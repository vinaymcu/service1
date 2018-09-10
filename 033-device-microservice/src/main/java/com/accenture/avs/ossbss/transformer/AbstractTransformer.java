/***************************************************************************
 * Copyright (C) Accenture
 *
 * The reproduction, transmission or use of this document or its contents is not permitted without
 * prior express written consent of Accenture. Offenders will be liable for damages. All rights,
 * including but not limited to rights created by patent grant or registration of a utility model or
 * design, are reserved.
 *
 * Accenture reserves the right to modify technical specifications and features.
 *
 * Technical specifications and features are binding only insofar as they are specifically and
 * expressly agreed upon in a written contract.
 *
 **************************************************************************/
package com.accenture.avs.ossbss.transformer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.accenture.avs.ossbss.exception.ErrorCode;
import com.accenture.avs.ossbss.exception.OSSBSSClientException;
import com.accenture.avs.ossbss.mapping.Mapping;
import com.accenture.avs.ossbss.mapping.PropertyMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

/**
 * The Class AbstractTransformer.
 *
 * @author <a href="Sumit.Sharma@rsystems.com">Sumit.Sharma</a>
 * @version Sep 16, 2016
 */
public abstract class AbstractTransformer implements Transformer {
  
  /** The root element to query. This starts all path expressions. */
  private static final String ROOT_ELEMENT = "$";
  
  /** The object mapper. */
  private final ObjectMapper objectMapper = new ObjectMapper();
  
  /** The configuration. */
  private final Configuration configuration = Configuration.defaultConfiguration();
  
  /**
   * Convert data type.
   *
   * @param object the object
   * @param from the from
   * @param to the to
   * @return the object
   * @throws NoSuchMethodException
   * @throws InvocationTargetException
   * @throws IllegalAccessException
   * @throws InstantiationException
   */
  private Object convertDataType(Object object, final String from, final String to) {
    if (StringUtils.isEmpty(from) || StringUtils.isEmpty(to)) {
      return object;
    }
    Object convertedObject;
    try {
      final Class<?> clazz = Class.forName(to);
      convertedObject = clazz.getConstructor(String.class).newInstance(object.toString());
    } catch (final RuntimeException | ReflectiveOperationException e) {
      throw new OSSBSSClientException(e);
    }
    return convertedObject;
  }
  
  /**
   * Prepare json array.
   *
   * @param document the document
   * @param mapping the mapping
   * @return the JSON array
   */
  private JSONArray prepareJsonArray(final Object document, final Mapping mapping) {
    int propertyIndex = 0;
    final JSONArray jsonArray = new JSONArray();
    for (final PropertyMapping property : mapping.getProperties()) {
      final Mapping nestedMapping = property.getMapping();
      if (nestedMapping != null) {
        // TODO
      }
      
      final String xpath = property.getOrigin().getPath();
      final List<String> list = JsonPath.read(document, xpath);
      for (int i = 0; i < list.size(); i++) {
        JSONObject jsonObject = new JSONObject();
        if (propertyIndex == 0) {
          jsonArray.put(jsonObject);
        } else {
          jsonObject = jsonArray.getJSONObject(i);
        }
        if (list.get(i) != null) {
          jsonObject.put(property.getDestination().getName(), list.get(i));
        } else {
          jsonObject.put(property.getDestination().getName(), JSONObject.NULL);
        }
      }
      propertyIndex++;
    }
    return jsonArray;
  }
  
  /**
   * Prepare json opbject.
   *
   * @param document the document
   * @param mapping the mapping
   * @return the JSON object
   */
  private JSONObject prepareJsonOpbject(final Object document, final Mapping mapping) {
    final JSONObject jsonObject = new JSONObject();
    for (final PropertyMapping property : mapping.getProperties()) {
      final Mapping nestedMapping = property.getMapping();
      if (nestedMapping != null) {
        if ("ARRAY".equalsIgnoreCase(nestedMapping.getType())) {
          jsonObject.put(property.getDestination().getName(),
              prepareJsonArray(document, nestedMapping));
        } else {
          jsonObject.put(property.getDestination().getName(),
              prepareJsonOpbject(document, nestedMapping));
        }
      } else {
        String xpath;
        if (StringUtils.isNoneBlank(property.getOrigin().getPath())) {
          xpath = property.getOrigin().getPath();
        } else {
          xpath = preparePath(property.getOrigin().getName());
        }
        final Object value = convertDataType(JsonPath.read(document, xpath),
            property.getOrigin().getType(), property.getDestination().getType());
        
        jsonObject.put(property.getDestination().getName(), value);
      }
    }
    return jsonObject;
  }
  
  /**
   * Prepare path.
   *
   * @param propertyHirarchy the property hirarchy
   * @return the string
   */
  private String preparePath(final String propertyHirarchy) {
    return ROOT_ELEMENT + "." + propertyHirarchy;
  }
  
  /**
   * To string.
   *
   * @param object the object
   * @param rootElement the root element
   * @return String
   */
  public abstract String toString(JSONArray object, String rootElement);
  
  /**
   * To string.
   *
   * @param object the object
   * @param rootElement the root element
   * @return String
   */
  public abstract String toString(JSONObject object, String rootElement);
  
  /*
   * (non-Javadoc)
   *
   * @see com.accenture.avs.ossbss.transformer.Transformer#transform(java.lang.String, java.lang.String,
   * java.lang.String)
   */
  @Override
  public String transform(final String requestJson, final String rootElement, final String mapper) {
    try {
      configuration.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
      
      final Object document = configuration.jsonProvider().parse(requestJson);
      final Mapping mapping = objectMapper.readValue(mapper, Mapping.class);
      if ("ARRAY".equalsIgnoreCase(mapping.getType())) {
        final JSONArray jsonArray = prepareJsonArray(document, mapping);
        return toString(jsonArray, rootElement);
      }
      final JSONObject jsonObject = prepareJsonOpbject(document, mapping);
      return toString(jsonObject, rootElement);
      
    } catch (IOException e) {
      throw new OSSBSSClientException(ErrorCode.TRANSFORMATION_ERROR, e);
    }
  }
  
}

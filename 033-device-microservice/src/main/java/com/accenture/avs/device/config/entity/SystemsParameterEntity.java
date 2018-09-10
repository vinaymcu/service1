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

package com.accenture.avs.device.config.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Entity class for reading sys_parameters table.
 * 
 * @author Singh.Saurabh
 */
public class SystemsParameterEntity implements RowMapper<SystemsParameterEntity> {

	/** paramId */
	private Integer paramId;

	/** paramGroup */
	private String paramGroup;

	/** paramName */
	private String paramName;

	/** paramType */
	private String paramType;

	/** paramValue */
	private String paramValue;

	/**
	 * Get param id
	 * 
	 * @return Integer Param id
	 */
	public Integer getParamId() {
		return paramId;
	}

	/**
	 * Set param id
	 * 
	 * @param paramId
	 */
	public void setParamId(Integer paramId) {
		this.paramId = paramId;
	}

	/**
	 * Get param group
	 * 
	 * @return String the param group
	 */
	public String getParamGroup() {
		return paramGroup;
	}

	/**
	 * Set param group
	 * 
	 * @param paramGroup
	 */
	public void setParamGroup(String paramGroup) {
		this.paramGroup = paramGroup;
	}

	/**
	 * Get param name
	 * 
	 * @return String the param name
	 */
	public String getParamName() {
		return paramName;
	}

	/**
	 * Set param name
	 * 
	 * @param paramName
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	/**
	 * Get param type
	 * 
	 * @return String the param type
	 */
	public String getParamType() {
		return paramType;
	}

	/**
	 * Set param type
	 * 
	 * @param paramType
	 */
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	/**
	 * Get param value
	 * 
	 * @return String the param value
	 */
	public String getParamValue() {
		return paramValue;
	}

	/**
	 * Set param value
	 * 
	 * @param paramValue
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paramName == null) ? 0 : paramName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (getClass() != obj.getClass()) {
			return false;
		}

		SystemsParameterEntity other = (SystemsParameterEntity) obj;
		if (paramName == null) {
			if (other.paramName != null)
				return false;
		} else if (!paramName.equals(other.paramName))
			return false;
		return true;
	}

	/**
	 * Get SystemParameter entity from result set
	 * 
	 * @param resultset
	 * @param row
	 *            number
	 * 
	 * @return SystemsParameterEntity
	 * @throws SQLException
	 */
	@Override
	public SystemsParameterEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		SystemsParameterEntity entity = new SystemsParameterEntity();
		entity.setParamGroup(rs.getString("param_group"));
		entity.setParamId(rs.getInt("param_id"));
		entity.setParamName(rs.getString("param_name"));
		entity.setParamType(rs.getString("param_type"));
		entity.setParamValue(rs.getString("param_value"));
		return entity;
	}

}

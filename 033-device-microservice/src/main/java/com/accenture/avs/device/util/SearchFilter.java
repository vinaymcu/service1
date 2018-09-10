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
package com.accenture.avs.device.util;

import org.apache.commons.lang3.StringUtils;

import com.accenture.avs.device.enums.SearchOperator;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.exception.DeviceManagerException;

/**
 * The Class SearchFilter.
 */
public class SearchFilter {

	/** The search by. */
	private String searchBy;

	/** The search value. */
	private String searchValue;

	/** The search operation. */
	private SearchOperator searchOperation;

	/** The sort by. */
	private String sortBy;

	/** The start index. */
	private Integer startIndex;

	/** The page size. */
	private Integer pageSize;

	/** The mapper. */
	private SearchCriteriaMapper mapper;

	/** LIKESTR */
	private static final String LIKESTR = "like";

	/** PERCENTAGESTR */
	private static final String PERCENTAGESTR = "%";

	/** SINGLEQUOTESSTR */
	private static final String SINGLEQUOTESSTR = "'";

	/** DOTSTR */
	private static final String DOTSTR = ".";

	/** SPACESTR */
	private static final String SPACESTR = " ";

	/**
	 * Builds the compelete criteria.
	 *
	 * @return the string
	 */
	public String buildCompeleteCriteria() {
		return buildCompeleteCriteria(null);
	}

	/**
	 * Builds the compelete criteria.
	 *
	 * @param alias
	 *            the alias
	 * @return the string
	 */
	public String buildCompeleteCriteria(final String alias) {
		final StringBuilder criteriaBuilder = new StringBuilder();
		if (searchOperation == null) {
			searchOperation = SearchOperator.EQUALS;
		}
		criteriaBuilder.append(" WHERE ");
		if (StringUtils.isNotBlank(alias)) {
			criteriaBuilder.append(alias);
			criteriaBuilder.append(DOTSTR);
		}
		criteriaBuilder.append(getSearchBy());
		appendSearchOperation(criteriaBuilder);
		appendSortBy(alias, criteriaBuilder);
		return criteriaBuilder.toString();
	}

	/**
	 * @param alias
	 * @param criteriaBuilder
	 */
	private void appendSortBy(final String alias, final StringBuilder criteriaBuilder) {
		/*if (StringUtils.isEmpty(this.sortBy)) {
			this.sortBy = "deviceId";
		}*/
		criteriaBuilder.append(" ORDER BY ");
		if (StringUtils.isNotBlank(alias)) {
			criteriaBuilder.append(alias);
			criteriaBuilder.append(DOTSTR);
		}
		criteriaBuilder.append(getSortBy());
	}

	/**
	 * @param criteriaBuilder
	 */
	private void appendSearchOperation(final StringBuilder criteriaBuilder) {
		switch (searchOperation) {
		case CONTAINS:
			/** like '%searchValue%' */
			criteriaBuilder.append(SPACESTR).append(LIKESTR).append(SPACESTR).append(SINGLEQUOTESSTR)
					.append(PERCENTAGESTR).append(searchValue).append(PERCENTAGESTR).append(SINGLEQUOTESSTR);
			break;
		case BEGINSWITH:
			/** like 'searchValue%' */
			criteriaBuilder.append(SPACESTR).append(LIKESTR).append(SPACESTR).append(SINGLEQUOTESSTR)
					.append(searchValue).append(PERCENTAGESTR).append(SINGLEQUOTESSTR);
			break;
		case ENDSWITH:
			/** like '%searchValue'*/
			criteriaBuilder.append(SPACESTR).append(LIKESTR).append(SPACESTR).append(SINGLEQUOTESSTR)
					.append(PERCENTAGESTR).append(searchValue).append(SINGLEQUOTESSTR);
			break;
		case EQUALS:
		default:
			criteriaBuilder.append(" =:param ");
		}
	}

	/**
	 * Gets the mapper.
	 *
	 * @return the mapper
	 */
	public SearchCriteriaMapper getMapper() {
		if (mapper == null) {
			throw new IllegalStateException("SearchCriteriaMapper can not be null.");
		}
		return mapper;
	}

	/**
	 * Gets the page size.
	 *
	 * @return the page size
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * Gets the search by.
	 *
	 * @return the search by
	 */
	public String getSearchBy() {

		return getMapper().searchByMapProperty(searchBy);
	}

	/**
	 * Gets the search operation.
	 *
	 * @return the search operation
	 */
	public SearchOperator getSearchOperation() {
		if (this.searchOperation == null) {
			return SearchOperator.EQUALS;
		}

		return searchOperation;
	}

	/**
	 * Gets the search value.
	 *
	 * @return the search value
	 */
	public String getSearchValue() {		
		return searchValue;
	}

	/**
	 * Gets the sort by.
	 *
	 * @return the sort by
	 */
	public String getSortBy() {
		return getMapper().sortMapProperty(sortBy);
	}

	/**
	 * Gets the start index.
	 *
	 * @return the start index
	 */
	public Integer getStartIndex() {
		return startIndex;
	}

	/**
	 * Sets the mapper.
	 *
	 * @param mapper
	 *            the new mapper
	 */
	public void setMapper(final SearchCriteriaMapper mapper) {
		this.mapper = mapper;
	}

	/**
	 * Sets the page size.
	 *
	 * @param pageSize
	 *            the new page size
	 */
	public void setPageSize(final Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Sets the search by.
	 *
	 * @param searchBy
	 *            the new search by
	 */
	public void setSearchBy(final String searchBy) {
		this.searchBy = searchBy;
	}

	/**
	 * Sets the search operation.
	 *
	 * @param searchOperation
	 *            the new search operation
	 */
	public void setSearchOperation(final SearchOperator searchOperation) {
		this.searchOperation = searchOperation;
	}

	/**
	 * Sets the search value.
	 *
	 * @param searchValue
	 *            the new search value
	 */
	public void setSearchValue(final String searchValue) {
		this.searchValue = searchValue;
	}

	/**
	 * Sets the sort by.
	 *
	 * @param sortBy
	 *            the new sort by
	 */
	public void setSortBy(final String sortBy) {
		this.sortBy = sortBy;
	}

	/**
	 * Sets the start index.
	 *
	 * @param startIndex
	 *            the new start index
	 */
	public void setStartIndex(final Integer startIndex) {
		this.startIndex = startIndex;
	}

}

package io.github.oliviercailloux.twod_library.model;

import com.google.common.base.MoreObjects;

public class PublicationRange {

	private Integer minRange;
	private Integer maxRange;

	public Integer getMinRange() {
		return minRange;
	}

	public void setMinRange(Integer minRange) {
		this.minRange = minRange;
	}

	public Integer getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(Integer maxRange) {
		this.maxRange = maxRange;
	}

	private PublicationRange(Integer minRange, Integer maxRange) {
		this.minRange = minRange;
		this.maxRange = maxRange;

	}

	public static PublicationRange createPublicationRange(Integer minRange, Integer maxRange) {
		return new PublicationRange(minRange, maxRange);
	}

	/**
	 * 
	 * @param year is the date to compare
	 * @return true if year is between interval of min and max Range attributes
	 */
	public boolean checkRange(int year) {
		if (getMinRange() == null && getMaxRange() == null)
			return false;
		else if (getMinRange() == null)
			return getMaxRange() >= year;
		else if (getMaxRange() == null)
			return getMinRange() <= year;
		else
			return getMinRange() <= year && year <= getMaxRange();
	}

	/**
	 * using to represent the object PublicationRange
	 */
	public String toString() {
		return MoreObjects.toStringHelper(this).add("minRange", getMinRange()).add("maxRange", getMaxRange())
				.toString();
	}

}

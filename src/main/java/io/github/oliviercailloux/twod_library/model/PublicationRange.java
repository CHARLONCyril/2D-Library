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

	public PublicationRange(Integer minRange, Integer maxRange) {
		this.minRange = minRange;
		this.maxRange = maxRange;

	}

	public String toString() {
		return MoreObjects.toStringHelper(this).add("minRange", getMinRange()).add("maxRange", getMaxRange())
				.toString();
	}

}

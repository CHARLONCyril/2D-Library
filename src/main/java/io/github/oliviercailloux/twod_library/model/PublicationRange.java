package io.github.oliviercailloux.twod_library.model;

public class PublicationRange {
	
	private int minRange;
	private int maxRange;
	
	public int getMinRange() {
		return minRange;
	}

	public void setMinRange(int minRange) {
		this.minRange = minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}

	
	public PublicationRange(int minRange, int maxRange) {
		this.minRange=minRange;
		this.maxRange=maxRange;
	
	}

}

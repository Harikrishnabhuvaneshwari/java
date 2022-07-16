package org.learn.enums;

public enum DaysOfWeek {
	SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);
	final int order;

	private DaysOfWeek(int order) {
		this.order = order;
	}
}

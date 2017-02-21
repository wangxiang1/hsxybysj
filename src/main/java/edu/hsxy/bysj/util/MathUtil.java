package edu.hsxy.bysj.util;

public class MathUtil {

	public static final double format(int num, double value) {
		String val = String.format("%." + num + "f", value);
		return Double.parseDouble(val);
	}
}

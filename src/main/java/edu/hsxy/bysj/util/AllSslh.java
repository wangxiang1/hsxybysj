package edu.hsxy.bysj.util;

import java.util.ArrayList;
import java.util.List;

public class AllSslh {

	public static List<String> getSslhs() {
		List<String> sslhs = new ArrayList<String>();
		for (int i = 0; i < 13; i++) {
			sslhs.add(String.valueOf(i + 1));
		}
		return sslhs;
	}
}

package net.wyd.nettalk.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Utilities {
	private static final String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static String genString(int size) {
		size = (size < 3)?3:((size > 100)?100: size);
		Random random = new Random();
		int randomsize = random.nextInt(size - 3) + 3;
		StringBuilder resultBuilder = new StringBuilder();
		for(int i = 0; i < randomsize; i++) {
			int index = random.nextInt(alpha.length());
			resultBuilder.append(alpha.charAt(index));
		}
		return resultBuilder.toString();
	}
	public static String formatTime(long time) {
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm");
		return sdf.format(date);
	}
}

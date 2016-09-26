package net.wyd.nettalk;

import java.util.ArrayList;

import android.app.Activity;

public class ActivityManager {
	private static ArrayList<Activity> activities = new ArrayList<Activity>();
	
	public static void addActivity(Activity activity) {
		activities.add(activity);
	}
	
	public static void removeActivity(Activity activity) {
		activities.remove(activity);
	}
}

package net.wyd.nettalk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import net.wyd.nettalk.model.*;

import java.util.*;

public class RecentListAdapter extends ArrayAdapter<Person> {
	private int resourceID;
	
	public RecentListAdapter(Context context, int textViewResourceID, List<Person> objects) {
		super(context, textViewResourceID, objects);
		resourceID = textViewResourceID;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		Person person = getItem(position);
		if(convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceID, null);
		}
		else {
			view = convertView;
		}
		ImageView imageView = (ImageView)view.findViewById(R.id.recentlist_image);
		TextView name = (TextView)view.findViewById(R.id.recentlist_name);
		TextView record = (TextView)view.findViewById(R.id.recentlist_record);
		imageView.setImageResource(person.getImageID());
		name.setText(person.getName());
		Message message = person.getLastRecord();
		if(message != null)
			record.setText(message.getMsg());
		return view;
	}
}

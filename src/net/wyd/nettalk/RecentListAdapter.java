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
		ViewHolder viewHolder = new ViewHolder();
		Person person = getItem(position);
		if(convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceID, null);
			viewHolder.icon = (ImageView)view.findViewById(R.id.recentlist_image);
			viewHolder.name = (TextView)view.findViewById(R.id.recentlist_name);
			viewHolder.record = (TextView)view.findViewById(R.id.recentlist_record);
			view.setTag(viewHolder);
		}
		else {
			view = convertView;
			viewHolder = (ViewHolder)view.getTag();
		}
		viewHolder.icon.setImageResource(person.getImageID());
		viewHolder.name.setText(person.getName());
		String message = person.getLastMsg();
		viewHolder.record.setText(message);
		return view;
	}
	class ViewHolder {
		public ImageView icon;
		public TextView name;
		public TextView record;
		public TextView time;
	}
}

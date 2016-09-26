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

public class RecentListAdapter extends ArrayAdapter<Session> {
	private int resourceID;
	
	public RecentListAdapter(Context context, int textViewResourceID, List<Session> objects) {
		super(context, textViewResourceID, objects);
		resourceID = textViewResourceID;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		ViewHolder viewHolder = new ViewHolder();
		Session session = getItem(position);
		if(convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceID, parent);
			viewHolder.icon = (ImageView)view.findViewById(R.id.recentlist_image);
			viewHolder.name = (TextView)view.findViewById(R.id.recentlist_name);
			viewHolder.record = (TextView)view.findViewById(R.id.recentlist_record);
			viewHolder.time = (TextView)view.findViewById(R.id.recentlist_time);
			view.setTag(viewHolder);
		}
		else {
			view = convertView;
			viewHolder = (ViewHolder)view.getTag();
		}
		viewHolder.icon.setImageResource(session.getImageID());
		viewHolder.name.setText(session.getName());
		Message message = session.getLastMsg();
		viewHolder.record.setText(message.getMsg());
		viewHolder.time.setText(message.getTime());
		return view;
	}
	class ViewHolder {
		public ImageView icon;
		public TextView name;
		public TextView record;
		public TextView time;
	}
}

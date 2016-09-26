package net.wyd.nettalk;

import net.wyd.nettalk.model.Message;
import net.wyd.nettalk.model.Person;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.*;

public class TalkAdpater extends ArrayAdapter<Message> {
	private int resourceID;
	public TalkAdpater(Context context, int textViewResourceID, List<Message> objects) {
		super(context, textViewResourceID, objects);
		resourceID = textViewResourceID;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Message msg = getItem(position);
		View view;
		ViewHolder viewHolder;
		if(convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceID, null);
			viewHolder = new ViewHolder();
			viewHolder.leftIcon = (ImageView)view.findViewById(R.id.icon_left);
			viewHolder.rightIcon = (ImageView)view.findViewById(R.id.icon_right);
			viewHolder.leftLayout = (LinearLayout)view.findViewById(R.id.layout_left);
			viewHolder.rightLayout = (LinearLayout)view.findViewById(R.id.layout_right);
			viewHolder.time = (TextView)view.findViewById(R.id.time);
			viewHolder.leftMsg = (TextView)view.findViewById(R.id.msg_left);
			viewHolder.rightMsg = (TextView)view.findViewById(R.id.msg_right);
			view.setTag(viewHolder);
		}
		else {
			view = convertView;
			viewHolder = (ViewHolder)view.getTag();
		}
		viewHolder.time.setText(msg.getTime());
		if(msg.getType() == Message.TYPE_RECEIVED) {
			viewHolder.leftLayout.setVisibility(View.VISIBLE);
			viewHolder.rightLayout.setVisibility(View.GONE);
			viewHolder.leftIcon.setImageResource(msg.getSender().getImageID());
			viewHolder.leftMsg.setText(msg.getMsg());
		}
		else if(msg.getType() == Message.TYPE_SENT) {
			viewHolder.leftLayout.setVisibility(View.GONE);
			viewHolder.rightLayout.setVisibility(View.VISIBLE);
			viewHolder.rightIcon.setImageResource(msg.getSender().getImageID());
			viewHolder.rightMsg.setText(msg.getMsg());
		}
		return view;
	}
	
	class ViewHolder {
		public TextView time;
		public TextView leftMsg;
		public TextView rightMsg;
		public ImageView leftIcon;
		public ImageView rightIcon;
		public LinearLayout leftLayout;
		public LinearLayout rightLayout;
	}
}

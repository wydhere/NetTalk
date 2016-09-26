package net.wyd.nettalk;

import java.util.List;

import net.wyd.nettalk.model.Message;
import net.wyd.nettalk.model.PersonManager;
import net.wyd.nettalk.model.Session;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecentListRVAdapter extends Adapter<RecentListRVAdapter.ViewHolder> {
	
	public static class ViewHolder extends RecyclerView.ViewHolder {
		public View view;
		public ImageView icon;
		public TextView name;
		public TextView record;
		public TextView time;
		public ViewHolder(View view) {
			super(view);
			this.icon = (ImageView)view.findViewById(R.id.recentlist_image);
			this.name = (TextView)view.findViewById(R.id.recentlist_name);
			this.record = (TextView)view.findViewById(R.id.recentlist_record);
			this.time = (TextView)view.findViewById(R.id.recentlist_time);
		}
	}

	private Context context;
	private List<Session> sessions;
	
	public RecentListRVAdapter(Context context, List<Session> sessions) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.sessions = sessions;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return sessions.size();
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {
		// TODO Auto-generated method stub
		Session session = sessions.get(position);
		viewHolder.icon.setImageResource(session.getImageID());
		viewHolder.name.setText(session.getName());
		Message message = session.getLastMsg();
		viewHolder.record.setText(message.getMsg());
		viewHolder.time.setText(message.getTime());
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// TODO Auto-generated method stub
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_list_content, parent, false);
		final ViewHolder viewHolder = new ViewHolder(view);
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				PersonManager.getInstance().setCurrentSession(sessions.get(viewHolder.getAdapterPosition()));
				Intent intent = new Intent(context, TalkActivity.class);
				context.startActivity(intent);
			}
		});
		return viewHolder;
	}

}

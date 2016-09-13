package net.wyd.nettalk;

import net.wyd.nettalk.model.PersonManager;
import android.os.Bundle;
import android.widget.ListView;

public class RecentListActivity extends BaseActivity {
	private ListView recentListView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recent_list);
		recentListView = (ListView) findViewById(R.id.recentlist);
		PersonManager personManager = PersonManager.getInstance();
		RecentListAdapter recentListAdapter = new RecentListAdapter(RecentListActivity.this, R.layout.recent_list_content, personManager.getRecentList());
		recentListView.setAdapter(recentListAdapter);
	}
}

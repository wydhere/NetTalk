package net.wyd.nettalk;

import net.wyd.nettalk.model.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class RecentListActivity extends BaseActivity {
	private ListView recentListView;
	private PersonManager personManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recent_list_fragment);
		recentListView = (ListView) findViewById(R.id.recentlist);
		personManager = PersonManager.getInstance();
		RecentListAdapter recentListAdapter = new RecentListAdapter(RecentListActivity.this, R.layout.recent_list_content, personManager.getSessionList());
		recentListView.setAdapter(recentListAdapter);
		recentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int posision, long id) {
				personManager.setCurrentSession(personManager.getSessionList().get(posision));
				Intent intent = new Intent(RecentListActivity.this, TalkActivity.class);
				startActivity(intent);
			}
		});
	}
}

package net.wyd.nettalk;

import net.wyd.nettalk.model.PersonManager;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class RecentListFragment extends Fragment {
	private ListView recentListView;
	private PersonManager personManager;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.recent_list_fragment, null);
		recentListView = (ListView) view.findViewById(R.id.recentlist);
		personManager = PersonManager.getInstance();
		RecentListAdapter recentListAdapter = new RecentListAdapter(getActivity(), R.layout.recent_list_content, personManager.getRecentList());
		recentListView.setAdapter(recentListAdapter);
		recentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int posision, long id) {
				personManager.setCurrentContact(personManager.getRecentList().get(posision));
				Intent intent = new Intent(getActivity(), TalkActivity.class);
				startActivity(intent);
			}
		});
		return view;
	}
}

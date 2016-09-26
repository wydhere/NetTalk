package net.wyd.nettalk;

import net.wyd.nettalk.model.PersonManager;
import net.wyd.nettalk.model.Session;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class RecentListFragment extends Fragment {
	private RecyclerView recyclerView;
	private PersonManager personManager;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.recentlist_fragment, null);
		recyclerView = (RecyclerView) view.findViewById(R.id.recentlist_rv);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		personManager = PersonManager.getInstance();
		RecentListRVAdapter adapter = new RecentListRVAdapter(getActivity(), personManager.getSessionList());
		recyclerView.setAdapter(adapter);
		/*RecentListAdapter recentListAdapter = new RecentListAdapter(getActivity(), R.layout.recent_list_content, personManager.getSessionList());
		recentListView.setAdapter(recentListAdapter);
		recentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int posision, long id) {
				Session session = personManager.getSessionList().get(posision);
				personManager.setCurrentSession(session);
				Intent intent = new Intent(getActivity(), TalkActivity.class);
				startActivity(intent);
			}
		});*/
		return view;
	}
}

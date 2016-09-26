package net.wyd.nettalk;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v7.widget.Toolbar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;

public class MainActivity extends BaseActivity {
	private Fragment[] fragments = {null, null};
	private final String[] tags = {"RecentListFragment", "ContactsFragment" };
	private TabLayout tabLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		tabLayout = (TabLayout)findViewById(R.id.tablayout);
		int index = 0;
		if(savedInstanceState != null)
			index = savedInstanceState.getInt("tabSelectedIndex", 0);
		setSelectedFragment(index);
		tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			
			@Override
			public void onTabUnselected(Tab arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onTabSelected(Tab tab) {
				// TODO Auto-generated method stub
				int position = tab.getPosition();
				setSelectedFragment(position);
				Log.d("TabLayout", "select" + String.valueOf(position));
			}
			
			@Override
			public void onTabReselected(Tab arg0) {
				// TODO Auto-generated method stub
				Log.d("TabLayout", "reselect" + String.valueOf(arg0.getPosition()));
			}
		});
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putInt("tabSelectedIndex", tabLayout.getSelectedTabPosition());
	}
	
	private void setSelectedFragment(int position) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		//Retrieve fragment,if null,create and add it,otherwise show it directly.
		fragments[position] = fm.findFragmentByTag(tags[position]);
		if (fragments[position] == null) {
			switch (position) {
			case 0:
				fragments[position] = new RecentListFragment();
				break;
			case 1:
				fragments[position] = new ContactsFragment();
				break;

			default:
				break;
			}
			ft.add(R.id.tab_fragment, fragments[position], tags[position]);
		}
		else {
			ft.show(fragments[position]);
		}
		//Hide other fragments.
		for (int i = 0; i < tags.length; i++) {
			if(i != position && fragments[i] != null)
				ft.hide(fragments[i]);
		}
		ft.commit();
	}
}

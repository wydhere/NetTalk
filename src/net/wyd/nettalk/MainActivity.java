package net.wyd.nettalk;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;

public class MainActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
		tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_recent)), true);
		tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_contacts)));
		tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			
			@Override
			public void onTabUnselected(Tab arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onTabSelected(Tab arg0) {
				// TODO Auto-generated method stub
				Fragment fragment = null;
				switch (arg0.getPosition()) {
				case 0:
					fragment = new RecentListFragment();
					break;
				case 1:
					fragment = new ContactsFragment();
					break;

				default:
					break;
				}
				FragmentManager fm = getFragmentManager();
				FragmentTransaction ft = fm.beginTransaction();
				ft.replace(R.id.tab_fragment, fragment);
				ft.commit();
				Log.d("TabLayout", "select" + String.valueOf(arg0.getPosition()));
			}
			
			@Override
			public void onTabReselected(Tab arg0) {
				// TODO Auto-generated method stub
				Log.d("TabLayout", "reselect" + String.valueOf(arg0.getPosition()));
			}
		});
	}
}

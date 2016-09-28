package net.wyd.nettalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;

import net.wyd.nettalk.model.Person;

public class MainActivity extends BaseActivity {
	private Fragment[] fragments = {null, null};
	private final String[] tags = {"RecentListFragment", "ContactsFragment" };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
		toolbar.setTitle(Person.ME.getName());
		setSupportActionBar(toolbar);
		toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
		FloatingActionButton fbutton = (FloatingActionButton)findViewById(R.id.float_button);
		fbutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
				startActivity(intent);
			}
		});
		setSelectedFragment(0);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
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

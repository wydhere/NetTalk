package net.wyd.nettalk;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

/**
 * Created by wyd on 2016/9/27.
 */

public class ContactsActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_fragment);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

package net.wyd.nettalk;

import java.util.List;

import net.wyd.nettalk.model.Message;
import net.wyd.nettalk.model.PersonManager;
import net.wyd.nettalk.model.Session;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class TalkActivity extends BaseActivity {
	private EditText input;
	private PersonManager personManager;
	private TalkAdpater talkAdpater;
	private ListView msgListView;
	private Button send;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.talk_list);
		personManager = PersonManager.getInstance();
		final Session session = personManager.getCurrentSession();
		talkAdpater = new TalkAdpater(this, R.layout.talk_list_content, session.getMessages());
		msgListView = (ListView)findViewById(R.id.msg_list);
		msgListView.setSelection(session.getMessages().size());
		msgListView.setAdapter(talkAdpater);
		send = (Button)findViewById(R.id.send_button);
		input = (EditText)findViewById(R.id.input_edit);
		send.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String inputString = input.getText().toString();
				input.setText("");
				if(!TextUtils.isEmpty(inputString)) {
					Message msg = new Message(inputString, Message.TYPE_SENT);
					session.addMessage(msg);
					talkAdpater.notifyDataSetChanged();
					msgListView.setSelection(session.getMessages().size());
				}
			}
		});
		input.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				if(s.length() > 0) {
					send.setEnabled(true);
				}
				else
					send.setEnabled(false);
			}
		});
	}
}

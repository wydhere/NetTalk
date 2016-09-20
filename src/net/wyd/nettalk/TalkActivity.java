package net.wyd.nettalk;

import net.wyd.nettalk.model.Message;
import net.wyd.nettalk.model.Person;
import net.wyd.nettalk.model.PersonManager;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class TalkActivity extends BaseActivity {
	private EditText input;
	private PersonManager personManager;
	private TalkAdpater talkAdpater;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.talk_list);
		personManager = PersonManager.getInstance();
		Person currentPerson = personManager.getCurrentContact();
		talkAdpater = new TalkAdpater(this, R.layout.talk_list_content, currentPerson.getRecord());
		ListView msgListView = (ListView)findViewById(R.id.msg_list);
		msgListView.setSelection(currentPerson.getRecord().size());
		msgListView.setAdapter(talkAdpater);
		Button send = (Button)findViewById(R.id.send_button);
		input = (EditText)findViewById(R.id.input_edit);
		send.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String inputString = input.getText().toString();
				input.setText("");
				if(inputString != null) {
					Message msg = new Message(inputString, Message.TYPE_SENT, personManager.getMe());
					personManager.getCurrentContact().addRecord(msg);
					talkAdpater.notifyDataSetChanged();
				}
			}
		});
	}
}

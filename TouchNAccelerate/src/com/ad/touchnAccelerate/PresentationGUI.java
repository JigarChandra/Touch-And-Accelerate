package com.ad.touchnAccelerate;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.NavUtils;

public class PresentationGUI extends Activity implements View.OnClickListener {

	private Button esc;
	private Button fs;
	private Button prev;
	private Button next;
	private EditText pt;
	private EditText pt2;
	private Button path;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_presentation_gui);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		esc = (Button) findViewById(R.id.ppt1);
		fs = (Button) findViewById(R.id.ppt2);
		prev = (Button) findViewById(R.id.ppt3);
		next = (Button) findViewById(R.id.ppt4);
		// pt=(EditText)findViewById(R.id.presentationtext);
		pt2 = (EditText) findViewById(R.id.presentationpath);

		path = (Button) findViewById(R.id.pptpath);
		esc.setOnClickListener(this);
		fs.setOnClickListener(this);
		prev.setOnClickListener(this);
		next.setOnClickListener(this);
		path.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String code = "";
		switch (v.getId()) {
		case R.id.ppt1:
			code = getString(R.string.presentation_ESC);
			break;
		case R.id.ppt2:
			code = getString(R.string.presentation_FULLSCR);
			break;
		case R.id.ppt3:
			code = getString(R.string.presentation_PREV);
			break;
		case R.id.ppt4:
			code = getString(R.string.presentation_NEXT);
			break;
		case R.id.pptpath:
			String p = pt2.getText().toString();
			code = "#p" + p;
			break;

		}
		// pt.setText(code);
		new SocketConnectivity(this).execute(code + "\n");

	}

}

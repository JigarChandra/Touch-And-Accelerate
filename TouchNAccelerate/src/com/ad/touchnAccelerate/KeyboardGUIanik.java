package com.ad.touchnAccelerate;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.Menu;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;

public class KeyboardGUIanik extends Activity implements OnClickListener {
	Button smallq, smallw, smalle, smallr, smallt, smally, smallu, smalli,
			smallo, smallp, smalla, smalls, smalld, smallf, smallg, smallh,
			smallj, smallk, smalll, smallz, smallx, smallc, smallv, smallb,
			smalln, smallm;

	String kcommand;

	private EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_keyboardsmall);

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		initialize();

		smallq.setOnClickListener(this);
		smallw.setOnClickListener(this);
		smalle.setOnClickListener(this);
		smallr.setOnClickListener(this);
		smallt.setOnClickListener(this);
		smally.setOnClickListener(this);
		smallu.setOnClickListener(this);
		smalli.setOnClickListener(this);
		smallo.setOnClickListener(this);
		smallp.setOnClickListener(this);
		smalla.setOnClickListener(this);
		smalls.setOnClickListener(this);
		smalld.setOnClickListener(this);
		smallf.setOnClickListener(this);
		smallg.setOnClickListener(this);
		smallh.setOnClickListener(this);
		smallj.setOnClickListener(this);
		smallk.setOnClickListener(this);
		smalll.setOnClickListener(this);
		smallz.setOnClickListener(this);
		smallx.setOnClickListener(this);
		smallc.setOnClickListener(this);
		smallv.setOnClickListener(this);
		smallb.setOnClickListener(this);
		smallm.setOnClickListener(this);
		smalln.setOnClickListener(this);

	}

	private void initialize() {
		// TODO Auto-generated method stub
		smallq = (Button) findViewById(R.id.smallq);
		smallw = (Button) findViewById(R.id.smallw);
		smalle = (Button) findViewById(R.id.smalle);
		smallr = (Button) findViewById(R.id.smallr);
		smallt = (Button) findViewById(R.id.smallt);
		smally = (Button) findViewById(R.id.smally);
		smallu = (Button) findViewById(R.id.smallu);
		smalli = (Button) findViewById(R.id.smalli);
		smallo = (Button) findViewById(R.id.smallo);
		smallp = (Button) findViewById(R.id.smallp);
		smalla = (Button) findViewById(R.id.smalla);
		smalls = (Button) findViewById(R.id.smalls);
		smalld = (Button) findViewById(R.id.smalld);
		smallf = (Button) findViewById(R.id.smallf);
		smallg = (Button) findViewById(R.id.smallg);
		smallh = (Button) findViewById(R.id.smallh);
		smallj = (Button) findViewById(R.id.smallj);
		smallk = (Button) findViewById(R.id.smallk);
		smalll = (Button) findViewById(R.id.smalll);
		smallz = (Button) findViewById(R.id.smallz);
		smallx = (Button) findViewById(R.id.smallx);
		smallc = (Button) findViewById(R.id.smallc);
		smallv = (Button) findViewById(R.id.smallv);
		smallb = (Button) findViewById(R.id.smallb);
		smalln = (Button) findViewById(R.id.smalln);
		smallm = (Button) findViewById(R.id.smallm);

		et = (EditText) findViewById(R.id.editText1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_keyboard_gui, menu);
		return true;
	}

	@Override
	public void onClick(View bPress) {
		// TODO Auto-generated method stub
		switch (bPress.getId()) {
		case R.id.smallq:
			kcommand = "#kq";
			break;
		case R.id.smallw:
			kcommand = "#kw";
			break;
		case R.id.smalle:
			kcommand = "#ke";
			break;
		case R.id.smallr:
			kcommand = "#kr";
			break;
		case R.id.smallt:
			kcommand = "#kt";
			break;
		case R.id.smally:
			kcommand = "#ky";
			break;
		case R.id.smallu:
			kcommand = "#ku";
			break;
		case R.id.smalli:
			kcommand = "#ki";
			break;
		case R.id.smallo:
			kcommand = "#ko";
			break;
		case R.id.smallp:
			kcommand = "#kp";
			break;
		case R.id.smalla:
			kcommand = "#ka";
			break;
		case R.id.smalls:
			kcommand = "#ks";
			break;
		case R.id.smalld:
			kcommand = "#kd";
			break;
		case R.id.smallf:
			kcommand = "#kf";
			break;
		case R.id.smallg:
			kcommand = "#kg";
			break;
		case R.id.smallh:
			kcommand = "#kh";
			break;
		case R.id.smallj:
			kcommand = "#kj";
			break;
		case R.id.smallk:
			kcommand = "#kk";
			break;
		case R.id.smalll:
			kcommand = "#kl";
			break;
		case R.id.smallz:
			kcommand = "#kz";
			break;
		case R.id.smallx:
			kcommand = "#kx";
			break;
		case R.id.smallc:
			kcommand = "#kc";
			break;
		case R.id.smallv:
			kcommand = "#kv";
			break;
		case R.id.smallb:
			kcommand = "#kb";
			break;
		case R.id.smalln:
			kcommand = "#kn";
			break;
		case R.id.smallm:
			kcommand = "#km";

		}

		kcommand += "\n";
		et.setText(kcommand.substring(2));
		new SocketConnectivity(this).execute(kcommand);

	}

}

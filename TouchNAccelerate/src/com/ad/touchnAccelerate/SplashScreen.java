package com.ad.touchnAccelerate;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class SplashScreen extends Activity implements OnClickListener {

	private ImageView ImageView1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		ImageView1 = (ImageView) findViewById(R.id.imageView1);
		int secondsDelayed = 4;
		new Handler().postDelayed(new Runnable() {
			public void run() {
				startActivity(new Intent(SplashScreen.this, Login.class));
				finish();
			}
		}, secondsDelayed * 1000);

		ImageView1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int secondsDelayed = 0;
				new Handler().postDelayed(new Runnable() {
					public void run() {
						startActivity(new Intent(SplashScreen.this, Login.class));
						finish();
					}
				}, secondsDelayed * 1000);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_splash_screen, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

}

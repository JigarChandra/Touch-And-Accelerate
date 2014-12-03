package com.ad.touchnAccelerate;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	/*
	 * @SuppressLint("NewApi") public void createNotification(View view) { //
	 * Prepare intent which is triggered if the // notification is selected
	 * Intent intent = new Intent(this, MainTabs.class); PendingIntent pIntent =
	 * PendingIntent.getActivity(this, 0, intent, 0);
	 * 
	 * // Build notification // Actions are just fake Notification noti = new
	 * Notification.Builder(this) .setContentTitle("TNA")
	 * .setContentText("Started").setSmallIcon(R.drawable.ic_launcher)
	 * .setContentIntent(pIntent) .addAction(R.drawable.ic_launcher, "Call",
	 * pIntent) .addAction(R.drawable.ic_launcher, "More", pIntent)
	 * .addAction(R.drawable.ic_launcher, "And more", pIntent).build();
	 * NotificationManager notificationManager = (NotificationManager)
	 * getSystemService(NOTIFICATION_SERVICE); // Hide the notification after
	 * its selected noti.flags |= Notification.FLAG_AUTO_CANCEL;
	 * 
	 * notificationManager.notify(0, noti);
	 * 
	 * }
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void getMouseMode(View view) {
		// Do something in response to button
		Intent intent = new Intent(this, MouseGUI.class);
		startActivity(intent);

	}

	public void getKeyboardMode(View view) {
		// Do something in response to button

		Intent intent = new Intent(this, KeyboardGUI.class);

		startActivity(intent);

	}

	public void getPresentationMode(View view) {
		// Do something in response to button

		Intent intent = new Intent(this, PresentationGUI.class);
		startActivity(intent);

	}

	public void getAcceleroMode(View view) {

		Intent intent = new Intent(this, AcceleroGUI.class);

		startActivity(intent);

	}

	public void screenViewMode(View view) { // Do something in response to
											// button

		Intent intent = new Intent(this, ScreenshotViewer.class);

		startActivity(intent);
	}

}

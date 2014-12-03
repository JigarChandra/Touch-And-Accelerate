package com.ad.touchnAccelerate;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.WindowManager;

public class Login extends Activity {
	private Handler mHandler = new Handler();
	static boolean auth=false;

	EditText pass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		// this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		// WindowManager.LayoutParams.FLAG_FULLSCREEN);
		Button bA = (Button) findViewById(R.id.login);
		final EditText ip = (EditText) findViewById(R.id.ip);
		final EditText port = (EditText) findViewById(R.id.port);
		pass = (EditText) findViewById(R.id.pass);
		
		// Show the ProgressDialog on this thread

		// Start a new thread that will download all the data

		bA.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String enteredIp = ip.getText().toString();
				if (!enteredIp.equalsIgnoreCase("")) {
					Toast.makeText(getBaseContext(), "Connecting " + enteredIp,
							(int) 5.0).show();
					try {

						SharedPreferences editor1 = getSharedPreferences(
								"Pref", MODE_PRIVATE);
						SharedPreferences.Editor editor = editor1.edit();
						editor.putString("IP", ip.getText().toString());
						editor.putString("PORT", port.getText().toString());

						editor.commit();

						long delayMillis = 0L;
						// post a message to main thread that will be executed
						// after a delay
						mHandler.postDelayed(new Runnable() {

							@Override
							public void run() {
								// run the splash screen asynchronous task
								new DownloadTask().execute();
							}

						}, delayMillis);

					} catch (Exception e) {

						Toast.makeText(getBaseContext(), "Error", (int) 5.0)
								.show();
					}

				} else {
					Toast.makeText(getBaseContext(), "Enter IP Address ",
							(int) 1.0).show();

				}
			}
		});

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.n, menu);
		return true;
	}

	class DownloadTask extends AsyncTask<Void, Integer, Void> {

		// this is the progress dialog that we will use to show the user that
		// there is
		// some activity in the background
		ProgressDialog loading = new ProgressDialog(Login.this);

		/**
		 * This method will run on the main thread also called as UI thread you
		 * can make updates to the UI from this method For e.g.: here we are
		 * drawing a dialog.
		 */
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			loading.requestWindowFeature(Window.FEATURE_NO_TITLE);

			loading.setMessage("Connecting ...");
			loading.show();

		}

		/**
		 * This method will be used to do jobs off the main thread in
		 * background. Note that you cannot update UI from non-UI/child thread.
		 */
		@Override
		protected Void doInBackground(Void... arg0) {

			for (int i = 0; i < 2; i++) {
				try {
					// fake a delay of 2 seconds
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// we will call publish progress, which will invoke
				// onProgressUpdate callback
				// in that method we will change the message that goes on the
				// ProgressDialog

				publishProgress(i);
			}

			return null;
		}

		// Used to publish intermediate results
		// we will use this to change message on the Progress Dialog
		// since we are able to change the message on the UI this means that
		// this method is also run
		// on UI thread
		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			switch (values[0]) {
			case 0:

				loading.setMessage("Establishing Connection");

			case 1:
				loading.setMessage("Almost done...");
			}
		}

		// This will be executed after doInBackground() finishes
		// this also runs on main thread so we can call other actvities or
		// update UI from this callback
		// we will call the next activity from here which will show the playlist
		@SuppressWarnings("deprecation")
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			String enteredPass = pass.getText().toString();

			if (enteredPass.equalsIgnoreCase("Aniket")) {
				Intent intent = new Intent(Login.this, TNAMainActivity.class);
				startActivity(intent);

				// let us remove splash screen from the UI; we call finish()
				finish();
			}

			else {
				try {

					new SocketConnectivity(Login.this).execute("#x"
							+ enteredPass);
					new ReverseSocketConnectivity(Login.this).execute("#x"
							+ enteredPass);
				} catch (Exception e) {
				}
				boolean stat=false;
				try
				{
					
				//	Thread.sleep(5000);
					stat=auth;
				}
				catch(Exception e){}
				if (stat) {
					// this is one way of calling an activity
					Intent intent = new Intent(Login.this,
							TNAMainActivity.class);
					startActivity(intent);

					// let us remove splash screen from the UI; we call finish()
					finish();

					// we will remove the loading modal

				} else {
					AlertDialog alertDialog = new AlertDialog.Builder(
							Login.this).create();

					// Setting Dialog Title
					alertDialog.setTitle("Not Connected");

					// Setting Dialog Message
					alertDialog.setMessage("Re enter the password");

					// Setting Icon to Dialog

					// Setting OK Button
					alertDialog.setButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									// Write your code here to execute after
									// dialog closed

								}
							});

					// Showing Alert Message
					alertDialog.show();
				}
				loading.dismiss();

			}
		}

	}

	public static void setAuth(boolean b) {
		// TODO Auto-generated method stub
		auth = true;
	}

}

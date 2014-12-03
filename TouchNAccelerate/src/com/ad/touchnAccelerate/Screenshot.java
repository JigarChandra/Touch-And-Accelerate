package com.ad.touchnAccelerate;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;

class Screenshot extends AsyncTask<String, Integer, Bitmap> {

	private Context c;

	Screenshot(Context c) {
		this.c = c;
	}

	ImageView imageView;
	Bitmap bitmap;
	Socket socket = null;
	DataOutputStream dataOutputStream = null;
	DataInputStream dataInputStream = null;
	String Ip = "192.168.1.2";
	InetAddress serverAddr;

	@Override
	protected Bitmap doInBackground(String... params) {

		try {
			Log.d("TCP", "Screenshot: Connecting...");
			Log.d("TCP", "Screenshot: Receiving: " + params[0]);

			bitmap = BitmapFactory.decodeStream(socket.getInputStream());

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.d("Error", "" + e);
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (dataOutputStream != null) {
				try {
					dataOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (dataInputStream != null) {
				try {
					dataInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return bitmap;

	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		try {

			SharedPreferences prefs = c.getSharedPreferences("Pref",
					Context.MODE_PRIVATE);
			String restoredTextip = prefs.getString("IP", null);

			System.out.print(restoredTextip);

			String restoredTextport = prefs.getString("PORT", null);

			restoredTextport = Integer.toString((Integer
					.parseInt(restoredTextport) + 1));
			if (restoredTextip != null) {

				serverAddr = InetAddress.getByName(restoredTextip);
				socket = new Socket(serverAddr,
						Integer.parseInt(restoredTextport));

			} else {
				serverAddr = InetAddress.getByName("192.168.1.2");
				socket = new Socket(serverAddr, 4445);
			}

			// dataInputStream = new DataInputStream(socket.getInputStream());
			// dataOutputStream = new
			// DataOutputStream(socket.getOutputStream());
			// out = new PrintWriter( new BufferedWriter( new
			// OutputStreamWriter(socket.getOutputStream())),true);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

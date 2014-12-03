package com.ad.touchnAccelerate;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;

class SocketConnectivity extends AsyncTask<String, Integer, String> {
	String Ip;
	Context c;

	SocketConnectivity(Context c) {
		Ip = "192.168.1.2";
		this.c = c;
	}

	SocketConnectivity(String ip) {
		Ip = ip;
	}

	Socket socket;
	InetAddress serverAddr;
	PrintWriter out;

	@Override
	protected String doInBackground(String... params) {
		try {

			Log.d("TCP", "Client: Connecting...");
			Log.d("TCP", "Client: Sending: " + params[0]);
			out.write(params[0] + "\n");
			out.flush();

		} catch (Exception e) {
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return params[0];
	}

	@Override
	protected void onPreExecute() {

		super.onPreExecute();
		try {

			SharedPreferences prefs = c.getSharedPreferences("Pref",
					Context.MODE_PRIVATE);
			String restoredTextip = prefs.getString("IP", null);
			String restoredTextport = prefs.getString("PORT", null);
			if (restoredTextip != null) {

				serverAddr = InetAddress.getByName(restoredTextip);
				socket = new Socket(serverAddr,
						Integer.parseInt(restoredTextport));

			} else {
				serverAddr = InetAddress.getByName("192.168.1.2");
				socket = new Socket(serverAddr, 4444);
			}

			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream())), true);
		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}

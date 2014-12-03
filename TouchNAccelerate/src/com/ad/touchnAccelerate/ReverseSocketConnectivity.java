package com.ad.touchnAccelerate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
import android.widget.Toast;

class ReverseSocketConnectivity extends AsyncTask<String, Integer, String> {
	String Ip;
	Context c;

	ReverseSocketConnectivity(Context c) {
		Ip = "192.168.1.2";
		this.c = c;
	}

	ReverseSocketConnectivity(String ip) {
		Ip = ip;
	}

	Socket socket;
	InetAddress serverAddr;
	BufferedReader in = null;
	String inputfromServer;
	String inputpassword;

	@Override
	protected String doInBackground(String... params) {
		try {

			Log.d("TCP", "Reading from Server.");

			inputfromServer = in.readLine();
			
			if ("AUTH".equalsIgnoreCase(inputfromServer)) {
				Login.setAuth(true);
				//Toast.makeText(c, "Connected", (int) 5.0).show();
			} else
				Toast.makeText(c, "Not Connected", (int) 5.0).show();
			
			
			Log.d("BCP", inputfromServer);

			Toast.makeText(c, inputfromServer, (int) 2.0).show();
		} catch (Exception e) {
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return inputfromServer;
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);

		/*if ("AUTH".equalsIgnoreCase(inputfromServer)) {
			Login.setAuth(true);
			//Toast.makeText(c, "Connected", (int) 5.0).show();
		} else
			Toast.makeText(c, "Not Connected", (int) 5.0).show();*/

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
						(Integer.parseInt(restoredTextport) + 2));

			} else {
				serverAddr = InetAddress.getByName("192.168.1.2");
				socket = new Socket(serverAddr, 4446);
			}

			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}

package com.ad.touchnAccelerate;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AcceleroGUI extends Activity implements SensorEventListener,
		OnClickListener {

	private float mLastX, mLastY, mLastZ;
	private boolean mInitialized;
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private final float NOISE = (float) 2.0;
	private long lastUpdate;
	private float x;
	private float y;
	private float z;
	private String temp;
	private String code;
	private Button Bx;
	private Button By;
	private Button Ba;
	private Button Bb;
	private String lastcode;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_accelero_gui);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();   // disable the detection of everything
		StrictMode.setThreadPolicy(policy);
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mAccelerometer = mSensorManager
				.getDefaultSensor(Sensor.TYPE_ACCELEROMETER); // set to accelerometer
		mSensorManager.registerListener(this, mAccelerometer,
				SensorManager.SENSOR_DELAY_NORMAL); // rate of events (default) suitable for screen orientation changes
		lastUpdate = System.currentTimeMillis();

		initialize();

		Bx.setOnClickListener(this);
		By.setOnClickListener(this);
		Ba.setOnClickListener(this);
		Bb.setOnClickListener(this);

	}

	private void initialize() {
		// TODO Auto-generated method stub
		Bx = (Button) findViewById(R.id.accelerox); //to retrieve the widgets in that UI that you need to interact with programmatically.
		By = (Button) findViewById(R.id.acceleroy);
		Ba = (Button) findViewById(R.id.acceleroa);
		Bb = (Button) findViewById(R.id.accelerob);
		lastcode = getString(R.string.accelero_CENTER);
	}

	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(this, mAccelerometer,
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	protected void onPause()  //To avoid the unnecessary usage of battery
{
		super.onPause();
		mSensorManager.unregisterListener(this);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// can be safely ignored for this demo
	}

	public static double round(double value, int places) //Round a double to 2 decimal places
{
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		TextView tvX = (TextView) findViewById(R.id.x_axis);
		TextView tvY = (TextView) findViewById(R.id.y_axis);
		TextView tvZ = (TextView) findViewById(R.id.z_axis);
		TextView op = (TextView) findViewById(R.id.output);
		// ImageView iv = (ImageView)findViewById(R.id.image);

		{
			float[] values = event.values;
			// Movement
			x = values[0];
			y = values[1];
			z = values[2];
			/*
			 * float accelationSquareRoot = (x * x + y * y + z * z) /
			 * (SensorManager.AXIS_X * SensorManager.AXIS_X);
			 */

			// tvZ.setText("Shakes"+"X: "+x+"  Y: "+y+"  Z: "+z);
			temp = "CENTER";

			code = getString(R.string.accelero_CENTER);

			long actualTime = System.currentTimeMillis();
			if ((actualTime - lastUpdate) > 100) {
				if (round(x, 4) > 3.0000) // device is already tilted, tilting on right implies center going down
				{
					temp = "DOWN";
					code = getString(R.string.accelero_DOWN);

				} else if (round(x, 4) < -3.0000) {
					temp = "UP";
					code = getString(R.string.accelero_UP);
				} else if (round(y, 4) > 3.0) {
					temp = " RIGHT";
					code = getString(R.string.accelero_RIGHT);

				}

				else if (round(y, 4) < -3.0) {
					temp = "LEFT";
					code = getString(R.string.accelero_LEFT);
				} else {
					temp = "CENTER";
					code = getString(R.string.accelero_CENTER);
				}
			}

			op.setText(temp);
			if (!code.equalsIgnoreCase(getString(R.string.accelero_CENTER)))
				new SocketConnectivity(this).execute(code);
			// lastcode=code;
			/*
			 * shake detect // float speed = Math.abs(x+y+z - last_x - last_y -
			 * last_z) / diffTime * 10000;
			 * 
			 * // if (speed > SHAKE_THRESHOLD) { //Log.d("sensor",
			 * "shake detected w/ speed: " + speed); //Toast.makeText(this,
			 * "shake detected w/ speed: " + speed, Toast.LENGTH_SHORT).show();
			 * //} // last_x = x; // last_y = y; // last_z = z;
			 */

			float deltaX = Math.abs(mLastX - x);
			float deltaY = Math.abs(mLastY - y);
			float deltaZ = Math.abs(mLastZ - z);
			if (deltaX < NOISE)
				deltaX = (float) 0.0;
			if (deltaY < NOISE)
				deltaY = (float) 0.0;
			if (deltaZ < NOISE)
				deltaZ = (float) 0.0;
			mLastX = x;
			mLastY = y;
			mLastZ = z;
			tvX.setText(Float.toString(deltaX)); //display the change in variables
			tvY.setText(Float.toString(deltaY));
			tvZ.setText(Float.toString(deltaZ));
			/*
			 * iv.setVisibility(View.VISIBLE); if (deltaX > deltaY) {
			 * iv.setImageResource(R.drawable.horizontal); } else if (deltaY >
			 * deltaX) { iv.setImageResource(R.drawable.vertical); } else {
			 * iv.setVisibility(View.INVISIBLE); }
			 */
		}
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		String bcode = "";
		switch (arg0.getId()) {
		case R.id.accelerox:
			bcode = getString(R.string.accelero_X);
			break;
		case R.id.acceleroy:
			bcode = getString(R.string.accelero_Y);
			break;
		case R.id.acceleroa:
			bcode = getString(R.string.accelero_A);
			break;
		case R.id.accelerob:
			bcode = getString(R.string.accelero_B);
			break;

		}

		new SocketConnectivity(this).execute(bcode);

	}
}
package com.ad.touchnAccelerate;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.view.MotionEventCompat;
import android.text.method.Touch;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MouseGUI extends Activity implements View.OnDragListener,
		OnClickListener {
	TextView et;
	LinearLayout sparent;
	String temp;

	String mcode;
	// private static final int INVALID_POINTER_ID = -1;
	int tempx;
	int tempy;
	int mLastTouchX, mLastTouchY, mPosX, mPosY;

	Button leftClick, middleClick, rightClick;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mouse_gui);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		intialize();

	}

	public void intialize() {
		et = (TextView) findViewById(R.id.tview);
		leftClick = (Button) findViewById(R.id.mouseleft);
		middleClick = (Button) findViewById(R.id.mousemiddle);
		rightClick = (Button) findViewById(R.id.mouseright);

		leftClick.setOnClickListener(this);
		middleClick.setOnClickListener(this);
		rightClick.setOnClickListener(this);

		sparent = (LinearLayout) findViewById(R.id.mParent);
		sparent.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent ev) {
				final int hisx, hisy;
				int curx = 0, cury = 0;
				final int difx;
				final int dify;
				mcode = "0";

				hisx = (int) ev.getX();
				hisy = (int) ev.getY();
				// storing
				if (ev.getAction() == MotionEvent.ACTION_DOWN) {
					tempx = hisx;
					tempy = hisy;
				}

				if (ev.getAction() == MotionEvent.ACTION_UP) {
					curx = (int) ev.getX();
					cury = (int) ev.getY();
				}
				difx = tempx - curx;
				dify = tempy - cury;

				temp = "#m" + difx + "," + dify + "," + mcode;
				// temp="#m" + (int)ev.getX()+"," + (int)ev.getY()+","+mcode;
				temp += "\n";

				et.setText(temp);
				if (ev.getAction() == MotionEvent.ACTION_UP)
					new SocketConnectivity(MouseGUI.this).execute(temp);
				return true;
			}
		});

	}

	// Mouse Drag
	// int mActivePointerId = INVALID_POINTER_ID;

	// @Override
	/*
	 * public boolean onTouchEvent(MotionEvent ev) { // Let the
	 * ScaleGestureDetector inspect all events. sparent.onTouchEvent(ev);
	 * 
	 * final int action = MotionEventCompat.getActionMasked(ev);
	 * 
	 * switch (action) { case MotionEvent.ACTION_DOWN: { final int pointerIndex
	 * = MotionEventCompat.getActionIndex(ev); final float x =
	 * MotionEventCompat.getX(ev, pointerIndex); final float y =
	 * MotionEventCompat.getY(ev, pointerIndex);
	 * 
	 * // Remember where we started (for dragging) mLastTouchX = (int) x;
	 * mLastTouchY = (int) y; // Save the ID of this pointer (for dragging)
	 * mActivePointerId = MotionEventCompat.getPointerId(ev, 0); break; }
	 * 
	 * case MotionEvent.ACTION_MOVE: { // Find the index of the active pointer
	 * and fetch its position final int pointerIndex =
	 * MotionEventCompat.findPointerIndex(ev, mActivePointerId);
	 * 
	 * final float x = MotionEventCompat.getX(ev, pointerIndex); final float y =
	 * MotionEventCompat.getY(ev, pointerIndex);
	 * 
	 * // Only move if the ScaleGestureDetector isn't processing a gesture. //
	 * ScaleGestureDetector mScaleDetector=new ScaleGestureDetector();
	 * 
	 * // if (!mScaleDetector.isInProgress()) { // Calculate the distance moved
	 * final float dx = x - mLastTouchX; final float dy = y - mLastTouchY;
	 * 
	 * mPosX += dx; mPosY += dy;
	 * 
	 * // invalidate(); // } // Remember this touch position for the next move
	 * event mLastTouchX = (int) x; mLastTouchY = (int) y;
	 * 
	 * break; }
	 * 
	 * case MotionEvent.ACTION_UP: { mActivePointerId = INVALID_POINTER_ID;
	 * break; }
	 * 
	 * case MotionEvent.ACTION_CANCEL: { mActivePointerId = INVALID_POINTER_ID;
	 * break; }
	 * 
	 * case MotionEvent.ACTION_POINTER_UP: {
	 * 
	 * final int pointerIndex = MotionEventCompat.getActionIndex(ev); final int
	 * pointerId = MotionEventCompat.getPointerId(ev, pointerIndex);
	 * 
	 * if (pointerId == mActivePointerId) { // This was our active pointer going
	 * up. Choose a new // active pointer and adjust accordingly. final int
	 * newPointerIndex = pointerIndex == 0 ? 1 : 0; mLastTouchX = (int)
	 * MotionEventCompat.getX(ev, newPointerIndex); mLastTouchY = (int)
	 * MotionEventCompat.getY(ev, newPointerIndex); mActivePointerId =
	 * MotionEventCompat.getPointerId(ev, newPointerIndex);
	 * 
	 * temp="#m" + mLastTouchX +":"+mLastTouchY+":" +mPosX+"," +
	 * mPosY+","+mcode; //temp="#m" + (int)ev.getX()+"," +
	 * (int)ev.getY()+","+mcode; temp+="\n";
	 * 
	 * 
	 * 
	 * 
	 * et.setText(temp); //if(ev.getAction()==MotionEvent.ACTION_UP ) new
	 * SocketConnectivity().execute(temp);
	 * 
	 * } break; } } return true; }
	 */

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_mouse_gui, menu);
		return true;
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onDrag(View arg0, DragEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.mouseleft:
			mcode = "1";
			break;
		case R.id.mousemiddle:
			mcode = "2";
			break;
		case R.id.mouseright:
			mcode = "3";
			break;

		}

		temp = "#m0,0," + mcode;
		// temp="#m" + (int)ev.getX()+"," + (int)ev.getY()+","+mcode;
		temp += "\n";
		new SocketConnectivity(this).execute(temp);

	}

}

package com.ad.touchnAccelerate;

import android.app.ActionBar.LayoutParams;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TNAMainActivity extends FragmentActivity {

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		new AlertDialog.Builder(this)
				.setMessage("Are you sure you want to exit?")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								TNAMainActivity.this.finish();
							}
						}).setNegativeButton("No", null).show();
	}

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	public void onButtonClicked(String spath) {
		// TODO Auto-generated method stub

		Intent intent = new Intent(spath);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {
		TNAMainActivity a;

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);

		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new DummySectionFragment1();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment1.ARG_SECTION_NUMBER, position + 1);
			args.putInt(DummySectionFragment1.ARG_SECTION_NAME, position + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 5;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase();
			case 1:
				return getString(R.string.title_section2).toUpperCase();
			case 2:
				return getString(R.string.title_section3).toUpperCase();
			case 3:
				return getString(R.string.title_section4).toUpperCase();
			case 4:
				return getString(R.string.title_section5).toUpperCase();

			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */

	public static class DummySectionFragment1 extends Fragment {
		private LinearLayout lLayout;
		private TextView tView;
		static String spath = null;
		TNAMainActivity a;
		int sint = 1;

		public DummySectionFragment1() {

		}

		public static final String ARG_SECTION_NUMBER = "section_number";
		public static final String ARG_SECTION_NAME = "section_name";

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			lLayout = new LinearLayout(getActivity());
			lLayout.setOrientation(LinearLayout.VERTICAL);
			// -1(LayoutParams.MATCH_PARENT) is fill_parent or match_parent
			// since API level 8
			// -2(LayoutParams.WRAP_CONTENT) is wrap_content
			lLayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

			String stext = null, sbutton = null;

			TextView textView = new TextView(getActivity());
			textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
			// Typeface typeFace=Typeface.createFromAsset(null,
			// "fonts/mytruetypefont.ttf");
			textView.setTypeface(Typeface.DEFAULT_BOLD);
			String inp = Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER));

			String[] cDes = getResources().getStringArray(R.array.Description);

			switch (inp.charAt(0)) {
			case '1':
				stext = cDes[0];
				sbutton = "Mouse Mode";
				sint = 1;

				spath = "MouseGUI.class";
				break;
			case '2':
				stext = cDes[1];
				sbutton = "KeyboardGUI Mode";

				sint = 2;
				spath = "KeyboardGUI.class";
				break;
			case '3':
				stext = cDes[2];
				sbutton = "PPT Mode";
				sint = 3;
				spath = "PresentationGUI.class";
				break;
			case '4':
				stext = cDes[3];
				sbutton = "Accelero Mode";
				sint = 4;
				spath = "AcceleroGUI.class";
				break;
			case '5':
				stext = cDes[4];
				sbutton = "ScreenShot Mode";
				sint = 5;
				spath = "ScreenshotViewer.class";
				break;
			}

			textView.setText(stext);

			Button b = new Button(getActivity());

			b.setText(sbutton);
			b.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			params.weight = 0.5f;
			params.gravity = Gravity.BOTTOM;
			b.setLayoutParams(params);

			b.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					//Toast.makeText(getActivity(), sint + "", (int) 2.0).show();

					switch (sint) {
					case 1:
						Intent intent1 = new Intent(getActivity(),
								MouseGUI.class);

						startActivity(intent1);
						break;
					case 2:
						Intent intent2 = new Intent(getActivity(),
								KeyboardGUI.class);
						startActivity(intent2);
						break;
					case 3:

						Intent intent3 = new Intent(getActivity(),
								PresentationGUI.class);
						startActivity(intent3);
						break;
					case 4:

						Intent intent4 = new Intent(getActivity(),
								AcceleroGUI.class);
						startActivity(intent4);
						break;
					case 5:

						Intent intent5 = new Intent(getActivity(),
								ScreenshotViewer.class);
						startActivity(intent5);
						break;

					}

					/*
					 * TNAMainActivity.intent=new
					 * Intent(getActivity(),"a.class"); startActivity(intent);
					 */
				}

			});
			b.setTextColor(Color.WHITE);
			b.setBackgroundResource(R.drawable.blackbutton);
			lLayout.addView(textView);
			lLayout.addView(b);

			return lLayout;

		}

	}

	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// Create a new TextView and set its text to the fragment's section
			// number argument value.
			TextView textView = new TextView(getActivity());
			textView.setGravity(Gravity.CENTER);
			textView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return textView;
		}
	}

}

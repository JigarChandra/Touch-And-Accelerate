package com.ad.touchnAccelerate;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.os.StrictMode;
import android.os.Vibrator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class KeyboardGUI extends Activity implements View.OnClickListener {
	TextView et;
	LinearLayout sparent;
	String temp;

	String mcode;
	// private static final int INVALID_POINTER_ID = -1;
	int tempx;
	int tempy;
	Vibrator vibe;
	int mLastTouchX, mLastTouchY, mPosX, mPosY;

	Button leftClick, middleClick, rightClick;
	private Button smallq, smallw, smalle, smallr, smallt, smally, smallu,
			smalli, smallo, smallp;
	private Button smalla, smalls, smalld, smallf, smallg, smallh, smallj,
			smallk, smalll;
	private Button smallz, smallc, smallv, smallb, smalln, smallm;
	Button smallx;

	private ImageButton abc;
	private ImageButton backspace, hp, num, x, space, dot, enter, nextpage;
	LayoutInflater inflater;
	LinearLayout kv;
	String display;
	View myView;
	private ViewFlipper vf;
	// private ImageButton arrowleftarrow;
	private long vibratems = 50;
	private ImageButton smallhp;
	private ImageButton smallnextpage;
	private ImageButton smallnum;
	private Button capitalq, capitalw, capitale, capitalr, capitalt, capitaly,
			capitalu, capitali, capitalo, capitalp;
	private Button capitala, capitals, capitald, capitalf, capitalg, capitalh,
			capitalj, capitalk, capitall;
	private Button capitalz, capitalx, capitalc, capitalv, capitalb, capitaln,
			capitalm;
	private ImageButton bighp;

	private ImageButton bignum;
	private ImageButton bigx;
	private ImageButton bignextpage;
	private ImageButton addhp;
	private ImageButton addabc;
	private ImageButton addx;
	private ImageButton addnextpage;
	private ImageButton addprevpage;
	private ImageButton addarrowpage;

	private ImageButton home, end, insert, pageup, pagedown, delete, printscr;
	private ImageButton curlyopen, curlyclose, lessthan, greaterthan, colon,
			squareopen, squareclose, singlequote, tab, pause;
	private ImageButton ctrlaltdelete, alttab, capslock, numlock, scrolllock;
	private ImageButton arrowhp;
	private ImageButton arrowabc;
	private ImageButton arrowprevpage;
	private ImageButton hotabc;
	private ImageButton hotx;
	private ImageButton hotnextpage;
	private ImageButton hotprevpage;
	private Button f1;
	private Button f2;
	private Button f3;
	private Button f4;
	private Button f5;
	private Button f6;
	private Button f7;
	private Button f8;
	private Button f9;
	private Button f10;
	private Button f11;
	private Button f12;
	private ImageButton uparrow;
	private ImageButton leftarrow;
	private ImageButton downarrow;
	private ImageButton rightarrow;
	private ImageButton smallX;
	private ImageButton shutdown;
	private ImageButton restart;
	private ImageButton logoff;
	private ImageButton volumeup;
	private ImageButton volumedown;
	private ImageButton volumemute;
	private ImageButton media;
	private ImageButton browser;
	private ImageButton email;
	private ImageButton calculator;
	private ImageButton mycomputer;
	private Button testnext;
	private Button testprev;
	private ImageButton smallshift;
	private ImageButton capitalshift;
	private Button one;
	private Button two;
	private Button three;
	private Button four;
	private Button five;
	private Button six;
	private Button seven;
	private Button eight;
	private Button nine;
	private Button zero;
	private ImageButton exclaimation;
	private ImageButton atrate;
	private ImageButton hash;
	private ImageButton dollar;
	private ImageButton percent;
	private ImageButton exor;
	private ImageButton ampersand;
	private ImageButton question;
	private ImageButton backwardslash;
	private ImageButton slash;
	private ImageButton underscore;
	private ImageButton doublequote;
	private ImageButton singleq;
	private ImageButton openround;
	private ImageButton closeround;
	private ImageButton minus;
	private ImageButton plus;
	private ImageButton semicolon;
	private ImageButton comma;
	private ImageButton numhp;
	private ImageButton numabc;
	private ImageButton numx;
	private ImageButton media2;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// setContentView(R.layout.activity_keyboardsmall);

		setContentView(R.layout.keyboardmodeslider);

		vf = (ViewFlipper) findViewById(R.id.ViewFlipper01);

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		intialize();

		kv = (LinearLayout) findViewById(R.id.keyboardview);

	}

	void smallcaps() {
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

		smallhp = (ImageButton) findViewById(R.id.smallhp);
		smallnum = (ImageButton) findViewById(R.id.smallnum);
		smallX = (ImageButton) findViewById(R.id.smallX);
		smallnextpage = (ImageButton) findViewById(R.id.smallnextpage);

		smallshift = (ImageButton) findViewById(R.id.smallshift);
		space = (ImageButton) findViewById(R.id.space);
		dot = (ImageButton) findViewById(R.id.dot);
		enter = (ImageButton) findViewById(R.id.enter);
		backspace = (ImageButton) findViewById(R.id.backspace);

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
		smalln.setOnClickListener(this);
		smallm.setOnClickListener(this);

		smallhp.setOnClickListener(this);
		smallnum.setOnClickListener(this);
		smallX.setOnClickListener(this);
		smallnextpage.setOnClickListener(this);

		smallshift.setOnClickListener(this);
		space.setOnClickListener(this);
		dot.setOnClickListener(this);
		enter.setOnClickListener(this);
		backspace.setOnClickListener(this);

	}

	void bigcaps() {

		capitalq = (Button) findViewById(R.id.capitalq);
		capitalw = (Button) findViewById(R.id.capitalw);
		capitale = (Button) findViewById(R.id.capitale);
		capitalr = (Button) findViewById(R.id.capitalr);
		capitalt = (Button) findViewById(R.id.capitalt);
		capitaly = (Button) findViewById(R.id.capitaly);
		capitalu = (Button) findViewById(R.id.capitalu);
		capitali = (Button) findViewById(R.id.capitali);
		capitalo = (Button) findViewById(R.id.capitalo);
		capitalp = (Button) findViewById(R.id.capitalp);

		capitala = (Button) findViewById(R.id.capitala);
		capitals = (Button) findViewById(R.id.capitals);
		capitald = (Button) findViewById(R.id.capitald);
		capitalf = (Button) findViewById(R.id.capitalf);
		capitalg = (Button) findViewById(R.id.capitalg);
		capitalh = (Button) findViewById(R.id.capitalh);
		capitalj = (Button) findViewById(R.id.capitalj);
		capitalk = (Button) findViewById(R.id.capitalk);
		capitall = (Button) findViewById(R.id.capitall);

		capitalz = (Button) findViewById(R.id.capitalz);
		capitalx = (Button) findViewById(R.id.capitalx);
		capitalc = (Button) findViewById(R.id.capitalc);
		capitalv = (Button) findViewById(R.id.capitalv);
		capitalb = (Button) findViewById(R.id.capitalb);
		capitaln = (Button) findViewById(R.id.capitaln);
		capitalm = (Button) findViewById(R.id.capitalm);

		capitalshift = (ImageButton) findViewById(R.id.capitalshift);
		bighp = (ImageButton) findViewById(R.id.bighp);
		bignum = (ImageButton) findViewById(R.id.bignum);
		bigx = (ImageButton) findViewById(R.id.bigx);
		bignextpage = (ImageButton) findViewById(R.id.bignextpage);

		capitalq.setOnClickListener(this);
		capitalw.setOnClickListener(this);
		capitale.setOnClickListener(this);
		capitalr.setOnClickListener(this);
		capitalt.setOnClickListener(this);
		capitaly.setOnClickListener(this);
		capitalu.setOnClickListener(this);
		capitali.setOnClickListener(this);
		capitalo.setOnClickListener(this);
		capitalp.setOnClickListener(this);

		capitala.setOnClickListener(this);
		capitals.setOnClickListener(this);
		capitald.setOnClickListener(this);
		capitalf.setOnClickListener(this);
		capitalg.setOnClickListener(this);
		capitalh.setOnClickListener(this);
		capitalj.setOnClickListener(this);
		capitalk.setOnClickListener(this);
		capitall.setOnClickListener(this);

		capitalz.setOnClickListener(this);
		capitalx.setOnClickListener(this);
		capitalc.setOnClickListener(this);
		capitalv.setOnClickListener(this);
		capitalb.setOnClickListener(this);

		capitaln.setOnClickListener(this);
		capitalm.setOnClickListener(this);
		capitalshift.setOnClickListener(this);
		bighp.setOnClickListener(this);
		bignum.setOnClickListener(this);
		bigx.setOnClickListener(this);
		bignextpage.setOnClickListener(this);

	}

	void additionalkeys() {
		home = (ImageButton) findViewById(R.id.home);
		end = (ImageButton) findViewById(R.id.end);
		insert = (ImageButton) findViewById(R.id.insert);
		pageup = (ImageButton) findViewById(R.id.pageup);
		pagedown = (ImageButton) findViewById(R.id.pagedown);
		delete = (ImageButton) findViewById(R.id.delete);
		printscr = (ImageButton) findViewById(R.id.printscr);

		curlyopen = (ImageButton) findViewById(R.id.curlyopen);
		curlyclose = (ImageButton) findViewById(R.id.curlyclose);
		lessthan = (ImageButton) findViewById(R.id.lessthan);
		greaterthan = (ImageButton) findViewById(R.id.greaterthan);
		colon = (ImageButton) findViewById(R.id.colon);
		squareopen = (ImageButton) findViewById(R.id.squareopen);
		squareclose = (ImageButton) findViewById(R.id.squareclose);
		singlequote = (ImageButton) findViewById(R.id.singlequote);
		tab = (ImageButton) findViewById(R.id.tab);

		pause = (ImageButton) findViewById(R.id.pause);
		ctrlaltdelete = (ImageButton) findViewById(R.id.ctrlaltdelete);
		alttab = (ImageButton) findViewById(R.id.alttab);
		capslock = (ImageButton) findViewById(R.id.capslock);
		numlock = (ImageButton) findViewById(R.id.numlock);
		scrolllock = (ImageButton) findViewById(R.id.scrolllock);

		home.setOnClickListener(this);
		end.setOnClickListener(this);
		insert.setOnClickListener(this);
		pageup.setOnClickListener(this);
		pagedown.setOnClickListener(this);
		delete.setOnClickListener(this);
		printscr.setOnClickListener(this);

		curlyopen.setOnClickListener(this);
		curlyclose.setOnClickListener(this);
		lessthan.setOnClickListener(this);
		greaterthan.setOnClickListener(this);
		colon.setOnClickListener(this);
		squareopen.setOnClickListener(this);
		squareclose.setOnClickListener(this);
		singlequote.setOnClickListener(this);
		tab.setOnClickListener(this);

		pause.setOnClickListener(this);
		ctrlaltdelete.setOnClickListener(this);
		alttab.setOnClickListener(this);
		capslock.setOnClickListener(this);
		numlock.setOnClickListener(this);
		scrolllock.setOnClickListener(this);

		addabc = (ImageButton) findViewById(R.id.addabc);
		addx = (ImageButton) findViewById(R.id.addx);
		addnextpage = (ImageButton) findViewById(R.id.addnextpage);
		addprevpage = (ImageButton) findViewById(R.id.addprevpage);
		addarrowpage = (ImageButton) findViewById(R.id.addarrowpage);

		// addhp.setOnClickListener(this);
		addabc.setOnClickListener(this);
		addx.setOnClickListener(this);
		addnextpage.setOnClickListener(this);
		addprevpage.setOnClickListener(this);
		addarrowpage.setOnClickListener(this);

	}

	void arrows() {

		f1 = (Button) findViewById(R.id.F1);
		f2 = (Button) findViewById(R.id.F2);
		f3 = (Button) findViewById(R.id.F3);
		f4 = (Button) findViewById(R.id.F4);
		f5 = (Button) findViewById(R.id.F5);
		f6 = (Button) findViewById(R.id.F6);
		f7 = (Button) findViewById(R.id.F7);
		f8 = (Button) findViewById(R.id.F8);
		f9 = (Button) findViewById(R.id.F9);
		f10 = (Button) findViewById(R.id.F10);
		f11 = (Button) findViewById(R.id.F11);
		f12 = (Button) findViewById(R.id.F12);

		uparrow = (ImageButton) findViewById(R.id.uparrow);
		leftarrow = (ImageButton) findViewById(R.id.leftarrow);
		downarrow = (ImageButton) findViewById(R.id.downarrow);
		rightarrow = (ImageButton) findViewById(R.id.rightarrow);

		f1.setOnClickListener(this);
		f2.setOnClickListener(this);
		f3.setOnClickListener(this);
		f4.setOnClickListener(this);
		f5.setOnClickListener(this);
		f6.setOnClickListener(this);
		f7.setOnClickListener(this);
		f8.setOnClickListener(this);
		f9.setOnClickListener(this);
		f10.setOnClickListener(this);
		f11.setOnClickListener(this);
		f12.setOnClickListener(this);

		uparrow.setOnClickListener(this);
		leftarrow.setOnClickListener(this);
		downarrow.setOnClickListener(this);
		rightarrow.setOnClickListener(this);

		arrowhp = (ImageButton) findViewById(R.id.arrowhp);
		arrowabc = (ImageButton) findViewById(R.id.arrowabc);
		arrowprevpage = (ImageButton) findViewById(R.id.arrowprevpage);

		arrowhp.setOnClickListener(this);
		arrowabc.setOnClickListener(this);
		arrowprevpage.setOnClickListener(this);

	}

	void hotkeys() {

		shutdown = (ImageButton) findViewById(R.id.shutdown);
		restart = (ImageButton) findViewById(R.id.restart);
		logoff = (ImageButton) findViewById(R.id.logoff);
		volumeup = (ImageButton) findViewById(R.id.volumeup);
		volumedown = (ImageButton) findViewById(R.id.volumedown);
		volumemute = (ImageButton) findViewById(R.id.volumemute);
		media2 = (ImageButton) findViewById(R.id.media2);
		browser = (ImageButton) findViewById(R.id.browser);
		email = (ImageButton) findViewById(R.id.email);
		calculator = (ImageButton) findViewById(R.id.calculator);
		mycomputer = (ImageButton) findViewById(R.id.mycomputer);

		hotabc = (ImageButton) findViewById(R.id.hotabc);
		hotx = (ImageButton) findViewById(R.id.hotx);
		hotnextpage = (ImageButton) findViewById(R.id.hotnextpage);
		hotprevpage = (ImageButton) findViewById(R.id.hotprevpage);

		shutdown.setOnClickListener(this);
		restart.setOnClickListener(this);
		logoff.setOnClickListener(this);
		volumeup.setOnClickListener(this);
		volumedown.setOnClickListener(this);
		volumemute.setOnClickListener(this);
		media2.setOnClickListener(this);
		browser.setOnClickListener(this);
		email.setOnClickListener(this);
		calculator.setOnClickListener(this);
		mycomputer.setOnClickListener(this);

		hotabc.setOnClickListener(this);
		hotx.setOnClickListener(this);
		hotnextpage.setOnClickListener(this);
		hotprevpage.setOnClickListener(this);

	}

	private void number() {
		// TODO Auto-generated method stub

		one = (Button) findViewById(R.id.one);
		two = (Button) findViewById(R.id.two);
		three = (Button) findViewById(R.id.three);
		four = (Button) findViewById(R.id.four);
		five = (Button) findViewById(R.id.five);
		six = (Button) findViewById(R.id.six);
		seven = (Button) findViewById(R.id.seven);
		eight = (Button) findViewById(R.id.eight);
		nine = (Button) findViewById(R.id.nine);
		zero = (Button) findViewById(R.id.zero);

		exclaimation = (ImageButton) findViewById(R.id.exclamation);
		atrate = (ImageButton) findViewById(R.id.atrate);
		hash = (ImageButton) findViewById(R.id.hash);
		dollar = (ImageButton) findViewById(R.id.dollar);
		percent = (ImageButton) findViewById(R.id.percent);
		exor = (ImageButton) findViewById(R.id.exor);
		ampersand = (ImageButton) findViewById(R.id.ambercent);
		question = (ImageButton) findViewById(R.id.question);
		backwardslash = (ImageButton) findViewById(R.id.backslash);
		slash = (ImageButton) findViewById(R.id.slash);
		underscore = (ImageButton) findViewById(R.id.underscore);
		doublequote = (ImageButton) findViewById(R.id.doubleinverted);
		singleq = (ImageButton) findViewById(R.id.singlequotes);
		openround = (ImageButton) findViewById(R.id.roundopen);
		closeround = (ImageButton) findViewById(R.id.roundclose);
		minus = (ImageButton) findViewById(R.id.minus);
		plus = (ImageButton) findViewById(R.id.plus);
		semicolon = (ImageButton) findViewById(R.id.semicolon);
		comma = (ImageButton) findViewById(R.id.comma);

		numhp = (ImageButton) findViewById(R.id.numhp);
		numabc = (ImageButton) findViewById(R.id.numabc);
		numx = (ImageButton) findViewById(R.id.numx);

		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		four.setOnClickListener(this);
		five.setOnClickListener(this);
		six.setOnClickListener(this);
		seven.setOnClickListener(this);
		eight.setOnClickListener(this);
		nine.setOnClickListener(this);
		zero.setOnClickListener(this);

		exclaimation.setOnClickListener(this);
		atrate.setOnClickListener(this);
		hash.setOnClickListener(this);
		dollar.setOnClickListener(this);
		percent.setOnClickListener(this);
		exor.setOnClickListener(this);
		ampersand.setOnClickListener(this);
		question.setOnClickListener(this);
		backwardslash.setOnClickListener(this);
		slash.setOnClickListener(this);
		underscore.setOnClickListener(this);
		doublequote.setOnClickListener(this);
		singleq.setOnClickListener(this);
		openround.setOnClickListener(this);
		closeround.setOnClickListener(this);
		minus.setOnClickListener(this);
		plus.setOnClickListener(this);
		semicolon.setOnClickListener(this);
		comma.setOnClickListener(this);

		numhp.setOnClickListener(this);
		numabc.setOnClickListener(this);
		numx.setOnClickListener(this);

	}

	public void intialize() {
		// TODO Auto-generated method stub
		vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		et = (TextView) findViewById(R.id.editText1);

		/*
		 * testnext=(Button)findViewById(R.id.testnext);
		 * testprev=(Button)findViewById(R.id.testprev);
		 * 
		 * testnext.setOnClickListener(this); testprev.setOnClickListener(this);
		 */

		smallcaps();
		bigcaps();
		additionalkeys();
		arrows();
		hotkeys();
		number();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		vibe.vibrate(vibratems);

		switch (v.getId()) {
		// test
		/*
		 * case R.id.testprev:prevpage(1); break; case
		 * R.id.testnext:nextpage(1); break;
		 */
		// SMALL
		case R.id.smallshift:
			prevpage(1);
			break;
		case R.id.smallhp:
			nextpage(3);
			break;
		case R.id.smallnum:
			nextpage(1);
			break;
		case R.id.smallX:
			nextpage(4);// gotoarow
			break;
		case R.id.smallnextpage:
			nextpage(5);// goto aditional
			break;
		// BIG
		case R.id.capitalshift:
			nextpage(1);
			break;
		case R.id.bighp:
			prevpage(3);
			break;
		case R.id.bignum:
			nextpage(2);
			break;
		case R.id.bigx:
			prevpage(2);// gotoarow
			break;
		case R.id.bignextpage:
			prevpage(1);// goto aditional
			break;
		// ADDITIONAL
		case R.id.addhp:
			prevpage(2);
			break;
		case R.id.addabc:
			prevpage(5);
			break;
		case R.id.addx:
			prevpage(1);// gotoarow
			break;
		case R.id.addnextpage:
			prevpage(5);// goto small caps
			break;
		case R.id.addprevpage:
			nextpage(1);// goto big caps
			break;
		case R.id.addarrowpage:
			prevpage(1);// goto big caps
			break;
		// ARROW
		case R.id.arrowhp:
			prevpage(1);
			break;
		case R.id.arrowabc:
			prevpage(4);
			break;
		case R.id.arrowprevpage:
			prevpage(4);// goto small caps
			break;
		// HOTKEYS

		case R.id.hotabc:
			prevpage(3);
			break;
		case R.id.hotx:
			nextpage(1);// gotoarow
			break;
		case R.id.hotnextpage:
			prevpage(3);// goto small caps
			break;
		case R.id.hotprevpage:
			nextpage(3);// goto big caps
			break;
		// num
		case R.id.numhp:
			nextpage(2);// gotoarow
			break;
		case R.id.numx:
			nextpage(3);// goto small caps
			break;
		case R.id.numabc:
			prevpage(1);// goto big caps
			break;

		
		
			
		
		
		
			
		
		case R.id.smallq:
			mcode="#k0Q";
			display="q";
			break;
		case R.id.smallw:mcode="#k0W";
		display="w";
			break;
		case R.id.smalle:mcode="#k0E";
		display="e";
			break;	
		case R.id.smallr:mcode="#k0R";
		display="r"; break;
	    case R.id.smallt:mcode="#k0T";
	    display="t"; break;
	    case R.id.smally:mcode="#k0Y";
	    display="y"; break;		
	    case R.id.smallu:mcode="#k0U";
	    display="u"; break;
	    case R.id.smalli:mcode="#k0I";
	    display="i"; break;
	    case R.id.smallo:mcode="#k0O";
	    display="o"; break;	
	    case R.id.smallp:mcode="#k0P";
	    display="p"; break;
        case R.id.smalla:mcode="#k0A";
        display="a"; break;
        case R.id.smalls:mcode="#k0S";
        display="s"; break;	    
        case R.id.smalld:mcode="#k0D";
        display="d"; break;
	    case R.id.smallf:mcode="#k0F";
	    display="f"; break;
	    case R.id.smallg:mcode="#k0G";
	    display="g"; break;	
	    case R.id.smallh:mcode="#k0H";
	    display="h"; break;
        case R.id.smallj:mcode="#k0J";
        display="j"; break;
        case R.id.smallk:mcode="#k0K";
        display="k"; break;	
        case R.id.smalll:mcode="#k0L";
        display="l"; break;
	    case R.id.smallz:mcode="#k0Z";
	    display="z"; break;
	    case R.id.smallx:mcode="#k0X";
	    display="x"; break;	
	    case R.id.smallc:mcode="#k0C";
	    display="c"; break;
        case R.id.smallv:mcode="#k0V";
        display="v"; break;
        
        
        case R.id.dot:mcode="#k2X";
        display="."; break;
        
        
        case R.id.smallb:mcode="#k0B";
        display="b"; break;	
        case R.id.smalln:mcode="#k0N";
        display="n"; break;
        case R.id.smallm:mcode="#k0M";
        display="m"; break;
        
        case R.id.capitalq:mcode="#k1Q";
        display="Q"; break;
        case R.id.capitalw:mcode="#k1W";
        display="W"; break;
        case R.id.capitale:mcode="#k1E";
        display="E"; break;
        case R.id.capitalr:mcode="#k1R";
        display="R"; break;
        case R.id.capitalt:mcode="#k1T";
        display="T"; break;
        case R.id.capitaly:mcode="#k1Y";
        display="Y"; break;
        case R.id.capitalu:mcode="#k1U";
        display="U"; break;
        case R.id.capitali:mcode="#k1I";
        display="I"; break;
        case R.id.capitalo:mcode="#k1O";
        display="O"; break;
        case R.id.capitalp:mcode="#k1P";
        display="P"; break;
        case R.id.capitala:mcode="#k1A";
        display="A"; break;
        case R.id.capitals:mcode="#k1S";
        display="S"; break;
        case R.id.capitald:mcode="#k1D";
        display="D"; break;
        case R.id.capitalf:mcode="#k1F";
        display="F"; break;
        case R.id.capitalg:mcode="#k1G";
        display="G"; break;
        case R.id.capitalh:mcode="#k1H";
        display="H"; break;
        case R.id.capitalj:mcode="#k1J";
        display="J"; break;
        case R.id.capitalk:mcode="#k1K";
        display="K"; break;
        case R.id.capitall:mcode="#k1L";
        display="L"; break;
        case R.id.capitalz:mcode="#k1Z";
        display="Z"; break;
        case R.id.capitalx:mcode="#k1X";
        display="X"; break;
        case R.id.capitalc:mcode="#k1C";
        display="C"; break;
        case R.id.capitalv:mcode="#k1V";
        display="V"; break;
        case R.id.capitalb:mcode="#k1B";
        display="B"; break;
        case R.id.capitaln:mcode="#k1N";
        display="N"; break;
        case R.id.capitalm:mcode="#k1M";
        display="M"; break;
        
        case R.id.home:mcode="#k3P";
        break;
        case R.id.insert:mcode="#k3S";
         break;
        case R.id.end:mcode="#k3T";
        break;
        case R.id.pageup:mcode="#k3Q";
       break;
        case R.id.pagedown:mcode="#k3R";
        break;
        case R.id.delete:mcode="#k3F";
        break;
        case R.id.printscr:mcode="#k3M";
        break;
        case R.id.curlyopen:mcode="#k2O";
        display="{"; break;
        case R.id.curlyclose:mcode="#k2P";
        display="}"; break;
        case R.id.lessthan:mcode="#k20";
        display="<"; break;
        case R.id.greaterthan:mcode="#k21";
        display=">"; break;
        case R.id.colon:mcode="#k2S";
        display=":"; break;
        case R.id.squareopen:mcode="#k2Q";
        display="["; break;
        case R.id.squareclose:mcode="#k2R";
        display="]"; break;
        case R.id.singlequote:mcode="#k2V";
        display="'"; break;
        case R.id.tab:mcode="#k3L";
        break;
        case R.id.ctrlaltdelete:mcode="#k3O";
        break;
        case R.id.pause:mcode="#k3N";
        break;
        case R.id.alttab:mcode="#k43";
        break;
        case R.id.capslock:mcode="#k3I";
        break;
        case R.id.numlock:mcode="#k3J";
        break;
        case R.id.scrolllock:mcode="#k3K";
        break;
        
       
        
        case R.id.uparrow:mcode="#k44";
        break;
        case R.id.downarrow:mcode="#k46";
        break;
        case R.id.leftarrow:mcode="#k45";
        break;
        case R.id.rightarrow:mcode="#k47";
        break;
        
        case R.id.shutdown:mcode="#k48";
        break;
        case R.id.restart:mcode="#k49";
        break;
        case R.id.logoff:mcode="#k4A";
        break;
        case R.id.volumeup:mcode="#k4B";
        break;
        case R.id.volumedown:mcode="#k4C";
        break;
        case R.id.volumemute:mcode="#k4D";
        break;
        case R.id.media2:mcode="#k4E";
        break;
        case R.id.browser:mcode="#k4F";
        break;
        case R.id.email:mcode="#k4G";
        break;
        case R.id.calculator:mcode="#k4H";
        break;
        case R.id.mycomputer:mcode="#k4I";
        break;
        
        case R.id.F1:mcode="#k31";
        break;
        case R.id.F2:mcode="#k32";
        break;
        case R.id.F3:mcode="#k33";
        break;
        case R.id.F4:mcode="#k34";
        break;
        case R.id.F5:mcode="#k35";
        break;
        case R.id.F6:mcode="#k36";
        break;
        case R.id.F7:mcode="#k37";
        break;
        case R.id.F8:mcode="#k38";
        break;
        case R.id.F9:mcode="#k39";
        break;
        case R.id.F10:mcode="#k3A";
        break;
        case R.id.F11:mcode="#k3B";
        break;
        case R.id.F12:mcode="#k3C";
        break;
        
        case R.id.one:mcode="#k01";
        display="1"; break;
        case R.id.two:mcode="#k02";
        display="2"; break;
        case R.id.three:mcode="#k03";
        display="3"; break;
        case R.id.four:mcode="#k04";
        display="4"; break;
        case R.id.five:mcode="#k05";
        display="5"; break;
        case R.id.six:mcode="#k06";
        display="6"; break;
        case R.id.seven:mcode="#k07";
        display="7"; break;
        case R.id.eight:mcode="#k08";
        display="8"; break;
        case R.id.nine:mcode="#k09";
        display="9"; break;
        case R.id.zero:mcode="#k00";
        display="0"; break;
        
        case R.id.exclamation:mcode="#k2A";
        display="!"; break;
        case R.id.atrate:mcode="#k2B";
        display="@"; break;
        case R.id.hash:mcode="#k2C";
        display="#"; break;
        case R.id.dollar:mcode="#k2D";
        display="$"; break;
        case R.id.percent:mcode="#k2E";
        display="%"; break;
        case R.id.exor:mcode="#k2F";
        display="^"; break;
        case R.id.ambercent:mcode="#k2G";
        display="&"; break;
        case R.id.backslash:mcode="#k2Y";
        display="/"; break;
        case R.id.slash:mcode="#k2I";
        display="\\"; break;
        case R.id.underscore:mcode="#k2K";
        display="_"; break;
        case R.id.doubleinverted:mcode="#k2T";
        display="\""; break;
        case R.id.singlequotes:mcode="#k2V";
        display="\'"; break;
        case R.id.roundopen:mcode="#k2I";
        display="("; break;
        case R.id.roundclose:mcode="#k1J";
        display=")"; break;
        case R.id.plus:mcode="#k1M";
        display="+"; break;
        case R.id.minus:mcode="#k1L";
        display="-"; break;
        case R.id.comma:mcode="#k1W";
        display=","; break;
        
        case R.id.enter:mcode="#k41";
        break;
        case R.id.backspace:mcode="#k42";
        break;
        case R.id.space:mcode="#k40";
        break;	
			
			
			
			
			
			
			
		}

		if (display != null)
			et.append(display);
		if (mcode != null) {
			new SocketConnectivity(this).execute(mcode);
		} else
			System.out.println("	mcode is null");

	}

	void prevpage(int n) {
		for (int i = 0; i < n; i++) {
			vf.setInAnimation(KeyboardGUI.this, R.anim.view_transition_in_right);
			vf.setOutAnimation(KeyboardGUI.this,
					R.anim.view_transition_out_right);
			vf.showNext();
		}

		mcode = null;
		display = null;
	}

	void nextpage(int n) {
		for (int i = 0; i < n; i++) {
			vf.setInAnimation(KeyboardGUI.this, R.anim.view_transition_in_left);
			vf.setOutAnimation(KeyboardGUI.this,
					R.anim.view_transition_out_left);
			vf.showPrevious();
		}

		mcode = null;
		display = null;
	}

}

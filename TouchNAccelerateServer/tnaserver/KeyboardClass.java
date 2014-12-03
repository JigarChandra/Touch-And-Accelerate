package tnaserver;

import java.awt.AWTKeyStroke;
import java.awt.Robot;

import java.io.File;
import org.w3c.dom.*;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 

import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.AWTException;

 class KeyboardClass extends Robot {
	
	 private boolean shift=false;
	private boolean specialkeys=false;
private String command;
	public KeyboardClass() throws AWTException {
	  super();
	 }
	 //using xml parser
	 
	 public void myKey(String text)
	 {
		 try {
System.out.println("Parsing in xml"+text);
	            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	            Document doc = docBuilder.parse (new File("keycodes.xml"));

	            // normalize text representation
	            doc.getDocumentElement ().normalize ();

	            NodeList value = doc.getElementsByTagName("keyboard");
	           /* int totalPersons = value.getLength();
	            System.out.println("Total no of people : " + totalPersons);*/

	            for(int s=0; s<value.getLength() ; s++){


	                Node codes = value.item(s);
	                if(codes.getNodeType() == Node.ELEMENT_NODE){

String code,values,keyevents;
	                    Element firstElement = (Element)codes;

	                    //-------
	                    NodeList firstNameList = firstElement.getElementsByTagName("code");
	                    Element firstNameElement = (Element)firstNameList.item(0);

	                    NodeList textFNList = firstNameElement.getChildNodes();

code=((Node)textFNList.item(0)).getNodeValue().trim();
	                
	                    //-------
	                    NodeList lastNameList = firstElement.getElementsByTagName("value");
	                    Element lastNameElement = (Element)lastNameList.item(0);

	                    NodeList textLNList = lastNameElement.getChildNodes();
values= ((Node)textLNList.item(0)).getNodeValue().trim();

	                    //----
	                    NodeList keyevent = firstElement.getElementsByTagName("keyevent");
	                    Element ageElement = (Element)keyevent.item(0);

	                    NodeList textAgeList = ageElement.getChildNodes();
keyevents=((Node)textAgeList.item(0)).getNodeValue().trim();

//System.out.println(code+"parsed");
	                    //------
if(text.equalsIgnoreCase(code))
{
	System.out.println(code+ "matched " + values +" "+ keyevents );
int key = 0;
	switch(Integer.parseInt(keyevents))
	{
	
	
		
		
	case 1: key=KeyEvent.VK_A;shift=false;break;
	case 2: key=KeyEvent.VK_B;shift=false;break;
	case 3: key=KeyEvent.VK_C;shift=false;break;
	case 4: key=KeyEvent.VK_D;shift=false;break;
	case 5: key=KeyEvent.VK_E;shift=false;break;
	case 6: key=KeyEvent.VK_F;shift=false;break;
	case 7: key=KeyEvent.VK_G;shift=false;break;
	case 8: key=KeyEvent.VK_H;shift=false;break;
	case 9: key=KeyEvent.VK_I;shift=false;break;
	case 10: key=KeyEvent.VK_J;shift=false;break;
	case 11: key=KeyEvent.VK_K;shift=false;break;
	case 12: key=KeyEvent.VK_L;shift=false;break;
	case 13: key=KeyEvent.VK_M;shift=false;break;
	case 14: key=KeyEvent.VK_N;shift=false;break;
	case 15: key=KeyEvent.VK_O;shift=false;break;
	case 16: key=KeyEvent.VK_P;shift=false;break;
	case 17: key=KeyEvent.VK_Q;shift=false;break;
	case 18: key=KeyEvent.VK_R;shift=false;break;
	case 19: key=KeyEvent.VK_S;shift=false;break;
	case 20: key=KeyEvent.VK_T;shift=false;break;
	case 21: key=KeyEvent.VK_U;shift=false;break;
	case 22: key=KeyEvent.VK_V;shift=false;break;
	case 23: key=KeyEvent.VK_W;shift=false;break;
	case 24: key=KeyEvent.VK_X;shift=false;break;
	case 25: key=KeyEvent.VK_Y;shift=false;break;
	case 26: key=KeyEvent.VK_Z;shift=false;break;
	//caps on
	
	case 27: key=KeyEvent.VK_A;shift=true;break;
	case 28: key=KeyEvent.VK_B;shift=true;break;
	case 29: key=KeyEvent.VK_C;shift=true;break;
	case 30: key=KeyEvent.VK_D;shift=true;break;
	case 31: key=KeyEvent.VK_E;shift=true;break;
	case 32: key=KeyEvent.VK_F;shift=true;break;
	case 33: key=KeyEvent.VK_G;shift=true;break;
	case 34: key=KeyEvent.VK_H;shift=true;break;
	case 35: key=KeyEvent.VK_I;shift=true;break;
	case 36: key=KeyEvent.VK_J;shift=true;break;
	case 37: key=KeyEvent.VK_K;shift=true;break;
	case 38: key=KeyEvent.VK_L;shift=true;break;
	case 39: key=KeyEvent.VK_M;shift=true;break;
	case 40: key=KeyEvent.VK_N;shift=true;break;
	case 41: key=KeyEvent.VK_O;shift=true;break;
	case 42: key=KeyEvent.VK_P;shift=true;break;
	case 43: key=KeyEvent.VK_Q;shift=true;break;
	case 44: key=KeyEvent.VK_R;shift=true;break;
	case 45: key=KeyEvent.VK_S;shift=true;break;
	case 46: key=KeyEvent.VK_T;shift=true;break;
	case 47: key=KeyEvent.VK_U;shift=true;break;
	case 48: key=KeyEvent.VK_V;shift=true;break;
	case 49: key=KeyEvent.VK_W;shift=true;break;
	case 50: key=KeyEvent.VK_X;shift=true;break;
	case 51: key=KeyEvent.VK_Y;shift=true;break;
	case 52: key=KeyEvent.VK_Z;shift=true;break;
	
	//numbers
	case 53: key=KeyEvent.VK_1;shift=false;break;
	case 54: key=KeyEvent.VK_2;shift=false;break;
	case 55: key=KeyEvent.VK_3;shift=false;break;
	case 56: key=KeyEvent.VK_4;shift=false;break;
	case 57: key=KeyEvent.VK_5;shift=false;break;
	case 58: key=KeyEvent.VK_6;shift=false;break;
	case 59: key=KeyEvent.VK_7;shift=false;break;
	case 60: key=KeyEvent.VK_8;shift=false;break;
	case 61: key=KeyEvent.VK_9;shift=false;break;
	case 62: key=KeyEvent.VK_0;shift=false;break;
	
	
	//SYMBOLS
	
	case 73: key= KeyEvent.VK_EXCLAMATION_MARK ;shift=false;break;
	case 74: key= KeyEvent.VK_AT  ;shift=false;break;
	case 75: key= KeyEvent.VK_NUMBER_SIGN   ;shift=false;break;
	case 76: key= KeyEvent.VK_DOLLAR  ;shift=false;break;
	case 77: key= KeyEvent.VK_5 ;shift=true;break;
	case 78: key= KeyEvent.VK_CIRCUMFLEX   ;shift=false;break;
	case 79: key= KeyEvent.VK_AMPERSAND   ;shift=false;break;
	case 80: key= KeyEvent.VK_8  ;shift=true;break;
	case 81: key= KeyEvent.VK_LEFT_PARENTHESIS  ;shift=false;break;
	case 82: key= KeyEvent.VK_RIGHT_PARENTHESIS;shift=false;break;
	case 83: key= KeyEvent.VK_UNDERSCORE  ;shift=false;break;
	case 84: key= KeyEvent.VK_MINUS   ;shift=false;break;
	case 85: key= KeyEvent.VK_PLUS   ;shift=false;break;
	case 86: key= KeyEvent.VK_EQUALS   ;shift=false;break;
	case 87: key= KeyEvent.VK_BRACELEFT   ;shift=false;break;
	case 88: key= KeyEvent.VK_BRACERIGHT   ;shift=false;break;
	case 89: key= KeyEvent.VK_OPEN_BRACKET  ;shift=false;break;
	case 90: key= KeyEvent.VK_CLOSE_BRACKET   ;shift=false;break;
	case 91: key= KeyEvent.VK_COLON   ;shift=false;break;
	case 92: key= KeyEvent.VK_QUOTE   ;shift=false;break;
	case 93: key= KeyEvent.VK_SEMICOLON  ;shift=false;break;
	case 94: key= KeyEvent.VK_AT  ;shift=false;break;
	case 95: key= KeyEvent.VK_COMMA   ;shift=false;break;
	case 96: key= KeyEvent.VK_PERIOD ;shift=false;break;
	case 97: key= KeyEvent.VK_SLASH  ;shift=false;break;
	case 98: key= KeyEvent.VK_AT  ;shift=false;break;
	case 99: key= KeyEvent.VK_LESS ;shift=false;break;
	case 100: key= KeyEvent.VK_GREATER   ;shift=false;break;
	
	//func keys
	case 101: key= KeyEvent.VK_ESCAPE   ;shift=false;break;
	case 102: key= KeyEvent.VK_F1   ;shift=false;break;
	case 103: key= KeyEvent.VK_F2   ;shift=false;break;
	case 104: key= KeyEvent.VK_F3  ;shift=false;break;
	case 105: key= KeyEvent.VK_F4   ;shift=false;break;
	case 106: key= KeyEvent.VK_F5   ;shift=false;break;
	case 107: key= KeyEvent.VK_F6   ;shift=false;break;
	case 108: key= KeyEvent.VK_F7   ;shift=false;break;
	case 109: key= KeyEvent.VK_F8   ;shift=false;break;
	case 110: key= KeyEvent.VK_F9   ;shift=false;break;
	case 111: key= KeyEvent.VK_F10   ;shift=false;break;
	case 112: key= KeyEvent.VK_F11   ;shift=false;break;
	case 113: key= KeyEvent.VK_F12   ;shift=false;break;
	case 114: key= KeyEvent.VK_CONTROL   ;shift=false;break;
	case 115: key= KeyEvent.VK_SHIFT   ;shift=false;break;
	case 116: key= KeyEvent.VK_DELETE   ;shift=false;break;
	case 117: key= KeyEvent.VK_ESCAPE   ;shift=false;break;
	case 118: key= KeyEvent.VK_ESCAPE   ;shift=false;break;
	case 119: key= KeyEvent.VK_CAPS_LOCK   ;shift=false;break;
	case 120: key= KeyEvent.VK_NUM_LOCK   ;shift=false;break;
	case 121: key= KeyEvent.VK_SCROLL_LOCK  ;shift=false;break;
	case 122: key= KeyEvent.VK_TAB  ;shift=false;break;
	case 123: key= KeyEvent.VK_PRINTSCREEN  ;shift=false;break;
	case 124: key= KeyEvent.VK_PAUSE   ;shift=false;break;
	case 125: key= KeyEvent.VK_HOME   ;shift=false;break;
	case 126: key= KeyEvent.VK_HOME   ;shift=false;specialkeys=true;break;
	case 127: key= KeyEvent.VK_PAGE_UP  ;shift=false;break;
	case 128: key= KeyEvent.VK_PAGE_DOWN   ;shift=false;break;
	case 129: key= KeyEvent.VK_INSERT   ;shift=false;break;
	case 130: key= KeyEvent.VK_END   ;shift=false;break;
	
	//Extras
	
	case 131: key= KeyEvent.VK_SPACE   ;shift=false;break;
	case 132: key= KeyEvent.VK_ENTER   ;shift=false;break;
	case 133: key= KeyEvent.VK_BACK_SPACE   ;shift=false;break;
	case 134: key= KeyEvent.VK_ALT ;keyType(key, KeyEvent.VK_TAB);  ;shift=false;break;
	
	case 135: key= KeyEvent.VK_UP    ;shift=false;break;
	
	case 136: key= KeyEvent.VK_LEFT    ;shift=false;break;
	
	case 137: key= KeyEvent.VK_DOWN   ;shift=false;break;
	
	case 138: key= KeyEvent.VK_RIGHT  ;shift=false;break;
	
	
	//APPS
	
	case 139: app("shutdown",0) ;shift=false;break;
	case 140: app("restart",1) ;shift=false;break;
	case 141: app("logoff",2) ;shift=false;break;
	case 142: app("volumeup",3) ;shift=false;break;
	case 143: app("volumedown",4) ;shift=false;break;
	case 144: app("volumemute",5) ;shift=false;break;
	case 145: app("media",6) ;shift=false;break;
	case 146: app("browser",7) ;shift=false;break;
	case 147: app("email",8) ;shift=false;break;
	case 148: app("calculator",9) ;shift=false;break;
	case 149: app("mycomputer",10) ;shift=false;break;
	
	
	
	
	
		
	}
	if(specialkeys)
	{
		//for multiple keys
		  keyPress(KeyEvent.VK_CONTROL);
		  keyPress(KeyEvent.VK_ALT);
		  keyPress(KeyEvent.VK_DELETE);
		  
		  delay(50);
		  keyRelease(KeyEvent.VK_DELETE);
		  keyRelease(KeyEvent.VK_ALT);
		  keyRelease(KeyEvent.VK_CONTROL);
		specialkeys=false;
	}
	else
	{
	if(shift)
	{
		keyType(key, KeyEvent.VK_SHIFT);
	}
	else
	{
		System.out.println("Typing code"+key);
		keyType(key);
		}
	}
}

	                }//end of if clause


	            }//end of for loop with s var


	        }catch (SAXParseException err) {
	        System.out.println ("** Parsing error" + ", line " 
	             + err.getLineNumber () + ", uri " + err.getSystemId ());
	        System.out.println(" " + err.getMessage ());

	        }catch (SAXException e) {
	        Exception x = e.getException ();
	        ((x == null) ? e : x).printStackTrace ();

	        }catch (Throwable t) {
	        t.printStackTrace ();
	        }
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
public void app(String command2, int i) {
		// TODO Auto-generated method stub
		
	System.out.println("Application "+command2);
	Runtime runtime;Process proc;
	
	
	try
	{switch(i)
	{
	case 0: runtime = Runtime.getRuntime();
	 proc = runtime.exec("shutdown -s -t 2");
	//System.exit(0);
		break;
		
	case 1:	runtime = Runtime.getRuntime();
	proc = runtime.exec("shutdown -r");
	//System.exit(0);
		break;
	case 2:	runtime = Runtime.getRuntime();
	proc = runtime.exec("shutdown -l");
	//System.exit(0);
		break;	
		
	case 3:HotkeysSound.setMasterOutputVolume(100f);
		break;
		
	case 4:HotkeysSound.setMasterOutputVolume(50f);
	break;	
		
	case 5:HotkeysSound.setMasterOutputVolume(0f);
	break;	
		
	case 6:	runtime = Runtime.getRuntime();
	proc = runtime.exec("\"C:\\Program Files\\Windows Media Player\\wmplayer.exe\"");
	//System.exit(0);
		break;
	case 7:	runtime = Runtime.getRuntime();
	proc = runtime.exec("\"C:\\Program Files\\Internet Explorer\\iexplore.exe\"");
	//System.exit(0);
		break;
	case 8:	runtime = Runtime.getRuntime();
	proc = runtime.exec("\"C:\\Program Files (x86)\\Microsoft Office\\Office14\\outlook.exe\"");
	//System.exit(0);
		break;
	case 9:	runtime = Runtime.getRuntime();
	proc = runtime.exec("calc");
	//System.exit(0);
		break;	
		
		
	case 10:	runtime = Runtime.getRuntime();
	proc = runtime.exec("C:/Windows/Explorer.exe");
	//System.exit(0);
		break;	
		
		
		
		
		
	}
	}catch(Exception e)
	{
		System.out.println("Cannot run Application "+command2);
	}
	
	
                }
              
	
	
	
	
	

	//MyKey Evaluator for small letters
	 public void myKey2(String text)
	 {
		 String textLower = text.toLowerCase();
		 char c=textLower.charAt(0);
		 int code = 0;
		 boolean shift = false;
		 switch(c)
		 {
		 case 'q':code= KeyEvent.VK_Q;break;
		 case 'w':code= KeyEvent.VK_W;break;
		 case 'e':code= KeyEvent.VK_E;break;
		 case 'r':code= KeyEvent.VK_R;break;
		 case 't':code= KeyEvent.VK_T;break;
		 case 'y':code= KeyEvent.VK_Y;break;
		 case 'u':code= KeyEvent.VK_U;break;
		 case 'i':code= KeyEvent.VK_I;break;
		 case 'o':code= KeyEvent.VK_O;break;
		 case 'p':code= KeyEvent.VK_P;break;
		 case 'a':code= KeyEvent.VK_A;break;
		 case 's':code= KeyEvent.VK_S;break;
		 case 'd':code= KeyEvent.VK_D;break;
		 case 'f':code= KeyEvent.VK_F;break;
		 case 'g':code= KeyEvent.VK_G;break;
		 case 'h':code= KeyEvent.VK_H;break;
		 case 'j':code= KeyEvent.VK_J;break;
		 case 'k':code= KeyEvent.VK_K;break;
		 case 'l':code= KeyEvent.VK_L;break;
		 case 'z':code= KeyEvent.VK_Z;break;
		 case 'x':code= KeyEvent.VK_X;break;
		 case 'c':code= KeyEvent.VK_C;break;
		 case 'v':code= KeyEvent.VK_V;break;
		 case 'b':code= KeyEvent.VK_B;break;
		 case 'n':code= KeyEvent.VK_N;break;
		 case 'm':code= KeyEvent.VK_M;break;
			 
		 }
		  if (shift)
			 keyType(code, KeyEvent.VK_SHIFT);
			  else
				 keyType(code);
		 
	 }
	 
	 //Actually Types the keycode with a delay
	 public void keyType(int keyCode) {
		 
	
	  keyPress(keyCode);
	  delay(50);
	  keyRelease(keyCode);
	 }
	 // For typing shifted keys
	 public void keyType(int keyCode, int keyCodeModifier) {
	  keyPress(keyCodeModifier);
	  keyPress(keyCode);
	  delay(50);
	  keyRelease(keyCode);
	  keyRelease(keyCodeModifier);
	 }

	 //Backup Tping option !! not used in the project
	 public void type(String text) {
	  String textUpper = text.toLowerCase();

	  for (int i=0; i<text.length(); ++i) {
	   typeChar(textUpper.charAt(i));
	  }  
	 }
	 
	 private void typeChar(char c) {
	  boolean shift = false;
	  int keyCode;
	  
	  switch (c) {
	  case '~':
	   keyCode = (int)'`';
	   break;
	  case '!':
	   keyCode = (int)'1';
	   break;
	  case '@':
	   keyCode = (int)'2';
	   break;
	  case '#':
	   keyCode = (int)'3';
	   break;
	  case '$':
	   keyCode = (int)'4';
	   break;
	  case '%':
	   keyCode = (int)'5';
	   break;
	  case '^':
	   keyCode = (int)'6';
	   break;
	  case '&':
	   keyCode = (int)'7';
	   break;
	  case '*':
	   keyCode = (int)'8';
	   break;
	  case '(':
	   keyCode = (int)'9';
	   break;
	  case ')':
	   keyCode = (int)'0';
	   break;
	  case ':':
	   keyCode = (int)';';
	   break;
	  case '_':
	   keyCode = (int)'-';
	   break;
	  case '+':
	   keyCode = (int)'=';
	   break;
	  case '|':
	   keyCode = (int)'\\';
	   break;

	  case '?':
	   keyCode = (int)'/';
	   break;
	  case '{':
	   keyCode = (int)'[';
	   break;
	  case '}':
	   keyCode = (int)']';
	   break;
	  case '<':
	   keyCode = (int)',';
	   break;
	  case '>':
	   keyCode = (int)'.';
	   break;
	  default:
	   keyCode = (int)c;
	   shift = false;
	  }
	  if (shift)
	   keyType(keyCode, KeyEvent.VK_SHIFT);
	  else
	   keyType(keyCode);
	 }
	}
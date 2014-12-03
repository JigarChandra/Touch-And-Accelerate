package tnaserver;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;


class CodeEvaluator {
	static int mx,my;
	static int prevx,prevy;
	static String x,y;
	String code;
	private Thread desktopServerThread3;
	CodeEvaluator(String g)
	{code=g;//Get CODE From the CodeEvaluator Object		
	}
	
	//Distributes the codes to specific modules
	public void codeDistributor()
	{
		if(code.charAt(0)!='#')
			return;
		switch(code.charAt(1))
		{
		 	case 'm':mouseCodeEvaluator(code);
		 	break;
		 	case 'a':acceleroCodeEvaluator(code);
		 	break;
		 	case 'p':presentationCodeEvaluator(code);
		 	break;
		 	case 'k':keyboardCodeEvaluator(code);
		 		break;
		 	case 'x':authentication(code);
		 	break;
		 		default: System.out.println("Drop Code:Code not recognized");
		}
	}
	
	private void authentication(String code2) {
		// TODO Auto-generated method stub
		code2=code2.substring(2);
		String tobesent;
		if(code2.equals(ServerJFrame.password))
		{
			System.out.println("Password matched "+code2+" "+ServerJFrame.password);
			tobesent="Auth";
		}
		else 
		{
			System.out.println("Password Unmatched "+code2+" "+ServerJFrame.password);
			tobesent="NoAuth";
			 
		}
	
		desktopServerThread3 = new Thread(new ReverseTCPDesktopServer(ServerJFrame.port,tobesent));
		  desktopServerThread3.start();
	
	
	}

	//Accelerometer Codes
	private void acceleroCodeEvaluator(String code2) {
	
		code2=code2.substring(2);
		System.out.print(code2);
		boolean centre=false;
		
		Robot robot;
		try {
	         robot= new Robot();
		if(Character.isDigit(code2.charAt(0)))
		{
			switch(Integer.parseInt(code2))
					{
			case 0: centre=true;//Centre is handled currently @ client side
			break;
				case 1:  /*while(!centre)*/ robot.keyPress(KeyEvent.VK_UP );
				robot.keyRelease(KeyEvent.VK_UP );
				break;
				case 2:/*while(!centre)*/robot.keyPress(KeyEvent.VK_LEFT );	
				robot.keyRelease(KeyEvent.VK_LEFT );	
					break;
				case 3:/*while(!centre)*/robot.keyPress(KeyEvent.VK_RIGHT );
				robot.keyRelease(KeyEvent.VK_RIGHT );	
						break;
				case 4:/*while(!centre)*/robot.keyPress(KeyEvent.VK_DOWN );
				robot.keyRelease(KeyEvent.VK_DOWN );	
				break;
				case 5:/*while(!centre)*/robot.keyPress(KeyEvent.VK_SHIFT );
				robot.keyRelease(KeyEvent.VK_SHIFT );	
				
				break;
				case 6:/*while(!centre)*/robot.keyPress(KeyEvent.VK_ALT );
				robot.keyRelease(KeyEvent.VK_ALT );	
				
				break;
				case 7:/*while(!centre)*/robot.keyPress(KeyEvent.VK_SPACE );
				robot.keyRelease(KeyEvent.VK_SPACE );	
				break;
				case 8:/*while(!centre)*/robot.keyPress(KeyEvent.VK_CONTROL );
				robot.keyRelease(KeyEvent.VK_CONTROL );	
				break;
		
					
					default:    

						
					}
		}
		else
		{//Nothing now to do
		}
		} catch (AWTException e) {
	        e.printStackTrace();
		}
		
		
	}
	private void presentationCodeEvaluator(String code2) {
		// TODO Auto-generated method stub
		
		code2=code2.substring(2);
		System.out.print(code2);
		Robot robot;
		try {
	         robot= new Robot();

	        // Simulate a mouse click
	     
	        // Simulate a key press
	     

	
	
		if(Character.isDigit(code2.charAt(0)))
		{
			switch(Integer.parseInt(code2))
					{
				case 0:   robot.keyPress(KeyEvent.VK_ESCAPE );
					break;
				case 1:   robot.keyPress(KeyEvent.VK_F5 );
				break;
				case 2:robot.keyPress(KeyEvent.VK_LEFT );	
					break;
				case 3:robot.keyPress(KeyEvent.VK_RIGHT );
						break;
		
					
					default:
						
					}
		}
		else
		{File file =new File(code2);
			try {
				Desktop.getDesktop().open(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		} catch (AWTException e) {
	        e.printStackTrace();
		}
		
	}
	private void keyboardCodeEvaluator(String kCode) {
		
		System.out.println("Keyboard Mode"+kCode);
		try {
			//kCode=kCode.substring(2);
		
		
				  new KeyboardClass().myKey(kCode);
				
			
			//new KeyboardClass().type(kCode);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
	public void mouseCodeEvaluator(String mCode)
	{
		System.out.println("Mouse Mode");
	

		String[] mouseCode = mCode.split(",");
		
		x=mouseCode[0].substring(2);
		y=mouseCode[1];
		char m=mouseCode[2].charAt(0);//Mode



		System.out.println("Xclient : " +x +" Yclient: " +y+" Mode "+m);
		Robot r;
		try {
			r = new Robot();
	
		switch(m)
		{
			case '0':	
				mouseEvaluationforMode0(Integer.parseInt(x),Integer.parseInt(y));
		customMouseMover(prevx,prevy,mx,my);
		//resolution("1280","1024");
				break;
		case '1':
		r.mousePress(InputEvent.BUTTON1_MASK);
        r.mouseRelease(InputEvent.BUTTON1_MASK);
			//resolution("1280","960");
				break;
		case '2':
			  r.mousePress(InputEvent.BUTTON3_DOWN_MASK);
	            r.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
			//resolution("1280","768");
				break;
		case '3':
			 r.mousePress(InputEvent.BUTTON3_MASK);
	            r.mouseRelease(InputEvent.BUTTON3_MASK);
			//resolution("1280","720");
				break;
		case '4':resolution("1024","768");
				break;
		default: System.out.println("AutoDetection Mode ");
		String tempx,tempy,temp;
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		tempx=d.width+"";
		tempy=d.height+"";

		temp=tempx+" * "+tempy;
		resolution(tempx,tempy);


			}
		}catch(Exception e){}

		//moving mouse
		
	

		
		}
	
	public void mouseEvaluationforMode0(int  x,int y){
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		 mx = (int) b.getX();
		my = (int) b.getY();
		prevx=mx;prevy=my;
		mx=mx-x;
		my=my-y;
		
	
	}
	
	public void customMouseMover(int prevx,int prevy,int x,int y){
			
			Robot r;
			try {
				r = new Robot();
				/*if(prevx<x||prevy<y)
				for(int i=prevx, j=prevy;i<=x||j<=y;i++,j++)
					 r.mouseMove(i, j);
				else if(prevx>x||prevy>y)
					for(int i=prevx, j=prevy;i>=x||j>=y;i--,j--)
						 r.mouseMove(i, j);*/
				
			
				line(prevx,prevy,x,y,r);
			
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	public void line(int x,int y,int x2, int y2, Robot r) {
		
	
		int dx = x2 - x;
		int dy =y2 - y;
while(x2!=x||y2!=y)
{
		x = x+dx;
		y = y+dy;
		r.mouseMove(x2, y2);
}
r.mouseMove(x, y);
	
	}
			
		private static void resolution(String res1,String res2)
		{
			System.out.println("Selected Resolution : "+res1+" * "+res2);


			try{

		 double nmx=Double.parseDouble(res1) * (Double.parseDouble(x)/480);
		 double nmy=Double.parseDouble(res2) * (Double.parseDouble(y)/800);

		mx=(int)nmx;my=(int) nmy;

			System.out.println("MX : " +mx +" MY : " +my);
			}catch(Exception e){
			}
	
	}
}

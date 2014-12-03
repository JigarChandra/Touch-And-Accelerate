package tnaserver;
import java.net.*;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.resizers.*;


class TCPImageConnection implements Runnable {
 static Socket sock;
 ActivityLogger logger;
 TCPImageConnection(ActivityLogger logger)
 {
 this.logger=logger;
 }
 public void run() {
  // create socket
  ServerSocket servsock;
  System.out.println("Waiting...");
try {
	servsock = new ServerSocket();
	
	servsock = new ServerSocket();
	servsock.setReuseAddress(true);
	
	String modified=ServerJFrame.getPort();
	
	
	//if(modified!=null)
	//	servsock.bind(new InetSocketAddress(Integer.parseInt(modified)));

	//else
	servsock.bind(new InetSocketAddress(4445));
while(true)
{

   sock = servsock.accept();
   System.out.println("Accepted connection : " + sock);
   logger.logAction("Screenshot received by "+sock.getInetAddress());
   
   //dataInputStream = new DataInputStream(sock.getInputStream());
//dataOutputStream = new DataOutputStream(sock.getOutputStream());
Robot robot = new Robot();
Rectangle rectangle=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
BufferedImage screenShot = robot.createScreenCapture(rectangle);

//BufferedImage dimg = (BufferedImage) screenShot.getScaledInstance(200,200, Image.SCALE_SMOOTH);
BufferedImage watermarkImage = ImageIO.read(new File("watermark.png"));
BufferedImage thumbnail = Thumbnails.of(screenShot)
.scale(0.25f)
.watermark(Positions.BOTTOM_RIGHT, watermarkImage, 0.1f)
.asBufferedImage();
ImageIO.write(thumbnail, "png", sock.getOutputStream());
}

}catch(Exception e){
	
	System.out.println("Couldnt Bind Port");
	//e.printStackTrace();
}
finally{
   try {
	   if(sock!=null)
	sock.close();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}}
 
  }
 }


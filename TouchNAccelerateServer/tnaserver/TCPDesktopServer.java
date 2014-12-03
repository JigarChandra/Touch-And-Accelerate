package tnaserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
//Requires passage of port only

//IP is taken only for future use

 class TCPDesktopServer implements Runnable{
    public   String SERVERIP ;
    public   int SERVERPORT ;
	private static ServerSocket serverSocket;
	private static Socket client;
	private ActivityLogger logger;
	
	//If ip and port is passed
	TCPDesktopServer(String ip,String port, ActivityLogger logger)
	{
	SERVERIP=ip;
	SERVERPORT=Integer.parseInt(port);
	this.logger = logger;
	}
	//Default port 4444
	TCPDesktopServer(ActivityLogger logger)
	{
	SERVERIP="10.0.2.2";
	SERVERPORT=4444;
	this.logger = logger;
	}
	
 public static void cancel()
         {
         if(client!=null)
         {
        	 try {
				client.close();
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
         }
 
 
    public void run() {
         try {
        	 System.out.println("SS Connecting...");
             serverSocket = new ServerSocket();
             serverSocket.setReuseAddress(true);
             serverSocket.bind(new InetSocketAddress(SERVERPORT));
             while (true) {
            	  client = serverSocket.accept();
            	  System.out.println("S: Receiving...");
            	  try {
                      BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                      String str = in.readLine();
                      System.out.println("S: Received: '" + str + "'");
                      
                      logger.logAction("S: Received: '" + str + "'");
                     //Code Distributor is called
                      new CodeEvaluator(str).codeDistributor();
                    } catch(Exception e) {
                        System.out.println("S: Error");
                        logger.logAction("S:Error");
                        e.printStackTrace();
                    } finally {
                    	client.close();
                        System.out.println("S: Done.");
                    }

             }
              
         } catch (Exception e) {
             System.out.println("S: Error");
             logger.logAction("S:Error");
             e.printStackTrace();
         }
   
    
    }

}
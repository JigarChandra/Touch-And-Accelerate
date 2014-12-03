package tnaserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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

 class ReverseTCPDesktopServer implements Runnable{
    public   String SERVERIP ;
    public   int SERVERPORT ;
	private static ServerSocket serverSocket;
	private static Socket client;
private String stat;
	private PrintWriter out;
	
	//If ip and port is passed
	ReverseTCPDesktopServer(String ip,String port, ActivityLogger logger)
	{
	SERVERIP=ip;
	SERVERPORT=Integer.parseInt(port)+2;

	}
	//Default port 4444
	ReverseTCPDesktopServer(String port,String stat)
	{
	
SERVERPORT=Integer.parseInt(port)+2;
	this.stat=stat;
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
        	
             serverSocket = new ServerSocket();
             serverSocket.setReuseAddress(true);
             serverSocket.bind(new InetSocketAddress(SERVERPORT));
             while (true) {
            	 System.out.println("Start send..to "+SERVERPORT);
            	  client = serverSocket.accept();
            	  String status=stat;
            	  System.out.println("S: Sending status..."+stat);
            	  try {
                     
                    //  logger.logAction("Sending status'" + status+ "'");
                     //Code Distributor is called
                      
                      out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(client.getOutputStream())),true);
                      
                      out.write(status+"\n");
      			    out.flush();
                      
                      
                    } catch(Exception e) {
                        System.out.println("S: Error");
                        //logger.logAction("S:Error");
                        e.printStackTrace();
                    } finally {
                    	client.close();
                        System.out.println("S: Done.");
                    }

             }
              
         } catch (Exception e) {
             System.out.println("S: Error");
           //  logger.logAction("S:Error");
             e.printStackTrace();
         }
   
    
    }

}
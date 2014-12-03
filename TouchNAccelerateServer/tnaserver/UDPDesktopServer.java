package tnaserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;


class UDPDesktopServer implements Runnable{
	
    public static final String SERVERIP = "192.168.1.2";
    public static final int SERVERPORT = 4444;
         
    public void run() {
         try {
        	 System.out.println("S:SS Connecting...");
        	// Vari.tcommands.setText("S: Done.\n");
            // ServerSocket serverSocket = new ServerSocket(SERVERPORT);
             while (true) {
            	  
            	
            	  System.out.println("S: Receiving...");
            	  String text;
            	  int server_port = 4444;
            	  byte[] message = new byte[1500];
            	  DatagramPacket p = new DatagramPacket(message, message.length);
            	  DatagramSocket s = new DatagramSocket(server_port);
            	  s.receive(p);
            	String str = new String(message, 0, p.getLength());
            	 
            	
            
                      System.out.println("S: Received: '" + str + "'");
                      new CodeEvaluator(str).codeDistributor();
                      
             }
             } catch(Exception e) {
                        System.out.println("S: Error");
                        e.printStackTrace();
                    } finally {
                    	
                        System.out.println("S: Done.");
                    }
            	
             
              
        
         }
   
    
    }
    
    
    
   /*public static void main (String a[]) {
    	Thread desktopServerThread = new Thread(new TCPDesktopServer());
    	desktopServerThread.start();
    }*/

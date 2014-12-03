package tnaserver;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Random;
import java.security.SecureRandom;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Aniket
 */

 @SuppressWarnings("serial")
class ServerJFrame extends javax.swing.JFrame implements ActivityLogger {
	String stringrandom;
	public static String ip;
	static String port;
	public static String password;
	private Thread desktopServerThread2;
	private Thread desktopServerThread;
	 JOptionPane optionPane;
    JDialog dialog;
	  SystemTray tray = null;	TrayIcon trayIcon = null;
	private Thread desktopServerThread3;
	public ServerJFrame() {
		initComponents();
		
		
		this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    int confirmed = JOptionPane.showConfirmDialog(null,
                                    "Are you sure you want to exit?", "TNA Server",
                                    JOptionPane.YES_NO_OPTION);
                    if (confirmed == JOptionPane.YES_OPTION)
                    { exit(ServerJFrame.this);System.out.print("Exited re");}
                    
            }

			private void exit(ServerJFrame serverJFrame) {
				// TODO Auto-generated method stub
				 serverJFrame.dispose();
				 System.exit(0);
			}
    });
		
		
		
		
		
		
		System.out.println("creating instance");
        try{
            System.out.println("Setting look and feel");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
            System.out.println("Unable to set LookAndFeel");
        }
      
	
		if(SystemTray.isSupported()){
            System.out.println("System tray supported");
            tray=SystemTray.getSystemTray();

            Image image=Toolkit.getDefaultToolkit().getImage("ic_launcher.png");
            ActionListener exitListener=new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Exiting....");
                    
                    
                    close();
                    		
                    
                    
                    
             
                }
            };
            PopupMenu popup=new PopupMenu();
            MenuItem defaultItem=new MenuItem("Exit");
            defaultItem.addActionListener(exitListener);
            popup.add(defaultItem);
            defaultItem=new MenuItem("Open");
            defaultItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(true);
                    setExtendedState(JFrame.NORMAL);
                }
            });
            popup.add(defaultItem);
            trayIcon=new TrayIcon(image, "TNA Server", popup);
            trayIcon.setImageAutoSize(true);
        }else{
            System.out.println("system tray not supported");
        }
        addWindowStateListener(new WindowStateListener() {
            public void windowStateChanged(WindowEvent e) {
                if(e.getNewState()==ICONIFIED){
                    try {
                        tray.add(trayIcon);
                        setVisible(false);
                        System.out.println("added to SystemTray");
                    } catch (AWTException ex) {
                        System.out.println("unable to add to tray");
                    }
                }
        if(e.getNewState()==7){
                    try{
            tray.add(trayIcon);
            setVisible(false);
            System.out.println("added to SystemTray");
            }catch(AWTException ex){
            System.out.println("unable to add to system tray");
        }
            }
        if(e.getNewState()==MAXIMIZED_BOTH){
                    tray.remove(trayIcon);
                    setVisible(true);
                    System.out.println("Tray icon removed");
                }
                if(e.getNewState()==NORMAL){
                    tray.remove(trayIcon);
                    setVisible(true);
                    System.out.println("Tray icon removed");
                }
            }
        });
        setIconImage(Toolkit.getDefaultToolkit().getImage("ic_launcher.png"));

        setVisible(true);
     
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		
		
		
		
		
		
		
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")

	private void initComponents() {

		filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0),
				new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		lip = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		tport = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		lpassword = new javax.swing.JLabel();
		regeneratePassword = new javax.swing.JButton();
		connecttoclient = new javax.swing.JButton();
		clearscroll = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		scrolog = new javax.swing.JTextArea();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();

	
		
		
		
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setBackground(new java.awt.Color(255, 0, 0));
		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel1.setText("IP Adress :");

		lip.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		lip.setText("Receiving Local IP Adress");
		try {
			lip.setText(InetAddress.getLocalHost().getHostAddress());
		} catch (Exception e) {
			lip.setText("Error Receiving Local IP Adress");
		}
		lip.setToolTipText("Enter the IP in your Client");

		jLabel3.setBackground(new java.awt.Color(255, 0, 0));
		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel3.setText("Port :");

		tport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		tport.setText("4444");
		tport.setToolTipText("Default : 4444");

		jLabel4.setBackground(new java.awt.Color(255, 0, 0));
		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel4.setText("Password :");

		lpassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		lpassword.setText("password");
		lpassword.setToolTipText("Enter the IP in your Client");
		try {
			stringrandom = new RandomString(3).nextString();
			lpassword.setText(stringrandom);
		} catch (Exception e) {
		}
//Password
		regeneratePassword.setText("Regenerate Password");
		regeneratePassword.setToolTipText("Press to regenerate password");
		regeneratePassword
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						regeneratePasswordActionPerformed(evt);
					}
				});

		connecttoclient.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		connecttoclient.setText("Connect");
		connecttoclient.setToolTipText("Open port for connection");
		connecttoclient.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				connecttoclientActionPerformed(evt);
			}
		});

		clearscroll.setText("Disconnect");
		clearscroll.setEnabled(false);
		clearscroll.setToolTipText("Clear Scrollable log");
		clearscroll.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clearscrollActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												114,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												lip,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												383,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jLabel3,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																114,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																jLabel4,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																114,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																tport,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																359,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																lpassword,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																374,
																																javax.swing.GroupLayout.PREFERRED_SIZE)))))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(34,
																				34,
																				34)
																		.addComponent(
																				regeneratePassword)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				connecttoclient,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				236,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				clearscroll,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				133,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabel1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(lip))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jLabel3,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																tport,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																28,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabel4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																35,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lpassword,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																35,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																regeneratePassword,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																46,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																connecttoclient,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																46,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																clearscroll,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																46,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(22, Short.MAX_VALUE)));

		lip.getAccessibleContext().setAccessibleName("lip");
		tport.getAccessibleContext().setAccessibleName("tport");
		lpassword.getAccessibleContext().setAccessibleName("lpassword");

		jScrollPane1
				.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setToolTipText("Log");
		jScrollPane1
				.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

		scrolog.setEditable(false);
		scrolog.setColumns(20);
		scrolog.setRows(5);
		scrolog.setName("jscroll"); // NOI18N
		jScrollPane1.setViewportView(scrolog);
		scrolog.getAccessibleContext().setAccessibleName("jscroll");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout.createSequentialGroup()
						.addComponent(jScrollPane1).addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout
						.createSequentialGroup()
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 282,
								Short.MAX_VALUE).addContainerGap()));

		jScrollPane1.getAccessibleContext().setAccessibleName("scrolog");

		jMenu1.setText("File");
		jMenuBar1.add(jMenu1);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(364, Short.MAX_VALUE)
								.addComponent(filler1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(274, 274, 274))
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(jPanel2,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addContainerGap())
				.addGroup(
						layout.createSequentialGroup()
								.addGap(19, 19, 19)
								.addComponent(jPanel1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										15, Short.MAX_VALUE)
								.addComponent(filler1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)));


		
	
		java.net.URL url = ClassLoader.getSystemResource("ic_launcher.png");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.createImage(url);
		setIconImage(img);	
		
	setTitle("Touch And Accelerate Server ");
	
	
		pack();
	}

	 
	//Click on Regenerate  Button
	
	private void regeneratePasswordActionPerformed(
			java.awt.event.ActionEvent evt) {
		try {
			stringrandom = new RandomString(3).nextString();
			lpassword.setText(stringrandom);
		} catch (Exception e) {
		}
		
	}
	
	public static String getPort()
	{
		return port;
	}
	//Click on Connect  Button 
	private void connecttoclientActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_connecttoclientActionPerformed
		scrolog.setText("");

		
		//setState(Frame.ICONIFIED);
		
		
		ip = lip.getText();
		port = tport.getText();
		password = lpassword.getText();
		scrolog.append(ip + " : " + port + " : " + password + "\n");
//Start all the threads
		
		desktopServerThread = new Thread(new TCPDesktopServer(ip, port, this));
		desktopServerThread.start();
		  desktopServerThread2 = new Thread(new TCPImageConnection(this));
		  desktopServerThread2.start();
		  
		  
		
		connecttoclient.setEnabled(false);
		regeneratePassword.setEnabled(false);
		clearscroll.setEnabled(true);
		
		
	}

	public void updateText(String s) {
		validate();//Revalidated used to update the GUI
	}

	
	//Disconnect Button pressed
	@SuppressWarnings("static-access")
	private void clearscrollActionPerformed(java.awt.event.ActionEvent evt) {

		
		scrolog.setText("");

/*
		try {
		//CODE TO REMOVE BINDING OF THE PORTS
			
			desktopServerThread = new Thread(new TCPDesktopServer(ip, port, this));
			desktopServerThread.start();
			  desktopServerThread2 = new Thread(new TCPImageConnection(this));
			  desktopServerThread2.start();
			  
			
			 
		} catch (Exception e) {
			
			e.printStackTrace();
		}*/
	

		connecttoclient.setEnabled(true);
		regeneratePassword.setEnabled(true);
		clearscroll.setEnabled(false);
	close();

	}

void close()
{
	   optionPane = new JOptionPane(
      		 "Are you sure you want to exit?",
      	    JOptionPane.QUESTION_MESSAGE,
      	    JOptionPane.YES_NO_OPTION); 

      dialog = optionPane.createDialog(getParent(), 
      		"Sure? ");
      		dialog.setVisible(true);
      	
      		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      		switch (((Integer)optionPane.getValue()).intValue())
      		{
      		case JOptionPane.YES_OPTION:
      		System.out.println("I have selected yes");
      		
      	       System.exit(0);
      		
      		break;
      		case JOptionPane.NO_OPTION:
      		System.out.println("I have selected no");
      		break;
      		}
      		
}
	public static void main(String args[]) {


		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ServerJFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ServerJFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ServerJFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ServerJFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		
		
		
		
		
		
		
		
		
		
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ServerJFrame().setVisible(true);
				
				
			
				
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.Box.Filler filler1;
	private javax.swing.JButton regeneratePassword;
	private javax.swing.JButton connecttoclient;
	private javax.swing.JButton clearscroll;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel lip;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel lpassword;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea scrolog;
	private javax.swing.JTextField tport;

	// End of variables declaration//GEN-END:variables
	@Override
	//Add log to scrolog
	public void logAction(String message) {

		scrolog.append(message + "\n");
		scrolog.setCaretPosition(scrolog.getDocument().getLength());
	}

}
//Generating Random string using secure random
class RandomString {

	/* Assign a string that contains the set of characters */
	private static final String symbols = "ABCDEFGJKLMNPRSTUVWXYZ0123456789";
	private final Random random = new SecureRandom();
	private final char[] buf;
	public RandomString(int length) {
		if (length < 1)
			throw new IllegalArgumentException("length < 1: " + length);
		buf = new char[length];
	}
	public String nextString() {
		for (int idx = 0; idx < buf.length; ++idx)
			buf[idx] = symbols.charAt(random.nextInt(symbols.length()));
		return new String(buf);
	}

}
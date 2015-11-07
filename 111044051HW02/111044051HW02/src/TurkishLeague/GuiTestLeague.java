package TurkishLeague;



import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.AttributedCharacterIterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GuiTestLeague {
	private Button btnPlay;   // Declare component Button
	private Button btnSave;
	private Button btnRead;
	private Button newGame;
	private Button btnAddTeam;
	private Button btnRemoveTeam;
	private Button btnExit;
	private Button btnAddPlayer;
	private Button btnRemovePlayer;
	
	private String board = new String();
	private JFrame jf;
	private JFrame jfAddTeam;
	private Container cAddTeam;
	private Container c;
	private JLabel label;
	private JTextArea tArea ;
	private TurkishLeague league;
	
	public void GameOfLifeGui() throws IOException
	{

		
		//board=obje.displayTheBoard();
		//System.out.print(board);

	    jf = new JFrame("Sportoto Süper Lig");
	    //jf.setBackground(Color.GREEN);
	    jf.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("test.jpg")))));
	  
	    c = jf.getContentPane();

	    board=null;
	    btnPlay = new Button("Play");
	    btnPlay.setLocation(0, 0);
	    btnPlay.setSize(100, 30);
	    btnPlay.setForeground(Color.red);
	    btnPlay.setBackground(Color.YELLOW);

	   
	    
	    btnAddPlayer = new Button("AddPlayer");
	    btnAddPlayer.setLocation(0, 35);
	    btnAddPlayer.setSize(100, 30);
	    btnAddPlayer.setForeground(Color.red);
	    btnAddPlayer.setBackground(Color.YELLOW);
	    
	    
	    btnRemovePlayer = new Button("RemovePlayer");
	    btnRemovePlayer.setLocation(0, 75);
	    btnRemovePlayer.setSize(100, 30);
	    btnRemovePlayer.setForeground(Color.red);
	    btnRemovePlayer.setBackground(Color.YELLOW);
	    
	    btnSave = new Button("Save the Game");
	    btnSave.setLocation(105,0);
	    btnSave.setSize(100, 30);
	    btnSave.setForeground(Color.red);
	    btnSave.setBackground(Color.YELLOW);
	    
	    btnRead = new Button("Read Game");
	    btnRead.setSize(100, 30);
	    btnRead.setLocation(210,0);
	    btnRead.setForeground(Color.red);
	    btnRead.setBackground(Color.YELLOW);
	    
	    newGame = new Button("New Game");
	    newGame.setSize(100, 30);
	    newGame.setLocation(315,0);
	    newGame.setForeground(Color.red);
	    newGame.setBackground(Color.YELLOW);
	    
	    btnAddTeam = new Button("Add Team");
	    btnAddTeam.setSize(100, 30);
	    btnAddTeam.setLocation(425,0);
	    btnAddTeam.setForeground(Color.red);
	    btnAddTeam.setBackground(Color.YELLOW);
	    
	    btnRemoveTeam = new Button("Remove Team");
	    btnRemoveTeam.setSize(100, 30);
	    btnRemoveTeam.setLocation(535,0);
	    btnRemoveTeam.setForeground(Color.red);
	    btnRemoveTeam.setBackground(Color.YELLOW);
	    
	    btnExit = new Button("Exit Game");
	    btnExit.setSize(100, 30);
	    btnExit.setLocation(640,0);
	    btnExit.setForeground(Color.red);
	    btnExit.setBackground(Color.YELLOW);
	
	    
	    
	    btnPlay.addActionListener(new ActionListener(){
	    
	    
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
					if(board==null || board=="okuma yapiniz")
						board="okuma yapiniz";
					else		
					board=league.playGame();
			
				System.out.print("board + "+ board + "\n");
				
				tArea.setBackground(Color.green);
				tArea.setForeground(Color.BLACK);
				
				tArea.setText(board);
				
				
				
					

				
				//tArea.setVisible(true);
				
			}
		});
	    
	    btnRead.addActionListener(new ActionListener(){
		    
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					league= new TurkishLeague();
					tArea.setText("Okuma Baþarýlý\n");
					league.gameScheudule2();
					board="okuma yapildi";
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					tArea.setText("Okuma Basarýsýz Dosyalar eksik\n");
				}
				
				
				
				
				
			}
		});
	    

	    btnSave.addActionListener(new ActionListener(){
		    
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				//obje.writeTheFile();
			
					tArea.setText("Saving Game on File !!!\n");
					board="Saving Game on File !!!\n";
					try {
						league.saveSchedule();
						
					} catch (FileNotFoundException | UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						tArea.setText("Something went wrong  !!!\n");
					}
					try {
						league.saveScoreTables();
					} catch (FileNotFoundException | UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						tArea.setText("Something went wrong  !!!\n");
					}
					try {
						league.saveTeams();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
					try {
						league.savePuanDurumu();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						tArea.setText("Something went wrong  !!!\n");
					}
				
		
			}
		});
	    newGame.addActionListener(new ActionListener(){
		    
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int year= league.getYear();
				try {
					league= new TurkishLeague();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					tArea.setText("Something went wrong  !!!\n");
				}
				league.setYear(year+1);
				league.gameScheudule2();
			
				board="Yeni oyun basliyor";
				
				
			}
		});
	    btnAddTeam.addActionListener(new ActionListener(){
		    
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jfAddTeam = new JFrame("ADD TEAM");
				jfAddTeam.setBackground(Color.GREEN);
			    try {
					jfAddTeam.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("add.jpg")))));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    cAddTeam = jfAddTeam.getContentPane();
				JTextArea text= new JTextArea();
				text.setLocation(50, 30);
				text.setSize(300, 30);
			    
			    Button btnOkey = new Button("EnterTeam Name");
			    btnOkey.setLocation(50, 0);
			    btnOkey.setSize(100, 30);
			    btnOkey.setForeground(Color.red);
			    btnOkey.setBackground(Color.YELLOW);
			    
			    btnOkey.addActionListener(new ActionListener(){
				    
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						String fileName= text.getText();
						Team t= new Team();
						try {
							t.readData(fileName);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							league= new TurkishLeague();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//league.gameScheudule2();
						league.AddTeam(t);
						
						jfAddTeam.setVisible(false);
					}
				});
			    
			    
			  //  jfAddTeam.setBackground(Color.red);
			    jfAddTeam.setLayout(null);  // reset layout manager for absolute positioning
			    jfAddTeam.setResizable(true);
			    jfAddTeam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    
			    cAddTeam.add(btnOkey);
			    cAddTeam.add(text);

			    jfAddTeam.setSize(500, 150);
			    jfAddTeam.setVisible(true);

				
			}
		});
	    
	    btnRemoveTeam.addActionListener(new ActionListener(){
		    
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jfAddTeam = new JFrame("Remove TEAM");
				jfAddTeam.setBackground(Color.GREEN);
			    try {
					jfAddTeam.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("delete.jpg")))));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    cAddTeam = jfAddTeam.getContentPane();
				JTextArea text= new JTextArea();
				text.setLocation(50, 30);
				text.setSize(300, 30);
			    
			    Button btnOkey = new Button("Enter Team name");
			    btnOkey.setLocation(50, 0);
			    btnOkey.setSize(105, 30);
			    btnOkey.setForeground(Color.red);
			    btnOkey.setBackground(Color.YELLOW);
			    
			    btnOkey.addActionListener(new ActionListener(){
				    
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						String teamName= text.getText();
						if(teamName==null)
							text.nextFocus();
						
						Team t= new Team();
					
							try {
								league= new TurkishLeague();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					
						//league.gameScheudule2();
						league.removeTeam(teamName);
						
						jfAddTeam.setVisible(false);
					}
				});
			    
			    
			    jfAddTeam.setBackground(Color.red);
			    jfAddTeam.setLayout(null);  // reset layout manager for absolute positioning
			    jfAddTeam.setResizable(true);
			    jfAddTeam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    
			    cAddTeam.add(btnOkey);
			    cAddTeam.add(text);
			    jfAddTeam.setSize(500, 150);
			    jfAddTeam.setVisible(true);
			    

				
			}
		});
	    btnExit.addActionListener(new ActionListener(){
		    
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);	
			}
		});
	    //label= new JLabel(new ImageIcon(ImageIO.read(new File("test.jpg"))));
	    //label.setLayout( new BorderLayout() );
	    tArea = new JTextArea(10, 100);
	    //tArea.setText(board);
	    tArea.setEditable(false);
	    tArea.setVisible(true);
	    tArea.setFont(new Font(Font.MONOSPACED, Font.HANGING_BASELINE, 12));
	    tArea.setSize(700,350);
	    tArea.setLocation(100, 30);
	    tArea.setText("Oyun basliyor !!!\n");
	    tArea.setForeground(Color.RED);
	    tArea.setBackground(Color.GREEN);
	    

	    //label.add(tArea);
	    //tArea.setBounds(104,34, fwidth-10, fheight-10);  // arbitrary size
	    
	    //jf.setBackground(Color.red);
	    jf.setLayout(null);  // reset layout manager for absolute positioning
	    jf.setResizable(true);
	    
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    c.add(btnPlay);
	    c.add(btnSave);
	    c.add(btnRead);
	    c.add(newGame);
	    c.add(btnAddTeam);
	    c.add(btnRemoveTeam);
	    c.add(btnAddPlayer);
	    c.add(btnRemovePlayer);
	    c.add(btnExit);
	    c.add(tArea);
	    c.setBackground(Color.darkGray);
	   
	    jf.setSize(1000, 500);
	    jf.setVisible(true);
	   


	  } 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		GuiTestLeague guiTest= new GuiTestLeague();
		guiTest.GameOfLifeGui();
	}

}

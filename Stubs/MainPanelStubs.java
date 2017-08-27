   //Victor Wang, Will Xu, Turner Arndt
   //version 8.1.2011
   
   import javax.swing.*;			//The JComponent class
   import java.awt.*;				//The Graphics  class
   import java.awt.event.*;		//The Listener class
	
    public class MainPanelStubs extends JPanel
   {
      private Gameboard board;
      private Scoreboard score;
   
   
   
       public MainPanelStubs()
      {
      //The main panel holds the gameBoard, the Scoreboard,
      //and the buttons to pause and quit.
      //The main panel has a border layout with the gameBoard in the center
      //scoreboard in the north, and the buttons in the south.
      //The main panel also has two key listeners.
      //If p on the keyboard is pressed, then the game is paused.
      //If the escape key is pressed, then the game ends.
      
         board = new Gameboard();
         score = new Scoreboard();
         
         setLayout(new BorderLayout());
         addKeyListener(new Key1());
         JButton Pause = new JButton("Pause");
         Pause.addActionListener(new Listener1());
         JButton Quit = new JButton("Quit");
         Quit.addActionListener(new Listener2());
         
         JPanel subPanel = new JPanel();
         subPanel.setLayout(new FlowLayout());
         subPanel.add(Pause);
         subPanel.add(Quit);
         add(subPanel, BorderLayout.SOUTH);
         add(board, BorderLayout.CENTER);
         add(score, BorderLayout.NORTH);
      
      	
      }
      
       private class Key1 extends KeyAdapter
      {
      
          public void keyPressed(KeyEvent e)
         {
         //If p on the keyboard is pressed, then the game is paused.
         //If the escape key is pressed, then the game ends.
         }
      }
   		
   
   
       public class Listener1 implements ActionListener
      {
      
          public void actionPerformed(ActionEvent a)
         {
         //If the pause button on the screen is pressed, then the game is paused.
         }
      }
      
       public class Listener2 implements ActionListener
      {
      
          public void actionPerformed(ActionEvent b)
         {
            //If the Quit button is pressed, then the game ends.
         }
      }
   
   }

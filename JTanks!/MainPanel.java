//Victor Wang, Will Xu, Turner Arndt
//version 8.4.2011  
   import javax.swing.*;//imports the JComponent 
   import java.awt.*;//imports Graphics 
    public class MainPanel extends JPanel
   {
   	//We made board and score, so we could access methods and displayes from both panels
      private static GameBoard board; 
      private static Scoreboard score;
       public MainPanel()
      {
         //We instansiated board and score, so we can use them.
         score = new Scoreboard();
         board = new GameBoard();
         //We set the layout as a BorderLayout.
         setLayout(new BorderLayout());
         
         //A JLabel named quit was made to place instructions about how to quit and pause the
      	//game
         JLabel Quit = new JLabel();
         Quit.setText("<HTML><center>Press P to Pause and display Instructions and <br> press Escape to Quit</center></HTML>");
         Quit.setFont(new Font("Arial", Font.BOLD, 45));
      	//board was set to Focusable because that was where the tank moved and shot.
         board.setFocusable(true);
      	//the quit label was added to the bottom of the Jpanel
      	//The Gameboard was added to the center
      	//and the scoreboard was added the the top
         add(Quit, BorderLayout.SOUTH);
         add(board, BorderLayout.CENTER);
         add(score, BorderLayout.NORTH);
      }
      //The methods below used the gameboard to retreive the Score and Lives
   	//then the Score and Lives are displayed onto the scoreboard.
       public static void setScore()
      {
         score.setScore(board.getScore());
      }	
       public static void setLives()
      {
         score.setLives(board.getLives());
      } 
   }
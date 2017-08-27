//Victor Wang, Will Xu, Turner Arndt
//version 8.4.2011
   import java.awt.*;  //imports the Graphics
   import javax.swing.*;	//imports JComponents
    public class Scoreboard extends JPanel
   {
      private JLabel lives, score;//the JLabel lives displayed the number of lives left on  
     										 // the tank, and score displayed the score.
      private static JLabel level;// the JLabel level shows what level the game is on. 
     										 // We made it static so we could reference level from
   										 // the GameBoard. 
       public Scoreboard()
      {
         setLayout(new FlowLayout());
         //We set the Layout of our Scoreboard Panel as a FlowLayout
         //Here we instansiated all the JLabels, spaced them, changed their font and size,
      	//and added them to the panel
         lives = new JLabel("Lives: 3         ", SwingConstants.CENTER);
         lives.setForeground(Color.red);
         lives.setFont(new Font("Arial", Font.BOLD, 50));
         add(lives);
         level = new JLabel("Level: 1         ", SwingConstants.CENTER);
         level.setForeground(Color.red);
         level.setFont(new Font("Arial", Font.BOLD, 50));
         add(level);
         score = new JLabel("Score: 0", SwingConstants.CENTER);
         score.setForeground(Color.red);
         score.setFont(new Font("Arial", Font.BOLD, 50));
         add(score);
      }
   	//This method displayed the updated lives of the tank after it died
       public void setLives(int x)
      {
         lives.setText("Lives: "+x+"       ");
      }
   	//This method displayed the updated level.
   	
       public static void setLevel(int x)
      {
         level.setText("Level: "+x+"       ");
      }
      //This method displayed the updated Score of the tank everytime a tank fired, died, 
   	// or killed a turret.
       public void setScore(int x)
      {
         score.setText("Score: " + x);
      }
   }
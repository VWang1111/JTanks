 //Victor Wang, Will Xu, Turner Arndt  
 //version 8.1.2011
	
	import java.awt.*;         //The Graphics  class
   import javax.swing.*;      //The JComponent class
    public class ScoreboardStubs extends JPanel
   {
      private JLabel lives, score;
        	
       public ScoreboardStubs()
      {	
		
			//Scoreboard has a flow layout
			//It has a Jlabel to display to the size
			//and another Jlabel to deisplay the score
                        
         setLayout(new FlowLayout());
			lives = new JLabel("Lives: 3");
         lives.setForeground(Color.red);
         add(lives);
         score = new JLabel("Score: 0");
         score.setForeground(Color.red);
         add(score);
         
      }
       public void setLives(int x)
      {		
			// Sets the amount of lives to be displayed     	
      }
      
       public void setScore(int x)
      {
      
         // Sets the score to be displayed     
      
      }
   	
   }
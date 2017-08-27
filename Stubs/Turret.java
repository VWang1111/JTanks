  //Will Xu, Victor Wang, Turner Arndt
	//version 8.1.11
	
	import javax.swing.*;		//JComponent Class
   import java.awt.*;			//Graphics Class

    public class Turret extends Crosshair
   {
      private static final int defaultXPos=0;
      private static final int defaultYPos=0;
      private static final int defaultRadius=25;
      private int xPos;
      private int yPos;
      private int myLevel;
      private ImageIcon myImage;
      private boolean IsAlive = true;
   
   
   	//constructors
       public Turret()
      {
         //calls Crosshair and the position of x and y to the default of Crosshair's contructor
      }
      
       public Turret(int x, int y)
      {
         //calls Crosshair and sets x and y to what we want
      }
   	
       public Turret(int x, int y, int l)
      {
         //sets x and y position by calling Crosshair
      	//sets the level/difficulty of the turret
      }
   	
       public Turret(int x, int y, int l, ImageIcon e)
      {
      	//sets the x and y of turret and the Image by calling Crosshair
      	//sets the difficulty of turret
      }
   	
       public Turret(int x, int y, ImageIcon e)
      {
         //sets the x, y and image of the turret
      }
   	
   	//accessors and modifiers
   	
       public int getX()
      {
      	//returns the x position of the turret
         return 1;
      }
   	
       public int getY()
      {
         
      	//returns the y position of the turret
         return 1;
      }
   	
       public int getLevel()
      {
      	//returns the difficulty of the turret      
         return 1;
      }
   	
       public void setX(int x)
      {
      	//changes the x position of the turret     
      }
   	
       public void setY(int y)
      {
         //changes the y position of the turret
      }
   	
       public void setLevel(int l)
      {
         //changes the difficulty of the turret
      	//color changes based on difficulty
      }
   	
   	//methods
   	
       public void draw(Graphics g)
      {
      	//checks to see if the bullet is still alive
      	//if it is, it then
        //draws the turret at its current position 
        //fills the color of the turret based on difficulty
         
      }
       private double distance(double x1, double y1, double x2, double y2)
      {
      	      
      	//returns the distance between turret and the tank
         return 1;  
      }
      
       public boolean inRange(Tank tank)
      {
         //checks to see whether or not the tank is in range of the turret
      	//returns whether or not the tank is close enough to be shot at
         return false;
      }
       public void disappear()
      {
         //sets isAlive to false so the turret does not get redrawn when it gets hit
      }
   
       public boolean alive()
      {
      	//goes to isAlive and returns whether or not the turret is still alive
         return false;
      }
   	
   
   
   }
	

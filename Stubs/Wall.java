     //Will Xu, Victor Wang, Turner Arndt
	//version 8.1.11
	
	import javax.swing.*;		//JComponent Class
   import java.awt.*;			//Graphics Class

    public class Wall{
      private int xPos, yPos, Height, Width;
       public Wall()
      {
         //default constructor
      	//sets X, Y, Height and Width to 0
      }
   
       public Wall(int x, int y,  int w, int h)
      {
         //constructor that gives us the most flexiblity
      	//can set the X, Y, Height and Width of the walls
      
      }
       public Wall(int x, int y)
      {
         //constructor that sets the X and Y coordinates
      	//Height and Width are set at 50 and 150 respectively
      }
   
       public int getXPos()
      {
      	//returns the position of the X coordinate
         return 1;
      }
       public int getYPos()
      {
      	//returns the Y position of the wall      
         return 1;
      }
       public int getHeight()
      {
      	//returns the Height of the wall      
         return 1;
      }
       public int getWidth()
      {
      	//returns the width of the wall      
         return 1;
      }
   
       public void setXPos(int x)
      {
      	//sets the X position of the wall
      
      }
       public void setYPos(int y){
      	//sets the Y position of the wall
      
      }	
       public void setHeight(int h)
      {
      	//sets the Height of the wall
      
      }
       public void setWidth(int w)
      {
      //sets the Width of the wall
      
      }
   
       public void draw(Graphics g)
      {
      	//draws the wall
      	//uses the wall's accessor methods to draw it    
      
      }
      
       public boolean inBumper(Tank arg)
      {
         //uses the distance formula to check whether the tank is in the wall or not
      	//returns whether or not the tank is in the wall or not          
         return false;
      }
       
       public boolean inBumper(Bullet arg)
      {
        	//uses the distance formula to check whethere the bullet is in the wall
      	//returns whether the bullet is in the wall or not            
         return false;
      }
   		
       private double distance(double x1, double y1, double x2, double y2)
      {
      	//returns the distance between two objects
         return 1;
      }
   }
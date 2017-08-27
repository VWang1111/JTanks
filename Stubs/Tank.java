  //Will Xu, Victor Wang, Turner Arndt
	//version 8.1.11
	
	import javax.swing.*;		//JComponent Class
   import java.awt.*;			//Graphics Class
   
	
    public class Tank extends Crosshair
   {
      private static final int defaultWidth=75;
      private static final int defaultHeight=75;
      private int myLevel;
      private ImageIcon myImage;
      private int myWidth;
      private int myHeight;
      private int myScore;
      private int myLives;
      private Color myColor;
   
       public Tank()
      {
         //calls Crosshair to set X and Y to default
      	//then sets Width and Height to default that is written above
      }
      
       public Tank(int x, int y)
      {
         //sets the X and Y position of the tank
      	//sets Width and Height to default
      }
   	
       public Tank(int x, int y, int l)
      {
         //sets the X and Y position of the tank
      	//sets Width and Height to default    
      	//sets the level of the tank(planned for upgrades)  
      }
   	
       public Tank(int x, int y, int l, ImageIcon e)
      {
         //sets the X and Y position of the tank
      	//sets Width and Height to default    
      	//sets the level of the tank(planned for upgrades) 
      	//sets the image of the tank 
      }
   	
       public Tank(int x, int y, int l, Color c, ImageIcon e)
      {
         //sets the X and Y position of the tank
      	//sets Width and Height to default    
      	//sets the level of the tank(planned for upgrades) 
      	//sets the image of the tank and the color of the tank
      }
   	
       public Tank(int x, int y, ImageIcon e)
      {
         //sets the X and Y position of the tank
      	//sets Width and Height to default     
      	//sets the image of the tank
      }
   	
       public Tank(int x, int y, ImageIcon e, Color c)
      {
         //sets the X and Y position of the tank
      	//sets Width and Height to default    
      	//sets the image of the tank and the color of the tank
      }
   	
       public Tank(int x, int y, int Width, int Height, ImageIcon e, Color c)
      {
         //sets the X and Y position of the tank
      	//sets Width and Height of the tank  
      	//sets the image of the tank and the color of the tank
      }
   
   	
        	
       public int getLevel()
      {
      	//returns what level the tank is on(planned for upgrades)
         return 1;
      }
   	
       public int getWidth()
      {
      	//returns the Width of the tank
         return 1;
      }
   	
       public int getHeight()
      {
      	//returns the Hieght of the tank      
         return 1;
      }
   	
       public Color getColor()
      {
      	//returns the color of the tank
         return Color.blue;
      }
   	
       public int getLives()
      {
      	//returns the number of lives remaining on the tank
         return 1;
      }
   	
       public int getScore()
      {
      	//returns the score of the tank
         return 1;
      }
   	
       public void setLevel(int l)
      {
         //sets the level of the tank(intended for upgrades)
      }
   	
       public void setWidth(int width)
      {
         //sets the Width of the tank
      }
   		
       public void setHeight(int height)
      {
         //changes the Height of the tank
      }
   	
       public void setColor(Color c)
      {
         //changes the color of the tank
      }
   	
       public void setLives(int l)
      {
         //sets the number of lives you have
      }
   	
       public void setScore(int s)
      {
         //sets the score of the tank
      }
   	
   	
       public void draw(Graphics g)
      {
         //uses graphics to draw tank
      	//(probably going to change into an image icon soon)
      }
   	
       public void collideWithWall(Wall[] bumper)
      {
        //checks to see if tank is coliding with a wall.
        //if it is, it will not let it continue moving that way
      }   
   }
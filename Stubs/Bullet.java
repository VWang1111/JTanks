   //Will Xu, Victor Wang, Turner Arndt
	//version 8.1.11
	
	import javax.swing.*;		//JComponent Class
   import java.awt.*;			//Graphics Class

    public class Bullet
   {
   	//Fields
      private static final int defaultSpeed = 10;
      private static final int defaultRadius = 5;
      private static final double defaultDx = 1;
      private static final double defaultDy = 1;
      private int mySpeed, myXPosition, myYPosition, count = 0;
      private double myDx, myDy;
      private ImageIcon myImage;
      private boolean isAlive = true;
   
   	//Constructors
       public Bullet()
      {
         //default constructor, sets mySpeed, myXPosition, myYPosition, myDx, myDy to default
         
      }
   
       public Bullet(int x, int y)
      {
        //constructor that sets the bullet's myXPosition and myYPostion, 
        //everything else is the same as the default
        
      
      }
   
       public Bullet(int s, int x, int y)
      {
        //constructor to set the mySpeed of the bullet
        //the myXPosition
        //and the myYPosition
         
      }
   	
       public Bullet(int x, int y, double dx, double dy)
      {
         // constructor to set the myXPosition and myYPositions
      	//as well as the myDx and myDy positions
      
      }
   	
   	
       public Bullet(int s, int x, int y, double dx, double dy)
      {
        //constructor used to set mySpeed,
        //the myXPosition and myYPosition
        //and the myDx and myDy position
      
      }
   	
       public Bullet(int x, int y, ImageIcon i)
      {
      	//constructor used to set the myXPosition and myYPosition
      	//and to set an image to the bullet.
      
      }
   	
       public Bullet(int s, int x, int y, ImageIcon i)
      {
      	//constructor able to set the mySpeed
      	//the myXPosition and myYPosition coorandiates
      	//and the image
      
      }
   	
       public Bullet(int s, int x, int y, double dx, double dy, ImageIcon i)
      {
      	//final constructor used to set the mySpeed
      	//the myXPosition and myYPositions
      	//the myDx and myDy positions
      	//and the image of the bullet      
      
      }
      
   	//modifiers
       public void setSpeed(int s)
      {
         //used to change the mySpeed of the bullet
      }
      
       public void setX(int x)
      {
         //change the starting myXPosition of the bullet
      }
   	
       public void setY(int y)
      {
         //change the starting myYPosition of bullet
      }
      
       public void setImage(ImageIcon i)
      {
        //change the image of the bullet
      }
   	
       public void setDx(double dx)
      {
         //sets the myDx of the bullet
      }
   	
       public void setDy(double dy)
      {
         //sets the myDy of the bullet
      }
      
   	//Accessors
       public int getSpeed()
      {
      	//gets the mySpeed of the bullet
         return 1;
      }
   	
       public int getX()
      {
      	//gets the myXPositon of the bullet
         return 1;
      }
   	
       public int getY()
      {
      	//get the myYPosition of the bullet      
         return 1;
      }
   	
       public double getDx()
      {
      	//gets the myDx of where the bullet is heading      
         return 1;
      }
   	
       public double getDy()
      {
      	//get the myDy of where the bullet is heading  
         return 1;
      }
      
       public int getRadius()
      {
         //gets the radius of the bullet to be used for hit methods and collide methods
         return 1;
      }
   	
   	//Instance Methods
       public void draw(Graphics g)
      {
         //if bullet is alive we need to redraw the bullet
      	//else if it is not alive we do nothing and have the background redraw and cover the bullet
      }
   	
       public void disappear()
      {
         //sets our alive variable to false so it does not get redrawn
      }
      
       public void move(Bullet bullet, Wall[] bumper)
      {
      	//we need to get the bullet to move forward until it hits a wall
      	//once the bullet hits a wall, it needs to bounce off
      	//after the bullet bounces off the wall 3 times,
      	//the bullet should disappear.
      }
      
       public boolean alive()
      {
      	//this will return where our alive variable for the bullet is really alive.
      	//if it is, it will continue to move, if now it will stop      
         return true;
      }
   }
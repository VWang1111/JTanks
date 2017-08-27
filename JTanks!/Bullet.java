   import javax.swing.*;
   import java.awt.*;
	/*****************************************************************
*Bullet is an object that knows its X and Y position, radius, speed, direction, 
*and Target. A Bullet knows how to return its X, Y, and radius, speed, direction, 
*and a Target. Bullet can also set its X, Y, radius, speed, direction, image, 
*a Target, the isAlive boolean, and the count. Crosshair knows how to draw itself,
*how to dissapear, how to move, and how to return if it is Alive or not.
@author Victor Wang, Will Xu, Turner Arndt @email 2014vwang@tjhsst.edu
@version 8.4.2011
*/

   public class Bullet
   {
      private static final int defaultRadius = 5; //Default speed
      private static final double defaultDx = 1;  //Default x direction
      private static final double defaultDy = 1;  //Default y direction	
   	//Bullets know how many times they bounced off the wall which is stored in variable
   	//count and a target which is stored in variable myTarget.
      private int count = 0, myTarget;
   	//Bullets' XPosition and YPosition is stored in myXPosition and myYPosition
      protected double myXPosition, myYPosition;
   	//Bullets' X direction and Y direction is stored in myDx and myDy
      private double myDx, myDy;
   	//Bullets' image is stored in myImage
      protected ImageIcon myImage;
   	//Bullets' boolean to tell if it is Alive or not is stored in
   	//boolean isAlive
      protected boolean isAlive = false;
      private boolean nyanCat = false;
      private ImageIcon nyancat = new ImageIcon("nyancatbullet.png");
   	
   	/**********************************
   	*Constructs a Bullet with an x and y of 0, its speed as 10, and its direction 
   	*as default.
   	*/ 
      public Bullet()
      {
         myXPosition = 0;
         myYPosition = 0;
         myDx = defaultDx;
         myDy = defaultDy;
      }
   		/**********************************
   	*Constructs a Bullet with xPosition specified by x, yPos specified by y, 
   	*its speed as 10, and its direction as default.
   	*@param x		initial x position
   	*@param y		initial y position
   	*/
      public Bullet(double x, double y)
      {
         myXPosition = x;
         myYPosition = y;
         myDx = defaultDx;
         myDy = defaultDy;
      }
   	/**********************************
   	*Constructs a Bullet with xPosition specified by x, yPos specified by y, 
   	*its speed as 10 and its direction specified by dx and dy.
   	*@param x		initial x position
   	*@param y		initial y position
   	*@param dx		inital of dx
   	*@param dy		inital of dy
   	*/
      public Bullet(double x, double y, double dx, double dy)
      {
         myXPosition = x;
         myYPosition = y;
         myDx = dx;
         myDy = dy;
      }
   	/**********************************
   	*Constructs a Bullet with xPosition specified by x, yPos specified by y,
   	*and an ImageIcon specified by i.
   	*@param x		initial x position
   	*@param y		initial y position
   	*@param i		initial ImageIcon
   	*/
      public Bullet(double x, double y, ImageIcon i)
      {
         myXPosition = x;
         myYPosition = y;
         myImage = i;
         myDx = defaultDx;
         myDy = defaultDy;
      }
   	/*********************
   	*Sets the x positon to input number
   	@param x		assigns x to xPosition
   	*/
      public void setX(double x)
      {
         myXPosition = x;
      }
   	/*********************
   	*Sets the y positon to input number
   	@param y		assigns y to yPosition
   	*/
      public void setY(double y)
      {
         myYPosition = y;
      }
      /*********************
   	*Sets the ImageIcon to the input image
   	@param i		assigns i to image
   	*/
      public void setImage(ImageIcon i)
      {
         myImage = i;
      }
   	/*********************
   	*Sets the dx to the input number
   	@param dx		assigns dx to direction dx
   	*/
      public void setDx(double dx)
      {
         myDx = dx;
      }
   	/*********************
   	*Sets the dy to the input number
   	@param dy		assigns dy to direction dy
   	*/
      public void setDy(double dy)
      {
         myDy = dy;
      }
   	/*********************
   	*Sets the isAlive boolean to the input boolean
   	@param a		assigns true or false to the isAlive boolean
   	*/
      public void setAlive(boolean a)
      {
         isAlive = a;
      }
      /*********************
   	*Sets the Target to the input number
   	@param t		assigns t to target
   	*/
      public void setTarget(int t)
      {
         myTarget = t;
      }
   	/*********************
   	*Sets the Count to the input number
   	@param c		assigns c to count
   	*/
      public void setCount(int c)
      {
         count = c;
      }
   	/*********************
   	*Returns the bullet's x position.
   	*@return xPosition
   	*/
      public double getX()
      {
         return myXPosition;
      }
   	/*********************
   	*Returns the bullet's y position.
   	*@return yPosition
   	*/
      public double getY()
      {
         return myYPosition;
      }
   	/*********************
   	*Returns the bullet's dx direction.
   	*@return myDx
   	*/
      public double getDx()
      {
         return myDx;
      }
   	/*********************
   	*Returns the bullet's dy direction.
   	*@return myDy
   	*/
      public double getDy()
      {
         return myDy;
      }
      /*********************
   	*Returns the bullet's radius.
   	*@return defaultRadius
   	*/
      public int getRadius()
      {
         return defaultRadius;
      }
      /*********************
   	*Returns the bullet's target.
   	*@return myTarget
   	*/
      public int getTarget()
      {
         return myTarget;
      }
   	/********************
   	*Method used to draw the Bullet.
   	*@param g		Draws the Bullet to the Graphics Object
   	*/
      public void draw(Graphics g)
      {
         if(isAlive)
         {
            if(nyanCat)
               g.drawImage(nyancat.getImage(), (int)(myXPosition-10), (int)(myYPosition+5), null);
            else
            {
               g.setColor(Color.BLACK);
               g.fillOval((int)(myXPosition-defaultRadius), (int)(myYPosition-defaultRadius), 10, 10);
            }
         }
      }
   	/********************
   	*Method used to make the Bullet dissapear.
   	*/
      public void disappear()
      {
         isAlive = false;
         setX(-50);
         setY(-50);
         setDx(0);
         setDy(0);
      }
      /********************
   	*Method used to make the Bullet move and to check to see if the Bullet 
   	*bounces off the wall.
   	*@param bumper		Check to see if the bullet hits the wall array bumper
   	*/
      public void move(Wall[] bumper)
      {
         setX(getX()+ myDx);
         setY(getY()+ myDy);
        
         for(int k = 0; k<bumper.length; k++)
            if(bumper[k].inBumper(this))
               if(!(getX() >= bumper[k].getXPos()+5&& getX() <= bumper[k].getXPos()
               +bumper[k].getWidth()-5))
               {
                  myDx = myDx * -1; 
                  count++;
               }
               else if(!(getY() >= bumper[k].getYPos()+5 && getY() <= bumper[k].getYPos()
               +bumper[k].getHeight()-5))
               {
                  myDy = myDy * -1;
                  count++;
               }
      		
         if(count >= 3 || myXPosition < 0 || myXPosition > 1000 || myYPosition < 0 ||
          myYPosition > 800)
            disappear();
      }
      /********************
   	*Method used to check if the Bullet if the bullet is Alive.
   	@return isAlive
   	*/
      public boolean alive()
      {
         return isAlive;
      }
      
      public void setNyan(boolean n)
      {
         nyanCat = n;
      }
   }
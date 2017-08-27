   import java.awt.*;
   import javax.swing.*;
   /* 
	* A Tank is a Crosshair that knows its width, height, score, and lives. It also
	* knows how to draw itself on a Graphics Object and check for a collision with a wall.
	* It can return it's private variables, as well as set its private variables through
	* accessor methods.
	* @author Turner Arndt, Victor Wang, Will Xu
	* @version 8.3.2011
	*/
    public class Tank extends Crosshair
   {
      private static final int defaultWidth=75;
      private static final int defaultHeight=75;
      private static final Color defaultColor = Color.yellow.darker();
      private int myWidth;
      private int myHeight;
   	//myScore is our variable that keeps track of the score of the game.    
      private int myScore = 0;
   	//myLives is how we kept track of the number of tries we gave the players.
   	//Everytime the player died, the myLives went down.						
      private int myLives = 3;
      private Color myColor;
   	/*
   	* Constructs a Tank with default width, height, color, and "radius"
   	*/
       public Tank()
      {
         super();
         myWidth=defaultWidth;
         myHeight=defaultHeight;
         myRadius=defaultWidth/2;
         myColor = defaultColor;
      }
   	/* 
   	* Constructs a Tank with initial x and y coordinates specified by x and y, default width,
		* height, "radius", and color.
   	* @param x   initial x coordinate
   	* @param y   initial y coordinate
   	*/
       public Tank(int x, int y)
      {
         super(x,y);
         myWidth=defaultWidth;
         myHeight=defaultHeight;
         myRadius=defaultWidth/2;
         myColor = defaultColor;
      }
   	/*
   	* Constructs a Tank with initial x and y coordinates specified by x and y, initial ImageIcon
		* specified by e, and default width, height, "radius", and color.
     	* @param x   initial x coordinate
   	* @param y   initial y coordinate
   	* @param e   initial ImageIcon
   	*/
       public Tank(int x, int y, ImageIcon e)
      {
         super(x,y,e);
         myWidth=defaultWidth;
         myHeight=defaultHeight;
         myRadius=defaultWidth/2;
         myColor = defaultColor;
      }
   	/*
   	* Constructs a Tank with initial x and y coordinates specified by x and y, initial Color
		* specified by c, initial ImageIcon specified by e, and default width, height, "radius",
		* and color.
   	* @param x   initial x coordinate
   	* @param y   initial y coordinate
   	* @param c   initial Color
   	* @param e   initial ImageIcon
   	*/
       public Tank(int x, int y, ImageIcon e, Color c)
      {
         super(x,y,e);
         myColor=c;
         myWidth=defaultWidth;
         myHeight=defaultHeight;
         myRadius=defaultWidth/2;
      }
   	/*
   	* Constructs a Tank with initial x and y coordinates specified by x and y, initial width
		* and height specified by Width and Height, initial ImageIcon specified by e. initial Color
		* specified by c, and default radius.
   	* @param x   initial x coordinate
   	* @param y   initial y coordinate
   	* @param Width   initial width
   	* @param Heightn initial height
   	* @param e   initial ImageIcon
   	* @param c   initial Color
   	*/
       public Tank(int x, int y, int Width, int Height, ImageIcon e, Color c)
      {
         super(x,y,e);
         myColor=c;
         myWidth=Width;
         myHeight=Height;
         myRadius=defaultWidth/2;
      }
   	/*
   	* Returns the Tank's width
   	* @return width
   	*/
       public int getWidth()
      {
         return myWidth;
      }
   	/*
   	* Returns the Tank's height
   	* @return height
   	*/
       public int getHeight()
      {
         return myHeight;
      }
   	/*
   	* Returns the Tank's color
   	* @return color
   	*/
       public Color getColor()
      {
         return myColor;
      }
   	/*
   	* Returns the Tank's lives
   	* @return lives
   	*/
       public int getLives()
      {
         return myLives;
      }
   	/*
   	* Returns the Tank's score
   	* @return score
   	*/
       public int getScore()
      {
         return myScore;
      }
   	/* 
   	* Sets the width of the Tank to the input number
   	* @param width
   	*/
       public void setWidth(int width)
      {
         myWidth=width;
      }
   	/* 
   	* Sets the height of the Tank to the input number
   	* @param height
   	*/
       public void setHeight(int height)
      {
         myHeight=height;
      }
   	/* 
   	* Sets the color of the Tank to the input color
   	* @param c
   	*/
       public void setColor(Color c)
      {
         myColor=c;
      }
   	/* 
   	* Sets the lives of the Tank to the input number
   	* @param l
   	*/
       public void setLives(int l)
      {
         myLives = l;
      }
   	/* 
   	* Sets the score of the Tank to the input number
   	* @param s
   	*/
       public void setScore(int s)
      {
         myScore = s;
      }
   	/*
   	* Draws the Tank at the x and y coordinates, which are set as the center of the tank.
   	* This method uses a try-catch to determine whether the Tank is assigned an ImageIcon.
   	* If it is, it will draw the ImageIcon. Otherwise, it will draw the default image, which
   	* is a square of the Tank's color. The Tank is drawn to the specified Graphics object.
   	* @param g   The Graphics object to be drawn to
   	*/
       public void draw(Graphics g)
      {
         try
         {
            g.drawImage(myImage.getImage(), xPos-myWidth/2, yPos-myHeight/2, null);
         }
             catch(NullPointerException e)
            {
               g.setColor(myColor);
               g.fillRect(xPos-myWidth/2,yPos-myHeight/2,myWidth, myHeight);
            }
      }
   	/*
   	* Checks to see if the Tank has collided with the wall. If it has, the Tank gets moved
		* so that it is not inside the wall. The method checks every wall that is in the wall
		* array argument it requires.
   	* @param bumper   The array of bumpers to be checked.
   	*/
       public void collideWithWall(Wall[] bumper)
      {
         for(int k = 0; k<bumper.length; k++)
            if(bumper[k].inBumper(this))
               if(xPos+myWidth/2 >= bumper[k].getXPos() && xPos+myWidth/2 <= bumper[k].getXPos()+10)
                  setX(bumper[k].getXPos()-myWidth/2);
               else if(xPos-myWidth/2 <= bumper[k].getXPos()+bumper[k].getWidth() && xPos-myWidth/2 >= bumper[k].getXPos()+bumper[k].getWidth()-10)
                  setX(bumper[k].getXPos()+bumper[k].getWidth()+myWidth/2);
               else if(yPos+myHeight/2 >= bumper[k].getYPos() && yPos+myHeight/2 >= bumper[k].getYPos()+10)
                  setY(bumper[k].getYPos()+bumper[k].getHeight()+myHeight/2);
               else if(yPos-myHeight/2 <= bumper[k].getYPos()+bumper[k].getHeight() && yPos-myHeight/2 <= bumper[k].getYPos()+bumper[k].getHeight()-10)
                  setY(bumper[k].getYPos()-myHeight/2);
      }
   }
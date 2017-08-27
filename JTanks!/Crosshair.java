   import java.awt.*;
   import javax.swing.*;
   import java.awt.event.*;
/*****************************************************************
*Crosshair is an object that knows its X and Y position and its Radius.
*A Crosshair knows how to return its X, Y, and Radius. 
*Crosshair can also set its X, Y, and Radius. 
*Crosshair knows how to draw itself.
@author Will Xu @email 2014wxu@tjhsst.edu
@version 8.3.2011
*/
    public class Crosshair
   {
      protected static final int defaultRadius = 20;
      protected int xPos, yPos, myRadius;
      protected ImageIcon myImage;
    	 /**********************************
   	 *Constructs a Crosshair with an x and y of 0 and a radius of 20.
   	 */ 
       public Crosshair()
      {
         xPos= 0;
         yPos= 0;
         myRadius = defaultRadius;
      }
   	/**********************************
   	*Constructs a Crosshair with xPos specified by x, yPos specified by y.
   	*@param x		initial x position
   	*@param y		initial y position
   
   	*/
       public Crosshair(int x, int y)
      {
         xPos=x;
         yPos=y;
         myRadius = defaultRadius;
      }
   	/**********************************
   	*Constructs a Crosshair with xPos specified by x, yPos specified by y,
   	*and an ImageIcon specified by e.
   	
   	*@param x		initial x position
   	*@param y		initial y position
   	*@param e		initial ImageIcon
   	*/
      
   	
       public Crosshair(int x, int y, ImageIcon e)
      {
         xPos=x;
         yPos=y;
         myImage=e;
         myRadius = defaultRadius;
      }
   	/**********************************
   	*Constructs a Crosshair with xPos specified by x, yPos specified by y,
   	*and radius specified by r.
   	
   	*@param x		initial x position
   	*@param y		initial y position
   	*@param r		initial myRadius
   	*/
       public Crosshair(int x, int y, int r)
      {
         xPos = x;
         yPos = y;
         myRadius = r;
      }
   	/**********************************
   	*Constructs a Crosshair with xPos specified by x, yPos specified by y,
   	*radius specified by r, and ImageIcon specifed by e
   	
   	*@param x		initial x position
   	*@param y		initial y position
   	*@param r		initial myRadius
   	*@param e		initial ImageIcon
   
   	*/
       public Crosshair(int x, int y, int r, ImageIcon e)
      {
         xPos = x;
         yPos = y;
         myRadius = r;
         myImage = e;
      }
   	/*********************
   	 *Returns the Crosshair's x position.
   	 *@return xPosition
   	 */
       public int getX()
      {
         return xPos;
      }
   	/*********************
   	 *Returns the Crosshair's y position.
   	 *@return YPosition
   	 */
       public int getY()
      {
         return yPos;
      }
      /*********************
   	 *Returns the Crosshair's radius.
   	 *@return radius
   	 */
       public int getRadius()
      {
         return myRadius;
      }
   	/*********************
   	 *Sets the x positon to input number
   	 @param x		assigns x to xPos
   	 */
   	
       public void setX(int x)
      {
         xPos = x;
      }
   	/*********************
   	 *Sets the y positon to input number
   	 @param y		assigns y to yPos
   	 */
       public void setY(int y)
      {
         yPos = y;
      }
      /*********************
   	 *Sets the radius to input number
   	 @param r		assigns r to myRadius
   	 */
       public void setRadius(int r)
      {
         myRadius = r;
      }
   		/********************
   	*Method used to draw the Crosshair.
   	*@param g		Draws the Crosshair to the Graphics Object
   	*/
       public void draw(Graphics g)
      {
         g.setColor(Color.red);
         g.drawOval(xPos - myRadius,yPos - myRadius,myRadius*2, myRadius*2);
         g.drawLine(xPos, yPos - myRadius, xPos, yPos + myRadius);
         g.drawLine(xPos - myRadius, yPos, xPos + myRadius, yPos);
      } 
   }
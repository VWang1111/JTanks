   import java.awt.*;
/*****************************************************************
*Wall is an object that knows its X and Y position as well as its Height 
*and Width.A Wall knows how to return its X, Y, Height, and Width. 
*Wall can also set its X, Y, Height, and Width. Wall can calculate its
*distance between two objects. It can check a tank or bullet is colliding with it
*and it can draw itself. 
@author Will Xu, Turner (T.J.) Arndt, Victor Wang
@version 8.3.2011
*/
    public class Wall{
      private int xPos, yPos, Height, Width;
   	 /**********************************
   	 *Constructs a Wall with all fields set to 0
   	 */    
       public Wall()
      {
         xPos = 0;
         yPos = 0;
         Height = 0;
         Width = 0;
      }
      /**********************************
   	*Constructs a Wall with xPos specified by x, yPos specified by y, 
   	*Width specified by w, and Height specified by h.
   	*@param x		initial x position
   	*@param y		initial y position
   	*@param w		initial Width
   	*@param h		initial Height
   	*/
       public Wall(int x, int y,  int w, int h)
      {
         xPos = x;
         yPos = y;
        
         Width = w;
         Height = h;
      }
   	/**********************************
   	*Constructs a Wall with xPos specified by x, yPos specified by y.
   	*@param x		initial x position
   	*@param y		initial y position
   	*/
       public Wall(int x, int y)
      {
         xPos = x;
         yPos = y;
         Height = 50;
         Width = 150;
      }
   	 /*********************
   	 *Returns the Wall's x position.
   	 *@return xPosition
   	 */
       public int getXPos()
      {
         return xPos;
      }
   	/*********************
   	 *Returns the Wall's y position.
   	 *@return yPosition
   	 */
       public int getYPos()
      {
         return yPos;
      }
   	/*********************
   	 *Returns the Wall's Height.
   	 *@return height
   	 */
       public int getHeight()
      {
         return Height;
      }
   	/*********************
   	 *Returns the Wall's Width.
   	 *@return width
   	 */
       public int getWidth()
      {
         return Width;
      }
   	/*********************
   	 *Sets the x positon to input number
   	 @param x		assigns x to xPos
   	 */
       public void setXPos(int x)
      {
         xPos = x;
      }
   	/*********************
   	 *Sets the y positon to input number
   	 @param y		assigns y to yPos
   	 */
       public void setYPos(int y){
         yPos = y;
      }	
   	/*********************
   	 *Sets the Height to input number
   	 @param h		assigns h to Height
   	 */
       public void setHeight(int h)
      {
         Height = h;
      }
   	/*********************
   	 *Sets the Width to input number
   	 @param w		assigns w to Width
   	 */
       public void setWidth(int w)
      {
         Width = w;
      }
   	/********************
   	*Method used to draw the Wall.
   	*@param g		Draws the wall to the graphics object
   	*/
       public void draw(Graphics g)
      {
         g.setColor(Color.black);
         g.fillRect(getXPos(), getYPos(), getWidth(), getHeight());
      }
      /*******************************
   	*Calculates whether the tank is inside of the wall.
   	*@param arg   TankToCheck
   	*@return TankIsInBumper
   	*/    
       public boolean inBumper(Tank arg)
      {
         for(int x = getXPos(); x <= getXPos() + getWidth(); x++)
            for(int y = getYPos(); y <= getYPos() + getHeight(); y++)
            {
               for(int x1 = arg.getX()-arg.getWidth()/2; x1 <= arg.getX()+arg.getWidth()/2; x1++)
                  if(x == x1 && y == arg.getY()-arg.getHeight()/2)
                     return true;
               for(int x1 = arg.getX()-arg.getWidth()/2; x1 <= arg.getX()+arg.getWidth()/2; x1++)
                  if(x == x1 && y == arg.getY()+arg.getHeight()/2)
                     return true;
               for(int y1 = arg.getY()-arg.getHeight()/2; y1 <= arg.getY()+arg.getHeight()/2; y1++)
                  if(x == arg.getX()-arg.getWidth()/2 && y == y1)
                     return true;
               for(int y1 = arg.getY()-arg.getHeight()/2; y1 <= arg.getY()+arg.getHeight()/2; y1++)
                  if(x == arg.getX()+arg.getWidth()/2 && y == y1)
                     return true;
            }
         return false;
      }
   	 /*************************
   	 *Calculates whether the bullet is inside of the wall.
   	 *@param arg   BulletToCheck
   	 *@return BulletIsInBumper
   	 */
       public boolean inBumper(Bullet arg)
      {
         for(int x = getXPos(); x <= getXPos() + getWidth(); x++)
            for(int y = getYPos(); y <= getYPos() + getHeight(); y++)
               if(distance(x, y, arg.getX(), arg.getY()) <= arg.getRadius() )
                  return true;
         return false;
      }
   	
   	/********************************
   	*Calculates the distance between two points.
   	*@param x1   First X
   	*@param y1   First Y
   	*@param x2   Second X
   	*@param y2   Second Y
   	*@return distance
   	*/
   		
       private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      }
   }
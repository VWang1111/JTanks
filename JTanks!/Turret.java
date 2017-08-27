   import java.awt.*;
   import javax.swing.*;
   /*********************************
	*Turret is a Crosshair that knows its level, range, recurrence, counter,
	*x and y positions, and color.
	*Turret knows how to return its x and y positon, its level, range, recurrence and counter.
	*Turret is able to set its x, y counter, and level. 
	*Methods Turret has allows it to draw itself, check whether it is alive, check if a tank
	*is in range of fire, disappear and check the distance using the distance formula.
	* @author Turner Arndt, Victor Wang, Will Xu
	* @version 8.4.2011
	*/
    public class Turret extends Crosshair
   {
      private static final int defaultXPos=0; //Default X Position
      private static final int defaultYPos=0; //Default Y Position
   	//A turrets knows its Level, Range, How often it shoots, and How long it's waited
      private int myLevel, myRange, myRecurrence, myCounter;
      private ImageIcon myImage; //The Image the Turrets uses
      private Color myColor; //The color of the turret (When it is default)
      private boolean isAlive = true; //Whether or not it is Alive
   /**********************************
   	 *Constructs a Turret with x and y set to 0 and radius set to 20.
   	 */  
       public Turret()
      {
         super();
      }
       /**********************************
   	*Constructs a Turret with xPos specified by x, and yPos specified by y.
   	*The Radius of the Turret is set to 25 and level is set to 1.
   	*@param x		initial x position
   	*@param y		initial y position
   	*/
       public Turret(int x, int y)
      {
         super(x,y,25);
         setLevel(1);
      }
   		/**
   	*Constructs a Turret with xPos specified by x, yPos specified by y,
   	*and level specified by l.
   	*The Radius of the Turret is set to 25.
   	*@param x		initial x position
   	*@param y		initial y position
   	*@param l		initial level
   	*/
   
       public Turret(int x, int y, int l)
      {
         super(x,y,25);
         setLevel(l);
      }
   	/**
   	*Constructs a Turret with xPos specified by x, yPos specified by y,
   	*level specified by l and ImageIcon specified by e.
   	*The Radius of the Turret is set to 25.
   	*@param x		initial x position
   	*@param y		initial y position
   	*@param l		initial level
   	*@param e		initial ImageIcon
   	*/
   
       public Turret(int x, int y, int l, ImageIcon e)
      {
         super(x,y,25,e);
         setLevel(l);
      }
   	/**
   	*Constructs a Turret with xPos specified by x, yPos specified by y,
   	*and ImageIcon specified by e.
   	*The Radius of the Turret is set to 25.
   	*@param x		initial x position
   	*@param y		initial y position
   	*@param e		initial ImageIcon
   	*/
       public Turret(int x, int y, ImageIcon e)
      {
         super(x,y,e);
         setLevel(1);
      }
   	/*********************
   	 *Returns the Turret's level.
   	 *@return level
   	 */
       public int getLevel()
      {
         return myLevel;
      }
       /*********************
   	 *Returns the Turret's recurrence (how often it shoots).
   	 *@return recurrence
   	 */
       public int getRecurrence()
      {
         return myRecurrence;
      }
   			/*********************
   	 *Returns the Turret's counter.
   	 *@return counter
   	 */
       public int getCounter()
      {
         return myCounter;
      }
      /*********************
   	 *Sets the counter to input number
   	 @param c		assigns c to Counter
   	 */
       public void setCounter(int c)
      {
         myCounter = c;
      }
   		/*********************
   	 *Sets the level to input number and changes fields accordingly
   	 @param l		assigns l to level
   	 */
       public void setLevel(int l)
      {
         myLevel=l;
         
         switch(myLevel)
         {
            case 0:
               myColor = Color.white;
               myRange = -1;
               myRecurrence = 1000000;
               break;
            case 1:
               myColor=Color.red.brighter();
               myRange=300;
               myRecurrence = 250;
               myImage = new ImageIcon("Level1.png");
               break;
            case 2:
               myColor=Color.blue.brighter();
               myRange=400;
               myRecurrence = 200;
               myImage = new ImageIcon("Level2.png");
               break;
            case 3:
               myColor=Color.green.brighter();
               myRange=500;
               myRecurrence = 150;
               myImage = new ImageIcon("Level3.png");
               break;
            case 4:
               myColor=Color.magenta.brighter();
               myRange=550;
               myRecurrence = 100;
               myImage = new ImageIcon("Level4.png");
               break;
            case 5:
               myColor=Color.orange.brighter();
               myRange=600;
               myRecurrence = 50;
               myImage = new ImageIcon("Level5.png");
               break;
            case 6:
               myColor = Color.red.brighter();
               myRange = 200;
               myRecurrence = 200;
               myImage = new ImageIcon("Level6.png");
               break;
         }
      
      }
   	/**
   	*Method used to draw Turret. It uses a try-catch to determine whether the Turret has an
   	*ImageIcon. If it doesn't, It draws the default image, which is an Oval of the specified
   	*color and Radius.
   	*@param g		Draws the Turret to the Graphics object
   	*/
       public void draw(Graphics g)
      {
         if(isAlive)
         {
            try
            {
               g.drawImage(myImage.getImage(), xPos-myRadius, yPos-myRadius, null);
            }
                catch(NullPointerException e)
               {
                  g.setColor(myColor);
                  g.fillOval(xPos-myRadius,yPos-myRadius,myRadius*2, myRadius*2);
               }
         }
      }
      /**
   	*Calculates the distance between two points
   	@return distance
   	*/
       private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      }
        /**
   	*Checks whether the Tank is in range of the Turret
   	*@return TankIsInRange
   	*/
       public boolean inRange(Tank tank)
      {
         if(distance(xPos,yPos,tank.getX(),tank.getY()) < myRange && myCounter >= myRecurrence)
            return true;
         return false;
      }
       /**
   	*Sets isAlive to false and sets the x and y coordinates to 0. This prevents the Turret
      *from drawing itself and moves it out of the way and sets all its fields to 0 to prevent
   	*it from firing and getting hit.
   	*/
       public void disappear()
      {
         isAlive = false;
         setX(0);
         setY(0);
         setRadius(0);
         setLevel(0);
      }
       /**
   	*checks whether turret is alive
   	*@return TurretIsAlive
   	*/
       public boolean alive()
      {
         return isAlive;
      }
   }
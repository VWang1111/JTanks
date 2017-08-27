  //Will Xu, Victor Wang, Turner Arndt
	//version 8.1.11
	
	import javax.swing.*;		//JComponent Class
   import java.awt.*;			//Graphics Class

    public class Crosshair
   {
      protected static final int defaultRadius = 20;
      protected int xPos, yPos, myRadius;
      private ImageIcon myImage;
   
       public Crosshair()
      {
         //sets the x and y to 0 and keeps radius at defaultRadius
      }
      
       public Crosshair(int x, int y)
      {
         //constructor where we can set x and y but keep radius at 20
      }
   	
       public Crosshair(int x, int y, ImageIcon e)
      {
         //constructor where we can set x and y and add an image
      	//keeps radius at 20
      }
      
       public Crosshair(int x, int y, int r)
      {
        //constructor where we can change x, y and the radius
      }
      
       public Crosshair(int x, int y, int r, ImageIcon e)
      {
         //constructor that can set x, y radius and the image
      }
   	
       public int getX()
      {
      	//returns x postion of crosshair
         return 1;
      }
   	
       public int getY()
      {
        //returns y postion of crosshair
         return 1;      }
      
       public int getRadius()
      {
         //returns radius postion of crosshair
         return 1;
      }
   	
       public void setX(int x)
      {
         //changes the x of crosshair
      }
   	
       public void setY(int y)
      {
        //changes y of crosshair
      }
      
       public void setRadius(int r)
      {
         //changes the radius of crosshair
      }
   	
       public void draw(Graphics g)
      {
         //draws the crosshair using graphics(might change to image)
      }
       	   
   }
   import java.awt.*;
   public class Mine extends Bullet
   {
      private static final int defaultRange = 250;
      private static final int defaultRadius = 15;
      private int myRange, myRadius;
      private Color myColor = Color.yellow;
   
      public Mine()
      {
         super();
         myRadius = defaultRadius;
         myRange = defaultRange;
         isAlive = false;
      }
   
      public Mine(int x, int y, int radius, int range)
      {
         super(x, y);
         myRadius = radius;
         myRange = range;
         isAlive = false;
      }
   
      public Mine(int x, int y)
      {
         super(x, y);
         myRadius = defaultRadius;
         myRange = defaultRange;
      }
      
      public boolean inRange(Crosshair target)
      {
         if(distance(myXPosition, myYPosition, target.getX(), target.getY()) <= myRange)
            return true;
         return false;
      }
   		
      private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      }
   	
      public void draw(Graphics g)
      {
         if(isAlive)
         {
            g.setColor(myColor);
            g.fillOval((int)(myXPosition-myRadius), (int)(myYPosition-myRadius), myRadius*2, myRadius*2);
         }
      }
      
      public void explode()
      {
         myColor = Color.orange;
         myRadius = myRange;
      }
      
      public void unexplode()
      {
         myColor = Color.yellow;
         myRadius = defaultRadius;
      }
   
   }
 //Victor Wang, Will Xu, Turner Arndt
 //Version 8.1.2011  
	
   import javax.swing.*; //Imported for the JPanel class
   import java.awt.*; //Imported for the Graphics class
   import java.awt.event.*; //Imported for the ActionListener
   import java.awt.image.*; //Imported for the Buffer
   import javax.swing.event.*; //Imported for the Key and MouseInput Adapters

    public class GameBoardStubs extends JPanel{
      private Graphics myBuffer;
      private BufferedImage myImage;
      private Timer bulletTimer, gameTimer;
      private boolean wPressed, aPressed, sPressed, dPressed;
      private static Wall[] wallArray;
      private Tank tank;
      private Crosshair crosshair;
      private int level = 1;
      private Bullet bullet;
      private Turret[] turrets;
       public GameBoardStubs(){
      	
      	//Creates a new Buffered Image
         myImage =  new BufferedImage(1000, 800, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         myBuffer.setColor(Color.white);
         myBuffer.fillRect(0, 0, 1000, 800);
         
      	//Creates an array of walls and an array of turrrets
         wallArray = new Wall[12];
         turrets = new Turret[6];
         
      	//Adds the Mouse and Key Listeners
         addMouseListener(new Mouse());
         addKeyListener(new Key());
         setFocusable(true);
         
      	//Creates a new "default" Tank, Crosshair, and Bullet
         tank = new Tank(0, 0);
         crosshair = new Crosshair(0, 0);
         bullet = new Bullet(0, 0, 0, 0);
         
      	//Creates a new Timer for Animations
         gameTimer = new Timer(50, new GameListener());
         gameTimer.start();
      
      	//Draws the first Level
         drawLevel1();
      }
      
       public void paintComponent(Graphics g)
      {
      	//Draws the Image to the buffer
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
   
       public static Wall[] getWalls()
      {
      	//returns the Array of walls (for use in the collide methods)
         return wallArray;
      }
   
       public void drawLevel1()
      {
         //Instantiate an array of "default" walls
         //Instantiate an array of "default" turrets
         
         //Change all the walls needed to so that they appear on the level
      	
         //Draw all of the walls
         
         //Set the x and y of the Tank and draw it
         
      	//Set x and y of turrets needed and draw them
      }
       public void drawLevel2()
      {
         //Same processs as drawLevel1(), but with different positions for the walls, turrets, and tank
      }
   
       public void drawLevel3()
      {
         //Same processs as drawLevel1(), but with different positions for the walls, turrets, and tank
      }
       public void drawLevel4()
      {
         //Same processs as drawLevel1(), but with different positions for the walls, turrets, and tank
      }
       public void drawLevel5()
      {
         //Same processs as drawLevel1(), but with different positions for the walls, turrets, and tank
      }
       public void drawLevel6()
      {
         //Same processs as drawLevel1(), but with different positions for the walls, turrets, and tank
      }
       public void drawLevel7()
      {
         //Same processs as drawLevel1(), but with different positions for the walls, turrets, and tank
      }
       public void drawLevel8()
      {
         //Same processs as drawLevel1(), but with different positions for the walls, turrets, and tank      
      }
      
       public void pause()
      {
      	//Stops the gameTimer
      }
      
       public void resume()
      {
         //Starts the gameTimer
      }
   	
       public void shoot(Crosshair shooter, Crosshair victim, int speed)
      {
      	//Sets dx, dy and scale, which are variables used to set the bullet's position
      	
         //scales the dx and dy so that dx always equals 5
      
         //instnatiates a new bullet
      
         //makes a new timer used to control the BulletListener and starts it
      }
   	
       private class BulletListener implements ActionListener
      {
         private Bullet myBullet;
      	
          public BulletListener(Bullet arg)
         {
            myBullet = arg;
         }
      	
          public void actionPerformed(ActionEvent e)
         {
         //Uses move method in bullet to move the bullet
         }
      }
      
       private class Key extends KeyAdapter
      {
      	//The following methods are designed to allow the tank to move at a constant rate when the keys are held down
      	//Booleans are set to true and false
      	//The Listener for the timer uses the booleans to move the tank
          public void keyPressed(KeyEvent pressed)
         {
         	//Check for w-a-s-d keys being pressed
         	//If they are pressed, set the corresponding boolean to true
         }
      	
          public void keyReleased(KeyEvent release)
         {
         	//Check to see if w-a-s-d keys are released
         	//If they are released, set the corresponding boolean to false
         }
      }
      
       private class Mouse extends MouseInputAdapter
      {
          public void mouseClicked(MouseEvent press)
         {
         	//If the mouse is clicked, the panel calls shoot, which makes the tank shoot the crosshair
         }
      	
          public void mouseMoved(MouseEvent moved)
         {
         	//If the mouse is moved, the crosshair follows it and then draws itself
         }
      }
      
       private class GameListener implements ActionListener
      {
          public void actionPerformed(ActionEvent move)
         {
         	//check for collisionsand perform appropriate actions such as disappear and subtrcting a life
         	
            //turrets shoot tanks (if in range)
                  
         	//Moves tank(if booleans are true) and checks for collision
         
            //draw Background  
         	//draw walls again
            //draw tanks, turrets, etc.
         }
      }
      
       public boolean collide(Crosshair victim, Bullet projectile)
      {
         //calls the distance formula
         
         //checks to see if the two objects have collided and return true if they did
      	
      	//returns false otherwise
      }
      
       private double distance(double x1, double y1, double x2, double y2)
      {
      	//the distance formula
         return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
      }
      
       public int getScore()
      {
      	//returns the score of the tank(one point for every kill)
         return tank.getScore();
      }
      	
       public int getLives()
      {
      	//returns the lives of the tank
         return tank.getLives();
      }
      
       public void drawLevel(int level)
      {
      	//draws the Background
      	
      	//Uses a switch to determine the level to draw
      }
   }
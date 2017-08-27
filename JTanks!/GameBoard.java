   //Victor Wang, Will Xu, Turner Arndt
   //version 8.4.2011
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   import javax.swing.event.*;
   import java.util.*;
   import java.io.*;

   public class GameBoard extends JPanel{
      private Graphics myBuffer; //Graphics Object we are drawing to
      private BufferedImage myImage; //Buffer we are drawing through
      private javax.swing.Timer gameTimer; //Timer used to animate the game
      private boolean wPressed, aPressed, sPressed, dPressed, mineDown = false; //Booleans used to control Tank movement
      private static Wall[] wallArray; //The array of Walls used in the levels
      private Tank tank; //The Tank controlled by the player
      private Crosshair crosshair; //The Crosshair used to aim
      //Integers used in the game
      private int level = 0, maxIndex = 0, difficulty = 1, count = 0, turretsinlevel=0, mineCount = 0;
      private Bullet[] bullets; //The array of Bullets used in the game
      private Turret[] turrets; //The array of turrets used in each level
      private ImageIcon tankPic; //The ImageIcon for the Tank
      private Mine mine;
      private HighScore[] highScores;
      private Scanner getScores;
      private PrintStream printScores;
      public GameBoard(){
         myImage =  new BufferedImage(1000, 800, BufferedImage.TYPE_INT_RGB); //Creates a new BufferedImage
         myBuffer = myImage.getGraphics(); //Assigns the Graphics object to the Buffer
         startGame();
      }
   	 //Re-Starts the game at Level 1
      public void startGame(){
       //Draws the Background on to the screen
         myBuffer.setColor(new Color(177, 115, 0));
         myBuffer.fillRect(0, 0, 1000, 800);
         
      	//Instantiates all of the objects used in the game
         tankPic = new ImageIcon("Tank.png");
         wallArray = new Wall[12];
         turrets = new Turret[6];
         bullets = new Bullet[50];
         gameTimer = new javax.swing.Timer(5, new GameListener());
         for(int x = 0; x< bullets.length; x++){
            bullets[x] = new Bullet(-50, -50, 0, 0);
            gameTimer.addActionListener(new BulletListener(bullets[x]));
         }
         tank = new Tank(0, 0, tankPic);
         crosshair = new Crosshair(0, 0);
         highScores = new HighScore[10];
         try{
            getScores = new Scanner(new File("highscores.txt"));
         }
            catch(FileNotFoundException e){
               JOptionPane.showMessageDialog(null, "Cannot find highscores.txt. Maybe it has been moved?");
            }
         for(int k = 0; k < highScores.length; k++)
            highScores[k] = new HighScore(getScores.next(), getScores.nextInt());
            
         mine = new Mine();
         
      	//Adds Listeners for the Keyboard and Mouse
         addMouseListener(new Mouse());
         addMouseMotionListener(new Mouse());
         addKeyListener(new Key());
         setFocusable(true);
         gameTimer.start();
         
      	//Sets booleans to false and draws Level 1
         wPressed = aPressed = sPressed = dPressed = false;
         difficulty = 1;
         drawLevel1();
      }
   	//Draws the image to the Buffer
      public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
       //Returns the array of Walls being used in the Level
      public static Wall[] getWalls(){
         return wallArray;
      }
   	 //Draws the first level
      public void drawLevel1(){
         for(int x = 0; x< wallArray.length; x++){
            wallArray[x] = new Wall(0,0,0,0);
         }
         for(int x = 0; x< turrets.length; x++){
            turrets[x] = new Turret(0,0,0);
            turrets[x].setRadius(0);
         }
         wallArray[0] = new Wall(250,0,55,200);
         wallArray[1] = new Wall(150,150,100,50);
         wallArray[2] = new Wall(700,0,60,200);
         wallArray[3] = new Wall(500,600,50,200);
         wallArray[4] = new Wall(150,600,725,50);
         wallArray[5] = new Wall(1000,0,0,800);
         wallArray[6] = new Wall(0,0,1000,0);
         wallArray[7] = new Wall(0,0,0,800);
         wallArray[8] = new Wall(0,800,1000,0);
         turrets[0] = new Turret(650,50, difficulty);
         turrets[1] = new Turret(700, 550, difficulty);
         turrets[2] = new Turret(950, 50, difficulty);
      	
         for(int x = 0; x< turrets.length; x++)
            turrets[x].draw(myBuffer);
         for(int x = 0; x < wallArray.length; x++)
            wallArray[x].draw(myBuffer);
         
         tank.setX(100);
         tank.setY(100);
         turretsinlevel=3;
      }
   	//Draws the second level
      public void drawLevel2(){
         for(int x = 0; x< wallArray.length; x++){
            wallArray[x] = new Wall(0,0,0,0);
         }
         for(int x = 0; x< turrets.length; x++){
            turrets[x] = new Turret(0,0,0);
            turrets[x].setRadius(0);
         }  
         wallArray[0] = new Wall(500,100, 200, 50);
         wallArray[1] = new Wall(300, 150, 75, 450);
         wallArray[2] = new Wall(0, 350, 300, 50);
         wallArray[5] = new Wall(1000,0,0,800);
         wallArray[6] = new Wall(0,0,1000,0);
         wallArray[7] = new Wall(0,0,0,800);
         wallArray[8] = new Wall(0,800,1000,0);
         turrets[0] = new Turret(50,100,difficulty); 
         turrets[1] = new Turret(600, 200, difficulty);
         turrets[2] = new Turret(875, 500, difficulty+1);    
         for(int x = 0; x < wallArray.length; x++)
            wallArray[x].draw(myBuffer);
         for(int x = 0; x < turrets.length; x++)
            turrets[x].draw(myBuffer);
         tank.setX(100);
         tank.setY(650);
         tank.draw(myBuffer);
         turretsinlevel=3;
      }
       //Draws the third level
      public void drawLevel3(){
         for(int x = 0; x< wallArray.length; x++){
            wallArray[x] = new Wall(0,0,0,0);
         }
         for(int x = 0; x< turrets.length; x++){
            turrets[x] = new Turret(0,0,0);
            turrets[x].setRadius(0);
         }  
      	
         wallArray[0] = new Wall(450,0, 75, 300);
         wallArray[1] = new Wall(600, 400, 400, 50);
         wallArray[2] = new Wall(750, 400, 50, 250);
         wallArray[5] = new Wall(1000,0,0,800);
         wallArray[6] = new Wall(0,0,1000,0);
         wallArray[7] = new Wall(0,0,0,800);
         wallArray[8] = new Wall(0,800,1000,0);
         turrets[0] = new Turret(100, 750, difficulty);
         turrets[1] = new Turret(700, 100, difficulty+1);
         turrets[2] = new Turret(900, 600, difficulty+1);
         tank.setX(100);
         tank.setY(100);
         tank.draw(myBuffer);
         turretsinlevel=3;
      }
       
   	 //Draws the fourth level
      public void drawLevel4(){
         for(int x = 0; x< wallArray.length; x++){
            wallArray[x] = new Wall(0,0,0,0);
         }
         for(int x = 0; x< turrets.length; x++){
            turrets[x] = new Turret(0,0,0);
            turrets[x].setRadius(0);
         }  
         wallArray[0] = new Wall(150,0, 50, 200);
         wallArray[1] = new Wall(0, 150, 150, 50);
         wallArray[2] = new Wall(0, 600, 300, 50);
         wallArray[5] = new Wall(1000,0,0,800);
         wallArray[6] = new Wall(0,0,1000,0);
         wallArray[7] = new Wall(0,0,0,800);
         wallArray[8] = new Wall(0,800,1000,0);
         turrets[0] = new Turret(75, 75,6);
         turrets[1] = new Turret(500,400, difficulty+1);
         turrets[2] = new Turret(75, 750, difficulty+1);
         turrets[3] = new Turret(900, 750, difficulty+1);
         tank.setX(910);
         tank.setY(100);
         tank.draw(myBuffer);
         turretsinlevel=4;
      }
       //Draws the fifth level
      public void drawLevel5(){
         for(int x = 0; x< wallArray.length; x++){
            wallArray[x] = new Wall(0,0,0,0);
         }
         for(int x = 0; x< turrets.length; x++){
            turrets[x] = new Turret(0,0,0);
            turrets[x].setRadius(0);
         }  
         wallArray[0] = new Wall(0,200, 200, 50);
         wallArray[1] = new Wall(450, 0, 50, 150);
         wallArray[2] = new Wall(275, 500, 75, 300);
         wallArray[3] = new Wall(600,300,500,50);
         wallArray[5] = new Wall(1000,0,0,800);
         wallArray[6] = new Wall(0,0,1000,0);
         wallArray[7] = new Wall(0,0,0,800);
         wallArray[8] = new Wall(0,800,1000,0);
         turrets[0] = new Turret(150,450, difficulty+1);
         turrets[1] = new Turret(450,350, difficulty+1);
         turrets[2] = new Turret(900, 50 , difficulty+2); 
         turrets[3] = new Turret(550, 750, difficulty+2);       
         tank.setX(100);
         tank.setY(100);
         tank.draw(myBuffer);
         turretsinlevel=4;
      }
       //Draws the sixth level
      public void drawLevel6(){
         for(int x = 0; x< wallArray.length; x++){
            wallArray[x] = new Wall(0,0,0,0);
         }
         for(int x = 0; x< turrets.length; x++){
            turrets[x] = new Turret(0,0,0);
            turrets[x].setRadius(0);
         }  
      	
         wallArray[0] = new Wall(250,0,55,200);
         wallArray[1] = new Wall(150,150,100,50);
         wallArray[2] = new Wall(700,0,60,200);
         wallArray[3] = new Wall(500,600,50,200);
         wallArray[4] = new Wall(150,600,725,50);
         wallArray[5] = new Wall(1000,0,0,800);
         wallArray[6] = new Wall(0,0,1000,0);
         wallArray[7] = new Wall(0,0,0,800);
         wallArray[8] = new Wall(0,800,1000,0);
         turrets[0] = new Turret(650,50,difficulty+1);
         turrets[1] = new Turret(700, 550, difficulty+2);
         turrets[2] = new Turret(950, 50, difficulty+2);
         tank.setX(100);
         tank.setY(100);
         tank.draw(myBuffer);
         turretsinlevel=3;
      }
      //Draws the seventh Level
      public void drawLevel7(){
         for(int x = 0; x< wallArray.length; x++){
            wallArray[x] = new Wall(0,0,0,0);
         }
         for(int x = 0; x< turrets.length; x++){
            turrets[x] = new Turret(0,0,0);
            turrets[x].setRadius(0);
         }  
         wallArray[0] = new Wall(425, 500, 75, 400);
         wallArray[1] = new Wall(275, 200, 375, 375);
         wallArray[5] = new Wall(1000,0,0,800);
         wallArray[6] = new Wall(0,0,1000,0);
         wallArray[7] = new Wall(0,0,0,800);
         wallArray[8] = new Wall(0,800,1000,0);
         turrets[0] = new Turret(100, 100, difficulty+1);
         turrets[1] = new Turret(200, 400, difficulty+1);
         turrets[2] = new Turret(500, 150, difficulty+1);
         turrets[3] = new Turret(900, 100, difficulty+2);
         turrets[4] = new Turret(775, 350, difficulty+2);
         turrets[5] = new Turret(550, 700, difficulty+2);
         tank.setX(100);
         tank.setY(700);
         tank.draw(myBuffer);
         turretsinlevel=6;
      }
       //Draws the eigth level
      public void drawLevel8(){
         for(int x = 0; x< wallArray.length; x++){
            wallArray[x] = new Wall(0,0,0,0);
         }
         for(int x = 0; x< turrets.length; x++){
            turrets[x] = new Turret(0,0,0);
            turrets[x].setRadius(0);
         }  
         wallArray[0] = new Wall(350, 100, 50, 125);
         wallArray[1] = new Wall(400, 100, 150, 40);
         wallArray[2] = new Wall(550, 100, 50, 250);
         wallArray[3] = new Wall(300,350,300,50);
         wallArray[4] = new Wall(125, 225, 275, 40);
         wallArray[5] = new Wall(125,250,50,300);
         wallArray[6] = new Wall(300, 400, 50, 150);
         wallArray[7] = new Wall(1000,0,0,800);
         wallArray[8] = new Wall(0,0,1000,0);
         wallArray[9] = new Wall(0,0,0,800);
         wallArray[10] = new Wall(0,800,1000,0);
         turrets[0]= new Turret(100, 100, difficulty+1);
         turrets[1]= new Turret(225,650, difficulty+2);
         turrets[2] = new Turret(850, 100, difficulty+2);
         turrets[3] = new Turret(500, 550, difficulty+2);
         turrets[4] = new Turret(700, 652, difficulty+2);
         tank.setX(475);
         tank.setY(250);
         tank.draw(myBuffer);      
         turretsinlevel=5;
      }
   	//Brings up the InputDialog that asks you whether or not you want to quit
      public void quit()
      {
         gameTimer.stop(); //Stops the Timer (so movement ceases)
         //Brings up InputDialog and performs approprite actions
         int choice = 0;
         while(choice != 1)
         { 
            String message = "";
            message = message + "\nAre you sure you want to quit this game?";
            message = message + "\n1. No";
            message = message + "\n2. Yes";
            try
            {
               choice = Integer.parseInt(JOptionPane.showInputDialog(message));
            }
               catch(NumberFormatException k)
               {
                  choice=5;
               }
            switch(choice)
            {
               case 1: resume();
                  wPressed=false;
                  aPressed=false;
                  sPressed=false;
                  dPressed=false;
                  break;
               case 2: System.exit(0);
                  break;
               default:JOptionPane.showMessageDialog(null,"Not a valid selection. \n Please press ok and make a valid selection.");
                  break;
            } 
         }
      }
      //Brings up the InputDialog for the Pause Menu
      public void pause()
      {
         gameTimer.stop(); //Stops the GameTimer so movement ceases
         //Brings up InputDialog and performs appropriate actions
         String choice = "0";
         int actualChoice = 0;
         while(Integer.parseInt(choice) != 1)
         {
            String message = "";
            message = message + "\n1. Resume";
            message = message + "\n2. Instructions";
            message = message + "\n3. Display High Scores";
            String highscores = "";
            choice = JOptionPane.showInputDialog(message);
         
            if(choice.equalsIgnoreCase("nyan"))
            {
               for(int k = 0; k<bullets.length; k++)
                  bullets[k].setNyan(true);
               choice = "4";
            }
            
            try
            {
               actualChoice = Integer.parseInt(choice);
            }
               catch(NumberFormatException k)
               {
                  actualChoice=5;
               }
                  
            switch(actualChoice)
            {
               case 1: resume();
                  wPressed=false;
                  aPressed=false;
                  sPressed=false;
                  dPressed=false;
                  break;
               case 2: JOptionPane.showMessageDialog(null,"Instructions: Use the W key to move up, A to move left, S to move down, and D to move right. \n As you move your mouse, a crosshair will follow it. \n When you are ready to shoot, click the Left Mouse Button to fire a bullet. \n Use the Right mouse button to place mines. \n Mines will explode a few seconds after they are placed. \n Turrets are placed around the map; your job is to destroy all turrets by shooting them with bullets. \n Turrets come in different difficulties, red ones are the easiest and orange ones are the hardest. \n Turrets are ABLE to SHOOT at YOU. \n Bullets are able to bounce off walls 3 times, use that to your advantage. \n Use P to pause the game. \n Use Esc to exit game.");           
                  break;
               case 3: 
                  for(int k = 0; k < highScores.length; k++)
                     highscores = highscores+"\n"+(k+1)+". "+highScores[k].getName()+" "+highScores[k].getScore();
                  JOptionPane.showMessageDialog(null, highscores);
                  break;
               case 4: JOptionPane.showMessageDialog(null, "You've found an Easter Egg! Have Fun!");
                  break;
               default:JOptionPane.showMessageDialog(null,"Not a valid selection. \n Please press ok and make a valid selection.");
                  break;
            } 
         }
      }
      //Starts the gameTimer so the game resumes
      public void resume()
      {
         gameTimer.start();
      }
   	//Shoots a Bullet from the specified shooter to the specified victim
   	//Target makes it so Tanks cannot shoot themselves and Turrets can
      public void shoot(Crosshair shooter, Crosshair victim, int target)
      {
      	//Sets the dx and dy using trigonometry. The dx and dy are used to make a new bullet
         double dx = 10*(Math.cos(Math.atan2(shooter.getY() - victim.getY(), shooter.getX() - victim.getX())))*-1;
         double dy = 10*(Math.sin(Math.atan2(shooter.getY() - victim.getY(), shooter.getX() - victim.getX())))*-1;
      	
      	//instnatiates a new bullet if the bullet index is not being used
         int k = 0;
         boolean w = true;
         while(w && k<bullets.length)
         {
            if(!bullets[k].alive())
            {
               if(target == 0)
               { //Makes a Bullet go from a Tank to a crosshair
                  bullets[k].setX(shooter.getX());
                  bullets[k].setY(shooter.getY());
                  bullets[k].setDx(dx);
                  bullets[k].setDy(dy);
                  bullets[k].setTarget(target);
                  bullets[k].setCount(0);
                  w = false;
                  bullets[k].setAlive(true);
                  if(maxIndex < k)
                     maxIndex = k;
                  if(tank.getScore()>=20)
                     tank.setScore(tank.getScore()-20);
                  MainPanel.setScore();
               }
               else
               { //Makes a Bullet go from a Turret to a Tank
                  bullets[k].setX((int)(shooter.getX()+dx*3));
                  bullets[k].setY((int)(shooter.getY()+dy*3));
                  bullets[k].setDx(dx);
                  bullets[k].setDy(dy);
                  bullets[k].setTarget(target);
                  bullets[k].setCount(0);
                  w = false;
                  bullets[k].setAlive(true);
                  if(maxIndex < k)
                     maxIndex = k;
               }
            }
            k++;
         }
      }
      public void placeMine()
      {
         mineDown = true;
         mine.setAlive(true);
         tank.setScore(tank.getScore()-300);
         if(tank.getScore() < 0)
            tank.setScore(0);
      }
   	//Used to control Bullet Movement
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
            if(myBullet.alive())
            {
               myBullet.move(GameBoard.getWalls());
               myBullet.draw(myBuffer);
            }
            redraw();
         }
      }
      //Listens for key Presses and releases
      private class Key extends KeyAdapter
      {
      	//The following methods are designed to allow the tank to move at a constant rate when the keys
      	//are held down
      	//Booleans are set to true and false depending on the keyboard actions
      	//The Listener for the timer uses the booleans to move the tank
         public void keyPressed(KeyEvent pressed)
         {
         	//Check for w-a-s-d keys being pressed
         	//If they are pressed, set the corresponding boolean to true
            if(pressed.getKeyCode() == KeyEvent.VK_W)
               wPressed = true;
            if(pressed.getKeyCode() == KeyEvent.VK_S)
               sPressed = true;
            if(pressed.getKeyCode() == KeyEvent.VK_A)
               aPressed = true;
            if(pressed.getKeyCode() == KeyEvent.VK_D)
               dPressed = true;
            if(pressed.getKeyCode() == KeyEvent.VK_P)
               pause();
            if(pressed.getKeyCode() == KeyEvent.VK_ESCAPE)
               quit();
         }
      	
         public void keyReleased(KeyEvent release)
         {
         	//Check to see if w-a-s-d keys are released
         	//If they are released, set the corresponding boolean to false
            if(release.getKeyCode() == KeyEvent.VK_W)
               wPressed = false;
            if(release.getKeyCode() == KeyEvent.VK_S)
               sPressed = false;
            if(release.getKeyCode() == KeyEvent.VK_A)
               aPressed = false;
            if(release.getKeyCode() == KeyEvent.VK_D)
               dPressed = false;
         }
      }
      //Listens for mouse movement and clicks
      private class Mouse extends MouseInputAdapter
      {
         public void mousePressed(MouseEvent press)
         {
         	//If the mouse is clicked, the panel calls shoot, which makes the tank shoot the crosshair
            if(press.isMetaDown())
               placeMine();
            else
               shoot(tank, crosshair, 0);
         }
      	
         public void mouseMoved(MouseEvent moved)
         {
         	//If the mouse is moved, the crosshair follows it
            crosshair.setX((int)(moved.getX()));
            crosshair.setY((int)(moved.getY()*1.1));
            crosshair.draw(myBuffer);
            redraw();
         }
      }
      //Controls the movement of our game
      private class GameListener implements ActionListener
      {
         public void actionPerformed(ActionEvent move)
         {
            if(mineDown)
            {
               mineCount++;
               if(mineCount >= 75)
               {
                  mine.explode();
                  if(mine.inRange(tank))
                  {
                     tank.setLives(tank.getLives()-1);
                     tank.setScore(tank.getScore()-1000);
                     if(tank.getScore() < 0)
                        tank.setScore(0);
                     drawLevel(level%8);
                     MainPanel.setScore();
                     MainPanel.setLives();
                  }
                  for(int k = 0; k < turrets.length; k++)
                     if(mine.inRange(turrets[k]))
                     {
                        tank.setScore(tank.getScore()+(100*turrets[k].getLevel()));
                        turrets[k].disappear();
                        MainPanel.setScore();
                        count++;
                     }
               }
            }
         	
         	//check for collisions perform appropriate actions
            for(int k = 0; k<maxIndex+1; k++)
            {
               if(collide(tank, bullets[k]) && bullets[k].getTarget() == 1)
               {
                  tank.setLives(tank.getLives()-1);
                  tank.setScore(tank.getScore()-1000);
                  if(tank.getScore() < 0)
                     tank.setScore(0);
                  drawLevel(level%8);
                  bullets[k].disappear();
                  bullets[k].setCount(0);
                  MainPanel.setLives();
                  MainPanel.setScore();
               }
            
               for(int a = 0; a<turrets.length; a++)
                  if(collide(turrets[a], bullets[k]))
                  {
                     tank.setScore(tank.getScore()+(100*turrets[a].getLevel()));
                     turrets[a].disappear();
                     bullets[k].disappear();
                     bullets[k].setCount(0);
                     count++;
                     MainPanel.setScore();
                  }
            }
                     
               //turrets shoot tanks (if in range)
            for(int k = 0; k<turretsinlevel; k++)
            {
               turrets[k].setCounter(turrets[k].getCounter()+1);
               if(turrets[k].inRange(tank))
               {
                  shoot(turrets[k], tank, 1);
                  turrets[k].setCounter(0);
               }
            }
                  
         		//Moves tank(if booleans are true) and checks for collision
            if(wPressed)
            {
               tank.setY(tank.getY()-8);
               tank.collideWithWall(wallArray);
            }
            if(sPressed)
            {
               tank.setY(tank.getY()+8);
               tank.collideWithWall(wallArray);
            }
            if(aPressed)
            {
               tank.setX(tank.getX()-8);
               tank.collideWithWall(wallArray);
            }
            if(dPressed)
            {
               tank.setX(tank.getX()+8);
               tank.collideWithWall(wallArray);
            }
            //Brings up the "You have Lost" method when lives are 0
            if(tank.getLives()==0)
            {
               gameTimer.stop();
               int choice = 0;
               int[] scores = new int[10];
               for(int k = 0; k < scores.length; k++)
                  scores[k] = highScores[k].getScore();
               if(scores[findMin(scores, scores.length)] < tank.getScore())
               {
                  String name = JOptionPane.showInputDialog("New High Score! Enter Name (No Spaces Please):");
                  highScores[findMin(scores, scores.length)] = new HighScore(name, tank.getScore());
               }               sortArray(highScores);
               try{
                  printScores = new PrintStream(new FileOutputStream(new File("highscores.txt")));
               }
                  catch(FileNotFoundException e){
                     JOptionPane.showMessageDialog(null, "Sorry, could not find highscores.txt. Maybe it has been moved?");
                  }
               for(int k = 0; k < highScores.length; k++)
                  printScores.println(highScores[k].toString());
               while(choice != 1)
               {
                  String message = "You have lost.\n Your score was "+tank.getScore()+". \n  Would you like to try again? ";
                  message = message + "\n1. Yes, give me a second chance.";
                  message = message + "\n2. Let me first review the instructions.";
                  message = message + "\n3. No, get me out of here";
                  message = message + "\n4. Display High Scores";
                  String highscores = "";
               
                  try
                  {
                     choice = Integer.parseInt(JOptionPane.showInputDialog(message));
                  }
                     catch(NumberFormatException k)
                     {
                        choice=5;
                     }
                  switch(choice)
                  {
                     case 1: startGame();
                        tank.setLives(3);
                        tank.setScore(0);
                        level = 1;	
                        MainPanel.setScore();
                        MainPanel.setLives();
                        Scoreboard.setLevel(level);
                     
                        break;
                     case 2: JOptionPane.showMessageDialog(null,"Instructions: Use the W key to move up, A to move left, S to move down, and D to move right. \n As you move your mouse, a crosshair will follow it. \n When you are ready to shoot, click the Left Mouse Button to fire a bullet. \n Use the Right mouse button to place mines. \n Mines will explode a few seconds after they are placed. \n Turrets are placed around the map; your job is to destroy all turrets by shooting them with bullets. \n Turrets come in different difficulties, red ones are the easiest and orange ones are the hardest. \n Turrets are ABLE to SHOOT at YOU. \n Bullets are able to bounce off walls 3 times, use that to your advantage. \n Use P to pause the game. \n Use Esc to exit game.");                     	             
                        break;
                     case 3: System.exit(0);
                        break;
                     case 4: 
                        for(int k = 0; k < highScores.length; k++)
                           highscores = highscores+"\n"+(k+1)+". "+highScores[k].getName()+" "+highScores[k].getScore();
                        JOptionPane.showMessageDialog(null, highscores);
                        break;
                     default:JOptionPane.showMessageDialog(null,"Not a valid selection. \n Please press ok and make a valid selection.");
                        break;
                  } 
               }
            }
            //Calls the Main Panel to set the score and lives
            if(count==turretsinlevel)
            {
               level++;
               if(level%8 == 0)
                  difficulty++;
               Scoreboard.setLevel(level+1);
               drawLevel(level%8);
            }
            //Ends game when you have completed all of the levels
            if(difficulty == 4)
            {
               gameTimer.stop();
               int choice = 0;
               int[] scores = new int[10];
               for(int k = 0; k < scores.length; k++)
                  scores[k] = highScores[k].getScore();
               if(scores[findMin(scores, scores.length)] < tank.getScore())
               {
                  String name = JOptionPane.showInputDialog("New High Score! Enter Name (No Spaces Please):");
                  highScores[findMin(scores, scores.length)] = new HighScore(name, tank.getScore());
               }
               sortArray(highScores);
               try{
                  printScores = new PrintStream(new FileOutputStream(new File("highscores.txt")));
               }
                  catch(FileNotFoundException e){
                     JOptionPane.showMessageDialog(null, "Sorry, could not find highscores.txt. Maybe it has been moved?");
                  }
               for(int k = 0; k < highScores.length; k++)
                  printScores.println(highScores[k].toString());
               while(choice != 1)
               {
                  String message = "You have won!\n Your score was "+tank.getScore()+". \n  Would you like to play again? ";
                  message = message + "\n1. Yes, play again.";
                  message = message + "\n2. Let me first review the instructions.";
                  message = message + "\n3. No, get me out of here";
                  message = message + "\n4. Display High Scores";
                  String highscores = "";
               
                  try
                  {
                     choice = Integer.parseInt(JOptionPane.showInputDialog(message));
                  }
                     catch(NumberFormatException k)
                     {
                        choice=5;
                     }
                  switch(choice)
                  {
                     case 1: startGame();
                        tank.setLives(3);
                        tank.setScore(0);
                        level = 1;	
                        MainPanel.setScore();
                        MainPanel.setLives();
                        Scoreboard.setLevel(level);
                        
                        break;
                     case 2: JOptionPane.showMessageDialog(null,"Instructions: Use the W key to move up, A to move left, S to move down, and D to move right. \n As you move your mouse, a crosshair will follow it. \n When you are ready to shoot, click the Left Mouse Button to fire a bullet. \n Use the Right mouse button to place mines. \n Mines will explode a few seconds after they are placed. \n Turrets are placed around the map; your job is to destroy all turrets by shooting them with bullets. \n Turrets come in different difficulties, red ones are the easiest and orange ones are the hardest. \n Turrets are ABLE to SHOOT at YOU. \n Bullets are able to bounce off walls 3 times, use that to your advantage. \n Use P to pause the game. \n Use Esc to exit game.");  
                        break;
                     case 3: System.exit(0);
                        break;
                     case 4: 
                        for(int k = 0; k < highScores.length; k++)
                           highscores = highscores+"\n"+(k+1)+". "+highScores[k].getName()+" "+highScores[k].getScore();
                        JOptionPane.showMessageDialog(null, highscores);
                        break;
                     default:JOptionPane.showMessageDialog(null,"Not a valid selection. \n Please press ok and make a valid selection.");
                        break;
                  } 
               }
            }
            //redraws all of the objects
            if(!mineDown)
            {
               mine.setX(tank.getX());
               mine.setY(tank.getY());
            }
            redraw();
         }
      }
      //Used to determine whether an Object has collided with a Bullet
      public boolean collide(Crosshair victim, Bullet projectile)
      {
         //calls the distance formula
         double distance = distance(victim.getX(), victim.getY(), projectile.getX(), projectile.getY());
         //checks to see if the two objects have collided and return true if they did
         if (distance < victim.getRadius() + projectile.getRadius())
            return true;
         return false;
      }
      //The Distance Formula
      private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
      }
      //Returns the Tank's score(This method is called in the MainPanel
      public int getScore()
      {
         return tank.getScore();
      }
      //Returns the Tank's lives (This method is called in MainPanel
      public int getLives()
      {
         return tank.getLives();
      }
      //Uses a switch to draw the specified Level
      public void drawLevel(int level)
      {
         myBuffer.setColor(new Color(177, 115, 0));
         myBuffer.fillRect(0, 0, 1000, 800); //Fills the Background
         count=0; //Sets the amount of turrets killed to 0
         switch(level)
         {	
            case 0: drawLevel1();
               break;
            case 1: drawLevel2();
               break;
            case 2: drawLevel3();
               break;
            case 3: drawLevel4();
               break;
            case 4: drawLevel5();
               break;
            case 5: drawLevel6();
               break;
            case 6: drawLevel7();
               break;
            case 7: drawLevel8();
               break;
         }
         for(int x = 0; x<bullets.length; x++)
            bullets[x].disappear(); //Disappears all of the Bullets
      }
      //Redraws all Objects and updates the buffer
      public void redraw()
      {
      	//Fills the Background
         myBuffer.setColor(new Color(177, 115, 0));
         myBuffer.fillRect(0, 0, 1000, 800);
         //Draws all of the Objects
         tank.draw(myBuffer);
         for(int k = 0; k<turrets.length; k++)
            turrets[k].draw(myBuffer);
         for(int x = 0; x<wallArray.length; x++)
            wallArray[x].draw(myBuffer);
         for(int a = 0; a<bullets.length; a++)
            bullets[a].draw(myBuffer);
         crosshair.draw(myBuffer);
         
         mine.draw(myBuffer);
         
         if(mineCount >= 75)
         {
            mine.setAlive(false);
            mineDown = false;
            mineCount = 0;
            mine.unexplode();
         }
         //Repaints the buffer
         repaint();
      }
      public void sortArray(HighScore[] scores)
      {
         int maxPos;
         int[] scoreArray = new int[10];
         for(int k =0; k < scores.length; k++)
            scoreArray[k] = scores[k].getScore();
            
         for(int k = scoreArray.length-1; k >= 0; k--)
         {
            maxPos = findMax(scoreArray, k);
            swapArray(scores, maxPos, scores.length - k - 1);
            swap(scoreArray, maxPos, scoreArray.length - k - 1);
         }
      }
      public static int findMax(int[] array, int upper)
      {
         int maxIndex = array.length - 1 - upper;
      	
         for(int x = maxIndex; x<=upper; x++)
            if(array[maxIndex]< array[x])
               maxIndex = x;
          
         return maxIndex;
      }
      
      public static int findMin(int[] array, int upper)
      {
         int minIndex = 0;
      	
         for(int x = 0; x<upper; x++)
            if(array[minIndex]> array[x])
               minIndex = x;
          
         return minIndex;
      }
   	
      public static void swapArray(HighScore[] array, int a, int b)
      {
         HighScore temp = array[b];
         array[b] = array[a];
         array[a] = temp;
      }
      
      public void swap(int[] array, int a, int b)
      {
         int temp = array[b];
         array[b] = array[a];
         array[a] = temp;
      }
   }
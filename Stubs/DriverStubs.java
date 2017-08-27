 //Victor Wang, Will Xu, Turner Arndt
 //version 8.1.2011  
	
	import javax.swing.JFrame; //The JFrame class
	
    public class DriverStubs
   {
       public static void main(String[] args)
      {
			//Makes a new JFrame that has MainPanel on it.
			//The frame is 1000 wide and 800 high
			//The location of the JFrame is at 100,50.
			//The JFrame will close when the the X button is pushed.
         JFrame frame = new JFrame("JTanks");
         frame.setSize(1000, 800);
         frame.setLocation(100, 50);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new MainPanel());
         frame.setVisible(true);
      }
   }
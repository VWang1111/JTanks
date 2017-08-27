    public class HighScore
   {
      private String myName;
      private int myScore;
   
       public HighScore(String name, int score)
      {
         myName = name;
         myScore = score;
      }
   
       public String getName()
      {
         return myName;
      }
   
       public int getScore()
      {
         return myScore;
      }
   
       public void setName(String name)
      {
         myName = name;
      }
   
       public void setScore(int score)
      {
         myScore = score;
      }
   
       public String toString()
      {
         return myName+"\n"+myScore;
      }
   }
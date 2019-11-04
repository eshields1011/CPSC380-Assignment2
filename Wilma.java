import java.util.concurrent.*;

public class Wilma extends Thread
{
  public Semaphore fredSem;
  public Semaphore wilmaSem;

  public Wilma(Semaphore s1, Semaphore s2)
  {
    fredSem = s1;
    wilmaSem = s2;
  }
  public void run()
  {
    try
    {
      for (int i = 0; i < 10; i++)
      { // initialize height values
        double fredHeight = 7;
        double wilmaHeight = 1;
        wilmaSem.acquire(); // acquire Wilma's semaphore so the loop can execute

        while (wilmaHeight != 7) // while Wilma is not at max height
        { // adjust heights on either side of the see saw
          wilmaHeight += 1.5;
          fredHeight -= 1.5;
          System.out.println("Fred's height: " + fredHeight + "    Wilma's height: " + wilmaHeight);
          Thread.sleep(1000);
        }
        fredSem.release(); // release Fred's semaphore for the other thread 
      }
    }
    catch (Exception e)
    {
      e.printStackTrace(); // standard error checking
    }
  }
}

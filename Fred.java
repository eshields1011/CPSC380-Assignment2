import java.util.concurrent.*;

public class Fred extends Thread
{
  public Semaphore fredSem;
  public Semaphore wilmaSem;

  public Fred(Semaphore s1, Semaphore s2)
  { // obtain both semaphores from Main
    fredSem = s1;
    wilmaSem = s2;
    try
    {
      wilmaSem.acquire(); // acquire Wilma's semaphore to properly sync between the two threads
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  public void run()
  {
    try
    {
      for (int i = 0; i < 10; i++)
      { /// intialize height values
        double fredHeight = 1;
        double wilmaHeight = 7;
        fredSem.acquire(); // acquire Fred's semaphore so the loop can execute

        while (fredHeight != 7) // while Fred is not at full height do the see saw stuff
        { // adjust heights on either side of the see saw
          fredHeight += 1;
          wilmaHeight -= 1;
          System.out.println("Fred's height: " + fredHeight + "    Wilma's height: " + wilmaHeight);
          Thread.sleep(1000);
        }
        wilmaSem.release(); // release Wilma's semaphore for the other thread
      }
    }
    catch (Exception e)
    {
      e.printStackTrace(); // standard error checking
    }
  }
}

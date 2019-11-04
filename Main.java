import java.util.concurrent.*;

public class Main
{
  public static void main(String[] args)
  {
    try
    {// initialize sempahores
      Semaphore fredaphore = new Semaphore(1);
      Semaphore wilmaphore = new Semaphore(1);
      // print out initial starting heights
      System.out.println("Fred's height: 1.0    Wilma's height: 7.0");
      Thread.sleep(1000);
      // initalize and start threads
      Fred fredSee = new Fred(fredaphore, wilmaphore);
      fredSee.start();
      Wilma wilmaSaw = new Wilma(fredaphore, wilmaphore);
      wilmaSaw.start();
      // wait for threads to join
      fredSee.join();
      wilmaSaw.join();
    }
    catch (Exception e)
    {
      e.printStackTrace(); // standard error checking
    }
  }
}

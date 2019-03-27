
import java.io.*;
import java.net.*;

public class JGet
{

  public static void main(String[] args)
  {

    if ( (args.length != 1) )
    {
      System.err.println( "\nUsage: java JGet [urlToGet]" );
      System.exit(1);
    }

    String url = args[0];


    URL u;
    InputStream is = null;
    BufferedReader dis;
    String s;

    try
    {
      u = new URL(url);
      is = u.openStream();
      dis = new BufferedReader(new InputStreamReader(is));
      while ((s = dis.readLine()) != null)
      {
        System.out.println(s);
      }
    }
    catch (MalformedURLException mue)
    {
      System.err.println("Ouch - a MalformedURLException happened.");
      mue.printStackTrace();
      System.exit(2);
    }
    catch (IOException ioe)
    {
      System.err.println("Oops- an IOException happened.");
      ioe.printStackTrace();
      System.exit(3);
    }
    finally
    {
      try
      {
        is.close();
      }
      catch (IOException ioe)
      {
      }
    }

  }

}
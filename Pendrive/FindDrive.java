import java.io.*;


public class FindDrive
{

public static String msg()
   {
   String[] letters = new String[]{ "A", "B", "C", "D", "E", "F", "G", "H", "I"};
   File[] drives = new File[letters.length];
   boolean[] isDrive = new boolean[letters.length];

   for ( int i = 0; i < letters.length; ++i )
       {
       drives[i] = new File(letters[i]+":/");

       isDrive[i] = drives[i].canRead();
       }

    System.out.println("FindDrive: waiting for devices...");

   
    while(true)
       {
     
       for ( int i = 0; i < letters.length; ++i )
           {
           boolean pluggedIn = drives[i].canRead();

          
           if ( pluggedIn != isDrive[i] )
{
               if ( pluggedIn )
                  return ("PenDrive "+letters[i]+" has been plugged in 172.16.8.47");
               if(!pluggedIn)
                   return ("PenDrive "+letters[i]+" has been unplugged from 172.16.8.47");

              // isDrive[i] = pluggedIn;
               }
           }

    
       try { Thread.sleep(100); }
       catch (InterruptedException e) {  }

       }
   }
}


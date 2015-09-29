import java.util.*;

class  GetSystemProperties{
  public static void main(String[] args) {
  Properties prop = System.getProperties();
    Enumeration keys = prop.keys();
    while (keys.hasMoreElements()) {
    String key = (String)keys.nextElement();
    String value = (String)prop.get(key);
    //System.out.println(key + ": " + value);
   }
  }
} 
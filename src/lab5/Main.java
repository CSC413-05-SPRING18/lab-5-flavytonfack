package lab5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) {

    HashMap map = new HashMap();

    try {
      File f = new File("src/lab5/Test.java");
      BufferedReader b = new BufferedReader(new FileReader(f));
      String readLine = "";
      while ((readLine = b.readLine()) != null) {
       //System.out.println(readLine);

        String [] mywords = readLine.split(" ");
        for (int i = 0; i < mywords.length; i++) {
          if (map.get(mywords[i]) == null) {
            map.put(mywords[i], 1);
          }
          else {
            int newWord = Integer.valueOf(String.valueOf(map.get(mywords[i])));
            newWord++;
            map.put(mywords[i], newWord );
          }
        }


      }
    } catch (IOException e) {
      e.printStackTrace();
    }


    TreeMap<String, String> sorted = new TreeMap<String, String>(map);
    for (Object key : sorted.keySet()) {
      System.out.println("Word: " + key + "\tCounts: " + map.get(key));
    }

  }
}

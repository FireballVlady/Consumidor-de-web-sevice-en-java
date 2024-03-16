/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package consumer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author nst_o
 */
public class Consumer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){ 
      try{
            URL url = new URL("http://localhost/Nestor/index.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
                if (responsecode!=200)
                    {
                       throw new RuntimeException("Ocurrio un error" + responsecode);
                     }
                else 
                    {
                    StringBuilder informationString = new StringBuilder();
          try (Scanner scanner = new Scanner (url.openStream())) {
              while(scanner.hasNext())
              {
                  informationString.append(scanner.nextLine());
              }
          }
          System.out.println(informationString);
      }
    }catch(IOException | RuntimeException e)
    {
        e.printStackTrace();
    }
    
    }
    
}

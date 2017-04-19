/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author cevans0971
 */
public class DictServer {
    private static Dictionary[] dictionary;
   public static void main(String[] args)
   {
       dictionary = new Dictionary[10];
       dictionary[0] = new Dictionary("bibble", "to drink often; to eat and/or drink noisily");
       dictionary[1] = new Dictionary("doodle sack", "old English word for bagpipe");
       dictionary[2] = new Dictionary("erinaceous", "of, pertaining to, or resembling a hedgehog");
       dictionary[3] = new Dictionary("gabelle","a tax on salt");
       dictionary[4] = new Dictionary("impignorate","to pawn or mortgage something");
       dictionary[5] = new Dictionary("jentacular","pertaining to breakfast");
       dictionary[6] = new Dictionary("kakorrhaphiophobia","fear of failure");
       dictionary[7] = new Dictionary("macrosmatic","having a good sense of smell");
       dictionary[8] = new Dictionary("quire","two dozen sheets of paper");
       dictionary[9] = new Dictionary("xertz","to gulp down quickly and greedily");
   ServerSocket server = null;
        Socket clientConnection = null;
        InputStream clientInput = null;
        OutputStream clientOutput = null;
        Scanner scanner = null;
        OutputStreamWriter osw = null;
        
       
        
         try
         {   
              int portNumber = Integer.parseInt(args[0]);
            server = new ServerSocket(portNumber);
            while (true)
            {
                    clientConnection = server.accept();
                    clientInput = clientConnection.getInputStream();
                    clientOutput = clientConnection.getOutputStream();
                    scanner = new Scanner(clientInput);
                    osw = new OutputStreamWriter(clientOutput);
                    osw.write("Welcome to Server\r\n");
                    osw.flush();
                    
                    while( true )
                    {
                        String message = scanner.nextLine();
                        boolean found = false;
                        if (!( message.equals("Exit")))
                        {
                            for (int i =0; i < 10; i++)
                            {
                                if(message.equals(dictionary[i].getWord()))
                                {
                                    found = true;
                                    osw.write(dictionary[i].getDefinition() + "\r\n" );
                                    osw.flush();
                                    break;
                                }
                            }
                           if(!found)
                           {
                             System.out.println("Word not in dictionary");
                           }
                        }
                        else
                        {
                            osw.close();
                            clientInput.close();
                            clientConnection.close();
                            break;
                        }
                    }

                }     
        }
         catch (IOException e)
         {

             System.out.println("Unable to establish "
                        + "server connection");
         }

   }
}

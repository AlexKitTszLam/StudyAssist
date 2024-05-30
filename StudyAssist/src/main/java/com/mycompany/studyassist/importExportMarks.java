package com.mycompany.studyassist;

import java.io.*;
import java.nio.*;
import java.nio.file.Files;

public class importExportMarks {

    static BufferedWriter writer; //note that due to the filename being "marks.txt", it will overwrite the old file. This is by design, as it should be writing to one file to allow for the person to actually view marks after rebooting.
     static {
         try {
             String file = createStorageFolder();
             writer = new BufferedWriter(new FileWriter(file));
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }

     //it's a reader.
     static BufferedReader reader;
     static {
         try {
             String file = createStorageFolder();
             reader = new BufferedReader(new FileReader(file));
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }

     public static String createStorageFolder(){ //looks for if user has a file for marks.txt, and if not creates one
         System.out.println(System.getProperty("user.home"));
         File file = new File(System.getProperty("user.home") + ("/StudentAssist/marks.txt"));
         File fileDir = new File(System.getProperty("user.home") + "/StudentAssist");
         if(fileDir.mkdirs()){
             System.out.println("Created StudentAssist Dir");
         }else{
             System.out.println("did not make dir");
         }
         return String.valueOf(file);
     }



     //This method is so the array is made into a format that is easier for the writer to write into.
     public static void writeIntoFile(){
         StringBuilder whatToPrint = new StringBuilder();
         for(Gui.Mark mark: Gui.markArr){
             whatToPrint.append(String.valueOf(mark)).append("\n");
         }
         try {
             writer.write(String.valueOf(whatToPrint));
             writer.flush();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }


     }
 }


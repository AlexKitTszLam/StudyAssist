package com.mycompany.studyassist;

import java.io.*;
import java.util.ArrayList;
import java.nio.*;
import java.nio.file.Files;

import static com.mycompany.studyassist.Gui.markArr;

public class importExportMarks {

    //it's a reader.
    static BufferedReader reader;
    static {
        try {
            String file = createStorageFolder();
            reader = new BufferedReader(new FileReader(file+"/marks.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

     public static String createStorageFolder(){ //looks for if user has a file for marks.txt, and if not creates one
         System.out.println(System.getProperty("user.home"));
         //File file = new File(System.getProperty("user.home") + ("/StudentAssist/marks.txt"));
         File fileDir = new File(System.getProperty("user.home") + "/StudentAssist");
         if(fileDir.mkdirs()){
             System.out.println("Created StudentAssist Dir");
         }else{
             System.out.println("did not make dir");
         }
         return String.valueOf(fileDir);
     }



     //This method is so the array is made into a format that is easier for the writer to write into.
     public static void writeIntoFile(){
         StringBuilder whatToPrint = new StringBuilder();

         BufferedWriter writer; //note that due to the filename being "marks.txt", it will overwrite the old file. This is by design, as it should be writing to one file to allow for the person to actually view marks after rebooting.
         {
             try {
                 String file = createStorageFolder();
                 writer = new BufferedWriter(new FileWriter(file+"/marks.txt"));
             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
         }

         for(Gui.Mark mark: markArr){
             whatToPrint.append(String.valueOf(mark)).append("\n");
         }
         try {
             writer.write(String.valueOf(whatToPrint));
             writer.flush();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }


     }

     public static void arrayAdder() throws IOException {
         //e
         String addedMark;
         System.out.println("arrayAdder Started");
         do{
             addedMark = reader.readLine();
             System.out.println(addedMark);
             if(addedMark != null){
                 System.out.println("not null");
                 String[] markInfo = addedMark.split(",");
                 if(markInfo.length == 17){
                     String courseCode = markInfo[0];
                     String assignmentName = markInfo[1];
                     double kMark = Double.parseDouble(markInfo[2]);
                     double kMaxMark = Double.parseDouble(markInfo[3]);
                     double kWeight = Double.parseDouble(markInfo[4]);
                     double tMark = Double.parseDouble(markInfo[5]);
                     double tMaxMark = Double.parseDouble(markInfo[6]);
                     double tWeight = Double.parseDouble(markInfo[7]);
                     double cMark = Double.parseDouble(markInfo[8]);
                     double cMaxMark = Double.parseDouble(markInfo[9]);
                     double cWeight = Double.parseDouble(markInfo[10]);
                     double aMark = Double.parseDouble(markInfo[11]);
                     double aMaxMark = Double.parseDouble(markInfo[12]);
                     double aWeight = Double.parseDouble(markInfo[13]);
                     double culminatingMark = Double.parseDouble(markInfo[14]);
                     double culminatingMaxMark = Double.parseDouble(markInfo[15]);
                     double culminatingWeight = Double.parseDouble(markInfo[16]);

                     Gui.Mark newMark = new Gui.Mark(courseCode, assignmentName, kMark, kMaxMark, kWeight, tMark, tMaxMark, tWeight, cMark, cMaxMark, cWeight, aMark, aMaxMark, aWeight, culminatingMark, culminatingMaxMark, culminatingWeight);
                     markArr.add(newMark);
                     System.out.println("added object to array: " + newMark);
                 }else{
                     System.out.println("something happened and it did NOT add properly.");
                 }
             }




         }while(addedMark != null);




     }
 }


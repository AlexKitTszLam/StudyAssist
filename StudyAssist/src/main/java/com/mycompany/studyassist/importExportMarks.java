package com.mycompany.studyassist;

import java.io.*;

 public class importExportMarks {

    static BufferedWriter writer; //note that due to the filename being "marks.txt", it will overwrite the old file. This is by design, as it should be writing to one file to allow for the person to actually view marks after rebooting.
     {
         try {
             writer = new BufferedWriter(new FileWriter("markFolder/marks.txt"));
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }

     //it's a reader.
     static BufferedReader reader;
     {
         try {
             reader = new BufferedReader(new FileReader("markFolder/marks.txt"));
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }

     //This method is so the array is made into a format that is easier for the writer to write into.
     public static void writeIntoFile(){
         StringBuilder whatToPrint = new StringBuilder();
         for(Gui.Mark mark: Gui.markArr){
             whatToPrint.append(String.valueOf(mark)).append("\n");
             try {
                 writer.write(String.valueOf(whatToPrint));
             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
         }

     }
 }


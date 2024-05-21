package com.mycompany.studyassist;

import java.io.*;

 public class importExportMarks {
    static BufferedWriter writer; //note that due to the filename being "marks.txt", it will overwrite the old file.
     {
         try {
             writer = new BufferedWriter(new FileWriter("markFolder/marks.txt"));
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }

     static BufferedReader reader;
     {
         try {
             reader = new BufferedReader(new FileReader("markFolder/marks.txt"));
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }
 }


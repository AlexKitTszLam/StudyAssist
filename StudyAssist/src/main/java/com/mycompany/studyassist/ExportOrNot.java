package com.mycompany.studyassist;

//This is a method for the gui that allows for the gui to ask for if you want to export the file when exiting.
//It uses a YES/NO jOptionPane to ask for an answer.

import javax.swing.JOptionPane;
import static com.mycompany.studyassist.importExportMarks.writeIntoFile;

public class ExportOrNot {

    public static void ExportQuestionPopup(){
        int export = JOptionPane.showConfirmDialog(null, "Would you like to export your marks?", "export????????????????????????", JOptionPane.YES_NO_OPTION);
        if(export == JOptionPane.YES_OPTION){
            writeIntoFile();
            System.out.println("wrote to file");
        }
        System.exit(0);
    }




}



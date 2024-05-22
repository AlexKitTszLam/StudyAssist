package com.mycompany.studyassist;

import javax.swing.JOptionPane;

import static com.mycompany.studyassist.importExportMarks.writeIntoFile;

public class ExportOrNot {

    public static void ExportQuestionPopup(){
        int export = JOptionPane.showConfirmDialog(null, "Would you like to export your marks?", "FORTNITE BATTLE PASSS", JOptionPane.YES_NO_OPTION);
        if(export == JOptionPane.YES_OPTION){
            writeIntoFile();
            System.out.println("wrote to file");
        }
        System.exit(0);
    }

}

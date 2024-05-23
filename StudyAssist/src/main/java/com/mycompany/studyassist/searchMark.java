package com.mycompany.studyassist;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

import static com.mycompany.studyassist.Gui.*;
import static com.mycompany.studyassist.importExportMarks.writer;

//Allow for the searching of marks.
//array is called markArr
//Mark(courseCode, assignmentName, kMark, kMaxMark, kWeight, tMark, tMaxMark, tWeight, cMark,
//cMaxMark, cWeight, aMark, aMaxMark, aWeight, culminatingMark, culminatingMaxMark, culminatingWeight);
//

//uses assignmentName to search for marks.
public class searchMark {
    static ArrayList<Gui.Mark> foundMarks = new ArrayList<>();

    public static void markFinder() {
        System.out.println("Starting to look for marks");

        if (nameTextField.getText() != null && courseCodeTextField.getText() != null) { //course code AND mark
            for(Gui.Mark mark: Gui.markArr){
                if(mark.getAssignmentName().equalsIgnoreCase(nameTextField.getName()) && mark.getCourseCode().equalsIgnoreCase(courseCodeTextField.getName())){
                    foundMarks.add(mark);
                }
            }
            if(!foundMarks.isEmpty()){
                addToDisplay();
            }else{
                JOptionPane.showInputDialog(null, "Did not find any assignments!", "uh", JOptionPane.ERROR_MESSAGE);
            }


        } else if (courseCodeTextField.getText() != null) { //course code only
            for(Gui.Mark mark: Gui.markArr){
                if(mark.getCourseCode().equalsIgnoreCase(courseCodeTextField.getName())){
                    foundMarks.add(mark);
                }
            }
            if(!foundMarks.isEmpty()){
                addToDisplay();
            }else{
                JOptionPane.showInputDialog(null, "Did not find any assignments!", "uh", JOptionPane.ERROR_MESSAGE);
            }


        } else if (nameTextField.getText() != null) { //name only
            for(Gui.Mark mark: Gui.markArr){
                if(mark.getAssignmentName().equalsIgnoreCase(nameTextField.getName())){
                    foundMarks.add(mark);
                }
            }

            if(!foundMarks.isEmpty()){
                addToDisplay();
            }else{
                JOptionPane.showInputDialog(null, "Did not find any assignments!", "uh", JOptionPane.ERROR_MESSAGE);
            }


        } else {
            JOptionPane.showInputDialog(null, "no name or course code was provided", "uh", JOptionPane.ERROR_MESSAGE);
        }
    }

    static StringBuilder whatToPrint;
    public static void addToDisplay(){
        for(Gui.Mark mark: Gui.markArr){
            whatToPrint.append(String.valueOf(mark)).append("\n");
            display.setText(String.valueOf(whatToPrint));
        }
    }
    
}


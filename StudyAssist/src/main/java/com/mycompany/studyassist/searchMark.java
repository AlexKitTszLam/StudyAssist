package com.mycompany.studyassist;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

import  com.mycompany.studyassist.Gui.*;
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

        if (!nameTextField.getText().equalsIgnoreCase("") && !courseCodeTextField.getText().equalsIgnoreCase("")) { //course code AND mark
            System.out.println("Name and CC was given");
            for(Gui.Mark mark: Gui.markArr){
                if(mark.getAssignmentName().equalsIgnoreCase(nameTextField.getName()) && mark.getCourseCode().equalsIgnoreCase(courseCodeTextField.getName())){
                    foundMarks.add(mark);
                }
            }
            if(!foundMarks.isEmpty()){
                addToDisplay();
            }else{
                JOptionPane.showMessageDialog(null, "Did not find any assignments!", "uh", JOptionPane.INFORMATION_MESSAGE);
            }


        } else if (!courseCodeTextField.getText().equalsIgnoreCase("")) { //course code only
            System.out.println("Course code was given");
            for(Gui.Mark mark: Gui.markArr){
                if(mark.getCourseCode().equalsIgnoreCase(courseCodeTextField.getName())){
                    foundMarks.add(mark);
                }
            }
            if(!foundMarks.isEmpty()){
                addToDisplay();
            }else{
                JOptionPane.showMessageDialog(null, "Did not find any assignments!", "uh", JOptionPane.INFORMATION_MESSAGE);
            }


        } else if (!nameTextField.getText().equalsIgnoreCase("")) { //name only
            System.out.println("name was given");
            for(Gui.Mark mark: Gui.markArr){
                if(mark.getAssignmentName().equalsIgnoreCase(nameTextField.getName())){
                    foundMarks.add(mark);
                }
            }

            if(!foundMarks.isEmpty()){
                addToDisplay();
            }else{
                JOptionPane.showMessageDialog(null, "Did not find any assignments!", "uh", JOptionPane.INFORMATION_MESSAGE);
            }


        } else {
             JOptionPane.showMessageDialog(null, "no name or course code was provided", "uh", JOptionPane.INFORMATION_MESSAGE);
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


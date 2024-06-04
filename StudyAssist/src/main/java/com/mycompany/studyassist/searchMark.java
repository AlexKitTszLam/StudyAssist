package com.mycompany.studyassist;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import static com.mycompany.studyassist.Gui.*;

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
        foundMarks.clear();

        if (!nameTextField.getText().equalsIgnoreCase("") && !courseCodeTextField.getText().equalsIgnoreCase("")) { //course code AND mark
            System.out.println("Name and CC was given");
            for(Gui.Mark mark: Gui.markArr){
                if(mark.getAssignmentName().equalsIgnoreCase(nameTextField.getText()) && mark.getCourseCode().equalsIgnoreCase(courseCodeTextField.getText())){
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
                if(mark.getCourseCode().equalsIgnoreCase(courseCodeTextField.getText())){
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
                if(mark.getAssignmentName().equalsIgnoreCase(nameTextField.getText())){
                    foundMarks.add(mark);
                }
            }

            if(!foundMarks.isEmpty()){
                addToDisplay();
            }else{
                JOptionPane.showMessageDialog(null, "Did not find any assignments!", "uh", JOptionPane.INFORMATION_MESSAGE);
            }


        } else {
            System.out.println("nothing was provided?");
             JOptionPane.showMessageDialog(null, "no name or course code was provided", "uh", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static StringBuilder whatToPrint = new StringBuilder();

    //This is not how we should have it formatted in the end. Should be treated as placeholder until I do a better printing method.
    public static void addToDisplay() {
        StringBuilder text = new StringBuilder("All Existing Assignments:\n");
        for (Mark item : foundMarks){
            text.append("Course code: ").append(item.getCourseCode()).append(" ");
            text.append("Assignment name: ").append(item.getAssignmentName()).append("\n");
            text.append(String.format("Knowledge - Mark: %.1f, Max Mark: %.1f, Weight: %.1f\n", item.getKMark(), item.getKMaxMark(), item.getKWeight()));
            text.append(String.format("Thinking - Mark: %.1f, Max Mark: %.1f, Weight: %.1f\n", item.getTMark(), item.getTMaxMark(), item.getTWeight()));
            text.append(String.format("Communication - Mark: %.1f, Max Mark: %.1f, Weight: %.1f\n", item.getCMark(), item.getCMaxMark(), item.getCWeight()));
            text.append(String.format("Application - Mark: %.1f, Max Mark: %.1f, Weight: %.1f\n", item.getAMark(), item.getAMaxMark(), item.getAWeight()));
            text.append(String.format("Culminating - Mark: %.1f, Max Mark: %.1f, Weight: %.1f\n", item.getCulminatingMark(), item.getCulminatingMaxMark(), item.getCulminatingWeight()));
            text.append("\n");
        }
        display.setText(text.toString());
    }
}


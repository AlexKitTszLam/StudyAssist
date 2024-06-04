package com.mycompany.studyassist;
import javax.swing.*;

import static com.mycompany.studyassist.Gui.*;
import static com.mycompany.studyassist.importExportMarks.createStorageFolder;

public class removeMark { //given the course code nd name of assignment, it deletes.

    public static void removeThatMark() {
        //Makes sure that the person has the correct information needed to delete the mark
        System.out.println("RemoveMarkButton was pressed");
        if (!courseCodeTextField.getText().equalsIgnoreCase("") && !nameTextField.getText().equalsIgnoreCase("")) {
            //asks if the persona intended to actually delete it.
            int doubleCheck = JOptionPane.YES_NO_OPTION;
            if (doubleCheck == JOptionPane.YES_OPTION) {
                for (Mark mark : markArr) {
                    if (mark.getCourseCode().equalsIgnoreCase(courseCodeTextField.getText()) && mark.getAssignmentName().equalsIgnoreCase(nameTextField.getText())) {
                        markArr.remove(mark);
                        System.out.println("removed mark?");
                        JOptionPane.showMessageDialog(null, "Deleted mark!", "uh", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Can not remove without the course code AND name!", "uh", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

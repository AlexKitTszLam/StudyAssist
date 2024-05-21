package culminatingTesting;

//Import necessary components
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class StudyAssist {
// Define the array list that will be used for the entire program
	    private static ArrayList<Mark> markArr = new ArrayList<>();
	    private static final Scanner scan = new Scanner(System.in);
	    
	public static void main(String[] args) {
		boolean running = true;
		while (running) {
            System.out.println("\nChoose an action: \n1. Query an Item\n2. Add a New Item\n3. Exit");
            String choice = scan.nextLine().trim();
         
            // Switch to each option according to the user input
            switch (choice) {
                case "1":
                    input();
                    break;
                case "2":
                    courseAverage();
                    break;
                case "3":
                    running = false;
                    break;
                default:
                	// Error check & message
                    System.out.println("Invalid option, option must be 1, 2, or 3.");
            }
        }
		// Terminate the program
        scan.close();
        System.out.println("System Exited.");
	}
	
	
	public static void input() {
		System.out.print("course code ");
		String courseCode = scan.nextLine().trim();
		
		System.out.print("assignment name");
		String assignmentName = scan.nextLine().trim();
        
		double kMark = readDouble ("k mark");
		double kMaxMark = readDouble ("k max mark");
		double kWeight = readDouble ("k weight");
		
		double tMark = readDouble ("t mark");
		double tMaxMark = readDouble ("t max mark");
		double tWeight = readDouble ("t weight");
		
		double cMark = readDouble ("c mark");
		double cMaxMark = readDouble ("c max mark");
		double cWeight = readDouble ("c weight");
		
		double aMark = readDouble ("a mark");
		double aMaxMark = readDouble ("a max mark");
		double aWeight = readDouble ("a weight");
		
		double culminatingMark = readDouble ("cul mark");
		double culminatingMaxMark = readDouble ("cul max mark");
		double culminatingWeight = readDouble ("cul weight");
		
		Mark newMark = new Mark(courseCode, assignmentName, kMark, kMaxMark, kWeight, tMark, tMaxMark, tWeight, cMark, 
				cMaxMark, cWeight, aMark, aMaxMark, aWeight, culminatingMark, culminatingMaxMark, culminatingWeight);
		
		System.out.println(newMark);
		markArr.add(newMark);
		for (Mark item : markArr) {
			System.out.println(item);
		}
	}
	
	public static void courseAverage() {
		String course = scan.nextLine();
		double dailyMark = 0;
		double culminatingMark = 0;
		for (Mark item : markArr) {
			String courseCode = item.getCourseCode();
			if (course.equals(courseCode)) {
				dailyMark = dailyMark + item.getKMark() * item.getKWeight();
				dailyMark = dailyMark + item.getTMark() * item.getTWeight();
				dailyMark = dailyMark + item.getCMark() * item.getCWeight();
				dailyMark = dailyMark + item.getAMark() * item.getAWeight();
				culminatingMark = culminatingMark;
			}
		}
			
	}
	
	public static class Mark {
	    private String courseCode;
	    private String assignmentName;
	    
	    private double kMark;
	    private double kMaxMark;
	    private double kWeight;
	    
	    private double tMark;
	    private double tMaxMark;
	    private double tWeight;
	    
	    private double cMark;
	    private double cMaxMark;
	    private double cWeight;
	    
	    private double aMark;
	    private double aMaxMark;
	    private double aWeight;
	    
	    private double culminatingMark;
	    private double culminatingMaxMark;
	    private double culminatingWeight;
	    
	    // Constructor 
	    public Mark(String courseCode, String assignmentName, double kMark, double kMaxMark, double kWeight, double tMark, 
	    			double tMaxMark, double tWeight, double cMark, double cMaxMark, double cWeight, double aMark,
	                double aMaxMark, double aWeight, double culminatingMark, double culminatingMaxMark, double culminatingWeight) {
	    	
	        this.courseCode = courseCode;
	        this.assignmentName = assignmentName;
	        
	        this.kMark = kMark;
	        this.kMaxMark = kMaxMark;
	        this.kWeight = kWeight;
	        
	        this.tMark = tMark;
	        this.tMaxMark = tMaxMark;
	        this.tWeight = tWeight;
	        
	        this.cMark = cMark;
	        this.cMaxMark = cMaxMark;
	        this.cWeight = cWeight;
	        
	        this.aMark = aMark;
	        this.aMaxMark = aMaxMark;
	        this.aWeight = aWeight;
	        
	        this.culminatingMark = culminatingMark;
	        this.culminatingMaxMark = culminatingMaxMark;
	        this.culminatingWeight = culminatingWeight;
	    }

	    // Getter and Setter for courseCode
	    public String getCourseCode() {
	        return courseCode;
	    }

	    public void setCourseCode(String courseCode) {
	        this.courseCode = courseCode;
	    }
	    
	    // Getter and Setter for assignmentName
	    public String getAssignmentName() {
	        return assignmentName;
	    }

	    public void setAssignmentName(String assignmentName) {
	        this.assignmentName = assignmentName;
	    }

	    // Getter and Setter for kMark
	    public double getKMark() {
	        return kMark;
	    }

	    public void setKMark(double kMark) {
	        this.kMark = kMark;
	    }
	    
	    // Getter and Setter for kMaxMark
	    public double getKMaxMark() {
	        return kMaxMark;
	    }

	    public void setKMaxMark(double kMaxMark) {
	        this.kMaxMark = kMaxMark;
	    }
	    
	    // Getter and Setter for kWeight
	    public double getKWeight() {
	        return kWeight;
	    }

	    public void setKWeight(double kWeight) {
	        this.kWeight = kWeight;
	    }

	    // Getter and Setter for tMark
	    public double getTMark() {
	        return tMark;
	    }

	    public void setTMark(double tMark) {
	        this.tMark = tMark;
	    }
	    
	    // Getter and Setter for tMaxMark
	    public double getTMaxMark() {
	        return tMaxMark;
	    }

	    public void setTMaxMark(double tMaxMark) {
	        this.tMaxMark = tMaxMark;
	    }

	    // Getter and Setter for tWeight
	    public double getTWeight() {
	        return tWeight;
	    }

	    public void setTWeight(double tWeight) {
	        this.tWeight = tWeight;
	    }

	    // Getter and Setter for cMark
	    public double getCMark() {
	        return cMark;
	    }

	    public void setCMark(double cMark) {
	        this.cMark = cMark;
	    }
	    
	    // Getter and Setter for cMaxMark
	    public double getCMaxMark() {
	        return cMaxMark;
	    }

	    public void setCMaxMark(double cMaxMark) {
	        this.cMaxMark = cMaxMark;
	    }

	    // Getter and Setter for cWeight
	    public double getCWeight() {
	        return cWeight;
	    }

	    public void setCWeight(double cWeight) {
	        this.cWeight = cWeight;
	    }

	    // Getter and Setter for aMark
	    public double getAMark() {
	        return aMark;
	    }

	    public void setAMark(double aMark) {
	        this.aMark = aMark;
	    }
	    
	    // Getter and Setter for aMaxMark
	    public double getAMaxMark() {
	        return aMaxMark;
	    }

	    public void setAMaxMark(double aMaxMark) {
	        this.aMaxMark = aMaxMark;
	    }

	    // Getter and Setter for aWeight
	    public double getAWeight() {
	        return aWeight;
	    }

	    public void setAWeight(double aWeight) {
	        this.aWeight = aWeight;
	    }

	    // Getter and Setter for culminatingMark
	    public double getCulminatingMark() {
	        return culminatingMark;
	    }

	    public void setCulminatingMark(double culminatingMark) {
	        this.culminatingMark = culminatingMark;
	    }
	    
	    // Getter and Setter for culminatingMark
	    public double getCulminatingMaxMark() {
	        return culminatingMaxMark;
	    }

	    public void setCulminatingMaxMark(double culminatingMaxMark) {
	        this.culminatingMaxMark = culminatingMaxMark;
	    }

	    // Getter and Setter for culminatingWeight
	    public double getCulminatingWeight() {
	        return culminatingWeight;
	    }
	    
	    public void setCulminatingWeight(double culminatingWeight) {
	        this.culminatingWeight = culminatingWeight;
	    }
	    
	    public String toString() {
	    	return String.format("%s,%s,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f",
                    courseCode, assignmentName, kMark, kMaxMark, kWeight, tMark, tMaxMark, tWeight, cMark,
                    cMaxMark, cWeight, aMark, aMaxMark, aWeight, culminatingMark, culminatingMaxMark, culminatingWeight);
	    }
	        
	}
	
	// Method for scanning an integer and error checks
    public static double readDouble(String prompt) {
    	// Print instruction
        System.out.print(prompt);
        
        // Check for not double first, avoiding variable type errors from the system
        while (!scan.hasNextDouble()) {
            System.out.println("That's not an double. Try again.");
            scan.next(); 
        }
        
        // Save the input
        double num = scan.nextDouble();
        
        // Check for invalid decimal(negative or more than two decimal places) with a method, asks the user to try again if input is invalid
        while (InvalidDecimal(num)) {
            System.out.println("Please enter a non-negative number.");
            
            // Loop to check for non-integer again
            while (!scan.hasNextDouble()) {
                System.out.println("That's not an double. Try again.");
                scan.next(); 
            }
            num = scan.nextDouble();
        }
        
        // Return the final input when no errors appeared
        return num;
    }
    
    // Method to check errors in doubles
    public static boolean InvalidDecimal(double num) {
    	// Find the index of the decimal point
    	int dotIndex = String.valueOf(num).indexOf("."); 
    	
    	// Check for negative, true represent an error has occurred
    	if (num < 0) {
    		return true;
    	}
        
    	// Exit case for when there is no decimal digits
        if (dotIndex == -1) {
            return false;
        }
        // Calculate the number of characters after the decimal point and compare 
        int decimalCount = String.valueOf(num).length() - dotIndex - 1;
        return decimalCount > 2;
    }
    
}


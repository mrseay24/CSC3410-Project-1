/*
 * CSC3420 - Spring 2015
 * Sidney Seay - sseay5@student.gsu.edu
 * DateDue: 02-3-2015
 * Assignment: 1
 * File(s): CreateSet.java, Convert.java
 */

//commands 5 and 6 not working

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class CreateSet {

    // constructor
    public CreateSet() {

        }

    public static void main(String[] args){
    	Scanner scan = new Scanner( System.in );  
        // create array list
        ArrayList nameList = new ArrayList();
        ArrayList valuesList = new ArrayList();        
        ArrayList union = new ArrayList();        
        ArrayList intersection = new ArrayList();
        ArrayList subtraction = new ArrayList();
        ArrayList duplicateValues = new ArrayList();
        String[] values = null;
        String[] unionValues = null;         
        //
        char ch1;
        String name = "";
        String uName1 = "";
        String uName2 = "";        
        String xValues = "";
        String str = "";        
        // program flag
        String nameFound = "False";
        String duplicateFound = "False";
        String enterName = "Please enter a name: ";
        String noName = "Set name does not exist ";        
        String unionName = "Please enter two set name separated by a space: ";        
        //***************************************
        // display user prompt (X will not finish)
        //***************************************
        System.out.println("1) Create a set");
		System.out.println("2) Print the list of created sets");
		System.out.println("3) Print a set");
		System.out.println("4) Union");
		System.out.println("5) Intersection");
		System.out.println("6) Subtraction");
		System.out.println("7) Exit");
        //
        while(true) {
		System.out.println("Please enter the number of the command > ");
		
		scan = new Scanner(System.in);
		str = scan.nextLine();
		ch1 = str.charAt(0);

		switch (ch1) {
		case '1':
	        // call setName - Create set
	        setName(nameList, valuesList, name);
	        continue;
		case '2':
	        // call printAllSet - Print all created set
	        printAllSet(nameList, valuesList);
	        continue;
		case '3':
	        // enter set name to find   
	        System.out.println(enterName);
	        name = scan.nextLine();			
	        // call printSet - Print set
	        printSet(nameList, valuesList, name);
	        continue;
		case '4':
        	// Please enter two set name separated by a space
            System.out.println(unionName);
            // separate value delimited/token by blank
            unionValues = scan.nextLine().split(" ");
            // get name value
            uName1 = unionValues[0];
            uName2 = unionValues[1];
            // check if set name exist
            nameFound = "False";
            nameFound = getName(nameList, uName1);
            if (nameFound.equals("False")) {
    	        // name was not found in array list   
    	        System.out.println(noName + " " + uName1);     	
            }
            else {
                nameFound = getName(nameList, uName2);
                if (nameFound.equals("False")) {
        	        // name was not found in array list   
        	        System.out.println(noName + " " + uName2);     	
                }
                else
                {
                    // call getUnionValue
                    getUnionValue(nameList, valuesList, uName1, uName2);            
                }
            }
			continue;
		case '5':
			// Intersection
			break;
		case '6':
			// Subtraction
			
			break;
		case '7':
			// Exit
			System.exit(ch1);
			break;		
		default:
			System.out.println("Please enter a valid number");				
		}
        }
        
        
        
        
        
        
        // Calculating Intersection of two Set in Java
        //Set<String> intersection = Sets.intersection(actors, singers);
        //System.out.printf("Intersection of two Set %s and %s in Java is %s %n",
        //        singers.toString(), actors.toString(), intersection.toString());
        //System.err.println("Number of elements common in two Set : " 
        //                   + intersection.size());
      

    }
		
	/*
        Union
    */
		private static void getUnionValue(ArrayList displayName, ArrayList displayValues, String name1, String name2) {
			String arrayName1 = "";
			String arrayName2 = "";
			String value1 = "";
			String value2 = "";			
			int valueIndex = 0;
			// get first name
	    	valueIndex = displayName.indexOf(name1);
	    	arrayName1 = displayName.get(valueIndex).toString();
	        // Cast - change Object to object[]
	    	Object[] oValue = (Object[])displayValues.get(valueIndex);
	        // get value       
	        value1 = Arrays.deepToString(oValue);
            // get second name
	        valueIndex = displayName.indexOf(name2);
	    	arrayName2 = displayName.get(valueIndex).toString();
	        // Cast - change Object to object[]
	    	oValue = (Object[])displayValues.get(valueIndex);
	        // get value       
	        value2 = Arrays.deepToString(oValue);         
	    	// Print set name
	        System.out.println("Union of set name " + arrayName1 + " and " + arrayName2);        
	        // Print set name values
	        System.out.println("contain: " + value1 + " "  + value2);
				
		}		

     /*
        Intersection
    */
		private static void getIntersectionValue() {

				
		}		
		
     /*
        Subtraction
    */
		private static void subtraction() {

				
		}		
		
		
    /*
       Get Set Name 
    */
    private static String getName(ArrayList displayName, String name) {
        String nameFound = "False";
        if (displayName.contains(name)) {
        	nameFound = "True";
        }
    	return nameFound;
    }
    
    /*
      Set Name 
   */
    private static void setName(ArrayList displayName, ArrayList displayValues, String name) {
    	Scanner scan = new Scanner( System.in );  
        // create array list
        ArrayList duplicateValues = new ArrayList();        
        //
        String enterName = "Please enter a name: ";
        String nameExist = "Set Name already exist ";
        String enterValues = "Please enter values separated by a space: ";
        String displayDuplicate = "Duplicate value was entered - Name and Values was not added to the Set ";
        String noValueEntered = "No values was entered";        
        //
        String displayInput = enterValues;
        // program flag
        String nameFound = "False";
        String duplicateFound = "False";
        String xValues = "";        
        
        System.out.println(enterName);
        
        name = scan.nextLine();
        if (displayName.contains(name)) {
            System.out.println(enterName);
        }
        else
        {
        	// display Please enter values separated by a space
            System.out.println(enterValues);
            // separate value delimited/token by blank
            String[] values = scan.nextLine().split(" ");
            //
        	try {
                int valueEntered = 0;
            	// check to see if values was entered - empty array list
                xValues = Arrays.deepToString(values);
                if (xValues.equals("[]")) {
                    // return and display text
                    System.out.println(noValueEntered);
                }
                else
                {
                	// check for non-numeric value entered
                	for (int j=0; j < values.length; j++)
                	{
                    	valueEntered = Integer.parseInt(values[j]);        	
                	}                	
                    // clear array list duplicateValue of content
                	duplicateValues.clear();
                    // add values entered into duplicateValue
                    duplicateValues.add(values);
                    // call checkDuplicateValue - check for duplicate value entered
                    duplicateFound = checkDuplicateValue(duplicateValues);
                }
                // check flag duplicateFound = True
            	if (duplicateFound.equals("True"))
            	{
            		// reset flag duplicateFound = False
            		duplicateFound = "False";
            		// display text - Duplicate value was entered
                    System.out.println(displayDuplicate);            		
            	}
            	else
            	{
                	// add name to array list
                	displayName.add(name);            		
                	// add values to array list
                    displayValues.add(values);
            	}
            } catch (Exception ex1) {
                // non-numeric value was entered
            	// end program
                System.out.println("Non-numeric value was entered ");
            }        
        }
    }
    
    /*
      Check for duplicate value entered
    */    
    private static String checkDuplicateValue(ArrayList duplicateValues) {
    	String duplicateFound = "False";
    	// get values from array list
    	Object[] obj = duplicateValues.toArray();
    	String oValues = Arrays.deepToString(obj);
    	// remove [[ and ]] from array list values
        oValues = oValues.replace("[[", "");
        oValues = oValues.replace("]]", "");        
    	// separate array list value by comma and blank
        String[] values = oValues.split(", ");
    	int iLen = values.length;
    	// determine if array list contain duplicate value
    	for (int a = 0; a < iLen; a++) {
            for (int b = a + 1; b < iLen; b++) {
                if (values[b].equals(values[a])) {
                    // duplicate found
                	duplicateFound = "True";
                	a = iLen;
                	break;
                }
            }
    	}
    	return duplicateFound;
    }
    
    /*
        print Set and Values 
   */
    private static void printSet(ArrayList displayName, ArrayList displayValues, String name) {
    	int valueIndex = 0;
    	valueIndex = displayName.indexOf(name);
    	String arrayName = displayName.get(valueIndex).toString();
        // Cast - change Object to object[]
    	Object[] oValue = (Object[])displayValues.get(valueIndex);
        // get value       
        String value1 = Arrays.deepToString(oValue);         
    	// Print set name
        System.out.println("Set name is: " + arrayName);        
        // Print set name values
        System.out.println("Set contain: " + value1);
    }
    
    /*
        print Set and Values 
   */
    private static void printAllSet(ArrayList displayName, ArrayList displayValues) {
    	String arrayName = "";
    	String value1 = "";
    	Object[] oValue = null;
    	//valueIndex = displayName.indexOf(name);
    	for (int a = 0; a < displayName.size(); a++) {
        	arrayName = displayName.get(a).toString();
            // Cast - change Object to object[]
        	oValue = (Object[])displayValues.get(a);
            // get value       
            value1 = Arrays.deepToString(oValue);         
        	// Print set name
            System.out.println("Set name is: " + arrayName);        
            // Print set name values
            System.out.println("Set contain: " + value1);    		
    	}
    	
    	
    }    
}

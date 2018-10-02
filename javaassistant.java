import javafx.application.Application;
import java.util.Scanner;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

/* 
 * Rikki Honnold Java ICS_141 section 1 
 * November 2017
This program will go to a website and pull up the list of employees. It will then scan the list of employees and calculate which one is a full professor, assistant professor or associate professor.
Then, it will sum the salaries of each professor type and average the salaries. 
When the required button is depressed, it will print off the salary quantities for the user to see in the texbox
This uses javafx to do so.

*/
	
	public class Homework6 extends Application  {
	 
	//declare all of the buttons, textfields and gridpanes
		 
        Button button1;
         
        Button button2;
        
        Button button3;
        
        Button button4;
         
        Button button5;
       
        Button button6;
     
        Button button7;
       
        Button button8;
        Button button9;
        Button button10;
        Button button11;
        TextField textfield;
        TextArea textarea;
        Border border;
        BorderPane pane;
       
        //declare initial variables for each type of professor and their salaries
        static double averageAssistant;
        static double averageAssociate;
        static double averageFull;
        static double averageFaculty;
        static double salaryFaculty;
        static double salaryAssistant;
        static double salaryAssociate;
        static double salaryFull;
        static double average;
        static String fullWebsite;
        
	    @Override
	    public void start(Stage primaryStage) throws Exception {
	    		
	    	//This long declaration creates each button, the color and the lambda effects fill text to put in the text pane
	        button1 = new Button("Total Salary Assistant Professor ");
	        button1.setTextFill(Color.WHITE);
	        button1.setStyle("-fx-background-color: Black;");
		    button1.setOnAction(e -> {textarea.setText("Assistant Professor " +salaryAssistant);});
	       
		    button2 = new Button("Average Salary Assistance Professor ");
	        button2.setTextFill(Color.WHITE);
	        button2.setStyle("-fx-background-color: Black;"); 
			button2.setOnAction(e -> {textarea.setText("Average Assist Prof " + averageAssistant);}); 
	       
			button3 = new Button("Total Salary Associate Professor ");
	        button3.setOnAction(e -> {textarea.setText("Total Salary Associate Professor " + salaryAssociate);});
	        button3.setTextFill(Color.WHITE);
	        button3.setStyle("-fx-background-color: Black;");
	        
	        button4 = new Button("Average Salary Associate Professor");
	        button4.setTextFill(Color.WHITE);
	        button4.setStyle("-fx-fill: Black;-fx-background-color: Black; ");
	        button4.setStyle("-fx-background-color: Black;");
			button4.setOnAction(e -> {textarea.setText("Average Salary Associate Professor" + averageAssociate);});
			
	        button5 = new Button("Total Salary Full Professor ");
	        button5.setTextFill(Color.WHITE);
	        button5.setStyle("-fx-fill: Black;");
	        button5.setStyle("-fx-background-color: Black;");
			button5.setOnAction(e -> {textarea.setText("Average Salary Faculty " + salaryFull);});
			
	        button6 = new Button("Average Salary Full Professor");
	        button6.setStyle("-fx-fill: Black;");
	        button6.setStyle("-fx-background-color: Black;");
	        button6.setTextFill(Color.WHITE);
		    button6.setOnAction(e -> {textarea.setText("Average Salary Full Professor " + averageFull);});
			 
	        button7 = new Button("Total Salary Faculty ");
	        button7.setStyle("-fx-fill: Black;");
	        button7.setStyle("-fx-background-color: Black;");
	        button7.setTextFill(Color.WHITE);
	        button7.setOnAction(e -> {textarea.setText("Total Salary Faculty " + salaryFaculty);});
	        
	        button8 = new Button("Average Salary Faculty ");
	        button8.setStyle("-fx-fill: Black;");
	        button8.setStyle("-fx-background-color: Black;");
	        button8.setTextFill(Color.WHITE);
	        button8.setOnAction(e -> {textarea.setText("Average Salary Faculty " + averageFaculty);});
	        
        	    button10 = new Button("Display Contents");
    	        button10.setStyle("-fx-background-color: Gray;");
    	        button10.setOnAction(e -> {textarea.setText("data" + fullWebsite);});
    	       
    	        button11 = new Button("Graphic User Interface GUI Based Web Crawler");
    	        button11.setStyle("-fx-background-color: Gray;");
    	        textfield = new TextField("http://cs.armstrong.edu/liang/data/Salary.txt");
    	         
	        GridPane gridPane = new GridPane();
	        gridPane.setStyle("-fx-border-color: lightblue; fx-border: 200; -fx-background-color: lightblue;"); 
	        gridPane.setPadding(new Insets(40, 40, 40, 40));//this padding is for the scene to set the gridpane in 50 px on each side
	        gridPane.setHgap(10);//gives 10 px of padding between the top and the bottom
	        gridPane.setVgap(10);
	        
	        //This creates the white box at the bottom of the screen for the page
	   
	        textarea = new TextArea();
	        
	       //This positions all of the buttons in the gridpane. The names of the buttons are listed below
//          column, row, column span, row span
	        gridPane.add(button10, 0, 1, 3, 1);// display contents button
	        gridPane.add(textfield, 1, 1, 2, 1);//URL
	        gridPane.add(button1, 0, 2, 1, 1);//Total Salary Assistant Professor
	        gridPane.add(button2, 0, 3, 1, 1); //Average Salary Assistance Professor
	        gridPane.add(button3, 1, 2, 1, 1); //Total Salary Associate Professor
	        gridPane.add(button4, 1, 3, 1, 1); //Average Salary Associate Professor
	        gridPane.add(button5, 2, 2, 1, 1); //Total Salary Full Professor
	        gridPane.add(button6, 2, 3, 1, 1); //Average Salary Full Professor
	        gridPane.add(button7, 3, 2, 1, 1); //Total Salary Faculty
	        gridPane.add(button8, 3, 3, 1, 1);   //Average Salary Faculty 
	        gridPane.add(textarea, 0, 4, 3, 1); //blank white box at the bottom
	        //gridPane.add(pane, 0, 0);
			
	         Scene scene = new Scene(gridPane, 1000, 1000, Color.BLUE);
	         primaryStage.setTitle("Graphic User Interface (GUI) Based Web Crawler"); // Set the stage title
	         primaryStage.setScene(scene);
	         primaryStage.show();   
	    }
	public static void main(String[] args) {
		 //This pulls from the URL on the website  
		 //This will calculate the salary averages, parse the data from the website and display it
		 String URLString = "http://cs.armstrong.edu/liang/data/Salary.txt";
	   
				        try {
				          java.net.URL url = new java.net.URL(URLString);
				           
				          //this establishes all of the counts for the various if/else loops, for each time of professor
				          int countFaculty = 0;
				          int countAssistantProf = 0;
				          int AssociateProf = 0;
				          int  FullProf = 0;
				          //this establishes the inital variable for the salary of each profesor type
				         salaryFaculty = 0.0;
				         salaryAssistant = 0;
				         salaryAssociate = 0;
				         salaryFull = 0;
				         average = 0;
				          
				         //this is the part that reads everything from the website
				          Scanner input = new Scanner(url.openStream());
				          fullWebsite = "";    // declare variable for the display contents button
				      while (input.hasNext()) {
				    	  //keeps looking for new lines on the wensite
				        		String line = input.nextLine();
				        		//this stores all of the data so that the "display contents" button on the screen will work
				        		fullWebsite = fullWebsite + line + "\n";
//this puts all of the words into an array, splitting each line at the space
				        		String words [] = line.split(" ");
				        //starts counting the number of times the word "Faculty" appears on the third position in the array
				            		countFaculty++;
				            		 salaryFaculty += Double.parseDouble(words[3]); //need to convert string to Double here
				            		//starts counting the number of times the word "Associate" appears on the third position in the array
				             if(words[2].equalsIgnoreCase("associate")) {//look for the word associate in the line of text
				           	AssociateProf++; //count the associate professor
			            		salaryAssociate += Double.parseDouble(words[3]); // look for the third set of data in the array
			            		//starts counting the number of times the word "full" appears on the third position in the array 
			            		 
				            } else if (words[2].equalsIgnoreCase("full")) {//look for the word full in the line of text from the website
				            FullProf++; //count the full professors
			            		 salaryFull += Double.parseDouble(words[3]);
			            		//starts counting the number of times the word "assistant" appears on the third position in the array 
			            		  
				            } else if (words[2].equalsIgnoreCase("assistant")) {// look for the word assistant in the line of text from the website
				            	countAssistantProf++; //count the assistant professors
				             salaryAssistant += Double.parseDouble(words[3]); 
				              

				            }
				        } 
				      //This calculates the average of each salary range by summing each word and dividing it by the total count
				        averageAssistant = salaryAssistant/countAssistantProf; //calculating average outside of the loop
				        averageAssociate =  salaryAssociate/AssociateProf;
				        averageFull =  salaryFull/FullProf;
				        averageFaculty = salaryFaculty/countFaculty;	
				        
				      }
				      
				                     catch (java.net.MalformedURLException ex) {
				                  
				        System.out.println("Invalid URL"); // regular exception for this type of code, be sure http vs https
				        
				      }
				        
				      catch (java.io.IOException ex) {
				        System.out.println("I/O Errors: no such file");
				      }
		   Application.launch(args); // Java standard for launching applications in main method

		}
	}

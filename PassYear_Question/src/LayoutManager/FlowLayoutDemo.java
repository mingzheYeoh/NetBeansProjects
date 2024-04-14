package LayoutManager;

// Java program to show Example of FlowLayout. 
// in java. Importing different Package. 
import java.awt.*; 
import javax.swing.*; 

class Example extends JFrame { 
	// Declaration of objects of JLabel class. 
	JLabel l1, l2, l3, l4, l5; 

	// Constructor of Example class. 
	public Example() 
	{ 
		// Creating Object of "FlowLayout" class 
		FlowLayout layout = new FlowLayout(); 

		// this Keyword refers to current object. 
		// Function to set Layout of JFrame. 
		this.setLayout(layout); 

		// Initialization of object "l1" of JLabel class. 
		l1 = new JLabel("Label 1 "); 

		// Initialization of object "l2" of JLabel class. 
		l2 = new JLabel("Label 2 "); 

		// Initialization of object "l3" of JLabel class. 
		l3 = new JLabel("Label 3 "); 

		// Initialization of object "l4" of JLabel class. 
		l4 = new JLabel("Label 4 "); 

		// Initialization of object "l5" of JLabel class. 
		l5 = new JLabel("Label 5 "); 

		// this Keyword refers to current object. 
		// Adding Jlabel "l1" on JFrame. 
		this.add(l1); 

		// Adding Jlabel "l2" on JFrame. 
		this.add(l2); 

		// Adding Jlabel "l3" on JFrame. 
		this.add(l3); 

		// Adding Jlabel "l4" on JFrame. 
		this.add(l4); 

		// Adding Jlabel "l5" on JFrame. 
		this.add(l5); 
	} 
} 

class MainFrame { 
	// Driver code 
	public static void main(String[] args) 
	{ 
		// Creating Object of Example class. 
		Example f = new Example(); 

		// Function to set title of JFrame. 
		f.setTitle("Example of FlowLayout"); 

		// Function to set Bounds of JFrame. 
		f.setBounds(200, 100, 600, 400); 

		// Function to set visible status of JFrame. 
		f.setVisible(true); 
	} 
} 

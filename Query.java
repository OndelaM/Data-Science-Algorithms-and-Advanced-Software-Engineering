import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

// This class will contain all of the behaviour to get and execute a MySQL query
public class Query {
	

	//A method to execute a query of the modify type
	public static void executeModifyQuery(String query) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_db?useSSL=false" , "myuser" ,"luna");
			Statement stmt = conn.createStatement();
			

			int queryCount = stmt.executeUpdate(query);
			//System.out.println(queryCount + " records updated");
			JOptionPane.showMessageDialog(null, queryCount + " records updated","Query Results", JOptionPane.PLAIN_MESSAGE);
			
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	//A method to execute a query of the search type
	public static void executeSearchQuery(String query) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_db?useSSL=false" , "myuser" ,"luna");
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			String results = "";
			
			while(rset.next()) {
				results += String.format("%d, %s, %s, %d\n", rset.getInt("id"), rset.getString("title"), rset.getString("author"),rset.getInt("qty"));
				//System.out.printf("%d, %s, %s, %d\n", rset.getInt("id"), rset.getString("title"), rset.getString("author"),rset.getInt("qty"));
			}
			
			JOptionPane.showMessageDialog(null, results,"Query Results", JOptionPane.PLAIN_MESSAGE);
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	//A method to create a string of the desired query and use it in the relevant execute method
	public static void searchQuery() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Which column would you like to search");
		String searchColumn = sc.nextLine();
		System.out.println("What " + searchColumn + " are you looking for?");
		String searchField = sc.nextLine();
		//sc.close();
		
		String strSearch = String.format("SELECT * FROM books WHERE %s = '%s'", searchColumn, searchField);
		System.out.println("The SQL Query is: " + strSearch);
		executeSearchQuery(strSearch);
		
		
	}

	
	//A method to create a string of the desired query and use it in the relevant execute method
	public static void enterQuery() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter an id for your book.");
		String id = sc.nextLine();
		System.out.println("Please enter a title for your book.");
		String title = sc.nextLine();
		System.out.println("please enter the name of the author.");
		String author = sc.nextLine();
		System.out.println("How many copies are in stock?");
		String qty = sc.nextLine();
		//sc.close();
		
		String strAdd = String.format("INSERT INTO books values (%s, '%s', '%s', %s)",id,title,author,qty);
		System.out.println("The SQL query is: " + strAdd);
		
		executeModifyQuery(strAdd);
		
	}
	
	
	//A method to create a string of the desired query and use it in the relevant execute method
	public static void updateQuery() {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Please enter the column you would like to change.");
		String setColumn = sc.nextLine();
		System.out.println("Please enter the " + setColumn +" you would like to update.");
		String setField = sc.nextLine();
		System.out.println("Please enter the column you would like to select");
		String testColumn = sc.nextLine();
		System.out.println("Please enter the " + testColumn + " you would like to find");
		String testField = sc.nextLine();
		//sc.close();
		
		
		String strUpdate = String.format("UPDATE books SET %s = '%s' WHERE %s = '%s'", setColumn, setField, testColumn, testField);
		System.out.println("The SQL query is " + strUpdate);
		
		executeModifyQuery(strUpdate);
		
		
	}
	
	
	//A method to create a string of the desired query and use it in the relevant execute method
	public static void deleteQuery() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the column you would like to search by.");
		String delColumn = sc.nextLine();
		System.out.println("Please enter the " + delColumn + " of the record you would like to delete");
		String delField = sc.nextLine();
		//sc.close();
		
		String strDelete = String.format("DELETE FROM books WHERE %s = '%s'",delColumn, delField);
		System.out.println("The SQL query is: " + strDelete);
		
		executeModifyQuery(strDelete);
		
	}


}

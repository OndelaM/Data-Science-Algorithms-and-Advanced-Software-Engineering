import java.util.Scanner;

//This class will deal with the menu that the user sees
public class Menu {
	
	//A method to display the menu in the console
	public static String showMenu(){
	return (
			"Please use the keyboard to select what you would like to do.\n"
			+ "1. Enter Book \n"
			+ "2. Update Book\n"
			+ "3. Delete Book\n"
			+ "4. Search Books\n"
			+ "5. Exit\n");
	}
	
	
	//A method to take user input and execute the instructions given by the user
	public static void databaseMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Greetings Bookstore Clerk\n");
		int selection;

		do {
			System.out.println(showMenu());
			selection = sc.nextInt();
			
			switch (selection) {
			case 1: 
				Query.enterQuery();
				break;
			case 2:
				Query.updateQuery();
				break;
			case 3:
				Query.deleteQuery();
				break;
			case 4: 
				Query.searchQuery();
				break;
			case 5:
				System.out.println("Thanks for using the Bookstore Express :)");
				break;
			default: 
				System.out.println("I do not understand what you want to do.");
			}
			System.out.println("\n");
		}while (selection != 5);

		sc.close();
	}

}

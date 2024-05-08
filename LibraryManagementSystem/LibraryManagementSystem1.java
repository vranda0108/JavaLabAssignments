//import java.util.Scanner;

class Person {
	public String name;
    	public String regNumber;
    	public String department;
    	public int contactNumber;
    	public String gmailID;

    	public Person(String name, String regNumber, String department, int contactNumber, String gmailID) {
        	this.name = name;
        	this.regNumber = regNumber;
        	this.department = department;
        	this.contactNumber = contactNumber;
        	this.gmailID = gmailID;
    	}	
}

class BookManager {
    	public String[] books;
    	public boolean[] availability;
    	public boolean[] borrowed;

    	public BookManager(String[] books) {
        	this.books = books;
        	this.availability = new boolean[books.length];
        	this.borrowed = new boolean[books.length];
        	// Initially, all books are available and not borrowed
        	for (int i = 0; i < books.length; i++) {
            		availability[i] = true;
            		borrowed[i] = false;
        	}
    	}

    	// Function to lend a book from the library
    	public void borrowBook(int bookNumber) {
        	if (bookNumber > 0 && bookNumber <= books.length && availability[bookNumber - 1]) {
            		availability[bookNumber - 1] = false; // marking the book as unavailable
            		borrowed[bookNumber - 1] = true; // marking the book as borrowed
            		System.out.println("You have borrowed: " + books[bookNumber - 1]);
            		System.out.println("Total books borrowed: " + countBorrowedBooks());
        	} 
        	else {
            		System.out.println("Invalid book number or book not available.");
        	}
    	}

    	// Function to return a book to the library
    	public void returnBook(int bookNumber) {
        	if (bookNumber > 0 && bookNumber <= books.length && borrowed[bookNumber - 1]) {
            		availability[bookNumber - 1] = true; // marking the book as available
            		borrowed[bookNumber - 1] = false; // marking the book as returned
            		System.out.println("You have returned " + books[bookNumber - 1]);
            		System.out.println("Total books borrowed: " + countBorrowedBooks());
        	} 
        	else {
            		System.out.println("Invalid book number or book not borrowed by you.");
        	}
    	}

    	// Function to renew a borrowed book
    	public void renewBook(int bookNumber) {
        	if (bookNumber > 0 && bookNumber <= books.length && borrowed[bookNumber - 1]) {
            		System.out.println("You have renewed " + books[bookNumber - 1]);
        	} 
        	else {
            		System.out.println("Invalid book number or book not borrowed by you.");
        	}
    	}

    	// Function to count the total number of borrowed books
    	private int countBorrowedBooks() {
        	int count = 0;
        	for (boolean status : borrowed) {
            		if (status) {
                		count++;
            		}
        	}
        	return count;
    	}
}

class LibraryManagementSystem {

	public static void main(String args[]) {
        	java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        	//details of person
        	System.out.println("Welcome to the Library Management System!");
        	System.out.print("Enter your name: ");
        	String Name = scanner.nextLine();       
        	System.out.print("Enter your user ID: ");
        	java.util.Scanner stringScanner = new java.util.Scanner(System.in);
        	String RegistrationNumber = stringScanner.next();
        	System.out.print("Enter your Department: ");
        	String Department = scanner.nextLine();
        	/*System.out.print("Enter your Contact Number: ");
        	int contactNumber = 0;
        	try {
            		contactNumber = scanner.nextInt();
        	} 
        	catch (Exception e) {
            		System.out.println("Invalid contact number entered. Please enter a valid integer.");
            		return;
        	}*/
        	int contactNumber = 0;
        	boolean validContactNumber = false;
        	while (!validContactNumber) {
            		System.out.print("Enter your Contact Number: ");
            		try {
                		contactNumber = Integer.parseInt(scanner.nextLine());
                		validContactNumber = true;
            		} 
            		catch (NumberFormatException e) {
                		System.out.println("Invalid contact number entered. Please enter a valid integer.");
            		}
        	}
        	/*System.out.print("Enter your user G-Mail ID: ");
        	String gmailID = stringScanner.next();*/
        	String gmailId;
        	boolean validGmailId = false;
        	while (!validGmailId) {
            		System.out.print("Enter your user G-Mail ID: ");
            		gmailId = scanner.nextLine();
            		if (isValidEmail(gmailId)) {
                		validGmailId = true;
            		} 
            		else {
                		System.out.println("Invalid email ID entered. Please enter a valid email ID.");
            		}
        	}
        	
        	// Array to represent the books available in the library
        	String[] books = {"Java Programming",
                		  "Java-The Complete Reference",
                		  "Python Programming",
                		  "C++",
                		  "C Language"};

        	// Creating a BookManager instance
        	BookManager bookManager = new BookManager(books);

        	// Variable to keep track of whether the user wants to continue lending or returning books
        	char action = ' ';

        	while (action != 'E' && action != 'e') {
            		// Displaying available books
            		System.out.println("Available Books:");
            		for (int i = 0; i < books.length; i++) {
                		if (bookManager.availability[i]) {
                    			System.out.println((i + 1) + ". " + books[i]);
                		}
            		}

            		// Displaying borrowed books
            		System.out.println("Borrowed Books:");
            		for (int i = 0; i < books.length; i++) {
                		if (bookManager.borrowed[i]) {
                    			System.out.println((i + 1) + ". " + books[i]);
                		}
            		}

            		// Asking user to select an action
            		System.out.println("Choose an action:");
            		System.out.println("L - Lend a book");
            		System.out.println("R - Return a book");
            		System.out.println("N - Renew a book");
            		System.out.println("E - Exit");
            		System.out.print("Enter your choice: ");
            		action = scanner.next().charAt(0);

            		switch (action) {
                		case 'L':
                		case 'l':
                    		// Asking user to select a book to lend
                    		System.out.print("Enter the book number you want to borrow: ");
                    		int borrowBookNumber = scanner.nextInt();
                    		bookManager.borrowBook(borrowBookNumber);
                    		break;
                		case 'R':
                		case 'r':
                    		// Asking user to select a book to return
                    		System.out.print("Enter the book number you want to return: ");
                    		int returnBookNumber = scanner.nextInt();
                    		bookManager.returnBook(returnBookNumber);
                    		break;
                		case 'N':
                		case 'n':
                    		// Asking user to select a book to renew
                    		System.out.print("Enter the book number you want to renew: ");
                    		int renewBookNumber = scanner.nextInt();
                    		bookManager.renewBook(renewBookNumber);
                    		break;
                		case 'E':
                		case 'e':
                    		// Exiting the loop if the user chooses to exit
                    		break;
                		default:
                    		System.out.println("Invalid choice. Please try again.");
            		}
        	}

        	// Closing scanner and stringScanner
        	scanner.close();
        	stringScanner.close();

        	// Displaying thank you message
        	System.out.println("Thank you for visiting the library!");
    	}
    	
    	private static boolean isValidEmail(String email) {
        	// Simple email validation logic
        	return email.contains("@") && email.contains(".");
    	}
}


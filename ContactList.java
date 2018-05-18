//Ezekial Page
//creates contact list application

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class ContactList{
	public static void main(String [] args) throws FileNotFoundException{
		//create new linked list
		LinkedList<Contact> contactsList = new LinkedList<Contact>(); 
		
		//create scanner for input file
		File inFile = new File("Contacts.txt");
		Scanner fScan = new Scanner(inFile);
		
		//read in from file
		while(fScan.hasNext()){
			//get contact name
			String last = fScan.next();
			String first = fScan.next();
			
			//get contacts phone number
			String phone = fScan.next();

			//get picture for contact
			String pic = fScan.next();
			
			//create object for contact
			Contact c1 = new Contact(first, last, phone, pic);
			//enter object into list
			contactsList.addAlpha(c1);
		}
		
		//create scanner for user input
		Scanner kScan = new Scanner(System.in);

		//display menu
		System.out.println("U    Upflip\nD    Downflip\nA    Add new contact\nR    Remove existing contact\nQ    Quit\n");
		System.out.print("Enter the letter corresponding to your choice: ");		
		
		//get user menu option
		String input = kScan.next();
		System.out.println();

		//create loop to continue until user enters Q
		while(!input.equalsIgnoreCase("Q")){

			if(input.equalsIgnoreCase("U")){
				System.out.println(contactsList.toString());
			}else if(input.equalsIgnoreCase("D")){
				System.out.println(contactsList.revString());
			}else if(input.equalsIgnoreCase("A")){
				//fillList(contactsList);
				System.out.print("Enter new contact info: ");
				String newLast = kScan.next();
				String newFirst = kScan.next();
				String newPhone = kScan.next();
				String newPic = kScan.next();
				
				Contact c2 = new Contact(newFirst, newLast, newPhone, newPic);
				contactsList.addAlpha(c2);
				System.out.println("Added Contact");
				System.out.println();
			}else if(input.equalsIgnoreCase("R")){
				System.out.print("Enter name of contact to remove(\"first last\"): ");
				String in = kScan.next();
				String in2 = kScan.next();
				if(contactsList.search(in, in2)){
					System.out.println("Contact Removed");
					System.out.println();
				}else{
					System.out.println("Contact not found.");
					System.out.println();
				}
			}else{
				System.out.println("Error! Invalid input.");
				System.out.println();
			}

			//display menu
			System.out.println("U    Upflip\nD    Downflip\nA    Add new contact\nR    Remove existing contact\nQ    Quit\n");
			System.out.print("Enter the letter corresponding to your choice: ");		
			
			//get user menu option
			input = kScan.next();
			System.out.println();

		}
	}
}

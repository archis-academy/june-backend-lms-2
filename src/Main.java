import java.util.Scanner;

public class Main {

    static int INDEX = 50;
    static String[][] books = new String[INDEX][4]; // ISBN - Title - Author - Additional Information
    static String[][] users = new String[INDEX][4]; // Identity Number - Name - Email - Password
    static String[][] transactions = new String[INDEX][3];// ISBN - User Id - Date
    static int bookQuantity = 0;
    static int userQuantity = 0;
    static int transactionQuantity = 0;


    public static void main(String[] args) {

    }


    static void displayBookDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the title of the book that you're interested for detailed information: ");
        String bookTitle = scanner.nextLine();

    static void removeBook(String ISBN, String bookName) {
        if (bookQuantity == 0) {
            System.out.println("There is no book in the library.");

        }


        boolean bookFound = false;

        for (int i = 0; i < bookQuantity; i++) {

            if (books[i][1].equals(bookTitle)) {
                System.out.println("\nHere is your desired book ->");
                System.out.println("Title: " + books[i][1]);
                System.out.println("ISBN: " + books[i][0]);
                System.out.println("Author: " + books[i][2]);
                System.out.println("Additional Information: " + books[i][3]);
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            System.out.println("Oops, Book Not Found!");
        }

            if(books[i][0].equals(ISBN) && books[i][1].equals(bookName)){
                bookFound = true;

                for(int j = i; j < bookQuantity - 1; j++){
                    books[j] = books[j + 1];
                }

                books[bookQuantity - 1] = null;
                bookQuantity--;
                System.out.printf("\"%s\" - book with this specific name and \"%s\" ISBN is deleted from the library succesfully.\n", bookName,ISBN);
                break;
            }
        }

        if(!bookFound){
            System.out.println("Book Not Found!");
        }
    }

    static void addBook(String ISBN, String title, String author, String additionalInformation) {
        if (bookQuantity < INDEX) {
            books[bookQuantity][0] = ISBN;
            books[bookQuantity][1] = title;
            books[bookQuantity][2] = author;
            books[bookQuantity][3] = additionalInformation;

            bookQuantity++;
        } else {
            System.out.println("\nOur shelves are full, so that we can't add the new one...");
        }

    }

}
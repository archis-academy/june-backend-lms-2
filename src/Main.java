import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {

    static int INDEX = 50;
    static String[][] books = new String[INDEX][4]; // ISBN - Title - Author - Additional Information
    static String[][] users = new String[INDEX][4]; // Identity Number - Name - Email - Password
    static String[][] transactions = new String[INDEX][3];// ISBN - User Id - Date
    static int bookQuantity = 0;
    static int userQuantity = 0;
    static int transactionQuantity = 0;
    static Scanner scanner = new Scanner(System.in);
    static LocalDate currentDate = LocalDate.now();
    static DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
    }

    static void extendBooksArrayOnAddition(String newBookISBN, String newBookTitle, String newBookAuthor, String newBookAdditionalInformation) {

        String[][] additionalBooks = new String[books.length + 1][4];

        System.arraycopy(books, 0, additionalBooks, 0, books.length);
        additionalBooks[books.length][0] = newBookISBN;
        additionalBooks[books.length][1] = newBookTitle;
        additionalBooks[books.length][2] = newBookAuthor;
        additionalBooks[books.length][3] = newBookAdditionalInformation;

        bookQuantity++;
        books = additionalBooks;

    }


    static int countTotalBooks() {
        if (bookQuantity != 0) {
            System.out.println("\nTotal Book Quantity in the library: " + bookQuantity);
            return bookQuantity;
        } else {
            System.out.println("\nThere is no book in the library.");
            return 0;
        }
    }


    static void viewAvailableBooks() {
        boolean bookFound = false;

        if (bookQuantity != 0) {
            bookFound = true;
            System.out.println("\nHere is the list of all available books in the library  ->\n");

            for (int i = 0; i < bookQuantity; i++) {
                System.out.print("Book " + (i + 1) + ": ");
                System.out.println(books[i][1]);
            }
        }
        if (!bookFound) {
            System.out.println("Oops, sth wrong happened while finding books.");
        }
    }


    static void displayBookDetails() {

        System.out.print("\nEnter the title of the book that you're interested for detailed information: ");
        String bookTitle = scanner.nextLine();

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
    }


    static void removeBook(String ISBN) {
        if (bookQuantity == 0) {
            System.out.println("There is no book in the library.");
        }

        boolean bookFound = false;

        for (int i = 0; i < bookQuantity; i++) {
            if (books[i][0].equals(ISBN)) {
                bookFound = true;

                for (int j = i; j < bookQuantity - 1; j++) {
                    books[j] = books[j + 1];
                }

                books[bookQuantity - 1] = null;
                bookQuantity--;
                System.out.printf("\"%s\" - book with specific ISBN is deleted from the library succesfully.\n", ISBN);
                break;
            }
        }

        if (!bookFound) {
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


    static void deleteUserInformation(String ID) {
        if (userQuantity == 0) {
            System.out.println("\nThere is no user registered on the system.");
        }

        boolean userFound = false;

        for (int i = 0; i < userQuantity; i++) {
            if (users[i][0].equals(ID)) {
                userFound = true;
            }

            for (int j = i; j < userQuantity - 1; j++) {
                users[j] = users[j + 1];
            }

            users[userQuantity - 1] = null;
            userQuantity--;
            System.out.printf("\n\"%s\" - user with the given ID is deleted from the system.", ID);
            break;
        }

        if (!userFound) {
            System.out.println("\nOops, user not found.");
        }
    }


    static void updateBook(String newISBN, String newTitle, String newAuthor, String newInfo) {

        System.out.print("Please enter the ISBN of the book you would like to update here: ");
        String bookISBNForUpdate = scanner.nextLine();

        boolean bookFound = false;

        for (int i = 0; i < bookQuantity; i++) {
            if (books[i][0].equals(bookISBNForUpdate)) {
                bookFound = true;

                books[i][0] = newISBN;
                books[i][1] = newTitle;
                books[i][2] = newAuthor;
                books[i][3] = newInfo;

                System.out.println("Book succesfully updated.");
            }
        }
        if (!bookFound) {
            System.out.println("Such book is not available in the library.");
        }
    }

    static void updatePatronInfo(String newID, String newUserName, String newEmail, String newPassword) {

        System.out.print("Please enter the ID of the user you would like to update: ");
        String IDForUpdate = scanner.nextLine();

        boolean userFound = false;

        for (int i = 0; i < userQuantity; i++) {
            if (users[i][0].equals(IDForUpdate)) {
                userFound = true;

                users[i][0] = newID;
                users[i][1] = newUserName;
                users[i][2] = newEmail;
                users[i][3] = newPassword;

                System.out.println("\nUser updated succesfully.");
            }
        }
        if (!userFound) {
            System.out.println("\nOops, user with these credentials is not found.");
        }
    }

    static void initialArrays() {
        countTotalBooks();
        for (int i = 0; i < bookQuantity; i++) {
            System.out.println("\nTitle: " + books[i][1]);
            System.out.println("ISBN: " + books[i][0]);
            System.out.println("Author: " + books[i][2]);
            System.out.println("Additional Information: " + books[i][3]);
        }

        System.out.println("\nUsers actively registered on the system: " + userQuantity);
        for(int i = 0; i < userQuantity; i++){
            System.out.println("\nName: " + users[i][1]);
            System.out.println("ID Number: " + users[i][0]);
            System.out.println("Email: " + users[i][2]);
        }

        System.out.println("\nCurrently active transactions on the system: " + transactionQuantity);
        for(int i = 0; i < transactionQuantity; i++){
            System.out.println("\nUser ID: " + transactions[i][1]);
            System.out.println("Book ISBN: " + transactions[i][0]);
            System.out.println("Transaction Date: " + transactions[i][2]);
        }
    }

    static void reserveBook(String bookISBN, String userID, int reservationDuration){

        boolean isBookAvailable = false;

        for(int i = 0; i < bookQuantity; i++){
            if(books[i][0].equals(bookISBN)){
                isBookAvailable = true;
                break;
            }
        }

        if(isBookAvailable){

            int daysTillCheckout = 3;
            LocalDate pickUpDeadline = currentDate.plusDays(daysTillCheckout);// in 3 days, u have to take it from library
            LocalDate reservationEndDate = currentDate.plusDays(reservationDuration);

            System.out.printf("You have succesfully reserved this book until this date - \"%s\"\n", reservationEndDate.format(formattedDate));
            System.out.printf("You have to pick up the book  until this date - \"%s\"\n", pickUpDeadline.format(formattedDate));

            LocalDate userPickUpDate = currentDate.plusDays(4);

            if(userPickUpDate.isBefore(pickUpDeadline) || userPickUpDate.isEqual(pickUpDeadline)){
                System.out.println("You have picked up the book on time.");
                if(transactionQuantity < INDEX){
                    transactions[transactionQuantity][0] = bookISBN;
                    transactions[transactionQuantity][1] = userID;
                    transactions[transactionQuantity][2] = currentDate.toString();
                    transactionQuantity++;
                }
            }
            else{
                System.out.println("You failed to pick up the book on time, Reservation failed.");
            }
        }
        else{
            System.out.println("Reservation failed, please try again.");
        }
    }
}

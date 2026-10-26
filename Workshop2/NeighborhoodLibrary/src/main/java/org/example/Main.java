package org.example;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[20];
        // 5 Fantasy books
        books[0] = new Book(1, "978-0547928227", "The Hobbit", false, "");
        books[1] = new Book(2, "978-0439708180", "Harry Potter", true, "John Smith");
        books[2] = new Book(3, "978-0765326355", "The Way of Kings", false, "");
        books[3] = new Book(4, "978-0553573428", "A Game of Thrones", true, "Sarah Johnson");
        books[4] = new Book(5, "978-0756404741", "The Name of the Wind", false, "");

// 5 Romance books
        books[5] = new Book(6, "978-0141439518", "Pride and Prejudice", false, "");
        books[6] = new Book(7, "978-1538724736", "The Notebook", true, "Emily Davis");
        books[7] = new Book(8, "978-0679783268", "Jane Eyre", false, "");
        books[8] = new Book(9, "978-0140449266", "The Time Traveler's Wife", true, "Michael Brown");
        books[9] = new Book(10, "978-0446691862", "The Wedding", false, "");

// 5 Fiction books
        books[10] = new Book(11, "978-0743273565", "The Great Gatsby", true, "David Wilson");
        books[11] = new Book(12, "978-0316769488", "The Catcher in the Rye", false, "");
        books[12] = new Book(13, "978-0061120084", "To Kill a Mockingbird", true, "Jessica Lee");
        books[13] = new Book(14, "978-0451524935", "1984", false, "");
        books[14] = new Book(15, "978-0060850524", "Brave New World", true, "Robert Taylor");

// 5 Horror books
        books[15] = new Book(16, "978-1501142970", "It", false, "");
        books[16] = new Book(17, "978-0307743657", "The Shining", true, "Amanda White");
        books[17] = new Book(18, "978-1501175466", "Pet Sematary", false, "");
        books[18] = new Book(19, "978-0451167804", "The Amityville Horror", true, "Chris Martin");
        books[19] = new Book(20, "978-0307743664", "Carrie", false, "");
        boolean start = true;
        int choice = 1;
        while (choice != 0) {
            System.out.println();
            System.out.println("---------------- Home Screen ----------------");
            System.out.println("1. Available Books");
            System.out.println("2. Checked Out Books");
            System.out.println("0. Exit");
            System.out.print("Choose between 0-2: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            while(choice != 0) {
                if (choice > 0 && choice <= 3) {
                    break;
                }else{
                    System.out.print("You enter a wrong choice. Try Again: \n");
                    choice = Integer.parseInt(scanner.nextLine());;
                }
            }
            switch (choice) {
                case 1:
                    System.out.println("---------------- Available Books ----------------");
                    for (Book book : books) {
                        if (!book.isCheckedOut()) {
                            System.out.printf("ID: %d :: ISBN: %s :: Title: %s.\n", book.getId(), book.getIsbn(), book.getTitle());
                        }
                    }
                    int bookId = 21;

                    while (bookId != 0) {
                        System.out.print("Select a book ID to Checkout, or press 0 to Exit: ");
                        bookId = Integer.parseInt(scanner.nextLine());

                        boolean found = false;
                        for (Book book : books) {
                            if (book.getId() == bookId && !book.isCheckedOut()) {
                                System.out.print("Enter you name: ");
                                String name = scanner.nextLine();
                                book.checkOut(name);
                                found = true;
                                break;
                            }
                        }
                        if(found){
                            // bookId = scanner.nextInt();
                            //scanner.nextLine();
                            break;
                        }else{
                            System.out.println("You Enter the wrong Id.");

                        }
                    }

                    System.out.println("Returning to Homescreen. ");
                    System.out.println();
                    break;

                case 2:
                    System.out.println("---------------- Checked Out Books ----------------");
                    for (Book book : books) {
                        if (book.isCheckedOut()) {
                            System.out.printf("ID: %d :: ISBN: %s :: Title: %s :: Name: %S.\n", book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
                        }
                    }

                    String checkin ="";
                    while(!checkin.equalsIgnoreCase("X")) {
                        System.out.print("Type C to Check in a book or X to exit the menu: ");
                        checkin = scanner.nextLine();
                        boolean found = false;
                        if (checkin.equalsIgnoreCase("C")) {

                            while(!found) {
                                System.out.print("Enter the book Id: ");
                                bookId =Integer.parseInt(scanner.nextLine());

                                for (Book book : books) {
                                    if (book.getId() == bookId && book.isCheckedOut()) {
                                        book.checkIn();
                                        found = true;
                                        break;
                                    }
                                }
                                if(!found){
                                    System.out.println("You Enter a Wrong Id. Try again: ");
                                }
                            }

                        }else if(!checkin.equalsIgnoreCase("X")){
                            System.out.println("Wrong option, Try again.");

                        }
                        if(found){
                            System.out.println("Returning to Homescreen.");
                            break;
                        }
                    }
                    break;
                case 0:
                    break;

            }
        }
        System.out.println();
        System.out.println("Thank you for visiting our library.");
    }
}
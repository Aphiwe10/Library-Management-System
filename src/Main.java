
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
      System.out.println("\nLibrary Management System");
      System.out.println("1. Add a new book");
      System.out.println("2. Add a new member");
      System.out.println("3. Issue a book");
      System.out.println("4. Return a book");
      System.out.println("5. Show issued books");
      System.out.println("6. Exit");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();
      scanner.nextLine(); // Consume the newline character

      switch (choice) {
      case 1:
        // Add a new book
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        library.addBook(new Book(title, author, isbn));
        break;

      case 2:
        // Add a new member
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        library.addMember(new Member(name, memberId));
        break;

      case 3:
        // Issue a book
        System.out.print("Enter ISBN of the book to issue: ");
        String issueIsbn = scanner.nextLine();
        System.out.print("Enter Member ID: ");
        String issueMemberId = scanner.nextLine();
        library.issueBook(issueIsbn, issueMemberId);
        break;

      case 4:
        // Return a book
        System.out.print("Enter ISBN of the book to return: ");
        String returnIsbn = scanner.nextLine();
        library.returnBook(returnIsbn);
        break;

      case 5:
        // Show issued books
        library.showIssuedBooks();
        break;

      case 6:
        System.out.println("Exiting the system.");
        break;

      default:
        System.out.println("Invalid choice. Please try again.");
      }

    } while (choice != 6);

    scanner.close();
  }
}

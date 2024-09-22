import java.util.ArrayList;
import java.util.List;

public class Library {
  private List<Book> books;
  private List<Member> members;

  public Library() {
    this.books = new ArrayList<>();
    this.members = new ArrayList<>();
  }

  public void addBook(Book book) {
    books.add(book);
    System.out.println("Book added: " + book);
  }

  public void addMember(Member member) {
    members.add(member);
    System.out.println("Member added: " + member);
  }

  public void issueBook(String isbn, String memberId) {
    Book book = findBookByIsbn(isbn);
    Member member = findMemberById(memberId);

    if (book != null && member != null && !book.isIssued()) {
      book.issueBook(member);
      member.issueBook(book);
      System.out.println("Book issued: " + book.getTitle() + " to " + member.getName());
    } else if (book == null) {
      System.out.println("Book with ISBN " + isbn + " not found.");
    } else if (member == null) {
      System.out.println("Member with ID " + memberId + " not found.");
    } else if (book.isIssued()) {
      System.out.println("Book is already issued to " + book.getIssuedTo().getName());
    }
  }

  public void returnBook(String isbn) {
    Book book = findBookByIsbn(isbn);
    if (book != null && book.isIssued()) {
      Member member = book.getIssuedTo();
      book.returnBook();
      member.returnBook(book);
      System.out.println("Book returned: " + book.getTitle());
    } else if (book == null) {
      System.out.println("Book with ISBN " + isbn + " not found.");
    } else {
      System.out.println("Book is not currently issued.");
    }
  }

  public void showIssuedBooks() {
    System.out.println("\nIssued Books:");
    boolean hasIssuedBooks = false;
    for (Book book : books) {
      if (book.isIssued()) {
        hasIssuedBooks = true;
        System.out.println(book + " is issued to " + book.getIssuedTo().getName());
      }
    }
    if (!hasIssuedBooks) {
      System.out.println("No books are currently issued.");
    }
  }

  public Book findBookByIsbn(String isbn) {
    for (Book book : books) {
      if (book.getIsbn().equals(isbn)) {
        return book;
      }
    }
    return null;
  }

  public Member findMemberById(String memberId) {
    for (Member member : members) {
      if (member.getMemberId().equals(memberId)) {
        return member;
      }
    }
    return null;
  }
}

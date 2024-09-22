
import java.util.ArrayList;
import java.util.List;

public class Member {
  private String name;
  private String memberId;
  private List<Book> issuedBooks;

  public Member(String name, String memberId) {
    this.name = name;
    this.memberId = memberId;
    this.issuedBooks = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public String getMemberId() {
    return memberId;
  }

  public List<Book> getIssuedBooks() {
    return issuedBooks;
  }

  public void issueBook(Book book) {
    issuedBooks.add(book);
  }

  public void returnBook(Book book) {
    issuedBooks.remove(book);
  }

  @Override
  public String toString() {
    return "Member: " + name + " (ID: " + memberId + ")";
  }
}


public class Book {
  private String title;
  private String author;
  private String isbn;
  private boolean isIssued;
  private Member issuedTo;

  public Book(String title, String author, String isbn) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.isIssued = false;
    this.issuedTo = null;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getIsbn() {
    return isbn;
  }

  public boolean isIssued() {
    return isIssued;
  }

  public void issueBook(Member member) {
    this.isIssued = true;
    this.issuedTo = member;
  }

  public void returnBook() {
    this.isIssued = false;
    this.issuedTo = null;
  }

  public Member getIssuedTo() {
    return issuedTo;
  }

  @Override
  public String toString() {
    return "Book: " + title + ", Author: " + author + ", ISBN: " + isbn;
  }
}

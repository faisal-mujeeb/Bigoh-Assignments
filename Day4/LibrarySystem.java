import java.util.ArrayList;
import java.util.stream.Collectors;

class LibrarySystem {
    private List<BookItem> catalog = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    // Methods for searching, checking out, reserving, renewing, and returning books
    public List<BookItem> searchBooks(String title, String author, String subject, String publicationDate) {
        return catalog.stream()
                .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                                (author == null || book.getAuthor().equalsIgnoreCase(author)) &&
                                (subject == null || book.getSubject().equalsIgnoreCase(subject)) &&
                                (publicationDate == null || book.getPublicationDate().equalsIgnoreCase(publicationDate)))
                .collect(Collectors.toList());
    }

    public boolean checkOutBook(Member member, BookItem bookItem) {
        if (!bookItem.isAvailable() || !member.checkOutBook(bookItem)) return false;
        return true;
    }

    public void returnBook(Member member, BookItem bookItem) {
        member.returnBook(bookItem);
    }

    public void reserveBook(Member member, BookItem bookItem) {
       
    }

    public void renewBook(Member member, BookItem bookItem) {
        
    }

}


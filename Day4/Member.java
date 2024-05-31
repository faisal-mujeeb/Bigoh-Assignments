import java.util.ArrayList;

class Member {
    private String memberId;
    private String name;
    private int booksCheckedOut;
    private static final int MAX_BOOKS = 5;
    private List<BookItem> checkedOutBooks = new ArrayList<>();

    // Constructor
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.booksCheckedOut = 0;
    }

    // Getters and methods for checking out and returning books
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<BookItem> getCheckedOutBooks() { return checkedOutBooks; }

    public boolean checkOutBook(BookItem bookItem) {
        if (booksCheckedOut >= MAX_BOOKS) return false;
        booksCheckedOut++;
        bookItem.setAvailable(false);
        checkedOutBooks.add(bookItem);
        return true;
    }

    public void returnBook(BookItem bookItem) {
        booksCheckedOut--;
        bookItem.setAvailable(true);
        checkedOutBooks.remove(bookItem);
    }
}


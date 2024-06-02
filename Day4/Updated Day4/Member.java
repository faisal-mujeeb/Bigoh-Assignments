class Member extends Person {
    private int booksCheckedOut;
    private static final int MAX_BOOKS = 5;
    private List<BookItem> checkedOutBooks = new ArrayList<>();
    private List<BookItem> reservedBooks = new ArrayList<>();

    public Member(String memberId, String name) {
        super(memberId, name);
        this.booksCheckedOut = 0;
    }

    public List<BookItem> getCheckedOutBooks() { return checkedOutBooks; }
    public List<BookItem> getReservedBooks() { return reservedBooks; }

    public boolean checkOutBook(BookItem bookItem) {
        if (booksCheckedOut >= MAX_BOOKS || !bookItem.isAvailable()) return false;
        booksCheckedOut++;
        bookItem.setAvailable(false);
        bookItem.setBorrowedBy(this);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 10);
        bookItem.setDueDate(cal.getTime());
        checkedOutBooks.add(bookItem);
        return true;
    }

    public void returnBook(BookItem bookItem) {
        booksCheckedOut--;
        bookItem.setAvailable(true);
        bookItem.setBorrowedBy(null);
        bookItem.setDueDate(null);
        checkedOutBooks.remove(bookItem);
    }

    public void reserveBook(BookItem bookItem) {
        reservedBooks.add(bookItem);
    }

    public void removeReservation(BookItem bookItem) {
        reservedBooks.remove(bookItem);
    }
}

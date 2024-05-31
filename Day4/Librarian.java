class Librarian {
    private String librarianId;
    private String name;

    // Constructor
    public Librarian(String librarianId, String name) {
        this.librarianId = librarianId;
        this.name = name;
    }

    // Methods to add/remove/edit books and members
    public void addBook(BookItem bookItem, List<BookItem> catalog) {
        catalog.add(bookItem);
    }

    public void removeBook(BookItem bookItem, List<BookItem> catalog) {
        catalog.remove(bookItem);
    }

    public void editBook(BookItem oldBookItem, BookItem newBookItem, List<BookItem> catalog) {
        removeBook(oldBookItem, catalog);
        addBook(newBookItem, catalog);
    }

    public void registerMember(Member member, List<Member> members) {
        members.add(member);
    }

    public void cancelMembership(Member member, List<Member> members) {
        members.remove(member);
    }
}


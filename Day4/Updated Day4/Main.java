public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem librarySystem = new LibraryManagementSystem();

        // Create librarian and members
        Librarian librarian = new Librarian("L1", "ABC");
        Member member = new Member("M1", "XYZ");

        // Register member
        librarySystem.getMemberManagementSystem().registerMember(member);

        // Add books to the catalog
        BookItem book1 = new BookItem("Book Title 1", "Author 1", "Subject 1", "2021-01-01", "B1", "BC1", "R1");
        BookItem book2 = new BookItem("Book Title 2", "Author 2", "Subject 2", "2022-02-02", "B2", "BC2", "R2");
        librarySystem.getBookManagementSystem().addBook(book1);
        librarySystem.getBookManagementSystem().addBook(book2);

        // Search for books
        List<BookItem> searchResults = librarySystem.getBookManagementSystem().searchBooks("Book Title 1", null, null, null);
        System.out.println("Search results: " + searchResults.size());

        // Check out book
        if (librarySystem.checkOutBook(member, book1)) {
            System.out.println("Book checked out successfully!");
        } else {
            System.out.println("Failed to check out book.");
        }

        // Return book
        librarySystem.returnBook(member, book1);
        System.out.println("Book returned successfully!");

        // Reserve book
        librarySystem.reserveBook(member, book2);

        // Renew book
        librarySystem.renewBook(member, book1);

        // Collect fine
        librarySystem.getMemberManagementSystem().collectFine(member);
    }
}

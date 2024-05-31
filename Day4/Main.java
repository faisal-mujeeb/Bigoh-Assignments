public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        // Create librarian and members
        Librarian librarian = new Librarian("L1", "Faisal Mujeeb");
        Member member = new Member("M1", "Ayush Rawat");

        // Register member
        librarian.registerMember(member, librarySystem.getMembers());

        // Add books to the catalog
        BookItem book1 = new BookItem("Book Title 1", "Author 1", "Subject 1", "2020-05-01", "B1", "BC1", "R1");
        librarian.addBook(book1, librarySystem.getCatalog());

        // Search for books
        List<BookItem> searchResults = librarySystem.searchBooks("Book Title 1", null, null, null);
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
    }
}

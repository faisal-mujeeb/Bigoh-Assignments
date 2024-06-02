class BookManagementSystem {
    private List<BookItem> catalog = new ArrayList<>();

    public List<BookItem> getCatalog() { return catalog; }

    public void addBook(BookItem bookItem) {
        catalog.add(bookItem);
    }

    public void removeBook(BookItem bookItem) {
        catalog.remove(bookItem);
    }

    public void editBook(BookItem oldBookItem, BookItem newBookItem) {
        removeBook(oldBookItem);
        addBook(newBookItem);
    }

    public List<BookItem> searchBooks(String title, String author, String subject, String publicationDate) {
        return catalog.stream()
                .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                                (author == null || book.getAuthor().equalsIgnoreCase(author)) &&
                                (subject == null || book.getSubject().equalsIgnoreCase(subject)) &&
                                (publicationDate == null || book.getPublicationDate().equalsIgnoreCase(publicationDate)))
                .collect(Collectors.toList());
    }

    public void notifyIfReserved(BookItem bookItem, List<Member> members) {
        for (Member member : members) {
            if (member.getReservedBooks().contains(bookItem)) {
                System.out.println("Notification: The book " + bookItem.getTitle() + " is now available for member " + member.getName());
                member.removeReservation(bookItem);
                break;
            }
        }
    }
}


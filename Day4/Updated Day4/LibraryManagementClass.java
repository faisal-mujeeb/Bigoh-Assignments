class LibraryManagementSystem {
    private BookManagementSystem bookManagementSystem = new BookManagementSystem();
    private MemberManagementSystem memberManagementSystem = new MemberManagementSystem();

    public BookManagementSystem getBookManagementSystem() { return bookManagementSystem; }
    public MemberManagementSystem getMemberManagementSystem() { return memberManagementSystem; }

    public boolean checkOutBook(Member member, BookItem bookItem) {
        if (member.checkOutBook(bookItem)) {
            return true;
        }
        return false;
    }

    public void returnBook(Member member, BookItem bookItem) {
        member.returnBook(bookItem);
        bookManagementSystem.notifyIfReserved(bookItem, memberManagementSystem.getMembers());
    }

    public void reserveBook(Member member, BookItem bookItem) {
        if (!bookItem.isAvailable()) {
            member.reserveBook(bookItem);
            System.out.println("Book reserved successfully!");
        } else {
            System.out.println("Book is available, no need to reserve.");
        }
    }

    public void renewBook(Member member, BookItem bookItem) {
        if (member.getCheckedOutBooks().contains(bookItem)) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(bookItem.getDueDate());
            cal.add(Calendar.DAY_OF_MONTH, 10);
            bookItem.setDueDate(cal.getTime());
            System.out.println("Book renewed successfully!");
        } else {
            System.out.println("Book not checked out by this member.");
        }
    }
}


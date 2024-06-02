class Book {
    private String title;
    private String author;
    private String subject;
    private String publicationDate;
    private String uniqueId;

    // Constructor and getters/setters

    public Book(String title, String author, String subject, String publicationDate, String uniqueId) {
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.publicationDate = publicationDate;
        this.uniqueId = uniqueId;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getSubject() { return subject; }
    public String getPublicationDate() { return publicationDate; }
    public String getUniqueId() { return uniqueId; }
}

class BookItem extends Book {
    private String barcode;
    private boolean isAvailable;
    private String rackNumber;

    public BookItem(String title, String author, String subject, String publicationDate, String uniqueId, String barcode, String rackNumber) {
        super(title, author, subject, publicationDate, uniqueId);
        this.barcode = barcode;
        this.isAvailable = true;
        this.rackNumber = rackNumber;
    }

    // Getters and setters
    public String getBarcode() { return barcode; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public String getRackNumber() { return rackNumber; }
}

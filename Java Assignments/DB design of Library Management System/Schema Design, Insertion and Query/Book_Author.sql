CREATE TABLE Book_Author(
    BookId INT ,
    AuthorId INT,
    PRIMARY KEY (BookId,AuthorId),
    FOREIGN KEY (BookId) REFERENCES Books(BookId),
    FOREIGN KEY (AuthorId) REFERENCES Author(AuthorId),
);
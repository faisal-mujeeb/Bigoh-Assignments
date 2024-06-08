/*Join tables to fetch the list of books along with their authors*/
SELECT Books.Title, Authors.FirstName , Authors.LastName
FROM Books
JOIN Books_Author ON Books.BookID = Book_Authors.BookId
JOIN Authors ON Books_Authora.AuthorId= Authors.AuthorId;




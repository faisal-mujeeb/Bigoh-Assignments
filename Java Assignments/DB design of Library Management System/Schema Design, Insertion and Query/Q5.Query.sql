/*Any additional queries that demonstrate complex data retrieval.*/
/*Authors having more than one book in library*/

SELECT Authors.FirstName,Authors.LastName,
COUNT(Book_Author.BookId) AS NumberOfBooks
FROM Authors JOIN Book_Author ON Authors.AuthorId= Book_Authors.AuthorsId
GROUP BY Author.FirstName,Authors.LastName HAVING COUNT(Book_Authors.BookID) >1;

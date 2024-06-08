/**Retrieve all books borrowed by a specific member.*/

SELECT Books.Title
FROM Books
Join Loans ON Books.BookId = Loans.BookId
WHERE Loans.MemberId = 2;


CREATE TABLE Loans(
LoanId INT PRIMARY KEY,
BookId INT,
MemberId INT,
LoanDate DATE,
ReturnDate DATE,
FOREIGN KEY (BookId) REFERENCES Books(BookId),
FOREIGN KEY (MemberId) REFERENCES Members(MemberId),
);
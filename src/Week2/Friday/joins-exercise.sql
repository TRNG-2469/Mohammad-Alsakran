-- Query 1: All Loans (no active/inactive distinction possible)
select m.name, b.title, l.loan_date
from loans l
inner join members m on l.member_id = m.member_id
inner join books b on l.book_id = b.book_id;


--Query 2: Identifying Inactive Members (LEFT JOIN)
select m.name, l.loan_date
from members m
left join loans l on m.member_id = l.member_id;


-- Query 3: Members with Zero Borrowings
select m.name, l.loan_date
from members m
left join loans l on m.member_id = l.member_id
where l.member_id is null;


-- Query 4: Detailed Book Checkout Catalog
select m.name, b.title, b.author, l.loan_date
from members m
inner join loans l on m.member_id = l.member_id
inner join books b on l.book_id = b.book_id;


-- Query 5: Overdue Borrowing Log
select m.name, m.email, b.title, l.loan_date
from loans l
inner join members m on l.member_id = m.member_id
inner join books b on l.book_id = b.book_id
where l.loan_date < '2026-07-01' and l.return_date is null;
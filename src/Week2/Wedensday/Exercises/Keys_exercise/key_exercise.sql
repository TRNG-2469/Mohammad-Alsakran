create table books (
    book_id int primary key,
    title varchar(100),
    author varchar(100)
);

create table members (
    member_id int primary key,
    name varchar(100),
    email varchar(50) unique
);

create table loans (
    member_id int references members(member_id),
    book_id int references books(book_id),
    loan_date date,
    primary key (member_id, book_id, loan_date)
);
-- Valid row: book published 2005, member with no status specified
insert into books (book_id,title, year)
values (33,'Some Random Book', 2005);

insert into books (book_id,title, year)
values (34,'Some Other Random Book', 2006);

insert into members (member_id,name)
values (33,'Jane Doe');

insert into members (member_id,name)
values (34,'Jane Smith');

select membership_status from members where name = 'Jane Doe';

-- Invalid CHECK row: book published 1200
insert into books (book_id,title, year)
values (44,'Ancient Text', 1200);

--SQL Error [23514]: ERROR: new row for relation "books" violates check constraint "check_year"
--Detail: Failing row contains (44, Ancient Text, null, null, 1200).


-- Invalid status row
insert into members (member_id,name, membership_status)
values (44,'John Smith', 'BLOCKED');

--SQL Error [23514]: ERROR: new row for relation "members" violates check constraint "check_membership"
--Detail: Failing row contains (44, John Smith, null, BLOCKED).




-- Setup: two separate loans so CASCADE and RESTRICT tests don't interfere
insert into loans (member_id, book_id, loan_date)
values (33, 33, CURRENT_DATE);

insert into loans (member_id, book_id, loan_date)
values (33, 34, CURRENT_DATE);

-- Test CASCADE: delete book_id 33, its loan row should cascade-delete
delete from books where book_id = 33;

-- Verify: should return zero rows
select * from loans where book_id = 33;

-- Test RESTRICT: member 33 still has a loan on book_id 34, so this should fail

delete from members where member_id = 33;

--SQL Error [23503]: ERROR: update or delete on table "members" violates foreign key constraint "loans_member_id_fkey" on table "loans"
--Detail: Key (member_id)=(33) is still referenced from table "loans".T
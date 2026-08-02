alter table books add constraint check_year check (year>1450 and year<2026);

alter table members add column membership_status varchar(30) default 'Active';

alter table members add constraint check_membership check (membership_status='Active' or membership_status='EXPIRED' or membership_status='SUSPENDED') 
--Had to go with Active instead of ACTIVE here because I didnt know it was case sensetive, kept it to document a learning moment


alter table loans drop constraint loans_book_id_fkey;
alter table loans add constraint loans_book_id_fkey
foreign key (book_id) references books(book_id) on delete cascade;

alter table loans drop constraint loans_member_id_fkey;
alter table loans add constraint loans_member_id_fkey
foreign key (member_id) references members(member_id) on delete restrict;
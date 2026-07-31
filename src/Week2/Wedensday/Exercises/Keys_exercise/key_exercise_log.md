
# Library Constraint Violation Tests

## First error:


Attempted to insert a loan for a non-existent member:

```sql
INSERT INTO loans (member_id, book_id, loan_date)
VALUES (9999, 101, '2026-07-12');
```

**Error received:**
```

SQL Error [23503]: ERROR: insert or update on table "loans" violates foreign key constraint "loans_member_id_fkey"
  Detail: Key (member_id)=(9999) is not present in table "members".

```


## Second error: 


Attempted to insert a member with a duplicate email:

```sql
INSERT INTO members VALUES (5003, 'Alex Jones', 'john@email.com');
```

**Error received:**
```
SQL Error [23505]: ERROR: duplicate key value violates unique constraint "members_email_key"
  Detail: Key (email)=(john@email.com) already exists.
```
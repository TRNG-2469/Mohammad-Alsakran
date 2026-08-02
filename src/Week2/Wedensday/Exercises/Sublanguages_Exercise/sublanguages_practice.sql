-- Task 1: DDL
ALTER TABLE books ADD COLUMN category VARCHAR(30);

-- Task 2: DML
INSERT INTO members VALUES (5003, 'Alex Jones', 'alex@email.com');

-- Task 3: DQL
SELECT * FROM books WHERE author = 'George Orwell';

-- Task 4: TCL
BEGIN;
INSERT INTO books VALUES (103, 'Brave New World', 'Aldous Huxley', 'Fiction');
SAVEPOINT insert_check;
INSERT INTO books VALUES (104, 'Fahrenheit 451', 'Ray Bradbury', 'Fiction');
ROLLBACK TO insert_check;
COMMIT;

-- Task 5: DCL
-- CREATE ROLE guest_reader;
-- GRANT SELECT ON books TO guest_reader;
CREATE TABLE customers (
    customer_id int PRIMARY KEY,
    full_name VARCHAR(50) NOT NULL,
    email_address VARCHAR(50) UNIQUE NOT NULL,
    age int CHECK (age > 0),
    credit_balance DECIMAL(10, 2),
    registered_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);
-- Get all fields and records from customer
SELECT * FROM customer;

-- Get all fields from customers from Arizona
SELECT * FROM customer WHERE state = 'AZ';

-- Get all invoices older than 6 months
SELECT * FROM invoice WHERE invoice_date < NOW() - INTERVAL '6 months';

-- Update all customer phone numbers to NULL if they don't follow this format '+1 555 555-555'
UPDATE customer SET phone = NULL WHERE phone !~ '^\+1 \(?\d{3}\)? \d{3}-\d{4}$';

-- Get all tracks longer than 180000 milliseconds
SELECT * FROM track where milliseconds > 180000;

-- Update all customers not in the USA so that their country = USA and address, city, & state are NULL
UPDATE customer SET country = 'USA', address = NULL, city = NULL, state = NULL WHERE country != 'USA';

-- Given a customer_id, return their total spending across all invoices using a function
CREATE OR REPLACE FUNCTION total_spending (c_id int)
RETURNS INT AS $$
BEGIN
    SELECT SUM(total) as total_spending FROM invoice WHERE customer_id = c_id GROUP BY customer_id;
END;
$$ LANGUAGE plpgsql;

SELECT total_spending(16);

-- Given an empoloyee_id + new_manager_id, create a stored procedure to update an Employee's ReportsTo field
CREATE OR REPLACE PROCEDURE report_to(e_id INT, m_id INT)
LANGUAGE plpgsql
AS $$
BEGIN
    IF EXISTS (SELECT 1 FROM employee WHERE employee_id = e_id)
    THEN
        IF (e_id <> m_id) AND EXISTS (SELECT 1 FROM employee WHERE employee_id = m_id) AND NOT EXISTS (SELECT 1 FROM employee WHERE employee_id = m_id AND reports_to = e_id)
        THEN
            UPDATE employee SET reports_to = m_id WHERE employee_id = e_id;
        ELSE
            RAISE NOTICE 'Unable to update';
        END IF;
    ELSE
        RAISE NOTICE 'Employee % not found', e_id;
    END IF;
END;
$$;

CALL report_to(1, 3);

-- Create a new schema: pets
CREATE SCHEMA IF NOT EXISTS pets;

-- Create two related tables Customer + Pets
CREATE TABLE IF NOT EXISTS pets.Customers(
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    age INT CHECK (age >= 18)
);

CREATE TABLE IF NOT EXISTS pets.Pets(
    pet_id INT PRIMARY KEY,
    pet_name VARCHAR(40) NOT NULL,
    age INT,
    species VARCHAR(20),
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES pets.Customers(customer_id) ON DELETE SET NULL
);

-- Demonstrate populating records into these tables
INSERT INTO pets.Customers (customer_id, first_name, last_name, age) VALUES
    (1, 'Jo', 'Bob', 20),
    (2, 'Alex', 'Tom', 25),
    (3, 'Carrie', 'Bloom', 21),
    (4, 'Fro', 'Horm', 22),
    (5, 'Grace', 'Blue', 30);

INSERT INTO pets.Pets (pet_id, pet_name, age, species, customer_id) VALUES
    (1, 'Waffles', 4, 'Dog', 1),
    (2, 'Pancake', 2, 'Cat', 2),
    (3, 'Doge', 7, 'Hamster', 3),
    (4, 'Icy', 5, 'Fish', 4),
    (5, 'Fluffy', 3, 'Bunny', 5);
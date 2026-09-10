-- Get all invoice ids with the customers first name, last name, and the invoice total
SELECT invoice_id, first_name, last_name, total FROM invoice i INNER JOIN customer c on i.customer_id = c.customer_id;

-- Print the invoice id, customer's first name, and invoice total where invoice total is over $30
SELECT invoice_id, first_name, last_name, total
FROM invoice i
INNER JOIN customer c on i.customer_id = c.customer_id
WHERE total > 30;

-- Get all the invoices for USA customers in the last 6 months using a CTE
WITH us_customers AS (
    SELECT customer_id
    FROM customer
    WHERE country = 'USA'
)
SELECT *
FROM invoice
WHERE customer_id IN (SELECT customer_id FROM us_customers) AND invoice_date > NOW() - INTERVAL '6 months';
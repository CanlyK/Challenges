-- Create a new table called record_logs with fields (log_id, record_id (customer records), field_changed, last_update, old_value, new_value)
CREATE TABLE IF NOT EXISTS record_logs (
    log_id INT PRIMARY KEY,
    field_changed VARCHAR(40),
    last_update TIMESTAMP,
    old_value VARCHAR(40),
    new_value VARCHAR(40),
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES pets.Customers(customer_id) ON DELETE SET NULL
);

-- Create a trigger that tracks changes to customer records and logs the changes in our new table
CREATE OR REPLACE FUNCTION set_record_update()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
BEGIN
    IF NEW.first_name IS DISTINCT FROM OLD.first_name
    THEN 
        INSERT INTO record_logs (field_changed, last_update, old_value, new_value, customer_id)
        VALUES ('first_name', NOW(), OLD.first_name, NEW.first_name, OLD.customer_id);
    END IF;
    IF NEW.last_name IS DISTINCT FROM OLD.last_name
    THEN 
        INSERT INTO record_logs (field_changed, last_update, old_value, new_value, customer_id)
        VALUES ('last_name', NOW(), OLD.last_name, NEW.last_name, OLD.customer_id);
    END IF;
    IF NEW.company IS DISTINCT FROM OLD.company
    THEN
        INSERT INTO record_logs (field_changed, last_update, old_value, new_value, customer_id)
        VALUES ('company', NOW(), OLD.company, NEW.company, OLD.customer_id);
    END IF;
    IF NEW.address IS DISTINCT FROM OLD.address
    THEN
        INSERT INTO record_logs (field_changed, last_update, old_value, new_value, customer_id)
        VALUES ('address', NOW(), OLD.address, NEW.address, OLD.customer_id);
    END IF;
    IF NEW.city IS DISTINCT FROM OLD.city
    THEN
        INSERT INTO record_logs (field_changed, last_update, old_value, new_value, customer_id)
            VALUES ('city', NOW(), OLD.city, NEW.city, OLD.customer_id);
    END IF;
    IF NEW.state IS DISTINCT FROM OLD.state
    THEN
        INSERT INTO record_logs (field_changed, last_update, old_value, new_value, customer_id)
            VALUES ('state', NOW(), OLD.state, NEW.state, OLD.customer_id);
    END IF;
    IF NEW.country IS DISTINCT FROM OLD.country
    THEN
        INSERT INTO record_logs (field_changed, last_update, old_value, new_value, customer_id)
            VALUES ('country', NOW(), OLD.country, NEW.country, OLD.customer_id);
    END IF;
    IF NEW.postal_code IS DISTINCT FROM OLD.postal_code
    THEN
        INSERT INTO record_logs (field_changed, last_update, old_value, new_value, customer_id)
            VALUES ('postal_code', NOW(), OLD.postal_code, NEW.postal_code, OLD.customer_id);
    END IF;
    IF NEW.phone IS DISTINCT FROM OLD.phone
    THEN
        INSERT INTO record_logs (field_changed, last_update, old_value, new_value, customer_id)
            VALUES ('phone', NOW(), OLD.phone, NEW.phone, OLD.customer_id);
    END IF;
    IF NEW.fax IS DISTINCT FROM OLD.fax
    THEN
        INSERT INTO record_logs (field_changed, last_update, old_value, new_value, customer_id)
            VALUES ('fax', NOW(), OLD.fax, NEW.fax, OLD.customer_id); 
    END IF;
    IF NEW.email IS DISTINCT FROM OLD.email
    THEN
        INSERT INTO record_logs (field_changed, last_update, old_value, new_value, customer_id)
            VALUES ('email', NOW(), OLD.email, NEW.email, OLD.customer_id);
    END IF;
    IF NEW.support IS DISTINCT FROM OLD.support
    THEN
        INSERT INTO record_logs (field_changed, last_update, old_value, new_value, customer_id)
            VALUES ('support', NOW(), OLD.support, NEW.support, OLD.customer_id); 
    END IF;
END;
$$;

CREATE TRIGGER users_set_record_update
AFTER UPDATE ON public.customer
FOR EACH ROW
EXECUTE FUNCTION set_record_update();
BEGIN;

DROP TABLE customers IF EXISTS CASCADE;
CREATE TABLE IF NOT EXISTS customers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES ('Angelina'), ('Arnold'), ('Bred'), ('Boris'), ('Clod'), ('Cris');

DROP TABLE products IF EXISTS CASCADE;
CREATE TABLE IF NOT EXISTS products (id bigserial PRIMARY KEY, title VARCHAR(255), cost int, customer_id bigint REFERENCES customers (id) ON DELETE CASCADE);
INSERT INTO products (title, cost, customer_id) VALUES ('apples', 200, 1), ('apples', 200, 3), ('apples', 200, 5), ('bread', 50, 2), ('bread', 50, 3), ('bread', 50, 6), ('carrot', 70, 1), ('carrot', 70, 2), ('carrot', 70, 4), ('beans', 100, 3), ('beans', 100, 4), ('milk', 80, 1), ('milk', 80, 2), ('milk', 80, 3), ('milk', 80, 4), ('milk', 80, 5), ('milk', 80, 6);

COMMIT;
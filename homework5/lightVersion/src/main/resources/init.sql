BEGIN;
DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (primary key id bigserial, title varchar(255), cost int);
INSERT INTO products (title, cost) VALUES ('milk', 105), ('bread', 30), ('jam', 100);
COMMIT;
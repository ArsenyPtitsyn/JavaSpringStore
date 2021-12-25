DROP TABLE products IF EXISTS;
CREATE TABLE products (id bigserial, title VARCHAR(255), cost int, PRIMARY KEY (id));
INSERT INTO products (title, cost) VALUES ('tea', 450), ('coffee', 500), ('bread', 45), ('milk', 84);
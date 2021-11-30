BEGIN;

CREATE TABLE IF NOT EXISTS products (id bigserial primary key, title varchar(255), cost int);
INSERT INTO products (title, cost) VALUES
('milk', 90),
('bread', 50),
('apples', 200),
('peaches', 300),
('sugar', 100),
('beef', 600),
('pork', 450),
('turkey', 400),
('chicken', 300),
('cookies', 120),
('olive oil', 700),
('sunflower oil', 150),
('olives', 70),
('waffles', 250),
('cake', 270),
('black tea', 380),
('green tea', 370),
('potatoes', 350),
('watermelon', 400),
('melon', 380);

COMMIT;
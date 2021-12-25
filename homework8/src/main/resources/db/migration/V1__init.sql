BEGIN;

CREATE TABLE IF NOT EXISTS products (id bigserial primary key, title varchar(255), cost int);
INSERT INTO products (title, cost) VALUES
('title1', 482),
('title2', 234),
('title3', 1534),
('title4', 26),
('title5', 363),
('title6', 263),
('title7', 12),
('title8', 53),
('title9', 724),
('title10', 105),
('title11', 32),
('title12', 1035),
('title13', 177),
('title14', 29),
('title15', 50),
('title16', 206),
('title17', 363),
('title18', 734),
('title19', 822),
('title20', 421);


COMMIT;
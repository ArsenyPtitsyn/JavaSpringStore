CREATE TABLE users (
  id                    bigserial,
  username              VARCHAR(30) NOT NULL UNIQUE,
  password              VARCHAR(80) NOT NULL,
  email                 VARCHAR(50) UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE authorities (
  id                    serial,
  name                  VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE users_authorities (
  user_id               bigint NOT NULL,
  authority_id               INT NOT NULL,
  PRIMARY KEY (USER_ID, AUTHORITY_ID),
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (authority_id) REFERENCES authorities (id)
);

INSERT INTO authorities (name)
VALUES
('AUTHORITY_READ_ALL_MSGS'), ('AUTHORITY_DELETE_USERS'), ('AUTHORITY_CREATE_NEW_USERS');

INSERT INTO users (username, password, email)
VALUES
('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com'),
('admin', '$2a$10$tHzsZwImF9cJzL5.qDNrgeDhodwR3wznXS.D1OFRQL0mNJe.G.VRG', 'admin@mail.ru');

INSERT INTO users_authorities (user_id, authority_id)
VALUES
(1, 1),
(2, 1),
(2, 2),
(2, 3);
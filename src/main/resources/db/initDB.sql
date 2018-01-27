DROP TABLE IF EXISTS roles CASCADE ;
DROP TABLE IF EXISTS restaurants CASCADE ;
DROP TABLE IF EXISTS users CASCADE ;
DROP TABLE IF EXISTS votes CASCADE ;
DROP TABLE IF EXISTS menu CASCADE ;
DROP TABLE IF EXISTS menu_details;

DROP SEQUENCE IF EXISTS user_seq;
DROP SEQUENCE IF EXISTS role_seq;
DROP SEQUENCE IF EXISTS restaurant_seq;
DROP SEQUENCE IF EXISTS menu_seq;
DROP SEQUENCE IF EXISTS vote_seq;

CREATE SEQUENCE user_seq START 1000;
CREATE SEQUENCE role_seq START 1;
CREATE SEQUENCE restaurant_seq START 500000;
CREATE SEQUENCE menu_seq START 100000;
CREATE SEQUENCE vote_seq START 300000;

CREATE TABLE roles
(
  role_id INTEGER PRIMARY KEY DEFAULT nextval('role_seq'),
  role    VARCHAR
);

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('user_seq'),
  role_id          INTEGER                 NOT NULL ,
  name             VARCHAR                 NOT NULL,
  email            VARCHAR                 NOT NULL,
  password         VARCHAR                 NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL,
  FOREIGN KEY (role_id) REFERENCES roles (role_id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE restaurants
(
  restaurant_id             INTEGER PRIMARY KEY DEFAULT nextval('restaurant_seq'),
  restaurant_name           VARCHAR                 NOT NULL,
  restaurant_address        VARCHAR                 NOT NULL,
  restaurant_registered     TIMESTAMP DEFAULT now() NOT NULL
);

CREATE TABLE menu
(
  menu_id                 INTEGER PRIMARY KEY DEFAULT nextval('menu_seq'),
  restaurant_id           INTEGER                 NOT NULL,
  created_by_user_id      INTEGER                 NOT NULL,
  registered              TIMESTAMP DEFAULT now() NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (restaurant_id) ON DELETE CASCADE,
  FOREIGN KEY (created_by_user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE menu_details
(
  menu_details_id           INTEGER PRIMARY KEY DEFAULT nextval('menu_seq'),
  menu_id                   INTEGER                 NOT NULL,
  dish                      VARCHAR                 NOT NULL,
  price                     FLOAT                 NOT NULL,
  FOREIGN KEY (menu_id) REFERENCES menu (menu_id) ON DELETE CASCADE
);

CREATE TABLE votes
(
  vote_id               INTEGER PRIMARY KEY DEFAULT nextval('vote_seq'),
  user_id               INTEGER                 NOT NULL,
  restaurant_id         INTEGER                 NOT NULL,
  vote_ts               TIMESTAMP               NOT NULL,
  coomment              VARCHAR                 NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (restaurant_id) ON DELETE CASCADE
);
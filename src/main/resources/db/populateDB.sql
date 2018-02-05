DELETE FROM roles;
DELETE FROM users;
DELETE FROM restaurants;
DELETE FROM menu;
DELETE FROM votes;
DELETE FROM menu_details;

ALTER SEQUENCE user_seq RESTART WITH 1000;
ALTER SEQUENCE role_seq RESTART WITH 1;
ALTER SEQUENCE restaurant_seq RESTART WITH 500000;
ALTER SEQUENCE menu_seq RESTART WITH 100000;
ALTER SEQUENCE vote_seq RESTART WITH 300000;


INSERT INTO users (name, email, password) VALUES
  ( 'User', 'user@yandex.ru', '{noop}password'),
  ( 'Kolhoz', 'kolhoz@yandex.ru', '{noop}password123'),
  ( 'Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO roles (user_id, role) VALUES
  (1000, 'ROLE_USER'),
  (1001, 'ROLE_USER'),
  (1002, 'ROLE_ADMIN'),
  (1002, 'ROLE_USER')
;

INSERT INTO restaurants (restaurant_name, restaurant_address) VALUES
  ('Bitching Restaurant', 'Asshole st. 15'),
  ('Joes balls', 'Moran ave. 25');

INSERT INTO menu (restaurant_id, created_by_user_id) VALUES
  (500000, 1002),
  (500001, 1002);

INSERT INTO menu_details (menu_id, dish, price) VALUES
  (100000, 'Shit of bull', 13.50),
  (100000, 'Soup of piss', 7.50),
  (100000, 'Meat Balls', 12.00),
  (100001, 'Soup Goulash', 8.00),
  (100001, 'Potatoes with pork', 14.00),
  (100001, 'Desert of luck', 6.30);

INSERT INTO votes (user_id, restaurant_id, vote_ts, coomment) VALUES
  (1000, 500000, '1/1/2018 10:10', 'mne huovo'),
  (1001, 500001, '1/1/2018 08:30', 'zaebis tut'),
  (1002, 500000, '1/1/2018 09:20', 'tut foso');
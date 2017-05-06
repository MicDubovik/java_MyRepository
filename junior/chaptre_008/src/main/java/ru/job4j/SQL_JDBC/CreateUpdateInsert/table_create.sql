\c

-- создаем таблицу orders
CREATE TABLE orders  (
  order_id SERIAL PRIMARY KEY ,
  description_order CHAR(100),
  date_create TIMESTAMP,
  order_type INT,
  order_states INT,
  comment_id INT,
  root_id INT
);

-- создаем таблицу order_states
CREATE TABLE order_states (
  states_id SERIAL PRIMARY KEY ,
  states CHAR(20)
);

-- создаем таблицу
CREATE TABLE order_type (
  type_id SERIAL PRIMARY KEY ,
  type CHAR(10)
);

-- создаем таблицу
 CREATE TABLE comments (
  comments_id SERIAL PRIMARY KEY ,
  comment CHAR(100)
);

-- создаем таблицу
CREATE TABLE attachment (
  attach_id SERIAL PRIMARY KEY ,
  name CHAR(15),
  description_attach CHAR(100),
  order_id INT
);

-- создаем таблицу
CREATE TABLE users (
  user_id SERIAL PRIMARY KEY ,
  user_name CHAR(15),
  login CHAR(15),
  password CHAR(15),
  role_id INT
);

-- создаем таблицу
CREATE TABLE role (
  role_id SERIAL PRIMARY KEY ,
  role CHAR(20),
  root_id INT
);

-- создаем таблицу
CREATE TABLE role_root (
  root_id SERIAL PRIMARY KEY ,
  root_name CHAR(20),
  description_root CHAR(20)
);

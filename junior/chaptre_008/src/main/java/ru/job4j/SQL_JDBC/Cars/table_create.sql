\c cars_db

CREATE TABLE transmission (
  id SERIAL PRIMARY KEY ,
  title CHAR(20)
);

CREATE TABLE engine (
  id SERIAL PRIMARY KEY ,
   title CHAR(20)
);

CREATE TABLE body (
  id SERIAL PRIMARY KEY ,
  title CHAR(20)
);

CREATE TABLE cars (
  id SERIAL PRIMARY KEY ,
  model CHAR(20),
  body INT,
  transmission INT,
  engine INT,
    FOREIGN KEY (body) REFERENCES body (id),
  FOREIGN KEY (transmission) REFERENCES transmission(id),
  FOREIGN KEY (engine) REFERENCES engine(id)
);
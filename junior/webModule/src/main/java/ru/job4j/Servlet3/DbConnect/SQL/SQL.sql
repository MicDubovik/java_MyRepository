


CREATE TABLE servlet
(id  SERIAL PRIMARY KEY ,
 name VARCHAR(15),
 login VARCHAR(20) UNIQUE ,
 date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 email VARCHAR(50)

);
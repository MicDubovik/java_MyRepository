
CREATE TABLE role
(id SERIAL PRIMARY KEY ,
 role VARCHAR(10));

INSERT INTO role (role) VALUES
  ('admin'),
  ('user');


CREATE TABLE servlet
(id  SERIAL PRIMARY KEY ,
 name VARCHAR(15),
 login VARCHAR(20) UNIQUE ,
 password VARCHAR(20) ,
 date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 email VARCHAR(50),
 id_role INTEGER DEFAULT 2,
  FOREIGN KEY (id_role) REFERENCES role (id)
);

INSERT INTO servlet (name, login,password, email ,id_role)  VALUES
  ('Ivan','vanos','2222','vano@gmail.com',2),
  ('Petr','apetr','3333','pe@gmail.com',2),
  ('John','jonny','1111','johnyy@gmail.com',2),
  ('Michael','mic','0101','michyy@gmail.com',1);
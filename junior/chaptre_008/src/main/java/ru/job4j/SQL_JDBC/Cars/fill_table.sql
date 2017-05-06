INSERT INTO transmission (title) VALUES
  ('auto'),
  ('4-x'),
  ('5-x'),
  ('6-x');

INSERT INTO engine(title) VALUES
  ('3.0 V6'),
  ('2.0 HDI'),
  ('1.6 VTEC'),
  ('1.4 TSI');

INSERT INTO body (title) VALUES
  ('Sedan'),
  ('Universal'),
  ('Hatchback'),
  ('SUV');


INSERT INTO cars(model, body, transmission, engine) VALUES
  ('Camry',1,1,2),
  ('Corola',3,2,4),
  ('Land Cruiser',1,1,1),
  ('Prius',3,3,3),
  ('Rav4',4,1,2);
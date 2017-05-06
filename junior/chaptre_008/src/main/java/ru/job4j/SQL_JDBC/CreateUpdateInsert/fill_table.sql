--заполняем таблицы
INSERT INTO users(user_name,login,password) VALUES
 ( 'Mic','mich','123'),
 ( 'Vano','ivan','321'),
 ( 'Viktory','tory','xxx');


INSERT INTO role (role) VALUES
  ( 'admin' ),
  ('user');


INSERT INTO role_root (root_name, description_root) VALUES
  ('admin' ,'full level access'),
  ('user' ,'small level access');

INSERT INTO order_type (type) VALUES
  ('Sell'),
  ('Buy');

INSERT INTO order_states (states) VALUES
  ('in progress'),
('completed');

INSERT INTO comments (comment) VALUES
  ('Nice product'),
  ('Good product'),
  ('Bad product');

INSERT INTO attachment (name, description_attach, order_id) VALUES
  ('TV','Sony',1),
  ('CD-Player','Sharp',2);


INSERT INTO orders (description_order,  order_type, order_states, comment_id, root_id) VALUES
  ('+++',2,1,1,1),
  ('+-+',1,2,2,2),
  ('---',1,1,2,1);

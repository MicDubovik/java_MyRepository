-- задаем внешние ключи.
ALTER TABLE users ADD FOREIGN KEY (role_id) REFERENCES role (role_id);

ALTER TABLE role ADD FOREIGN KEY (root_id) REFERENCES role_root (root_id);

ALTER TABLE orders  ADD FOREIGN KEY (comment_id) REFERENCES comments (comments_id);

ALTER TABLE orders  ADD FOREIGN KEY (order_states) REFERENCES order_states (states_id);

ALTER TABLE orders  ADD FOREIGN KEY (order_type) REFERENCES order_type (type_id);

ALTER TABLE orders  ADD FOREIGN KEY (root_id) REFERENCES role_root (root_id);

ALTER TABLE orders  ADD FOREIGN KEY (attachment_id) REFERENCES attachment (attach_id);

INSERT INTO users (id, name, email) VALUES (1, 'Alice', 'alice@example.com');
INSERT INTO users (id, name, email) VALUES (2, 'Bob', 'bob@example.com');

INSERT INTO orders (id, user_id, total_price) VALUES (1, 1, 99.99);
INSERT INTO orders (id, user_id, total_price) VALUES (2, 1, 199.99);
INSERT INTO orders (id, user_id, total_price) VALUES (3, 2, 299.99);
CREATE TABLE IF NOT EXISTS orden(
  id SERIAL,
  fecha DATE,
  total DECIMAL,
  customer_id INT NOT NULL,
  PRIMARY KEY(id),
  UNIQUE (total),
  FOREIGN KEY (customer_id) REFERENCES customer (id)
 );

CREATE VIEW orden_view AS
SELECT o.*, c.fullname customer
FROM orden o
       INNER JOIN customer c ON o.customer_id = c.id;

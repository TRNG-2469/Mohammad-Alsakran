
SELECT COUNT(*) AS total_orders, AVG(amount) AS avg_order_amount
FROM orders;


SELECT c.customer_id, c.name, COUNT(o.order_id) AS order_count
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_id, c.name
ORDER BY order_count DESC;


SELECT c.customer_id, c.name, SUM(o.amount) AS total_spent
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_id, c.name
HAVING SUM(o.amount) > 150.00;



SELECT MIN(price) AS lowest_price, MAX(price) AS highest_price,
       AVG(price) AS avg_price, COUNT(*) AS total_products
FROM products;


SELECT p.name, SUM(oi.quantity) AS total_quantity
FROM products p
JOIN order_items oi ON p.product_id = oi.product_id
GROUP BY p.name
ORDER BY total_quantity DESC
LIMIT 3;
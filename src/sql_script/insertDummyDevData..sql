-- Replace the id here with the first user id you want to have ownership of the orders.
SET @userId1 = 1;
-- Replace the id here with the second user id you want to have ownership of the orders.
SET @userId2 = 2;



INSERT INTO product (name, short_description, long_description, price) VALUES ('Product #1', 'Product one short description.', 'This is a very long description of product #1.', 5.50);
INSERT INTO product (name, short_description, long_description, price) VALUES ('Product #2', 'Product two short description.', 'This is a very long description of product #2.', 10.56);
INSERT INTO product ( name, short_description, long_description, price) VALUES ('Product #3', 'Product three short description.', 'This is a very long description of product #3.', 2.74);
INSERT INTO product ( name , short_description, long_description, price) VALUES ('Product #4', 'Product four short description.', 'This is a very long description of product #4.', 15.69);
INSERT INTO product (  name , short_description, long_description, price) VALUES ('Product #5', 'Product five short description.', 'This is a very long description of product #5.', 42.59);

SET @product1 = (SELECT id FROM product WHERE name = 'Product #1');
SET @product2 = (SELECT id FROM product WHERE name = 'Product #2');
SET @product3 = (SELECT id FROM product WHERE name = 'Product #3');
SET @product4 = (SELECT id FROM product WHERE name = 'Product #4');
SET @product5 = (SELECT id FROM product WHERE name = 'Product #5');

INSERT INTO inventory (product_id, quantity) VALUES (@product1, 5);
INSERT INTO inventory (product_id, quantity) VALUES (@product2, 8);
INSERT INTO inventory (product_id, quantity) VALUES (@product3, 12);
INSERT INTO inventory (product_id, quantity) VALUES (@product4, 73);
INSERT INTO inventory (product_id, quantity) VALUES (@product5, 2);

INSERT INTO address (address_line_1,address_line_2, city, country, user_id) VALUES ('123 Tester Hill','hill', 'Testerton', 'England', @userId1);
INSERT INTO address (address_line_1,address_line_2, city, country, user_id) VALUES ('312 Spring Boot','boot', 'Hibernate', 'England', @userId2);

SET @address1 = (SELECT id FROM address WHERE user_id = @userId1 ORDER BY id DESC LIMIT 1);
SET @address2 = (SELECT id FROM address WHERE user_id = @userId2 ORDER BY id DESC LIMIT 1);


INSERT INTO web_order (address_id, user_id) VALUES (@address1, @userId1);
INSERT INTO web_order (address_id, user_id) VALUES (@address1, @userId1);
INSERT INTO web_order (address_id, user_id) VALUES (@address1, @userId1);
INSERT INTO web_order (address_id, user_id) VALUES (@address2, @userId2);
INSERT INTO web_order (address_id, user_id) VALUES (@address2, @userId2);

SET @order1 = (SELECT id FROM web_order WHERE address_id = @address1 AND user_id = @userId1 ORDER BY id DESC LIMIT 1);
SET @order4 = (SELECT id FROM web_order WHERE address_id = @address2 AND user_id = @userId2 ORDER BY id DESC LIMIT 1);
SET @order2 = (SELECT id FROM web_order WHERE address_id = @address1 AND user_id = @userId1 ORDER BY id DESC LIMIT 1 OFFSET 1);
SET @order3 = (SELECT id FROM web_order WHERE address_id = @address1 AND user_id = @userId1 ORDER BY id DESC LIMIT 1 OFFSET 1);
SET @order5 = (SELECT id FROM web_order WHERE address_id = @address2 AND user_id = @userId2 ORDER BY id DESC LIMIT 1 OFFSET 1);


INSERT INTO web_order_quantities (order_id, product_id, quantity) VALUES (@order1, @product1, 5);
INSERT INTO web_order_quantities (order_id, product_id, quantity) VALUES (@order1, @product2, 15);
INSERT INTO web_order_quantities (order_id, product_id, quantity) VALUES (@order2, @product3, 50);
INSERT INTO web_order_quantities (order_id, product_id, quantity) VALUES (@order2, @product2, 500);
INSERT INTO web_order_quantities (order_id, product_id, quantity) VALUES (@order2, @product5, 10);
INSERT INTO web_order_quantities (order_id, product_id, quantity) VALUES (@order3, @product3, 25);
INSERT INTO web_order_quantities (order_id, product_id, quantity) VALUES (@order4, @product4, 5);
INSERT INTO web_order_quantities (order_id, product_id, quantity) VALUES (@order4, @product2, 48);
INSERT INTO web_order_quantities (order_id, product_id, quantity) VALUES (@order5, @product3, 35);
INSERT INTO web_order_quantities (order_id, product_id, quantity) VALUES (@order5, @product1, 78);
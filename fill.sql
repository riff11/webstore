INSERT INTO `User`( `E_MAIL`, `FIRST_NAME`, `password`, `PHONE`, `authority`, `username`) VALUES ('alexdy9@gmail.com','Misha','21232f297a57a5a743894a0e4a801fc3','434-434','ROLE_ADMIN', 'admin');
INSERT INTO `User`( `E_MAIL`, `FIRST_NAME`, `password`, `PHONE`, `authority`, `username`) VALUES ('alexdy9@gmail.com','Misha','aae6118fbee51271873d7e407dd2495c','434-434','ROLE_MANAGER', 'manag');
INSERT INTO `User`( `E_MAIL`, `FIRST_NAME`, `password`, `PHONE`, `authority`, `username`) VALUES ('alexdy9@gmail.com','Misha','084e0343a0486ff05530df6c705c8bb4','434-434','ROLE_LOGUSER', 'guest');

INSERT INTO `Product_Type`( `productType`) VALUES ('Mobile');
INSERT INTO `Product_Type`( `productType`) VALUES ('Laptop');
INSERT INTO `Product_Type`( `productType`) VALUES ('TV');

INSERT INTO `product` ( `addDate`, `description`, `editDate`, `imageLink`, `price`, `productName`, `quantity`, `product_type_fk`) VALUES
( NULL, 'Cool Mobile', NULL, 'resources/images/mobile.jpg', 3323.99, 'Nokia', 32, 1),
( NULL, 'tv good', NULL, 'resources/images/tv2.jpg', 2134, 'wqwrs', 3, 2),
( NULL, 'Best TV', NULL, 'resources/images/tv.jpg', 7023.32, 'Samsung', 32, 8),
( NULL, 'Good Notebook', NULL, 'resources/images/notebook (2).jpg', 6323.98, 'Nokia', 32, 8);

INSERT INTO `Product` ( `addDate`, `description`, `editDate`, `imageLink`, `price`, `productName`, `quantity`, `product_type_fk`) VALUES
( NULL, 'Cool Mobile', NULL, 'resources/images/mobile.jpg', 3323.99, 'Nokia', 32,01),
( NULL, 'tv good', NULL, 'resources/images/tv2.jpg', 2134, 'wqwrs', 3, 2),
( NULL, 'Best TV', NULL, 'resources/images/tv.jpg', 7023.32, 'Samsung', 32, 2),
( NULL, 'Good Notebook', NULL, 'resources/images/notebook (2).jpg', 6323.98, 'Nokia', 32, 1);
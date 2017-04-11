
  
INSERT INTO `producers`( `name`) VALUES ('Nokia');
INSERT INTO `producers`( `name`) VALUES ('Bosh');
INSERT INTO `producers`( `name`) VALUES ('Sony');

INSERT INTO `categories`( `name`) VALUES ('Mobile');
INSERT INTO `categories`( `name`) VALUES ('Laptop');
INSERT INTO `categories`( `name`) VALUES ('TV');

INSERT INTO `products` ( `name`, `price`, `producer_fk`, `image`, `description`, `available`) VALUES
( 'Cool Mobile', 3323.99, 1, 'resources/images/mobile.jpg', 'Nokia', 1),
( 'tv good', 2134, 2,  'resources/images/tv2.jpg', 'wqwrs', 1),
( 'Best TV', 7023.32, 3, 'resources/images/tv.jpg',  'Samsung', 0),
( 'Good Notebook', 6323.98, 2, 'resources/images/notebook (2).jpg', 'Nokia', 1);



  
INSERT INTO `producers`( `name`) VALUES ('Nokia');
INSERT INTO `producers`( `name`) VALUES ('Bosh');
INSERT INTO `producers`( `name`) VALUES ('Sony');
INSERT INTO `producers`( `name`) VALUES ('Panasonic');
INSERT INTO `producers`( `name`) VALUES ('Saturn');
INSERT INTO `producers`( `name`) VALUES ('Apple');
INSERT INTO `producers`( `name`) VALUES ('LG');



INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Крупная бытовая техника', null);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Мелкая бытовая техника', null);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Смартфоны, ТВ и электроника', null);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Ноутбуки и компьютеры', null);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Mobile', 4);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Laptop', 4);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('TV', 3);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Camera', 3);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Washing machine', 1);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Speakers', 3);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Vacuum', 2);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Oven', 1);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Toaster', 2);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Refrigerator', 1);





INSERT INTO `products` ( `name`, `price`, `producer_fk`, `categories_fk`, `image`, `description`, `available`) VALUES
( 'Cool Mobile', 3323.99, 1, 5, '/resources/images/mobile.jpg', 'Nokia', 1),
( 'tv good', 2134, 2, 7, '/resources/images/tv2.jpg', 'wqwrs', 1),
( 'Best TV', 7023.32, 3, 7, '/resources/images/tv.jpg',  'Samsung', 0),
( 'Good Notebook', 6323.98, 2, 6, '/resources/images/notebook (2).jpg', 'описание ыаы', 1),
( 'Good Laptop', 6323.98, 2, 6, '/resources/images/notebook (2).jpg', 'описание ыаы', 1);



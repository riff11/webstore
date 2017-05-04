
  
INSERT INTO `producers`( `name`) VALUES ('Philips');
INSERT INTO `producers`( `name`) VALUES ('Bosh');
INSERT INTO `producers`( `name`) VALUES ('Sony');
INSERT INTO `producers`( `name`) VALUES ('Panasonic');
INSERT INTO `producers`( `name`) VALUES ('Saturn');
INSERT INTO `producers`( `name`) VALUES ('Apple');
INSERT INTO `producers`( `name`) VALUES ('LG');
INSERT INTO `producers`( `name`) VALUES ('Lenovo');



INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Крупная бытовая техника', null);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Мелкая бытовая техника', null);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Смартфоны, ТВ и электроника', null);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Ноутбуки и компьютеры', null);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Телефоны', 4);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Ноутбуки', 4);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('TV', 3);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Камеры', 3);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Стиральные машины', 1);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Наушники', 3);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Пылесосы', 2);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Печи', 1);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Тостеры', 2);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('Холодильники', 1);





INSERT INTO `products` ( `name`, `price`, `producer_fk`, `categories_fk`, `description`, `available`) VALUES
( 'iPhone 5s', 8323.99, 6, 5, 'Экран (4", IPS, 1136x640)/ Apple A7 (1.3 ГГц)/ основная камера: 8 Мп, фронтальная камера: 1.2 Мп/ RAM 1 ГБ/ 16 ГБ встроенной памяти/ 3G/ LTE/ GPS/ Nano-SIM/ iOS 9/ 1560 мА*ч', 1),
( 'UE22H5600AKXUA', 2134, 3, 7,  'Благодаря классическому дизайну и простым в использовании функциям серия телевизор  предлагает превосходное качество по доступной цене.', 0),
( 'Viera TX', 7023.32, 3, 7,  'Наслаждайтесь абсолютным совершенством цвета, контраста и четкости при помощи мощнейшего процессора', 0),
( 'PX-1234', 6323.98, 7, 14, 'Полезный объем холодильной камеры: 219 л Полезный объем морозильной камеры: 86 л Цвет: Нержавеющая сталь', 1),
( 'GoodNotebook432', 10311.98, 4, 6, 'Экран 13.3" IPS (3200x1800) QHD+, матовый / Intel Core i5-6200U (2.3 - 2.8 ГГц)', 1),
( 'bestVacuum', 1433.98, 5, 11, 'Тип пылесоса: с мешком. Тип уборки: сухая. Потребляемая мощность: 2000 Вт', 1),
( 'Oven-best', 9323.98, 2, 12, 'the best oven ever', 1),
( 'ProCam', 4303.98, 1, 8, 'Разрешение видео: Full HD (1920x1080) Тип носителя: Flash память Матрица (светочувствительный элемент): 1/5.8" (3.1 мм) Exmor R CMOS с тыловой подсветкой', 1),
( 'Super Oven', 6323.98, 5, 12, 'Комбинированная плита от компании на четыре газовые конфорки с мультифункциональной духовкой объемом 48 литров', 0),
( 'Notebook365', 12323.98, 8, 6,  'Экран 15.6" (1366x768) HD, глянцевый / Intel Celeron N3060', 0),
( 'Good Laptop', 3522.98, 6, 6, '/ Intel HD Graphics 400 / без ОД / LAN / Wi-Fi / Bluetooth / веб-камера / DOS / 2.2 кг / черный', 1);




  
INSERT INTO `producers`( `name`) VALUES ('Philips');
INSERT INTO `producers`( `name`) VALUES ('Bosh');
INSERT INTO `producers`( `name`) VALUES ('Sony');
INSERT INTO `producers`( `name`) VALUES ('Panasonic');
INSERT INTO `producers`( `name`) VALUES ('Saturn');
INSERT INTO `producers`( `name`) VALUES ('Apple');
INSERT INTO `producers`( `name`) VALUES ('LG');
INSERT INTO `producers`( `name`) VALUES ('Lenovo');



INSERT INTO `categories`( `name`, `parent_id`) VALUES ('������� ������� �������', null);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('������ ������� �������', null);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('���������, �� � �����������', null);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('�������� � ����������', null);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('��������', 4);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('��������', 4);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('TV', 3);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('������', 3);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('���������� ������', 1);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('��������', 3);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('��������', 2);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('����', 1);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('�������', 2);
INSERT INTO `categories`( `name`, `parent_id`) VALUES ('������������', 1);





INSERT INTO `products` ( `name`, `price`, `producer_fk`, `categories_fk`, `description`, `available`) VALUES
( 'iPhone 5s', 8323.99, 6, 5, '����� (4", IPS, 1136x640)/ Apple A7 (1.3 ���)/ �������� ������: 8 ��, ����������� ������: 1.2 ��/ RAM 1 ��/ 16 �� ���������� ������/ 3G/ LTE/ GPS/ Nano-SIM/ iOS 9/ 1560 ��*�', 1),
( 'UE22H5600AKXUA', 2134, 3, 7,  '��������� ������������� ������� � ������� � ������������� �������� ����� ���������  ���������� ������������ �������� �� ��������� ����.', 0),
( 'Viera TX', 7023.32, 3, 7,  '������������� ���������� ������������� �����, ��������� � �������� ��� ������ ���������� ����������', 0),
( 'PX-1234', 6323.98, 7, 14, '�������� ����� ����������� ������: 219 � �������� ����� ����������� ������: 86 � ����: ����������� �����', 1),
( 'GoodNotebook432', 10311.98, 4, 6, '����� 13.3" IPS (3200x1800) QHD+, ������� / Intel Core i5-6200U (2.3 - 2.8 ���)', 1),
( 'bestVacuum', 1433.98, 5, 11, '��� ��������: � ������. ��� ������: �����. ������������ ��������: 2000 ��', 1),
( 'Oven-best', 9323.98, 2, 12, 'the best oven ever', 1),
( 'ProCam', 4303.98, 1, 8, '���������� �����: Full HD (1920x1080) ��� ��������: Flash ������ ������� (������������������� �������): 1/5.8" (3.1 ��) Exmor R CMOS � ������� ����������', 1),
( 'Super Oven', 6323.98, 5, 12, '��������������� ����� �� �������� �� ������ ������� �������� � �������������������� �������� ������� 48 ������', 0),
( 'Notebook365', 12323.98, 8, 6,  '����� 15.6" (1366x768) HD, ��������� / Intel Celeron N3060', 0),
( 'Good Laptop', 3522.98, 6, 6, '/ Intel HD Graphics 400 / ��� �� / LAN / Wi-Fi / Bluetooth / ���-������ / DOS / 2.2 �� / ������', 1);



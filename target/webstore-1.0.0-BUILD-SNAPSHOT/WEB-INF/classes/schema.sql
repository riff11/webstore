  CREATE TABLE `producers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,  
  PRIMARY KEY (`id`));
  
  
CREATE TABLE `products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `price` INT NULL,
  `producer_fk` INT(45) NULL,
  `image` VARCHAR(255) NULL,
  `description` VARCHAR(255) NULL,
  `available` BIT(5)  NULL,  
  PRIMARY KEY (`id`),
  CONSTRAINT `fk`
    FOREIGN KEY (`producer_fk`)
    REFERENCES `producers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

 CREATE TABLE `categories` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,  
  PRIMARY KEY (`id`));


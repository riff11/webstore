  CREATE TABLE `producers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,  
  PRIMARY KEY (`id`));
  
   CREATE TABLE `categories` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `parent_id` INT NULL,  
  PRIMARY KEY (`id`),
  FOREIGN KEY (parent_id) REFERENCES categories(id)
  ON DELETE CASCADE
  ON UPDATE CASCADE);
  
  
CREATE TABLE `products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `price` INT NULL,
  `producer_fk` INT NULL,
  `categories_fk` INT NULL,
  `image` VARCHAR(255) NULL,
  `description` VARCHAR(255) NULL,
  `available` BIT(5)  NULL,  
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_product`
    FOREIGN KEY (`producer_fk`)
    REFERENCES `producers` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,    
 CONSTRAINT `fk_categories`
    FOREIGN KEY (`categories_fk`)
    REFERENCES `categories` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);




DROP TABLE IF EXISTS `product` ;
CREATE TABLE IF NOT EXISTS `product` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `brand` VARCHAR(45) NOT NULL,
    `category` VARCHAR(45) NOT NULL,
    `price` INT NULL DEFAULT '0',
    `create_dt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
--      ,UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
    );
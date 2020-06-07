CREATE TABLE `orders` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`user_id` VARCHAR(50) NOT NULL,
	`order_id` VARCHAR(50) NOT NULL,
	`email_id` VARCHAR(50),
	`payment_mode`TINYINT(1),
	`payment_info_id` VARCHAR(50),
	`address_id` VARCHAR(50),
	`total_bill` DECIMAL(10,2),
	`order_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
	`status_cd` VARCHAR(50) NOT NULL,
	`version` INT(11) NOT NULL,
	`created_by` VARCHAR(100) NOT NULL,
	`created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_by` VARCHAR(100) NOT NULL,
	`updated_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`),
	UNIQUE KEY `UK_OD_OID` (`order_id`),
	KEY `IDX_OD_UID` (`user_id`),
	KEY `IDX_OD_EID` (`email_id`)
);


CREATE TABLE `ordered_items` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`order_item_id` VARCHAR(50) NOT NULL,
	`order_id` VARCHAR(50) NOT NULL,
	`item_id` VARCHAR(50) NOT NULL,
	`item_name` VARCHAR(100) NOT NULL,
	`description` TEXT,
	`quantity` BIGINT(10),
	`status_cd` VARCHAR(50) NOT NULL,
	`version` INT(11) NOT NULL,
	`created_by` VARCHAR(100) NOT NULL,
	`created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_by` VARCHAR(100) NOT NULL,
	`updated_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`),
	UNIQUE KEY `UK_ODIT_OIID` (`order_item_id`),
	KEY `IDX_ODIT_OID` (`order_id`),
	KEY `IDX_ODIT_II` (`item_id`)
);
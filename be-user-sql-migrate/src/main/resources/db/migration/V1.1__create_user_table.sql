CREATE TABLE `user` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `account` VARCHAR(30) NOT NULL COMMENT '帳號',
    `password_hash` VARCHAR(128) NOT NULL COMMENT '密碼雜湊',
    `mail` VARCHAR(30) NOT NULL COMMENT '信箱',
    `phone` VARCHAR(10) COMMENT '手機號碼',

    UNIQUE INDEX (`mail`),
    UNIQUE INDEX (`account`),
    PRIMARY KEY(`id`)
) AUTO_INCREMENT=1 CHARSET=utf8mb4 ENGINE=InnoDB COLLATE=utf8mb4_unicode_ci COMMENT='用戶資料';
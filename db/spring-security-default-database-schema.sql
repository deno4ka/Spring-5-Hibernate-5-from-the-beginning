CREATE TABLE `users` (
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `enabled` TINYINT(1) NOT NULL,
    PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `authorities` (
    `username` VARCHAR(50) NOT NULL,
    `authority` VARCHAR(50) NOT NULL,
    UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
    CONSTRAINT `authorities_ibfk_1`
        FOREIGN KEY (`username`)
            REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `users` VALUES ('john', '{noop}test123', 1);
INSERT INTO `users` VALUES ('mary', '{noop}test123', 1);
INSERT INTO `users` VALUES ('susan', '{noop}test123', 1);

INSERT INTO `authorities` VALUES ('john', 'ROLE_EMPLOYEE');
INSERT INTO `authorities` VALUES ('mary', 'ROLE_EMPLOYEE');
INSERT INTO `authorities` VALUES ('mary', 'ROLE_MANAGER');
INSERT INTO `authorities` VALUES ('susan', 'ROLE_EMPLOYEE');
INSERT INTO `authorities` VALUES ('susan', 'ROLE_ADMIN');
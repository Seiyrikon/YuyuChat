DROP DATABASE IF EXISTS yuyuchat_db;

CREATE DATABASE yuyuchat_db;

USE yuyuchat_db;

DROP USER 'yuyuchat'@'localhost';
CREATE USER 'yuyuchat'@'localhost' IDENTIFIED BY 'tsukiden+';
GRANT ALL PRIVILEGES ON yuyuchat_db.* TO 'yuyuchat'@'localhost';

FLUSH PRIVILEGES;

DROP TABLE IF EXISTS tbl_user;
CREATE TABLE tbl_user (
	user_id INT(9) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    del_flag INT(1) NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL DEFAULT NULL
);

DROP TABLE IF EXISTS tbl_personal_info;
CREATE TABLE tbl_personal_info (
	pi_id INT(9) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT(9) UNSIGNED NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    middle_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    del_flag INT(1) NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES tbl_user(user_id)
);

DROP TABLE IF EXISTS tbl_requests;
CREATE TABLE tbl_requests (
	r_id INT(9) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT(9) UNSIGNED NOT NULL,
    friend_id INT(9) UNSIGNED NOT NULL,
    del_flag INT(1) NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES tbl_user(user_id),
    FOREIGN KEY (friend_id) REFERENCES tbl_user(user_id)
);

DROP TABLE IF EXISTS tbl_confirm_requests;
CREATE TABLE tbl_confirm_requests (
	cr_id INT(9) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT(9) UNSIGNED NOT NULL,
    friend_id INT(9) UNSIGNED NOT NULL,
    del_flag INT(1) NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES tbl_user(user_id),
    FOREIGN KEY (friend_id) REFERENCES tbl_user(user_id)
);

DROP TABLE IF EXISTS tbl_friends;
CREATE TABLE tbl_friends(
	f_id INT(9) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT(9) UNSIGNED NOT NULL,
    friend_id INT(9) UNSIGNED NOT NULL,
    del_flag INT(1) NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES tbl_user(user_id),
    FOREIGN KEY (friend_id) REFERENCES tbl_user(user_id)
);

-- SELECT user FROM mysql.user WHERE user = 'yuyuchat' AND host = 'localhost';



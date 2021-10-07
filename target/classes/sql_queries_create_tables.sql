DROP DATABASE IF EXISTS  blogDB;
CREATE DATABASE blogDB;
USE blogDB;

DROP TABLE IF EXISTS blog_schema;
CREATE TABLE blog_schema(
    schema_name varchar(50) PRIMARY KEY,
    category varchar(50),
    color varchar(20),
    background_image blob
);

DROP TABLE IF EXISTS blog_table;
CREATE TABLE blog_table(
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
    note_text varchar(100),
    comment_text varchar(50),
    blog_schema varchar(30),
    FOREIGN KEY(blog_schema) REFERENCES blog_schema(schema_name)
);

DROP TABLE IF EXISTS role_table;
CREATE TABLE role_table(
    role_name ENUM('ADMIN', 'MODERATOR', 'USER', 'UNREGISTERED') DEFAULT 'UNREGISTERED' PRIMARY KEY,
    can_read_data boolean,
    can_modify_data boolean,
    can_read_note boolean,
    can_modify_note boolean,
    can_delete_note boolean,
    can_write_comment boolean
);

DROP TABLE IF EXISTS user_table;
CREATE TABLE user_table(
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
    user_name varchar(50),
    user_password varchar(50),
    user_role ENUM('ADMIN', 'MODERATOR','USER', 'UNREGISTERED') DEFAULT 'UNREGISTERED',
    FOREIGN KEY(user_role) REFERENCES role_table(role_name) 
);

DROP TABLE IF EXISTS note_table;
CREATE TABLE note_table(
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
    note_text varchar(100),
    user_name varchar(50),
    has_comment boolean,
    state ENUM('DRAFT', 'RELEASED', 'DELETED') DEFAULT 'DRAFT',
    blog_id INT UNSIGNED NOT NULL,
    FOREIGN KEY(blog_id) REFERENCES blog_table(id)
);

DROP TABLE IF EXISTS comment_table;
CREATE TABLE comment_table(
    comment_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
    comment_text varchar(50),
    user_name varchar(50),
    note_id INT UNSIGNED NOT NULL,
    FOREIGN KEY(note_id) REFERENCES note_table(id)
);

DROP TABLE IF EXISTS person_table;
CREATE TABLE person_table(
    name varchar(100),
    is_registered boolean,
    blog_id INT UNSIGNED NOT NULL,
    FOREIGN KEY(blog_id) REFERENCES blog_table(id)
);
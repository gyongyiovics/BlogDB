DROP DATABASE IF EXISTS  blogDB;
CREATE DATABASE blogDB;
USE blogDB;

DROP TABLE IF EXISTS blog_schema;
CREATE TABLE blog_schema(
    /*id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,*/
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

DROP TABLE IF EXISTS user_table;
CREATE TABLE user_table(
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
    user_name varchar(50),
    user_password varchar(50),
    user_role ENUM('ADMIN', 'MODERATOR','USER') DEFAULT 'USER',
    FOREIGN KEY(user_role) REFERENCES role_table(role_name) 
);

DROP TABLE IF EXISTS role_table;
CREATE TABLE role_table(
    role_name ENUM('ADMIN', 'MODERATOR','USER') DEFAULT 'USER' PRIMARY KEY,
    can_read_data boolean,
    can_modify_data boolean,
    can_read_note boolean,
    can_modify_note boolean,
    can_delete_note boolean,
    can_write_comment boolean
);

DROP TABLE IF EXISTS note_table;
CREATE TABLE note_table(
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
    note_text varchar(100),
    user_name varchar(50),
    has_comment boolean,
    state ENUM('draft', 'released', 'deleted') DEFAULT 'draft',
    blog_id INT,
    FOREIGN KEY(blog_id) REFERENCES blog_table(id)
);

DROP TABLE IF EXISTS comment_table;
CREATE TABLE comment_table(
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
    comment_text varchar(50),
    user_name varchar(50),
    note_id INT UNSIGNED NOT NULL,
    FOREIGN KEY(note_id) REFERENCES note_table(id)
);


DROP TABLE IF EXISTS person_table;
CREATE TABLE person_table(
    name varchar(100),
    is_registered boolean,
    own_notes varchar(100),
    own_comments varchar(50),
    other_notes varchar(100),
    other_comments varchar(50)
);

/*kapcsolattáblák*/
DROP TABLE IF EXISTS connect_user_and_note;
CREATE TABLE connect_user_and_note(
/*	is_own boolean,
    authorities varchar(50)*/ /*enum instead: canModify, canAdd, canRead, canDelete*/
    user_id INT UNSIGNED NOT NULL,
    is_own boolean,
    can_modify int,
    can_add int,
    can_read int,
    can_delete int,
    note_id INT UNSIGNED NOT NULL,
    FOREIGN KEY(user_id) REFERENCES user_table(id),
    FOREIGN KEY(note_id) REFERENCES note_table(id)
);

DROP TABLE IF EXISTS connect_user_and_comment;
CREATE TABLE connect_user_and_comment(
    user_id INT UNSIGNED NOT NULL,
    is_own boolean,
    can_modify int,
    can_add int,
    can_read int,
    can_delete int,
    comment_id INT UNSIGNED NOT NULL,
    FOREIGN KEY(user_id) REFERENCES user_table(id),
    FOREIGN KEY(comment_id) REFERENCES comment_table(id)
);

DROP TABLE IF EXISTS connect_user_and_roles;
CREATE TABLE connect_user_and_roles(
	/*is_registered boolean,*/
    role_name ENUM('ADMIN', 'MODERATOR','USER') DEFAULT 'USER',
    user_id INT UNSIGNED NOT NULL,
    FOREIGN KEY(role_name) REFERENCES role_table(role_name),
    FOREIGN KEY(user_id) REFERENCES user_table(id)
);


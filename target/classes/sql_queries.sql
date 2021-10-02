DROP DATABASE IF EXISTS  blogDB;
CREATE DATABASE blogDB;
USE blogDB;

DROP TABLE IF EXISTS blog_table;
CREATE TABLE blog_table(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
	note_text varchar(50),
    comment_text varchar(50),
    is_own boolean,
    blog_schema varchar(30)              /*PK from blog_schema*/
);

DROP TABLE IF EXISTS user_table;
CREATE TABLE user_table(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
	user_name varchar(50), /*username*/
	is_registered boolean,
    role_name ENUM('ADMIN', 'MODERATOR','USER') DEFAULT 'USER' /*PK from role_table*/
);

DROP TABLE IF EXISTS role_table;
CREATE TABLE role_table(
	role_name ENUM('ADMIN', 'MODERATOR','USER') DEFAULT 'USER', /*PK for the user_table*/
    can_read_data boolean,
    can_modify_data boolean,
    can_read_note boolean,
    can_modify_note boolean,
    can_delete_note boolean,
    can_write_comment boolean
);

DROP TABLE IF EXISTS blog_schema;
CREATE TABLE blog_schema(
    schema_name varchar(50),
    category varchar(50),
    color varchar(20),
    background_image blob
);

DROP TABLE IF EXISTS note_table;
CREATE TABLE note_table(
    note_title varchar(30),
    note_text varchar(50),
    user_name varchar(50),
    has_comment boolean
    /*comment_title varchar(50) if the has_comment is false, this is empty*/
);

DROP TABLE IF EXISTS comment_table;
CREATE TABLE comment_table(
    comment_title varchar(30),
    comment_text varchar(50),
    user_name varchar(50),
    has_note boolean
                          /*this might be always true! has_comment instead?*/
    /*note_title varchar(50) if the has_note is false, this is empty*/
);

CREATE TABLE notes_and_comments(
    note_title varchar(30),
    comment_title varchar(30)
                               /*more to more connect OR more to one*/
);


INSERT INTO blog_table(note_text, comment_text, is_own) VALUES
	('Hello world', 'no comment', true),
    ('Todays schedule', 'not today', false),
    ('Hello world', '', true);

/*kapcsolattáblák*/
DROP TABLE IF EXISTS people_table;
CREATE TABLE people_table(
    name varchar(100),
    role varchar(50),
    own_notes varchar(50),
    own_comments varchar(50),
	other_notes varchar(50),
    other_comments varchar(50)
);

DROP TABLE IF EXISTS connect_user_and_notes;
CREATE TABLE connect_user_and_notes(
	is_own boolean,
    authorities varchar(50) /*enum instead: canModify, canAdd, canRead, canDelete*/
);

DROP TABLE IF EXISTS connect_user_and_roles;
CREATE TABLE connect_user_and_roles(
	is_registered boolean
);
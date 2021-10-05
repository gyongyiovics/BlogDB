DROP DATABASE IF EXISTS  blogDB;
CREATE DATABASE blogDB;
USE blogDB;

DROP TABLE IF EXISTS blog_table;
CREATE TABLE blog_table(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
	note_text varchar(50),
    comment_text varchar(50),
    is_own boolean,
    blog_schema varchar(30),
    FOREIGN KEY(blog_schema) REFERENCES blog_schema(schema_name)
);

DROP TABLE IF EXISTS user_table;
CREATE TABLE user_table(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
	user_name varchar(50), /*username*/
    is_registered boolean
	/*role_name ENUM('ADMIN', 'MODERATOR','USER') DEFAULT 'USER'*/ /*PK from role_table*/
);

DROP TABLE IF EXISTS role_table;
CREATE TABLE role_table(
	role_name ENUM('ADMIN', 'MODERATOR','USER') DEFAULT 'USER' PRIMARY KEY, /*PK for the user_table*/
    can_read_data boolean,
    can_modify_data boolean,
    can_read_note boolean,
    can_modify_note boolean,
    can_delete_note boolean,
    can_write_comment boolean
);

DROP TABLE IF EXISTS blog_schema;
CREATE TABLE blog_schema(
    /*id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,*/
    schema_name varchar(50) PRIMARY KEY,
    category varchar(50),
    color varchar(20),
    background_image blob
);

DROP TABLE IF EXISTS note_table;
CREATE TABLE note_table(
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
    note_title varchar(30),
    note_text varchar(50),
    user_name varchar(50),
    has_comment boolean,
    state ENUM('draft', 'released', 'deleted') DEFAULT 'draft',
    /*comment_title varchar(50) if the has_comment is false, this is empty*/
    blog_schema varchar(50),
    FOREIGN KEY(blog_schema) REFERENCES blog_schema(schema_name)
);

DROP TABLE IF EXISTS comment_table;
CREATE TABLE comment_table(
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
    comment_title varchar(30),
    comment_text varchar(50),
    user_name varchar(50),
    note_id int,
    /*has_note boolean,*/
    /*this might be always true! has_comment instead?*/
    /*note_title varchar(50) if the has_note is false, this is empty*/
    FOREIGN KEY(note_id) REFERENCES note_table(id)
);

DROP TABLE IF EXISTS people_table;
CREATE TABLE people_table(
    name varchar(100),
    own_notes varchar(50),
    own_comments varchar(50),
	other_notes varchar(50),
    other_comments varchar(50)
);

/*kapcsolattáblák*/
DROP TABLE IF EXISTS connect_user_and_note;
CREATE TABLE connect_user_and_note(
/*	is_own boolean,
    authorities varchar(50)*/ /*enum instead: canModify, canAdd, canRead, canDelete*/
    user_id int,
    is_own boolean,
    can_modify int,
    can_add int,
    can_read int,
    can_delete int,
    note_id int,
    FOREIGN KEY(user_id) REFERENCES user_table(id),
    FOREIGN KEY(note_id) REFERENCES note_table(id)
);

DROP TABLE IF EXISTS connect_user_and_comment;
CREATE TABLE connect_user_and_comment(
    user_id int,
    is_own boolean,
    can_modify int,
    can_add int,
    can_read int,
    can_delete int,
    comment_id int,
    FOREIGN KEY(user_id) REFERENCES user_table(id),
    FOREIGN KEY(comment_id) REFERENCES comment_table(id)
);

DROP TABLE IF EXISTS connect_user_and_roles;
CREATE TABLE connect_user_and_roles(
	/*is_registered boolean,*/
    role_name ENUM('ADMIN', 'MODERATOR','USER') DEFAULT 'USER',
    user_id int,
    FOREIGN KEY(role_name) REFERENCES role_table(role_name),
    FOREIGN KEY(user_id) REFERENCES user_table(id)
);

INSERT INTO blog_table(note_text, comment_text, is_own) VALUES
                                                            ('Hello world', 'no comment', true),
                                                            ('Todays schedule', 'not today', false),
                                                            ('Hello world', '', true);
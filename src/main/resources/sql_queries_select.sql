/**
 * visszaadja adott szerepkörű felhasználók összes adatát
 * mysql: SELECT * FROM user WHERE role IS ...;
 JOIN user_table and role_table
 * java: getUsersData
 * visszaadja egy adott felhasználó összes adatát:
 * mysql: SELECT * FROM user WHERE user_name IS ...;
 * java: new User
 * visszaadja egy adott felhasználó összes blogját
 * mysql: SELECT blog_text FROM ... WHERE user_name IS ...;
 * java: getUserNotes
 * visszaadja egy adott blog összes blogbejegyzését
 * mysql: SELECT blog_text FROM ... WHERE blog is ...;
 * java: new Blog -> getText
 * visszaadja egy adott blogbejegyzéshez tartozó összes kommentet
 * mysql: SELECT comment_text FROM ... WHERE blog_text IS ...;
 * java: getNoteComments
 **/
 
 
 SELECT * FROM user_table WHERE user_name LIKE 'Jancsi@45';
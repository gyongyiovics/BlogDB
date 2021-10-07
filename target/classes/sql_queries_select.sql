/*
SELECT * FROM blog_schema;
SELECT * FROM blog_table;
*/
SELECT * FROM user_table WHERE user_role LIKE 'ADMIN';
SELECT * FROM user_table WHERE user_name LIKE 'Gizi@123';
SELECT note_text FROM note_table WHERE user_name LIKE 'Jancsi@45';
SELECT note_text FROM note_table WHERE blog_id = 2;
SELECT comment_text FROM comment_table WHERE note_id = 1;

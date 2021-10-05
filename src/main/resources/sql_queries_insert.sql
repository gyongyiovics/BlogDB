INSERT INTO blog_schema VALUES
('blooming','flowers_schema','pink', LOAD_FILE('data.png')),
('zombified','zombies_schema','grey', LOAD_FILE('data.png')), 
('cats','cat_schema','yellow', LOAD_FILE('data.png')),
('dogs','dog_schema','purple', LOAD_FILE('data.png')); 

INSERT INTO blog_table(note_text, comment_text, is_own) VALUES
('Hello world', 'no comment', true),
('Todays schedule', 'not today', false),
('Zombie ipsum reversus ab viral inferno', '???', true),
('Cum horribilem walking dead resurgere de crazed sepulcris creaturis...', '', false);

INSERT INTO user_table(user_name, is_registered) VALUES
('Jancsi@45', true),
('Bela@bbb', false),
('Gizi@123', true),
('Geodézia23', true);

INSERT INTO role_table VALUES
('ADMIN', true, true, true, true, true, true),
('MODERATOR', false, false, true, true, true, true),
('USER', true, true, true, true, true, true),
('USER', false, false, true, false, false, true),
('USER', true, false, true, false, false, false);

INSERT INTO note_table VALUES();

INSERT INTO comment_table VALUES();

INSERT INTO people_table VALUES();


/*connections*/
INSERT INTO connect_user_and_note VALUES();

INSERT INTO connect_user_and_comment VALUES();

INSERT INTO connect_user_and_roles VALUES();
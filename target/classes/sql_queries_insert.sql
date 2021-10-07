INSERT INTO blog_schema VALUES
('blooming','flowers_schema','pink', LOAD_FILE('data.png')),
('zombified','zombies_schema','grey', LOAD_FILE('data.png')), 
('cats','cat_schema','yellow', LOAD_FILE('data.png')),
('dogs','dog_schema','purple', LOAD_FILE('data.png')); 

INSERT INTO blog_table(note_text, comment_text, blog_schema) VALUES
('Hello world', 'no comment', 'blooming'),
('Todays schedule', 'not today', 'dogs'),
('Zombie ipsum reversus ab viral inferno', '???', 'zombified'),
('Cuom horribilem walking dead resurgere de crazed sepulcris creaturis...', '', 'zombified');

INSERT INTO role_table VALUES
('ADMIN', true, true, true, true, true, true),
('MODERATOR', false, false, true, true, true, true),
('USER', true, true, true, true, true, true),
('UNREGISTERED', true, false, true, false, false, false);

INSERT INTO user_table(user_name, user_password, user_role) VALUES
('Jancsi@45', 'pw', 'ADMIN'),
('Bela@bbb', 'pw', 'USER'),
('Gizi@123', 'pw', 'UNREGISTERED'),
('Geodézia23', 'pw', 'MODERATOR');


INSERT INTO note_table(note_text, user_name, has_comment, state, blog_id) VALUES
('Hello world', 'Jancsi@45', true, 'RELEASED', 1),
('Todays schedule', 'Bela@bbb', true, 'RELEASED', 2),
('Zombie ipsum reversus ab viral inferno', 'Gizi@123', false, 'DRAFT', 3),
('Cuom horribilem walking dead resurgere de crazed sepulcris creaturis...', 'Geodézia23', true, 'DELETED', 4);

INSERT INTO comment_table(comment_text, user_name, note_id) VALUES
('no comment', 'Jancsi@45', 1),
('hello again', 'Jancsi@45', 2),
('no comment', 'Jancsi@45', 4),
('', 'Jancsi@45', 2),
('I have commented on this before, blablabla', 'Jancsi@45', 2);

INSERT INTO person_table(name, is_registered, blog_id) VALUES
('Jancsi@45', true, 1),
('Bela@bbb', true, 2),
('Gizi@123', false, 1),
('Geodézia23', true, 3);

INSERT INTO blog_to_user VALUES
('HelloBello', 1, 1),
('BElaVagyok', 2, 2),
('Schedule', 2, 1);
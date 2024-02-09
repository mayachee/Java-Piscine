-- Insert sample users
INSERT INTO User (login, password) VALUES
    ('user1', 'password1'),
    ('user2', 'password2'),
    ('user3', 'password3'),
    ('user4', 'password4'),
    ('user5', 'password5');

-- Insert sample chatrooms
INSERT INTO Chatroom (chatroom_name, chatroom_owner) VALUES
    ('General', 1), -- user1 is the owner
    ('Random', 2),  -- user2 is the owner
    ('Tech Talk', 3), -- user3 is the owner
    ('Funny Chat', 4), -- user4 is the owner
    ('Study Group', 5); -- user5 is the owner

-- Insert sample messages
INSERT INTO Message (message_author, message_room, message_text, message_datetime) VALUES
    (1, 1, 'Hello everyone!', NOW()),
    (2, 1, 'Hi there!', NOW()),
    (3, 3, 'Anyone interested in AI?', NOW()),
    (4, 4, 'What''s up folks?', NOW()),
    (5, 5, 'Let''s meet at the library tomorrow.', NOW());

-- Insert sample courses
INSERT INTO Course (course_name) VALUES
    ('Mathematics'),
    ('History'),
    ('Computer Science');

-- Insert sample lessons
INSERT INTO Lesson (lesson_name, course_id) VALUES
    ('Algebra', 1), -- Algebra lesson belongs to Mathematics course
    ('World War II', 2), -- World War II lesson belongs to History course
    ('Data Structures', 3); -- Data Structures lesson belongs to Computer Science course

-- User table
CREATE TABLE User (
    user_id SERIAL PRIMARY KEY,
    login VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Chatroom table
CREATE TABLE Chatroom (
    chatroom_id SERIAL PRIMARY KEY,
    chatroom_name VARCHAR(255) NOT NULL,
    chatroom_owner INTEGER REFERENCES User(user_id)
);

-- Message table
CREATE TABLE Message (
    message_id SERIAL PRIMARY KEY,
    message_author INTEGER REFERENCES User(user_id),
    message_room INTEGER REFERENCES Chatroom(chatroom_id),
    message_text TEXT,
    message_datetime TIMESTAMP
);

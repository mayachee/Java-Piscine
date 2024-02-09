package fr.med1337.chat.models;

// import fr.med1337.chat.models.Chatroom;
// import fr.med1337.chat.models.User;
// import fr.med1337.chat.models.Message;
public class Main {
    
    public static void main(String[] args) {
        User user1 = new User(1, "user 1", "password 1", null, null);
        User user2 = new User(2, "user 2", "password 2", null, null);

        Chatroom room1 = new Chatroom(1, "room 1", user1, null);
        Chatroom room2 = new Chatroom(2, "room 2", user2, null);

        Message message1 = new Message(1, user1, room1, "message 1", null);


        System.out.println(user1);
        System.out.println(user2);

        System.out.println(room1);
        System.out.println(room2);


        System.out.println(message1);
    }
}

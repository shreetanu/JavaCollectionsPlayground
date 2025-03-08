package my.practice.datastructures.chat;

import my.practice.datastructures.chat.Mediator.ChatMediator;
import my.practice.datastructures.chat.Mediator.ChatMediatorImpl;
import my.practice.datastructures.chat.User.User;
import my.practice.datastructures.chat.User.UserImpl;

public class Chat {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediatorImpl();
        User user1 = new UserImpl(chatMediator,"LAILA");
        User user2 = new UserImpl(chatMediator,"MAJNU");
        chatMediator.addUsers(user1);
        chatMediator.addUsers(user2);

        user1.sendMessage("HOW ARE YOU");
        user2.sendMessage("I AM FINE, HOW ARE YOU");
        user1.sendMessage("I AM GOOD");
        user2.sendMessage("GOOD TO KNOW");
    }


}

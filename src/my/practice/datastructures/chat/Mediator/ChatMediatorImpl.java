package my.practice.datastructures.chat.Mediator;

import my.practice.datastructures.chat.User.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatMediatorImpl implements ChatMediator{
    private List<User> users;

    public ChatMediatorImpl() {
        users = new ArrayList<>();
    }
    @Override
    public void addUsers(User user) {
        System.out.println("ADDING A USER");
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        for(User user1: users) {
            if(!Objects.equals(user1.getName(), user.getName())) {
                user1.receiveMessage(message);
            }
        }
    }
}

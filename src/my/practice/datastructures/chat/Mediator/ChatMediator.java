package my.practice.datastructures.chat.Mediator;

import my.practice.datastructures.chat.User.User;

public interface ChatMediator {

    void addUsers(User user);

    void sendMessage(String message, User user);
}

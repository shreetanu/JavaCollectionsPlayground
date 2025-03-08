package my.practice.datastructures.chat.User;

import my.practice.datastructures.chat.Mediator.ChatMediator;

public class UserImpl extends User {

    public UserImpl(ChatMediator chatMediator,String name) {
        super(chatMediator,name);
    }

    @Override
    public void sendMessage(String message) {
        String sentMess = this.name+" Sends a message: "+ message;
        chatMediator.sendMessage(sentMess,this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Received Message"+message);
    }

}

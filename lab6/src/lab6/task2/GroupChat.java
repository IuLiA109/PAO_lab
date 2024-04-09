package lab6.task2;

import java.util.ArrayList;
import java.util.List;

public class GroupChat implements Topic{
    private String name;
    private List<User> members;

    public GroupChat(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }
    @Override
    public void join(User user) {
        members.add(user);
    }
    @Override
    public void exit(User user) {
        members.remove(user);
    }
    @Override
    public void notifyUsers(User sender, String message) {
        for (User user : members) {
            if (!user.equals(sender)) {
                user.update(message, sender, name);
            }
        }
    }
}

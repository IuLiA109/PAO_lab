package lab6.task2;

public interface Topic {
    void join(User user);
    void exit(User user);
    void notifyUsers(User sender, String message);
}

package lab6.task2;

public class ConcreteUser implements User{
    private String name;
    public ConcreteUser(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    @Override
    public void update(String message, User sender, String topic) {
        System.out.println("[" + name + "] " + sender.getName() + " @ " + topic + ": " + message);
    }
}

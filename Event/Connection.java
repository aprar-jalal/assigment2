package Event;

public class Connection {
    private final String name;

    public Connection(String name) {
        this.name = name;
    }

    public void execute(String sql) {
        System.out.println("[DB] (" + name + ") execute: " + sql);
    }
}

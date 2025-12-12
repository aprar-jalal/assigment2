package DataBase;

import Event.Connection;
import Event.ConnectionPool;
import Event.Event;
import Observer.IObserver;

public class SqlDataBase implements IdataBases, IObserver {
    private final ConnectionPool pool;

    public SqlDataBase(ConnectionPool pool) {
        this.pool = pool;
    }

    @Override
    public void save(int id, String data) {
        Connection c = pool.acquire();
        try {
            c.execute("INSERT events(id,data) VALUES(" + id + "," + data + ")");
            System.out.println("[DB] saved " + id);
        } finally {
            pool.release(c);
        }
    }
    @Override
    public void update(Event event) {
        save(event.getId(), event.getPayload());
    }
}

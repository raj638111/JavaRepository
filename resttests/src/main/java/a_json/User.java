package a_json;


/**
 * Created by mertcaliskan
 * on 22/09/14.
 */
public class User {		//Domain Class(Model)

    private int id;
    private String name;

    public User() {}

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

package b_xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by mertcaliskan
 * on 22/09/14.
 */
@XmlRootElement
public class User {		//Domain Class(Model)
	
	@XmlElement
    private int id;
	
	@XmlElement
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

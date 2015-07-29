package b_xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Repository;

/**
 * Created by mertcaliskan
 * on 22/09/14.
 */
@Repository							/* 	@Repository 
											+ 	Represents a Bean and is a derivative of
												@Component */
public class UserRepository {

    private Map<Integer, User> users = new HashMap<Integer, User>();

    @PostConstruct					/* 	This method will be called post
    									instantiation */
    public void setup() {
    	System.out.println("UserRepository : Post initialization setup");
        users.put(1, new User(1, "Raj"));
        users.put(2, new User(2, "Akhil"));
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public List<User> findAll() {
        return new ArrayList<User>(users.values());
    }

    public User find(int id) {
        return users.get(id);
    }

    public void update(int id, User user) {
        users.put(id, user);
    }

    public void delete(int id) {
        users.remove(id);
    }
}

package a_json;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mertcaliskan
 * on 18/09/14.
 */
@RestController							/*	Combines 
												+ @ResponseBody & 
												+ @Controller
											@Controller
											 	+ Represents Spring Managed Bean #61
												+ Represents a Controller in MVC Framework #84
											@ResponseBody
												+ Is responsible for convertring response to JSON #316
												+ If we do not specify here, than the annotation @ResponseBody
												  needs to be specified in each method #316
												  
										*/
@RequestMapping("/userclr")				/*
											Provide a base mapping uri for all methods below #317
											URI format
												+ http://<server‐name>:<server‐port>/<servlet‐context>/
														<base‐mapping>/<handler‐method‐mapping>
										*/
public class UserRestController {

    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = Logger.getLogger(UserRestController.class);
    
    //-------------------------------------------------------------------------------
    
    @RequestMapping(value = "/users", method=RequestMethod.POST) /*
    																Map resource '/rest/users' to this Method
    																when request method is POST
    															*/
    public void save(@RequestBody User user) {					/*	@RequestBody specifies the object
    																'user' is available in HTTP Posts Request body
    															*/
        userRepository.save(user);
    }
    
    
  //-------------------------------------------------------------------------------

    @RequestMapping(value = "/users", method=RequestMethod.GET)/*
																	Map resource '/rest/users' to this Method
																	when request method is GET
     															*/
    public List<User> list() {
    	
    	logger.debug("list() : Inside list() method");
    	
        return userRepository.findAll();
    }
    
  //-------------------------------------------------------------------------------

    @RequestMapping(value="/users/{id}", method=RequestMethod.GET)
    public User get(@PathVariable("id") int id) {			/*
    																@PathVariable is used to retrieve the value of 'id'
    																from the path variable {id} #318
    														*/
        return userRepository.find(id);
    }
  //-------------------------------------------------------------------------------

    @RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
    public void update(@PathVariable("id") int id, @RequestBody User user) {
        userRepository.update(id, user);
    }
    
  //-------------------------------------------------------------------------------

    @RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        userRepository.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
    
}

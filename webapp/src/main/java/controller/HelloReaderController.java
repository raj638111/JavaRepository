package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloReaderController {
	
    @RequestMapping(value = "/hello")
    public ModelAndView sayHello() {
    	
    	ModelAndView mv = new ModelAndView();	//** 	Use ModelAndView Class to hold 
    											//		both Model & View in MVC framework
    
    	// Add **attribute to the Model
        mv.addObject("message", "Hello Reader!"); 
        
        // Set View Name associated with the model
        mv.setViewName("helloReader");  
        return mv;
    }
}


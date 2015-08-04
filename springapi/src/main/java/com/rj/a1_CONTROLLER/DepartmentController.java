package com.rj.a1_CONTROLLER;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rj.a3_REPOSITORY.DepartmentRepository;
import com.rj.a7_DOMAIN.Department;

@RestController							/*	
											Combines 					#@RestController
											+ 	@ResponseBody		
												-	Normally Defined in each method of the Controller  #@316, #@ResponseBody
												-	Does automatic conversion of the response to oJSON
											+ 	@Controller
												-	Used to represent Controller bean #@Controller
												-	Inherits @Component (Used to create Spring Bean) #@Component 
										*/
@RequestMapping("/departmentid")		/*
											+	Used to map request URL to handler methods #@RequestMapping, #71
											+	When used in Class level, all methods of a Controller is mapped to a URL
										*/
public class DepartmentController {
	
	final static Logger logger = Logger.getLogger(DepartmentController.class);
	NamedParameterJdbcTemplate t;
	
	DepartmentController() {
		logger.debug("## Inside Constructor ");
	}
	
	@Autowired							/*	
											+ 	Used to Specify the Bean dependency that will be injected by
												Spring Container at run time	#19, #@Autowired
										*/
	private DepartmentRepository repo;
	
	@RequestMapping(value="/departments", method=RequestMethod.POST)
	public void save(@RequestBody Department department) {	//???
		logger.debug("## Inside save()");
		//TODO : Provide authorization to this method
		//TODO : Enable input validation..if possible with @Valid
		//		 http://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/mvc.html#mvc-config		
	}
	
	
	@RequestMapping(value="/departments", method=RequestMethod.GET)
	public List<Department> get() {
		return repo.select();
	}
	
	
	@Cacheable(value="repo")	// +	Indicates return value will be cached according to its argument #288
								// +	Note also the method should be public #288
								// +	Here 'repo' is the name of the Cache Storage(Believe this name is  
								//		not realted to the variable 'repo') #290
	@RequestMapping(value="/departments/{departmentId}", method=RequestMethod.GET)
	public List<Department> get(@PathVariable("departmentId") int id) {
		logger.debug("## Not cached : Retrieving from actual source");
		return repo.select(id);
	}
}
	
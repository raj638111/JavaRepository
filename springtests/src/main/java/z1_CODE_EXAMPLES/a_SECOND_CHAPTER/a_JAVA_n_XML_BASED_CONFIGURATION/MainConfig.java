package z1_CODE_EXAMPLES.a_SECOND_CHAPTER.a_JAVA_n_XML_BASED_CONFIGURATION;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainConfig {

	public static void main(String[] args) {
		
		/*
		 * ApplicationContext					+ Represents the Spring Container #25
		 * AnnotationConfigApplicationContext	+ Is used for Java based Configuration Metadata Classes
		 * 										+ Argument can also take more than 1 configuration classes
		 */
		//AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Ch2BeanConfiguration.class);
		ClassPathXmlApplicationContext applicationContext = new
				ClassPathXmlApplicationContext("z_CODE_EXAMPLES.a_CONFIGURATION_BASICS.a_JAVA_CONFIGURATION.ch2-beans.xml");
		
		/*
		 * Bean Lookup	+ Is the process of obtaining Spring-Managed Bean
		 * 				+ The 2nd argument is used to make upcas
		 */
		AccountService accountService = applicationContext.getBean("accountService", AccountService.class);

		System.out.println("Before money transfer");
		System.out.println("Account 1 balance :" + accountService.getAccount(1).getBalance());
		System.out.println("Account 2 balance :" + accountService.getAccount(2).getBalance());		
		
		accountService.transferMoney(1, 2, 5.0);
		
		System.out.println("After money transfer");
		System.out.println("Account 1 balance :" + accountService.getAccount(1).getBalance());
		System.out.println("Account 2 balance :" + accountService.getAccount(2).getBalance());
	}

}

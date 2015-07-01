package z_CODE_EXAMPLES.a_SECOND_CHAPTER.a_JAVA_n_XML_BASED_CONFIGURATION;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration	
				/*
						Indicates to Container, this is a Configuration Metadata as
						well as itself is a Bean #25
				*/
public class Ch2BeanConfiguration {

	@Bean  /*
				+	Indicates to Container this method is a Factory Method 
					& should be called during bootstrap & the return value of the method 
					wshould be treated as 'Spring Managed Bean' #25
					
			    + 	Method Name is accepted as Bean Name by Default
			    
			    + 	Recommended : Always use return value as 'Interface' Class
			    
			    + 	Each Bean is in 'Singleton Scope'. There wont be more than 1 Bean #25
			*/
	public AccountService accountService() {
		AccountServiceImpl bean = new AccountServiceImpl();
		bean.setAccountDao(accountDao());
		return bean;
	}
	
	/*
	 * Factory method 2
	 */
	@Bean
	public AccountDao accountDao() {
		AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
		//depedencies of accountDao bean will be injected here...
		return bean;
	}
}

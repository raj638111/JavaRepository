package z1_CODE_EXAMPLES.a_SECOND_CHAPTER.c_JAVA_BASED_AUTOWIRING;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Ch2BeanConfiguration {

	@Bean
	public AccountService accountService() {
		AccountServiceImpl bean = new AccountServiceImpl();
		return bean;
	}
	
	@Bean
	@Qualifier
	public AccountDao accountDao() {
		AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
		//depedencies of accountDao bean will be injected here...
		return bean;
	}
	
	@Bean
	public AccountDao accountDaoJdbc() {
		AccountDaoJdbcImpl bean = new AccountDaoJdbcImpl();
		return bean;
	}
}
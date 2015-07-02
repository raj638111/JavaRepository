package z1_CODE_EXAMPLES.a_SECOND_CHAPTER.d_CONFIGURING_ENVIRONMENT_57;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class Ch2Configuration {
	
	@Bean
	@Profile("dev")
	public Foo devFoo(@Value("${name}") String name) {
		Foo foo = new Foo();
		foo.setName("dev : " + name);
		return foo;
	}
	
	@Bean
	@Profile("prod")
	public Foo prodFoo(@Value("${name}") String name) {
		Foo foo = new Foo();
		foo.setName("prod " + name);
		return foo;
	}
	
	@Bean
	/*
		#	What is the significance of the method being static here #58
			+	Believe we need the place holder resolution to kick-in even before
			+	'Ch2Configuration' bean container is created
			
		#	Used for placeholder(${name}) resolution mechanisme #58
	 * 
	 */
	public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}

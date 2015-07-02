package z1_CODE_EXAMPLES.a_SECOND_CHAPTER.d_CONFIGURING_ENVIRONMENT_57;

import java.util.Collections;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(Ch2Configuration.class);
		
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		
		environment.setActiveProfiles("dev");
		
		// For adding properties(which can be later used to replace place holders) #58, #59
		MutablePropertySources propertySources = environment.getPropertySources();
		
		propertySources.addLast(new MapPropertySource("mapSource", Collections.singletonMap("name", (Object)"my modified foo")));
		applicationContext.refresh();
		
		Foo foo = applicationContext.getBean(Foo.class);
		System.out.println(foo.getName());
	}

}

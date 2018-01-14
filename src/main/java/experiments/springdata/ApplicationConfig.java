package experiments.springdata;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"experiments.springdata"})
@EnableJpaRepositories
@EnableTransactionManagement
public class ApplicationConfig {

}

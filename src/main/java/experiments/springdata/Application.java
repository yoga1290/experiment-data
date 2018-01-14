package experiments.springdata;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import experiments.springdata.jdbc.*;

public class Application {

    public static void main(String arg[]) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserRepository userRepository = (UserRepository) ctx.getBean("UserRepository");//UserRepository.class.getSimpleName());
    }
}

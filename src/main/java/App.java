import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"repository", "service", "entity", "controller", "dto"})
@EnableJpaRepositories(basePackages = "repository")
@EnableAutoConfiguration
@EntityScan(basePackages = {"entity"})
public class App 
{
    public static void main( String[] args )

    {
        SpringApplication.run(App.class,args);
    }
}

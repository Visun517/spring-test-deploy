package lk.ijse.gdse71.confi;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "lk.ijse.gdse71")
@PropertySource("classpath:application.properties")
public class AppConfig {
}

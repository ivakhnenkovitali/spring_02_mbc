package by.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@EnableWebMvc   // СПРИНГ nbs приложение анотация позволяет читать все анатацииии.....
@ComponentScan(basePackages = "by.IT.controllers")
public class AppConfig {
    @Bean
    public ViewResolver viewResolver(){
        var resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}

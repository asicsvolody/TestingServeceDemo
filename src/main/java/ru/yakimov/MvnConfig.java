/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.yakimov.util.DateFormatter;

@Configuration
public class MvnConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("login").setViewName("login");

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(dateFormatter());
    }

    @Bean
    public DateFormatter dateFormatter(){
        return new DateFormatter();
    }


}

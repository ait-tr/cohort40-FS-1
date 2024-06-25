package org.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean("parrot-kesha")
    public Parrot getParrot() {
        return new Parrot();
    }

    @Bean("dog")
    @Scope("prototype")
    public Dog getDog() {return new Dog();}


    @Bean
    public Cat getCat(Parrot parrot){
        Cat cat = new Cat();
        cat.setName(parrot.getName() + " - killer");
        return cat;
    }
 }

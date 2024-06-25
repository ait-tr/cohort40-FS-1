package org.annotationConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnimalService {

    private final Dog dog;

    @Autowired
    public AnimalService(Dog dog) {
        this.dog = dog;
    }

   public void printDogData(){
       System.out.println("Dog's name: " + dog.getName());
   }

}

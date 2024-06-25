package org.springdemoxmlconfig.v2;

public class HelloWorld {

    public void initMethod() throws Exception {
        System.out.println("Я инит-метод " + this.getClass().getSimpleName());
    }

    public void destroyMethod() throws Exception{
        System.out.println("Я destroy-метод " + this.getClass().getSimpleName());
    }

    public void workingMethod(){
        System.out.println("Working ...");
    }
}

package org.javaConfig;

public class Dog {
    private String name = "Barbos";

    public Dog() {
        System.out.println("Dog constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}

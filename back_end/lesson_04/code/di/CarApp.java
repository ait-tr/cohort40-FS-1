package code.di;

import java.util.HashMap;
import java.util.Map;

public class CarApp {
    public static void main(String[] args) {
        /*
        DI / IoC

        POJO - Plain Old Java Object

         */

        EngineGeneral ourEngine = new EngineElectro();
        Body body = new Body();
        Transmission transmission = new Transmission();

        //=====================================

        Map<String,Object> table = new HashMap<>();

        table.put("ourEngine", new EngineElectro());
        table.put("body", new Body());
        table.put("transmission", new Transmission());


        // -----------------------------------------------

        Car myCar = new Car(body,ourEngine,transmission);
        myCar.getEngine().start();



    }
}

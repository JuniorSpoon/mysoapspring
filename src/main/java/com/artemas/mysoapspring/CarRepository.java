package com.artemas.mysoapspring;



import com.artemas.mysoapspring.gen.Car;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Component
public class CarRepository {

    private static final Map<String, Car> cars = new HashMap<>();

    @PostConstruct
    public void initData() {
        Car vesta = new Car();
        vesta.setColor("blue");
        vesta.setBrand("LADA");
        vesta.setModel("Vesta");
        vesta.setYear(2022);
        vesta.setHorsePower(105);

        cars.put(vesta.getModel(), vesta);

        Car focus = new Car();
        focus.setColor("white");
        focus.setBrand("Ford");
        focus.setModel("Focus III");
        focus.setYear(2021);
        focus.setHorsePower(105);

        cars.put(focus.getModel(), focus);

        Car toyota = new Car();
        toyota.setColor("silver");
        toyota.setBrand("Toyota");
        toyota.setModel("Camry");
        toyota.setYear(2017);
        toyota.setHorsePower(150);

        cars.put(toyota.getModel(), toyota);
    }

    public Car findCar(String name) {
        Assert.notNull(name, "The car's model must not be null");
        return cars.get(name);
    }
}
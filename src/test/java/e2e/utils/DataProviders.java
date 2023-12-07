package e2e.utils;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class DataProviders {

    Faker faker = new Faker();

    //[{"Tetiana","Skvarnyk","Student"}, {"Tetiana","Skvarnyk","Student"}] massiw objectow
    @DataProvider
    public Iterator<Object[]> newContact(){
        List<Object[]> list = new ArrayList<>(); //написание массива в листе
        list.add(new Object[]{faker.name().firstName(),faker.name().lastName(),faker.lorem().paragraph()});
        list.add(new Object[]{faker.internet().uuid(),faker.internet().uuid(),faker.lorem().sentence()});
        list.add(new Object[]{faker.internet().uuid(),"Skvarnyk","Student"});
        return list.listIterator(); // метод перебирает с поочередно с первого по последний
    }
}

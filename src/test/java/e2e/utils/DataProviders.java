package e2e.utils;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    Faker faker = new Faker();
    @DataProvider
    public Iterator<Object[]> newContact(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{faker.internet().uuid(),faker.name().lastName(),faker.lorem().paragraph()});
//        list.add(new Object[]{faker.internet().uuid(),faker.internet().uuid(),faker.lorem().sentence()});
//        list.add(new Object[]{faker.internet().uuid(),"Mikhailov","I am a teacher"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> invalidLoginData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{faker.name().firstName(),faker.name().lastName()});
        list.add(new Object[]{faker.internet().uuid(),faker.internet().uuid()});
        list.add(new Object[]{faker.internet().uuid(),"Mikhailov"});
        return list.iterator();
    }
}

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
        list.add(new Object[]{faker.name().firstName(),faker.name().lastName(),faker.lorem().paragraph()});
        list.add(new Object[]{faker.internet().uuid(),faker.internet().uuid(),faker.lorem().sentence()});
        list.add(new Object[]{faker.internet().uuid(),"Alex","Hello"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> invalidDataForLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Summer","newTest@gmail.com","with_invalid_email"});
        list.add(new Object[]{"newTest@gmail.com",faker.internet().uuid(),"with_invalid_password"});
        list.add(new Object[]{"234234","123123","with_invalid_data"});
        return list.iterator();
    }

}

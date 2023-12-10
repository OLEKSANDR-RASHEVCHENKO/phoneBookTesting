package e2e.utils;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class DataProviders {
    Faker faker = new Faker();
    @DataProvider
    public Iterator<Object[]> newContact(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{faker.name().firstName(),faker.name().lastName(),faker.lorem().paragraph()});
        list.add(new Object[]{faker.internet().uuid(),faker.internet().uuid(),faker.lorem().sentence()});
        list.add(new Object[]{faker.internet().uuid(),"Pakhamovich", "I'am a idiot"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> invalidLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"newtest@gmail.com","newtest@gmail.com"});
        list.add(new Object[]{"newtest1@gmail.com","newtest@gmail.com"});
        list.add(new Object[]{"newtest@gmail.com","newtest22@gmail.com"});
        list.add(new Object[]{"new1test@gmail.com","newtest23@gmail.com"});
        return list.iterator();
    }


}
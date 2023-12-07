package e2e.utils;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class DataProviders {
    Faker faker = new Faker();
    @DataProvider
    public Iterator<Object[]> newContact() {
        List<Object[]> list = new ArrayList<>();
    list.add( new Object[]{faker.name(), faker.lastName(), faker.lorem().paragraph()});
    list.add(new Object[]{faker.internet(), faker.uuid(), faker.lorem().sentence()});
        list.add(new Object[]{"Nat", "Yan", "New York"});
    return  list.iterator();



    }
}

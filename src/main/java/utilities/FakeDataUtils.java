package utilities;

import com.github.javafaker.Faker;

public class FakeDataUtils {
    private static final Faker faker = new Faker();

    protected static String getId() {
        return faker.number().digits(7);
    }

    protected static String getName() {
        return faker.name().firstName() + " " + faker.name().lastName();
    }

}

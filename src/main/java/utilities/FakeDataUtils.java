package utilities;


import net.datafaker.Faker;

public class FakeDataUtils {
    private static final Faker faker = new Faker();

    public String getId() {
        return faker.number().digits(7);
    }

    public String getName() {
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public String getCountry() {
        return faker.country().toString();
    }

}

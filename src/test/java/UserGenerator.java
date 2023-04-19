import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static User getRandom() {
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);
        String email = generatedString + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(10);
        return new User(name, email, password);
    }
    public static User getRandomWithPasswordLessThanFiveSymbols() {
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        String email = generatedString + "@yandex.ru";
        String name = RandomStringUtils.randomAlphabetic(10);
        String password = RandomStringUtils.randomAlphabetic(4);
        return new User(email, name, password);
    }
}

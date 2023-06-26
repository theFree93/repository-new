package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class StringsUtils {
    private final static String EMAIL = RandomStringUtils.randomAlphanumeric(4);
    private final static int LENGTH_OF_RANDOM_PASSWORD = 3;
    private final static int LENGTH_OF_RANDOM_DOMAIN = 3;

    public static String getRandomPassword(String capitalLitter, int numeral, String cyrillicCharacter) {
        return capitalLitter.toUpperCase().concat(RandomStringUtils.randomAlphanumeric(LENGTH_OF_RANDOM_PASSWORD)).concat(String.valueOf(numeral)).concat(EMAIL).concat(cyrillicCharacter);
    }

    public static String getRandomEmail() {
        return EMAIL;
    }

    public static String randomDomain() {
        return RandomStringUtils.randomAlphanumeric(LENGTH_OF_RANDOM_DOMAIN);
    }
}

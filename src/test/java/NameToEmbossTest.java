import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class NameToEmbossTest {

    public final String name;
    public final boolean expected;

    public NameToEmbossTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12}, {13}")
    public static Object[][] getNameData() {
        return new Object[][]{
                {"Xxxxxx Xxxxxxxxx", true}, // длина name в границах допустимого диапазона 3-19
                {"Xxxxxxx Xxxxxxxxxxx", true}, // длина name равна верхнему граничному значению 19
                {"X X", true}, // длина name равна нижнему граничному значению 3
                {"Xxxxxx Xxxxxxxxxxx", true}, // длина name на 1 символ меньше максимально допустимого значения
                {"Xx X", true}, // длина name на 1 символ больше минимально допустимого значения
                {"Xxxxxxxx Xxxxxxxxxxx", false}, // длина name на 1 символ больше максимально допустимого значения
                {"Xx", false}, // длина name на 1 символ меньше минимально допустимого значения
                {" Xxx Xxxxx", false}, // name содержит пробел в начале строки
                {"Xxx Xxxxx ", false}, // name содержит пробел в конце строки
                {"Xxx  Xxxxx", false}, // name содержит 2 пробела подряд
                {"XxxXxxxx", false}, // name не содержит пробелов
                {"", false},
                {null, false}
        };
    }

    @Test
    public void shouldBeEmbossed() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        Assert.assertEquals(expected, actual);
    }
}


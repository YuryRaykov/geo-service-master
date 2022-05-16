import org.hamcrest.junit.ExpectedException;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoServiceTest {
    GeoServiceImpl sut;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeEach
    public void init() {
        System.out.println("tests started");
        sut = new GeoServiceImpl();
    }

    @BeforeAll
    public static void started() {
        System.out.println("tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("tests completed");
    }

    @Test
    public void testByIp(){
        String ip = "172.123.12.19";
        Location result = sut.byIp(ip);
        Assertions.assertInstanceOf(Location.class, result);
    }

    @Test
    public void testByIpRussian(){
        String ip = "172.123.12.19";
        Country expexted = Country.USA;
        Country result = sut.byIp(ip).getCountry();
        Assertions.assertEquals(expexted, result);
    }

    @Test
    public void testByIpUSA(){
        String ip = "96.44.183.149";
        Country expexted = Country.USA;
        Country result = sut.byIp(ip).getCountry();
        Assertions.assertEquals(expexted, result);
    }

    @Test
    public void testByCoordinates(){
//        thrown.expect(RuntimeException.class);
//        thrown.expectMessage("Not implemented");
//        Если я правильно понял, то две сторки выше и строка ниже проверяют одно и тоже???
        Assertions.assertThrows(RuntimeException.class, () -> {sut.byCoordinates(13.00, 14.00);}, "NOK");

    }
}




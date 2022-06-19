package ru.netology;

import org.junit.jupiter.api.*;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest extends LocalizationServiceImpl {

    LocalizationServiceImpl value;

    @BeforeEach
    public void init() {
        System.out.println("tests started");
        value = new LocalizationServiceImpl();
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
    public void testLocaleRussia(){
        String message = "Добро пожаловать";
        String expected = value.locale(Country.RUSSIA);
        Assertions.assertEquals(expected, message);
    }

    @Test
    public void testLocaleUsa(){
        String message = "Welcome";
        String expected = value.locale(Country.USA);
        Assertions.assertEquals(expected, message);
    }

}

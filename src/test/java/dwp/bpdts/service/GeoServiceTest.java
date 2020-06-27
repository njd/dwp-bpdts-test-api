package dwp.bpdts.service;

import dwp.bpdts.geo.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GeoServiceTest {

    @Autowired
    GeoService geoService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void milesLondonToElstree() {
        Position london = new Position(GeoService.LONDON_LATITUDE, GeoService.LONDON_LONGITUDE);
        Position elstree = new Position(51.6441, -0.2982);

        Double expectedDistance = 12.2;

        assertEquals(expectedDistance, geoService.milesBetween(london, elstree), 0.1);
    }

    @Test
    void milesLondonToLeeds() {
        Position london = new Position(GeoService.LONDON_LATITUDE, GeoService.LONDON_LONGITUDE);
        Position leeds = new Position(53.7905,-1.5430);

        Double expectedDistance = 168.9;

        assertEquals(expectedDistance, geoService.milesBetween(london, leeds), 0.1);
    }
    @Test
    void milesToKm() {
        assertEquals(1.60934, GeoService.milesToKm(1.0), 0.0001);
    }

    @Test
    void kmToMiles() {
        assertEquals(1.0, GeoService.kmToMiles(1.60934), 0.0001);
    }
}
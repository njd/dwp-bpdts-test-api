package dwp.bpdts.service;

import lombok.extern.slf4j.Slf4j;

import dwp.bpdts.geo.Position;
import net.sf.geographiclib.Geodesic;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GeoService {

    Geodesic geo;
    // 51.504831314, -0.123499506
    public static final double MILES_TO_KM = 1.60934;

    // Actually it's Trafalgar Square
    protected static final double LONDON_LATITUDE = 51.504831314;
    protected static double LONDON_LONGITUDE = -0.123499506;

    public static final Position LONDON = new Position(LONDON_LATITUDE, LONDON_LONGITUDE);

    public GeoService() {
        geo = new Geodesic(Geodesic.WGS84.EquatorialRadius(), Geodesic.WGS84.Flattening());
    }

    /**
     * Calculate distance between two positions
     *
     * @param from position
     * @param to   position
     * @return distance in miles
     */
    public Double milesBetween(Position from, Position to) {

        double distanceInMetres = geo.Inverse(from.latitude, from.longitude, to.latitude, to.longitude).s12;
        double distanceInKm = distanceInMetres / 1000.0;

        double distanceInMiles = kmToMiles(distanceInKm);

        log.debug("%s to %s is %f miles", from, to, distanceInMiles);
        return distanceInMiles;
    }

    protected static double milesToKm(double miles) {
        return miles * MILES_TO_KM;
    }

    protected static double kmToMiles(double km) {
        return km / MILES_TO_KM;
    }
}


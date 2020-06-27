package dwp.bpdts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    public static final double LONDON_LATITUDE = 51.5074;
    public static final double LONDON_LONGITUDE = 0.1278;

    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String email;

    @JsonProperty("ip_address")
    private String ipAddress;

    @JsonIgnore
    private InetAddress inetAddress;

    private Double latitude;
    private Double longitude;

    public User() {
    }

    public User(Long id, String firstName, String lastName, double latitude, double longitude) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        try {
            this.inetAddress = InetAddress.getByName(ipAddress);
        } catch (UnknownHostException e) {
            log.warn("Failed to set inet address from IP address {}.", ipAddress);
        }
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public void setInetAddress(InetAddress inetAddress) {
        this.inetAddress = inetAddress;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {

        return "User{" +
            "id=" + id +
            ", firstName=" + firstName +
            ", lastName=" + lastName +
            ", email=" + email +
            ", ipAddress=" + ipAddress +
            ", inetAddress=" + inetAddress +
            ", lat/lon=(" + latitude + "," + longitude + ")" +
            '}';
    }

}

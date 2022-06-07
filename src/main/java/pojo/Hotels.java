package pojo;

/* Below class is a sub pojo created for Autocomplete API Response */

public class Hotels {
    int hotelId;
    String name;
    String city;
    String country;
    String countryCode;
    String thumbnail_url;
    String displayType;
    double latitude;
    double longitude;
    boolean isActive;

    public Hotels() {

    }

    public Hotels(int hotelId, String name, String city, String country, String countryCode, String thumbnail_url, String displayType, float latitude, float longitude, boolean isActive) {
        this.hotelId = hotelId;
        this.name = name;
        this.city = city;
        this.country = country;
        this.countryCode = countryCode;
        this.thumbnail_url = thumbnail_url;
        this.displayType = displayType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isActive = isActive;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public String getDisplayType() {
        return displayType;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean getisActive() {
        return isActive;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }
}

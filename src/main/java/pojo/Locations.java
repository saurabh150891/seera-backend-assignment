package pojo;

/* Below class is a sub pojo created for Autocomplete API Response */

public class Locations {
    String name;
    String city;
    String country;
    String displayType;
    String placeId;
    String source;
    GoogleType googleType;

    public Locations(){

    }

    public Locations(String name, String city, String country, String displayType, String placeId, String source, GoogleType googleType) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.displayType = displayType;
        this.placeId = placeId;
        this.source = source;
        this.googleType = googleType;
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

    public String getDisplayType() {
        return displayType;
    }

    public String getPlaceId() {
        return placeId;
    }

    public String getSource() {
        return source;
    }

    public GoogleType getGoogleType() {
        return googleType;
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

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setGoogleType(GoogleType googleType) {
        this.googleType = googleType;
    }
}

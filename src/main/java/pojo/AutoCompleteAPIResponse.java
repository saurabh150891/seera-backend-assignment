package pojo;

import java.util.List;

/* Below class is a pojo created for Autocomplete API Response */

public class AutoCompleteAPIResponse {

    List<Locations> locations;
    List<Hotels> hotels;

    public AutoCompleteAPIResponse() {

    }

    public AutoCompleteAPIResponse(List<Locations> locations, List<Hotels> hotels) {
        this.locations = locations;
        this.hotels = hotels;
    }

    public List<Locations> getLocations() {
        return locations;
    }

    public List<Hotels> getHotels() {
        return hotels;
    }

    public void setLocations(List<Locations> locations) {
        this.locations = locations;
    }

    public void setHotels(List<Hotels> hotels) {
        this.hotels = hotels;
    }
}

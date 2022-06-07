package StepDefinitions;

import io.cucumber.java.en.And;
import org.junit.Assert;
import pojo.AutoCompleteAPIResponse;

public class AutoCompleteSteps {
    AutoCompleteAPIResponse autoCompleteAPIResponse;

    @And("verify autoCompleteResponse for hotels")
    public void validateResponseForHotels() {

        autoCompleteAPIResponse = BaseStepDefinitions.response.as(AutoCompleteAPIResponse.class);
        for (int i = 0; i < autoCompleteAPIResponse.getLocations().size(); i++) {
            Assert.assertFalse(autoCompleteAPIResponse.getHotels().get(i).getHotelId() < 1);
            Assert.assertFalse(autoCompleteAPIResponse.getHotels().get(i).getName().isEmpty());
            Assert.assertFalse(autoCompleteAPIResponse.getHotels().get(i).getCity().isEmpty());
            Assert.assertFalse(autoCompleteAPIResponse.getHotels().get(i).getCountry().isEmpty());
            Assert.assertFalse(autoCompleteAPIResponse.getHotels().get(i).getCountryCode().isEmpty());
            Assert.assertFalse(autoCompleteAPIResponse.getHotels().get(i).getThumbnail_url().isEmpty());
            Assert.assertFalse(autoCompleteAPIResponse.getHotels().get(i).getDisplayType().isEmpty());
            Assert.assertFalse(autoCompleteAPIResponse.getHotels().get(i).getLatitude() < 1);
            Assert.assertFalse(autoCompleteAPIResponse.getHotels().get(i).getLongitude() < 1);
        }
    }

    @And("verify autoCompleteResponse for locations")
    public void validateResponseForLocations() {
        for (int i = 0; i < autoCompleteAPIResponse.getLocations().size(); i++) {
            Assert.assertFalse(autoCompleteAPIResponse.getLocations().get(i).getCity().isEmpty());
            Assert.assertFalse(autoCompleteAPIResponse.getLocations().get(i).getCountry().isEmpty());
            Assert.assertFalse(autoCompleteAPIResponse.getLocations().get(i).getDisplayType().isEmpty());
            Assert.assertFalse(autoCompleteAPIResponse.getLocations().get(i).getPlaceId().isEmpty());
            Assert.assertFalse(autoCompleteAPIResponse.getLocations().get(i).getSource().isEmpty());
            Assert.assertFalse(autoCompleteAPIResponse.getLocations().get(i).getName().isEmpty());
        }
    }
}

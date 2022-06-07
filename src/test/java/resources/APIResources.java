package resources;

/* This enum class is used to store API resources for different APIs */

public enum APIResources {

    asyncAPI("/api/enigma/search/async"),
    autocompleteAPI("/api/enigma/autocomplete");
    private String resource;

    APIResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}

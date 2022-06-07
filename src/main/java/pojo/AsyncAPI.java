package pojo;

import java.util.List;

/* Below class is a sub pojo created for Async API request creation */

public class AsyncAPI {

    public String checkIn;
    public String checkOut;
    public List<RoomsInfo> roomsInfo;
    public String placeId;

    public AsyncAPI() {
    }

    public AsyncAPI(String checkIn, String checkOut, List<RoomsInfo> roomsInfo, String placeId) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomsInfo = roomsInfo;
        this.placeId = placeId;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public List<RoomsInfo> getRoomsInfo() {
        return roomsInfo;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public void setRoomsInfo(List<RoomsInfo> roomsInfo) {
        this.roomsInfo = roomsInfo;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

}

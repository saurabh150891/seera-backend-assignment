package resources;

import pojo.AsyncAPI;
import pojo.RoomsInfo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class TestDataBuild {

    Utils utils = new Utils();

    /* Below method will build the requests body for Async API using POJO */
    public AsyncAPI asyncApiPayload(String checkInDate, String checkOutDate, int numberOfAdults, int numberOfKids, String placeId) throws ParseException {

        AsyncAPI asyncAPI = new AsyncAPI();
        List<RoomsInfo> roomsInfo = new ArrayList<RoomsInfo>();
        RoomsInfo subRoomInfo = new RoomsInfo();
        subRoomInfo.setAdultsCount(numberOfAdults);
        List<Integer> kidsAge = new ArrayList<Integer>();
        for (int i = 0; i < numberOfKids; i++) {
            kidsAge.add(i + 1);
        }
        subRoomInfo.setKidsAges(kidsAge);
        roomsInfo.add(subRoomInfo);
        asyncAPI.setCheckIn(utils.getCheckInDate(checkInDate));
        asyncAPI.setCheckOut(utils.getCheckOutDate(checkOutDate));
        asyncAPI.setRoomsInfo(roomsInfo);
        asyncAPI.setPlaceId(placeId);
        return asyncAPI;
    }

}

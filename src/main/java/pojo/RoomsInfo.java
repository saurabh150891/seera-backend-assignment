package pojo;

import java.util.List;

/* Below class is a sub pojo created for AsyncAPI class */

public class RoomsInfo {
    public int adultsCount;
    public List<Integer> kidsAges;

    public RoomsInfo() {

    }

    public RoomsInfo(int adultsCount, List<Integer> kidsAges) {
        this.adultsCount = adultsCount;
        this.kidsAges = kidsAges;
    }

    public int getAdultsCount() {
        return adultsCount;
    }

    public List<Integer> getKidsAges() {
        return kidsAges;
    }

    public void setAdultsCount(int adultsCount) {
        this.adultsCount = adultsCount;
    }

    public void setKidsAges(List<Integer> kidsAges) {
        this.kidsAges = kidsAges;
    }
}

package pojo;

/* Below class is a sub pojo created for Locations class */

public class GoogleType {
    String typeNameEn;
    String typeNameAr;

    public  GoogleType(){

    }

    public GoogleType(String typeNameEn, String typeNameAr) {
        this.typeNameEn = typeNameEn;
        this.typeNameAr = typeNameAr;
    }

    public String getTypeNameEn() {
        return typeNameEn;
    }

    public String getTypeNameAr() {
        return typeNameAr;
    }

    public void setTypeNameEn(String typeNameEn) {
        this.typeNameEn = typeNameEn;
    }

    public void setTypeNameAr(String typeNameAr) {
        this.typeNameAr = typeNameAr;
    }
}

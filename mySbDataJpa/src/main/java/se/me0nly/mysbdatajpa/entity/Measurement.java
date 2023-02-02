package se.me0nly.mysbdatajpa.entity;
public enum Measurement {
    LITRE("l"), DECILITRE("dl"), CENTILITRE("cl"), KILOGRAM("kg"), GRAM("gr"), MILLIGRAM("mg"), TEASPOON("teaspoon"), TABLESPOON("tablespoon");

    private String type;

    Measurement(String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
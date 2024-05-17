package Enum;

public enum CallCentreUserDetailsEnum {

    First_Name("First Name"),

    Last_Name("Last Name"),

    Phone("Phone #"),

    Email("Email"),

    Joined_Date("Joined Date"),

    Requested_On("Requested On"),

    Language("Language"),

    Emirate_ID("Emirate ID");

    public  String value;

    CallCentreUserDetailsEnum(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }





    }

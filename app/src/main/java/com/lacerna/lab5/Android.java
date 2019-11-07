package com.lacerna.lab5;

public class Android {
    int logo;
    String name,version,date,APILevel,shortMessage;

    public Android(int logo, String name, String version, String APILevel, String date, String shortMessage) {
        this.logo = logo;
        this.name = name;
        this.version = version;
        this.date = date;
        this.APILevel=APILevel;
        this.shortMessage=shortMessage;
    }

    public int getLogo() {
        return logo;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getDate() {
        return date;
    }

    public String getAPILevel(){
        return APILevel;
    }

    public String getShortMessage(){
        return shortMessage;
    }
}

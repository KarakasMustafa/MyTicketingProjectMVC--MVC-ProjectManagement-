package com.mustafa.enums;

public enum Status {
    COMPLETED("Completed"),IN_PROGRESS("In Progress"),OPEN("Open"),UAT_TEST("UAT Testing");

    private final String value;

    private Status(String value){
        this.value = value;
    }

    public String getStatus(){
        return value;
    }
}

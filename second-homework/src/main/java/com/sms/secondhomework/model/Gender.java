package com.sms.secondhomework.model;

public enum Gender {

    MALE('M'),
    FEMALE('F');

    private char gender;

    Gender(char gender) {
        this.gender= gender;
    }

    public char getGender() {
        return gender;
    }
}

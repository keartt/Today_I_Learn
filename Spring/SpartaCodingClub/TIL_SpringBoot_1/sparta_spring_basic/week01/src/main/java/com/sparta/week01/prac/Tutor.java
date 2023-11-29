package com.sparta.week01.prac;

public class Tutor {
    private String name;
    private int bio;

    public Tutor() {
    }

    public Tutor(String name, int bio) {
        this.name = name;
        this.bio = bio;
    }

    public String getName() {
        return this.name;
    }

    public int getBio() {
        return this.bio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(int bio) {
        this.bio = bio;
    }

}

package com.practice.java.functionalprogramming;

import java.util.List;

public class Instructor {

    String name;
    int experience;
    String title;
    String gender;
    boolean onlineCourse;
    List<String> courses;

    public Instructor(String name, int experience, String title, String gender, boolean onlineCourse, List<String> courses) {
        this.name = name;
        this.experience = experience;
        this.title = title;
        this.gender = gender;
        this.onlineCourse = onlineCourse;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isOnlineCourse() {
        return onlineCourse;
    }

    public void setOnlineCourse(boolean onlineCourse) {
        this.onlineCourse = onlineCourse;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                ", onlineCourse=" + onlineCourse +
                ", courses=" + courses +
                '}';
    }
}

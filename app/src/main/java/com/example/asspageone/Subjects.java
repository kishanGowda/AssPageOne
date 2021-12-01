package com.example.asspageone;

public class Subjects {
    private int subjectImage;
    private String assignment;
    private String subjectName;

    public int getSubjectImage() {
        return subjectImage;
    }

    public String getAssignment() {
        return assignment;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Subjects(int subjectImage, String assignment, String subjectName) {
        this.subjectImage = subjectImage;
        this.assignment = assignment;
        this.subjectName = subjectName;
    }


}

package com.jiro.MarksApplication.utils;

public class GradeCalculator {
    public static double calculateGPA(double marks) {
        if (marks >= 90) return 4.0;
        if (marks >= 80) return 3.6;
        if (marks >= 70) return 3.2;
        if (marks >= 60) return 2.8;
        if (marks >= 50) return 2.4;
        if (marks >= 40) return 2.0;
        if (marks >= 35) return 2.0;
        return 0.0; // Not Graded (NG)
    }

    public static String calculateGrade(double marks) {
        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B+";
        if (marks >= 60) return "B";
        if (marks >= 50) return "C+";
        if (marks >= 40) return "C";
        if (marks >= 35) return "D";
        return "NG";
    }
}


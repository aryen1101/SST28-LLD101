package rules.impl;

import entities.StudentProfile;
import rules.EligibilityRule;

public class AttendanceRule implements EligibilityRule {

    private final int minAttendance;

    public AttendanceRule(int minAttendance) {
        this.minAttendance = minAttendance;
    }

    @Override
    public String evaluate(StudentProfile s) {
        return s.attendancePct < minAttendance ? "attendance below " + minAttendance : "";
    }
}

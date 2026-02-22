package printer.impl;

import entities.StudentRecord;

import java.util.List;

public class StudentOnboardingPrinter implements OnboardingPrinter {
    @Override
    public void printInput(String raw) {
        System.out.println("INPUT: " + raw);
    }

    @Override
    public void printSuccess(StudentRecord rec, int totalCount) {
        System.out.println("OK: created student " + rec.id);
        System.out.println("Saved. Total students: " + totalCount);
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }

    @Override
    public void printErrors(List<String> errors) {
        System.out.println("ERROR: cannot register");
        for (String e : errors) System.out.println("- " + e);
    }
}

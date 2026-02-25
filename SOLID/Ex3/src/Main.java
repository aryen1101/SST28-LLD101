import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);

        RuleInput config = new RuleInput();

        List<EligibilityRule> placementRules = Arrays.asList(
            new DisciplinaryRule(),
            new CGRRule(config.minCgr),
            new AttendanceRule(config.minAttendance),
            new CreditsRule(config.minCredits)
        );
        FakeEligibilityStore store = new FakeEligibilityStore();
        EligibilityEngine engine = new EligibilityEngine(store, placementRules);
        engine.runAndPrint(s);
    }
}

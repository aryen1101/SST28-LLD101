package helper;

import config.RuleInput;
import entities.StudentProfile;
import printer.ReportPrinter;
import rules.EligibilityRule;
import rules.impl.AttendanceRule;
import rules.impl.CgrRule;
import rules.impl.CreditsRule;
import rules.impl.DisciplinaryRule;
import store.FakeEligibilityStore;

import java.util.ArrayList;
import java.util.List;

public class EligibilityEngine {
    private final FakeEligibilityStore store;
    private final List<EligibilityRule> rules;

    public EligibilityEngine(FakeEligibilityStore store) {
        RuleInput config = new RuleInput();
        this.store = store;
        this.rules = List.of(
                new DisciplinaryRule(),
                new CgrRule(config.minCgr),
                new AttendanceRule(config.minAttendance),
                new CreditsRule(config.minCredits)
        );
    }

    public EligibilityEngine(FakeEligibilityStore store, List<EligibilityRule> rules) {
        this.store = store;
        this.rules = rules;
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s);
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();

        for (EligibilityRule rule : rules) {
            String reason = rule.evaluate(s);
            if (!reason.isEmpty()) {
                reasons.add(reason);
                break;
            }
        }

        String status = reasons.isEmpty() ? "ELIGIBLE" : "NOT_ELIGIBLE";
        return new EligibilityEngineResult(status, reasons);
    }
}


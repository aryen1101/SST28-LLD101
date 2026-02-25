
import java.util.*;

public class OnboardingService {

    private final StudentRepository db;
    private final InputParser parser;
    private final StudentValidator validator;
    private final OnBoardingPrinter printer;

    public OnboardingService(StudentRepository db) {
        this(db, new InputParser(), new StudentValidator(), new OnBoardingPrinter());
    }

    public OnboardingService(StudentRepository db, InputParser parser, StudentValidator validator , OnBoardingPrinter printer) {
        this.db = db;
        this.parser = parser;
        this.validator = validator;
        this.printer = printer;

    }

    

    public void registerFromRawInput(String raw) {

        printer.printInput(raw);

        StudentData data = parser.parse(raw);

        List<String> errors = validator.validate(data);

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, data.name, data.email, data.phone, data.program);

        db.save(rec);

        printer.printSuccess(rec, db.count());

    }
}

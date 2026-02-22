package entities;

public class Notification {
    public final String subject;
    public final String body;
    public final String email;
    public final String phone;

    public Notification(String subject, String body, String email, String phone) {
        this.subject = subject != null ? subject : "";
        this.body = body != null ? body : "";
        this.email = email != null ? email : "";
        this.phone = phone != null ? phone : "";
    }
}

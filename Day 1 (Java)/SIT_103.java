//Q: Employee management (Diamond structure)
//this is the classic structure  A-->B, C-->D structure

//Q = create a real time employee notification system
//* A = Employee, B = EmailNotification, C = SMSNotification, D = Manager
//Both B & C inherit from A

interface Employee {
    void setEmployeeName(String name);

    String getEmployeeName();
}

interface EmailNotification extends Employee {
    default void sendNotification(String message) {
        System.out.println("Notification sent via email");
    }
}

interface SMSNotification extends Employee {
    default void sendNotification(String message) {
        System.out.println("Notification sent via SMS");
    }
}

class Manager implements EmailNotification, SMSNotification {
    private String employeeName;

    @Override
    public void setEmployeeName(String name) {
        this.employeeName = name;
    }

    @Override
    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public void sendNotification(String message) {
        SMSNotification.super.sendNotification(message);
        EmailNotification.super.sendNotification(message);
    }
}

public class SIT_103 {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setEmployeeName("Rahul");
    }
}

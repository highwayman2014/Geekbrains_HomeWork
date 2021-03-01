package homeworkfive;

public class Worker {

    private String fio;
    private String position;
    private String email;
    private String phoneNumber;
    private float salary;

    public int getAge() {
        return age;
    }

    private int age;

    public Worker(){
        this.fio = "";
        this.position = "";
        this.email = "";
        this.phoneNumber = "";
        this.salary = 0.0f;
        this.age = 0;
    }

    public Worker(String fio, String position, String email, String phoneNumber, float salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printWorkerInformation(){
        System.out.println("Информация о работнике " + this.fio + ":");
        System.out.println("   Должность: " + this.position);
        System.out.println("   Возраст: " + this.age);
        System.out.println("   Зарплата: " + this.salary);
        System.out.println("   Email: " + this.email);
        System.out.println("   Номер телефона: " + this.phoneNumber);
    }
}

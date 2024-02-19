package mainPackage;

import java.util.Random;

class Employee {
    private String code;
    private String name;
    private String gender;
    private String title;
    private double salary;
    private static Random random = new Random();

    // Constructor
    public Employee(String name, String gender, String title, double salary) {
        this.name = name;
        this.gender = gender;
        this.title = title;
        this.salary = salary;
        this.code = generateUniqueId();
    }

    // Getter and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private String generateUniqueId() {
        StringBuilder idBuilder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            char randomChar = (char) (random.nextInt(26) + 'A');
            idBuilder.append(randomChar);
        }
        idBuilder.append('-');
        for (int i = 0; i < 4; i++) {
            idBuilder.append(random.nextInt(10));
        }
        return idBuilder.toString();
    }

    @Override
    public String toString() {
        return "Employee {" +
                "id ='" + code + '\'' +
                ", name ='" + name + '\'' +
                ", gender ='" + gender + '\'' +
                ", title ='" + title + '\'' +
                ", salary =" + salary +
                '}';
    }
}
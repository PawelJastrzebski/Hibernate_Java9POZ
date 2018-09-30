package jdbc.student;

public class Student {
    private int idStudent;
    private String name;
    private String surname;

    public Student(int idStudent, String name, String surname) {
        this.idStudent = idStudent;
        this.name = name;
        this.surname = surname;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

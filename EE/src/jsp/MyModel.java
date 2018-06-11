package jsp;

public class MyModel {
    public Student getStudent() {
        Student student = new Student();
        //...
        student.setName("Kolen");
        student.setAge(34);
        student.setTitle("This is student Kolen");
        return student;
    }


}

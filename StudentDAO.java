package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.util.List;

public interface StudentDAO {

    /* ****This method reads the student table in your database and returns the data as a List<Student>*/

    List<Student> getAllStudents();

    /* ****This method takes a Student’s email as a String and parses the student list for a Student with that email
and returns a Student Object. */

    Student getStudentByEmail(String sEmail);

    /* ****This method takes two parameters: the first one is the user email and the second one is the password from the
user input. Return whether or not student was found.*/

    boolean validateStudent(String sEmail,String sPassword);

    /* ****–After a successful student validation, this method takes a Student’s email and a Course ID. It checks in the join table (i.e.
Student_Course) generated by JPA to find if a Student with that Email is currently attending a Course with that ID.
-If the Student is not attending that Course, register the student to that course; otherwise not.*/

    void registerStudentToCourse(String sEmail, Integer cId);


    /* ****–This method takes a Student’s Email as a parameter and would find all the courses a student is registered.*/

    List<Course> getStudentCourses(String sEmail);




}


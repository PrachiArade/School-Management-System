package jpa.entitymodels;
import org.hibernate.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "email")
    private String sEmail; //Student’s current school email, unique student identifier

    @Basic
    @Column(name = "name")
    private String sName; //The full name of the student

    @Basic
    @Column(name = "password")
    private String sPass; //Student’s password in order to login


    @ManyToMany
    @JoinTable(
            name = "studentcourse",
            joinColumns = {@JoinColumn(name = "email",referencedColumnName = "email",unique = false)},
           inverseJoinColumns = {@JoinColumn(name = "cId",referencedColumnName = "id",unique = false)}
    )
    private List<Course> sCourses; //All the courses that a student’s registered for


    /* **** First constructor takes no parameters, and it initializes every members to an initial value.*/
    public Student() {
        this.sEmail="";
        this.sName="";
        this.sPass="";
        this.sCourses= new ArrayList<>();
    }

    /* ****Second constructor must initialize every private member with a parameter provided to the
constructor.*/

    public Student(String sEmail, String sName, String sPass,List sCourses) {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;
        this.sCourses= sCourses;
    }





    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPass() {
        return sPass;
    }

    public void setsPass(String sPass) {
        this.sPass = sPass;
    }

    public List<Course> getsCourses() {
        return sCourses;
    }

    public void setsCourses(List<Course> sCourses) {
        this.sCourses = sCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sEmail='" + sEmail + '\'' +
                ", sName='" + sName + '\'' +
                ", sPass='" + sPass + '\'' +
                ", sCourses=" + sCourses +
                '}';
    }
}

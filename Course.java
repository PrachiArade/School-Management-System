package jpa.entitymodels;


import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {

     @Id
     @Column(name = "id")
     private int cId; //Unique course Identifier


    @Basic
     @Column(name = "name")
     private String cName;  //Provides the name of the  course

     @Basic
     @Column(name = "instructor")
     private String cInstructorName; //Provides the name of the instructor


     /* **** First constructor takes no parameters, and it initializes every member to an initial value.*/
    public Course() {
        this.cId=0;
        this.cName="";
        this.cInstructorName="";
    }

    /* ****Second constructor must initialize every private member with a parameter provided to the
constructor.*/
    public Course(int cId, String cName, String cInstructorName) {
        this.cId = cId;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }



    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInstructorName() {
        return cInstructorName;
    }

    public void setcInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;

    }

    @Override
    public String toString() {
        return "Course{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cInstructorName='" + cInstructorName + '\'' +
                '}';
    }
}

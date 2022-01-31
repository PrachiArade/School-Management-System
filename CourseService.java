package jpa.service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

import javax.persistence.*;
import java.util.List;

//import static javax.persistence.Persistence.createEntityManagerFactory;


public class CourseService implements CourseDAO {
    List<Course> courses ;
    private EntityManagerFactory emf;
    private EntityManager em;

    public CourseService() {
        emf = Persistence.createEntityManagerFactory("school_db");
        em = emf.createEntityManager();

    }


    @Override
    public List<Course> getAllCourses() {

        //This method takes no parameter and returns every Course in the table.

     //   EntityManagerFactory emf = createEntityManagerFactory("school_db");
     //   EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createQuery("SELECT c FROM Course c");
            List<Course> courses = query.getResultList();

            return courses;


        }catch (Exception e) {
            return null;
        }


    }
    @Override
    public Course GetCourseById(int courseId){

        // This method takes courseId as parameter and returns the list of courses

        try {
            Query query = em.createQuery("SELECT c FROM Course c WHERE id = :id")
                    .setParameter("id",courseId);
            List<Course> courseList =query.getResultList();


            if (courseList.size()!=0){
                return courseList.get(0);
            }else{
                return null;
            }
        }catch (NoResultException | NullPointerException e) {
            System.out.println("No Such course Exists");

        }
        return null;
    }


}

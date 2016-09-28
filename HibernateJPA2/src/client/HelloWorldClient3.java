
package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Guide;
import entity.Student;

public class HelloWorldClient3 {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			//Adding data to guide and student table by adding a Guide and associating a Student with it
			Guide guide = new Guide("2000DO10777", "Lalo", 3000);		
			Student student = new Student("2014RG50347", "JC");
			Student student2 = new Student("2014RG50348", "Gio");

			guide.addStudent(student);
			guide.addStudent(student2);
			em.persist(guide);
	
			guide.addStudent(new Student("2014RG50349", "Gabo"));
			//Loading all the student objects
			
			Query query = em.createQuery("SELECT student FROM Student student");
			List<Student> students = query.getResultList();	

			for (Student studentTemp : students) {
				System.out.println(studentTemp.getName() + ": " + studentTemp.getEnrollmentId());
			}  
			

			//Loading all the students with their associated Guide objects with the Student objects selectively (whenever you need to load them eagerly)
			
			Query query2 = em.createQuery("SELECT student FROM Student student LEFT JOIN FETCH student.guide");
			List<Student> students2 = query2.getResultList();	

			for (Student studentTemp2 : students2) {
				//students who do not have a guide will not be loaded
				if(studentTemp2.getGuide() != null) {				
					System.out.println(studentTemp2.getName() + ": " + studentTemp2.getEnrollmentId() + ": " + studentTemp2.getGuide().getName());
				}
			}  		
			
			//Loading all the student objects
			
			Query query3 = em.createQuery("SELECT guide FROM Guide guide");
			List<Guide> guide2 = query3.getResultList();	

			for (Guide guideTemp : guide2) {
				System.out.println(guideTemp.getName() + ": " + guideTemp.getStudents().size());
			}

			txn.commit();			
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}
}















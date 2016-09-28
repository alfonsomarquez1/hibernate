
package client;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entity.Address;
import entity.Person;
import entity.Student;


public class HelloWorldClient2 {
	public static void main(String[] args) {
		
			Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();
        	
        			Address address = new Address("200 E Main St", "New York", "85123");
        			Person person = new Person("Rub", address);
        	
        			session.save(person);
	        
        			List<Person> students = 
        					session.createQuery("SELECT person FROM Person person WHERE person.address.city = 'New York'").list();
        			
        			for(Person p: students) {
        				System.out.println("student " + p.getName() + ", addess " + p.getAddress().getCity());
        			}
        			
	        		txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}













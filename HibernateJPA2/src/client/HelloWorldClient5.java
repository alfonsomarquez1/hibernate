package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Country;
import entity.Guide;
import entity.State;
import entity.Student;

public class HelloWorldClient5 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			Country country = new Country(10,"Ratotitlan");		
			State state1 = new State(country.getCountryId(), 1, "Edo Mex");
			State state2 = new State(country.getCountryId(), 2, "Veracruz");
			State state3 = new State(country.getCountryId(), 3, "Chiapas");

			country.addState(state1);
			country.addState(state2);
			country.addState(state3);
			
			em.persist(country);
	
			
			//Loading all the students with their associated Guide objects with the Student objects selectively (whenever you need to load them eagerly)
			
			Query query2 = em.createQuery("select state from State state left join fetch state.country WHERE state.country.id = 10");
			List<State> states = query2.getResultList();	

			for (State stateTemp : states) {
				//students who do not have a guide will not be loaded
				if(stateTemp.getCountry() != null) {				
					System.out.println(stateTemp.getCountry().getCountryName()+ ": " + stateTemp.getName() + ": " + stateTemp.getStateId());
				}
			}  		
			
			//Loading all the student objects
			
			Query query3 = em.createQuery("select country from Country country");
			List<Country> countries = query3.getResultList();	

			for (Country countryTemp : countries) {
				System.out.println(countryTemp.getCountryName() + ": " + countryTemp.getStates().size());
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












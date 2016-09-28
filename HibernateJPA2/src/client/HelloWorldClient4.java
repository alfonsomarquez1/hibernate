package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Metatable;
import entity.MetatableValue;
import entity.MetatableValuePK;

public class HelloWorldClient4 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			
			System.out.println("Iniciando");
			Metatable metatable = new Metatable("S_ES_MX_2", "Estatus");
			
			MetatableValuePK metaValuePK1 = new MetatableValuePK(metatable.getMetatableId(),"0");
			MetatableValue metatableValue1 = new MetatableValue(metaValuePK1, "Inactivo");
			
			MetatableValuePK metaValuePK2 = new MetatableValuePK(metatable.getMetatableId(),"1");
			MetatableValue metatableValue2 = new MetatableValue(metaValuePK2, "Activo");
			
			metatable.addMetatableValue(metatableValue1);
			metatable.addMetatableValue(metatableValue2);
			
			em.persist(metatable);
			System.out.println("Guardado");

			
			//Loading all the students with their associated Guide objects with the Student objects selectively (whenever you need to load them eagerly)
			System.out.println("Iniciando consulta valores");

			Query query2 = em.createQuery("SELECT mv FROM MetatableValue mv LEFT JOIN FETCH mv.metatable WHERE mv.key.metatableId = 'S_ES_MX_2'");
			List<MetatableValue> metatableValues = query2.getResultList();	

			for (MetatableValue metatableValueTemp : metatableValues) {
				//students who do not have a guide will not be loaded
				if(metatableValueTemp.getMetatable() != null) {				
					System.out.println(metatableValueTemp.getMetatable().getMetatableName()+ " : " 
							+ metatableValueTemp.getMetatableName() + ": " + 
							metatableValueTemp.getKey().getMetatableValueId());
				}
			}  		
			System.out.println("Fin consulta");

			//Loading all the student objects
			System.out.println("Iniciando consulta catalogos");

			Query query3 = em.createQuery("SELECT m FROM Metatable m");
			List<Metatable> metatables = query3.getResultList();	

			for (Metatable metatableTemp : metatables) {
				System.out.println(metatableTemp.getMetatableName() + ": " +
						metatableTemp.getMetatableValues().size());
			}
			System.out.println("Fin consulta catalogos");

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





package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Person;

public class Program {

	public static void main(String[] args) {
		
		Person p1 = new Person(null, "Carlos da Silva", "carlos@gmail.com");
		Person p2 = new Person(null, "Joaquim Torres", "joaquim@gmail.com");
		Person p3 = new Person(null, "Ana Maria", "ana@gmail.com");

		final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("exemplo-jpa");

		final EntityManager em = emFactory.createEntityManager();

		em.getTransaction().begin();
			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
		em.getTransaction().commit();

		final Person person = em.find(Person.class, 2);
		em.getTransaction().begin();
		em.remove(person);
		em.getTransaction().commit();

		System.out.println("Done");
		em.close();
		emFactory.close();
	}
}

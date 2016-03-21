import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class Test {
 
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("EmpCRD");
		Employee employee = new Employee();
		employee.setFirstname("Recep");
		employee.setLastname("Sezer");
		employee.setEmail("recepsezer94@gmail.com");
		employee.setIdEmployee(1);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		employee = em.find(Employee.class, 1);
		System.out.println(employee);
		em.getTransaction().begin();
		employee.setFirstname("Reggie");
		System.out.println("G�ncelleme Sonras� " + employee);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.remove(employee);
		em.getTransaction().commit();
		employee = em.find(Employee.class, 1);
		System.out.println("Silinme Sonras� " + employee);
 
	}
}
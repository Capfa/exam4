import jpa.entity.Climber;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("exam4");
        EntityManager manager = factory.createEntityManager();
        Climber climber = new Climber();
        climber.setName("Pol");
        climber.setAdress("Moscow");

        manager.getTransaction().begin();
        manager.persist(climber);

        manager.getTransaction().commit();
    }
}
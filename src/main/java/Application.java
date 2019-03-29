import DAO.UtilisateurDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Class Application
 * Created by Alexis on 11/03/2019
 */
public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("droitAcces");
        try {
            EntityManager em = emf.createEntityManager();
            try {

                UtilisateurDAO utilisateurDAO = new UtilisateurDAO(em);

            } finally {
                em.close();
            }
        } finally {
            emf.close();
        }
    }
}

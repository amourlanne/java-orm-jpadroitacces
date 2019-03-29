package DAO;

import Entity.Utilisateur;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UtilisateurDAOTest extends JPAHibernateTest {

    private UtilisateurDAO utilisateurDAO;

    @BeforeAll
    void initDAO() {
        utilisateurDAO = new UtilisateurDAO(em);
    }

    @Test
    void get() {
        assertEquals(utilisateurDAO.get(1).getLogin(), "doe");
        assertNotEquals(utilisateurDAO.get(2).getLogin(), "doe");
        assertEquals(utilisateurDAO.get(3).getLogin(), "vincent");
    }

    @Test
    void getAll() {
        assertEquals(utilisateurDAO.getAll().size(), 3);
    }

    @Test
    void getAllActifs() {
        assertEquals(utilisateurDAO.getAllActifs().size(), 2);
    }

    @Test
    void desactiverInscritsAvant() {
        // TODO
    }

    @Test
    void getByBadge() {
        Utilisateur doe = utilisateurDAO.getByBadge("XTC222");
        assertEquals(doe.getLogin(), "doe");

        Utilisateur spoonless = utilisateurDAO.getByBadge("XTV555");
        assertEquals(spoonless.getLogin(), "spoonless");
    }

    @Test
    void getByDroit() {
        List<Utilisateur> utilisateurs = utilisateurDAO.getByDroit("connexion");

        assertEquals(utilisateurs.size(), 3);

        Utilisateur doe = utilisateurs.stream()
                .filter(utilisateur -> utilisateur.getLogin().equals("doe"))
                .findFirst()
                .orElse(null);

        assertNotNull(doe);
    }

    @Test
    void isAutorise() {
        assertTrue(utilisateurDAO.isAutorise("XTC222", "connexion"));
        assertFalse(utilisateurDAO.isAutorise("XTH999", "suppression"));
    }

}
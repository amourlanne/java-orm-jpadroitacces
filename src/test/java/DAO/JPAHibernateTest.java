package DAO;

import Entity.Utilisateur;
import org.h2.tools.RunScript;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * Class DAO.JPAHibernateTest
 * Created by Alexis on 15/03/2019
 */
abstract class JPAHibernateTest {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    @BeforeAll
    void init() {
        emf = Persistence.createEntityManagerFactory("droitAccesTest");
        em = emf.createEntityManager();
        // <property name="hibernate.hbm2ddl.auto" value="update"/> in persistence.xml auto create table
        initializeDatabase();
    }

    void initializeDatabase() {
        Session session = em.unwrap(Session.class);
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                try {
                    File script = new File(getClass().getResource("/fixtures.sql").getFile());
                    RunScript.execute(connection, new FileReader(script));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException("could not initialize with script");
                }
            }
        });
    }

    @AfterAll
    void tearDown() {
        em.clear();
        em.close();
        emf.close();
    }
}

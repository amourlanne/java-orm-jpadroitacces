package DAO;

import Entity.Utilisateur;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

/**
 * Class UtilisateurDAO
 * Created by Alexis on 15/03/2019
 */
public class UtilisateurDAO {

    private EntityManager entityManager;

    public UtilisateurDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Utilisateur get(int id) {
        return entityManager.find(Utilisateur.class, id);
    }

    public void create(Utilisateur u) {
        this.entityManager.persist(u);
    }

    public List<Utilisateur> getAll() {
        return entityManager.createQuery("select u from Utilisateur u", Utilisateur.class)
                .getResultList();
    }

    public List<Utilisateur> getAllActifs() {
        return entityManager.createQuery("select u from Utilisateur u where u.actif = true", Utilisateur.class)
                .getResultList();
    }

    public void desactiverInscritsAvant(Date date) {
        entityManager.createQuery("UPDATE Utilisateur u set u.actif = false where u.dateInscription <= :date")
                .setParameter("date", date)
                .executeUpdate();
    }

    public Utilisateur getByBadge(String numeroBadge) {
        return entityManager.createQuery("select u from Utilisateur u where u.badge.numero = :numeroBadge", Utilisateur.class)
                .setParameter("numeroBadge", numeroBadge)
                .getSingleResult();
    }

    public boolean isAutorise(String numeroBadge, String droit) {
        long c = entityManager.createQuery("select count(u) from Utilisateur u join u.droits d where u.badge.numero = :numeroBadge and d.libelle = :libelle", Long.class)
                .setParameter("numeroBadge", numeroBadge)
                .setParameter("libelle", droit)
                .getSingleResult();
        return c == 1;
    }

    public List<Utilisateur> getByDroit(String droit) {
        return entityManager.createQuery("select u from Utilisateur u join u.droits d where d.libelle = :droit", Utilisateur.class)
                .setParameter("droit", droit)
                .getResultList();
    }

}

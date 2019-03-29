package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class Utilisateur
 * Created by Alexis on 11/03/2019
 */

@Entity
public class Utilisateur {

    public Utilisateur() {
    }

    public Utilisateur(String login, Date dateInscription, boolean actif) {
        this.login = login;
        this.dateInscription = dateInscription;
        this.actif = actif;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String login;

    @Temporal(TemporalType.DATE)
    private Date dateInscription;

    @OneToOne(cascade= {CascadeType.PERSIST})
    @JoinColumn(name = "badge_id")
    private Badge badge;

    @ManyToMany
    @JoinTable(name = "Utilisateur_Droit",
            joinColumns = @JoinColumn(name = "id_utilisateur"),
            inverseJoinColumns = @JoinColumn(name = "id_droit"))
    private List<Droit> droits;

    private boolean actif;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    @Override
    public String toString() {
        return login;
    }
}

package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Badge
 * Created by Alexis on 29/03/2019
 */

@Entity
public class Badge {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String numero;

    @OneToOne(mappedBy="badge")
    private Utilisateur utilisateur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}

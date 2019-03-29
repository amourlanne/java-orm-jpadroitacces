package Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Class Droit
 * Created by Alexis on 29/03/2019
 */
@Entity
public class Droit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String libelle;

    @ManyToMany(mappedBy="droits")
    private List<Utilisateur> utilisateurs;
}

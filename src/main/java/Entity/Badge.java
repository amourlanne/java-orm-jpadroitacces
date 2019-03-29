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
}

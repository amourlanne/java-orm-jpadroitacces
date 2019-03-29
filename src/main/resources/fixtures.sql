insert into Badge (id, numero)
values (1, 'XTC222'),
       (2, 'XTV555'),
       (3, 'XTH999');

insert into Droit (id,libelle)
values (1,'connexion'),
       (2,'lecture'),
       (3,'ecriture'),
       (4,'suppression');

insert into Utilisateur (id, login, dateInscription, actif, badge_id)
values (1, 'doe', '2000-12-25', true, 1),
       (2, 'spoonless', '2017-01-26', false, 2),
       (3, 'vincent', '2018-06-03', true, 3);

insert into Utilisateur_Droit (id_utilisateur, id_droit)
values (1, 1),
       (1, 2),
       (2, 1),
       (2, 2),
       (2, 3),
       (2, 4),
       (3, 1),
       (3, 2),
       (3, 3);

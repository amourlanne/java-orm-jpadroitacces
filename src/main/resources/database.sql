drop table if exists Utilisateur_Droit;
drop table if exists Droit;
drop table if exists Utilisateur;
drop table if exists Badge;

create table Utilisateur
(
    id              int primary key auto_increment,
    login           varchar(50) not null,
    dateInscription date        not null,
    actif           boolean     not null
) engine = InnoDB;

create table Droit
(
    id      int primary key auto_increment,
    libelle varchar(50) not null
) engine = InnoDB;

create table Utilisateur_Droit
(
    id_utilisateur int not null,
    id_droit       int not null,
    primary key (id_utilisateur, id_droit),
    foreign key fk_utilisateur (id_utilisateur) references Utilisateur (id),
    foreign key fk_droit (id_droit) references Droit (id)
) engine = InnoDB;

create table Badge
(
    id     int          not null auto_increment,
    numero varchar(100) not null,
    primary key (id)
) engine = InnoDB;

alter table Utilisateur
    add column badge_id int;
alter table Utilisateur
    add constraint badge_fk foreign key (badge_id) references Badge(id);
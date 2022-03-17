DROP DATABASE  IF EXISTS `sauvelle`;

CREATE DATABASE  IF NOT EXISTS `sauvelle`;
USE `sauvelle`;

CREATE TABLE `categories` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `nom` varchar(20) NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `matieres_premieres` (
                         `id` INT  NOT NULL AUTO_INCREMENT,
                         `nom` char(50) NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `secteurs` (
                          `id` INT  NOT NULL AUTO_INCREMENT,
                          `name` varchar(20) NOT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `unites` (
                          id	INT NOT NULL auto_increment,
                          `nom` varchar(20) NOT NULL,
                          PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `cooperatives` (
                                `id` INT NOT NULL AUTO_INCREMENT,
                                `nom` varchar(500) DEFAULT NULL,
                                secteur_id INT NOT NULL,
                                FOREIGN KEY (secteur_id) REFERENCES secteurs (id),
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `clients` (
                        id INT NOT NULL,
                        nom varchar(25) NOT NULL,
                        adresse varchar(80) DEFAULT NULL,
                        telephone varchar(20) DEFAULT NULL,
                        ville varchar(10) DEFAULT NULL,
                        email varchar(30) DEFAULT NULL,
                        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `produits` (
                        id INT NOT NULL,
                        nom varchar(25) NOT NULL,
                        description varchar(500) NOT NULL,
                        prix DOUBLE NOT NULL,
                        unite_id INT NOT NULL,
                        categorie_id INT NOT NULL,
                        cooperative_id INT NOT NULL,
                        FOREIGN KEY (unite_id) REFERENCES unites (id),
                        FOREIGN KEY (categorie_id) REFERENCES categories (id),
                        FOREIGN KEY (cooperative_id) REFERENCES cooperatives (id),
                        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `compositions` (
                        produit_id INT NOT NULL,
                        matiere_premiere_id INT NOT NULL,
                        pourcentage DOUBLE NOT NULL,
                        FOREIGN KEY (produit_id) REFERENCES produits (id),
                        FOREIGN KEY (matiere_premiere_id) REFERENCES matieres_premieres (id),
                        PRIMARY KEY (produit_id,matiere_premiere_id)
)  ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `paniers` (
                           client_id INT NOT NULL,
                           produit_id INT NOT NULL,
                           quantite int DEFAULT 1,
                           PRIMARY KEY (client_id,produit_id),
                           FOREIGN KEY (client_id) references clients (id) ,
                           FOREIGN KEY (produit_id)  references produits (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `commandes` (
                          id INT NOT NULL,
                          client_id INT NOT NULL,
                          `date` DATE DEFAULT CURRENT_DATE ,
                          montant DOUBLE NOT NULL,
                          status ENUM('livraison','livre','refuse','valide','en cours') DEFAULT ('en cours'),
                          PRIMARY KEY (id),
                          FOREIGN KEY (client_id) references clients (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `commandes_details` (
                        commande_id INT NOT NULL,
                        produit_id INT NOT NULL,
                        quantite INT DEFAULT 1,
                        prix_unite DOUBLE,
                        FOREIGN KEY (commande_id) REFERENCES commandes (id),
                        FOREIGN KEY (produit_id) REFERENCES produits (id),
                        PRIMARY KEY (commande_id,produit_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
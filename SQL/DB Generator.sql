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

CREATE TABLE `roles` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `name` varchar(500) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO roles VALUES (1,'ROLE_USER');
INSERT INTO roles VALUES (2,'ROLE_ADMIN');

CREATE TABLE `clients` (
                           id INT NOT NULL AUTO_INCREMENT,
                           nom varchar(25) NOT NULL,
                           adresse varchar(80) DEFAULT NULL,
                           telephone varchar(20) DEFAULT NULL,
                           ville varchar(10) DEFAULT NULL,
                           email varchar(30) DEFAULT NULL,
                           username varchar(10) NOT NULL unique ,
                           password varchar(50) NOT NULL,
                           id_role int DEFAULT 0,
                           PRIMARY KEY (id),
                            FOREIGN KEY (id_role) references roles (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `produits` (
                            id INT NOT NULL AUTO_INCREMENT,
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
                                produit_id INT NOT NULL AUTO_INCREMENT,
                                matiere_premiere_id INT NOT NULL,
                                pourcentage DOUBLE NOT NULL,
                                FOREIGN KEY (produit_id) REFERENCES produits (id),
                                FOREIGN KEY (matiere_premiere_id) REFERENCES matieres_premieres (id),
                                PRIMARY KEY (produit_id,matiere_premiere_id)
)  ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `paniers` (
                           client_id INT NOT NULL AUTO_INCREMENT,
                           produit_id INT NOT NULL,
                           quantite int DEFAULT 1,
                           PRIMARY KEY (client_id,produit_id),
                           FOREIGN KEY (client_id) references clients (id) ,
                           FOREIGN KEY (produit_id)  references produits (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `discounts` (
                           id INT NOT NULL AUTO_INCREMENT,
                           code VARCHAR(8) NOT NULL,
                           pourcentage double ,
                           PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `commandes` (
                             id INT NOT NULL AUTO_INCREMENT,
                             client_id INT NOT NULL,
                             discount_id INT,
                             `date` DATETIME DEFAULT CURRENT_TIMESTAMP,
                             `montant` DOUBLE NOT NULL,
                             status ENUM('livraison','livre','refuse','valide','en cours') DEFAULT ('en cours'),
                             PRIMARY KEY (id),
                             FOREIGN KEY (client_id) references clients (id),
                             FOREIGN KEY (discount_id) references discounts (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `commandes_details` (
                                     commande_id INT NOT NULL AUTO_INCREMENT,
                                     produit_id INT NOT NULL,
                                     quantite INT DEFAULT 1,
                                     prix_unite DOUBLE,
                                     FOREIGN KEY (commande_id) REFERENCES commandes (id),
                                     FOREIGN KEY (produit_id) REFERENCES produits (id),
                                     PRIMARY KEY (commande_id,produit_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO unites VALUES (1,'ML');
INSERT INTO unites VALUES (2,'L');
INSERT INTO unites VALUES (3,'G');
INSERT INTO unites VALUES (4,'KG');

INSERT INTO secteurs VALUES (1,'cosmetiques');

INSERT INTO categories VALUES (1,'huiles');
INSERT INTO categories VALUES (2,'savons');

INSERT INTO cooperatives VALUES (1,'SOUSS',1);
INSERT INTO cooperatives VALUES (2,'CASABLANCA',1);

INSERT INTO matieres_premieres VALUES (1,'olive verte');
INSERT INTO matieres_premieres VALUES (2,'argan');
INSERT INTO matieres_premieres VALUES (3,'eau');
INSERT INTO matieres_premieres VALUES (4,'savon');

INSERT INTO produits VALUES (1,'argan huile','huilde d agran pour cosmétique',150,2,1,1);
INSERT INTO produits VALUES (2,'olive huile','huilde d olive pour cosmétique',100,1,1,2);
INSERT INTO produits VALUES (3,'argan savonnette','savon d agran pour cosmétique',95,3,2,1);
INSERT INTO produits VALUES (4,'olive savonnette','savon d olive pour cosmétique',40,3,2,2);

INSERT INTO compositions VALUES (1,2,90);
INSERT INTO compositions VALUES (1,3,10);
INSERT INTO compositions VALUES (2,1,90);
INSERT INTO compositions VALUES (2,3,10);
INSERT INTO compositions VALUES (3,2,40);
INSERT INTO compositions VALUES (3,4,60);
INSERT INTO compositions VALUES (4,2,70);
INSERT INTO compositions VALUES (4,1,30);

SET FOREIGN_KEY_CHECKS = 1;
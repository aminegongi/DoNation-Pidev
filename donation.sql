-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  lun. 17 fév. 2020 à 18:42
-- Version du serveur :  5.7.28
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `donation`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

DROP TABLE IF EXISTS `administrateur`;
CREATE TABLE IF NOT EXISTS `administrateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `salt` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `dateAjout` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `administrateur`
--

INSERT INTO `administrateur` (`id`, `mail`, `mdp`, `salt`, `nom`, `username`, `dateAjout`) VALUES
(2, 'amine@gmail.com', 'azdaze', 'dzdzada', 'amine', 'rafraf', '2020-02-08 23:26:44'),
(3, 'amine@gmail.com', 'azdaze', 'dzdzada', 'amine', 'rafraf', '2020-02-08 23:33:55');

-- --------------------------------------------------------

--
-- Structure de la table `demandedesactivationcompte`
--

DROP TABLE IF EXISTS `demandedesactivationcompte`;
CREATE TABLE IF NOT EXISTS `demandedesactivationcompte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `dateDemande` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `historiqueconnexionuser`
--

DROP TABLE IF EXISTS `historiqueconnexionuser`;
CREATE TABLE IF NOT EXISTS `historiqueconnexionuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idUtilisateur` int(11) NOT NULL,
  `ipAdresse` varchar(255) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idUtilisateur` (`idUtilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `historiqueconnexionuser`
--

INSERT INTO `historiqueconnexionuser` (`id`, `idUtilisateur`, `ipAdresse`, `date`) VALUES
(2, 18, '196.229.252.243', '2020-02-11 19:15:47'),
(6, 13, '196.229.165.86', '2020-02-12 13:35:14'),
(7, 18, '196.229.165.86', '2020-02-12 13:57:10'),
(8, 3, '196.229.252.243', '2020-02-13 16:10:28'),
(9, 18, '196.229.165.86', '2020-02-12 13:57:10'),
(10, 18, '196.229.165.86', '2020-02-12 13:57:10'),
(11, 18, '94.177.243.143', '2020-02-12 13:57:10'),
(12, 18, '196.229.165.86', '2020-02-12 13:57:10'),
(13, 9, '41.226.11.245', '2020-02-14 07:45:33'),
(14, 9, '41.226.11.245', '2020-02-14 07:51:32'),
(15, 9, '41.226.11.245', '2020-02-14 08:06:47'),
(16, 9, '41.226.11.245', '2020-02-14 08:17:03'),
(17, 9, '196.225.167.97', '2020-02-14 11:00:59');

-- --------------------------------------------------------

--
-- Structure de la table `inscrinewsletter`
--

DROP TABLE IF EXISTS `inscrinewsletter`;
CREATE TABLE IF NOT EXISTS `inscrinewsletter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) DEFAULT NULL,
  `mailNews` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idU_user_news` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `inscrinewsletter`
--

INSERT INTO `inscrinewsletter` (`id`, `idUser`, `mailNews`) VALUES
(1, NULL, 'amine98gongi@gmail.com'),
(2, NULL, 'amine@gmail.com'),
(3, 25, 'neila.neila.neila@gmail.com'),
(4, NULL, 'DonationOrgTest1@gmail.com'),
(5, NULL, 'DonationOrgModifTest1@gmail.com'),
(6, 19, 'amine.gqqongi@esprit.tn'),
(7, 21, 'goamine3@gmail.com'),
(8, 28, 'amine.gongi@esprit.tn'),
(9, 2, 'mail.com@om2'),
(10, 2, 'mail.com@om2'),
(11, 2, 'mail.com@om2'),
(12, 2, 'mail.com@om2'),
(13, 2, 'mail.com@om2'),
(14, 2, 'mail.com@om2'),
(15, 2, 'mail.com@om2'),
(16, 2, 'mail.com@om2'),
(17, 2, 'mail.com@om2'),
(18, 2, 'mail.com@om2'),
(19, 3, 'mail.com@om3');

-- --------------------------------------------------------

--
-- Structure de la table `newsletter`
--

DROP TABLE IF EXISTS `newsletter`;
CREATE TABLE IF NOT EXISTS `newsletter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  `objetMail` varchar(255) NOT NULL,
  `corpsMail` text NOT NULL,
  `dateEnvoi` date DEFAULT NULL,
  `dateAjout` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `newsletter`
--

INSERT INTO `newsletter` (`id`, `libelle`, `objetMail`, `corpsMail`, `dateEnvoi`, `dateAjout`) VALUES
(2, 'est1', 'Objet du mai TEst1', 'corps du mail Test1', '2020-02-14', '2020-02-14 03:52:56'),
(3, 'TestMo', 'Objet du mai TestMo', 'corps du mail TestMo', NULL, '2020-02-14 03:53:22'),
(4, 'Test1', 'Objet du mai TEst1', 'corps du mail Test1', NULL, '2020-02-14 04:16:04'),
(5, 'Test1', 'Objet du mai TEst1', 'corps du mail Test1', NULL, '2020-02-14 04:16:15'),
(6, 'Test1', 'Objet du mai TEst1', 'corps du mail Test1', NULL, '2020-02-14 04:16:44'),
(7, 'Test1', 'Objet du mai TEst1', 'corps du mail Test1', NULL, '2020-02-14 04:19:23'),
(8, 'Test1', 'Objet du mai TEst1', 'corps du mail Test1', NULL, '2020-02-14 04:20:07'),
(9, 'Test1', 'Objet du mai TEst1', 'corps du mail Test1', NULL, '2020-02-14 04:21:02'),
(10, 'Test1', 'Objet du mai TEst1', 'corps du mail Test1', NULL, '2020-02-14 04:34:13'),
(11, 'TestMo', 'Objet du mai TestMo', 'corps du mail TestMo', NULL, '2020-02-14 04:34:45'),
(12, 'TestMo', 'Objet du mai TestMo', 'corps du mail TestMo', NULL, '2020-02-14 11:02:47');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `salt` varchar(255) NOT NULL,
  `numTel` varchar(255) NOT NULL,
  `A_pays` varchar(255) NOT NULL,
  `A_ville` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `pointXP` int(11) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `confirm_token` varchar(255) NOT NULL,
  `password_request_at` timestamp NULL DEFAULT NULL,
  `nom` varchar(255) NOT NULL,
  `matriculeFiscale` varchar(255) DEFAULT NULL,
  `pageFB` varchar(255) DEFAULT NULL,
  `siteWeb` varchar(255) DEFAULT NULL,
  `description` text,
  `numVisa` varchar(255) DEFAULT NULL,
  `porteFeuilleV` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `dateNaissance` datetime DEFAULT NULL,
  `dateInscription` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mail` (`mail`),
  UNIQUE KEY `confirm_token` (`confirm_token`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id`, `role`, `mail`, `mdp`, `salt`, `numTel`, `A_pays`, `A_ville`, `image`, `pointXP`, `enabled`, `confirm_token`, `password_request_at`, `nom`, `matriculeFiscale`, `pageFB`, `siteWeb`, `description`, `numVisa`, `porteFeuilleV`, `longitude`, `latitude`, `prenom`, `genre`, `dateNaissance`, `dateInscription`) VALUES
(2, 'us', 'mail.com@om2', 'aaza1', 'azrazrza', '3112122121', 'Tunisie1', 'Ghazella1', 'image1', 0, 0, 'eererzeeerzr', NULL, 'Org Enactus', NULL, 'fb.com/ORG1', 'sw.com/ORG1', 'AQZSS1', 'ORG98988', NULL, 987.6, 99, 'Gonoo', 'Fomme', NULL, '2020-02-10 20:24:34'),
(3, 'us', 'mail.com@om3', 'aaza1', 'azrazrza', '3112122121', 'Tunisie1', 'Ghazella1', 'image1', 321111, 0, 'eererzerzraaa', NULL, 'Org Enactus', NULL, 'fb.com/ORG1', 'sw.com/ORG1', 'AQZSS1', 'ORG98988', NULL, 987.6, 99, 'Gongi', 'Homme', NULL, '2020-02-10 20:24:34'),
(4, 'us', 'mail.com@om4', 'aaza1', 'azrazrza', '3112122121', 'Tunisie1', 'Ghazella1', 'image1', 321111, 1, 'eererzerzrrrr', NULL, 'Org Enactus', NULL, 'fb.com/ORG1', 'sw.com/ORG1', 'AQZSS1', 'ORG98988', NULL, 987.6, 99, 'Gongi', 'Homme', NULL, '2020-02-10 20:24:34'),
(5, 'us', 'mail.com@om5', 'aaza1', 'azrazrza', '3112122121', 'Tunisie1', 'Ghazella1', 'image1', 321111, 1, 'eererzerzrffff', NULL, 'Org Enactus', NULL, 'fb.com/ORG1', 'sw.com/ORG1', 'AQZSS1', 'ORG98988', NULL, 987.6, 99, 'Gongi', 'Homme', NULL, '2020-02-10 20:24:34'),
(6, 'us', 'mail.com@om6', 'aaza1', 'azrazrza', '3112122121', 'Tunisie1', 'Ghazella1', 'image1', 321111, 1, 'eererzerzrsd', NULL, 'Org Enactus', NULL, 'fb.com/ORG1', 'sw.com/ORG1', 'AQZSS1', 'ORG98988', NULL, 987.6, 99, 'Gongi', 'Homme', NULL, '2020-02-10 20:24:34'),
(7, 'us', 'mail.com@om7', 'aaza1', 'azrazrza', '3112122121', 'Tunisie1', 'Ghazella1', 'image1', 321111, 1, 'eererzerzrqqqq', NULL, 'Org Enactus', NULL, 'fb.com/ORG1', 'sw.com/ORG1', 'AQZSS1', 'ORG98988', NULL, 987.6, 99, 'Gongi', 'Homme', NULL, '2020-02-10 20:24:34'),
(8, 'org', 'mail.com@om', 'aaza', 'aqqdfe21', '311212212', 'Tunisie', 'Ghazella', 'image', 3211, 1, 'AZAZA1212121eeeeee', NULL, 'Org Enactus555', NULL, 'fb.com/ORG', 'sw.com/ORG', 'AQZSS', 'ORG12341', NULL, 2, 1, NULL, NULL, NULL, '2020-02-10 20:24:34'),
(9, 'org', 'mail.com@om8', 'aaza1', 'aqqdfe21', '3112122121', 'Tunisie1', 'Ghazella1', 'image1', 321111, 1, 'AZAZA1212121', NULL, 'Org Enactus', NULL, 'fb.com/ORG1', 'sw.com/ORG1', 'AQZSS1', 'ORG98988', NULL, 987.6, 99, NULL, NULL, NULL, '2020-02-10 20:24:34'),
(10, 'ent', 'mail.com@ENT', 'aazaENT', 'aqqdfe21ENT', '311212212', 'Tunisie', 'Ghazella', 'image', 3211, 1, 'AZAZA1212121ENT', NULL, 'ENT MFC', 'ENT12341', 'fb.com/ENT', 'sw.com/ENT', 'AQENT', NULL, NULL, 42, 55, NULL, NULL, NULL, '2020-02-10 20:24:34'),
(11, 'ent', 'mail.com@ENT999', 'aazaENT999', 'aqqdfe21ENT', '311212212999', 'Tunisi999e', '999Ghazella', 'image999', 3211999, 1, 'AZAZA1212121rrrENT', NULL, 'ENT MFC999', 'ENT999', 'fb.com/ENT999', 'sw.com/ENT999', 'AQENT999', NULL, NULL, 112, 99, NULL, NULL, NULL, '2020-02-10 20:24:34'),
(13, 'resto', 'mail.com@REST2', 'aazaRESTREST', 'aqqdfe21REST', '311212212REST', 'TuniRESTsie', 'GhaRESTzella', 'imaRESTge', 3211, 1, 'AZAZA12121rrr21RESTENT', NULL, 'RESTREST MFC', NULL, 'fb.com/RESTREST', 'sw.com/RESTREST', 'AQRESTREST', NULL, 118.244, 142, 655, NULL, NULL, NULL, '2020-02-10 20:24:34'),
(15, 'resto', 'mail.com@REST', 'aazaREST', 'aqqdfe21REST', '311212212', 'Tunisie', 'Ghazella', 'image', 3211, 1, 'AZAZA1212121RESTENT', NULL, 'REST MFC', NULL, 'fb.com/REST', 'sw.com/REST', 'AQREST', NULL, 9898.44, 422, 52, NULL, NULL, NULL, '2020-02-10 20:24:34'),
(16, 'resto', 'mail.com', 'eezezeze', 'salt', '9898', 'tunisie', 'tunis', 'image', 212, -1, '623b3', NULL, 'Amine', NULL, 'www.fb.com', 'sw', 'zeaeaeaeaea', NULL, 444, 33, 22, NULL, NULL, NULL, '2020-02-11 11:51:49'),
(17, 'resto', 'mail.zzzcom', 'eezezeze', 'salt', '9898', 'tunisie', 'tunis', 'image', 212, 0, '5b78d', NULL, 'Amine', NULL, 'www.fb.com', 'sw', 'zeaeaeaeaea', NULL, 444, 33, 22, NULL, NULL, NULL, '2020-02-11 11:54:50'),
(18, 'resto', 'mailee.zzzcom', 'eezezeze', 'salt', '9898', 'tunisie', 'tunis', 'image', 212, 1, 'ee9fe', NULL, 'Amine', NULL, 'www.fb.com', 'sw', 'zeaeaeaeaea', NULL, 444, 33, 22, NULL, NULL, NULL, '2020-02-11 12:05:10'),
(19, 'us', 'amine.gqqongi@esprit.tn', 'aaaa', 'aaaa', 'zfzzz', 'Tunisie', 'tunis', 'image', 121, -1, 'e7f2a', NULL, 'aaaaaaa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'gongi', 'homme', '3906-03-07 00:00:00', '2020-02-12 16:49:56'),
(20, 'us', 'aaaa', 'aa', 'Bsalt', 'aaa', 'Tunisie', 'tunn', 'image', 0, -1, '55173', NULL, 'amine', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'aaa', 'Homme', '2020-02-13 00:00:00', '2020-02-13 17:12:32'),
(21, 'us', 'goamine3@gmail.com', 'aa', 'Bsalt', 'aaa', 'Tunisie', 'tunn', 'image', 0, 1, '70749', NULL, 'amine', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'aaa', 'Homme', '2020-02-13 00:00:00', '2020-02-13 17:13:48'),
(22, 'us', 'da@gmail.com', 'zazza', 'Bsalt', 'dsf', 'Tunisie', 'rer', 'image', 0, -1, 'e7c13', NULL, 'azdaza', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'adadadda', 'Homme', '2020-02-26 00:00:00', '2020-02-13 17:19:02'),
(23, 'us', 'daaddada@gmail.com', 'dadadada', 'Bsalt', 'addada', 'Tunisie', 'dad', 'image', 0, -1, '61242', NULL, 'ada', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'daaada', 'Homme', '1998-02-07 00:00:00', '2020-02-13 17:21:17'),
(25, 'us', 'neila.neila.neila@gmail.com', '123', 'Bsalt', '121231212', 'Maroc', 'casa', 'image', 0, -1, '1f7ad', NULL, 'ezfefzf', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'zfzfzfz', 'Homme', '2020-02-05 00:00:00', '2020-02-14 06:37:52'),
(28, 'us', 'amine.gongi@esprit.tn', '212', 'Bsalt', '3232323', 'Maroc', 'casa', 'image', 0, -1, 'c0055', NULL, 'azaz', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'zeazera', 'Homme', '2020-02-12 00:00:00', '2020-02-14 11:21:54');

--
-- Déclencheurs `utilisateurs`
--
DROP TRIGGER IF EXISTS `after_UserMail_Modif`;
DELIMITER $$
CREATE TRIGGER `after_UserMail_Modif` AFTER UPDATE ON `utilisateurs` FOR EACH ROW BEGIN
    INSERT INTO inscrinewsletter(inscrinewsletter.idUser, inscrinewsletter.mailNews)
    VALUES(NEW.id,NEW.mail);
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `after_UserMail_insert`;
DELIMITER $$
CREATE TRIGGER `after_UserMail_insert` AFTER INSERT ON `utilisateurs` FOR EACH ROW BEGIN
    INSERT INTO inscrinewsletter(inscrinewsletter.idUser, inscrinewsletter.mailNews)
    VALUES(NEW.id,NEW.mail);
END
$$
DELIMITER ;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `demandedesactivationcompte`
--
ALTER TABLE `demandedesactivationcompte`
  ADD CONSTRAINT `demandedesactivationcompte_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `utilisateurs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `historiqueconnexionuser`
--
ALTER TABLE `historiqueconnexionuser`
  ADD CONSTRAINT `fk_idU_user` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateurs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `inscrinewsletter`
--
ALTER TABLE `inscrinewsletter`
  ADD CONSTRAINT `fk_idU_user_news` FOREIGN KEY (`idUser`) REFERENCES `utilisateurs` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

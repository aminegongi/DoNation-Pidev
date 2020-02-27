-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  jeu. 27 fév. 2020 à 18:54
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
-- Structure de la table `apps_countries`
--

DROP TABLE IF EXISTS `apps_countries`;
CREATE TABLE IF NOT EXISTS `apps_countries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country_code` varchar(2) NOT NULL DEFAULT '',
  `country_name` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `apps_countries`
--

INSERT INTO `apps_countries` (`id`, `country_code`, `country_name`) VALUES
(1, 'AF', 'Afghanistan'),
(2, 'AL', 'Albania'),
(3, 'DZ', 'Algeria'),
(4, 'DS', 'American Samoa'),
(5, 'AD', 'Andorra'),
(6, 'AO', 'Angola'),
(7, 'AI', 'Anguilla'),
(8, 'AQ', 'Antarctica'),
(9, 'AG', 'Antigua and Barbuda'),
(10, 'AR', 'Argentina'),
(11, 'AM', 'Armenia'),
(12, 'AW', 'Aruba'),
(13, 'AU', 'Australia'),
(14, 'AT', 'Austria'),
(15, 'AZ', 'Azerbaijan'),
(16, 'BS', 'Bahamas'),
(17, 'BH', 'Bahrain'),
(18, 'BD', 'Bangladesh'),
(19, 'BB', 'Barbados'),
(20, 'BY', 'Belarus'),
(21, 'BE', 'Belgium'),
(22, 'BZ', 'Belize'),
(23, 'BJ', 'Benin'),
(24, 'BM', 'Bermuda'),
(25, 'BT', 'Bhutan'),
(26, 'BO', 'Bolivia'),
(27, 'BA', 'Bosnia and Herzegovina'),
(28, 'BW', 'Botswana'),
(29, 'BV', 'Bouvet Island'),
(30, 'BR', 'Brazil'),
(31, 'IO', 'British Indian Ocean Territory'),
(32, 'BN', 'Brunei Darussalam'),
(33, 'BG', 'Bulgaria'),
(34, 'BF', 'Burkina Faso'),
(35, 'BI', 'Burundi'),
(36, 'KH', 'Cambodia'),
(37, 'CM', 'Cameroon'),
(38, 'CA', 'Canada'),
(39, 'CV', 'Cape Verde'),
(40, 'KY', 'Cayman Islands'),
(41, 'CF', 'Central African Republic'),
(42, 'TD', 'Chad'),
(43, 'CL', 'Chile'),
(44, 'CN', 'China'),
(45, 'CX', 'Christmas Island'),
(46, 'CC', 'Cocos (Keeling) Islands'),
(47, 'CO', 'Colombia'),
(48, 'KM', 'Comoros'),
(49, 'CD', 'Democratic Republic of the Congo'),
(50, 'CG', 'Republic of Congo'),
(51, 'CK', 'Cook Islands'),
(52, 'CR', 'Costa Rica'),
(53, 'HR', 'Croatia (Hrvatska)'),
(54, 'CU', 'Cuba'),
(55, 'CY', 'Cyprus'),
(56, 'CZ', 'Czech Republic'),
(57, 'DK', 'Denmark'),
(58, 'DJ', 'Djibouti'),
(59, 'DM', 'Dominica'),
(60, 'DO', 'Dominican Republic'),
(61, 'TP', 'East Timor'),
(62, 'EC', 'Ecuador'),
(63, 'EG', 'Egypt'),
(64, 'SV', 'El Salvador'),
(65, 'GQ', 'Equatorial Guinea'),
(66, 'ER', 'Eritrea'),
(67, 'EE', 'Estonia'),
(68, 'ET', 'Ethiopia'),
(69, 'FK', 'Falkland Islands (Malvinas)'),
(70, 'FO', 'Faroe Islands'),
(71, 'FJ', 'Fiji'),
(72, 'FI', 'Finland'),
(73, 'FR', 'France'),
(74, 'FX', 'France, Metropolitan'),
(75, 'GF', 'French Guiana'),
(76, 'PF', 'French Polynesia'),
(77, 'TF', 'French Southern Territories'),
(78, 'GA', 'Gabon'),
(79, 'GM', 'Gambia'),
(80, 'GE', 'Georgia'),
(81, 'DE', 'Germany'),
(82, 'GH', 'Ghana'),
(83, 'GI', 'Gibraltar'),
(84, 'GK', 'Guernsey'),
(85, 'GR', 'Greece'),
(86, 'GL', 'Greenland'),
(87, 'GD', 'Grenada'),
(88, 'GP', 'Guadeloupe'),
(89, 'GU', 'Guam'),
(90, 'GT', 'Guatemala'),
(91, 'GN', 'Guinea'),
(92, 'GW', 'Guinea-Bissau'),
(93, 'GY', 'Guyana'),
(94, 'HT', 'Haiti'),
(95, 'HM', 'Heard and Mc Donald Islands'),
(96, 'HN', 'Honduras'),
(97, 'HK', 'Hong Kong'),
(98, 'HU', 'Hungary'),
(99, 'IS', 'Iceland'),
(100, 'IN', 'India'),
(101, 'IM', 'Isle of Man'),
(102, 'ID', 'Indonesia'),
(103, 'IR', 'Iran (Islamic Republic of)'),
(104, 'IQ', 'Iraq'),
(105, 'IE', 'Ireland'),
(106, 'IL', 'Israel'),
(107, 'IT', 'Italy'),
(108, 'CI', 'Ivory Coast'),
(109, 'JE', 'Jersey'),
(110, 'JM', 'Jamaica'),
(111, 'JP', 'Japan'),
(112, 'JO', 'Jordan'),
(113, 'KZ', 'Kazakhstan'),
(114, 'KE', 'Kenya'),
(115, 'KI', 'Kiribati'),
(116, 'KP', 'Korea, Democratic People\'s Republic of'),
(117, 'KR', 'Korea, Republic of'),
(118, 'XK', 'Kosovo'),
(119, 'KW', 'Kuwait'),
(120, 'KG', 'Kyrgyzstan'),
(121, 'LA', 'Lao People\'s Democratic Republic'),
(122, 'LV', 'Latvia'),
(123, 'LB', 'Lebanon'),
(124, 'LS', 'Lesotho'),
(125, 'LR', 'Liberia'),
(126, 'LY', 'Libyan Arab Jamahiriya'),
(127, 'LI', 'Liechtenstein'),
(128, 'LT', 'Lithuania'),
(129, 'LU', 'Luxembourg'),
(130, 'MO', 'Macau'),
(131, 'MK', 'North Macedonia'),
(132, 'MG', 'Madagascar'),
(133, 'MW', 'Malawi'),
(134, 'MY', 'Malaysia'),
(135, 'MV', 'Maldives'),
(136, 'ML', 'Mali'),
(137, 'MT', 'Malta'),
(138, 'MH', 'Marshall Islands'),
(139, 'MQ', 'Martinique'),
(140, 'MR', 'Mauritania'),
(141, 'MU', 'Mauritius'),
(142, 'TY', 'Mayotte'),
(143, 'MX', 'Mexico'),
(144, 'FM', 'Micronesia, Federated States of'),
(145, 'MD', 'Moldova, Republic of'),
(146, 'MC', 'Monaco'),
(147, 'MN', 'Mongolia'),
(148, 'ME', 'Montenegro'),
(149, 'MS', 'Montserrat'),
(150, 'MA', 'Morocco'),
(151, 'MZ', 'Mozambique'),
(152, 'MM', 'Myanmar'),
(153, 'NA', 'Namibia'),
(154, 'NR', 'Nauru'),
(155, 'NP', 'Nepal'),
(156, 'NL', 'Netherlands'),
(157, 'AN', 'Netherlands Antilles'),
(158, 'NC', 'New Caledonia'),
(159, 'NZ', 'New Zealand'),
(160, 'NI', 'Nicaragua'),
(161, 'NE', 'Niger'),
(162, 'NG', 'Nigeria'),
(163, 'NU', 'Niue'),
(164, 'NF', 'Norfolk Island'),
(165, 'MP', 'Northern Mariana Islands'),
(166, 'NO', 'Norway'),
(167, 'OM', 'Oman'),
(168, 'PK', 'Pakistan'),
(169, 'PW', 'Palau'),
(170, 'PS', 'Palestine'),
(171, 'PA', 'Panama'),
(172, 'PG', 'Papua New Guinea'),
(173, 'PY', 'Paraguay'),
(174, 'PE', 'Peru'),
(175, 'PH', 'Philippines'),
(176, 'PN', 'Pitcairn'),
(177, 'PL', 'Poland'),
(178, 'PT', 'Portugal'),
(179, 'PR', 'Puerto Rico'),
(180, 'QA', 'Qatar'),
(181, 'RE', 'Reunion'),
(182, 'RO', 'Romania'),
(183, 'RU', 'Russian Federation'),
(184, 'RW', 'Rwanda'),
(185, 'KN', 'Saint Kitts and Nevis'),
(186, 'LC', 'Saint Lucia'),
(187, 'VC', 'Saint Vincent and the Grenadines'),
(188, 'WS', 'Samoa'),
(189, 'SM', 'San Marino'),
(190, 'ST', 'Sao Tome and Principe'),
(191, 'SA', 'Saudi Arabia'),
(192, 'SN', 'Senegal'),
(193, 'RS', 'Serbia'),
(194, 'SC', 'Seychelles'),
(195, 'SL', 'Sierra Leone'),
(196, 'SG', 'Singapore'),
(197, 'SK', 'Slovakia'),
(198, 'SI', 'Slovenia'),
(199, 'SB', 'Solomon Islands'),
(200, 'SO', 'Somalia'),
(201, 'ZA', 'South Africa'),
(202, 'GS', 'South Georgia South Sandwich Islands'),
(203, 'SS', 'South Sudan'),
(204, 'ES', 'Spain'),
(205, 'LK', 'Sri Lanka'),
(206, 'SH', 'St. Helena'),
(207, 'PM', 'St. Pierre and Miquelon'),
(208, 'SD', 'Sudan'),
(209, 'SR', 'Suriname'),
(210, 'SJ', 'Svalbard and Jan Mayen Islands'),
(211, 'SZ', 'Swaziland'),
(212, 'SE', 'Sweden'),
(213, 'CH', 'Switzerland'),
(214, 'SY', 'Syrian Arab Republic'),
(215, 'TW', 'Taiwan'),
(216, 'TJ', 'Tajikistan'),
(217, 'TZ', 'Tanzania, United Republic of'),
(218, 'TH', 'Thailand'),
(219, 'TG', 'Togo'),
(220, 'TK', 'Tokelau'),
(221, 'TO', 'Tonga'),
(222, 'TT', 'Trinidad and Tobago'),
(223, 'TN', 'Tunisia'),
(224, 'TR', 'Turkey'),
(225, 'TM', 'Turkmenistan'),
(226, 'TC', 'Turks and Caicos Islands'),
(227, 'TV', 'Tuvalu'),
(228, 'UG', 'Uganda'),
(229, 'UA', 'Ukraine'),
(230, 'AE', 'United Arab Emirates'),
(231, 'GB', 'United Kingdom'),
(232, 'US', 'United States'),
(233, 'UM', 'United States minor outlying islands'),
(234, 'UY', 'Uruguay'),
(235, 'UZ', 'Uzbekistan'),
(236, 'VU', 'Vanuatu'),
(237, 'VA', 'Vatican City State'),
(238, 'VE', 'Venezuela'),
(239, 'VN', 'Vietnam'),
(240, 'VG', 'Virgin Islands (British)'),
(241, 'VI', 'Virgin Islands (U.S.)'),
(242, 'WF', 'Wallis and Futuna Islands'),
(243, 'EH', 'Western Sahara'),
(244, 'YE', 'Yemen'),
(245, 'ZM', 'Zambia'),
(246, 'ZW', 'Zimbabwe');

-- --------------------------------------------------------

--
-- Structure de la table `cagnotte`
--

DROP TABLE IF EXISTS `cagnotte`;
CREATE TABLE IF NOT EXISTS `cagnotte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `id_categorie` int(11) NOT NULL,
  `date_de_creation` date NOT NULL,
  `date_de_debut` date NOT NULL,
  `date_de_fin` date NOT NULL,
  `montant_demande` double NOT NULL,
  `montant_actuel` double NOT NULL,
  `id_proprietaire` int(11) NOT NULL,
  `id_organisation` int(11) NOT NULL,
  `etat` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_categorie` (`id_categorie`)
) ENGINE=MyISAM AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cagnotte`
--

INSERT INTO `cagnotte` (`id`, `nom`, `id_categorie`, `date_de_creation`, `date_de_debut`, `date_de_fin`, `montant_demande`, `montant_actuel`, `id_proprietaire`, `id_organisation`, `etat`) VALUES
(47, 'Chaise roulante', 2, '2020-02-27', '2020-02-25', '2020-03-25', 1500, 500, 1, 0, 0),
(48, 'Construction d\'une maison', 17, '2020-02-27', '2020-02-27', '2021-03-31', 30000, 4000, 1, 2, 1),
(49, 'Vetements pour 100 enfants', 1, '2020-02-27', '2020-02-27', '2020-05-27', 5000, 0, 1, 2, 1),
(50, 'Medicaments', 2, '2020-02-27', '2020-02-27', '2020-03-05', 500, 0, 1, 0, 0),
(51, 'Lancement d\'un mini-projet pour un SDF', 17, '2020-02-27', '2020-02-27', '2020-06-01', 8000, 1500, 1, 0, 0),
(52, 'Amelioration d\'un jardin publique', 18, '2020-02-27', '2020-02-27', '2020-04-01', 3000, 0, 1, 0, 0),
(53, 'PC Portables pour 10 etudiants', 18, '2020-02-27', '2020-02-27', '2020-04-01', 15000, 3500, 1, 2, 1),
(54, 'Operation medicale', 2, '2020-02-27', '2020-02-27', '2020-11-25', 300000, 20000, 1, 2, 1),
(55, 'Vetements pour 50 SDF', 17, '2020-02-27', '2020-01-06', '2020-02-25', 1500, 2000, 1, 2, 0),
(56, 'Construction d\'un hopital pour enfants', 18, '2020-02-27', '2020-02-24', '2022-01-01', 3000000, 50000, 1, 0, 0),
(57, 'Renouvellement d\'une ecole', 18, '2020-02-27', '2020-02-22', '2021-01-01', 500000, 10000, 1, 0, 0),
(58, 'Construction d\'un hopital d\'animaux', 18, '2020-02-27', '2020-02-21', '2021-01-01', 1000000, 0, 1, 0, 0),
(59, 'Journee Mondiale des Donneurs de Sang', 18, '2020-02-27', '2020-02-13', '2020-06-14', 10000, 1000, 1, 0, 0),
(60, 'Salle de jeux dans le village SOS Manouba', 1, '2020-02-27', '2020-02-13', '2020-06-20', 10000, 2000, 1, 0, 0),
(64, 'amineTest', 1, '2020-02-27', '2020-02-03', '2020-02-21', 989, 1231, 1, 2, 0);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nom` (`nom`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `nom`) VALUES
(92, 'AmineTest'),
(93, 'aqwzsxdc'),
(38, 'bricolage'),
(87, 'categorietest'),
(33, 'education'),
(80, 'f'),
(81, 'faa'),
(84, 'feafaaa'),
(85, 'hedicatEEE'),
(34, 'informatique'),
(91, 'opopmmmpopo'),
(79, 'x'),
(75, 'yx'),
(78, 'z'),
(74, 'zxz');

-- --------------------------------------------------------

--
-- Structure de la table `categoriecagnotte`
--

DROP TABLE IF EXISTS `categoriecagnotte`;
CREATE TABLE IF NOT EXISTS `categoriecagnotte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categoriecagnotte`
--

INSERT INTO `categoriecagnotte` (`id`, `nom`, `description`) VALUES
(1, 'SOS', 'SOS'),
(2, 'Maladie', 'Les maladies'),
(17, 'Pauvrete', NULL),
(18, 'Communaute', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `categorieemplois`
--

DROP TABLE IF EXISTS `categorieemplois`;
CREATE TABLE IF NOT EXISTS `categorieemplois` (
  `id_categorie_emplois` int(11) NOT NULL AUTO_INCREMENT,
  `titre_categorie` varchar(255) NOT NULL,
  `description_categorie` varchar(255) NOT NULL,
  PRIMARY KEY (`id_categorie_emplois`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorieemplois`
--

INSERT INTO `categorieemplois` (`id_categorie_emplois`, `titre_categorie`, `description_categorie`) VALUES
(23, 'titre', 'descreption'),
(25, 'titre2', 'descreption2'),
(27, 'titre4', 'descreption4'),
(28, 'titre5', 'descreption5'),
(31, 'jj', 'rr'),
(32, 'hechem', 'hechem');

-- --------------------------------------------------------

--
-- Structure de la table `categorie_emplois`
--

DROP TABLE IF EXISTS `categorie_emplois`;
CREATE TABLE IF NOT EXISTS `categorie_emplois` (
  `id_categorie_emplois` int(11) NOT NULL AUTO_INCREMENT,
  `titre_categorie` varchar(255) NOT NULL,
  `description_categorie` varchar(255) NOT NULL,
  PRIMARY KEY (`id_categorie_emplois`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie_emplois`
--

INSERT INTO `categorie_emplois` (`id_categorie_emplois`, `titre_categorie`, `description_categorie`) VALUES
(11, 'DIVERS', 'DIVERS'),
(22, 'INFORMATIQUE', 'INFORMATIQUE'),
(23, 'industrie', 'INDUSTRIE'),
(35, 'SANTE', 'SANTE'),
(37, 'allloalao', 'guauabuafbiufa');

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_demande` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `valeur` text,
  PRIMARY KEY (`id`),
  KEY `fk_commentaire_demande` (`id_demande`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

DROP TABLE IF EXISTS `demande`;
CREATE TABLE IF NOT EXISTS `demande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_categorie` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `titre` varchar(40) DEFAULT NULL,
  `description` text,
  `etat` enum('VISIBLE','VALIDE','SIGNALEE') DEFAULT NULL,
  `nb_reactions` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_categorie` (`id_categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `demande`
--

INSERT INTO `demande` (`id`, `id_categorie`, `id_user`, `titre`, `description`, `etat`, `nb_reactions`) VALUES
(18, 38, 2, 'demande bricolage', 'aider moi a ...', 'VISIBLE', 12),
(19, 33, 2, 'besoin d\'aide en physique', 'mes notes  en physique sont catasrophiques...', 'VISIBLE', 12),
(21, 38, 100, 'demande bricolage', 'aider moi a ...', 'SIGNALEE', 0),
(22, 38, 2, 'demande bricolage', 'aider moi a ...', 'VALIDE', 5),
(23, 38, 2, 'demande bricolage', 'aider moi a ...', 'VISIBLE', 3),
(24, 34, 2, 'demande last', 'description last', 'VISIBLE', 7),
(25, 33, 2, 'besoin d\'aide en physique', 'Le lorem ipsum est, en imprimerie, une suite de mots sans signification utilisée à titre provisoire pour calibrer une mise en page, le texte définitif venant remplacer le faux-texte dès qu\'il est prêt ou que la mise en page est achevée. Généralement, on utilise un texte en faux latin, le Lorem ipsum ou Lipsum', 'VISIBLE', 2),
(26, 33, 2, 'besoin d\'aide en physique', 'Le lorem ipsum est, en imprimerie, une suite de mots sans signification utilisée à titre provisoire pour calibrer une mise en page, le texte définitif venant remplacer le faux-texte dès qu\'il est prêt ou que la mise en page est achevée. Généralement, on utilise un texte en faux latin, le Lorem ipsum ou Lipsum', 'VISIBLE', 1),
(27, 33, 2, 'besoin d\'aide en physique', 'Le lorem ipsum est, en imprimerie, une suite de mots sans signification utilisée à titre provisoire pour calibrer une mise en page, le texte définitif venant remplacer le faux-texte dès qu\'il est prêt ou que la mise en page est achevée. Généralement, on utilise un texte en faux latin, le Lorem ipsum ou Lipsum', 'VISIBLE', 2),
(28, 33, 2, 'besoin d\'aide en physique', 'Le lorem ipsum est, en imprimerie, une suite de mots sans signification utilisée à titre provisoire pour calibrer une mise en page, le texte définitif venant remplacer le faux-texte dès qu\'il est prêt ou que la mise en page est achevée. Généralement, on utilise un texte en faux latin, le Lorem ipsum ou Lipsum', 'VISIBLE', 0),
(29, 33, 2, 'besoin d\'aide en physique', 'Le lorem ipsum est, en imprimerie, une suite de mots sans signification utilisée à titre provisoire pour calibrer une mise en page, le texte définitif venant remplacer le faux-texte dès qu\'il est prêt ou que la mise en page est achevée. Généralement, on utilise un texte en faux latin, le Lorem ipsum ou Lipsum', 'VISIBLE', 0),
(30, 33, 2, 'besoin d\'aide en physique', 'Le lorem ipsum est, en imprimerie, une suite de mots sans signification utilisée à titre provisoire pour calibrer une mise en page, le texte définitif venant remplacer le faux-texte dès qu\'il est prêt ou que la mise en page est achevée. Généralement, on utilise un texte en faux latin, le Lorem ipsum ou Lipsum', 'VISIBLE', 1),
(31, 33, 2, 'besoin d\'aide en physique', 'Le lorem ipsum est, en imprimerie, une suite de mots sans signification utilisée à titre provisoire pour calibrer une mise en page, le texte définitif venant remplacer le faux-texte dès qu\'il est prêt ou que la mise en page est achevée. Généralement, on utilise un texte en faux latin, le Lorem ipsum ou Lipsum', 'VISIBLE', 1),
(32, 33, 2, 'besoin d\'aide en physique', 'Le lorem ipsum est, en imprimerie, une suite de mots sans signification utilisée à titre provisoire pour calibrer une mise en page, le texte définitif venant remplacer le faux-texte dès qu\'il est prêt ou que la mise en page est achevée. Généralement, on utilise un texte en faux latin, le Lorem ipsum ou Lipsum', 'VISIBLE', 0),
(33, 33, 2, 'besoin d\'aide en physique', 'Le lorem ipsum est, en imprimerie, une suite de mots sans signification utilisée à titre provisoire pour calibrer une mise en page, le texte définitif venant remplacer le faux-texte dès qu\'il est prêt ou que la mise en page est achevée. Généralement, on utilise un texte en faux latin, le Lorem ipsum ou Lipsum', 'VISIBLE', 0),
(34, 34, 3, 'demande signale ', 'signale test', 'SIGNALEE', 0),
(35, 34, 1, 'demande user test  ', 'user test', 'SIGNALEE', 0),
(36, 38, 100, 'demande user test  ', 'user test', 'SIGNALEE', 0),
(37, 38, 80, 'demande user test  ', 'user test', 'SIGNALEE', 0),
(38, 38, 100, 'demande user test  ', 'user test', 'SIGNALEE', 0),
(39, 38, 100, 'demande user test  ', 'user test', 'SIGNALEE', 0),
(40, 38, 100, 'demande user test  ', 'user test', 'SIGNALEE', 0),
(41, 38, 105, 'demande sig test  ', 'sig test', 'SIGNALEE', 0),
(42, 38, 2, 'demande sig test  ', 'sig test', 'VISIBLE', 1),
(43, 38, 100, 'demande sig test  ', 'sig test', 'VISIBLE', 2),
(44, 38, 2, 'demande affiche user', 'mes notes  en physique sont catasrophiques...', 'VISIBLE', 0),
(45, 38, 2, 'demande sig test  ', 'sig test', 'VISIBLE', 0),
(46, 33, 2, 'titre clavier', 'description clavier', 'VISIBLE', 0),
(47, 38, 2, 'test brico clavier', 'test brico clavier description', 'VISIBLE', 0),
(48, 34, 2, 'info clavier', 'info clavier desc', 'VISIBLE', 0),
(49, 33, 2, 'testsms', 'testsms', 'VISIBLE', 0),
(50, 87, 2, 'demandepi', 'desci pi', 'VISIBLE', 0),
(51, 38, 2, 'test', 'tt', 'VISIBLE', 0),
(52, 38, 2, 'saisir titremmmmmm', 'mmmmmmmmsaisir description', 'VISIBLE', 2),
(53, 38, 39, 'azaeaz', 'azaez', 'VISIBLE', 0),
(54, NULL, 41, 'saisir titregegrege', 'saisir descriptiongeggegegeg', 'VISIBLE', 0),
(55, 38, 2, 'AmineTest', 'asasasas', 'VISIBLE', 0),
(56, 38, 2, 'azaza', 'azazazeqsddqffsf', 'VISIBLE', 1),
(58, 38, 2, 'titre demande', '', 'VISIBLE', 0),
(59, NULL, 2, 'aa', 'gghg', 'SIGNALEE', 0),
(60, 38, 2, 'zgzgzrg', 'grzgz', 'VISIBLE', 0),
(61, 38, 2, 'molo', 'molom', 'SIGNALEE', 0),
(62, 92, 41, 'aqwzsx', 'aqwzsx', 'VISIBLE', 0),
(63, 92, 41, 'aqwzsxzz', 'aqwzsxzzzz', 'VISIBLE', 0);

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
-- Structure de la table `donations`
--

DROP TABLE IF EXISTS `donations`;
CREATE TABLE IF NOT EXISTS `donations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_cagnotte` int(11) NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `montant` double NOT NULL,
  `date_don` date NOT NULL,
  `methode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_categorie_cagnotte` (`id_cagnotte`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `donations`
--

INSERT INTO `donations` (`id`, `id_cagnotte`, `id_utilisateur`, `nom`, `montant`, `date_don`, `methode`) VALUES
(1, 25, 1, 'Ahmed', 500, '2020-02-21', 'PayPal'),
(2, 25, 1, 'Ahmed', 500, '2020-02-21', 'PayPal'),
(3, 23, 1, 'Anonyme', 100, '2020-02-21', 'PayPal'),
(4, 23, 1, 'Anonyme', 500, '2020-02-21', 'PayPal'),
(5, 23, 1, 'Anonyme', 500, '2020-02-21', 'PayPal'),
(6, 23, 1, 'Anonyme', 5000, '2020-02-21', 'PayPal'),
(7, 25, 1, 'Validation', 2500, '2020-02-21', 'PayPal'),
(8, 37, 1, 'Anonyme', 2500, '2020-02-21', 'PayPal'),
(9, 25, 1, '55', 20, '2020-02-21', 'PayPal'),
(10, 25, 1, '58585', 66966, '2020-02-21', 'PayPal'),
(11, 37, 1, 'Anonyme', 88, '2020-02-21', 'PayPal'),
(12, 25, 1, 'Monji Slim', 6000, '2020-02-21', 'PayPal'),
(13, 39, 1, 'Ahmed', 500, '2020-02-25', 'PayPal'),
(14, 39, 1, 'Anonyme', 7000, '2020-02-25', 'PayPal'),
(15, 40, 1, 'spark', 121, '2020-02-25', 'PayPal'),
(16, 40, 1, 'spark', 121, '2020-02-25', 'PayPal'),
(17, 64, 1, 'amine', 1231, '2020-02-27', 'PayPal');

-- --------------------------------------------------------

--
-- Structure de la table `donrestaurant`
--

DROP TABLE IF EXISTS `donrestaurant`;
CREATE TABLE IF NOT EXISTS `donrestaurant` (
  `idDon` int(20) NOT NULL AUTO_INCREMENT,
  `idResto` int(20) NOT NULL,
  `idUser` int(11) NOT NULL,
  `montant` decimal(9,3) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idDon`),
  KEY `fk_DonRestaurant_utilisateurs_Resto` (`idResto`),
  KEY `fk_DonRestaurant_utilisateurs_User` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `donrestaurant`
--

INSERT INTO `donrestaurant` (`idDon`, `idResto`, `idUser`, `montant`, `date`) VALUES
(1, 15, 20, '1.000', '2020-02-20 17:25:13'),
(2, 15, 25, '1.500', '2020-02-20 17:25:13'),
(3, 15, 20, '3.000', '2020-02-21 05:15:28'),
(4, 15, 20, '1.000', '2020-02-21 05:26:12'),
(5, 15, 20, '2.400', '2020-02-21 06:33:50'),
(6, 15, 20, '2.400', '2020-02-21 06:35:36'),
(7, 15, 20, '2.400', '2020-02-21 06:41:52'),
(8, 15, 20, '2.400', '2020-02-21 06:42:07'),
(9, 15, 20, '2.400', '2020-02-21 07:18:10'),
(10, 15, 20, '2.400', '2020-02-21 07:24:07'),
(11, 15, 20, '2.400', '2020-02-21 07:42:59'),
(12, 15, 20, '2.400', '2020-02-21 07:43:40'),
(13, 15, 20, '2.400', '2020-02-21 07:43:56'),
(14, 15, 20, '2.400', '2020-02-21 07:58:28'),
(15, 15, 20, '2.400', '2020-02-21 08:16:07'),
(16, 15, 20, '5.000', '2020-02-21 08:16:36'),
(17, 15, 38, '12.000', '2020-02-24 21:49:42'),
(18, 15, 38, '1.000', '2020-02-24 21:53:22'),
(19, 41, 38, '2.000', '2020-02-24 21:56:40'),
(20, 41, 38, '2.000', '2020-02-24 22:01:10'),
(21, 41, 38, '3.000', '2020-02-24 22:05:57'),
(22, 41, 38, '99.000', '2020-02-25 01:06:20'),
(23, 41, 38, '121.000', '2020-02-27 15:33:49');

-- --------------------------------------------------------

--
-- Structure de la table `emplois`
--

DROP TABLE IF EXISTS `emplois`;
CREATE TABLE IF NOT EXISTS `emplois` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `Photo` varchar(255) NOT NULL,
  `salaire` double NOT NULL,
  `emplacement` enum('Tunis','Mahdia','Sousse','Ariana','Sfax','Beja','BenArous','Bizerte','Gabes','Gafsa','Jendouba','Kairouan','Kasserine','Kebili','Kef','Manouba','Medenine','Monastir','Nabeul','SidiBouzid','Siliana','Tataouine','Tozeur','Zaghouan') NOT NULL,
  `TypeDemploi` enum('Offre','Demande') NOT NULL,
  `TypeContrat` enum('ContratDureeIndeterminee','Contratdureedeterminee','ContratTravailTemporaire','ContratApprentissage','ContratProfessionnalisation','ContratUniqueInsertion') NOT NULL,
  `idcategorie` int(11) DEFAULT NULL,
  `id_utilisateur` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_emplois_categorieemplois` (`idcategorie`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `emplois`
--

INSERT INTO `emplois` (`id`, `titre`, `description`, `Photo`, `salaire`, `emplacement`, `TypeDemploi`, `TypeContrat`, `idcategorie`, `id_utilisateur`) VALUES
(3, 'ezezr', 'zerzrzr', 'picture.png', 121, 'Tunis', 'Demande', 'ContratUniqueInsertion', 35, 0),
(4, 'ezezrtrtrtr', 'zerzrzrrtrtrt', 'picture.png', 1219, 'Tunis', 'Demande', 'ContratDureeIndeterminee', 22, 0),
(5, 'testIII77', 'testIII', 'shane-rounce-DNkoNXQti3c-unsplash.jpg', 12111, 'Monastir', 'Offre', 'ContratUniqueInsertion', 22, 38),
(6, 'aqazas', 'ezrzrr', 'Couleur.PNG', 12311, 'Kairouan', 'Demande', 'ContratUniqueInsertion', 35, 38),
(12, 'ds', 'sd', 'ds', 777, 'Ariana', 'Offre', 'ContratDureeIndeterminee', 22, 7),
(13, 'ds', 'sd', 'ds', 777, 'Sfax', 'Offre', 'ContratDureeIndeterminee', 22, 7),
(14, 'fdxg', 'gd', 'gd', 7777, 'Beja', 'Offre', 'ContratDureeIndeterminee', 23, 2),
(15, 'fdxg', 'gd', 'gd', 7777, 'BenArous', 'Offre', 'ContratDureeIndeterminee', 23, 2),
(16, 'fdxg', 'gd', 'gd', 7777, 'Bizerte', 'Offre', 'ContratDureeIndeterminee', 23, 2),
(17, 'fdxg', 'gd', 'gd', 7777, 'Gabes', 'Offre', 'ContratDureeIndeterminee', 23, 2),
(18, 'fdxg', 'gd', 'gd', 7777, 'Gafsa', 'Offre', 'ContratDureeIndeterminee', 23, 2),
(19, 'fdxg', 'gd', 'gd', 7777, 'Jendouba', 'Offre', 'ContratDureeIndeterminee', 23, 2),
(20, 'fdxg', 'gd', 'gd', 7777, 'Tunis', 'Offre', 'ContratDureeIndeterminee', 23, 2),
(21, 'fdxg', 'gd', 'gd', 7777, 'Kasserine', 'Offre', 'ContratDureeIndeterminee', 23, 2),
(22, 'fdxg', 'gd', 'gd', 7777, 'Kebili', 'Offre', 'ContratDureeIndeterminee', 23, 2),
(23, 'fdxg', 'gd', 'gd', 7777, 'Kef', 'Offre', 'ContratDureeIndeterminee', 23, 2),
(26, 'hfg', 'dfg', 'Offre-emploi.jpg', 77, 'Beja', 'Offre', 'ContratDureeIndeterminee', 11, 42),
(27, 'hfg', 'dfg', 'Offre-emploi.jpg', 77, 'Zaghouan', 'Offre', 'ContratDureeIndeterminee', 11, 42),
(28, 'hfg', 'dfg', 'Offre-emploi.jpg', 77, 'Tozeur', 'Offre', 'ContratDureeIndeterminee', 11, 42),
(29, 'ee', 'ee', 'Offre-emploi.jpg', 122, 'Tozeur', 'Offre', 'ContratTravailTemporaire', 22, 42),
(30, 'aa', '11', 'Offre-emploi.jpg', 454, 'Siliana', 'Demande', 'ContratProfessionnalisation', 11, 42),
(31, 'ss', 'ss', 'ss', 77, 'Nabeul', 'Offre', 'ContratDureeIndeterminee', 35, 2),
(34, 'edsds', 'ezsd', 'download.jpg', 788, 'Tataouine', 'Demande', 'Contratdureedeterminee', 22, 42),
(36, 'fd', 'df', 'fd', 44, 'Tunis', 'Offre', 'ContratDureeIndeterminee', 23, 2),
(37, 'fd', 'df', 'fd', 44, 'Tunis', 'Offre', 'ContratDureeIndeterminee', 23, 2),
(38, 'sdsd', 'dssd', 'download.jpg', 11, 'Beja', 'Demande', 'Contratdureedeterminee', 22, 42),
(39, 'dxcfh', 'cfncfh', 'ghost5.png', 121, 'Beja', 'Demande', 'ContratTravailTemporaire', 23, 41);

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
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8;

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
(17, 9, '196.225.167.97', '2020-02-14 11:00:59'),
(18, 33, '94.177.243.143', '2020-02-19 14:38:47'),
(19, 33, 'IP Prob', '2020-02-19 14:39:45'),
(20, 39, '94.177.243.143', '2020-02-20 20:18:41'),
(21, 39, '94.177.243.143', '2020-02-21 02:02:00'),
(22, 39, '94.177.243.143', '2020-02-21 02:05:25'),
(23, 39, '94.177.243.143', '2020-02-21 05:20:08'),
(24, 39, '94.177.243.143', '2020-02-21 05:36:57'),
(25, 39, '94.177.243.143', '2020-02-21 05:37:17'),
(26, 39, '94.177.243.143', '2020-02-21 05:37:31'),
(27, 39, '94.177.243.143', '2020-02-21 05:59:14'),
(28, 39, '94.177.243.143', '2020-02-21 06:12:05'),
(29, 39, '94.177.243.143', '2020-02-21 06:13:48'),
(30, 39, '94.177.243.143', '2020-02-21 07:36:22'),
(31, 39, '94.177.243.143', '2020-02-21 07:44:42'),
(32, 39, '94.177.243.143', '2020-02-21 07:46:13'),
(33, 40, '160.159.50.110', '2020-02-21 08:40:55'),
(34, 40, '94.177.243.143', '2020-02-21 08:40:55'),
(35, 39, '196.232.230.188', '2020-02-23 14:16:07'),
(36, 39, '41.226.11.245', '2020-02-24 19:03:15'),
(37, 39, '41.226.11.245', '2020-02-24 19:04:46'),
(38, 39, '41.226.11.245', '2020-02-24 19:20:21'),
(39, 39, '41.226.11.245', '2020-02-24 19:21:16'),
(40, 38, '41.226.11.245', '2020-02-24 19:21:40'),
(41, 38, '41.226.11.245', '2020-02-24 19:22:15'),
(42, 38, '41.226.11.245', '2020-02-24 19:22:46'),
(43, 38, '41.226.11.245', '2020-02-24 19:23:45'),
(44, 38, '41.226.11.245', '2020-02-24 19:24:57'),
(45, 38, '41.226.11.245', '2020-02-24 19:26:11'),
(46, 38, '41.226.11.245', '2020-02-24 19:40:11'),
(47, 38, '41.226.11.245', '2020-02-24 19:56:23'),
(48, 38, '41.226.11.245', '2020-02-24 20:00:24'),
(49, 38, '41.226.11.245', '2020-02-24 20:03:20'),
(50, 38, '41.226.11.245', '2020-02-24 20:40:09'),
(51, 38, '41.226.11.245', '2020-02-24 20:44:40'),
(52, 38, '41.226.11.245', '2020-02-24 20:45:21'),
(53, 38, '41.226.11.245', '2020-02-24 20:47:07'),
(54, 38, '41.226.11.245', '2020-02-24 20:48:07'),
(55, 38, '41.226.11.245', '2020-02-24 20:52:48'),
(56, 41, '41.226.11.245', '2020-02-24 20:56:01'),
(57, 41, '41.226.11.245', '2020-02-24 21:00:47'),
(58, 41, '41.226.11.245', '2020-02-24 21:05:26'),
(59, 41, '41.226.11.245', '2020-02-24 21:42:15'),
(60, 41, '41.226.11.245', '2020-02-24 21:44:13'),
(61, 41, '41.226.11.245', '2020-02-24 22:07:59'),
(62, 41, '41.226.11.245', '2020-02-24 22:14:17'),
(63, 41, '41.226.11.245', '2020-02-24 22:16:54'),
(64, 41, '41.226.11.245', '2020-02-24 22:18:18'),
(65, 39, '41.226.11.245', '2020-02-24 22:19:19'),
(66, 39, '41.226.11.245', '2020-02-24 22:20:02'),
(67, 41, 'IP Prob', '2020-02-24 22:53:57'),
(68, 41, '41.226.11.245', '2020-02-24 23:18:57'),
(69, 39, '41.226.11.245', '2020-02-24 23:46:33'),
(70, 39, '41.226.11.245', '2020-02-24 23:53:01'),
(71, 39, 'IP Prob', '2020-02-24 23:53:41'),
(72, 39, 'IP Prob', '2020-02-24 23:54:33'),
(73, 39, 'IP Prob', '2020-02-24 23:56:41'),
(74, 39, '41.226.11.245', '2020-02-25 00:02:28'),
(75, 39, '41.226.11.245', '2020-02-25 00:03:25'),
(76, 39, '41.226.11.245', '2020-02-25 00:04:29'),
(77, 41, '41.226.11.245', '2020-02-25 00:05:12'),
(78, 41, '41.226.11.245', '2020-02-25 00:39:29'),
(79, 41, '41.226.11.245', '2020-02-25 00:40:59'),
(80, 41, '41.226.11.245', '2020-02-25 00:41:31'),
(81, 41, '41.226.11.245', '2020-02-25 00:43:34'),
(82, 41, '41.226.11.245', '2020-02-25 00:47:47'),
(83, 39, 'IP Prob', '2020-02-25 11:54:41'),
(84, 39, 'IP Prob', '2020-02-25 11:55:19'),
(85, 39, 'IP Prob', '2020-02-25 19:18:16'),
(86, 39, '197.2.11.152', '2020-02-25 19:43:20'),
(87, 39, '197.2.11.152', '2020-02-25 19:43:57'),
(88, 39, '197.2.11.152', '2020-02-25 19:57:32'),
(89, 41, '197.2.11.152', '2020-02-25 21:08:39'),
(90, 41, '197.2.11.152', '2020-02-25 21:46:53'),
(91, 41, 'IP Prob', '2020-02-26 20:36:38'),
(92, 41, 'IP Prob', '2020-02-26 20:37:57'),
(93, 41, 'IP Prob', '2020-02-26 20:43:17'),
(94, 41, 'IP Prob', '2020-02-26 20:45:48'),
(95, 41, 'IP Prob', '2020-02-26 20:48:41'),
(96, 41, 'IP Prob', '2020-02-26 20:49:14'),
(97, 41, 'IP Prob', '2020-02-26 20:51:55'),
(98, 41, '41.226.11.245', '2020-02-26 21:05:30'),
(99, 41, '41.226.11.245', '2020-02-26 21:06:32'),
(100, 41, '41.226.11.245', '2020-02-26 21:10:54'),
(101, 41, '41.226.11.245', '2020-02-26 21:14:45'),
(102, 41, '41.226.11.245', '2020-02-26 21:15:57'),
(103, 39, '41.226.11.245', '2020-02-26 21:16:47'),
(104, 39, '41.226.11.245', '2020-02-26 21:18:23'),
(105, 39, '41.226.11.245', '2020-02-26 21:19:56'),
(106, 39, '41.226.11.245', '2020-02-26 21:21:27'),
(107, 39, '41.226.11.245', '2020-02-26 21:21:59'),
(108, 39, '41.226.11.245', '2020-02-26 21:23:26'),
(109, 39, '41.226.11.245', '2020-02-26 21:24:17'),
(110, 39, '41.226.11.245', '2020-02-26 21:25:07'),
(111, 39, '41.226.11.245', '2020-02-26 21:26:03'),
(112, 41, 'IP Prob', '2020-02-27 00:45:26'),
(113, 41, 'IP Prob', '2020-02-27 00:48:51'),
(114, 39, 'IP Prob', '2020-02-27 00:50:42'),
(115, 39, 'IP Prob', '2020-02-27 08:00:32'),
(116, 39, 'IP Prob', '2020-02-27 08:04:44'),
(117, 39, 'IP Prob', '2020-02-27 08:07:51'),
(118, 39, 'IP Prob', '2020-02-27 08:11:41'),
(119, 39, '41.226.11.245', '2020-02-27 10:56:28'),
(120, 39, '41.226.11.245', '2020-02-27 11:06:05'),
(121, 39, '41.226.11.245', '2020-02-27 11:10:19'),
(122, 39, '41.226.11.245', '2020-02-27 11:12:09'),
(123, 39, '41.226.11.245', '2020-02-27 11:16:32'),
(124, 39, '41.226.11.245', '2020-02-27 11:17:00'),
(125, 39, '41.226.11.245', '2020-02-27 11:21:02'),
(126, 39, '41.226.11.245', '2020-02-27 11:23:18'),
(127, 39, '41.226.11.245', '2020-02-27 11:24:10'),
(128, 39, '41.226.11.245', '2020-02-27 11:25:15'),
(129, 39, '41.226.11.245', '2020-02-27 11:30:21'),
(130, 39, '41.226.11.245', '2020-02-27 11:35:00'),
(131, 39, '41.226.11.245', '2020-02-27 11:35:34'),
(132, 39, '41.226.11.245', '2020-02-27 11:36:43'),
(133, 39, '41.226.11.245', '2020-02-27 11:51:31'),
(134, 39, '<html>', '2020-02-27 13:14:05'),
(135, 39, '<html>', '2020-02-27 13:18:06'),
(136, 39, '<html>', '2020-02-27 13:19:04'),
(137, 38, '<html>', '2020-02-27 13:41:46'),
(138, 38, '<html>', '2020-02-27 13:43:19'),
(139, 38, '<html>', '2020-02-27 13:44:18'),
(140, 38, '<html>', '2020-02-27 13:45:37'),
(141, 38, '<html>', '2020-02-27 13:51:05'),
(142, 38, '<html>', '2020-02-27 13:54:52'),
(143, 38, '<html>', '2020-02-27 14:04:47'),
(144, 38, '41.226.11.245', '2020-02-27 14:31:06'),
(145, 41, '41.226.11.245', '2020-02-27 14:32:53'),
(146, 41, '<html>', '2020-02-27 14:46:21'),
(147, 41, '<html>', '2020-02-27 14:56:24'),
(148, 41, '<html>', '2020-02-27 15:00:08'),
(149, 41, '<html>', '2020-02-27 15:04:44'),
(150, 41, '<html>', '2020-02-27 15:06:35'),
(151, 41, '<html>', '2020-02-27 15:07:34'),
(152, 41, '<html>', '2020-02-27 15:09:13'),
(153, 41, '<html>', '2020-02-27 15:10:01'),
(154, 41, '<html>', '2020-02-27 15:11:05'),
(155, 41, '<html>', '2020-02-27 15:14:20'),
(156, 41, '<html>', '2020-02-27 15:16:47'),
(157, 41, '<html>', '2020-02-27 15:19:02'),
(158, 41, '<html>', '2020-02-27 15:20:04'),
(159, 39, '<html>', '2020-02-27 15:29:46'),
(160, 41, '<html>', '2020-02-27 15:31:02'),
(161, 39, '<html>', '2020-02-27 15:32:05'),
(162, 41, '197.4.7.144', '2020-02-27 15:44:37'),
(163, 39, '197.4.7.144', '2020-02-27 15:47:53'),
(164, 41, '197.4.7.144', '2020-02-27 15:53:20'),
(165, 41, '197.4.7.144', '2020-02-27 17:06:58'),
(166, 41, '197.4.7.144', '2020-02-27 17:10:08'),
(167, 41, '197.4.7.144', '2020-02-27 17:22:11'),
(168, 41, '197.4.7.144', '2020-02-27 17:34:05');

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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `inscrinewsletter`
--

INSERT INTO `inscrinewsletter` (`id`, `idUser`, `mailNews`) VALUES
(1, 28, 'amine.gongi@esprit.tn'),
(2, 28, 'amine.gongi@esprit.tn'),
(3, 28, 'amine.gongi@esprit.tn'),
(4, 28, 'amine.gongi@esprit.tn'),
(5, 28, 'amine.gongi@esprit.tn'),
(6, 42, 'amine@gmail.com'),
(7, 42, 'amine@gmail.com'),
(8, 42, 'amine@gmail.com'),
(9, 43, 'rctccece@gmail.com'),
(10, 44, 'addadad@gmail.com'),
(11, 45, 'ammam@gmail.com'),
(12, 46, 'zfzfzfz@'),
(13, 47, 'azazaazaz@gmail.com'),
(14, 41, 'yessine.khanfir@esprit.tn'),
(15, 41, 'yessine.khanfir@esprit.tn'),
(16, 41, 'yessine.khanfir@esprit.tn'),
(17, 41, 'yessine.khanfir@esprit.tn'),
(18, 41, 'yessine.khanfir@esprit.tn'),
(19, 41, 'yessine.khanfir@esprit.tn'),
(20, 41, 'yessine.khanfir@esprit.tn'),
(21, 41, 'yessine.khanfir@esprit.tn'),
(22, 41, 'yessine.khanfir@esprit.tn'),
(23, 39, 'amingongie98gongi@gmail.com'),
(24, 39, 'amingongie98gongi@gmail.com'),
(25, 39, 'amingongie98gongi@gmail.com'),
(26, 48, 'amine.maalouuuf@esprit.tn'),
(27, 48, 'amine.maalouuuf@esprit.tn');

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `newsletter`
--

INSERT INTO `newsletter` (`id`, `libelle`, `objetMail`, `corpsMail`, `dateEnvoi`, `dateAjout`) VALUES
(2, 'est1', 'Objet du mai TEst1', 'corps du mail Test1', '2020-02-14', '2020-02-14 03:52:56'),
(3, 'TestMoAmine', 'Objet du mai TestMo', 'corps du mail TestMo', NULL, '2020-02-14 03:53:22'),
(4, 'Test1', 'Objet du mai TEst1', 'corps du mail Test1', NULL, '2020-02-14 04:16:04'),
(5, 'Test1', 'Objet du mai TEst1', 'corps du mail Test1', NULL, '2020-02-14 04:16:15'),
(6, 'Test1', 'Objet du mai TEst1', 'corps du mail Test1', NULL, '2020-02-14 04:16:44'),
(7, 'Test1', 'Objet du mai TEst1', 'corps du mail Test1', NULL, '2020-02-14 04:19:23'),
(8, 'Test1', 'Objet du mai TEst1', 'corps du mail Test1', NULL, '2020-02-14 04:20:07'),
(9, 'Test1', 'Objet du mai TEst1', 'corps du mail Test1', NULL, '2020-02-14 04:21:02'),
(10, 'Test1', 'Objet du mai TEst1', 'corps du mail Test1', NULL, '2020-02-14 04:34:13'),
(11, 'TestMo', 'Objet du mai TestMo', 'corps du mail TestMo', NULL, '2020-02-14 04:34:45'),
(12, 'TestMo', 'Objet du mai TestMo', 'corps du mail TestMo', NULL, '2020-02-14 11:02:47'),
(13, 'aaza', 'azaza', '<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><p><font face=\"Segoe UI\">azazazaza</font></p><p><font face=\"Segoe UI\"><b>azaza</b></font></p></body></html>', NULL, '2020-02-21 00:49:04'),
(14, 'azaza', 'azaza', '<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><p><font face=\"Segoe UI\">aazazazaz</font></p></body></html>', NULL, '2020-02-21 01:12:11'),
(15, 'azazasfsdfs', 'azazasfsdfsd', '<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><p><font face=\"Segoe UI\">aazazazazfdsfsfsf</font></p></body></html>', NULL, '2020-02-21 01:12:16'),
(16, 'xwqsqd', 'qdqdqd', '<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><p><font face=\"Segoe UI\">arez</font></p></body></html>', '2020-02-26', '2020-02-21 01:14:39'),
(18, 'PIDonation', 'DoNation', '<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><p><font face=\"Segoe UI\" size=\"5\"><b>Hello</b></font></p><p style=\"text-align: center;\"><font face=\"Segoe UI\"><b><i>Bonjour</i></b></font></p></body></html>', '2020-02-26', '2020-02-21 08:48:51');

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

DROP TABLE IF EXISTS `participation`;
CREATE TABLE IF NOT EXISTS `participation` (
  `id_demande` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_demande`,`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `participation`
--

INSERT INTO `participation` (`id_demande`, `id_user`) VALUES
(19, 1),
(19, 2),
(21, 1),
(22, 1),
(22, 2);

-- --------------------------------------------------------

--
-- Structure de la table `publicationdon`
--

DROP TABLE IF EXISTS `publicationdon`;
CREATE TABLE IF NOT EXISTS `publicationdon` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `datePublication` datetime(5) NOT NULL,
  `nbreUp` int(255) DEFAULT NULL,
  `nbrePlat` int(100) DEFAULT NULL,
  `etat` int(100) NOT NULL COMMENT '1 =actif / 0= non actiof',
  `ajoutePar` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `publicationdon`
--

INSERT INTO `publicationdon` (`id`, `type`, `titre`, `description`, `datePublication`, `nbreUp`, `nbrePlat`, `etat`, `ajoutePar`) VALUES
(11, 'OffreDon', '3', '3', '2020-02-20 11:06:42.00000', 0, NULL, 0, 12),
(12, 'OffreDon', 'ne', 'new', '2020-02-20 11:09:09.00000', 0, NULL, 0, 11),
(14, 'OffreDon', 'Ahmed', 'FouratiAhmed', '2020-02-20 21:46:12.00000', 0, NULL, 0, 13),
(17, 'OffreDon', 'Offre Don', 'Bojoour j\'ofree ...', '2020-02-21 07:59:42.00000', 0, NULL, 0, 13),
(18, 'OffreDon', 'Offre Don', 'Bojoour j\'ofree ...', '2020-02-21 07:59:42.00000', 0, NULL, 0, 13),
(19, 'AppelAuDon', 'Demande ! ', 'Demande ! ', '2020-02-21 08:01:56.00000', 0, 3, 0, 11),
(20, 'OffreDon', 'tt', 'tt', '2020-02-21 09:19:21.00000', 0, NULL, 0, 13),
(21, 'AppelAuDon', 'dd', 'dd', '2020-02-21 09:22:20.00000', 0, 3, 0, 11),
(22, 'AppelAuDon', 'Hello', 'Hello', '2020-02-24 21:31:59.00000', 0, 3, 1, 11),
(23, 'AppelAuDon', 'Hello 2', 'Hello 2', '2020-02-24 21:31:59.00000', 0, 3, 1, 11),
(24, 'OffreDon', 'azazazaz', 'aazazazza\naz\naz\naz\nz\naz\naz', '2020-02-27 01:45:31.00000', 0, NULL, 1, 41),
(26, 'OffreDon', 's', 'sszszs', '2020-02-27 01:48:53.00000', 0, NULL, 1, 41),
(27, 'AppelAuDon', 'aza', 'azazazazaza', '2020-02-27 01:50:44.00000', 0, 5, 1, 39),
(28, 'OffreDon', 'Amine :\'(', 'azarzerzrezzrgregdergeggre\nzrzrzrrzrzrrrzaazscfefzzrgsgg\nzrzzrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr', '2020-02-27 16:44:40.00000', 0, NULL, 1, 41),
(29, 'AppelAuDon', 'amine Resto', 'azaazazzazzazazaazaz\nazazzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz\nazzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz', '2020-02-27 16:47:55.00000', 0, 44, 1, 39);

-- --------------------------------------------------------

--
-- Structure de la table `publicite`
--

DROP TABLE IF EXISTS `publicite`;
CREATE TABLE IF NOT EXISTS `publicite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  `marque` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `dateAjout` datetime(6) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `publicite`
--

INSERT INTO `publicite` (`id`, `titre`, `marque`, `description`, `dateAjout`, `image`) VALUES
(4, 'ss', 'gg', 'www.coca-cola.com', '2020-02-24 22:57:48.000000', 'coca3.png'),
(5, 's', '', 'www.asus.com', '2020-02-24 23:06:49.000000', 'asus3.png'),
(6, 'se', '', 'www.audi.com', '2020-02-24 23:07:06.000000', 'audi3.png');

-- --------------------------------------------------------

--
-- Structure de la table `publicite_country`
--

DROP TABLE IF EXISTS `publicite_country`;
CREATE TABLE IF NOT EXISTS `publicite_country` (
  `idPublicite` int(11) NOT NULL,
  `idCountry` int(11) NOT NULL,
  `nbrClick` int(11) NOT NULL,
  PRIMARY KEY (`idPublicite`,`idCountry`),
  KEY `fk1_country` (`idCountry`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `publicite_country`
--

INSERT INTO `publicite_country` (`idPublicite`, `idCountry`, `nbrClick`) VALUES
(4, 1, 0),
(4, 2, 0),
(4, 3, 0),
(4, 4, 0),
(4, 5, 0),
(4, 6, 0),
(4, 7, 0),
(4, 8, 0),
(4, 9, 0),
(4, 10, 0),
(4, 11, 0),
(4, 12, 0),
(4, 13, 0),
(4, 14, 0),
(4, 15, 0),
(4, 16, 0),
(4, 17, 0),
(4, 18, 0),
(4, 19, 0),
(4, 20, 0),
(4, 21, 0),
(4, 22, 0),
(4, 23, 0),
(4, 24, 0),
(4, 25, 0),
(4, 26, 0),
(4, 27, 0),
(4, 28, 0),
(4, 29, 0),
(4, 30, 0),
(4, 31, 0),
(4, 32, 0),
(4, 33, 0),
(4, 34, 0),
(4, 35, 0),
(4, 36, 0),
(4, 37, 0),
(4, 38, 0),
(4, 39, 0),
(4, 40, 0),
(4, 41, 0),
(4, 42, 0),
(4, 43, 0),
(4, 44, 0),
(4, 45, 0),
(4, 46, 0),
(4, 47, 0),
(4, 48, 0),
(4, 49, 0),
(4, 50, 0),
(4, 51, 0),
(4, 52, 0),
(4, 53, 0),
(4, 54, 0),
(4, 55, 0),
(4, 56, 0),
(4, 57, 0),
(4, 58, 0),
(4, 59, 0),
(4, 60, 0),
(4, 61, 0),
(4, 62, 0),
(4, 63, 0),
(4, 64, 0),
(4, 65, 0),
(4, 66, 0),
(4, 67, 0),
(4, 68, 0),
(4, 69, 0),
(4, 70, 0),
(4, 71, 0),
(4, 72, 0),
(4, 73, 0),
(4, 74, 0),
(4, 75, 0),
(4, 76, 0),
(4, 77, 0),
(4, 78, 0),
(4, 79, 0),
(4, 80, 0),
(4, 81, 0),
(4, 82, 0),
(4, 83, 0),
(4, 84, 0),
(4, 85, 0),
(4, 86, 0),
(4, 87, 0),
(4, 88, 0),
(4, 89, 0),
(4, 90, 0),
(4, 91, 0),
(4, 92, 0),
(4, 93, 0),
(4, 94, 0),
(4, 95, 0),
(4, 96, 0),
(4, 97, 0),
(4, 98, 0),
(4, 99, 0),
(4, 100, 0),
(4, 101, 0),
(4, 102, 0),
(4, 103, 0),
(4, 104, 0),
(4, 105, 0),
(4, 106, 0),
(4, 107, 0),
(4, 108, 0),
(4, 109, 0),
(4, 110, 0),
(4, 111, 0),
(4, 112, 0),
(4, 113, 0),
(4, 114, 0),
(4, 115, 0),
(4, 116, 0),
(4, 117, 0),
(4, 118, 0),
(4, 119, 0),
(4, 120, 0),
(4, 121, 0),
(4, 122, 0),
(4, 123, 0),
(4, 124, 0),
(4, 125, 0),
(4, 126, 0),
(4, 127, 0),
(4, 128, 0),
(4, 129, 0),
(4, 130, 0),
(4, 131, 0),
(4, 132, 0),
(4, 133, 0),
(4, 134, 0),
(4, 135, 0),
(4, 136, 0),
(4, 137, 0),
(4, 138, 0),
(4, 139, 0),
(4, 140, 0),
(4, 141, 0),
(4, 142, 0),
(4, 143, 0),
(4, 144, 0),
(4, 145, 0),
(4, 146, 0),
(4, 147, 0),
(4, 148, 0),
(4, 149, 0),
(4, 150, 0),
(4, 151, 0),
(4, 152, 0),
(4, 153, 0),
(4, 154, 0),
(4, 155, 0),
(4, 156, 0),
(4, 157, 0),
(4, 158, 0),
(4, 159, 0),
(4, 160, 0),
(4, 161, 0),
(4, 162, 0),
(4, 163, 0),
(4, 164, 0),
(4, 165, 0),
(4, 166, 0),
(4, 167, 0),
(4, 168, 0),
(4, 169, 0),
(4, 170, 0),
(4, 171, 0),
(4, 172, 0),
(4, 173, 0),
(4, 174, 0),
(4, 175, 0),
(4, 176, 0),
(4, 177, 0),
(4, 178, 0),
(4, 179, 0),
(4, 180, 0),
(4, 181, 0),
(4, 182, 0),
(4, 183, 0),
(4, 184, 0),
(4, 185, 0),
(4, 186, 0),
(4, 187, 0),
(4, 188, 0),
(4, 189, 0),
(4, 190, 0),
(4, 191, 0),
(4, 192, 0),
(4, 193, 0),
(4, 194, 0),
(4, 195, 0),
(4, 196, 0),
(4, 197, 0),
(4, 198, 0),
(4, 199, 0),
(4, 200, 0),
(4, 201, 0),
(4, 202, 0),
(4, 203, 0),
(4, 204, 0),
(4, 205, 0),
(4, 206, 0),
(4, 207, 0),
(4, 208, 0),
(4, 209, 0),
(4, 210, 0),
(4, 211, 0),
(4, 212, 0),
(4, 213, 0),
(4, 214, 0),
(4, 215, 0),
(4, 216, 0),
(4, 217, 0),
(4, 218, 0),
(4, 219, 0),
(4, 220, 0),
(4, 221, 0),
(4, 222, 0),
(4, 223, 4),
(4, 224, 0),
(4, 225, 0),
(4, 226, 0),
(4, 227, 0),
(4, 228, 0),
(4, 229, 0),
(4, 230, 0),
(4, 231, 0),
(4, 232, 0),
(4, 233, 0),
(4, 234, 0),
(4, 235, 0),
(4, 236, 0),
(4, 237, 0),
(4, 238, 0),
(4, 239, 0),
(4, 240, 0),
(4, 241, 0),
(4, 242, 0),
(4, 243, 0),
(4, 244, 0),
(4, 245, 0),
(4, 246, 0),
(5, 1, 0),
(5, 2, 0),
(5, 3, 0),
(5, 4, 0),
(5, 5, 0),
(5, 6, 0),
(5, 7, 0),
(5, 8, 0),
(5, 9, 0),
(5, 10, 0),
(5, 11, 0),
(5, 12, 0),
(5, 13, 0),
(5, 14, 0),
(5, 15, 0),
(5, 16, 0),
(5, 17, 0),
(5, 18, 0),
(5, 19, 0),
(5, 20, 0),
(5, 21, 0),
(5, 22, 0),
(5, 23, 0),
(5, 24, 0),
(5, 25, 0),
(5, 26, 0),
(5, 27, 0),
(5, 28, 0),
(5, 29, 0),
(5, 30, 0),
(5, 31, 0),
(5, 32, 0),
(5, 33, 0),
(5, 34, 0),
(5, 35, 0),
(5, 36, 0),
(5, 37, 0),
(5, 38, 0),
(5, 39, 0),
(5, 40, 0),
(5, 41, 0),
(5, 42, 0),
(5, 43, 0),
(5, 44, 0),
(5, 45, 0),
(5, 46, 0),
(5, 47, 0),
(5, 48, 0),
(5, 49, 0),
(5, 50, 0),
(5, 51, 0),
(5, 52, 0),
(5, 53, 0),
(5, 54, 0),
(5, 55, 0),
(5, 56, 0),
(5, 57, 0),
(5, 58, 0),
(5, 59, 0),
(5, 60, 0),
(5, 61, 0),
(5, 62, 0),
(5, 63, 0),
(5, 64, 0),
(5, 65, 0),
(5, 66, 0),
(5, 67, 0),
(5, 68, 0),
(5, 69, 0),
(5, 70, 0),
(5, 71, 0),
(5, 72, 0),
(5, 73, 0),
(5, 74, 0),
(5, 75, 0),
(5, 76, 0),
(5, 77, 0),
(5, 78, 0),
(5, 79, 0),
(5, 80, 0),
(5, 81, 0),
(5, 82, 0),
(5, 83, 0),
(5, 84, 0),
(5, 85, 0),
(5, 86, 0),
(5, 87, 0),
(5, 88, 0),
(5, 89, 0),
(5, 90, 0),
(5, 91, 0),
(5, 92, 0),
(5, 93, 0),
(5, 94, 0),
(5, 95, 0),
(5, 96, 0),
(5, 97, 0),
(5, 98, 0),
(5, 99, 0),
(5, 100, 0),
(5, 101, 0),
(5, 102, 0),
(5, 103, 0),
(5, 104, 0),
(5, 105, 0),
(5, 106, 0),
(5, 107, 0),
(5, 108, 0),
(5, 109, 0),
(5, 110, 0),
(5, 111, 0),
(5, 112, 0),
(5, 113, 0),
(5, 114, 0),
(5, 115, 0),
(5, 116, 0),
(5, 117, 0),
(5, 118, 0),
(5, 119, 0),
(5, 120, 0),
(5, 121, 0),
(5, 122, 0),
(5, 123, 0),
(5, 124, 0),
(5, 125, 0),
(5, 126, 0),
(5, 127, 0),
(5, 128, 0),
(5, 129, 0),
(5, 130, 0),
(5, 131, 0),
(5, 132, 0),
(5, 133, 0),
(5, 134, 0),
(5, 135, 0),
(5, 136, 0),
(5, 137, 0),
(5, 138, 0),
(5, 139, 0),
(5, 140, 0),
(5, 141, 0),
(5, 142, 0),
(5, 143, 0),
(5, 144, 0),
(5, 145, 0),
(5, 146, 0),
(5, 147, 0),
(5, 148, 0),
(5, 149, 0),
(5, 150, 0),
(5, 151, 0),
(5, 152, 0),
(5, 153, 0),
(5, 154, 0),
(5, 155, 0),
(5, 156, 0),
(5, 157, 0),
(5, 158, 0),
(5, 159, 0),
(5, 160, 0),
(5, 161, 0),
(5, 162, 0),
(5, 163, 0),
(5, 164, 0),
(5, 165, 0),
(5, 166, 0),
(5, 167, 0),
(5, 168, 0),
(5, 169, 0),
(5, 170, 0),
(5, 171, 0),
(5, 172, 0),
(5, 173, 0),
(5, 174, 0),
(5, 175, 0),
(5, 176, 0),
(5, 177, 0),
(5, 178, 0),
(5, 179, 0),
(5, 180, 0),
(5, 181, 0),
(5, 182, 0),
(5, 183, 0),
(5, 184, 0),
(5, 185, 0),
(5, 186, 0),
(5, 187, 0),
(5, 188, 0),
(5, 189, 0),
(5, 190, 0),
(5, 191, 0),
(5, 192, 0),
(5, 193, 0),
(5, 194, 0),
(5, 195, 0),
(5, 196, 0),
(5, 197, 0),
(5, 198, 0),
(5, 199, 0),
(5, 200, 0),
(5, 201, 0),
(5, 202, 0),
(5, 203, 0),
(5, 204, 0),
(5, 205, 0),
(5, 206, 0),
(5, 207, 0),
(5, 208, 0),
(5, 209, 0),
(5, 210, 0),
(5, 211, 0),
(5, 212, 0),
(5, 213, 0),
(5, 214, 0),
(5, 215, 0),
(5, 216, 0),
(5, 217, 0),
(5, 218, 0),
(5, 219, 0),
(5, 220, 0),
(5, 221, 0),
(5, 222, 0),
(5, 223, 5),
(5, 224, 0),
(5, 225, 0),
(5, 226, 0),
(5, 227, 0),
(5, 228, 0),
(5, 229, 0),
(5, 230, 0),
(5, 231, 0),
(5, 232, 0),
(5, 233, 0),
(5, 234, 0),
(5, 235, 0),
(5, 236, 0),
(5, 237, 0),
(5, 238, 0),
(5, 239, 0),
(5, 240, 0),
(5, 241, 0),
(5, 242, 0),
(5, 243, 0),
(5, 244, 0),
(5, 245, 0),
(5, 246, 0),
(6, 1, 0),
(6, 2, 0),
(6, 3, 0),
(6, 4, 0),
(6, 5, 0),
(6, 6, 0),
(6, 7, 0),
(6, 8, 0),
(6, 9, 0),
(6, 10, 0),
(6, 11, 0),
(6, 12, 0),
(6, 13, 0),
(6, 14, 0),
(6, 15, 0),
(6, 16, 0),
(6, 17, 0),
(6, 18, 0),
(6, 19, 0),
(6, 20, 0),
(6, 21, 0),
(6, 22, 0),
(6, 23, 0),
(6, 24, 0),
(6, 25, 0),
(6, 26, 0),
(6, 27, 0),
(6, 28, 0),
(6, 29, 0),
(6, 30, 0),
(6, 31, 0),
(6, 32, 0),
(6, 33, 0),
(6, 34, 0),
(6, 35, 0),
(6, 36, 0),
(6, 37, 0),
(6, 38, 0),
(6, 39, 0),
(6, 40, 0),
(6, 41, 0),
(6, 42, 0),
(6, 43, 0),
(6, 44, 0),
(6, 45, 0),
(6, 46, 0),
(6, 47, 0),
(6, 48, 0),
(6, 49, 0),
(6, 50, 0),
(6, 51, 0),
(6, 52, 0),
(6, 53, 0),
(6, 54, 0),
(6, 55, 0),
(6, 56, 0),
(6, 57, 0),
(6, 58, 0),
(6, 59, 0),
(6, 60, 0),
(6, 61, 0),
(6, 62, 0),
(6, 63, 0),
(6, 64, 0),
(6, 65, 0),
(6, 66, 0),
(6, 67, 0),
(6, 68, 0),
(6, 69, 0),
(6, 70, 0),
(6, 71, 0),
(6, 72, 0),
(6, 73, 0),
(6, 74, 0),
(6, 75, 0),
(6, 76, 0),
(6, 77, 0),
(6, 78, 0),
(6, 79, 0),
(6, 80, 0),
(6, 81, 0),
(6, 82, 0),
(6, 83, 0),
(6, 84, 0),
(6, 85, 0),
(6, 86, 0),
(6, 87, 0),
(6, 88, 0),
(6, 89, 0),
(6, 90, 0),
(6, 91, 0),
(6, 92, 0),
(6, 93, 0),
(6, 94, 0),
(6, 95, 0),
(6, 96, 0),
(6, 97, 0),
(6, 98, 0),
(6, 99, 0),
(6, 100, 0),
(6, 101, 0),
(6, 102, 0),
(6, 103, 0),
(6, 104, 0),
(6, 105, 0),
(6, 106, 0),
(6, 107, 0),
(6, 108, 0),
(6, 109, 0),
(6, 110, 0),
(6, 111, 0),
(6, 112, 0),
(6, 113, 0),
(6, 114, 0),
(6, 115, 0),
(6, 116, 0),
(6, 117, 0),
(6, 118, 0),
(6, 119, 0),
(6, 120, 0),
(6, 121, 0),
(6, 122, 0),
(6, 123, 0),
(6, 124, 0),
(6, 125, 0),
(6, 126, 0),
(6, 127, 0),
(6, 128, 0),
(6, 129, 0),
(6, 130, 0),
(6, 131, 0),
(6, 132, 0),
(6, 133, 0),
(6, 134, 0),
(6, 135, 0),
(6, 136, 0),
(6, 137, 0),
(6, 138, 0),
(6, 139, 0),
(6, 140, 0),
(6, 141, 0),
(6, 142, 0),
(6, 143, 0),
(6, 144, 0),
(6, 145, 0),
(6, 146, 0),
(6, 147, 0),
(6, 148, 0),
(6, 149, 0),
(6, 150, 0),
(6, 151, 0),
(6, 152, 0),
(6, 153, 0),
(6, 154, 0),
(6, 155, 0),
(6, 156, 0),
(6, 157, 0),
(6, 158, 0),
(6, 159, 0),
(6, 160, 0),
(6, 161, 0),
(6, 162, 0),
(6, 163, 0),
(6, 164, 0),
(6, 165, 0),
(6, 166, 0),
(6, 167, 0),
(6, 168, 0),
(6, 169, 0),
(6, 170, 0),
(6, 171, 0),
(6, 172, 0),
(6, 173, 0),
(6, 174, 0),
(6, 175, 0),
(6, 176, 0),
(6, 177, 0),
(6, 178, 0),
(6, 179, 0),
(6, 180, 0),
(6, 181, 0),
(6, 182, 0),
(6, 183, 0),
(6, 184, 0),
(6, 185, 0),
(6, 186, 0),
(6, 187, 0),
(6, 188, 0),
(6, 189, 0),
(6, 190, 0),
(6, 191, 0),
(6, 192, 0),
(6, 193, 0),
(6, 194, 0),
(6, 195, 0),
(6, 196, 0),
(6, 197, 0),
(6, 198, 0),
(6, 199, 0),
(6, 200, 0),
(6, 201, 0),
(6, 202, 0),
(6, 203, 0),
(6, 204, 0),
(6, 205, 0),
(6, 206, 0),
(6, 207, 0),
(6, 208, 0),
(6, 209, 0),
(6, 210, 0),
(6, 211, 0),
(6, 212, 0),
(6, 213, 0),
(6, 214, 0),
(6, 215, 0),
(6, 216, 0),
(6, 217, 0),
(6, 218, 0),
(6, 219, 0),
(6, 220, 0),
(6, 221, 0),
(6, 222, 0),
(6, 223, 4),
(6, 224, 0),
(6, 225, 0),
(6, 226, 0),
(6, 227, 0),
(6, 228, 0),
(6, 229, 0),
(6, 230, 0),
(6, 231, 0),
(6, 232, 0),
(6, 233, 0),
(6, 234, 0),
(6, 235, 0),
(6, 236, 0),
(6, 237, 0),
(6, 238, 0),
(6, 239, 0),
(6, 240, 0),
(6, 241, 0),
(6, 242, 0),
(6, 243, 0),
(6, 244, 0),
(6, 245, 0),
(6, 246, 0);

-- --------------------------------------------------------

--
-- Structure de la table `publicite_region`
--

DROP TABLE IF EXISTS `publicite_region`;
CREATE TABLE IF NOT EXISTS `publicite_region` (
  `idPublicite` int(11) NOT NULL,
  `idRegion` int(11) NOT NULL,
  `nbClick` int(11) NOT NULL,
  PRIMARY KEY (`idPublicite`,`idRegion`),
  KEY `idRegion` (`idRegion`),
  KEY `idPublicite` (`idPublicite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `publicite_region`
--

INSERT INTO `publicite_region` (`idPublicite`, `idRegion`, `nbClick`) VALUES
(4, 1, 0),
(4, 2, 0),
(4, 3, 0),
(4, 4, 4),
(5, 1, 1),
(5, 2, 0),
(5, 3, 0),
(5, 4, 4),
(6, 1, 0),
(6, 2, 0),
(6, 3, 0),
(6, 4, 4);

-- --------------------------------------------------------

--
-- Structure de la table `region`
--

DROP TABLE IF EXISTS `region`;
CREATE TABLE IF NOT EXISTS `region` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `region`
--

INSERT INTO `region` (`id`, `nom`) VALUES
(1, 'Tunis'),
(2, 'Sousse'),
(3, 'Sfax'),
(4, 'Aryanah');

-- --------------------------------------------------------

--
-- Structure de la table `repasservi`
--

DROP TABLE IF EXISTS `repasservi`;
CREATE TABLE IF NOT EXISTS `repasservi` (
  `idResto` int(11) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`idResto`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `repasservi`
--

INSERT INTO `repasservi` (`idResto`, `date`) VALUES
(15, '2020-02-13 20:28:31'),
(15, '2020-02-13 20:29:04'),
(15, '2020-02-13 20:29:08'),
(15, '2020-02-13 20:29:10'),
(15, '2020-02-21 05:49:45'),
(15, '2020-02-21 06:40:28'),
(15, '2020-02-21 06:40:44'),
(15, '2020-02-21 06:40:47'),
(15, '2020-02-21 07:18:14'),
(15, '2020-02-21 07:24:15'),
(15, '2020-02-21 07:43:08'),
(15, '2020-02-21 07:43:44'),
(15, '2020-02-21 07:43:45'),
(15, '2020-02-21 07:58:39'),
(15, '2020-02-21 07:58:45'),
(15, '2020-02-21 07:59:03'),
(15, '2020-02-21 08:16:40'),
(15, '2020-02-21 08:16:47'),
(15, '2020-02-21 08:16:48'),
(15, '2020-02-24 21:52:57'),
(41, '2020-02-24 22:06:32'),
(41, '2020-02-25 01:05:47'),
(41, '2020-02-25 01:06:05'),
(41, '2020-02-25 01:06:22'),
(41, '2020-02-25 22:47:47'),
(41, '2020-02-27 15:33:30'),
(41, '2020-02-27 15:33:52'),
(41, '2020-02-27 15:33:53'),
(41, '2020-02-27 15:33:55'),
(41, '2020-02-27 15:33:58'),
(41, '2020-02-27 15:34:06');

-- --------------------------------------------------------

--
-- Structure de la table `signalement`
--

DROP TABLE IF EXISTS `signalement`;
CREATE TABLE IF NOT EXISTS `signalement` (
  `id_demande` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `raison` enum('ARNAQUE','HAINE','VIOLENCE','AUTRE') DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id_demande`,`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `signalement`
--

INSERT INTO `signalement` (`id_demande`, `id_user`, `raison`, `description`) VALUES
(18, 1, 'HAINE', 'un discours haineux'),
(18, 2, 'VIOLENCE', 'un discours de violence'),
(18, 100, 'AUTRE', 'zrgegeg'),
(19, 2, 'VIOLENCE', 'un discours de violence'),
(19, 6, 'ARNAQUE', ''),
(19, 100, 'HAINE', 'frfrrf'),
(21, 1, 'VIOLENCE', 'un discours de violence'),
(21, 2, 'HAINE', 'un discours de haine'),
(21, 3, 'AUTRE', 'un discours de autre'),
(21, 4, 'VIOLENCE', 'un discours de violence'),
(21, 5, 'VIOLENCE', 'un discours de violence'),
(21, 6, 'VIOLENCE', 'un discours de violence'),
(21, 100, 'VIOLENCE', 'un discours de violence'),
(22, 100, 'HAINE', 'un discours haineux'),
(23, 100, 'AUTRE', 'blabla'),
(24, 2, 'AUTRE', 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'),
(25, 2, 'VIOLENCE', 'g'),
(27, 100, 'ARNAQUE', 'trtrt'),
(28, 2, 'HAINE', 'descri'),
(28, 100, 'HAINE', 'htth'),
(29, 2, 'VIOLENCE', 'hfieaihfaehueh'),
(29, 100, 'AUTRE', 'trtrtrtrtrtrtr'),
(30, 2, 'HAINE', 'gkggygggg'),
(33, 2, 'VIOLENCE', ''),
(41, 100, 'ARNAQUE', 'ee'),
(41, 101, 'HAINE', 'frf'),
(41, 102, 'ARNAQUE', 'd'),
(41, 103, 'ARNAQUE', 'sdsd'),
(41, 104, 'HAINE', 'dddd'),
(41, 105, 'VIOLENCE', 'zszsz'),
(59, 41, 'HAINE', 'vyuyu'),
(61, 2, 'ARNAQUE', 'zee'),
(61, 3, 'VIOLENCE', 'ddd'),
(61, 4, 'HAINE', 'ffff'),
(61, 5, 'HAINE', ''),
(61, 6, 'AUTRE', 'ffff'),
(61, 41, 'HAINE', 'oop');

-- --------------------------------------------------------

--
-- Structure de la table `tarifresto`
--

DROP TABLE IF EXISTS `tarifresto`;
CREATE TABLE IF NOT EXISTS `tarifresto` (
  `idResto` int(11) NOT NULL,
  `tarif` decimal(9,3) NOT NULL,
  `portefeuilleVirtuel` decimal(9,3) DEFAULT '0.000',
  PRIMARY KEY (`idResto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tarifresto`
--

INSERT INTO `tarifresto` (`idResto`, `tarif`, `portefeuilleVirtuel`) VALUES
(15, '7.000', '12.800'),
(16, '2.700', '0.000'),
(17, '3.500', '0.000'),
(41, '1.000', '22.000');

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
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

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
(28, 'us', 'amine.gonfgfghgi@esprit.tn', '212', 'Bsalt', '3232323', 'Maroc', 'casa', 'image', 0, -1, 'c0055', NULL, 'azaz', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'zeazera', 'Homme', '2020-02-12 00:00:00', '2020-02-14 11:21:54'),
(29, 'us', 'amine.gongi@espggrit.tn', '123', 'Bsalt', '12321231', 'Tunisie', 'tunis', 'image', 0, -1, 'd13b3', NULL, 'ghfgh', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'hffh', 'Homme', '2020-02-04 00:00:00', '2020-02-18 19:56:33'),
(30, 'us', 'amine.gongi@esprit.tnn', '123', 'Bsalt', '12321123', 'Tunisie', 'aaaaa', 'image', 0, -1, '09f9c', NULL, 'zezeze', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ezrzerz', 'Homme', '2020-02-05 00:00:00', '2020-02-19 13:48:02'),
(31, 'us', 'amine.godddngi@esprit.tn', '$2a$12$KhJn1dC1Ohpc.cb9oD7kWufk48kSEJi.7TJoVruliy3e4XuEPxcNC', 'Bsalt', '12345543', 'Tunisie', 'tunis', 'image', 0, -1, '550ce', NULL, 'amine', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'gongi', 'Homme', '2020-02-07 00:00:00', '2020-02-19 14:04:23'),
(32, 'us', 'amine.gongi@gmail.com', '$2a$05$1DxJ4awJQmMEW6P7j46/ZO4N1qwL8vWzi5KeCo/lZsp4XpOhGpsLC', '42bafee', '12312112', 'France', 'paris', 'image', 0, -1, '462c5', NULL, 'azddaz', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'adazadada', 'Homme', '2020-02-12 00:00:00', '2020-02-19 14:15:45'),
(33, 'us', 'amine.gongi@esprit.tn', '$2a$05$L6QEO5YgxeiZlpyDh.WRieQAC8r9vh5C8Zx1dkswaiyxmO/RenCr6', 'a634fb9-3e11-4', '12123123', 'Tunisie', 'gaa', 'image', 0, 1, '41c82', NULL, 'ammam', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'amzmaazm', 'Homme', '2020-02-19 00:00:00', '2020-02-19 14:27:46'),
(34, 'us', 'amine98gongi@gmail.com', '$2a$05$W/M3zyzfmuwFLxGktHGbMOCcdRm1D9p3.EtkLyqOWU7kXcGSywY/6', 'd86d4ed-7efc-4', '0021655685313', 'Tunisie', 'adada', 'image', 0, -1, '7e63a', NULL, 'azeaezae', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'azeeae', 'Homme', '2020-02-13 00:00:00', '2020-02-20 06:54:57'),
(35, 'us', 'aminegongiesprit@gmail.com', '$2a$05$BhtFNTBW5UnRqK7xMqJE4ucp3rvvv/n.KpxYGt.YxLn4sStelDGYC', 'd86aa6c-2fe8-4', '0021655685313', 'Tunisie', 'ezze', 'image', 0, -1, 'a8801', NULL, 'zefzfaez', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'efzfzg', 'Homme', '2020-02-05 00:00:00', '2020-02-20 06:57:13'),
(36, 'us', 'sedkikik@donation.tn', '$2a$05$9CmVI457UREgV5N7wQnfV.FeQ3w.FTAaQHR/.P.3aPJT/2b3CKImy', '6fef4d7-ac6c-4', '0021624172824', 'Tunisie', 'sdds', 'image', 0, -1, 'ce3ac', NULL, 'sedki', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'sedki', 'Homme', '2020-02-26 00:00:00', '2020-02-20 06:59:05'),
(37, 'us', 'aazeae@gmail.com', '$2a$05$7qdytVyloLzRL/KiXi1.6OXGbNBlwgnVx3DogT.A2HkKs5h4fB1SK', '7720e9f-eb4e-4', '0021624172824', 'Tunisie', 'tunis', 'image', 0, -1, '31e39', NULL, 'azaza', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'zeaaze', 'Homme', '2020-02-05 00:00:00', '2020-02-20 07:01:04'),
(38, 'us', 'ahmed.fourati@esprit.tn', '$2a$05$b8S0FwS/oD1/42ZXU1DUL.Z1DIig7jzBesvJOT.WtkREwBaMW4zqu', '9604785-b543-4', '0021655685313', 'Tunisie', 'tunis', 'image', 0, 1, '085ce', NULL, 'amine', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'aazaza', 'Femme', '2020-02-05 00:00:00', '2020-02-20 11:39:42'),
(39, 'org', 'amingongie98gongi@gmail.com', '$2a$05$uzdJ3kOGoPNVphHRGgix/.WH7UokDKQn65el4DJVL6gkMfX2s5XaG', '30ce4c9-067c-4', '0021655685313', 'Tunisie', 'tunis', '8b5c477.jpg', 0, 1, 'e261c', NULL, 'SOS', NULL, 'www.fb.com', 'www.site.com', 'c,eezfzf\nfzf\nzf\nz\nfz\nfzfzfzfzf', '1231AZ', NULL, 99.5421, 12.3, NULL, NULL, NULL, '2020-02-20 20:04:52'),
(40, 'us', 'pidevJava@esprit.tn', '$2a$05$4lsZmTcuK/FV7TkUq5WxUeaNIedEHcFGGCUb3oPN0fQqma0SoO48W', '1b7d748-11ba-4', '0021655685313', 'Tunisie', 'Tunis', 'C:\\Users\\Amine Gongi\\Desktop\\Esprit 3A\\PIDEV\\DoNationJava\\JavaFXApplicationWUI\\src\\images\\amineGongi.PNG', 0, 0, 'd12c5', NULL, 'amine', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'pidev', 'Homme', '2020-01-02 00:00:00', '2020-02-21 08:38:06'),
(41, 'resto', 'yessine.khanfir@esprit.tn', '$2a$05$.l2nRWj9oYBZpKpHiy105e.SI9rtRHtjJL6XvbTs6YsJmXC80zckG', '34c5967-652c-4', '0021655685313', 'Tunisie', 'tunis', 'head.png', 0, 1, '1e31b', NULL, 'khanfir', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'yessine', 'Homme', '2020-02-04 00:00:00', '2020-02-23 14:13:05'),
(42, 'us', 'amine@gmail.com', '$2a$05$gbUHMfSTuL3cvsCaIc5fSO5EjaQI9Y.QzNx2Cf8DyDjWI2.EDNrMa', '7ea61ca-41d1-4', '+21655685313', 'Tunisia', 'La Goulette', 'image', 0, -1, 'd9276', NULL, 'azza', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'azaza', 'Homme', '2020-02-05 00:00:00', '2020-02-26 15:36:57'),
(43, 'org', 'rctccece@gmail.com', '$2a$05$7Zh/NH4gQ2.z4SM6bHOfpOzrML131m2V0v7fhiAFV4lxwqAJzS15W', '7301c14-a8fb-4', '+21655685313', 'Tunisia', 'Tunis', 'image', 0, -1, '5d292', NULL, 'rct', NULL, 'www.fb.com', 'www.ffff.com', 'azeazeea\nazeazaze\nazeaea', 'aazazaz23232', NULL, 10.1969, 36.8491, NULL, NULL, NULL, '2020-02-26 16:09:07'),
(44, 'us', 'addadad@gmail.com', '$2a$05$YTs4BmieXU8cF1LlNhRoPuRw5eSKJ9e/OG5gNqYVs9I2MCfkSTeoW', 'fa092c0-c6aa-4', '+21655123123', 'Tunisia', 'Tunis', 'image', 0, -1, '2ec9c', NULL, 'azadaz', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'dazad', 'Homme', '2020-02-03 00:00:00', '2020-02-26 16:11:26'),
(45, 'us', 'ammam@gmail.com', '$2a$05$ZdxSZw6g9pKebJRH1wT4Du9jj5n9uIXoGDPK2974asNqw8LwO.DF6', '18333d7-869f-4', '+21655685313', 'Tunisia', 'Tunis', 'image', 0, -1, '34043', NULL, 'amine', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'amine', 'Homme', '2019-11-06 00:00:00', '2020-02-26 19:31:37'),
(46, 'us', 'zfzfzfz@', '$2a$05$Gs/TYtHvHtw7ZzWQtUZ9CuKQAcz0s4azG9FE9xuJR7NnnsfFj8yxq', '35dc452-a202-4', '+21655685313', 'Tunisia', 'Tunis', 'image', 0, -1, '9bb80', NULL, 'dzfeez', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'zffzf', 'Homme', '2020-02-12 00:00:00', '2020-02-26 19:32:48'),
(47, 'us', 'azazaazaz@gmail.com', '$2a$05$ypWc14bPLeJSILHGbBvxDuWxSH4hfI5SPeeHOQJkPvZlF0rD4OVom', '092f2ed-47ef-4', '+21655685313', 'Tunisia', 'Tunis', '/images/user_male.png', 0, -1, '4317d', NULL, 'azaz', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'azaz', 'Homme', '2020-02-03 00:00:00', '2020-02-26 20:19:37'),
(48, 'us', 'amine.maalouuuf@esprit.tn', '$2a$05$M9LAHJf11OZELFXVkqwoBOheK4sqN3UxorRnhD6iiBORTH5xvE.n2', 'a48da70-99d0-4', '+21655685313', 'Tunisia', 'Tunis', './src/images/user_male.png', 0, 1, '20c03', NULL, 'amine', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'maalouf', 'Homme', '2020-02-03 00:00:00', '2020-02-27 15:43:28');

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
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `fk_commentaire_demande` FOREIGN KEY (`id_demande`) REFERENCES `demande` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Contraintes pour la table `demande`
--
ALTER TABLE `demande`
  ADD CONSTRAINT `fk_categorie` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Contraintes pour la table `demandedesactivationcompte`
--
ALTER TABLE `demandedesactivationcompte`
  ADD CONSTRAINT `demandedesactivationcompte_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `utilisateurs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `donrestaurant`
--
ALTER TABLE `donrestaurant`
  ADD CONSTRAINT `fk_DonRestaurant_utilisateurs_Resto` FOREIGN KEY (`idResto`) REFERENCES `utilisateurs` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_DonRestaurant_utilisateurs_User` FOREIGN KEY (`idUser`) REFERENCES `utilisateurs` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

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

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `fk_participation_demande` FOREIGN KEY (`id_demande`) REFERENCES `demande` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Contraintes pour la table `publicite_country`
--
ALTER TABLE `publicite_country`
  ADD CONSTRAINT `fk1_country` FOREIGN KEY (`idCountry`) REFERENCES `apps_countries` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_country` FOREIGN KEY (`idPublicite`) REFERENCES `publicite` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `publicite_region`
--
ALTER TABLE `publicite_region`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`idRegion`) REFERENCES `region` (`id`),
  ADD CONSTRAINT `fk2` FOREIGN KEY (`idPublicite`) REFERENCES `publicite` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `repasservi`
--
ALTER TABLE `repasservi`
  ADD CONSTRAINT `fk_RepasServi_utilisateurs` FOREIGN KEY (`idResto`) REFERENCES `utilisateurs` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `signalement`
--
ALTER TABLE `signalement`
  ADD CONSTRAINT `fk_signalement_demande` FOREIGN KEY (`id_demande`) REFERENCES `demande` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Contraintes pour la table `tarifresto`
--
ALTER TABLE `tarifresto`
  ADD CONSTRAINT `fk_TarifResto_utilisateurs` FOREIGN KEY (`idResto`) REFERENCES `utilisateurs` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

DELIMITER $$
--
-- Évènements
--
DROP EVENT `Expiration_Publication`$$
CREATE DEFINER=`root`@`localhost` EVENT `Expiration_Publication` ON SCHEDULE EVERY 30 SECOND STARTS '2020-02-16 13:42:53' ON COMPLETION PRESERVE ENABLE DO UPDATE publicationdon set etat=0 WHERE ( ((abs(TIMESTAMPDIFF(minute,datePublication,now()))>3 AND type='OffreDon')
                                        OR
                                        (abs(TIMESTAMPDIFF(minute,datePublication,now()))>2 AND type='AppelAuDon'))
                                        
                                        AND etat=1 )$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

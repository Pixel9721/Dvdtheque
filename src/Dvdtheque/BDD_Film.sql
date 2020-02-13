-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 13 fév. 2020 à 06:09
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `dvdtheque`
--

-- --------------------------------------------------------

--
-- Structure de la table `acteur`
--

CREATE TABLE `acteur` (
  `Id_Acteur` int(11) NOT NULL,
  `Nom_Acteur` varchar(50) NOT NULL,
  `Prenom_Acteur` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `acteur`
--

INSERT INTO `acteur` (`Id_Acteur`, `Nom_Acteur`, `Prenom_Acteur`) VALUES
(1, 'Arnold', 'Schwarzenegger'),
(2, 'De Funes', 'Louis'),
(3, 'Neill', 'Sam'),
(4, 'Dern', 'Laura'),
(5, 'Hanks', 'Tom');

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

CREATE TABLE `film` (
  `Id_Film` int(11) NOT NULL,
  `Nom_Film` varchar(50) NOT NULL,
  `Annee_Film` int(250) NOT NULL,
  `Note_Film` int(250) NOT NULL,
  `Resume_Film` varchar(500) NOT NULL,
  `Image_Film` varchar(250) NOT NULL,
  `Realisateur_id` int(11) DEFAULT NULL,
  `Nationnalite_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `film`
--

INSERT INTO `film` (`Id_Film`, `Nom_Film`, `Annee_Film`, `Note_Film`, `Resume_Film`, `Image_Film`, `Realisateur_id`, `Nationnalite_id`) VALUES
(1, 'Jurassic Park', 1993, 8, 'John Parker Hammond, le PDG de la puissante compagnie InGen, parvient à donner vie à des dinosaures grâce à la génétique et décide de les utiliser dans le cadre d’un parc d\'attractions qu’il compte ouvrir sur une île au large du Costa Rica.', 'jurassicPark.jpg', 1, 1),
(2, 'Le Gendarme de Saint-Tropez', 1964, 9, 'Grâce aux loyaux services rendus à une commune non nommée des Alpes-Maritimes, où il était jusqu\'ici en poste, Ludovic Cruchot, gendarme, est muté dans le Var, à Saint-Tropez tout en étant promu maréchal des logis-chef.', 'gendarmeTropez.jpg', 4, 2),
(3, 'Predator', 1987, 7, 'En 1987, un vaisseau spatial extraterrestre arrive à proximité de la Terre et largue un module qui entre dans l\'atmosphère de la planète, celui-ci atterrissant en Amérique centrale.', 'predator.jpg', 2, 1),
(4, 'Il faut sauver le soldat Ryan', 1998, 7, 'Au matin du 6 juin 1944, premier jour de la bataille de Normandie, lors du débarquement allié en Normandie : sur la plage d’Omaha Beach où débarquent les Américains, dans le secteur « Dog Green », le capitaine John H. Miller qui commande une compagnie de Rangers, tente de sortir de la plage avec ses hommes.', 'soldatRyan.jpg', 1, 1),
(5, 'Conan le Barbare', 1992, 6, 'L\'histoire se passe des milliers d\'années avant l’avènement de la civilisation moderne, durant l\'âge hyborien. Le film commence avec la citation de Friedrich Nietzsche, « Ce qui ne nous tue pas nous rend plus fort »N 1. S\'ensuit une narration qui établit que l’histoire raconte les origines de Conan, un jeune barbare.', 'ConanBarbare.jpg', 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `film_acteur`
--

CREATE TABLE `film_acteur` (
  `Film_id` int(11) NOT NULL,
  `Acteur_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `film_acteur`
--

INSERT INTO `film_acteur` (`Film_id`, `Acteur_id`) VALUES
(1, 3),
(1, 4),
(2, 2),
(3, 1),
(4, 5),
(5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `film_genre`
--

CREATE TABLE `film_genre` (
  `Film_id` int(11) NOT NULL,
  `Genre_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `film_genre`
--

INSERT INTO `film_genre` (`Film_id`, `Genre_id`) VALUES
(1, 5),
(2, 1),
(3, 5),
(4, 6),
(5, 7);

-- --------------------------------------------------------

--
-- Structure de la table `genre`
--

CREATE TABLE `genre` (
  `Id_Genre` int(11) NOT NULL,
  `Libelle_Genre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `genre`
--

INSERT INTO `genre` (`Id_Genre`, `Libelle_Genre`) VALUES
(1, 'Comedie'),
(2, 'Romance'),
(3, 'Horreur'),
(4, 'Action'),
(5, 'Science fiction'),
(6, 'Historique'),
(7, 'Fantasy');

-- --------------------------------------------------------

--
-- Structure de la table `nationnalite`
--

CREATE TABLE `nationnalite` (
  `Id_Nationnalite` int(11) NOT NULL,
  `Libelle_Nationnalite` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `nationnalite`
--

INSERT INTO `nationnalite` (`Id_Nationnalite`, `Libelle_Nationnalite`) VALUES
(1, 'Americain'),
(2, 'Francais');

-- --------------------------------------------------------

--
-- Structure de la table `realisateur`
--

CREATE TABLE `realisateur` (
  `Id_Realisateur` int(11) NOT NULL,
  `Nom_Realisateur` varchar(50) NOT NULL,
  `Prenom_Realisateur` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `realisateur`
--

INSERT INTO `realisateur` (`Id_Realisateur`, `Nom_Realisateur`, `Prenom_Realisateur`) VALUES
(1, 'Spielberg', 'Steven'),
(2, 'McTiernan', 'John'),
(3, 'Milius', 'John'),
(4, 'Girault', 'Jean');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `acteur`
--
ALTER TABLE `acteur`
  ADD PRIMARY KEY (`Id_Acteur`);

--
-- Index pour la table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`Id_Film`),
  ADD KEY `fkRealFilm` (`Realisateur_id`),
  ADD KEY `fkNationnaliteFilm` (`Nationnalite_id`);

--
-- Index pour la table `film_acteur`
--
ALTER TABLE `film_acteur`
  ADD PRIMARY KEY (`Film_id`,`Acteur_id`),
  ADD KEY `fkFilmActeur2` (`Acteur_id`);

--
-- Index pour la table `film_genre`
--
ALTER TABLE `film_genre`
  ADD PRIMARY KEY (`Film_id`,`Genre_id`),
  ADD KEY `fkFilmGenre2` (`Genre_id`);

--
-- Index pour la table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`Id_Genre`);

--
-- Index pour la table `nationnalite`
--
ALTER TABLE `nationnalite`
  ADD PRIMARY KEY (`Id_Nationnalite`);

--
-- Index pour la table `realisateur`
--
ALTER TABLE `realisateur`
  ADD PRIMARY KEY (`Id_Realisateur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `acteur`
--
ALTER TABLE `acteur`
  MODIFY `Id_Acteur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `film`
--
ALTER TABLE `film`
  MODIFY `Id_Film` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `genre`
--
ALTER TABLE `genre`
  MODIFY `Id_Genre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `nationnalite`
--
ALTER TABLE `nationnalite`
  MODIFY `Id_Nationnalite` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `realisateur`
--
ALTER TABLE `realisateur`
  MODIFY `Id_Realisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `fkNationnaliteFilm` FOREIGN KEY (`Nationnalite_id`) REFERENCES `nationnalite` (`Id_Nationnalite`),
  ADD CONSTRAINT `fkRealFilm` FOREIGN KEY (`Realisateur_id`) REFERENCES `realisateur` (`Id_Realisateur`);

--
-- Contraintes pour la table `film_acteur`
--
ALTER TABLE `film_acteur`
  ADD CONSTRAINT `fkFilmActeur1` FOREIGN KEY (`Film_id`) REFERENCES `film` (`Id_Film`),
  ADD CONSTRAINT `fkFilmActeur2` FOREIGN KEY (`Acteur_id`) REFERENCES `acteur` (`Id_Acteur`);

--
-- Contraintes pour la table `film_genre`
--
ALTER TABLE `film_genre`
  ADD CONSTRAINT `fkFilmGenre1` FOREIGN KEY (`Film_id`) REFERENCES `film` (`Id_Film`),
  ADD CONSTRAINT `fkFilmGenre2` FOREIGN KEY (`Genre_id`) REFERENCES `genre` (`Id_Genre`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

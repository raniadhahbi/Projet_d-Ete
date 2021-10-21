-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 22 sep. 2020 à 00:53
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `autoecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `candidats`
--

CREATE TABLE `candidats` (
  `cin_candidat` int(7) NOT NULL,
  `nom` varchar(10) NOT NULL,
  `prenom` varchar(15) NOT NULL,
  `date_naissance` date NOT NULL,
  `age` int(3) NOT NULL,
  `sexe` varchar(6) NOT NULL,
  `numero` int(8) NOT NULL,
  `gmail` varchar(30) NOT NULL,
  `etat` varchar(10) NOT NULL,
  `permis` varchar(3) NOT NULL,
  `date_inscription` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `candidats`
--

INSERT INTO `candidats` (`cin_candidat`, `nom`, `prenom`, `date_naissance`, `age`, `sexe`, `numero`, `gmail`, `etat`, `permis`, `date_inscription`) VALUES
(3, 'bellaswad', 'hamadi', '2020-03-05', 21, 'homme', 21478360, 'hamadisawda@gmail.com', 'Admis', 'B', '2020-07-15'),
(10, 'Mkaddem', 'Aymen', '2020-07-16', 21, 'homme', 95981272, 'aymen.mkaddem@ensi-uma.tn', 'En cours', 'B+E', '2020-07-30'),
(12, 'Manai', 'Bilel', '2020-07-03', 21, 'homme', 55135059, 'bilel.manai@ensi-uma.tn', 'Admis', 'C+E', '2020-07-30'),
(52, 'chaari', 'hatem', '2020-07-02', 21, 'homme', 53590804, 'hatem.chaari12@gmail.com', 'Admis', 'B', '2020-07-09'),
(158, 'kharrat', 'ayoub', '2020-07-19', 21, 'homme', 21810470, 'ayoub.kharrat@gmail.com', 'En cours', 'B', '2020-07-30'),
(132547, 'dhahbi', 'rania', '2020-08-28', 22, 'femme', 55642665, 'rania.dhahbi@ensi-uma.tn', 'En cours', 'C+E', '2020-08-31'),
(1111111, 'dhahbi', 'houssem', '2020-08-07', 18, 'rajel', 123456, 'houssem@gmail.com', 'En cours', 'A1', '2020-08-30');

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `id_cours` int(10) NOT NULL,
  `date_cours` date NOT NULL,
  `matricule_vehicule` varchar(20) NOT NULL,
  `cin_candidat` int(10) NOT NULL,
  `cin_moniteur` int(10) NOT NULL,
  `heure_deb` int(5) NOT NULL,
  `heure_fin` int(5) NOT NULL,
  `statut` varchar(30) NOT NULL,
  `duree_cours` int(5) NOT NULL,
  `prix` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`id_cours`, `date_cours`, `matricule_vehicule`, `cin_candidat`, `cin_moniteur`, `heure_deb`, `heure_fin`, `statut`, `duree_cours`, `prix`) VALUES
(4, '2020-08-02', '45tunis3306', 125466, 45697, 15, 17, 'code', 2, 15),
(5, '2020-08-02', '45tunis3306', 125466, 45698, 15, 17, 'examen code', 2, 25),
(6, '2020-09-16', '45tunis1475', 125466, 45698, 11, 14, 'conduite', 3, 10),
(7, '2020-07-18', 'tunis1257', 45789, 228, 13, 15, 'examen conduite', 2, 20),
(9, '2020-07-18', 'tunis', 45789, 228, 11, 15, 'examen code', 4, 10),
(14, '2020-07-11', 'tunis1458', 10, 45698, 10, 13, 'code', 3, 35);

-- --------------------------------------------------------

--
-- Structure de la table `leçon`
--

CREATE TABLE `leçon` (
  `id_lecon` int(11) NOT NULL,
  `cin_moniteur` int(11) NOT NULL,
  `type_lecon` varchar(10) NOT NULL,
  `tarif` int(11) NOT NULL,
  `categorie` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `leçon`
--

INSERT INTO `leçon` (`id_lecon`, `cin_moniteur`, `type_lecon`, `tarif`, `categorie`) VALUES
(1, 45789, 'code', 35, 'A'),
(3, 12212, 'conduite', 25, 'A1'),
(4, 1122, 'conduite', 20, 'B+E'),
(5, 228, 'conduite', 25, 'A1'),
(6, 12212, 'conduite', 25, 'A1'),
(7, 45698, 'conduite', 35, 'A1');

-- --------------------------------------------------------

--
-- Structure de la table `moniteurs`
--

CREATE TABLE `moniteurs` (
  `cin_moniteur` int(7) NOT NULL,
  `nom` varchar(10) NOT NULL,
  `prenom` varchar(10) NOT NULL,
  `date_naiss` date NOT NULL,
  `age` int(3) NOT NULL,
  `sexe` varchar(10) NOT NULL,
  `adresse` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `moniteurs`
--

INSERT INTO `moniteurs` (`cin_moniteur`, `nom`, `prenom`, `date_naiss`, `age`, `sexe`, `adresse`) VALUES
(45698, 'kharrat', 'ahmed', '2020-07-19', 23, 'homme', 'sfax'),
(1236547, 'dhahbi', 'ghaston', '2002-08-01', 18, 'rojla', 'city riadh');

-- --------------------------------------------------------

--
-- Structure de la table `paiements`
--

CREATE TABLE `paiements` (
  `id_paiements` int(20) NOT NULL,
  `cin_candidat` int(10) NOT NULL,
  `montant_total` int(20) NOT NULL,
  `mode_paiement` varchar(15) NOT NULL,
  `date_paiement` date NOT NULL,
  `reste` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `paiements`
--

INSERT INTO `paiements` (`id_paiements`, `cin_candidat`, `montant_total`, `mode_paiement`, `date_paiement`, `reste`) VALUES
(5, 12345, 150, 'espece', '2020-07-17', 10),
(12, 125463, 300, 'espece', '2020-07-09', 0),
(18, 125466, 50, 'par chèque', '2020-07-08', 50),
(19, 125466, 50, 'par chèque', '2020-07-08', 50),
(25, 125466, 0, 'espece', '2020-07-14', 0),
(26, 12, 0, 'espece', '2020-07-14', 0),
(27, 125466, 50, 'par chèque', '2020-08-07', 5),
(28, 10, 35, 'par chèque', '2020-09-11', 25);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE `utilisateurs` (
  `name` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `e_mail` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`name`, `username`, `e_mail`, `password`) VALUES
('ahmed', 'ahmed', 'ahmed@gmail.com', '123'),
('maram', 'maram', 'maram@ensi.tn', '12'),
('rania', 'rania', 'rania', 'rania');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `numero` int(8) NOT NULL,
  `matricule` varchar(15) NOT NULL,
  `type` varchar(10) NOT NULL,
  `marque` varchar(10) NOT NULL,
  `couleur` varchar(15) NOT NULL,
  `etat` varchar(15) NOT NULL,
  `cin_candidat` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`numero`, `matricule`, `type`, `marque`, `couleur`, `etat`, `cin_candidat`) VALUES
(12457, '173tunis3457', 'sport', 'chevrelet', 'Noir', 'Occupé', 45789);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `candidats`
--
ALTER TABLE `candidats`
  ADD UNIQUE KEY `cin_candidat` (`cin_candidat`);

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD UNIQUE KEY `id_cours` (`id_cours`);

--
-- Index pour la table `leçon`
--
ALTER TABLE `leçon`
  ADD UNIQUE KEY `id_lecon` (`id_lecon`);

--
-- Index pour la table `paiements`
--
ALTER TABLE `paiements`
  ADD PRIMARY KEY (`id_paiements`);

--
-- Index pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD UNIQUE KEY `username` (`username`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD UNIQUE KEY `numero` (`numero`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cours`
--
ALTER TABLE `cours`
  MODIFY `id_cours` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `leçon`
--
ALTER TABLE `leçon`
  MODIFY `id_lecon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `paiements`
--
ALTER TABLE `paiements`
  MODIFY `id_paiements` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

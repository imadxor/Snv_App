-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 29 nov. 2017 à 22:55
-- Version du serveur :  10.1.22-MariaDB
-- Version de PHP :  7.0.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `snv`
--

-- --------------------------------------------------------

--
-- Structure de la table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `Nom` varchar(32) NOT NULL,
  `Prenom` varchar(32) NOT NULL,
  `Depar` varchar(32) NOT NULL,
  `login` varchar(32) NOT NULL,
  `pass` varchar(32) NOT NULL,
  `user_statut` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `login`
--

INSERT INTO `login` (`id`, `Nom`, `Prenom`, `Depar`, `login`, `pass`, `user_statut`) VALUES
(1, '', '', '', 'admin', 'admin123', 'admin'),
(2, '', '', '', 'user', 'user', 'user'),
(3, 'jhgh', 'ghfg', 'Industrielle', 'gfdgdf', 'hgh', 'Administrateur');

-- --------------------------------------------------------

--
-- Structure de la table `produit_entree`
--

CREATE TABLE `produit_entree` (
  `id` int(11) NOT NULL,
  `Nom_prod` varchar(32) NOT NULL,
  `qte` int(11) NOT NULL,
  `Date_entree` date NOT NULL,
  `fournisseur` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit_entree`
--

INSERT INTO `produit_entree` (`id`, `Nom_prod`, `qte`, `Date_entree`, `fournisseur`) VALUES
(1, 'Produit 1', 250, '2017-11-04', 'KJK'),
(2, 'Produit 2', 400, '2017-11-04', 'HHHH'),
(3, 'Produit 3', 120, '2017-11-03', 'JKH'),
(5, 'Produit 4', 294852, '2017-11-18', '45'),
(4, 'Produit 5', 2121, '2017-11-11', '45'),
(8, 'Produit 6', 120, '2017-11-27', 'BABY'),
(7, 'Produit 7', 211, '2017-11-11', 'KLJJ'),
(6, 'Produit 8', 10, '2017-11-04', 'DFGH');

-- --------------------------------------------------------

--
-- Structure de la table `produit_sortie`
--

CREATE TABLE `produit_sortie` (
  `id` int(10) UNSIGNED ZEROFILL NOT NULL,
  `Nom_prod` varchar(32) NOT NULL,
  `qte` int(6) NOT NULL,
  `Date_sortie` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit_sortie`
--

INSERT INTO `produit_sortie` (`id`, `Nom_prod`, `qte`, `Date_sortie`) VALUES
(0000000002, 'Produit 2 ', 100, '2017-11-17');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`);

--
-- Index pour la table `produit_entree`
--
ALTER TABLE `produit_entree`
  ADD PRIMARY KEY (`Nom_prod`);

--
-- Index pour la table `produit_sortie`
--
ALTER TABLE `produit_sortie`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

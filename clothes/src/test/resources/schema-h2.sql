-- phpMyAdmin SQL Dump
-- version 4.8.5
-- SQLINES DEMO *** admin.net/
--
-- SQLINES DEMO *** :3306
-- SQLINES DEMO *** en. 08 jan. 2021 à 10:10
-- SQLINES DEMO *** r :  5.7.26
-- SQLINES DEMO ***  7.2.18

/* SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO"; */
SET @AUTOCOMMIT = 0;
BEGIN TRANSACTION;
SET @time_zone = '+00:00';


/* SQLINES DEMO *** ARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/* SQLINES DEMO *** ARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/* SQLINES DEMO *** LLATION_CONNECTION=@@COLLATION_CONNECTION */;
/* SQLINES DEMO *** tf8mb4 */;

--
-- SQLINES DEMO *** :  `niollo-clothes-api`
--

-- SQLINES DEMO *** ---------------------------------------

--
-- SQLINES DEMO *** able `categorie_table`
--

DROP TABLE IF EXISTS categorie_table;
CREATE TABLE categorie_table (
  categorie_id bigint NOT NULL,
  label varchar(255) DEFAULT NULL,
  PRIMARY KEY (categorie_id)
) ;

--
-- SQLINES DEMO ***  données de la table `categorie_table`
--



-- SQLINES DEMO *** ---------------------------------------

--
-- SQLINES DEMO *** able `clothes_categorie`
--

DROP TABLE IF EXISTS clothes_categorie;
CREATE TABLE clothes_categorie (
  clothes_id bigint NOT NULL,
  categorie_id bigint NOT NULL,
  PRIMARY KEY (clothes_id,categorie_id)
) ;

CREATE INDEX FKnyj4iip3te8b8dykg3j0rd3uh ON clothes_categorie (categorie_id);

-- SQLINES DEMO *** ---------------------------------------

--
-- SQLINES DEMO *** able `clothes_table`
--

DROP TABLE IF EXISTS clothes_table;
CREATE TABLE clothes_table (
  clothes_id bigint NOT NULL,
  date datetime2(0) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  label varchar(255) DEFAULT NULL,
  PRIMARY KEY (clothes_id)
) ;

-- SQLINES DEMO *** ---------------------------------------

--
-- SQLINES DEMO *** able `hibernate_sequence`
--

DROP TABLE IF EXISTS hibernate_sequence;
CREATE TABLE hibernate_sequence (
  next_val bigint DEFAULT NULL
) ;

--
-- SQLINES DEMO ***  données de la table `hibernate_sequence`
--

COMMIT;

/* SQLINES DEMO *** ER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/* SQLINES DEMO *** ER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/* SQLINES DEMO *** ON_CONNECTION=@OLD_COLLATION_CONNECTION */;

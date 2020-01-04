/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 5.7.28 : Database - cactusfood
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE TABLE `cidade` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `estado_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cidade_estado` (`estado_id`),
  CONSTRAINT `fk_cidade_estado` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `cozinha` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `estado` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `sigla` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `forma_pagamento` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `grupo` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `grupo_permissao` (
  `grupo_id` BIGINT(20) NOT NULL,
  `permissao_id` BIGINT(20) NOT NULL,
  KEY `fk_grupo_permissao_permissao` (`permissao_id`),
  KEY `fk_grupo_permissao_grupo` (`grupo_id`),
  CONSTRAINT `fk_grupo_permissao_permissao` FOREIGN KEY (`permissao_id`) REFERENCES `permissao` (`id`),
  CONSTRAINT `fk_grupo_permissao_grupo` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `permissao` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `produto` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `ativo` BIT(1) NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `preco` DECIMAL(19,2) NOT NULL,
  `restaurante_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_produto_restaurante` (`restaurante_id`),
  CONSTRAINT `fk_produto_restaurante` FOREIGN KEY (`restaurante_id`) REFERENCES `restaurante` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `restaurante` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `data_atualizacao` DATETIME NOT NULL,
  `data_cadastro` DATETIME NOT NULL,
  `endereco_bairro` VARCHAR(255) DEFAULT NULL,
  `endereco_cep` VARCHAR(255) DEFAULT NULL,
  `endereco_complemento` VARCHAR(255) DEFAULT NULL,
  `endereco_logradouro` VARCHAR(255) DEFAULT NULL,
  `endereco_numero` VARCHAR(255) DEFAULT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `taxa_frete` DECIMAL(19,2) NOT NULL,
  `cozinha_id` BIGINT(20) NOT NULL,
  `endereco_cidade_id` BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_restaurante_cozinha` (`cozinha_id`),
  KEY `fk_restaurante_cidade` (`endereco_cidade_id`),
  CONSTRAINT `fk_restaurante_cozinha` FOREIGN KEY (`cozinha_id`) REFERENCES `cozinha` (`id`),
  CONSTRAINT `fk_restaurante_cidade` FOREIGN KEY (`endereco_cidade_id`) REFERENCES `cidade` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `restaurante_forma_pagamento` (
  `restaurante_id` BIGINT(20) NOT NULL,
  `forma_pagamento_id` BIGINT(20) NOT NULL,
  KEY `fk_rest_forma_pagto_forma_pagto` (`forma_pagamento_id`),
  KEY `fk_rest_forma_pagto_restaurante` (`restaurante_id`),
  CONSTRAINT `fk_rest_forma_pagto_forma_pagto` FOREIGN KEY (`forma_pagamento_id`) REFERENCES `forma_pagamento` (`id`),
  CONSTRAINT `fk_rest_forma_pagto_restaurante` FOREIGN KEY (`restaurante_id`) REFERENCES `restaurante` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `usuario` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `data_cadastro` DATETIME NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `senha` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `usuario_grupo` (
  `usuario_id` BIGINT(20) NOT NULL,
  `grupo_id` BIGINT(20) NOT NULL,
  KEY `fk_usuario_grupo_grupo` (`grupo_id`),
  KEY `fk_usuario_grupo_usuario` (`usuario_id`),
  CONSTRAINT `fk_usuario_grupo_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `fk_usuario_grupo_grupo` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
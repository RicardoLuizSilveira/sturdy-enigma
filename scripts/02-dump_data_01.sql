-- MySQL dump 10.13  Distrib 8.0.20, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: curso_spring
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `payment_barr_code`
--

INSERT INTO payment_barr_code VALUES ('2017-02-20 03:00:00.000000',NULL,2);

--
-- Dumping data for table `payment_credit_card`
--

INSERT INTO payment_credit_card VALUES (6,1);

--
-- Dumping data for table `sic_address`
--

INSERT INTO sic_address VALUES (1,'zona 5','987','rua 1','87954211',1,1);
INSERT INTO sic_address VALUES (2,'Barão Rio Branco','55','rua 2','88954211',2,1);

--
-- Dumping data for table `sic_category`
--

INSERT INTO sic_category VALUES (1,'cat1 Electronics ');
INSERT INTO sic_category VALUES (2,'cat2 Books');
INSERT INTO sic_category VALUES (3,'cat3 Computers');
INSERT INTO sic_category VALUES (4,'cat4 Computers');
INSERT INTO sic_category VALUES (5,'cat5 Computers');
INSERT INTO sic_category VALUES (6,'cat6 Computers');
INSERT INTO sic_category VALUES (7,'cat7 Computers');
INSERT INTO sic_category VALUES (8,'cat8 Computers');
INSERT INTO sic_category VALUES (9,'cat9 Computers');
INSERT INTO sic_category VALUES (10,'cat10 Computers');
INSERT INTO sic_category VALUES (11,'cat11 Computers');
INSERT INTO sic_category VALUES (12,'cat12 Computers');
INSERT INTO sic_category VALUES (13,'cat13 Computers');
INSERT INTO sic_category VALUES (14,'cat14 Computers');
INSERT INTO sic_category VALUES (15,'cat15 Computers');
INSERT INTO sic_category VALUES (16,'cat16 Computers');
INSERT INTO sic_category VALUES (17,'cat17 Computers');
INSERT INTO sic_category VALUES (18,'cat18 Computers');
INSERT INTO sic_category VALUES (19,'cat19 Computers');
INSERT INTO sic_category VALUES (20,'cat20 Computers');
INSERT INTO sic_category VALUES (21,'cat21 Computers');
INSERT INTO sic_category VALUES (22,'cat22 Computers');

--
-- Dumping data for table `sic_city`
--

INSERT INTO sic_city VALUES (1,'Maringá',2);
INSERT INTO sic_city VALUES (2,'Sarandi',2);
INSERT INTO sic_city VALUES (3,'Cerejeiras',1);
INSERT INTO sic_city VALUES (4,'Porto Velho',1);

--
-- Dumping data for table `sic_client`
--

INSERT INTO sic_client VALUES (1,'m@hotmail.com','Maria','5478545',0);

--
-- Dumping data for table `sic_order`
--

INSERT INTO sic_order VALUES (1,'2017-09-30 13:32:00.000000',1,1);
INSERT INTO sic_order VALUES (2,'2017-10-10 22:35:00.000000',1,2);

--
-- Dumping data for table `sic_order_item`
--

INSERT INTO sic_order_item VALUES (0,90.5,1,1,1);
INSERT INTO sic_order_item VALUES (0,1250,2,3,1);
INSERT INTO sic_order_item VALUES (100,2190,1,2,2);

--
-- Dumping data for table `sic_payment`
--

INSERT INTO sic_payment VALUES (1,2);
INSERT INTO sic_payment VALUES (2,1);

--
-- Dumping data for table `sic_phones`
--

INSERT INTO sic_phones VALUES (1,'99663322');
INSERT INTO sic_phones VALUES (1,'88996655');

--
-- Dumping data for table `sic_product`
--

INSERT INTO sic_product VALUES (1,'The Lord of the Rings',90.5);
INSERT INTO sic_product VALUES (2,'Smart TV',2190);
INSERT INTO sic_product VALUES (3,'Macbook Pro',1250);
INSERT INTO sic_product VALUES (4,'PC Gamer',1200);
INSERT INTO sic_product VALUES (5,'Rails for Dummies',100.99);
INSERT INTO sic_product VALUES (6,'Product 06',100.99);
INSERT INTO sic_product VALUES (7,'Product 07',410.99);
INSERT INTO sic_product VALUES (8,'Product 08',110.99);
INSERT INTO sic_product VALUES (9,'Product 09',200.99);
INSERT INTO sic_product VALUES (10,'Product 10',300.99);
INSERT INTO sic_product VALUES (11,'Product 11',510.99);

--
-- Dumping data for table `sic_product_category`
--

INSERT INTO sic_product_category VALUES (1,2);
INSERT INTO sic_product_category VALUES (2,1);
INSERT INTO sic_product_category VALUES (3,3);
INSERT INTO sic_product_category VALUES (4,3);
INSERT INTO sic_product_category VALUES (5,2);
INSERT INTO sic_product_category VALUES (6,3);
INSERT INTO sic_product_category VALUES (7,4);
INSERT INTO sic_product_category VALUES (8,5);
INSERT INTO sic_product_category VALUES (9,6);
INSERT INTO sic_product_category VALUES (10,6);
INSERT INTO sic_product_category VALUES (11,7);

--
-- Dumping data for table `sic_state`
--

INSERT INTO sic_state VALUES (1,'Rondônia');
INSERT INTO sic_state VALUES (2,'Paraná');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed

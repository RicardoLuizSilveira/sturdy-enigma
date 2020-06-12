DROP TABLE IF EXISTS sic_phones;
DROP TABLE IF EXISTS sic_order_item;
DROP TABLE IF EXISTS sic_product_category;
DROP TABLE IF EXISTS sic_product;
DROP TABLE IF EXISTS sic_category;
DROP TABLE IF EXISTS payment_barr_code;
DROP TABLE IF EXISTS payment_credit_card;
DROP TABLE IF EXISTS sic_payment;
DROP TABLE IF EXISTS sic_order;
DROP TABLE IF EXISTS sic_address;
DROP TABLE IF EXISTS sic_client;
DROP TABLE IF EXISTS sic_city;
DROP TABLE IF EXISTS sic_state;
--
-- Table structure for table `sic_product`
--
CREATE TABLE sic_product (
  id bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  price double DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=12;
--
-- Table structure for table `sic_state`
--
CREATE TABLE sic_state (
  id bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3;
--
-- Table structure for table `sic_city`
--
CREATE TABLE sic_city (
  id bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  state_id bigint DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK6yfg54gw3lauhjpykwcb9mm8p (state_id),
  CONSTRAINT FK6yfg54gw3lauhjpykwcb9mm8p FOREIGN KEY (state_id) REFERENCES sic_state (id)
) ENGINE=InnoDB AUTO_INCREMENT=5;
--
-- Table structure for table `sic_client`
--
CREATE TABLE sic_client (
  id bigint NOT NULL AUTO_INCREMENT,
  email varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  nin_or_nif varchar(255) DEFAULT NULL,
  `type` int DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_29twp2vi9jilmtt17hkx899im (email)
) ENGINE=InnoDB AUTO_INCREMENT=2;
--
-- Table structure for table `sic_address`
--
CREATE TABLE sic_address (
  id bigint NOT NULL AUTO_INCREMENT,
  neighborhood varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  street varchar(255) DEFAULT NULL,
  zip_code varchar(255) DEFAULT NULL,
  city_id bigint DEFAULT NULL,
  client_id bigint DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK8lc53chuwbupul1vykydwaoie (city_id),
  KEY FKpx8pamqdwig364v4r6w3ovfrr (client_id),
  CONSTRAINT FK8lc53chuwbupul1vykydwaoie FOREIGN KEY (city_id) REFERENCES sic_city (id),
  CONSTRAINT FKpx8pamqdwig364v4r6w3ovfrr FOREIGN KEY (client_id) REFERENCES sic_client (id)
) ENGINE=InnoDB AUTO_INCREMENT=3;
--
-- Table structure for table `sic_phones`
--
CREATE TABLE sic_phones (
  client_id bigint NOT NULL,
  phones varchar(255) DEFAULT NULL,
  KEY FK9sp2hsh7t5ydpf574yf2g1yf2 (client_id),
  CONSTRAINT FK9sp2hsh7t5ydpf574yf2g1yf2 FOREIGN KEY (client_id) REFERENCES sic_client (id)
) ENGINE=InnoDB;
--
-- Table structure for table `sic_category`
--
CREATE TABLE sic_category (
  id bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=23;
--
-- Table structure for table `sic_product_category`
--
CREATE TABLE sic_product_category (
  product_id bigint NOT NULL,
  category_id bigint NOT NULL,
  KEY FK3521hsasfw9g6cff30ep9hpjd (category_id),
  KEY FK93ykkckw1buxk8n46enp2pjvp (product_id),
  CONSTRAINT FK3521hsasfw9g6cff30ep9hpjd FOREIGN KEY (category_id) REFERENCES sic_category (id),
  CONSTRAINT FK93ykkckw1buxk8n46enp2pjvp FOREIGN KEY (product_id) REFERENCES sic_product (id)
) ENGINE=InnoDB;
--
-- Table structure for table `sic_order`
--
CREATE TABLE sic_order (
  id bigint NOT NULL AUTO_INCREMENT,
  instant datetime DEFAULT NULL,
  client_id bigint DEFAULT NULL,
  deliver_address_id bigint DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKtc8hvq59svj23pdhffwqbwsnv (client_id),
  KEY FKq48mi36eg2sqapx0fnu9i2n3q (deliver_address_id),
  CONSTRAINT FKq48mi36eg2sqapx0fnu9i2n3q FOREIGN KEY (deliver_address_id) REFERENCES sic_address (id),
  CONSTRAINT FKtc8hvq59svj23pdhffwqbwsnv FOREIGN KEY (client_id) REFERENCES sic_client (id)
) ENGINE=InnoDB AUTO_INCREMENT=3;
--
-- Table structure for table `sic_order_item`
--
CREATE TABLE sic_order_item (
  discount double DEFAULT NULL,
  price double DEFAULT NULL,
  quantity int DEFAULT NULL,
  product_id bigint NOT NULL,
  order_id bigint NOT NULL,
  PRIMARY KEY (order_id,product_id),
  KEY FK4b6ox74wi8uc25po0ldssmv0d (product_id),
  CONSTRAINT FK4b6ox74wi8uc25po0ldssmv0d FOREIGN KEY (product_id) REFERENCES sic_product (id),
  CONSTRAINT FKpvd41k3mq42r50e5uit45628t FOREIGN KEY (order_id) REFERENCES sic_order (id)
) ENGINE=InnoDB;
--
-- Table structure for table `sic_payment`
--
CREATE TABLE sic_payment (
  order_id bigint NOT NULL,
  situation int DEFAULT NULL,
  PRIMARY KEY (order_id),
  CONSTRAINT FKh7fy6yw64tkpgrw5lgm9l3xwm FOREIGN KEY (order_id) REFERENCES sic_order (id)
) ENGINE=InnoDB;
--
-- Table structure for table `payment_barr_code`
--
CREATE TABLE payment_barr_code (
  duedate datetime DEFAULT NULL,
  pay_date datetime DEFAULT NULL,
  order_id bigint NOT NULL,
  PRIMARY KEY (order_id),
  CONSTRAINT FK6o39aiewpi3qmv3tfywk5s42q FOREIGN KEY (order_id) REFERENCES sic_payment (order_id)
) ENGINE=InnoDB;
--
-- Table structure for table `payment_credit_card`
--
CREATE TABLE payment_credit_card (
  number_of_installments int DEFAULT NULL,
  order_id bigint NOT NULL,
  PRIMARY KEY (order_id),
  CONSTRAINT FKsa0hnh9ufi1e7srp7l67r8cbe FOREIGN KEY (order_id) REFERENCES sic_payment (order_id)
) ENGINE=InnoDB;


CREATE USER 'propty'@'%' IDENTIFIED BY 'propty';
GRANT ALL PRIVILEGES ON propty.* TO 'propty'@'%' WITH GRANT OPTION;

CREATE DATABASE IF NOT EXISTS propty;

USE propty;

CREATE TABLE IF NOT EXISTS `auth_user_role` (

	roleid INT UNSIGNED NOT NULL AUTO_INCREMENT,
	rolename VARCHAR(30) NOT NULL unique,
	roletype VARCHAR(30),
	create_date TIMESTAMP,
    index (roleid),
    PRIMARY KEY (roleid)
)
engine = InnoDB
COMMENT = 'User role details';

CREATE TABLE IF NOT EXISTS `auth_user` (

	userid INT UNSIGNED NOT NULL AUTO_INCREMENT,
	firstname VARCHAR(30) NOT NULL,
	middlename VARCHAR(30) NOT NULL,
	lastname VARCHAR(30) NOT NULL,
	dateofbirth date,
	email VARCHAR(100) NOT NULL unique,
	gender VARCHAR(8),
	fk_role INT UNSIGNED NOT NULL,
    image VARCHAR(255),
    phoneno VARCHAR(14),
    mobileno VARCHAR(14),
    addressline1 VARCHAR(100),
    addressline2 VARCHAR(100),
    city VARCHAR(100),
    state VARCHAR(50),
    country VARCHAR(50),
    postcode VARCHAR(10),
    faxno VARCHAR(14),
    alternatecontact VARCHAR(14),
	username VARCHAR(100) NOT NULL unique,
	password VARCHAR(255),
        password_confirm VARCHAR(255),
	isactive VARCHAR(5),
	reg_date TIMESTAMP,
    index (userid),
    PRIMARY KEY (userid),
    FOREIGN KEY (fk_role) REFERENCES auth_user_role(roleid)
		ON DELETE CASCADE ON UPDATE CASCADE
	
)
engine = InnoDB
COMMENT = 'User authorization details';

CREATE TABLE IF NOT EXISTS `accounttype` (
    
    userid INT UNSIGNED NOT NULL,
	accounttypeid INT UNSIGNED NOT NULL AUTO_INCREMENT,
	accounttype VARCHAR(30) NOT NULL unique,
    description VARCHAR(254) NOT NULL,
	create_date TIMESTAMP,
    index (accounttypeid),
    PRIMARY KEY (accounttypeid)
)
engine = InnoDB
COMMENT = 'User role details';

CREATE TABLE IF NOT EXISTS `account` (

	accountid INT UNSIGNED NOT NULL AUTO_INCREMENT,
	currency VARCHAR(3),
    fk_accounttype INT UNSIGNED NOT NULL,
	fk_authuser INT UNSIGNED NOT NULL,
	create_date TIMESTAMP,
    index (accountid),
    PRIMARY KEY (accountid),
    FOREIGN KEY (fk_authuser) REFERENCES auth.auth_user(authuserid)
		on delete restrict on update restrict,
	FOREIGN KEY (fk_accounttype) REFERENCES auth.accounttype(accounttypeid)
		on delete restrict on update restrict
)
engine = InnoDB
COMMENT = 'User account details';

CREATE TABLE IF NOT EXISTS `approver` (

	approverid INT UNSIGNED NOT NULL AUTO_INCREMENT,
	approvername VARCHAR(50) NOT NULL unique,
    fk_authuser INT UNSIGNED NOT NULL,
    fk_authuserrole INT UNSIGNED NOT NULL, -- approver role
    description VARCHAR(255) NOT NULL,
	create_date TIMESTAMP,
    index (approverid),
    PRIMARY KEY (approverid),
	FOREIGN KEY (fk_authuserrole) REFERENCES auth.auth_user_role(authuserroleid) 
		on delete restrict on update restrict,
	FOREIGN KEY (fk_authuser) REFERENCES auth.auth_user(authuserid)
		on delete restrict on update restrict
)
engine = InnoDB
COMMENT = 'Approver details while end user perform any cretical activity';

CREATE TABLE IF NOT EXISTS `userimages` (

	userimagesid INT UNSIGNED NOT NULL AUTO_INCREMENT,
    images_url VARCHAR(255),
    fk_authuser INT UNSIGNED NOT NULL,
    currencysimbol VARCHAR(5),
	save_date TIMESTAMP,
    index (userimagesid),
    PRIMARY KEY (userimagesid),
    FOREIGN KEY (fk_authuser) REFERENCES auth.auth_user(authuserid) 
		on delete restrict on update restrict
)
engine = InnoDB
COMMENT = 'Property specific images'; 

CREATE TABLE IF NOT EXISTS `country` (

	countryid INT UNSIGNED NOT NULL AUTO_INCREMENT,
    countryname VARCHAR(255),
    countrycode VARCHAR(255),
    countryflag VARCHAR(5),
	save_date TIMESTAMP,
    index (countryid),
    PRIMARY KEY (countryid)
)
engine = InnoDB
COMMENT = 'Property specific images'; 

CREATE TABLE IF NOT EXISTS `currency` (

	currencyid INT UNSIGNED NOT NULL AUTO_INCREMENT,
    currencycode VARCHAR(3),
    fk_countrycode INT UNSIGNED NOT NULL,
    currencyname VARCHAR(255),
	save_date TIMESTAMP,
    index (currencyid),
    PRIMARY KEY (currencyid),
    FOREIGN KEY (fk_countrycode) REFERENCES auth.country(countryid) 
		on delete restrict on update restrict
)
engine = InnoDB
COMMENT = 'Property specific images'; 
 
CREATE TABLE IF NOT EXISTS `property_type` (

	propertytypeid INT UNSIGNED NOT NULL AUTO_INCREMENT,
	propertytype VARCHAR(30) NOT NULL unique,
    description VARCHAR(255) NOT NULL,
	create_date TIMESTAMP,
    index (propertytypeid),
    PRIMARY KEY (propertytypeid)
)
engine = InnoDB
COMMENT = 'Property type details';
 
CREATE TABLE IF NOT EXISTS `property` (

	propertyid INT UNSIGNED NOT NULL AUTO_INCREMENT,
    userid INT,
    propertyname VARCHAR(254),
	fk_propertytype INT UNSIGNED NOT NULL,
    images VARCHAR(255),
    construction_area DECIMAL(10,2),
    total_area DECIMAL(10,2),
    total_price DECIMAL(12,2),
    unit_price DECIMAL(10,2),
    no_of_units INT,
    available VARCHAR(1),
    units_sold INT,
    addressline1 VARCHAR(255),
    addressline2 VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    country VARCHAR(255),
    postcode VARCHAR(10),
	description VARCHAR(1000),
	reg_date TIMESTAMP,
    index (propertyid),
    PRIMARY KEY (propertyid),
    FOREIGN KEY (fk_propertytype) REFERENCES cwh.property_type(propertyid) 
		on delete cascade on update cascade
)
engine = InnoDB
COMMENT = 'Property details';

CREATE TABLE IF NOT EXISTS `party_seller` (

    partysellerid INT UNSIGNED NOT NULL AUTO_INCREMENT,
    userid INT NOT NULL,
    fk_property INT UNSIGNED NOT NULL,
    description VARCHAR(255) NOT NULL,
    reg_date TIMESTAMP NOT NULL,
    index (partysellerid),
    PRIMARY KEY (partysellerid),
    FOREIGN KEY (fk_property) REFERENCES cwh.property_type(propertyid) 
		on delete cascade on update cascade
)
engine = InnoDB
COMMENT = 'Seller party details';

CREATE TABLE IF NOT EXISTS `party_buyer` (

    partybuyerid INT UNSIGNED NOT NULL AUTO_INCREMENT,
    userid INT NOT NULL,
    no_of_units INT NOT NULL,
    currency VARCHAR(3) NOT NULL,
    fk_property INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    reg_date TIMESTAMP NOT NULL,
    index (partybuyerid),
    PRIMARY KEY (partybuyerid),
    FOREIGN KEY (fk_property) REFERENCES cwh.property_type(propertytypeid) 
		on delete cascade on update cascade
)
engine = InnoDB
COMMENT = 'buyer party details';

CREATE TABLE IF NOT EXISTS `images_property` (

	propertyimagesid INT UNSIGNED NOT NULL AUTO_INCREMENT,
    images_url INT NOT NULL,
    fk_property INT UNSIGNED NOT NULL,
    currency_simbol VARCHAR(5),
	save_date TIMESTAMP,
    index (propertyimagesid),
    PRIMARY KEY (propertyimagesid),
    FOREIGN KEY (fk_property) REFERENCES cwh.property(propertyid) 
		on delete restrict on update restrict
)
engine = InnoDB
COMMENT = 'Property specific images';

CREATE TABLE IF NOT EXISTS `status_reason` (

	reasonid INT UNSIGNED NOT NULL AUTO_INCREMENT,
	reasonname VARCHAR(30) NOT NULL unique,
    description VARCHAR(255) NOT NULL,
	create_date TIMESTAMP,
    index (reasonid),
    PRIMARY KEY (reasonid)
)
engine = InnoDB
COMMENT = 'status reason description';

CREATE TABLE IF NOT EXISTS `paymentinfo` (

	paymentinfoid INT UNSIGNED NOT NULL AUTO_INCREMENT,
    userid INT,
	amount DECIMAL(8,2) NOT NULL,
    currency VARCHAR(80),
    bankname VARCHAR(80),
    no_of_units INT,
    fk_property INT UNSIGNED NOT NULL,
	payment_date TIMESTAMP,
    paymentstatus VARCHAR(4), -- INIT - initiated, INPR- in-progress, COMP- completed 
    index (paymentinfoid),
    PRIMARY KEY (paymentinfoid),
    FOREIGN KEY (fk_property) REFERENCES cwh.property(propertyid) 
		on delete restrict on update restrict
)
engine = InnoDB
COMMENT = 'Payment details of property buying and selling';

CREATE TABLE IF NOT EXISTS `settlement` (

	settlementid INT UNSIGNED NOT NULL AUTO_INCREMENT,
    fk_paymentinfo INT UNSIGNED NOT NULL,
	amount DECIMAL(8,2) NOT NULL,
    currency VARCHAR(80),
    no_of_units INT,
    commission DECIMAL(8,2) NOT NULL, -- commission deducted from buyer of property (around 2.5%)
    fk_property INT UNSIGNED NOT NULL,
	payment_date TIMESTAMP,
    index (settlementid),
    PRIMARY KEY (settlementid),
    FOREIGN KEY (fk_paymentinfo) REFERENCES cwh.paymentinfo(paymentinfoid) 
		on delete restrict on update restrict,
	FOREIGN KEY (fk_property) REFERENCES cwh.property(propertyid) 
		on delete restrict on update restrict
)
engine = InnoDB
COMMENT = 'Payment details of property buying and selling';


CREATE TABLE IF NOT EXISTS `rental_income` (

	rentalincomeid INT UNSIGNED NOT NULL AUTO_INCREMENT,
	amount DECIMAL(8,2) NOT NULL,
    currency VARCHAR(80),
    bankname VARCHAR(80), -- bank name of transferred amount from tenant
    fk_property INT UNSIGNED NOT NULL,
    description VARCHAR(255) NOT NULL,
	payment_date TIMESTAMP,
    paymentstatus VARCHAR(4), -- INIT - initiated, INPR- in-progress, COMP- completed 
    index (rentalincomeid),
    PRIMARY KEY (rentalincomeid),
    FOREIGN KEY (fk_property) REFERENCES cwh.property(propertyid) 
		on delete restrict on update restrict
)
engine = InnoDB
COMMENT = 'rental income from tenant';

CREATE TABLE IF NOT EXISTS `income_share` (

	incomeshareid INT UNSIGNED NOT NULL AUTO_INCREMENT,
	amount_per_unit DECIMAL(8,2) NOT NULL,
    buyer_units INT,
    currency VARCHAR(80),
    userid INT(10),
    fk_property INT UNSIGNED NOT NULL,
    description VARCHAR(255) NOT NULL,
	payment_date TIMESTAMP,
    paymentstatus VARCHAR(4), -- INIT - initiated, INPR- in-progress, COMP- completed 
    index (incomeshareid),
    PRIMARY KEY (incomeshareid),
    FOREIGN KEY (fk_property) REFERENCES cwh.property(propertyid) 
		on delete restrict on update restrict
)
engine = InnoDB
COMMENT = 'rental income from tenant';

CREATE TABLE IF NOT EXISTS `contents` (

	contentid INT UNSIGNED NOT NULL AUTO_INCREMENT,
	pagetitle VARCHAR(255) NOT NULL,
    pagesubtitle VARCHAR(255),
    pagesubsubtitle VARCHAR(255),
    content text(50000),
    remarks text(50000),
    index (contentid),
    PRIMARY KEY (contentid)
)
engine = InnoDB
COMMENT = 'rental income from tenant';

CREATE TABLE IF NOT EXISTS `contactus` (

	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	personname VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    contact VARCHAR(255),
    message text(50000),
    reg_date TIMESTAMP,
    index (id),
    PRIMARY KEY (id)
)
engine = InnoDB
COMMENT = 'rental income from tenant';
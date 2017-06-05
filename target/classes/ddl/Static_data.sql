USE propty;
INSERT INTO accounttype (ACCOUNTTYPE, DESCRIPTION, CREATE_DATE) VALUES ('buyer', 'who can approve user', sysdate());
INSERT INTO accounttype (ACCOUNTTYPE, DESCRIPTION, CREATE_DATE) VALUES ('seller', 'user who registered on website', sysdate());
INSERT INTO accounttype (ACCOUNTTYPE, DESCRIPTION, CREATE_DATE) VALUES ('tenant', 'tenant who pay rent on property', sysdate());

INSERT INTO auth_user_role (rolename, roletype, CREATE_DATE) VALUES ('USER', 'user_register', sysdate());
INSERT INTO auth_user_role (rolename, roletype, CREATE_DATE) VALUES ('SUPPORT', 'support_team', sysdate());
INSERT INTO auth_user_role (rolename, roletype, CREATE_DATE) VALUES ('MANAGER', 'manager', sysdate());
INSERT INTO auth_user_role (rolename, roletype, CREATE_DATE) VALUES ('SR_MANAGE', 'sr_management', sysdate());
INSERT INTO auth_user_role (rolename, roletype, CREATE_DATE) VALUES ('ADMIN', 'all_rights', sysdate());
INSERT INTO auth_user_role (rolename, roletype, CREATE_DATE) VALUES ('APPROVER', 'approver', sysdate());

INSERT INTO property_type (propertytype, description, CREATE_DATE) VALUES ('Commercial', 'used for business purpose', sysdate());
INSERT INTO property_type (propertytype, description, CREATE_DATE) VALUES ('Flat', 'flat in a multi floor building', sysdate());
INSERT INTO property_type (propertytype, description, CREATE_DATE) VALUES ('Apartment', 'type of flat sometimes calles as apartment', sysdate());
INSERT INTO property_type (propertytype, description, CREATE_DATE) VALUES ('Plot', 'blank land', sysdate());
INSERT INTO property_type (propertytype, description, CREATE_DATE) VALUES ('Under Contruction', 'property under construction', sysdate());

INSERT INTO country(countryname, countrycode, save_date) values ('India', 'IN', sysdate());
INSERT INTO country(countryname, countrycode, save_date) values ('Norway', 'NO', sysdate());
INSERT INTO country(countryname, countrycode, save_date) values ('USA', 'US', sysdate());
INSERT INTO country(countryname, countrycode, save_date) values ('United Kingdom', 'UK', sysdate());
INSERT INTO country(countryname, countrycode, save_date) values ('Germany', 'DE', sysdate());
INSERT INTO country(countryname, countrycode, save_date) values ('Sweden', 'SE', sysdate());

INSERT INTO `propty`.`contents` (`pagetitle`, `pagesubtitle`, `content`, `remarks`) VALUES ('Home', 'imageslider1', 'Now you can buy property anywhere in the world. Just select the property and buy.', 'image text');
INSERT INTO `propty`.`contents` (`pagetitle`, `pagesubtitle`, `content`, `remarks`) VALUES ('Home', 'imageslider2', 'We are World\'s largest marketplace for investors, offering opportunities not available on the general market.', 'image text');
INSERT INTO `propty`.`contents` (`pagetitle`, `pagesubtitle`, `content`, `remarks`) VALUES ('Home', 'imageslider3', 'We are specialized to serve high-value opportunity for investment which gives more profitable returns', 'image text');
INSERT INTO `propty`.`contents` (`pagetitle`, `pagesubtitle`, `pagesubsubtitle`, `content`, `remarks`) VALUES ('Home', 'Targeted Investment', 'Available to rent out Land and Properties', 'We always prioritize the land and properties those are ready to rent out. Our specialized team evaluate the property price rise in coming years. So that investors can get maximum benefit out of his investment. We share the rental income from the investment and when property sold out we share the core amount along with the profit earned.', 'We have specialized team to identify the best investment options in all covered geolocation and negotiate to purchase in the best possible minimum value. This usually be 20-30% less then from the original market price of the property.');
INSERT INTO `propty`.`contents` (`pagetitle`, `pagesubtitle`, `pagesubsubtitle`, `content`, `remarks`) VALUES ('Home', 'Geolocation', 'We are in Asain and European countries and targeting more countries', 'As of now we cover Asian and European countries where our specialized team identified a good growth in prices of the property. We are still in process of exploring more locations at global level for best investment options where investors can earn maximum profit out of his investment.', 'Our specialized team who take care to explore more options is in process of dealing and accomplishing legal activities required to make any purchase to minimize any uncertain conditions of loses. This way we ensure to keep your investment save and secure.');
INSERT INTO `propty`.`contents` (`pagetitle`, `pagesubtitle`, `pagesubsubtitle`, `content`, `remarks`) VALUES ('Home', 'Business Strategy', 'Rent out the property as soon as possible and sale after 4-5 years', 'Our business strategy is very clear and straight forward. Land and property considered to be safest option of investment. In the past, it is noticed that property rates are increasing in all over the world. Our main focus are on three activities i.e. purchase, renting out and sell of property where we can earn profit through rental income and income from selling property after 4-5 years.', 'Transparency is our first agenda. Portal provides all information of yours and others investment except any personal information of other investor. All income from investment is been shared with share holder of the investment. We ease your work to identify the best investment options cross world and in exchange we charge small amount to cover business running expenses. It is 2.5% on all investments and incomes.');
INSERT INTO `propty`.`contents` (`pagetitle`, `pagesubtitle`, `pagesubsubtitle`, `content`, `remarks`) VALUES ('Home', 'Sell out Options', 'Investor can sell out his share at any point of time', 'We understand that anyone might need money at any point of time. Keeping in mind this condition, we provide the options to sell out you shares to any other third party. Where we help to publish your share in our portal to attract investors to purchase your share. Our portal serves the purpose to list your shares to interested public. However, we do not take guaranty to sell shares.', 'We display your shares in the portal for sells with other investment options. Here anyone interested can buy your share just like share market work. Investor is free to sell his shares at any time, we do not bind investor with any terms and conditions for re-sell his shares and also we do not charge any amount on resell.');
INSERT INTO `propty`.`contents` (`pagetitle`, `pagesubtitle`, `pagesubsubtitle`, `content`, `remarks`) VALUES ('Home', 'Footer', 'aboutus', 'join with us to get new ways to invest and earn profit in today\'s volatile world market. Share your experience with us on links provided.', 'test only');

INSERT INTO currency(currencycode, fk_countrycode, currencyname, save_date) values ('INR', 1, 'Indian Rupee', sysdate());
INSERT INTO currency(currencycode, fk_countrycode, currencyname, save_date) values ('NOK', 2, 'Norwegian Krone', sysdate());
INSERT INTO currency(currencycode, fk_countrycode, currencyname, save_date) values ('USD', 3, 'US Dollar', sysdate());
INSERT INTO currency(currencycode, fk_countrycode, currencyname, save_date) values ('GBP', 4, 'British Pound', sysdate());
INSERT INTO currency(currencycode, fk_countrycode, currencyname, save_date) values ('EUR', 5, 'Euro', sysdate());
INSERT INTO currency(currencycode, fk_countrycode, currencyname, save_date) values ('SEK', 6, 'Swedish Krone', sysdate());

INSERT INTO approver (approvername, fk_authuser, fk_authuserrole, description, CREATE_DATE) VALUES ('Abhishek', 1, 5, 'abhsjkd', sysdate());
INSERT INTO approver (approvername, fk_authuser, fk_authuserrole, description, CREATE_DATE) VALUES ('Naveen', 1, 5, 'abhsjkd', sysdate());

INSERT INTO auth_user (firstname, middlename, lastname, fk_role, dateofbirth, email, phoneno, mobileno, username, password, isactive, gender, reg_date)
	values ('Abhishek', 'Singh', 'Rajawat', 1, date('1986/02/18'), 'abhishek.rajawat10@gmail.com', '', '+4797381745', 'abhishek.rajawat10@gmail.com', 'password', 'Y', 'male', sysdate());
INSERT INTO auth_user (firstname, middlename, lastname, fk_role, dateofbirth, email, phoneno, mobileno, addressline1, addressline2, city, state, country, postcode, username, password, isactive, gender, reg_date)
	values ('Naveen', 'Kumar', 'Vasudevan', 1, date('1985/02/18'), 'abhishek.rajawat12@gmail.com', '', '+4795174867', 'Ovre flyingvein', 'hdsahd', 'Oslo', 'Hordaland', 'Norway', '5040', 'abhishek.rajawat12@gmail.com', 'password', 'Y', 'male', sysdate());

INSERT INTO propty.property(userid, propertyname, fk_propertytype, images, construction_area, total_area, total_price, unit_price,
	no_of_units, available, units_sold, addressline1, addressline2, city, state, country, description, reg_date) 
	values (1, 'Villa', 1, '', 1200.40, 1400.00, 2000000.00, 40000.00, 50, 'Y', 20, 'address line 1', 'address line 2', 'City', 'State', 'Country', 'Best opportunity to invest in most success full project company is going to purchase', sysdate());

INSERT INTO propty.property(userid, propertyname, fk_propertytype, images, construction_area, total_area, total_price, unit_price,
	no_of_units, available, units_sold, addressline1, addressline2, city, state, country, description, reg_date) 
	values (2, 'Villa1', 1, '', 1200.40, 1400.00, 1000000.00, 20000.00, 50, 'Y', 20, 'address line 1', 'address line 2', 'Hordaland', 'Bergen', 'Norway', 'Best opportunity to invest in most success full project company is going to purchase', sysdate());
	
INSERT INTO propty.property(userid, propertyname, fk_propertytype, images, construction_area, total_area, total_price, unit_price,
	no_of_units, available, units_sold, addressline1, addressline2, city, state, country, description, reg_date) 
	values (1, 'Villa2', 2, '', 1200.40, 1400.00, 3000000.00, 60000.00, 50, 'Y', 20, 'address line 1', 'address line 2', 'Bangalore', 'Karnataka', 'India', 'Best opportunity to invest in most success full project company is going to purchase', sysdate());

INSERT INTO property(userid, propertyname, fk_propertytype, images, construction_area, total_area, total_price, unit_price,
	no_of_units, available, units_sold, addressline1, addressline2, city, state, country, description, reg_date) 
	values (1, 'Villa3', 2, '', 1200.40, 1400.00, 6000000.00, 100000.00, 60, 'Y', 20, 'address line 1', 'address line 2', 'Delhi', 'Delhi', 'India', 'This is awesome', sysdate());

commit;
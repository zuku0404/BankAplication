create table account(
id int(10) primary key ,
password varchar (20) not null);

INSERT INTO account
values (1,'asdDSs234234242'),
    (2,'fdvSA252030423'),
    (3,'f!dsdA4323214242'),
    (6,'dsaFDASFdfj');

 create table transfer (
 id_transfer int (10) primary key,
 id_user int (10),
 id_user_recipient varchar (20),
 transfer_type varchar (20) not null,
 transfer_cash decimal,
 title varchar (50) not null);

INSERT INTO transfer
values (4,6,'6','deposit',50,'payment of money'),
       (36,6,'6','deposit',100,'payment of money'),
       (68,6,'6','deposit',50,'payment of money'),
       (69,6,'6','deposit',50,'payment of money'),
       (101,6,'6','deposit',10,'payment of money'),
       (102,6,'6','deposit',10,'payment of money'),
       (134,6,'6','deposit',10,'payment of money'),
       (135,6,'6','deposit',10,'payment of money'),
       (136,6,'6','deposit',10,'payment of money'),
       (137,6,'6','deposit',10,'payment of money'),
       (169,6,'6','deposit',20,'payment of money'),
       (201,6,'6','credit card',-50,'cash withdrawal at an ATM'),
       (233,6,'6','credit card',-50,'cash withdrawal at an ATM'),
       (265,6,'3','transfer',-20,'title:'),
       (297,6,'6','deposit',50,'payment of money'),
       (298,6,'5','transfer',-20,'przelew'),
       (362,6,'6','deposit',50,'payment of money'),
       (363,6,'6','deposit',20,'payment of money'),
       (364,6,'6','credit card',-123,'cash withdrawal at an ATM'),
       (365,6,'6','credit card',200,'cash withdrawal at an ATM'),
       (366,6,'6','credit card',0,'cash withdrawal at an ATM'),
       (395,6,'6','credit card',0,'cash withdrawal at an ATM'),
       (396,6,'6','credit card',0,'cash withdrawal at an ATM'),
       (427,6,'6','credit card',-100,'cash withdrawal at an ATM'),
       (428,6,'6','credit card',-50,'cash withdrawal at an ATM'),
       (429,6,'6','credit card',-50,'cash withdrawal at an ATM'),
       (430,6,'6','credit card',-50,'cash withdrawal at an ATM'),
       (431,6,'6','credit card',-60,'cash withdrawal at an ATM'),
       (460,6,'6','credit card',-20,'cash withdrawal at an ATM'),
       (461,6,'6','deposit',20,'payment of money'),
       (462,6,'6','credit card',-20,'cash withdrawal at an ATM'),
       (494,6,'6','deposit',20,'payment of money'),
       (526,6,'6','credit card',-10,'cash withdrawal at an ATM'),
       (558,6,'6','credit card',-10,'cash withdrawal at an ATM'),
       (559,6,'6','credit card',-7,'cash withdrawal at an ATM'),
       (560,6,'6','deposit',20,'payment of money'),
       (561,6,'6','deposit',20,'payment of money'),
       (562,6,'6','credit card',-10,'cash withdrawal at an ATM'),
       (594,6,'6','deposit',10,'payment of money'),
       (626,6,'6','deposit',10,'payment of money'),
       (627,6,'6','credit card',-20,'cash withdrawal at an ATM'),
       (628,6,'6','credit card',-10,'cash withdrawal at an ATM'),
       (629,6,'6','deposit',20,'payment of money'),
       (660,6,'6','deposit',10,'payment of money'),
       (661,6,'6','credit card',0,'cash withdrawal at an ATM'),
       (693,6,'1','transfer',0,'dsd'),
       (725,6,'6','deposit',10,'payment of money'),
       (757,6,'2','transfer',-23,'a'),
       (789,6,'6','deposit',10,'payment of money'),
       (790,6,'6','credit card',-10,'cash withdrawal at an ATM');

 create table users (
 id int(10) primary key,
 pesel varchar (20) not null,
 name varchar (20) not null,
 surname varchar (20) not null,
 date_of_birth varchar (20) not null,
 login varchar (20) not null,
 account_number varchar (50) not null);

INSERT INTO users
values (1,'47091716452','Pawel','Kowalski','17-09-1947','mimi','11401483511375550113866197'),
       (2,'97051754538','Tomasz','Ogorek','17-05-1997','nskjdfnasW','11408693591542191224851553'),
       (3,'62071231893','Bozena','Pomidor','12-07-1962','SDsdsafd','11405543886132830506854188'),
       (6,'03290561659','Jerzy','Brzęczek','05-29-1903','eeWwfefE','11402866429075064350688546');
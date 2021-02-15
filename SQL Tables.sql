create table users(
			uid int not null primary key,
            uname varchar(20) not null,
            password varchar(20) not null,
            flag int);

create table invoice_master(
			billno varchar(20) not null primary key,
            billdate date not null,
            customerid varchar(20) not null,
            discount int,
            gst int
            );

create table invoice_transaction(
			billno varchar(20) not null primary key,
            itemid varchar(20) not null,
            qty int not null
            );

create table item_master(
			itemid varchar(10) not null primary key,
            itemdescription varchar(50) not null,
            unit varchar(20) not null,
            price int not null,
            imageurl varchar(60),
            shopid varchar(10) not null
            );

create table shop_master(
			shopid varchar(10) not null primary key,
            shopname varchar(20) not null
            );
            
create table e_cart(
			uid int not null,
            itemid varchar(20) not null primary key,
            qty int not null
            );
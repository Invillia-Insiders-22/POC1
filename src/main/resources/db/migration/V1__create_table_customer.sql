create table customer (
	id varchar(255) primary key,
	name varchar(255) not null,
	email varchar (255) not null unique,
	document int not null unique,
	document_type enum('PF', 'PJ') not null,
	phone_number int not null
);
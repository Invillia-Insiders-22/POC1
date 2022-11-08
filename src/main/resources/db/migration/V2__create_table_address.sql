create table tb_address (
	id varchar(255) primary key,
	city varchar(255) not null,
	neighborhood varchar(255) not null,
	address_number varchar(255) not null,
	complement varchar(255),
	cep varchar(255) not null,
	customer_id varchar(255) not null,
	foreign key (customer_id) references tb_customer(id)
);
-- CRIA A DATABASE
create database projeto_HumQueCaro;

-- SELECIONA A DATABASE
use projeto_HumQueCaro;


-- CRIA TABELA USUARIO
create table usuarios(
	codigo int not null auto_increment,
	email varchar(60) not null,
	nome varchar(80) not null,
	senha varchar(30) not null,
	PRIMARY KEY (codigo),
	UNIQUE (email)
);


-- CRIA TABELA PRODUTO
create table produtos(
	codigo int not null auto_increment,
	codigo_barras varchar(60) not null,
	nome varchar(80) not null,
	fabricante varchar(80) not null,
	valor varchar(10) not null,
	PRIMARY KEY (codigo),
	UNIQUE (codigo_produto)
);


-- CRIA TABELA CLIENTE
create table clientes(
	codigo int not null auto_increment,
	telefone char(11) not null,
	nome varchar(80) not null,
	PRIMARY KEY (codigo),
	UNIQUE (telefone)
);

-- CRIA TABELA PEDIDO
create table pedidos(
	codigo int not null auto_increment,
	telefone_cliente char(11) not null,
	situacao varchar(10) not null,
	
	PRIMARY KEY(codigo),
	FOREIGN KEY (telefone_cliente) references clientes(telefone)
);

-- CRIA TABELA PRODUTOS_DE_PEDIDO
create table produtos_de_pedido(
	codigo_pedido int not null,
	codigo_produto varchar(60) not null,

	FOREIGN KEY (codigo_pedido) references pedidos(codigo),
	FOREIGN KEY (codigo_produto) references produtos(codigo_produto)
)


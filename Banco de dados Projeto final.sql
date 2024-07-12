create database db_sustentavel;

use db_sustentavel;

create table tb_servico(
servico_id bigint auto_increment,
nome_servico varchar(255)not null,
descricao varchar (1000),
valor decimal(6,2)not null,
primary key (servico_id));

create table tb_categoria(
categoria_id bigint auto_increment,
nome_categoria varchar(255) not null,
descricao varchar(1000),
primary key (categoria_id));

create table tb_usuario(
usuario_id bigint auto_increment,
nome_usuario varchar(255)not null,
email varchar (255)not null,
cpf varchar(15) not null,
data_nascimento date not null,
endereço varchar (1000),
primary key (usuario_id));

ALTER TABLE tb_usario ADD senha VARCHAR(255) NOT NULL;

alter table tb_servico add categoriaid bigint;

ALTER TABLE tb_servico ADD usuarioid bigint;

ALTER TABLE tb_servico ADD CONSTRAINT fk_servico_categorias 
FOREIGN KEY (categoriaid) REFERENCES tb_categoria (categoria_id);

ALTER TABLE tb_servico ADD CONSTRAINT fk_servico_usuario 
FOREIGN KEY (usuarioid) REFERENCES tb_usuario (usuario_id);

ALTER TABLE tb_usuario add foto varchar(1000);

ALTER TABLE tb_usuario modify column email varchar(255) unique;

ALTER TABLE tb_usuario drop column  senha;

ALTER TABLE tb_servico add Sobre_mim varchar(2000);
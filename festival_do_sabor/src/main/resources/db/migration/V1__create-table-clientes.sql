create table clientes(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(11) not null unique,
    senha varchar(255) not null,
    data_de_nascimento DATE,
    regiao_onde_vive varchar(100) not null,

    primary key(id)

);
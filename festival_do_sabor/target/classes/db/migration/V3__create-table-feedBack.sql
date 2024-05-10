create table feedBack (

    id bigint not null auto_increment,
    nome varchar(100) not null unique,
    texto varchar(300) not null unique,

    primary key(id)
);

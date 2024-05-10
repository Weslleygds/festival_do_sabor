create table cardapio (

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    imagem varchar(250) not null unique,
    preço varchar(30) not null,

    primary key(id)
);

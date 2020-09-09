



//drop hibernate sequence if exists
    drop sequence if exists hibernate_sequence;

    //create hibernate sequence start from 1
    create sequence hibernate_sequence start with 1 increment by 70;

create table user(
    id bigint auto_increment primary key ,
    username varchar(80) not null unique ,
    password varchar(190) not null
);


insert into user(username, password) VALUES ( 'user','$2y$12$1Wft9stPYdd0Lk5LAimOreTr/4cYl6zT9jfWqJ8uPvPl8m8YtNboq' );
insert into user(username, password) VALUES ( 'admin','$2y$12$aSQplBZY4v9PuHQNyQrPPuTZu.R9St4kzBZHcdv8/v39jYy157A4W' );



















# Estante de livros

Aplicação para representar uma estante de livros, no qual podemos adicionar livros com codigo, nome e autor.
Foi utilizado o banco de dados MySQL e a criacao do banco e da tabela foi feita da seguinte forma:

create database estante;
use estante;
create table livros(
    codigo int primary key,
    nome text not null,
    autor varchar(100) not null
);
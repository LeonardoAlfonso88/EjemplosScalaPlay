# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table book (
  idbook                        bigint auto_increment not null,
  nombre                        varchar(255),
  autor                         varchar(255),
  user_id_user                  bigint,
  constraint pk_book primary key (idbook)
);

create table target (
  _id                           bigint not null,
  _code                         integer not null
);

create table user (
  iduser                        bigint auto_increment not null,
  nombre                        varchar(50) not null,
  edad                          integer not null,
  constraint pk_user primary key (iduser)
);

alter table book add constraint fk_book_user_id_user foreign key (user_id_user) references user (iduser) on delete restrict on update restrict;
create index ix_book_user_id_user on book (user_id_user);


# --- !Downs

alter table book drop foreign key fk_book_user_id_user;
drop index ix_book_user_id_user on book;

drop table if exists book;

drop table if exists target;

drop table if exists user;


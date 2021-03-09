

create database if not exists test_db default charset utf8 collate utf8_general_ci;

create table user_1(
id int(11) primary  key not null comment '主键',
user_name varchar(128) default null comment '名称',
user_password int(11) default null comment '用户密码'
);
create table user_2(
id int(11) primary  key not null comment '主键',
user_name varchar(128) default null comment '名称',
user_password int(11) default null comment '用户密码'
)
create table user_3(
id int(11) primary  key not null comment '主键',
user_name varchar(128) default null comment '名称',
user_password int(11) default null comment '用户密码'
)
create table user_4(
id int(11) primary  key not null comment '主键',
user_name varchar(128) default null comment '名称',
user_password int(11) default null comment '用户密码'
)
create database shop_db;
use shop_db;

create table goods(
    goods_id int primary key comment '商品编号',
    goods_name varchar(32) comment '商品名称',
     unitprice double comment '单价' check ( unitprice in (1.0,9999.99)) ,
    category varchar(32) comment '商品类别'

);
select * from goods;

create table customer (
    customer_id int primary key comment '顾客编号',
    name varchar(32) not null comment '顾客姓名',
    address varchar(32) comment '顾客地址',
    email varchar(32) unique comment '顾客邮箱',
    sex varchar(6) comment '顾客性别' check ( sex in ('男','女')),
    card_Id varchar(32) comment '顾客身份证号码'
);

create table purchase (
    order_id int primary key comment '订单编号',
    customer_id int not null comment '顾客编号',
    goods_id int not null comment '商品编号',
    num int not null comment '购买数量',
    foreign key (customer_id) references customer (customer_id),
    foreign key (goods_id) references goods (goods_id)
);






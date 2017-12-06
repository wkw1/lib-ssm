-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE lib;
-- 使用数据库
use lib;
-- 创建并初始化图书表
CREATE TABLE books(
  `book_ISBN` varchar(30) not null comment '书的ISBN',
  `book_img_src` varchar(100) default  '/img/book/bookdefault.jpg' comment '书的封面',
  `book_name` varchar(120) not null comment 'bookName',
  `book_introduction` text not null comment '书的简介',
  `book_author` varchar(30) not null comment '书的作者',
  `book_press` varchar(30) not null comment '出版社',
  `total_number` int not null comment '书的总数量',
  `remaining_number` int not null comment '书的剩余数量',
  `power_need` int not null comment '借书所需权限，1,2,3，数字越大权限越大',
  `storage_time` timestamp not null default current_timestamp comment '书的存储时间',
  `book_type` varchar(30) not null comment '书的类型',
  primary key(book_ISBN),
  key idx_storage_time(storage_time),
  key ISBN(book_ISBN)
)ENGINE =InnoDB DEFAULT CHARSET=utf8 COMMENT ='图书列表';

-- 初始化图书数据
INSERT INTO books(book_ISBN,book_name,book_introduction,book_author,book_press,total_number,
                  remaining_number,power_need,book_type)
    VALUES
      ('83893hfiaufhdi7ya3q','lib-ssm开发','这是一本假书','wkw','bupt',10,10,1,'计算机'),
      ('4324tgrhter54grrwrw','lib-ssm开发2','这是一本真书','wkw','bupt',10,10,1,'计算机'),
      ('42tgfsgfdagfd','lib-ssm开发3','这是一本真书','wkw','bupt',10,10,1,'计算机'),
      ('dshrwrfshhwrgr','ssm框架入门','垃圾','wkw','bupt',10,10,1,'计算机'),
      ('rwy54wgfsjy64ehtth','lib-ssm开发2','准垃圾','wkw','hhhh',110,110,1,'计算机');


-- 创建借书表
CREATE TABLE borrow_books(
  `borrow_ID` int not null auto_increment comment '借阅编号',
  -- `stu_name` varchar(30) not null comment '学生姓名',
  `stu_ID` varchar(20) not null comment '学生ID',
  -- `book_name` varchar(30) not null comment '书名',
  `book_ISBN` varchar(30) not null comment '书的编号',
  `borrow_time` timestamp not null default current_timestamp comment '借书时间',
  `expect_return_time` timestamp not null comment '应还时间',
  primary key(borrow_ID)
)ENGINE =InnoDB DEFAULT CHARSET=utf8 COMMENT ='借书列表';

-- 创建还书表
CREATE TABLE return_books(
  `borrow_ID` int not null comment '借阅编号',
  -- `stu_name` varchar(30) not null comment '学生姓名',
  `stu_ID` varchar(20) not null comment '学生ID',
  -- `book_name` varchar(30) not null comment '书名',
  `book_ISBN` varchar(30) not null comment '书的编号',
  `borrow_time` timestamp not null comment '借书时间',
  `return_time` timestamp not null default current_timestamp comment '还书时间',
  primary key(borrow_ID)
)ENGINE =InnoDB DEFAULT CHARSET=utf8 COMMENT ='借书列表';

-- 创建学生用户表

DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `stu_ID` varchar(15) NOT NULL,
  `stu_name` varchar(30) NOT NULL,
  `school` varchar(30) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `power` tinyint(4) NOT NULL DEFAULT '1',
  `borrow_number` tinyint(4) NOT NULL DEFAULT '0',
  `head_img` varchar(120) DEFAULT '/img/book/bookdefault.jpg',
  PRIMARY KEY (`stu_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生列表';
SET FOREIGN_KEY_CHECKS=1;

-- 插入用户数据
INSERT INTO students(stu_ID, stu_name, school, phone, email)
   VALUES
     ('2015211383','wkw','计算机学院','13051883232','97328398@163.com'),
     ('2015211333','wkw','计算机学院','54554545455','54@163.com'),
     ('2015211353','haoren','计算机学院','13051883232','97328398@163.com');


-- 创建预约表
use lib;

create table order_books(
  -- `order_ID` int not null auto_increment comment '预约编号 唯一', 不要了
  `stu_ID` varchar(15) not null comment '学号ID',
  `book_ISBN` varchar(30) not null comment '书的ISBN',
  `order_time` timestamp not null default current_timestamp comment '预约时间',
  -- primary key(order_ID),
  key order_time(order_time)
) ENGINE =InnoDB DEFAULT CHARSET=utf8 COMMENT ='预约列表';


use lib;
alter table order_books drop column order_ID;
alter table order_books add primary key (stu_ID,book_ISBN);


use lib;
alter table students add column head_img varchar(120) default '/img/book/bookdefault.jpg';
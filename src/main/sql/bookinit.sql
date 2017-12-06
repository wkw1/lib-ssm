-- ���ݿ��ʼ���ű�

-- �������ݿ�
CREATE DATABASE lib;
-- ʹ�����ݿ�
use lib;
-- ��������ʼ��ͼ���
CREATE TABLE books(
  `book_ISBN` varchar(30) not null comment '���ISBN',
  `book_img_src` varchar(100) default  '/img/book/bookdefault.jpg' comment '��ķ���',
  `book_name` varchar(120) not null comment 'bookName',
  `book_introduction` text not null comment '��ļ��',
  `book_author` varchar(30) not null comment '�������',
  `book_press` varchar(30) not null comment '������',
  `total_number` int not null comment '���������',
  `remaining_number` int not null comment '���ʣ������',
  `power_need` int not null comment '��������Ȩ�ޣ�1,2,3������Խ��Ȩ��Խ��',
  `storage_time` timestamp not null default current_timestamp comment '��Ĵ洢ʱ��',
  `book_type` varchar(30) not null comment '�������',
  primary key(book_ISBN),
  key idx_storage_time(storage_time),
  key ISBN(book_ISBN)
)ENGINE =InnoDB DEFAULT CHARSET=utf8 COMMENT ='ͼ���б�';

-- ��ʼ��ͼ������
INSERT INTO books(book_ISBN,book_name,book_introduction,book_author,book_press,total_number,
                  remaining_number,power_need,book_type)
    VALUES
      ('83893hfiaufhdi7ya3q','lib-ssm����','����һ������','wkw','bupt',10,10,1,'�����'),
      ('4324tgrhter54grrwrw','lib-ssm����2','����һ������','wkw','bupt',10,10,1,'�����'),
      ('42tgfsgfdagfd','lib-ssm����3','����һ������','wkw','bupt',10,10,1,'�����'),
      ('dshrwrfshhwrgr','ssm�������','����','wkw','bupt',10,10,1,'�����'),
      ('rwy54wgfsjy64ehtth','lib-ssm����2','׼����','wkw','hhhh',110,110,1,'�����');


-- ���������
CREATE TABLE borrow_books(
  `borrow_ID` int not null auto_increment comment '���ı��',
  -- `stu_name` varchar(30) not null comment 'ѧ������',
  `stu_ID` varchar(20) not null comment 'ѧ��ID',
  -- `book_name` varchar(30) not null comment '����',
  `book_ISBN` varchar(30) not null comment '��ı��',
  `borrow_time` timestamp not null default current_timestamp comment '����ʱ��',
  `expect_return_time` timestamp not null comment 'Ӧ��ʱ��',
  primary key(borrow_ID)
)ENGINE =InnoDB DEFAULT CHARSET=utf8 COMMENT ='�����б�';

-- ���������
CREATE TABLE return_books(
  `borrow_ID` int not null comment '���ı��',
  -- `stu_name` varchar(30) not null comment 'ѧ������',
  `stu_ID` varchar(20) not null comment 'ѧ��ID',
  -- `book_name` varchar(30) not null comment '����',
  `book_ISBN` varchar(30) not null comment '��ı��',
  `borrow_time` timestamp not null comment '����ʱ��',
  `return_time` timestamp not null default current_timestamp comment '����ʱ��',
  primary key(borrow_ID)
)ENGINE =InnoDB DEFAULT CHARSET=utf8 COMMENT ='�����б�';

-- ����ѧ���û���

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ѧ���б�';
SET FOREIGN_KEY_CHECKS=1;

-- �����û�����
INSERT INTO students(stu_ID, stu_name, school, phone, email)
   VALUES
     ('2015211383','wkw','�����ѧԺ','13051883232','97328398@163.com'),
     ('2015211333','wkw','�����ѧԺ','54554545455','54@163.com'),
     ('2015211353','haoren','�����ѧԺ','13051883232','97328398@163.com');


-- ����ԤԼ��
use lib;

create table order_books(
  -- `order_ID` int not null auto_increment comment 'ԤԼ��� Ψһ', ��Ҫ��
  `stu_ID` varchar(15) not null comment 'ѧ��ID',
  `book_ISBN` varchar(30) not null comment '���ISBN',
  `order_time` timestamp not null default current_timestamp comment 'ԤԼʱ��',
  -- primary key(order_ID),
  key order_time(order_time)
) ENGINE =InnoDB DEFAULT CHARSET=utf8 COMMENT ='ԤԼ�б�';


use lib;
alter table order_books drop column order_ID;
alter table order_books add primary key (stu_ID,book_ISBN);


use lib;
alter table students add column head_img varchar(120) default '/img/book/bookdefault.jpg';
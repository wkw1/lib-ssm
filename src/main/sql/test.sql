

-- 使用数据库
use  lib;

-- 初始化图书数据
INSERT INTO books(book_ISBN,book_name,book_introduction,book_author,book_press,total_number,
                  remaining_number,power_need,book_type)
    VALUES
      ('48395843','java开发','这是一本假书','wkw','bupt',10,10,1,'计算机'),
      ('42542642','spring开发2','这是一本真书','wkw','bupt',10,10,1,'计算机'),
      ('45254242','java web开发3','这是一本真书','wkw','bupt',10,10,1,'计算机'),
      ('54325462','框架入门','垃圾','好人','bupt',10,10,1,'计算机'),
      ('4265426542','学习','准垃圾','乔建永','hhhh',110,110,1,'计算机');



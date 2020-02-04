/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/2/14 23:10:29                           */
/*==============================================================*/
SET NAMES utf8;

DROP TABLE IF EXISTS tab_route;
DROP TABLE IF EXISTS tab_route_img;
DROP TABLE IF EXISTS tab_favorite;
DROP TABLE IF EXISTS tab_test_img;
DROP TABLE IF EXISTS tab_test_tol;
DROP TABLE IF EXISTS tab_category;
DROP TABLE IF EXISTS tab_user;
DROP TABLE IF EXISTS tab_comment;


/*==============================================================*/
/* 常用语句                                                      */
/*==============================================================*/

ALTER TABLE tab_test_tol  MODIFY COLUMN source VARCHAR(500);







/*==============================================================*/
/* Table: tab_category         测试工具分类                      */
/*==============================================================*/
CREATE TABLE tab_category
(
   cid                  INT NOT NULL AUTO_INCREMENT,
   cname                VARCHAR(100) NOT NULL,
   PRIMARY KEY (cid),
   UNIQUE KEY AK_nq_categoryname (cname)
);

/*==============================================================*/
/* Table: tab_favorite       收藏数                              */
/*==============================================================*/
CREATE TABLE tab_favorite
(
   tid                  INT NOT NULL,
   DATE                 DATE NOT NULL,
   uid                  INT NOT NULL,
   PRIMARY KEY (tid, uid)
);

/*==============================================================*/
/* Table: tab_test           测试工具                            */
/*==============================================================*/
CREATE TABLE tab_test_tol
(
   tid                  INT NOT NULL AUTO_INCREMENT,
   tname                VARCHAR(500) NOT NULL,
   price                DOUBLE NOT NULL,
   testIntroduce       VARCHAR(1000),
   tflag                CHAR(1) NOT NULL,
   tdate                VARCHAR(19),
   COUNT                INT NOT NULL,
   cid                  INT NOT NULL,
   timage               VARCHAR(200),
   source             VARCHAR(500),
   PRIMARY KEY (tid)
);

/*==============================================================*/
/* Table: tab_route_img                                         */
/*==============================================================*/
CREATE TABLE tab_test_img
(
   tgid                 INT NOT NULL AUTO_INCREMENT,
   tid                  INT NOT NULL,
   bigPic               VARCHAR(200) NOT NULL,
   smallPic             VARCHAR(200),
   PRIMARY KEY (tgid)
);


/*==============================================================*/
/* Table: tab_user                                              */
/*==============================================================*/
CREATE TABLE tab_user
(
   uid                  INT NOT NULL AUTO_INCREMENT,
   username             VARCHAR(100) NOT NULL,
   PASSWORD             VARCHAR(32) NOT NULL,
   NAME                 VARCHAR(100),
   birthday             DATE,
   sex                  CHAR(1),
   telephone            VARCHAR(11),
   email                VARCHAR(100),
   STATUS               CHAR(1) ,
   CODE					VARCHAR(50),

   PRIMARY KEY (uid),
   UNIQUE KEY AK_nq_username (username),
   UNIQUE KEY AK_nq_code (CODE)
);

/*==============================================================*/
/* Table: tab_user                                              */
/*==============================================================*/
CREATE TABLE tab_common
(
   cid                  INT NOT NULL AUTO_INCREMENT,
   cdescribe            VARCHAR(1000) NOT NULL,
   cdate             DATE,
   uid                INT NOT NULL,
   tid                INT NOT NULL,
   PRIMARY KEY (cid)
);

/*==============================================================*/
/* 外键                                                         */
/*==============================================================*/

ALTER TABLE tab_favorite ADD CONSTRAINT FK_testtol_favorite FOREIGN KEY (tid)
      REFERENCES tab_test_tol (tid) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE tab_favorite ADD CONSTRAINT FK_user_favorite FOREIGN KEY (uid)
      REFERENCES tab_user (uid) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE tab_test_tol ADD CONSTRAINT FK_category_testtol FOREIGN KEY (cid)
      REFERENCES tab_category (cid) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE tab_test_img ADD CONSTRAINT FK_test_testimg FOREIGN KEY (tid)
      REFERENCES tab_test_tol (tid) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE tab_common ADD CONSTRAINT FK_common_testtol FOREIGN KEY (tid)
      REFERENCES tab_test_tol (tid) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE tab_common ADD CONSTRAINT FK_common_user FOREIGN KEY (uid)
      REFERENCES tab_user (uid) ON DELETE RESTRICT ON UPDATE RESTRICT;













/*==============================================================*/
/* 数据                                                         */
/*==============================================================*/
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('LoadRunner', '0', 'LoadRunner，是一种预测系统行为和性能的负载测试工具。通过模拟上千万用户实施并发负载及实时性能监测的方式来确认和查找问题，LoadRunner能够对整个企业架构进行测试。企业使用LoadRunner能最大限度地缩短测试时间，优化性能和加速应用系统的发布周期。',
'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('QALoad', '0',
'(1).测试接口多；(2)可预测系统性能；(3)通过重复测试寻找瓶颈问题；(4)从控制中
心管理全局负载测试；(5)可验证应用的扩展性；(6)快速创建仿真的负载测试；(7)性能价格比较高。此外，QALoad不单单测试Web应用，还可以
测试一些后台的东西，比如SQL Server等。只要它支持的协议，都可以测试。'
,'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('JMeter', '0',
'(1).测试接口多；(2)可预测系统性能；(3)通过重复测试寻找瓶颈问题；(4)从控制中
心管理全局负载测试；(5)可验证应用的扩展性；(6)快速创建仿真的负载测试；(7)性能价格比较高。此外，QALoad不单单测试Web应用，还可以
测试一些后台的东西，比如SQL Server等。只要它支持的协议，都可以测试。'
,'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('Benchmark Factory', '0',
'JMeter是一个专门为运行和服务器负载测试而设计、
100%的纯Java桌面运行程序。原先它是为Web/HTTP测试而设计的，但是它已经扩展以支持各种各样的测试模块。它和HTTP和SQL(使用
JDBC)的模块一起运行。它可以用来测试静止或活动资料库中的服务器运行情况，可以用来模拟服务器或网络系统在重负载下的运行情况。它也提供了一个可替
换的界面用来定制数据显示，测试同步及测试的创建和执行。'
,'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('WAS', '0',
'WAS是Micro$oft提供的免费的Web负载压力测试工具，应用广泛。WAS可以通过一台或者多台客户机模拟大量用户的活动。WAS支持身份验证、加密和Cookies，也能够模拟各种浏览器和Modem速度，它的功能和性能可以与数万美元的产品媲美。'
,'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');

INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('LoadRunner', '0', 'LoadRunner，是一种预测系统行为和性能的负载测试工具。通过模拟上千万用户实施并发负载及实时性能监测的方式来确认和查找问题，LoadRunner能够对整个企业架构进行测试。企业使用LoadRunner能最大限度地缩短测试时间，优化性能和加速应用系统的发布周期。',
'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('QALoad', '0',
'(1).测试接口多；(2)可预测系统性能；(3)通过重复测试寻找瓶颈问题；(4)从控制中
心管理全局负载测试；(5)可验证应用的扩展性；(6)快速创建仿真的负载测试；(7)性能价格比较高。此外，QALoad不单单测试Web应用，还可以
测试一些后台的东西，比如SQL Server等。只要它支持的协议，都可以测试。'
,'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('JMeter', '0',
'(1).测试接口多；(2)可预测系统性能；(3)通过重复测试寻找瓶颈问题；(4)从控制中
心管理全局负载测试；(5)可验证应用的扩展性；(6)快速创建仿真的负载测试；(7)性能价格比较高。此外，QALoad不单单测试Web应用，还可以
测试一些后台的东西，比如SQL Server等。只要它支持的协议，都可以测试。'
,'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('Benchmark Factory', '0',
'JMeter是一个专门为运行和服务器负载测试而设计、
100%的纯Java桌面运行程序。原先它是为Web/HTTP测试而设计的，但是它已经扩展以支持各种各样的测试模块。它和HTTP和SQL(使用
JDBC)的模块一起运行。它可以用来测试静止或活动资料库中的服务器运行情况，可以用来模拟服务器或网络系统在重负载下的运行情况。它也提供了一个可替
换的界面用来定制数据显示，测试同步及测试的创建和执行。'
,'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('WAS', '0',
'WAS是Micro$oft提供的免费的Web负载压力测试工具，应用广泛。WAS可以通过一台或者多台客户机模拟大量用户的活动。WAS支持身份验证、加密和Cookies，也能够模拟各种浏览器和Modem速度，它的功能和性能可以与数万美元的产品媲美。'
,'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');

INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('LoadRunner', '0', 'LoadRunner，是一种预测系统行为和性能的负载测试工具。通过模拟上千万用户实施并发负载及实时性能监测的方式来确认和查找问题，LoadRunner能够对整个企业架构进行测试。企业使用LoadRunner能最大限度地缩短测试时间，优化性能和加速应用系统的发布周期。',
'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('QALoad', '0',
'(1).测试接口多；(2)可预测系统性能；(3)通过重复测试寻找瓶颈问题；(4)从控制中
心管理全局负载测试；(5)可验证应用的扩展性；(6)快速创建仿真的负载测试；(7)性能价格比较高。此外，QALoad不单单测试Web应用，还可以
测试一些后台的东西，比如SQL Server等。只要它支持的协议，都可以测试。'
,'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('JMeter', '0',
'(1).测试接口多；(2)可预测系统性能；(3)通过重复测试寻找瓶颈问题；(4)从控制中
心管理全局负载测试；(5)可验证应用的扩展性；(6)快速创建仿真的负载测试；(7)性能价格比较高。此外，QALoad不单单测试Web应用，还可以
测试一些后台的东西，比如SQL Server等。只要它支持的协议，都可以测试。'
,'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('Benchmark Factory', '0',
'JMeter是一个专门为运行和服务器负载测试而设计、
100%的纯Java桌面运行程序。原先它是为Web/HTTP测试而设计的，但是它已经扩展以支持各种各样的测试模块。它和HTTP和SQL(使用
JDBC)的模块一起运行。它可以用来测试静止或活动资料库中的服务器运行情况，可以用来模拟服务器或网络系统在重负载下的运行情况。它也提供了一个可替
换的界面用来定制数据显示，测试同步及测试的创建和执行。'
,'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('WAS', '0',
'WAS是Micro$oft提供的免费的Web负载压力测试工具，应用广泛。WAS可以通过一台或者多台客户机模拟大量用户的活动。WAS支持身份验证、加密和Cookies，也能够模拟各种浏览器和Modem速度，它的功能和性能可以与数万美元的产品媲美。'
,'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');


INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('LoadRunner', '0', 'LoadRunner，是一种预测系统行为和性能的负载测试工具。通过模拟上千万用户实施并发负载及实时性能监测的方式来确认和查找问题，LoadRunner能够对整个企业架构进行测试。企业使用LoadRunner能最大限度地缩短测试时间，优化性能和加速应用系统的发布周期。',
'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('QALoad', '0',
'(1).测试接口多；(2)可预测系统性能；(3)通过重复测试寻找瓶颈问题；(4)从控制中
心管理全局负载测试；(5)可验证应用的扩展性；(6)快速创建仿真的负载测试；(7)性能价格比较高。此外，QALoad不单单测试Web应用，还可以
测试一些后台的东西，比如SQL Server等。只要它支持的协议，都可以测试。'
,'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('JMeter', '0',
'(1).测试接口多；(2)可预测系统性能；(3)通过重复测试寻找瓶颈问题；(4)从控制中
心管理全局负载测试；(5)可验证应用的扩展性；(6)快速创建仿真的负载测试；(7)性能价格比较高。此外，QALoad不单单测试Web应用，还可以
测试一些后台的东西，比如SQL Server等。只要它支持的协议，都可以测试。'
,'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('Benchmark Factory', '0',
'JMeter是一个专门为运行和服务器负载测试而设计、
100%的纯Java桌面运行程序。原先它是为Web/HTTP测试而设计的，但是它已经扩展以支持各种各样的测试模块。它和HTTP和SQL(使用
JDBC)的模块一起运行。它可以用来测试静止或活动资料库中的服务器运行情况，可以用来模拟服务器或网络系统在重负载下的运行情况。它也提供了一个可替
换的界面用来定制数据显示，测试同步及测试的创建和执行。'
,'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('WAS', '0',
'WAS是Micro$oft提供的免费的Web负载压力测试工具，应用广泛。WAS可以通过一台或者多台客户机模拟大量用户的活动。WAS支持身份验证、加密和Cookies，也能够模拟各种浏览器和Modem速度，它的功能和性能可以与数万美元的产品媲美。'
,'1', '2020-01-22', '0', '1', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');



INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('LoadRunner', '0', 'LoadRunner，是一种预测系统行为和性能的负载测试工具。通过模拟上千万用户实施并发负载及实时性能监测的方式来确认和查找问题，LoadRunner能够对整个企业架构进行测试。企业使用LoadRunner能最大限度地缩短测试时间，优化性能和加速应用系统的发布周期。',
'1', '2020-01-22', '0', '2', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('QALoad', '0',
'(1).测试接口多；(2)可预测系统性能；(3)通过重复测试寻找瓶颈问题；(4)从控制中
心管理全局负载测试；(5)可验证应用的扩展性；(6)快速创建仿真的负载测试；(7)性能价格比较高。此外，QALoad不单单测试Web应用，还可以
测试一些后台的东西，比如SQL Server等。只要它支持的协议，都可以测试。'
,'1', '2020-01-22', '0', '2', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('JMeter', '0',
'(1).测试接口多；(2)可预测系统性能；(3)通过重复测试寻找瓶颈问题；(4)从控制中
心管理全局负载测试；(5)可验证应用的扩展性；(6)快速创建仿真的负载测试；(7)性能价格比较高。此外，QALoad不单单测试Web应用，还可以
测试一些后台的东西，比如SQL Server等。只要它支持的协议，都可以测试。'
,'1', '2020-01-22', '0', '2', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('Benchmark Factory', '0',
'JMeter是一个专门为运行和服务器负载测试而设计、
100%的纯Java桌面运行程序。原先它是为Web/HTTP测试而设计的，但是它已经扩展以支持各种各样的测试模块。它和HTTP和SQL(使用
JDBC)的模块一起运行。它可以用来测试静止或活动资料库中的服务器运行情况，可以用来模拟服务器或网络系统在重负载下的运行情况。它也提供了一个可替
换的界面用来定制数据显示，测试同步及测试的创建和执行。'
,'1', '2020-01-22', '0', '2', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('WAS', '0',
'WAS是Micro$oft提供的免费的Web负载压力测试工具，应用广泛。WAS可以通过一台或者多台客户机模拟大量用户的活动。WAS支持身份验证、加密和Cookies，也能够模拟各种浏览器和Modem速度，它的功能和性能可以与数万美元的产品媲美。'
,'1', '2020-01-22', '0', '3', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');

INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('LoadRunner', '0', 'LoadRunner，是一种预测系统行为和性能的负载测试工具。通过模拟上千万用户实施并发负载及实时性能监测的方式来确认和查找问题，LoadRunner能够对整个企业架构进行测试。企业使用LoadRunner能最大限度地缩短测试时间，优化性能和加速应用系统的发布周期。',
'1', '2020-01-22', '0', '3', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('QALoad', '0',
'(1).测试接口多；(2)可预测系统性能；(3)通过重复测试寻找瓶颈问题；(4)从控制中
心管理全局负载测试；(5)可验证应用的扩展性；(6)快速创建仿真的负载测试；(7)性能价格比较高。此外，QALoad不单单测试Web应用，还可以
测试一些后台的东西，比如SQL Server等。只要它支持的协议，都可以测试。'
,'1', '2020-01-22', '0', '3', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('JMeter', '0',
'(1).测试接口多；(2)可预测系统性能；(3)通过重复测试寻找瓶颈问题；(4)从控制中
心管理全局负载测试；(5)可验证应用的扩展性；(6)快速创建仿真的负载测试；(7)性能价格比较高。此外，QALoad不单单测试Web应用，还可以
测试一些后台的东西，比如SQL Server等。只要它支持的协议，都可以测试。'
,'1', '2020-01-22', '0', '3', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('Benchmark Factory', '0',
'JMeter是一个专门为运行和服务器负载测试而设计、
100%的纯Java桌面运行程序。原先它是为Web/HTTP测试而设计的，但是它已经扩展以支持各种各样的测试模块。它和HTTP和SQL(使用
JDBC)的模块一起运行。它可以用来测试静止或活动资料库中的服务器运行情况，可以用来模拟服务器或网络系统在重负载下的运行情况。它也提供了一个可替
换的界面用来定制数据显示，测试同步及测试的创建和执行。'
,'1', '2020-01-22', '0', '4', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('WAS', '0',
'WAS是Micro$oft提供的免费的Web负载压力测试工具，应用广泛。WAS可以通过一台或者多台客户机模拟大量用户的活动。WAS支持身份验证、加密和Cookies，也能够模拟各种浏览器和Modem速度，它的功能和性能可以与数万美元的产品媲美。'
,'1', '2020-01-22', '0', '4', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');





INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('LoadRunner', '0', 'LoadRunner，是一种预测系统行为和性能的负载测试工具。通过模拟上千万用户实施并发负载及实时性能监测的方式来确认和查找问题，LoadRunner能够对整个企业架构进行测试。企业使用LoadRunner能最大限度地缩短测试时间，优化性能和加速应用系统的发布周期。',
'1', '2020-01-22', '0', '5', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('QALoad', '0',
'(1).测试接口多；(2)可预测系统性能；(3)通过重复测试寻找瓶颈问题；(4)从控制中
心管理全局负载测试；(5)可验证应用的扩展性；(6)快速创建仿真的负载测试；(7)性能价格比较高。此外，QALoad不单单测试Web应用，还可以
测试一些后台的东西，比如SQL Server等。只要它支持的协议，都可以测试。'
,'1', '2020-01-22', '0', '5', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('JMeter', '0',
'(1).测试接口多；(2)可预测系统性能；(3)通过重复测试寻找瓶颈问题；(4)从控制中
心管理全局负载测试；(5)可验证应用的扩展性；(6)快速创建仿真的负载测试；(7)性能价格比较高。此外，QALoad不单单测试Web应用，还可以
测试一些后台的东西，比如SQL Server等。只要它支持的协议，都可以测试。'
,'1', '2020-01-22', '0', '5', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('Benchmark Factory', '0',
'JMeter是一个专门为运行和服务器负载测试而设计、
100%的纯Java桌面运行程序。原先它是为Web/HTTP测试而设计的，但是它已经扩展以支持各种各样的测试模块。它和HTTP和SQL(使用
JDBC)的模块一起运行。它可以用来测试静止或活动资料库中的服务器运行情况，可以用来模拟服务器或网络系统在重负载下的运行情况。它也提供了一个可替
换的界面用来定制数据显示，测试同步及测试的创建和执行。'
,'1', '2020-01-22', '0', '5', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
INSERT INTO `ones`.`tab_test_tol` (`tname`, `price`, `testIntroduce`, `tflag`, `tdate`, `count`, `cid`, `timage`, `source`) VALUES
('WAS', '0',
'WAS是Micro$oft提供的免费的Web负载压力测试工具，应用广泛。WAS可以通过一台或者多台客户机模拟大量用户的活动。WAS支持身份验证、加密和Cookies，也能够模拟各种浏览器和Modem速度，它的功能和性能可以与数万美元的产品媲美。'
,'1', '2020-01-22', '0', '5', 'images/jiangxuan_4.jpg', 'https://zhidao.baidu.com/question/526817422.html?qbl=relate_question_0&word=%C8%ED%BC%FE%B2%E2%CA%D4%B9%A4%BE%DF%B3%A3%D3%C3%B5%C4%B6%BC%D3%D0%C4%C4%D0%A9');
















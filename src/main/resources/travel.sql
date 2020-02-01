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
   source             VARCHAR(50),
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

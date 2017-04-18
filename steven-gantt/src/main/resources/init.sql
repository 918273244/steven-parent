--设置自动增长从1000开始
alter table roadmap AUTO_INCREMENT=100000;

/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/4/18 14:11:19                           */
/*==============================================================*/


drop table if exists ROADMAP;
CREATE TABLE
    roadmap
    (
        ID bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
        ROADNO VARCHAR(50),
        CREATEDBY VARCHAR(50),
        CREATEDUSERID bigint,
        CREATEDDATE DATETIME,
        DEPARTMENTNAME VARCHAR(50),
        MOBILE VARCHAR(20),
        EMAIL VARCHAR(50),
        ROADNAME VARCHAR(50),
        ROADTYPE bigint,
        ROADLEVEL bigint,
        NEWLOOKFLAG bigint,
        ROADPRIORITY bigint,
        APPEARANCEFORM VARCHAR(100),
        HARDWAREPLATFORM VARCHAR(100),
        PLANSTARTTIME DATETIME,
        PLANPUBLISHTIME DATETIME,
        MARKETPOSITION bigint,
        TARGETEDMARKET bigint,
        TYPICALCUSTOMERS VARCHAR(100),
        EXPECTEDLIFECYCLE VARCHAR(20),
        ESTIMATEDSALESVOLUME VARCHAR(20),
        ESTIMATEDSALESPRICE VARCHAR(20),
        ESTIMATEDGROSSMARGIN VARCHAR(20),
        ESTIMATEDRDEXPENSES VARCHAR(20),
        ESTIMATEDSALESAMOUNT VARCHAR(20),
        ESTIMATEDGROSSAMOUNT VARCHAR(20),
        ESTIMATEDINOUT VARCHAR(20),
        CORECONTENT text,
        PERFORMANCE VARCHAR(100),
        COMPETITIONCONTENT text,
        CUSTOMERCONTENT text,
        ROADINHERITID bigint,
        ROADINHERITNAME VARCHAR(200),
        ROADQUOTESID bigint,
        ROADQUOTESNAME VARCHAR(200),
        ROADSUPPORTID bigint,
        ROADSUPPORTNAME VARCHAR(200),
        ROADPLATFORMID bigint,
        ROADPLATFORMNAME VARCHAR(200),
        ROADIMAGE VARCHAR(125),
        FIELD1 VARCHAR(125),
        FIELD2 VARCHAR(125),
        FIELD3 VARCHAR(125),
        FIELD4 VARCHAR(125),
        FIELD5 VARCHAR(125),
        FIELD6 VARCHAR(125),
        FIELD7 VARCHAR(125),
        FIELD8 VARCHAR(125),
        UPLOADFILE VARCHAR(100),
        ROADMAPTYPE bigint,
        PARENTID bigint,
        RMTID bigint,
        CREATEUSERNO VARCHAR(60),
        UPDATETIME DATETIME,
        STATUS CHAR(1),
        TYPEFLAG CHAR(1) DEFAULT '1',
        PRIMARY KEY (ID)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='路标';



drop table if exists rmtsys;
CREATE TABLE
    rmtsys
    (
        ID bigint NOT NULL AUTO_INCREMENT,
        RMTNAME VARCHAR(100),
        CREATETIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON
    UPDATE
        CURRENT_TIMESTAMP,
        DELETESTATUS CHAR(1) DEFAULT '0',
        FIELD VARCHAR(100),
        UPDATETIME TIMESTAMP DEFAULT '0000-00-00 00:00:00',
        TYPEFLAG CHAR(1) DEFAULT '1',
        PRIMARY KEY (ID)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists users;
    CREATE TABLE
    users
    (
        id bigint NOT NULL AUTO_INCREMENT,
        username VARCHAR(100),
        userpassword VARCHAR(100),
        role VARCHAR(100),
        PRIMARY KEY (id),
        INDEX users_id_name (id, username)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;


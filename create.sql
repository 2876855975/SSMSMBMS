

DROP DATABASE IF EXISTS smbms;
CREATE DATABASE smbms;


USE smbms;


/*用户信息表*/
CREATE TABLE user_info(
sid   INT PRIMARY KEY AUTO_INCREMENT,
username   VARCHAR(10) UNIQUE NOT NULL,
userpassword VARCHAR(50) NOT NULL,
userType  INT
)CHARSET =utf8;

/*商品信息表*/
CREATE TABLE goods_info(
	Gid	INT PRIMARY KEY AUTO_INCREMENT,
	Gname	VARCHAR(50) NOT NULL,
	gCost_price DECIMAL(18,2) NOT NULL,
	gStock	INT NOT NULL,
	gPrice	DECIMAL(18,2) NOT NULL,
	gDiscount DECIMAL(5,2) NOT NULL,
	gCategory INT,
	gPoints	INT NOT NULL,
	gunit	VARCHAR(20),
	gRemark	VARCHAR(100)
)CHARSET =utf8;

CREATE TABLE user_type(
    tid INT PRIMARY KEY AUTO_INCREMENT,
    tname VARCHAR(20)
)CHARSET =utf8;






/*商品类型表*/
CREATE TABLE goods_Category(
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL
)CHARSET =utf8;




/*会员等级表*/
CREATE TABLE member_grade(
gid INT PRIMARY KEY AUTO_INCREMENT,
Mgrade 	VARCHAR(10) UNIQUE NOT NULL,
mdiscount  DECIMAL(3,2) NOT NULL
)CHARSET =utf8;


/*会员管理表*/
CREATE TABLE member_manage(
	`mid`	INT PRIMARY KEY AUTO_INCREMENT,	/*会员id 主键*/
	mname	VARCHAR(50) NOT NULL,   /*会员姓名*/
	msex	CHAR(2) NOT NULL, /*会员性别*/
	grade	INT REFERENCES member_grade(gid),
	mmonetary DECIMAL(10,2) NOT NULL,
	Mtel  VARCHAR(20),
	mAccount DECIMAL(10,2)
)CHARSET =utf8;





/*超市销售信息表*/
CREATE TABLE super_sale_info(
Saleid	INT PRIMARY KEY AUTO_INCREMENT,
SDate	TIMESTAMP NOT NULL,
sid  INT REFERENCES user_info(sid),
`Mid`   INT REFERENCES member_manage(`mid`),
mgathering DECIMAL(10,2) NOT NULL,
`change` DECIMAL(10,2) NOT NULL,
Remark	VARCHAR(50)

)CHARSET =utf8;





/*销售项目表*/
CREATE TABLE sales_project(
sales_Saleid	INT REFERENCES super_sale_info(Saleid),
sales_gid	INT REFERENCES goods_info(Gid),
Snum	INT NOT NULL

)CHARSET =utf8;



/*.供应商表*/
CREATE TABLE supplier(
Did  INT PRIMARY KEY AUTO_INCREMENT,
Dname	VARCHAR(20) UNIQUE NOT NULL,
Dtel	VARCHAR(20) UNIQUE NOT NULL,
Daddress VARCHAR(50) NOT NULL,
Demail	VARCHAR(30) UNIQUE NOT NULL
)CHARSET =utf8;


/*采购信息表*/
CREATE TABLE purchase_info(
Pid	INT PRIMARY KEY AUTO_INCREMENT,
pdate	TIMESTAMP NOT NULL,
Did	INT REFERENCES supplier(did),
sid	INT REFERENCES user_info(sid),
Remark	VARCHAR(50)

)CHARSET =utf8;

/*采购项目表*/
CREATE TABLE purchase_project(
Pid	INT REFERENCES purchase_info(pid),
Gid	INT REFERENCES goods_info(Gid),
Pnum	INT NOT NULL

)CHARSET =utf8;

ALTER TABLE `user_info` ADD CONSTRAINT `fk_1` FOREIGN KEY ( `userType` )
REFERENCES `user_type`(tid);

ALTER TABLE `goods_info` ADD CONSTRAINT `fgk_1` FOREIGN KEY (gCategory)
REFERENCES `goods_Category`(id);






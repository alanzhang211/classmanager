/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : classmanager

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2014-12-21 23:20:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `Name` varchar(45) NOT NULL,
  `Passworld` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '张汉卿', '806a');

-- ----------------------------
-- Table structure for `ccostinfo`
-- ----------------------------
DROP TABLE IF EXISTS `ccostinfo`;
CREATE TABLE `ccostinfo` (
  `cNum` int(10) unsigned NOT NULL auto_increment,
  `cDate` varchar(45) NOT NULL,
  `cName` varchar(45) default NULL,
  `cIn` varchar(45) default NULL,
  `cOut` varchar(45) default NULL,
  `cTotal` varchar(45) default NULL,
  PRIMARY KEY  (`cNum`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of ccostinfo
-- ----------------------------
INSERT INTO `ccostinfo` VALUES ('1', '2011-3-8', '收取班费', '2050', '0', '2050');
INSERT INTO `ccostinfo` VALUES ('2', '2011-3-14', '春游', '0', '518', '-518');
INSERT INTO `ccostinfo` VALUES ('3', '2011-3-5', '复印通讯录', '0', '4.5', '-4.5');
INSERT INTO `ccostinfo` VALUES ('4', '2011-3-13', '交团费', '0', '24', '-24.0');
INSERT INTO `ccostinfo` VALUES ('5', '2011-3-28', '复印数字电路实验资料', '0', '109', '-109.0');
INSERT INTO `ccostinfo` VALUES ('6', '2011-3-17', '春游踩点', '0', '20', '-20.0');
INSERT INTO `ccostinfo` VALUES ('7', '2011-4-1', '复印红旗团支部资料', '0', '8.4', '-8.4');
INSERT INTO `ccostinfo` VALUES ('8', '2011-4-2', '红旗团支部题库资料', '0', '25', '-25.0');
INSERT INTO `ccostinfo` VALUES ('9', '2011-4-5', '班旗费用', '0', '70', '-70.0');
INSERT INTO `ccostinfo` VALUES ('10', '2011-4-7', '歌词复印费', '0', '9', '-9.0');
INSERT INTO `ccostinfo` VALUES ('11', '2011-4-13', '概率与统计练习册40x9', '0', '360', '-360.0');
INSERT INTO `ccostinfo` VALUES ('12', '2011-4-13', '红旗团支部三面旗90+资料10', '0', '100', '-100.0');
INSERT INTO `ccostinfo` VALUES ('13', '2011-4-17', '体育文化节买水', '0', '24', '-24.0');
INSERT INTO `ccostinfo` VALUES ('14', '2011-5-29', '复印知识产权资料', '0', '56', '-56.0');
INSERT INTO `ccostinfo` VALUES ('15', '2011-6-6', '班级买粽子', '0', '60', '-60.0');
INSERT INTO `ccostinfo` VALUES ('16', '2011-6-12', '近代史、数电复习试卷', '0', '213', '-213.0');
INSERT INTO `ccostinfo` VALUES ('17', '2011-6-24', '为高飞主任买花', '0', '100', '-100.0');
INSERT INTO `ccostinfo` VALUES ('18', '2011-9-6', '班级交取团费', '0', '23.4', '-23.4');
INSERT INTO `ccostinfo` VALUES ('19', '2011-9-10', '班级中秋买月饼', '0', '64', '-64.0');
INSERT INTO `ccostinfo` VALUES ('20', '2011-9-10', '教师节为老师买贺卡', '0', '6', '-6.0');
INSERT INTO `ccostinfo` VALUES ('21', '2011-9-18', '申请先进班集体标兵材料复印', '0', '42', '-42.0');
INSERT INTO `ccostinfo` VALUES ('22', '2011-9-20', '收取班费', '2050', '0', '2050.0');
INSERT INTO `ccostinfo` VALUES ('23', '2011-9-22', '复印红歌歌词', '0', '4.1', '-4.1');
INSERT INTO `ccostinfo` VALUES ('24', '2011-9-26', '年级为老师买礼物，每班出50元', '0', '50', '-50.0');
INSERT INTO `ccostinfo` VALUES ('25', '2011-10-22', '班级秋游费用', '0', '560', '-560.0');
INSERT INTO `ccostinfo` VALUES ('26', '2011-10-23', '计算机组原实验报告册6x39', '0', '234', '-234.0');
INSERT INTO `ccostinfo` VALUES ('27', '2011-11-18', '班级复印试卷', '0', '145', '-145.0');
INSERT INTO `ccostinfo` VALUES ('28', '2011-11-21', '复印晚会剧本', '0', '5.5', '-5.5');
INSERT INTO `ccostinfo` VALUES ('29', '2011-12-4', '班级复印项目管理与软测试卷', '0', '34', '-34.0');
INSERT INTO `ccostinfo` VALUES ('30', '2011-11-28', '班级晚会排练道具费用16', '0', '16', '-16.0');
INSERT INTO `ccostinfo` VALUES ('31', '2011-12-5', '班级晚会排练道具费用18.3', '0', '18.3', '-18.3');
INSERT INTO `ccostinfo` VALUES ('32', '2011-11-21', '人机交互课本退还10元', '10', '0', '10.0');
INSERT INTO `ccostinfo` VALUES ('33', '2011-12-3', '复习试卷 ', '0', '34', '-34.0');
INSERT INTO `ccostinfo` VALUES ('34', '2011-12-18', '复习资料', '0', '130', '-130.0');
INSERT INTO `ccostinfo` VALUES ('35', '2011-12-19', '复习试卷资料', '0', '17.2', '-17.2');
INSERT INTO `ccostinfo` VALUES ('36', '2011-12-28', '项目管理复习资料', '0', '11.4', '-11.4');
INSERT INTO `ccostinfo` VALUES ('37', '2011-11-18', '复印试卷', '0', '145', '-145.0');
INSERT INTO `ccostinfo` VALUES ('38', '2012-1-11', '班级年终聚餐200', '0', '200', '-220.0');
INSERT INTO `ccostinfo` VALUES ('39', '2012-1-12', '复印毛概资料', '0', '34', '-34.0');
INSERT INTO `ccostinfo` VALUES ('40', '2012-3-11', '收取班费', '1920', '0', '1920.0');
INSERT INTO `ccostinfo` VALUES ('41', '2012-3-15', '交班级团费', '0', '24', '-24.0');
INSERT INTO `ccostinfo` VALUES ('42', '2012-4-17', '复印试卷', '0', '125', '-125.0');
INSERT INTO `ccostinfo` VALUES ('43', '2012-4-22', '复印考试复习资料', '0', '25', '-25.0');
INSERT INTO `ccostinfo` VALUES ('44', '2012-5-13', '毕业照相', '0', '480', '-480.0');
INSERT INTO `ccostinfo` VALUES ('45', '2012-5-31', '王凡、蒋建飞踩点', '0', '20', '-20.0');
INSERT INTO `ccostinfo` VALUES ('46', '2012-6-1', '袁志伟薰衣草园踩点', '0', '21', '-21.0');
INSERT INTO `ccostinfo` VALUES ('47', '2012-6-11', '网络安全复习资料', '0', '52', '-52.0');
INSERT INTO `ccostinfo` VALUES ('48', '2012-6-14', '网络安全复习试卷', '0', '9', '-9.0');
INSERT INTO `ccostinfo` VALUES ('49', '2012-6-8', '薰衣草庄园出游340+87+266', '0', '693', '-693.0');
INSERT INTO `ccostinfo` VALUES ('50', '2012-6-23', '端午节购买粽子', '0', '50', '-50.0');
INSERT INTO `ccostinfo` VALUES ('51', '2012-9-10', '教师节购买礼物', '0', '80', '-80.0');
INSERT INTO `ccostinfo` VALUES ('52', '2012-9-21', '网络实验指导书', '0', '117', '-117.0');
INSERT INTO `ccostinfo` VALUES ('53', '2012-9-29', '中秋节月饼', '0', '162', '-162.0');
INSERT INTO `ccostinfo` VALUES ('54', '2012-10', '班级慰问考研同胞', '0', '100', '-100.0');
INSERT INTO `ccostinfo` VALUES ('55', '2012-11-11', '光棍节礼物100', '0', '100', '-100.0');
INSERT INTO `ccostinfo` VALUES ('56', '2012-12-25', '平安夜班级买苹果', '0', '80', '-80.0');
INSERT INTO `ccostinfo` VALUES ('57', '2013-3-26', '班级复印资料', '0', '9.8', '-9.8');
INSERT INTO `ccostinfo` VALUES ('58', '2013-4-13', '班级棋牌活动', '0', '125', '-125');
INSERT INTO `ccostinfo` VALUES ('59', '2013-4-20', '班级羽毛球比赛', '0', '125', '-125');
INSERT INTO `ccostinfo` VALUES ('60', '2013-4-20', '班级羽毛球买水', '0', '24', '-24');
INSERT INTO `ccostinfo` VALUES ('61', '2013-5-8', '班级团费', '0', '44.6', '-44.6');
INSERT INTO `ccostinfo` VALUES ('62', '2013-5-15', '租借学士服', '0', '195', '-195');
INSERT INTO `ccostinfo` VALUES ('63', '2013-5-16', '班服费用', '0', '1260', '-1260');
INSERT INTO `ccostinfo` VALUES ('64', '2013-4-7', '收取班费', '1950', '0', '1950');
INSERT INTO `ccostinfo` VALUES ('65', '2013-5-28', '班级喊楼', '0', '68', '-68');
INSERT INTO `ccostinfo` VALUES ('66', '2013-6-3', '班级统计就业统计打印', '0', '7.8', '-7.8');
INSERT INTO `ccostinfo` VALUES ('67', '2013-6-9', '班级租借衣服', '0', '760', '-760');
INSERT INTO `ccostinfo` VALUES ('68', '2013-6-10', '收取班费（吃饭）', '2340', '0', '2340');
INSERT INTO `ccostinfo` VALUES ('69', '2013-6-11', '端午节粽子', '0', '53', '-53');
INSERT INTO `ccostinfo` VALUES ('70', '2013-6-19', '班级毕业聚餐', '0', '1950', '-1950');
INSERT INTO `ccostinfo` VALUES ('71', '2013-6-19', '资助班级KTV', '0', '65', '-65');

-- ----------------------------
-- Table structure for `sactive`
-- ----------------------------
DROP TABLE IF EXISTS `sactive`;
CREATE TABLE `sactive` (
  `sNum` varchar(45) NOT NULL,
  `sName` varchar(45) default NULL,
  `sSex` varchar(45) default NULL,
  `date` varchar(45) default NULL,
  `activity` varchar(45) default NULL,
  `meeting` varchar(45) default NULL,
  `sport` varchar(45) default NULL,
  `details` varchar(45) default NULL,
  `id` int(10) unsigned NOT NULL auto_increment,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of sactive
-- ----------------------------

-- ----------------------------
-- Table structure for `scheckinfo`
-- ----------------------------
DROP TABLE IF EXISTS `scheckinfo`;
CREATE TABLE `scheckinfo` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `sNum` varchar(45) NOT NULL,
  `sName` varchar(45) default NULL,
  `sSex` varchar(45) default NULL,
  `sUsualScore` varchar(45) default NULL,
  `sAwardName` varchar(45) default NULL,
  `sAwardScore` varchar(45) default NULL,
  `sRank` varchar(45) default NULL,
  `sTotal` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of scheckinfo
-- ----------------------------
INSERT INTO `scheckinfo` VALUES ('1', '0906840201', '张汉卿', '男', '20', '无', '0', '40', '20');

-- ----------------------------
-- Table structure for `stuinfo`
-- ----------------------------
DROP TABLE IF EXISTS `stuinfo`;
CREATE TABLE `stuinfo` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `sNum` varchar(45) NOT NULL,
  `sName` varchar(45) default NULL,
  `sSex` varchar(45) default NULL,
  `sNation` varchar(45) default NULL,
  `sDormId` varchar(45) default NULL,
  `sBirth` varchar(45) default NULL,
  `sDuty` varchar(45) default NULL,
  `sCardId` varchar(45) default NULL,
  `sPhone` varchar(45) default NULL,
  `sHome` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stuinfo
-- ----------------------------
INSERT INTO `stuinfo` VALUES ('1', '0906840201', '张汉卿', '男', '汉', '805B', '1990-3-23', '生活委员', '65270119981222371*', '15850796182', '新疆省');

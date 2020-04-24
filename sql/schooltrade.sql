-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.21 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 schooltrade.category 结构
CREATE TABLE IF NOT EXISTS `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '分类名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- 正在导出表  schooltrade.category 的数据：6 rows
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`, `name`) VALUES
	(1, '图书'),
	(2, '电脑'),
	(3, '手机'),
	(4, '电器'),
	(5, '衣服'),
	(0, '其他');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- 导出  表 schooltrade.conditions 结构
CREATE TABLE IF NOT EXISTS `conditions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '新旧程度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- 正在导出表  schooltrade.conditions 的数据：3 rows
/*!40000 ALTER TABLE `conditions` DISABLE KEYS */;
INSERT INTO `conditions` (`id`, `name`) VALUES
	(0, '全新'),
	(1, '二手'),
	(2, '可借');
/*!40000 ALTER TABLE `conditions` ENABLE KEYS */;

-- 导出  表 schooltrade.item 结构
CREATE TABLE IF NOT EXISTS `item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '名称',
  `price` decimal(11,0) NOT NULL COMMENT '价格',
  `info` varchar(300) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '商品描述',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `state_id` int NOT NULL DEFAULT '0' COMMENT '是否上架',
  `category_id` int NOT NULL DEFAULT '0' COMMENT '商品分类',
  `conditions_id` int NOT NULL DEFAULT '0' COMMENT '新旧程度',
  `user_id` int NOT NULL DEFAULT '0' COMMENT '所属用户',
  `pic1` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pic2` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pic3` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=155 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- 正在导出表  schooltrade.item 的数据：3 rows
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`id`, `name`, `price`, `info`, `createTime`, `state_id`, `category_id`, `conditions_id`, `user_id`, `pic1`, `pic2`, `pic3`) VALUES
	(154, '二手手机', 50, '<p><span>出二手手机，有点老，但是又不是不能打电话，50面交啦</span></p>', '2020-12-11 16:09:31', 1, 3, 1, 0, '20201211\\22e0d7c71993a2cfc73704e12740a679.jpg', NULL, NULL),
	(152, '联想小新air 15寸笔记本 2018款', 2000, '<p>联想小新air&nbsp;15寸笔记本&nbsp;2018款<br>&nbsp;酷睿i5&nbsp;8250八代i5处理器，<br>独显mx150，8g内存，512g固体硬盘，<br>自用，无拆修，功能全好<br>屠龙刀不要来，直接拉黑<br></p>', '2020-12-11 12:53:20', 0, 2, 1, 2, '20201211\\d33a3ed0ac6cce6a0b22765fdd371222.jpg', '20201211\\6944c29b58a8ff92deb86648fe7303f2.jpg', NULL),
	(150, 'IKEA诺德马克无线充电板', 30, '<p>IKEA诺德马克无线充电板&nbsp;品牌：IKEA/宜家<br>功能完好，只用过一两次</p>', '2020-12-11 11:16:31', 0, 4, 0, 2, '20201211\\a491ae9d0565dd2b013da372feeb2613.jpg', '20201211\\4e517dad9f82619d71060ebf9e8074f3.jpg', NULL);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;

-- 导出  表 schooltrade.state 结构
CREATE TABLE IF NOT EXISTS `state` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '是否上架',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- 正在导出表  schooltrade.state 的数据：2 rows
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` (`id`, `name`) VALUES
	(0, '已上架'),
	(1, '未上架');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;

-- 导出  表 schooltrade.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `flag` int unsigned NOT NULL DEFAULT '0' COMMENT '是否管理员',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `regtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `avatar` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'up/touxiang_default.jpg' COMMENT '头像',
  `sex` int NOT NULL COMMENT '性别',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 正在导出表  schooltrade.user 的数据：3 rows
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `flag`, `phone`, `regtime`, `avatar`, `sex`) VALUES
	(0, 'admin', 'admin', 1, '18922222222', '2020-12-11 10:57:26', 'up/head.jpg', 0),
	(1, 'qq', '123456', 0, '15119838305', '2020-12-11 11:48:05', 'up/touxiang_default.jpg', 0),
	(2, 'hhyygg', '123', 0, '18988888888', '2020-12-11 13:17:47', 'up/touxiang_default.png', 0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

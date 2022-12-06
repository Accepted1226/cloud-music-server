/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : tp_music

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 03/12/2022 14:49:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES (1, 'admin', 'admin');
INSERT INTO `admin` VALUES (2, 'admin1', '123456');
COMMIT;

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL,
  `type` tinyint NOT NULL,
  `song_id` int unsigned DEFAULT NULL,
  `song_list_id` int unsigned DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of collect
-- ----------------------------
BEGIN;
INSERT INTO `collect` VALUES (54, 1, 0, 1, NULL, '2022-10-08 14:59:59');
INSERT INTO `collect` VALUES (55, 1, 0, 17, NULL, '2022-10-08 15:00:07');
INSERT INTO `collect` VALUES (57, 1, 0, 16, NULL, '2022-10-08 15:00:29');
INSERT INTO `collect` VALUES (58, 30, 0, 3, NULL, '2022-10-10 01:30:30');
COMMIT;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL,
  `song_id` int unsigned DEFAULT NULL,
  `song_list_id` int unsigned DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `type` tinyint NOT NULL,
  `up` int unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of comment
-- ----------------------------
BEGIN;
INSERT INTO `comment` VALUES (41, 1, NULL, 80, 'nice', '2019-03-24 01:55:04', 1, 0);
INSERT INTO `comment` VALUES (42, 1, NULL, 80, 'nice', '2019-03-24 01:57:02', 1, 0);
INSERT INTO `comment` VALUES (43, 1, NULL, 82, 'success', '2019-03-24 01:57:40', 1, 0);
INSERT INTO `comment` VALUES (45, 1, NULL, 1, '啦啦啦(*≧∀≦)ﾉ', '2019-04-25 21:24:43', 1, 0);
INSERT INTO `comment` VALUES (46, 1, 21, NULL, '111', '2019-04-26 00:51:18', 0, 0);
INSERT INTO `comment` VALUES (47, 1, NULL, 1, '222', '2019-04-26 01:01:27', 1, 0);
INSERT INTO `comment` VALUES (48, 5, NULL, 10, '我喜欢你', '2019-04-26 01:03:12', 1, 0);
INSERT INTO `comment` VALUES (49, 1, NULL, 0, '', '2019-05-23 21:35:47', 1, 0);
INSERT INTO `comment` VALUES (50, 1, NULL, 51, '好听', '2019-05-23 21:38:04', 1, 0);
INSERT INTO `comment` VALUES (51, 1, NULL, 5, '好听', '2019-05-23 21:39:55', 1, 0);
INSERT INTO `comment` VALUES (52, 1, NULL, 5, '好听', '2019-05-23 21:40:25', 1, 0);
INSERT INTO `comment` VALUES (53, 1, 107, NULL, 'I love you！！！', '2019-06-03 02:16:23', 0, 0);
INSERT INTO `comment` VALUES (54, 1, 95, NULL, '好听', '2020-03-14 16:14:53', 0, 0);
INSERT INTO `comment` VALUES (55, 1, 28, NULL, '?', '2020-03-14 16:19:11', 0, 0);
INSERT INTO `comment` VALUES (56, 26, 69, NULL, 'good!', '2020-03-22 02:19:03', 0, 0);
INSERT INTO `comment` VALUES (57, 26, 10, NULL, 'good', '2020-03-22 03:40:10', 0, 3);
COMMIT;

-- ----------------------------
-- Table structure for consumer
-- ----------------------------
DROP TABLE IF EXISTS `consumer`;
CREATE TABLE `consumer` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(100) NOT NULL,
  `sex` tinyint DEFAULT NULL,
  `phoneNum` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` char(30) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `phone_num_UNIQUE` (`phoneNum`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of consumer
-- ----------------------------
BEGIN;
INSERT INTO `consumer` VALUES (1, 'admin', 'admin', 1, '17683757476', '1378291419@qq.com', '2022-10-01 00:00:00', '做好自己', '湖北', '/img/avatarImages/user.jpg', '2019-01-04 21:42:24', '2022-12-03 14:06:52');
INSERT INTO `consumer` VALUES (30, '123456', '123456', 1, '123456', '123456@qq.com', '2022-10-10 00:00:00', '123456', '北京', '/img/avatarImages/user.jpg', '2022-10-10 00:18:46', '2022-12-03 14:06:52');
INSERT INTO `consumer` VALUES (31, 'user_test', '1234567', NULL, '12345678901', NULL, NULL, NULL, NULL, '/img/avatarImages/user.jpg', '2022-12-01 00:13:40', '2022-12-01 00:13:40');
INSERT INTO `consumer` VALUES (32, 'test', '123456', NULL, '18621562618', NULL, NULL, NULL, NULL, '/img/avatarImages/user.jpg', '2022-12-01 00:40:16', '2022-12-01 00:40:16');
INSERT INTO `consumer` VALUES (34, 'test1', '123456', NULL, '12453215433', NULL, NULL, NULL, NULL, '/img/avatarImages/user.jpg', '2022-12-01 09:49:23', '2022-12-01 09:49:23');
INSERT INTO `consumer` VALUES (35, 'test2', '123456', NULL, '12453215436', NULL, NULL, NULL, NULL, '/img/avatarImages/user.jpg', '2022-12-01 09:58:54', '2022-12-01 09:58:54');
INSERT INTO `consumer` VALUES (36, 'test3', '123456', NULL, '12453219436', NULL, NULL, NULL, NULL, '/img/avatarImages/user.jpg', '2022-12-01 10:15:04', '2022-12-01 10:15:04');
INSERT INTO `consumer` VALUES (37, 'test4', '123456', NULL, '12454219436', NULL, NULL, NULL, NULL, '/img/avatarImages/user.jpg', '2022-12-01 10:33:33', '2022-12-01 10:33:33');
INSERT INTO `consumer` VALUES (38, 'test5', '123456', NULL, '12454119436', NULL, NULL, NULL, NULL, '/img/avatarImages/user.jpg', '2022-12-01 10:43:03', '2022-12-03 14:06:07');
INSERT INTO `consumer` VALUES (39, 'test6', '123456', NULL, '12954119436', NULL, NULL, NULL, NULL, '/img/avatarImages/user.jpg', '2022-12-01 10:48:51', '2022-12-03 14:06:07');
INSERT INTO `consumer` VALUES (40, 'test7', '123456', NULL, '42954119436', NULL, NULL, NULL, NULL, '/img/avatarImages/user.jpg', '2022-12-01 10:49:55', '2022-12-03 14:06:07');
INSERT INTO `consumer` VALUES (41, 'test8', '123456', NULL, '18654119436', NULL, NULL, NULL, NULL, '/img/avatarImages/user.jpg', '2022-12-01 10:53:03', '2022-12-03 14:06:52');
INSERT INTO `consumer` VALUES (42, 'test11', '123456', NULL, '18623542816', NULL, NULL, NULL, NULL, '/img/avatarImages/user.jpg', '2022-12-02 21:02:28', '2022-12-02 21:02:28');
INSERT INTO `consumer` VALUES (43, 'test100', '123456', NULL, '19992359823', NULL, NULL, NULL, NULL, '/img/avatarImages/1670047756350cuteFace.png', '2022-12-03 13:57:22', '2022-12-03 14:09:16');
INSERT INTO `consumer` VALUES (45, 'test200', 'adc3949ba5', NULL, '15031973942', NULL, NULL, NULL, NULL, '/img/avatarImages/user.jpg', '2022-12-03 14:16:52', '2022-12-03 14:16:52');
COMMIT;

-- ----------------------------
-- Table structure for feed
-- ----------------------------
DROP TABLE IF EXISTS `feed`;
CREATE TABLE `feed` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `media` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '媒体，逗号分割',
  `userId` int NOT NULL COMMENT '用户id',
  `createdAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatedAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of feed
-- ----------------------------
BEGIN;
INSERT INTO `feed` VALUES (5, '这是我这学期的课表，55怎么会有这么多课', '\"img/feed/1670049395525课表.jpg\"', 45, '2022-12-03 14:37:50', '2022-12-03 14:37:50');
INSERT INTO `feed` VALUES (6, '这是我用latex写公式的时候偶然发现的，好可爱的颜文字呀：）', 'img/feed/1670049589841cuteFace.jpg,img/feed/1670049589841cuteFace2.png', 45, '2022-12-03 14:41:29', '2022-12-03 14:41:29');
COMMIT;

-- ----------------------------
-- Table structure for list_song
-- ----------------------------
DROP TABLE IF EXISTS `list_song`;
CREATE TABLE `list_song` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `song_id` int unsigned NOT NULL,
  `song_list_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=215 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of list_song
-- ----------------------------
BEGIN;
INSERT INTO `list_song` VALUES (211, 17, 86);
INSERT INTO `list_song` VALUES (212, 17, 3);
INSERT INTO `list_song` VALUES (213, 17, 1);
INSERT INTO `list_song` VALUES (214, 24, 1);
COMMIT;

-- ----------------------------
-- Table structure for rank_list
-- ----------------------------
DROP TABLE IF EXISTS `rank_list`;
CREATE TABLE `rank_list` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `songListId` bigint unsigned NOT NULL,
  `consumerId` bigint unsigned NOT NULL,
  `score` int unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `consumerId` (`consumerId`,`songListId`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of rank_list
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for singer
-- ----------------------------
DROP TABLE IF EXISTS `singer`;
CREATE TABLE `singer` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `sex` tinyint DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of singer
-- ----------------------------
BEGIN;
INSERT INTO `singer` VALUES (1, '陈奕迅', 1, '/img/singerPic/16652029648451c950a7b02087bf40ad1c9a0ad99402c11dfa9ec616d.jpg', '1974-07-27 00:00:00', '中国香港', '著名实力派粤语流行音乐歌手、演员，香港演艺人协会副会长之一，曾被美国《时代杂志》形容为影响香港乐坛风格的人物，同时也是继许冠杰、张学友之后第三个获得“歌神”称号的香港男歌手。同时他也是继张学友后另一个在台湾获得成功的香港歌手，在2003年他成为了第二个拿到台湾金曲奖“最佳国语男演唱人”的香港歌手。陈奕迅曾被《时代》杂志形容为影响香港乐坛风格的人物。2010年，陈奕迅入选全球华人音乐殿堂华语金曲奖“30年经典评选”，成为1990年代出道歌手唯一代表。');
INSERT INTO `singer` VALUES (2, '林俊杰', 1, '/img/singerPic/1665203059426a8014c086e061d95fc94258578f40ad163d9cab9.jpg', '1981-03-27 00:00:00', '新加坡', '著名男歌手，作曲人、作词人、音乐制作人，偶像与实力兼具。林俊杰出生于新加坡的一个音乐世家。在父母的引导下，4岁就开始学习古典钢琴，不善言辞的他由此发现了另一种与人沟通的语言。小时候的林俊杰把哥哥林俊峰当作偶像，跟随哥哥的步伐做任何事，直到接触流行音乐后，便爱上创作这一条路。2003年以专辑《乐行者》出道，2004年一曲《江南》红遍两岸三地，凭借其健康的形象，迷人的声线，出众的唱功，卓越的才华，迅速成为华语流行乐坛的领军人物之一，迄今为止共创作数百首音乐作品，唱片销量在全亚洲逾1000万张。');
INSERT INTO `singer` VALUES (3, '周杰伦', 1, '/img/singerPic/16652032157993ac79f3df8dcd100baa1df14eac75010b912c8fc81f8.jpg', '1979-01-08 17:29:15', '中国台湾', '著名歌手，音乐人，词曲创作人，编曲及制作人，MV及电影导演。新世纪华语歌坛领军人物，中国风歌曲始祖，被时代周刊誉为“亚洲猫王”，是2000年后亚洲流行乐坛最具革命性与指标性的创作歌手，亚洲销量超过3100万张，有“亚洲流行天王”之称，开启华语乐坛“R&B时代”与“流行乐中国风”的先河，周杰伦的出现打破了亚洲流行乐坛长年停滞不前的局面，为亚洲流行乐坛翻开了新的一页，是华语乐坛真正把R&B提升到主流高度的人物，引领华语乐坛革命整十年，改写了华语乐坛的流行方向。');
INSERT INTO `singer` VALUES (4, '张紫豪', 1, '/img/singerPic/1665203635569f703738da9773912f0ac0638f7198618377ae2e5.jpg', '1997-06-22 00:00:00', '中国内地', '一个喜欢唱歌大男孩，希望每首歌都能有你故事。');
INSERT INTO `singer` VALUES (5, '颜人中', 1, '/img/singerPic/1665203833587472309f7905298220287b396d8ca7bcb0a46d42b.jpg', '1994-06-17 00:00:00', '中国台湾', '中国台湾创作型流行乐男歌手，毕业于中国文化大学（台湾）戏剧学系。');
INSERT INTO `singer` VALUES (6, '张信哲', 1, '/img/singerPic/1665205160341d833c895d143ad4bc5d3abbd82025aafa50f06c9.jpg', '1967-03-26 00:00:00', '中国台湾', '张信哲被誉为“情歌王子”，以他高亢温柔的声线，诚挚动人的歌声，唱出了令人沉醉的情歌世界');
INSERT INTO `singer` VALUES (7, '邵帅', 1, '/img/singerPic/1665204305295eaf81a4c510fd9f9d72af79ebb64c32a2834359b0eb8.jpg', '1998-02-08 00:00:00', '河南周口', '如果你心中有牵挂的人，那我祝福你，愿你们的冬天永远不缺暖阳。');
INSERT INTO `singer` VALUES (8, 'Beyond', 2, '/img/singerPic/1665205000811b7003af33a87e950a6f2019414385343faf2b465.jpg', '1962-06-10 00:00:00', '中国香港', 'Beyond，中国香港摇滚乐队，成立于1983年，由黄家驹、黄贯中、黄家强、叶世荣组成。');
INSERT INTO `singer` VALUES (9, '张国荣', 1, '/img/singerPic/1665205401662b219ebc4b74543a9b3ff04d11c178a82b80114c2.jpg', '1956-09-12 00:00:00', '中国香港', '张国荣是中国流行文化的指标人物之一,影视歌全能亚洲巨星,华人演艺圈多栖发展的代表之一');
INSERT INTO `singer` VALUES (10, '刘德华', 1, '/img/singerPic/16652057656761f178a82b9014a90f60314da2d3b2e12b31bb051400d.jpg', '1961-09-27 00:00:00', '中国香港', '刘德华是华人娱乐圈影、视、歌多栖发展的代表之一,在电视、电影、音乐等方面都留下了为数众多的代表作。作为演员，他是华语影坛的巨星.');
INSERT INTO `singer` VALUES (11, '陈百强', 1, '/img/singerPic/1665204840212267f9e2f070828381f30e7674ad3be014c086e065b27.jpg', '1958-09-07 00:00:00', '中国香港', '擅长演绎浪漫情歌，亦能自己创作歌曲');
INSERT INTO `singer` VALUES (12, '尚士达', 1, '/img/singerPic/16652040855340b46f21fbe096b63f624ac4f6a799044ebf81a4c06d3.jpg', '1999-05-03 00:00:00', '河南濮阳', '如果你有梦想就努力去实现');
INSERT INTO `singer` VALUES (13, '张学友', 1, '/img/singerPic/166520559676511385343fbf2b21193131db754ce72380cd7902320b1.jpg', '1961-07-10 00:00:00', '中国香港', '张学友是流行音乐领域的巨星和先行者。他的影响力覆盖全球华人社会以及东南亚，20世纪90年代在华人中流行这样一句话：有风吹过的地方就有张学友的音乐回荡。');
INSERT INTO `singer` VALUES (14, '孟凡明', 1, '/img/singerPic/16652045454095243fbf2b2119313592fa54568380cd790238dd3.jpg', '1994-04-05 00:00:00', '中国内地', '把我关进冰箱里,逃离人间几百世纪。');
INSERT INTO `singer` VALUES (15, '黎明', 1, '/img/singerPic/16652058840007dd98d1001e93901b24f585472ec54e736d1960f.jpg', '1966-12-11 00:00:00', '中国香港', '20世纪80年代，黎明因为俊朗潇洒的外表，被封为偶像派的文艺青年。他身上那种忧郁的文艺青年气质为他带来不少文艺影片拍摄的机会。');
COMMIT;

-- ----------------------------
-- Table structure for song
-- ----------------------------
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `singer` varchar(255) NOT NULL,
  `name` varchar(45) NOT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `createdAt` datetime NOT NULL COMMENT '发行时间',
  `updatedAt` datetime NOT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `lyric` text,
  `uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `clicksCount` bigint unsigned NOT NULL DEFAULT '0',
  `commentsCount` bigint unsigned NOT NULL DEFAULT '23',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=212 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of song
-- ----------------------------
BEGIN;
INSERT INTO `song` VALUES (164, '许嵩', '不语', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/不语.jpg', NULL, '/song/不语.flac', 11, 23);
INSERT INTO `song` VALUES (165, '许嵩', '九月清晨', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/九月清晨.jpg', NULL, '/song/九月清晨.flac', 11, 23);
INSERT INTO `song` VALUES (166, '许嵩', '今年勇', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/今年勇.jpg', NULL, '/song/今年勇.flac', 11, 23);
INSERT INTO `song` VALUES (167, '许嵩', '伴虎', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/伴虎.jpg', NULL, '/song/伴虎.flac', 11, 23);
INSERT INTO `song` VALUES (168, '许嵩', '你若成风', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/你若成风.jpg', NULL, '/song/你若成风.flac', 11, 23);
INSERT INTO `song` VALUES (169, '许嵩', '假摔', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/假摔.jpg', NULL, '/song/假摔.flac', 11, 23);
INSERT INTO `song` VALUES (170, '许嵩', '内线', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/内线.jpg', NULL, '/song/内线.flac', 11, 23);
INSERT INTO `song` VALUES (171, '许嵩', '冰柜', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/冰柜.jpg', NULL, '/song/冰柜.flac', 11, 23);
INSERT INTO `song` VALUES (172, '许嵩', '千百度', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/千百度.jpg', NULL, '/song/千百度.flac', 11, 23);
INSERT INTO `song` VALUES (173, '许嵩', '单人旅途', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/单人旅途.jpg', NULL, '/song/单人旅途.flac', 11, 23);
INSERT INTO `song` VALUES (174, '许嵩', '半城烟沙', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/半城烟沙.jpg', NULL, '/song/半城烟沙.flac', 11, 23);
INSERT INTO `song` VALUES (175, '许嵩', '城府', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/城府.jpg', NULL, '/song/城府.flac', 11, 23);
INSERT INTO `song` VALUES (176, '许嵩', '多余的解释', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/多余的解释.jpg', NULL, '/song/多余的解释.flac', 11, 23);
INSERT INTO `song` VALUES (177, '许嵩', '大千世界', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/大千世界.jpg', NULL, '/song/大千世界.flac', 11, 23);
INSERT INTO `song` VALUES (178, '许嵩', '对话老师', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/对话老师.jpg', NULL, '/song/对话老师.flac', 11, 23);
INSERT INTO `song` VALUES (179, '许嵩', '平行宇宙', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/平行宇宙.jpg', NULL, '/song/平行宇宙.flac', 11, 23);
INSERT INTO `song` VALUES (180, '许嵩', '幻胖', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/幻胖.jpg', NULL, '/song/幻胖.flac', 11, 23);
INSERT INTO `song` VALUES (181, '许嵩', '庐州月', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/庐州月.jpg', NULL, '/song/庐州月.flac', 11, 23);
INSERT INTO `song` VALUES (182, '许嵩', '庞贝', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/庞贝.jpg', NULL, '/song/庞贝.flac', 11, 23);
INSERT INTO `song` VALUES (183, '许嵩', '弹指一挥间', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/弹指一挥间.jpg', NULL, '/song/弹指一挥间.flac', 11, 23);
INSERT INTO `song` VALUES (184, '许嵩', '惊鸿一面', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/惊鸿一面.jpg', NULL, '/song/惊鸿一面.flac', 11, 23);
INSERT INTO `song` VALUES (185, '许嵩', '摆脱', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/摆脱.jpg', NULL, '/song/摆脱.flac', 11, 23);
INSERT INTO `song` VALUES (186, '许嵩', '放肆', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/放肆.jpg', NULL, '/song/放肆.flac', 11, 23);
INSERT INTO `song` VALUES (187, '许嵩', '敬酒不吃', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/敬酒不吃.jpg', NULL, '/song/敬酒不吃.flac', 11, 23);
INSERT INTO `song` VALUES (191, '许嵩', '明智之举', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/明智之举.jpg', NULL, '/song/明智之举.flac', 11, 23);
INSERT INTO `song` VALUES (192, '许嵩', '柳成荫', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/柳成荫.jpg', NULL, '/song/柳成荫.flac', 11, 23);
INSERT INTO `song` VALUES (193, '许嵩', '诲人不倦', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/诲人不倦.jpg', NULL, '/song/诲人不倦.flac', 11, 23);
INSERT INTO `song` VALUES (194, '许嵩', '江湖', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/江湖.jpg', NULL, '/song/江湖.flac', 11, 23);
INSERT INTO `song` VALUES (195, '许嵩', '河山大好', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/河山大好.jpg', NULL, '/song/河山大好.flac', 11, 23);
INSERT INTO `song` VALUES (196, '许嵩', '浪', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/浪.jpg', NULL, '/song/浪.flac', 11, 23);
INSERT INTO `song` VALUES (198, '许嵩', '灰色头像', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/灰色头像.jpg', NULL, '/song/灰色头像.flac', 11, 23);
INSERT INTO `song` VALUES (199, '许嵩', '玫瑰花的葬礼', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/玫瑰花的葬礼.jpg', NULL, '/song/玫瑰花的葬礼.flac', 11, 23);
INSERT INTO `song` VALUES (200, '许嵩', '白色面包车', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/白色面包车.jpg', NULL, '/song/白色面包车.flac', 11, 23);
INSERT INTO `song` VALUES (201, '许嵩', '科幻', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/科幻.jpg', NULL, '/song/科幻.flac', 11, 23);
INSERT INTO `song` VALUES (202, '许嵩', '等到烟火清凉', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/等到烟火清凉.jpg', NULL, '/song/等到烟火清凉.flac', 11, 23);
INSERT INTO `song` VALUES (203, '许嵩', '绝代风华', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/绝代风华.jpg', NULL, '/song/绝代风华.flac', 11, 23);
INSERT INTO `song` VALUES (204, '许嵩', '老古董', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/老古董.jpg', NULL, '/song/老古董.flac', 11, 23);
INSERT INTO `song` VALUES (205, '许嵩', '胡萝卜须', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/胡萝卜须.jpg', NULL, '/song/胡萝卜须.flac', 11, 23);
INSERT INTO `song` VALUES (206, '许嵩', '蝴蝶的时间', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/蝴蝶的时间.jpg', NULL, '/song/蝴蝶的时间.flac', 11, 23);
INSERT INTO `song` VALUES (207, '许嵩', '超市', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/超市.jpg', NULL, '/song/超市.flac', 11, 23);
INSERT INTO `song` VALUES (208, '许嵩', '闺蜜', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/闺蜜.jpg', NULL, '/song/闺蜜.flac', 11, 23);
INSERT INTO `song` VALUES (209, '许嵩', '降温', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/降温.jpg', NULL, '/song/降温.flac', 11, 23);
INSERT INTO `song` VALUES (210, '许嵩', '隔代', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/隔代.jpg', NULL, '/song/隔代.flac', 11, 23);
INSERT INTO `song` VALUES (211, '许嵩', '飞驰于你', NULL, '2022-11-30 00:00:00', '2022-11-30 00:00:00', '/img/songPic/飞驰于你.jpg', NULL, '/song/飞驰于你.flac', 11, 23);
COMMIT;

-- ----------------------------
-- Table structure for song_list
-- ----------------------------
DROP TABLE IF EXISTS `song_list`;
CREATE TABLE `song_list` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `pic` varchar(255) DEFAULT '/img/songListPic/123.jpg',
  `introduction` text,
  `style` varchar(10) DEFAULT '无',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of song_list
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

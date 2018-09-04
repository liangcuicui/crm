/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : customer

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 04/09/2018 17:53:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_dict
-- ----------------------------
DROP TABLE IF EXISTS `base_dict`;
CREATE TABLE `base_dict`  (
  `dict_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据字典id(主键)',
  `dict_type_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据字典类别代码',
  `dict_type_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据字典类别名称',
  `dict_item_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据字典项目名称',
  `dict_item_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据字典项目(可为空)',
  `dict_sort` int(10) NULL DEFAULT NULL COMMENT '排序字段',
  `dict_enable` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '1:使用 0:停用',
  `dict_memo` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of base_dict
-- ----------------------------
INSERT INTO `base_dict` VALUES ('1', '001', '客户行业', '教育培训 ', NULL, 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('10', '003', '公司性质', '民企', NULL, 3, '1', NULL);
INSERT INTO `base_dict` VALUES ('12', '004', '年营业额', '1-10万', NULL, 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('13', '004', '年营业额', '10-20万', NULL, 2, '1', NULL);
INSERT INTO `base_dict` VALUES ('14', '004', '年营业额', '20-50万', NULL, 3, '1', NULL);
INSERT INTO `base_dict` VALUES ('15', '004', '年营业额', '50-100万', NULL, 4, '1', NULL);
INSERT INTO `base_dict` VALUES ('16', '004', '年营业额', '100-500万', NULL, 5, '1', NULL);
INSERT INTO `base_dict` VALUES ('17', '004', '年营业额', '500-1000万', NULL, 6, '1', NULL);
INSERT INTO `base_dict` VALUES ('18', '005', '客户状态', '基础客户', NULL, 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('19', '005', '客户状态', '潜在客户', NULL, 2, '1', NULL);
INSERT INTO `base_dict` VALUES ('2', '001', '客户行业', '电子商务', NULL, 2, '1', NULL);
INSERT INTO `base_dict` VALUES ('20', '005', '客户状态', '成功客户', NULL, 3, '1', NULL);
INSERT INTO `base_dict` VALUES ('21', '005', '客户状态', '无效客户', NULL, 4, '1', NULL);
INSERT INTO `base_dict` VALUES ('22', '006', '客户级别', '普通客户', NULL, 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('23', '006', '客户级别', 'VIP客户', NULL, 2, '1', NULL);
INSERT INTO `base_dict` VALUES ('24', '007', '商机状态', '意向客户', NULL, 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('25', '007', '商机状态', '初步沟通', NULL, 2, '1', NULL);
INSERT INTO `base_dict` VALUES ('26', '007', '商机状态', '深度沟通', NULL, 3, '1', NULL);
INSERT INTO `base_dict` VALUES ('27', '007', '商机状态', '签订合同', NULL, 4, '1', NULL);
INSERT INTO `base_dict` VALUES ('3', '001', '客户行业', '对外贸易', NULL, 3, '1', NULL);
INSERT INTO `base_dict` VALUES ('30', '008', '商机类型', '新业务', NULL, 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('31', '008', '商机类型', '现有业务', NULL, 2, '1', NULL);
INSERT INTO `base_dict` VALUES ('32', '009', '商机来源', '电话营销', NULL, 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('33', '009', '商机来源', '网络营销', NULL, 2, '1', NULL);
INSERT INTO `base_dict` VALUES ('34', '009', '商机来源', '推广活动', NULL, 3, '1', NULL);
INSERT INTO `base_dict` VALUES ('4', '001', '客户行业', '酒店旅游', NULL, 4, '1', NULL);
INSERT INTO `base_dict` VALUES ('5', '001', '客户行业', '房地产', NULL, 5, '1', NULL);
INSERT INTO `base_dict` VALUES ('6', '002', '客户信息来源', '电话营销', NULL, 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('7', '002', '客户信息来源', '网络营销', NULL, 2, '1', NULL);
INSERT INTO `base_dict` VALUES ('8', '003', '公司性质', '合资', NULL, 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('9', '003', '公司性质', '国企', NULL, 2, '1', NULL);

-- ----------------------------
-- Table structure for cst_customer
-- ----------------------------
DROP TABLE IF EXISTS `cst_customer`;
CREATE TABLE `cst_customer`  (
  `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
  `cust_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户名称(公司名称)',
  `cust_source` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户信息来源',
  `cust_industry` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户所属行业',
  `cust_level` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户级别',
  `cust_phone` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '固定电话',
  `cust_mobile` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '移动电话',
  `cust_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cust_id`) USING BTREE,
  INDEX `FKeh5g36duab8g1h051pdjfwcgd`(`cust_source`) USING BTREE,
  INDEX `FK2xhr3arwp3tkuae1da4lqv352`(`cust_industry`) USING BTREE,
  INDEX `FKrty52nvbjg1echf0se39eng49`(`cust_level`) USING BTREE,
  CONSTRAINT `cst_customer_ibfk_1` FOREIGN KEY (`cust_source`) REFERENCES `base_dict` (`dict_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `cst_customer_ibfk_2` FOREIGN KEY (`cust_industry`) REFERENCES `base_dict` (`dict_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `cst_customer_ibfk_3` FOREIGN KEY (`cust_level`) REFERENCES `base_dict` (`dict_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK2xhr3arwp3tkuae1da4lqv352` FOREIGN KEY (`cust_industry`) REFERENCES `base_dict` (`dict_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKeh5g36duab8g1h051pdjfwcgd` FOREIGN KEY (`cust_source`) REFERENCES `base_dict` (`dict_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKrty52nvbjg1echf0se39eng49` FOREIGN KEY (`cust_level`) REFERENCES `base_dict` (`dict_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cst_customer
-- ----------------------------
INSERT INTO `cst_customer` VALUES (19, '张三', '7', '2', '22', '022-225', '333', 'C:/upload/9/8/1760f1da3f1d4634a6e5d3a14a238a52');
INSERT INTO `cst_customer` VALUES (21, '李四', '6', '4', '22', '12343', '2222', NULL);
INSERT INTO `cst_customer` VALUES (22, '张1', '7', '2', '22', '3335', '', NULL);
INSERT INTO `cst_customer` VALUES (23, '张2', '6', '3', '22', '13254', '123', NULL);
INSERT INTO `cst_customer` VALUES (24, '大催催', '7', '2', '23', '', '', NULL);

-- ----------------------------
-- Table structure for cst_linkman
-- ----------------------------
DROP TABLE IF EXISTS `cst_linkman`;
CREATE TABLE `cst_linkman`  (
  `lkm_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '联系人编号(主键)',
  `lkm_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人姓名',
  `lkm_cust_id` bigint(32) NOT NULL COMMENT '客户id',
  `lkm_gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人性别',
  `lkm_phone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人办公电话',
  `lkm_mobile` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人手机',
  `lkm_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人邮箱',
  `lkm_qq` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人qq',
  `lkm_position` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人职位',
  `lkm_memo` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人备注',
  PRIMARY KEY (`lkm_id`) USING BTREE,
  INDEX `FK_cst_linkman_lkm_cust_id`(`lkm_cust_id`) USING BTREE,
  CONSTRAINT `FKh9yp1nql5227xxcopuxqx2e7q` FOREIGN KEY (`lkm_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_cst_linkman_lkm_cust_id` FOREIGN KEY (`lkm_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cst_linkman
-- ----------------------------
INSERT INTO `cst_linkman` VALUES (2, '小四', 21, '男', '02223', '1235', 'aa@qq.com', '09009', '经理', '熟人');
INSERT INTO `cst_linkman` VALUES (3, '小战', 23, '女', '77988', '79855', '99@163.com', '9899', '职员', 'meisha');

-- ----------------------------
-- Table structure for sale_visit
-- ----------------------------
DROP TABLE IF EXISTS `sale_visit`;
CREATE TABLE `sale_visit`  (
  `visit_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `visit_cust_id` bigint(32) NULL DEFAULT NULL COMMENT '客户id',
  `visit_user_id` bigint(32) NULL DEFAULT NULL COMMENT '负责人id',
  `visit_time` date NULL DEFAULT NULL COMMENT '拜访时间',
  `visit_addr` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拜访地点',
  `visit_detail` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拜访详情',
  `visit_nexttime` date NULL DEFAULT NULL COMMENT '下次拜访时间',
  PRIMARY KEY (`visit_id`) USING BTREE,
  INDEX `FK_sale_visit_cust_id`(`visit_cust_id`) USING BTREE,
  INDEX `FK_sale_visit_user_id`(`visit_user_id`) USING BTREE,
  CONSTRAINT `FK1ndldk9dhlv7xqyftts1vf3do` FOREIGN KEY (`visit_user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKgr4aivocixwcvkwxcmc0b4css` FOREIGN KEY (`visit_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_sale_visit_cust_id` FOREIGN KEY (`visit_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_sale_visit_user_id` FOREIGN KEY (`visit_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sale_visit
-- ----------------------------
INSERT INTO `sale_visit` VALUES ('1', 19, 1, '2018-09-05', '天津', '无', '2018-09-26');
INSERT INTO `sale_visit` VALUES ('297e8a8b65a370950165a37186940000', 21, 3, '2018-09-03', NULL, '', '2018-09-05');
INSERT INTO `sale_visit` VALUES ('297e8a8b65a3824a0165a3837f960000', 23, 7, '2018-09-06', '这', '', '2018-09-27');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `user_password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `user_state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '1正常，0暂停',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '张三', '123', '1');
INSERT INTO `user` VALUES (3, 'aaa', 'aa', '4124bc0a9335c27f086f24ba207a4912', '1');
INSERT INTO `user` VALUES (6, '王五', 'ww', '202cb962ac59075b964b07152d234b70', '1');
INSERT INTO `user` VALUES (7, '张三', 'asa', '202cb962ac59075b964b07152d234b70', '1');

SET FOREIGN_KEY_CHECKS = 1;

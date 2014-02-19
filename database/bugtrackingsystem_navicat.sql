/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : bugtrackingsystem

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2014-02-19 12:09:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for buginfo
-- ----------------------------
DROP TABLE IF EXISTS `buginfo`;
CREATE TABLE `buginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bugId` varchar(255) DEFAULT NULL,
  `title` varchar(500) DEFAULT NULL,
  `project` varchar(500) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `description` text,
  `owner` varchar(255) DEFAULT NULL,
  `submitter` varchar(255) DEFAULT NULL,
  `submitData` datetime DEFAULT NULL,
  `severity` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `regression` varchar(255) DEFAULT NULL,
  `component` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buginfo
-- ----------------------------
INSERT INTO `buginfo` VALUES ('19', '0364881', 'G11n: I18n: SC: The text template in username label doesn’t disappear after pressing Shift key when using default Chinese input method on Win8x64 with Firefox 18.0.', 'Receiver for Web', 'Failure', 'Assigned', '<[1359975102]> - Weitao Shen (3P):\r<br>--Repro Steps:\r<br>1. Prepared XA setup with Archer RTM build on SC Windows 2008R2 SP1.\r<br>2. Published some apps.\r<br>3. Prepared Storefront setup with build 46 on SC Windows 2012.\r<br>4. Hosted Store on above XA setup and create Web Receiver site.\r<br>5. From Windows 8 X64 client machine, browsed to WR site with Firefox 18.0.\r<br>7. Typed some words into username label using default Chinese input method.\r<br>8. Pressed Shift key and checked the text template in username label.\r<br>\r<br>--Expected Result:\r<br>After press Shift key once time, English letters should be selected and inputted into username label, the text template should be disappears,\r<br>\r<br>--Actual Result:\r<br>After pressed Shift key, English letters was selected and seems to be inputted into username label.\r<br>But at this time, the text template didn’t disappear and overlapping occurred.\r<br>After pressed Shift key again, the text template disappeared.\r<br>\r<br>--Issue occurring on language:\r<br>SC: Win8x64 with Firefox 18.0: Fail\r<br>SC: Win8x64 with IE10: Pass\r<br>SC: Win7x86 with Firefox 18.0: Pass \r<br>SC: Win7x86 with IE9: Pass\r<br>\r<br>--Note:\r<br>1. This issue is only reproduced in Win8x64 with Firefox in SC when using default Chinese input method.\r<br>2. When using a popular Chinese input method like “Sougou Pinyin”, this issue is not happened in Win8x64 with Firefox.\r<br>\r<br>--Environment details:\r<br>XenApp: Archer RTM\r<br>Receiver Storefront: Build 46								 \r<br>Windows Receiver: Zeus4 RTM									             \r<br>Web Receiver OS: Win8x64								              \r<br>Browser: Firefox 18.0									               \r<br>Language: SC\r<br>\r<br>--Contract person:\r<br>Weitao.shen@pactera.com                                                                                                  \r<br>CC:Shally.Garg@Citrix.com\r<br>\r<br><[1365580671]> - Dariusz Sczcepaniak:\r<br>comment from Jun Zhang:\r<br>\r<br>This issue isn’t a big problem, frankly I doubt whether end-user can find the difference.\r<br>This bug is similar to BUG0330993  and we believe they have the same root cause: IME and browser can’t match well, because of background signals are not triggered. \r<br>EphramW will work on BUG0330993 solution soon, and will update you once any founding.', 'Vincent Huang', 'Weitao Shen (3P)', '2013-02-04 10:51:42', 'S4 - Low', null, 'No', 'HDX-ICA Integration');
INSERT INTO `buginfo` VALUES ('20', '0405135', 'loader.conf in recovery directory should have boot_verbose set to 0', 'NetScaler', '', 'Closed', '<[1374629840]> - Saravanan Dhakshinamurthy:<br>loader.conf in recovery directory should have boot_verbose set to 0<br><br><[1379529742]> - Avantika Sahai:<br>root@ns# pwd<br>/flash/.recovery/boot<br>root@ns# cat loader.conf <br>kernel=kernel<br>autoboot_delay=\"3\"<br>vfs.root.mountfrom=\"ufs:/dev/md0c\"<br>boot_verbose=0<br>console=comconsole<br>root@ns# exit<br>logout<br> Done<br>Decapolis-36> sh version<br>        NetScaler NS11.0: Build 12.3.nc, Date: Sep 10 2013, 00:10:23  <br> Done<br>Decapolis-36> sh hardware<br>        Platform: NSMPX-22000 16*CPU+24*IX+12*E1K+2*E1K+4*CVM N3 2200100<br>        Manufactured on: 12/8/2013<br>        CPU: 2900MHZ<br>        Host Id: 1006665862<br>        Serial no: 1HN2V2AANM<br>        Encoded serial no: 1HN2V2AANM<br> Done', '(None)', 'Saravanan Dhakshinamurthy', '2013-07-24 01:37:20', 'S3 - Medium', '', '(None)', 'DDC-ADIdentity Service');
INSERT INTO `buginfo` VALUES ('21', '0000014', 'Workstaions can be added to the Managed Desktop if the Mapping exists even if they are not in the domain', 'XenDesktop', 'Failure', 'Post Shipped', 'CPR # 178452 was cloned on Oct  3 2008 12:55PM ...<br>CPR # 178452 was cloned to CPR # 198968 ...<br>If a mapping exists on a workstation pool Management doesn\'t do reverse lookup when adding the workstation to the desktop this can be problem if a workstation has got mapping but not part of the domain. Workstation will be added to the Desktop and Pool Management Service will include it as part of idle count but no one will be able to login as it will not get registered<br><br>REPRO STEPS<br>------------------------<br><br>Add a workstation w1 which is part of a domain to a Managed Desktop d1. Delete the Desktop d1. Remove w1 from the domain. Publish a new Managed Desktop d2 and add w1 to the desktop d2. The old mapping will be used and no reverse lookup will be performed. <br><br><br>This can have some serious problems in case of managed Pooled Desktops. Pool Management Service treats the workstation as part of the Pool irrespective of it is in the domain or not. There can be a scenario where user tries to login Pool management service starts the workstation which is not in the domain and after a while user gets an error as that workstation will not get registered while there are other workstations available.<br><br>See Notes', '(None)', 'Jamal Ahmed', '2008-01-03 05:56:11', 'S3 - Medium', 'shared PS PUBSDONE KB?', 'No', 'DDC-ADIdentity Service');
INSERT INTO `buginfo` VALUES ('22', '0000020', 'G11N: Barossa: Installer: SC, KO,TC : Misalignment occurs in the description text of help.', 'XenDesktop', 'Cosmetic', 'Post Shipped', 'CPR # 178526 was cloned on May 20 2008  5:30AM ...<br>CPR # 178526 was cloned to CPR # 191639 ...<br>--Contact person<br>Test Engineer email ID: Limin.tang@hisoft.com (cc: Hideaki.Fujiwara@citrix.co.jp)<br><br>--CPR description (Brief)<br>G11N: Barossa: Installer: SC, KO: Misalignment occurs in the description text of unattended installation help.<br><br>--Reproducing Steps<br>1.Restore a refresh SC Win2k3 R2 Server platform.<br>2.Run setup.exe in Barossa build 2129 through the command line with the -help option<br>3.The Help text display.<br><br>--Expected Behavior<br>The description text display normally.<br><br>--Actual Behavior<br>Misalignment occurs in the description text. Please refer to the attachment.<br><br>--Issue occurs on languages<br>SC: Win 2k3 R2 SC 32-bit: Barossa 2129 - Fail<br>KO: Win 2k3 R2 KO 32-bit: Barossa 2129 - Fail<br>TC: Win 2k3 R2 KO 32-bit: Barossa 2131 - Fail<br>EN: Win 2k3 R2 EN 32-bit: Barossa 2128 - Pass<br><br>--Frequency<br>100%<br><br>--Test engineer<br>Tang Limin', '(None)', 'Limin Tang (3P)', '2008-01-04 00:33:55', 'S4 - Low', 'PS', 'Pending Validation', null);
INSERT INTO `buginfo` VALUES ('23', '0382752', 'EN: Page layout of \"User Configuration\" and \"Vendor Daemon Configuration\" is disordered on IE10.', 'Jasper', 'Cosmetic', 'Assigned', '<[1366357728]> - Jia Sun (3P):\r\n--Contact person\r\njia.sun@pactera.com\r\nCC: Abhishek.Singh@citrix.com\r\n\r\n--Build No.\r\nBuild: License build 345230#120440#40986\r\nServer OS: Win2012\r\nBrowser: IE10\r\n\r\n--Repro steps\r\n1. Install License server.\r\n2. Open Citrix License Administration Console\r\n3. Click \"Administration\" to log in.\r\n4. Select \"User Configuration\", check the page layout.\r\n5. Select \"Vendor Daemon Configuration\", check the page layout\r\n\r\n--Except result\r\nBoth pages should display fine and no UI issues.\r\n\r\n--Actual result\r\nThe page layout is disordered.\r\n\r\n--Note\r\nIt cannot repro on IE9, IE8, Firefox and Chrome.\r\n\r\n<[1392286270]> - Abhishek Singh:\r\nLooks like 3rd party issue. Assigning to Vincent to confirm.', 'test', 'Jia Sun (3P)', '2013-04-19 07:48:48', 'S4 - Low', 'G11N', 'Data Not Required', 'DDC-ADIdentity Service');

-- ----------------------------
-- Table structure for managedbugs
-- ----------------------------
DROP TABLE IF EXISTS `managedbugs`;
CREATE TABLE `managedbugs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userInfoId` int(11) DEFAULT NULL,
  `bugInfoId` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '0' COMMENT '0 represents not deleted. 1 represents having been deleted',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`userInfoId`,`bugInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of managedbugs
-- ----------------------------
INSERT INTO `managedbugs` VALUES ('1', '4', '20', '0');
INSERT INTO `managedbugs` VALUES ('2', '4', '21', '0');
INSERT INTO `managedbugs` VALUES ('3', '4', '22', '0');
INSERT INTO `managedbugs` VALUES ('5', '5', '21', '0');
INSERT INTO `managedbugs` VALUES ('6', '5', '22', '0');
INSERT INTO `managedbugs` VALUES ('7', '5', '19', '0');
INSERT INTO `managedbugs` VALUES ('8', '4', '19', '0');

-- ----------------------------
-- Table structure for ownerbugs
-- ----------------------------
DROP TABLE IF EXISTS `ownerbugs`;
CREATE TABLE `ownerbugs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userInfoId` int(11) DEFAULT NULL,
  `bugInfoId` int(11) DEFAULT NULL,
  `status` int(2) DEFAULT '0',
  `changed` int(2) DEFAULT '0',
  `newOwner` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`userInfoId`,`bugInfoId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ownerbugs
-- ----------------------------
INSERT INTO `ownerbugs` VALUES ('1', '4', '23', '0', '1', 'Vincent Huang');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `oneBugFullName` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('4', 'admin', 'admin', 'test', 'yin-shun-ming@163.com');
INSERT INTO `userinfo` VALUES ('5', 'test', 'test', 'Shunming Yin (Intern)', 'i@i.com');

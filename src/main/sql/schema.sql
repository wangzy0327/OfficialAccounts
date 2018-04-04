DROP DATABASE IF EXISTS `official_accounts`;
CREATE DATABASE IF NOT EXISTS `official_accounts` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
use `official_accounts`;
DROP TABLE IF EXISTS `t_token`;
CREATE TABLE IF NOT EXISTS `t_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `access_token` varchar(1024) NOT NULL,
  `expires_in` int(11) NOT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;
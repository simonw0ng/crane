drop table if exists t_user;

CREATE TABLE t_user (
  ID bigint(18) DEFAULT NULL COMMENT 'ÓÃ»§ID',
  LOGIN_NAME varchar(32) DEFAULT NULL COMMENT 'µÇÂ½Ãû³Æ',
  PASSWORD varchar(32) DEFAULT NULL COMMENT 'µÇÂ½ÃÜÂë'
) ENGINE=InnoDB DEFAULT CHARSET=utf8
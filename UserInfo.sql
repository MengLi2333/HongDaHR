create table T_USER ( -- 用户信息表
	N_USER_ID bigint auto_increment primary key comment '用户信息ID',
	VC_USER_NAME varchar(30) not null comment '用户姓名',
	VC_USER_CODE varchar(12) not null comment '用户编号',
	N_GENDER numeric(1,0) not null comment '用户性别',
	VC_IDCARD_CODE varchar(20) not null comment '身份证号',
	VC_PASSWORD varchar(30) not null comment '登录密码',
);
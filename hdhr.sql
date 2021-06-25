create database hdhr;

use hdhr;

create table T_DEPT ( -- 组织机构表
	N_DEPT_ID bigint auto_increment primary key comment '部门ID',
	VC_DEPT_CODE varchar(6) not null comment '部门编号',
	VC_DEPT_NAME varchar(30) not null comment '部门名称',
	N_DEPT_TYPE numeric(1,0) not null comment '部门类型',
	N_PARENT_ID bigint comment '上级部门ID',
	VC_LOCATION varchar(200) comment '地址',
	VC_POST_CODE varchar(20) comment '邮编',
	VC_TELEPHONE varchar(20) comment '联系电话',
	VC_FAX varchar(20) comment '传真',
	VC_MAIL varchar(50) comment '电子邮件',
	N_IS_REMOVED numeric(1,0) not null comment '是否已撤销',
	D_REMOVE_DATE date comment '撤销时间',
	foreign key(N_PARENT_ID) references T_DEPT(N_DEPT_ID)
);

create table T_TITLE ( -- 职称信息表
	N_TITLE_ID bigint auto_increment primary key comment '职称ID',
	VC_TITLE_NAME varchar(30) not null comment '职称名称',
	VC_QUALIFICATION varchar(500) not null comment '任职资格',
	VC_DUTY varchar(500) not null comment '职称职责',
	VC_WORK_TARGET varchar(500) not null comment '工作目标'
);

create table T_POST ( -- 岗位信息表
	N_POST_ID bigint auto_increment primary key comment '岗位ID',
	VC_POST_NAME varchar(30) not null comment '岗位名称',
	N_PARENT_ID bigint comment '上级岗位ID',
	VC_DUTY varchar(500) not null comment '岗位职责',
	VC_QUALIFICATION varchar(500) not null comment '任职资格',
	VC_PURVIEW varchar(500) not null comment '岗位权限',
	VC_WORK_CONTENT varchar(500) not null comment '工作内容',
	foreign key(N_PARENT_ID) references T_POST(N_POST_ID)
);

create table T_EMP ( -- 员工信息表
	N_EMP_ID bigint auto_increment primary key comment '员工信息ID',
	N_DEPT_ID bigint not null comment '所在部门ID',
	N_TITLE_ID bigint not null comment '职称ID',
	N_POST_ID bigint not null comment '岗位ID',
	VC_EMP_NAME varchar(30) not null comment '员工姓名',
	VC_EMP_CODE varchar(12) not null comment '员工编号',
	N_GENDER numeric(1,0) not null comment '员工性别',
	VC_IDCARD_CODE varchar(20) not null comment '身份证号',
	D_BIRTHDAY date not null comment '出生日期',
	VC_NATIVE_PLACE varchar(50) comment '籍贯',
	N_EDU_LEVEL numeric(1,0) not null comment '学历',
	N_NATION numeric(2,0) not null comment '名族',
	N_PARTY numeric(1,0) not null comment '政治面貌',
	N_HEALTH numeric(1,0) not null comment '健康状况',
	N_REG_TYPE numeric(1,0) not null comment '户口类型',
	N_STATUS numeric(1,0) not null comment '工作状态',
	VC_PASSWORD varchar(30) not null comment '登录密码',
	foreign key(N_DEPT_ID) references T_DEPT(N_DEPT_ID),
	foreign key(N_TITLE_ID) references T_TITLE(N_TITLE_ID),
	foreign key(N_POST_ID) references T_POST(N_POST_ID)
);

create table T_ROLE ( -- 角色表
	N_ROLE_ID bigint auto_increment primary key comment '角色ID',
	VC_ROLE_NAME varchar(30) not null comment '角色名称'
);

create table T_EMP_ROLE ( -- 员工角色表
	N_EMP_ID bigint comment '员工ID',
	N_ROLE_ID bigint comment '角色ID',
	foreign key(N_EMP_ID) references T_EMP(N_EMP_ID),
	foreign key(N_ROLE_ID) references T_ROLE(N_ROLE_ID),
	primary key(N_EMP_ID, N_ROLE_ID)
);

create table S_EMP_CODE_SEQ ( -- 模拟序列功能的表, 用于插入员工信息时生成员工编号
	seq int not null
);
insert into S_EMP_CODE_SEQ values(0);

create event E_CLEAR_SEQ on schedule every 1 day starts '2021-04-03 00:00:00' comment '每天0点将S_EMP_CODE_SEQ序列重置为0' do
	update S_EMP_CODE_SEQ set seq = 0;

create procedure P_INSERT_EMP( -- 插入员工信息
		in N_DEPT_ID bigint,
		in N_TITLE_ID bigint,
		in N_POST_ID bigint,
		in VC_EMP_NAME varchar(30),
		in N_GENDER numeric(1,0),
		in VC_IDCARD_CODE varchar(20),
		in D_BIRTHDAY date,
		in VC_NATIVE_PLACE varchar(50),
		in N_EDU_LEVEL numeric(1,0),
		in N_NATION numeric(2,0),
		in N_PARTY numeric(1,0),
		in N_HEALTH numeric(1,0),
		in N_REG_TYPE numeric(1,0),
		in N_STATUS numeric(1,0)
) begin
	declare emp_count int;
	declare count_str varchar(4);
	declare emp_code varchar(30);
	update S_EMP_CODE_SEQ set seq = LAST_INSERT_ID(seq+1);
	select LAST_INSERT_ID() into emp_count;
	set count_str = emp_count;
	while emp_count < 1000 do
		set emp_count = emp_count * 10;
		set count_str = concat('0', count_str);
	end while;
	set emp_code = concat(DATE_FORMAT(now(),'%Y%m%d'), count_str);
	insert into t_emp values (
		NULL, N_DEPT_ID, N_TITLE_ID, N_POST_ID, VC_EMP_NAME, emp_code, N_GENDER,
		VC_IDCARD_CODE, D_BIRTHDAY, VC_NATIVE_PLACE, N_EDU_LEVEL, N_NATION, N_PARTY,
		N_HEALTH, N_REG_TYPE, N_STATUS, emp_code
	);
end;


-- testing data
insert into t_dept values(null, 000001, "人力资源管理部门", 0, null, "四川省成都市高新区交子北一路88号", "611731", "85938888", "85938888", "hongda@qiye163.net", 0, null);
insert into t_title values(null, "助理工程师", "电子电工、计算机网络、建筑电气、机电等相关理工工程科专业；熟悉电脑和电脑操作，熟练CAD绘制的设计图纸，熟悉office办公软件；勤奋敬业、责任心强、善于沟通，具有团队合作精神；", "项目的工程实施，包括拟订实施方案、项目预搭建测试，现场布线，现场设备安装调试工作；项目实施后的对项目进行售后维护工作；", "受指导并完成指派的自动化相关工作。");
insert into t_post values(null, "人资部经理", null, "1、公司内部相关人事制度的起草、制定、执行。\n2、根据公司发展及部门需求制度相应的招聘政策及按照任职要求进行员工的招聘。\n3、根据公司要求及员工实际情况进行员工入职、调动、升职、离职及辞退手续的办理。", "1、对公司具备较高的忠诚度；\n2、具备一定的人力资源专业性相关知识及良好的亲和力及执行力。\n3、较好的语言表达能力及沟通能力；", "可对公司所有员工的信息进行查询修改。", "最大限度地开发与管理组织内外部的人力资源。");
insert into t_role values(null, "人资部管理员");
call P_INSERT_EMP(1, 1, 1, "李小明", 0, "510104199003074913", "1990-03-07", "四川省成都市", 4, 1, 1, 2, 0, 2);
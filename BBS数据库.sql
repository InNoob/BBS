use master
go
if exists(select 1 from sys.databases where name='bbsdb')
drop database bbsdb
go
create database bbsdb
go
use bbsdb
go
create table userinfo
(
	
	[uid] int not null identity(1000,1) primary key,
	
	[username] nvarchar(32) not null,
	[password] varchar(16) not null,
	--用户头像
	[headimg] nvarchar(256) not null,
	--用户等级
	[level] int not null,
	--积分
	[mark] bigint not null,
	--个性签名
	[whatup] nvarchar(256),
	--注册时间
	[jointime] datetime default(getdate()),
	--备注
	[tag] nvarchar(128)
)
go
create table block
(
	[bid] int not null identity(1,1) primary key,
	--管理编号 这个管理可以是普通管理 可以是版主 根据这个编号查verify来确定是版主还是管理 
	[uid] int not null references userinfo(uid),
	--板块名称
	[bname] nvarchar(256) not null,
	--身份 版主2 管理1 普通成员0
	[verify] int not null,
	--板块状态 关闭0 火爆1 征求版主2
	[stat] int not null,
	--创建时间
	[createtime] datetime default(getdate()),
	[tag] nvarchar(256)
)
create table topic
(
	[tid] int not null identity(1,1) primary key,
	[bid] int not null references block(bid),
	[uid] int not null references userinfo(uid),
	--标题
	[title] nvarchar(128) not null,
	--正文
	[content] ntext not null,
	
	--发帖时间
	[toptime] datetime default(getdate()),
	--点赞
	[great] int,
	--状态 用来标记是不是置顶贴或者精品贴
	[stat] int default(0),
	--附件
	[attachment] nvarchar(256),
	--标记
	[tag] nvarchar(128)
)
go
create table recive
(
	[rid] int not null identity(1,1) primary key,
	[bid] int not null references block(bid),
	[tid] int not null references topic(tid),
	[uid] int not null references userinfo(uid),
	--正文
	[content] ntext not null,
	--回帖时间
	[rectime] datetime default(getdate()),
	--点赞
	[great] int,
	--类型 
	[type] int not null,
	--附件 
	[attachment] nvarchar(256),
	--备注
	[tag] nvarchar(128)
)
go
create table evaluat
(
	[eid] int not null identity(1,1) primary key,
	[rid] int not null references recive(rid),
	[bid] int not null references block(bid),
	[tid] int not null references topic(tid),
	[uid] int not null references userinfo(uid),
	--正文
	[content] ntext not null,
	--评论时间
	[evatime] datetime default(getdate()),
	--点赞
	[great] int,
	--类型 用来看是回复主贴的还是回复副贴的
	[type] int not null,
	--附件
	[attachment] nvarchar(256),
	--备注
	[tag] nvarchar(128)

)
go

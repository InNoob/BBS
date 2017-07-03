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
	[headimg] nvarchar(256) not null,
	[level] int not null,
	[whatup] nvarchar(256),
	[jointime] datetime default(getdate()),
	[tag] nvarchar(128)
)
go
create table topic
(
	[tid] int not null identity(1,1) primary key,
	[uid] int not null references userinfo(uid),
	[title] nvarchar(64) not null,
	[toptime] datetime default(getdate()),
	[great] int,
	[stat] int default(0),
	[attachment] nvarchar(256),
	[tag] nvarchar(128)
)
go
create table recive
(
	[rid] int not null identity(1,1) primary key,
	[tid] int not null references topic(tid),
	[uid] int not null references userinfo(uid),
	[content] nvarchar(512) not null,
	[rectime] datetime default(getdate()),
	[great] int,
	[type] int not null,
	[attachment] nvarchar(256),
	[tag] nvarchar(128)
)
go
create table evaluat
(
	[eid] int not null identity(1,1) primary key,
	[rid] int not null references recive(rid),
	[tid] int not null references topic(tid),
	[uid] int not null references userinfo(uid),
	[content] nvarchar(512) not null,
	[evatime] datetime default(getdate()),
	[great] int,
	[type] int not null,
	[attachment] nvarchar(256),
	[tag] nvarchar(128)
)
go

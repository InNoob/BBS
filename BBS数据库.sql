use master
go
if exists(select 1 from sys.databases where name='bbsdb')
drop database bbsdb
go
create database bbsdb
go
use bbsdb
go

--用户信息表
create table userinfo
(
	
	--用户id
	[uid] int not null identity(1000,1) primary key,
	--用户名
	[username] nvarchar(32) not null,
	--密码
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

--版块表
create table block
(
	[bid] int not null identity(1,1) primary key,
	--板块名称
	[bname] nvarchar(256) not null,
	--板块状态 关闭0 正常1 火爆2 
	[stat] int not null,
	--创建时间
	[createtime] datetime default(getdate()),
	--备注
	[tag] nvarchar(256)
)

--版块管理员
create table blockmanager
(
	--管理员id
	[bmid] int not null identity(1,1) primary key,
	--版块id
	[bid] int not null references block(bid),
	--管理编号 这个管理可以是普通管理 可以是版主 根据这个编号查verify来确定是版主还是管理 
	--用户id
	[uid] int not null references userinfo(uid),
	--身份 版主1 管理0
	[verify] int not null,
	--管理状态 0停职 1正常
	[stat] int not null
)

--发帖表
create table topic
(
	--发帖id
	[tid] int not null identity(1,1) primary key,
	--版块id
	[bid] int not null references block(bid),
	--用户id
	[uid] int not null references userinfo(uid),
	--标题
	[title] nvarchar(128) not null,
	
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

--回帖表
create table recive
(
	--回帖id
	[rid] int not null identity(1,1) primary key,
	--版块id
	[bid] int not null references block(bid),
	--发帖表
	[tid] int not null references topic(tid),
	--用户id
	[uid] int not null references userinfo(uid),
	--正文
	[content] ntext not null,
	--回帖时间
	[rectime] datetime default(getdate()),
	--点赞
	[great] int,
	--附件 
	[attachment] nvarchar(256),
	--备注
	[tag] nvarchar(128)
)
go

--回复未读表 用户登陆时候根据uid检查此表有没有未读回帖
create table reciveUnread
(
	---回复未读idd
	[ruid] int not null identity(1,1) PRIMARY key,
	--用户id 这个是被回帖人的用户id
	[uid] int not null references userinfo(uid),
	--这个是发帖id
	[tid] int not null references topic(tid),
	--这个是回帖id
	[rid] int not null references recive(rid)
)

--评论表
create table evaluat
(
	--评论id
	[eid] int not null identity(1,1) primary key,
	--用户id
	[uid] int not null references userinfo(uid),
	--版块id block表id
	[bid] int not null references block(bid),
	--帖子id topic表id
	[tid] int not null references topic(tid),
	--回帖id recive表id
	[rid] int not null references recive(rid),
	--正文
	[content] ntext not null,
	--评论时间
	[evatime] datetime default(getdate()),
	--点赞
	[great] int,
	--附件
	[attachment] nvarchar(256),
	--备注
	[tag] nvarchar(128)

)
go

--评论未读表 用户登陆的时候要根据uid检查此表是否有未读评论
create table evaluatUnread
(
	---回复未读idd
	[ueid] int not null identity(1,1) PRIMARY key,
	--用户id 这个是被评论人的用户id
	[uid] int not null references userinfo(uid),
	--这个是回帖id
	[rid] int not null references topic(tid),
	--这个是评论id
	[eid] int not null references recive(rid)
)
go

--这是回复评论表 
create table revaluat
(
	--回复评论id
	[reid] int not null identity(1,1) primary key,
	--主动回复评论
	[meid] int not null references evaluat(eid),
	--被回复评论
	[beid] int not null references evaluat(eid),
	--被回复评论用户id
	[beuid] int not null references userinfo(uid)
)
go

--这是回复评论未读表 用户登陆的时候要根据uid查这个表里面有没有回复自己评论的记录
create table revaluatUnread
(
	--回复评论未读id
	[ureid] int not null identity(1,1) primary key,
	--被回复评论用户id
	[uid] int not null references userinfo(uid),
	--回复评论表
	[reid] int not null references revaluat(reid)
)
go


--私聊消息
create table message
(
	--消息id
	[mid] int not null identity(1,1) primary key,
	--发送者
	[sender] int not null references userinfo(uid),
	--接受者
	[reciver] int not null references userinfo(uid),
	--内容
	[content] ntext not null,
	--发送时间
	[sendtime] datetime default(getdate()),
	--备注
	[tag] nvarchar(256)
)

--未读消息表
create table messageUnread
(
	--未读消息id
	[umid] int not null identity(1,1) primary key,
	--用户id
	[uid] int not null references userinfo(uid),
	--消息id 
	[mid] int not null references message(mid)
)

--添加用户
insert into userinfo values('jason bourne','287276013','resource/image/headimg.png',1,100,N'我思故我在',default,null)
insert into userinfo values('well smith','123456','resource/image/headimg.png',2,551,N'我思故我在',default,null)
insert into userinfo values('winter worth','11111','resource/image/headimg.png',3,1107,N'我思故我在',default,null)
insert into userinfo values('micole jackson','0000000','resource/image/headimg.png',4,2571,N'我思故我在',default,null)
go
--添加版块 标题 状态码 时间 备注
insert into block values(N'技术交流',1,default,null)
insert into block values(N'日常生活',1,default,null)
go
--添加版块管理员 bid uid verify stat
insert into blockmanager values(1,1000,1,1)
insert into blockmanager values(1,1001,0,1)
insert into blockmanager values(2,1002,1,1)
go
--添加帖子               bid uid title toptime great stat attach tag
insert into topic values(1,1002,N'震惊！',default,5,0,null,null)
insert into topic values(1,1003,N'男默女泪',default,1,0,null,null)
go
--添加回复                bid tid uid content rectime great attach tag
insert into recive values(1,1,1000,N'狗主编',default,10086,null,null)
insert into recive values(1,1,1001,N'狗东西',default,10086,null,null)
insert into recive values(1,1,1000,N'狗主编',default,10086,null,null)
insert into recive values(1,1,1000,N'狗主编',default,10086,null,null)
go
--添加未读回复                   uid tid rid
insert into reciveUnread values(1002,1,1)
insert into reciveUnread values(1002,1,2)
go
insert into evaluat values(1001,1,1,1,N'骂得好',default,1000,null,null)
insert into evaluat values(1003,1,1,1,N'没错',default,1000,null,null)
go
insert into evaluatUnread values(1000,1,1)
go
insert into revaluat values(2,1,1001)
go
insert into revaluatUnread values(1001,1)
go

insert into message values(1003,1002,N'来UC震惊部上班吧',default,null)
go
insert into messageUnread values(1002,1)
go

-- select * from userinfo
-- select * from block
-- select * from blockmanager
-- select * from topic
-- select * from recive
-- select * from reciveUnread
-- select * from evaluat
-- select * from evaluatUnread
-- select * from revaluat
-- select * from revaluatUnread
-- select * from message
-- select * from messageUnread

--判断用户登陆
-- select 1 from userinfo where username = 'xxx' and password = 'xxx'
-- --用户登陆时检查自己的未读消息数量

-- select count(1) from reciveUnread where uid = 1
-- select count(1) from evaluatUnread where uid = 1
-- select count(1) from revaluatUread where uid = 1
-- select count(1) from messageUread where uid = 1
-- --当用户点击未读消息的时候查询未读的消息
print N'----------未查看的回帖--------------'
select su.username as N'发送者',re.username as N'接受者' 
,r.content as N'正文'
from recive as r 
inner join reciveUnread as ru on r.rid = ru.rid 
inner join userinfo as su on r.uid = su.uid
inner join userinfo as re on ru.uid = re.uid
where ru.uid = 1002

print N'----------未查看的评论------------'
select  
from evaluat as e
inner join evaluatUnread as e





-- select e. from evaluat as e inner join evaluatUread as eu on e.rid = eu.rid where eu.uid = 1
-- select re. from revaluat as re inner join revaluatUnread as reu on re.rid = reu.rid where reu.uid = 1
-- select m. from message as m inner join messageUread as mu on m.rid = mu.rid where mu.uid = 1


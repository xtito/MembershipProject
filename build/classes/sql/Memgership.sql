-- 用户类型表
create table user_type(
  -- 类型id 使用序列赋值
  id number(10) constraint usType_PK primary key,
  -- 类名名称
  name varchar2(50) constraint usType_name not null
);

-- 用户表
create table users(
  -- 用户id 使用序列赋值
  id number(10) constraint users_PK primary key,
  -- 用户名 长度6位含以上
  name varchar2(50) constraint users_name not null,
  -- 密码 长度6位含以上
  password varchar2(50) constraint users_pwd not null,
  -- 用户状态 1为正常，0为冻结
  status number(1) constraint users_status not null,
  -- 最后修改时间
  last_modify_time date constraint us_last_modify_time not null,
  -- 用户类型 对应用户类型表主键
  type_id number(10) constraint users_FK references user_type(id)
);

-- 为 user_type 表创建自动增长序列
create sequence user_type_x1
-- 递增的序列值，每次增加几
increment by 1
-- 开始的值，递增默认是minvalue
start with 1
-- minvalue设置最小值，nominvalue最小
minvalue 1
-- maxvalue设置最大值，nomaxvalue最大值不上限
nomaxvalue
-- 是否循环，cycle循环、nocycle不循环
nocycle
-- 缓存，可以缓存几个序号，cache缓存，nocache不缓存
nocache;

-- 为 user_type 表创建触发器
create or replace trigger "user_type_cf" before
-- 为 user_type 表添加 id 值
insert on user_type for each row when(new.id is null)
begin
-- 使用 user_type_x1 序列，为 id 赋值
select user_type_x1.nextval into:new.id from dual;
end;

-- 为 users 表创建自动增长序列
create sequence users_x1
-- 递增的序列值，每次增加几
increment by 1
-- 开始的值，递增默认是minvalue
start with 1
-- minvalue设置最小值，nominvalue最小
minvalue 1
-- maxvalue设置最大值，nomaxvalue最大值不上限
nomaxvalue
-- 是否循环，cycle循环、nocycle不循环
nocycle
-- 缓存，可以缓存几个序号，cache缓存，nocache不缓存
nocache;

-- 为 users 表创建触发器
create or replace trigger "users_cf" before
-- 为 user_type 表添加 id 值
insert on users for each row when(new.id is null)
begin
-- 使用 user_type_x1 序列，为 id 赋值
select users_x1.nextval into:new.id from dual;
end;









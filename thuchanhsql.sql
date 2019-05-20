use newservlet12month2018;

create table role(
	id bigint not null primary key auto_increment,
    name VARCHAR(150) NOT NULL,
    code varchar(150) not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(150) null,
    modifiedby varchar(150) null
);
create table user(
	id bigint not null primary key auto_increment,
    username VARCHAR(150) NOT NULL,
    password VARCHAR(150) NOT NULL,
    fullname VARCHAR(150) NOT NULL,
    roleid bigint not  null,
    status VARCHAR(150) not null,
    createddate timestamp null,
    modifieddate timestamp null,    
    createdby varchar(150) null,
    modifiedby varchar(150) null
);

alter table user add constraint fk_user_role foreign key (roleid) references role(id);
    
create table news(
	id bigint not null primary key auto_increment,
    title varchar(255) null,
    thumbnail varchar(255) null,
    categoryid bigint not null,
    shortdecriptions text null,
    content text null,
    createddate timestamp null,
    modifieddate timestamp null,    
    createdby varchar(150) null,
    modifiedby varchar(150) null
);

create table category(
	id bigint not null primary key auto_increment,
    name varchar(255) not null,
    code varchar(255) not null,
    createddate timestamp null,
    modifieddate timestamp null,    
    createdby varchar(150) null,
    modifiedby varchar(150) null
);

alter table news add constraint fk_news_category foreign key (categoryid) references category(id);
create table comment(
	id bigint not null primary key auto_increment,
    user_id bigint not null,
    news_id bigint not null,
    content text null,
    createddate timestamp null,
    modifieddate timestamp null,    
    createdby varchar(150) null,
    modifiedby varchar(150) null
);
alter table comment add constraint fk_comment_user foreign key (user_id) references user(id);
 alter table comment add constraint fk_comment_news foreign key (news_id) references news(id);   
    
insert into category(code, name) values('the-thao', 'Thể thao');
insert into category(code, name) values('the-gioi', 'Thế giới');
insert into category(code, name) values('chinh-tri', 'Chính trị');
insert into category(code, name) values('thoi-su', 'Thời sự');
insert into category(code, name) values('goc-nhin', 'Góc nhìn');


insert into news(title, categoryid) values('Bài viết 1', 1);
insert into news(title, categoryid) values('Bài viết 2', 2);
insert into news(title, categoryid) values('Bài viết 3', 3);

insert into role(code, name) values('ADMIN','Quản trị');
insert into role(code, name) values('USER','Người dùng');

INSERT INTO user(`username`, `password`, `fullname`, `roleid`, `status`) VALUES ('admin', '123456', 'admin', '1', '1');
INSERT INTO user(`username`, `password`, `fullname`, `roleid`, `status`) VALUES ('user1', '123456', 'Ong A', '2', '1');
INSERT INTO user(`username`, `password`, `fullname`, `roleid`, `status`) VALUES ('user2', '123456', 'Ba B', '2', '1');


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
);


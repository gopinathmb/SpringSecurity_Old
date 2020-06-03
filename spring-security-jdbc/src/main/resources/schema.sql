
-- These are default tables recomended by Spring https://docs.spring.io/spring-security/site/docs/current/reference/html5/#user-schema.
--If you have tables in schema format then u needn't to code anything but if u have ur own tables then u need to tell spring how to deal 
--with it.
create table users(
    username varchar_ignorecase(50) not null primary key,
    password varchar_ignorecase(50) not null,
    enabled boolean not null
);

create table authorities (
    username varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);
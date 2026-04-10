-- Schema design
-- (ER diagram and normalization)

-- create database instaSIT;
-- use instaSIT;

-- create table users(
-- user_id int auto_increment primary key,
-- username varchar(50) unique not null,
-- email varchar(100) unique not null,
-- password varchar(100),
-- bio text,
-- created_at timestamp default current_timestamp
-- );

-- create table post(
-- post_id int auto_increment primary key,
-- user_id int,
-- caption text,
-- media_url varchar(225),
-- created_at timestamp default current_timestamp,
-- foreign key(user_id) references users(user_id)
-- );

-- create table likes(
-- like_id int auto_increment primary key,
-- user_id int,
-- post_id int, 
-- created_at timestamp default current_timestamp,
-- unique(user_id, post_id),
-- foreign key(user_id) references users(user_id),
-- foreign key(post_id) references post(post_id)
-- );


-- create table comments(
-- comment_id int auto_increment primary key,
-- user_id int,
-- post_id int,
-- text text,
-- created_at timestamp default current_timestamp,
-- foreign key(user_id) references users(user_id),
-- foreign key(post_id) references post(post_id)
-- );

-- create table follows (
-- follower_id int,
-- following_id int,
-- created_at timestamp default current_timestamp,
-- primary key(follower_id, following_id),
-- foreign key(follower_id) references users(user_id),
-- foreign key(following_id) references users(user_id)

-- );

-- insert into users(username,email,password,bio) values
-- ('onkar','onkarholkar@gmail.com','12345','AI Dev'),
-- ('Brad','Brad@gmail.com','23455','AI Dev'),
-- ('Max','Max@gmail.com','45345','AI Dev'),
-- ('Tom','Tom@gmail.com','96345','AI Dev'),
-- ('Daniel','Daniel@gmail.com','99345','AI Dev');

-- insert into post(user_id, caption, media_url) values
-- (1, 'my first post', 'img1.jpg'),
-- (2, 'my home', 'img2.jpg'),
-- (3, 'my office', 'img3.jpg'),
-- (4, 'trek post', 'img4.jpg');

-- insert into follows(follower_id, following_id) values
-- (1,2),
-- (1,3),
-- (2,3),
-- (4,5),
-- (5,4);

-- insert into likes(user_id, post_id) values
-- (1,2),
-- (1,3),
-- (2,1),
-- (5,4);

-- insert into comments(user_id, post_id, text) values
-- (1,2,'nice post'),
-- (2,1,'great'),
-- (3,2,'good look'),
-- (5,4,'fire');


-- Real time operations
-- Q1) list of people Onkar follows
-- select p.post_id, u.username, p.caption, p.media_url, p.created_at from post p join users u on p.user_id=u.user_id
-- 	join follows f on f.following_id=u.user_id
--     where f.follower_id = 1
--     order by p.created_at desc;

-- Q2) Like count per post
-- select p.post_id, count(l.like_id) as total_likes
-- from post p
-- left join likes l on p.post_id=l.post_id
-- group by p.post_id;

-- Q3) comment count per post

-- select post_id, count(*) as total_comments
-- from comments group by post_id;

-- Q4) who follows whom
-- select u1.username as follower, u2.username as following
-- from follows f
-- join users u1 on f.follower_id=u1.user_id
-- join users u2 on f.following_id=u2.user_id

-- Q5) add new post
-- insert into post(user_id,caption, media_url)
-- values (3, 'my first bike riding', 'image002.jpg');
-- select * from post;

-- Q6) like a post
-- insert into likes(user_id, post_id)
-- values(2,5);

-- Q7) delete a follow(unfollow)
-- delete from follows 
-- where follower_id = 1 and following_id=2;

-- Q8) get all comments on a post
select u.username, c.text
from comments c
join users u 
on c.user_id = u.user_id
where c.user_id = 2

-- create table department with dept_id, dept_name; [(201,202,203,204,205), (hr, finance, operations, sales, it)]
-- create table project with proj_id, proj_name, dept_id(from department table); 
-- [(301 to 310), (hiring, event(part of hr, 201, 201), audit(part of finance, 202), urban areas, semi urban (part of operations, 203, 203), social media (part of sales, 204), fe, be, ds(part of it, 205, 205, 205)]
-- create employee emp_id, emp_name, mgr_id, dept_id(from department table);
-- [(401-420), (AAA, BBB, CCC... till TTT), (501, 502, 504, 501, 503, 504, 505, 501, 502, 501, 506, 506, 501, 503, 504, 505, 501, 506, 502, 505), (201, 201, 201, 202, 202, 202, 202, 203, 203, 203, 203, 203, 203, 204, 204, 204, 204, 205, 205, 205, 205)]






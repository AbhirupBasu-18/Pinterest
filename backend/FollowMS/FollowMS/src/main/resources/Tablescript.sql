DROP SCHEMA IF EXISTS follow_db;
CREATE SCHEMA follow_db;
USE follow_db;
create table follow(
    id INT AUTO_INCREMENT primary key,
    follower_id INT not null,
    followed_id INT not null
);

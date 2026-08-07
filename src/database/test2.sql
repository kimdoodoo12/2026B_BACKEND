show DATABASES;
use mydb0805;
CREATE table PostTable(
    listID int unsigned auto_increment, constraint primary key(listID),
    memberID int unsigned, constraint Foreign Key (memberID) REFERENCES memberTable(memberID),
    listTitle varchar(30),
    listContent text not null,
    listDay datetime default now(),
    thumbsUp int unsigned, thumbsDown int unsigned
);
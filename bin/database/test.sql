use mydb0814;

cReAtE tAbLe OrDeRs(
   no int,
   constraint primary key(no) AUTO_INCREMENT,
   mno int,
   constraint foregin key(mno) references inventory(no),
   amount int,
   pname varchar(30)
);

iNsErT iNtO OrDeRs(mno, amount, pname ) Values
(1, 4, "자르반97세의마지막한타"),
(1, 3, "카타리나"),
(3, 1, "요네"),
(2, 4, "야스오");
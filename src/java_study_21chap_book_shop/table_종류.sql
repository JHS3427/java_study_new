use hrdb2019;
select database();

/******************************************************************
	book_market_books = 서점의 도서 테이블
    book_market_cart = 장바구니 테이블
    book_market_member = 회원 테이블
	book_market_receipt = 영수증 테이블 - 번호 누가 무엇을 얼마에 언제 어디로(주소) 샀는지
******************************************************************/
create table book_market_books(
	BookId varchar(20),
    Title varchar(100),
    Author varchar(50),
    Price int,
    BigSort varchar(50),
    InputDate datetime
);
select * from book_market_books;
insert into book_market_books
values ("ABCD1114","주식실습2권","김수한무",4000 , "경제", now());
desc book_market_member;

create table book_market_member(
	UserId varchar(20),
    UserPw varchar(30),
    UserName varchar(50),
    UserAddress varchar(200),
    Phone varchar(30)
);
alter table book_market_member
add constraint primary key(UserID);
desc book_market_member;
create table book_market_cart(
	UserId varchar(20),
	BookId varchar(20),
    Amount int,
    AmountPriceSum int
);
select * from book_market_member;
Insert into book_market_member
values("rrr","sss","가나다","한국","010-1111-1111");

desc book_market_books;
desc book_market_member;
desc book_market_cart;

alter table book_market_cart
add constraint foreign key(UserId) references book_market_member(UserId);

alter table book_market_books
add constraint primary key(BookId);

alter table book_market_cart
add constraint foreign key(BookId) references book_market_books(BookId);

select UserId, UserPw, UserName, Phone
from book_market_member where UserId = "rrr";
set SQL_SAFE_UPDATES = 0;

update book_market_cart set amount = 10 where userId = 'rrr' and bookId = 'ABCD1234';
update book_market_cart set amount = 3, AmountPriceSum = amount*1000
where userId = 'rrr' and bookId = 'ABCD1234';

select * from book_market_cart;
delete from book_market_cart where userId = "rrr";
-- book_market_receipt = 영수증 테이블 - 번호 누가 무엇을 얼마나 얼마에 언제 어디로(주소) 샀는지

create table book_market_receipt
(
	BuyingIdx int auto_increment primary key,
    UserId varchar(20),
    BookId varchar(20),
    Amount int,
    AmountPriceSum int,
    BuyingDate datetime,
    UserAddress varchar(200)
);

desc book_market_receipt;

select * from book_market_member;
select sum(AmountPriceSum) from book_market_cart where userid = "rrr";
select * from book_market_cart ;


select bmm.Username, bmm.Phone, bmm.UserAddress
, bmc.BookId, bmc.Amount, bmc.AmountPriceSum
from book_market_member bmm
inner join book_market_cart bmc
on bmm.UserId = bmc.userID;

create database Ministore
go
use Ministore
go
create table Users(
	userID int identity(1,1),
	userName varchar(255),
	password varchar(255),
	fullName nvarchar(255),
	avatar varchar(MAX),
	address nvarchar(MAX),
	phone varchar(20),
	email varchar(255),
	status int,
	note nvarchar(MAX),
	primary key (userID)
)
go
create table Roles(
	roleID int identity(1,1),
	roleName varchar(100),
	status int,
	description varchar(MAX),
	primary key (roleID)
)
go 
create table Report(
	reportID int identity(1,1),
    reportTitle nvarchar(MAX),
	createDate DATE,
	description nvarchar(MAX),
	status int,
	note nvarchar(MAX),
	primary key (reportID)
)
go

create table ShiftTime(
	 shiftID int identity(1,1),
	 timeStart datetime,
	 timeEnd datetime,
	 coeShift float,
	 coeOT float,
	 wage float,
	 status int,
	 note nvarchar(MAX),
	 primary key (shiftID)
)
go
create table UserShift(
	userID int, 
	shiftID int,
	date date,
	status int,
	note nvarchar(MAX),
	isOT bit,
	primary key(userID, shiftID, date)
)
go
create table Attendance(
	attendID int identity(1,1),
	date date,
	checkIn datetime,
	checkOut datetime,
	lateTime int,
	overTime int,
	status int,
	note nvarchar(MAX),
	primary key(attendID)
) 
go
create table DayOff(
	dayOffID int identity(1,1),
	date date,
	coefficient float,
	description nvarchar(MAX),
	status int,
	note nvarchar(MAX),
	primary key (dayOffID)
)
go
create table CheckIn(
	checkInID int identity(1,1), 
	checkInTime datetime,
	primary key(checkInID)
)
go
create table CheckOut(
	checkOutID int identity(1,1), 
	checkOutTime datetime,
	primary key(checkOutID)
)
go
create table Bonus(
	bonusID int identity(1,1),
	bonus float,
	description nvarchar(MAX),
	status int,
	note nvarchar(MAX),
	primary key(bonusID)
)
go 
create table Minus(
	minusID int identity(1,1),
	lateTime int,
	reduction float,
	fine float,
	description nvarchar(MAX),
	status int,
	note nvarchar(MAX),
	primary key(minusID)
)
go
create table PaySlip(
	paySlipID int identity(1,1),
	salary float,
	bonus float,
	minus float,
	status int,
	note nvarchar(MAX),
	primary key(paySlipID)
)
go 

/*PHẦN TẠO FOREIGN KEY CHO BẢNG*/
/*Tạo foreign key cho bảng Users => các fk mới tạo sẽ ở cuối bảng*/
alter table Users
add roleID int foreign key references Roles(roleID)

/*Tạo foreign key cho bảng Report*/
alter table Report 
add userID int foreign key references Users(userID)

/*Tạo foreign key cho bảng UserShift*/
alter table UserShift
add foreign key (userID) references Users(userID)

alter table UserShift
add foreign key (shiftID) references ShiftTime(shiftID)

/*Tạo foreign key cho bảng Attendance*/
alter table Attendance
add userID int foreign key references Users(userID)

/*Tạo foreign key cho bảng CheckIn*/
alter table CheckIn
add userID int foreign key references Users(userID)

/*Tạo foreign key cho bảng CheckOut*/
alter table CheckOut
add userID int foreign key references Users(userID)

/*Tạo foreign key cho bảng Bonus*/
alter table Bonus
add userID int foreign key references Users(userID)

/*Tạo foreign key cho bảng Minus*/
alter table Minus
add userID int foreign key references Users(userID)

/*Tạo foreign key cho bảng PaySlip*/
alter table PaySlip
add userID int foreign key references Users(userID)
/*
alter table PaySlip
add bonusID int foreign key references Bonus(bonusID)

alter table PaySlip
add minusID int foreign key references Minus(minusID)
*/

/*PHẦN INSERT DỮ LIỆU CHO BẢNG*/

/*Insert cho Roles*/
insert into Roles values('Manager',1,'')
insert into Roles values('Sale',1,'')
insert into Roles values('Guard',1,'')

/*Insert cho Users*/
insert into Users values('A','6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B','Nguyen Thi A', 'https://toigingiuvedep.vn/wp-content/uploads/2021/01/anh-avatar-cho-con-gai-cuc-dep.jpg','Thanh pho Ho Chi Minh', '0945076586', 'A@gmail.com', 1,'', 1)
insert into Users values('B','D4735E3A265E16EEE03F59718B9B5D03019C07D8B6C51F90DA3A666EEC13AB35','Nguyen Van B', 'https://demoda.vn/wp-content/uploads/2022/04/avatar-dep-anime.jpg','Can Tho', '0945076587', 'B@gmail.com', 1, '', 2)
insert into Users values('C','4E07408562BEDB8B60CE05C1DECFE3AD16B72230967DE01F640B7E4729B49FCE','Nguyen Van C', 'https://cdn.vox-cdn.com/thumbor/WR9hE8wvdM4hfHysXitls9_bCZI=/0x0:1192x795/1400x1400/filters:focal(596x398:597x399)/cdn.vox-cdn.com/uploads/chorus_asset/file/22312759/rickroll_4k.jpg','Vung Tau', '0945076589', 'C@gmail.com', 1, '', 3)
insert into Users values('D','4B227777D4DD1FC61C6F884F48641D02B4D121D3FD328CB08B5531FCACDABF8A','Nguyen Thi D', 'https://cdn.shopify.com/s/files/1/0150/0643/3380/products/SB-Standees-Spong-1_800x.jpg?v=1603744567','Vinh Long', '0945076590', 'D@gmail.com', 1, '', 2)


/*Insert cho Report*/
insert into Report values('Report1','2022-10-10','',1,'',1)
insert into Report values('Report2','2023-05-11','',1,'',2)

/*Insert cho ShiftTime*/
insert into ShiftTime values('06:00:00', '12:00:00', 1, 0.5, 20, 0, '')
insert into ShiftTime values('12:00:00', '18:00:00', 1, 0.5, 20, 0, '')
insert into ShiftTime values('18:00:00', '06:00:00', 1.5, 0.5, 20, 0, '')

/*Insert cho UserShift*/
insert into UserShift values ('2','1','2023-05-11', 0, '',0)
insert into UserShift values ('2','1','2023-10-10', 0, '', 0)

--Insert cho Attendance
insert into Attendance values ('2023-06-01', '2023-06-01 06:00:00', '2023-06-01 18:00:00', 0, 0, 0 ,'', 3);
insert into Attendance values ('2023-06-02', '2023-06-02 06:00:00', '2023-06-02 12:30:00', 0, 30, 0 ,'', 2);
insert into Attendance values ('2023-06-02', '2023-06-02 07:00:00', '2023-06-02 18:00:00', 60, 0, 0 ,'', 3);
insert into Attendance values ('2023-06-01', '2023-06-01 06:00:00', '2023-06-01 12:00:00', 0, 0, 0 ,'', 2);

select * from Users
select * from Roles
select * from Report
select * from ShiftTime
select * from UserShift
select * from Attendance

update Users set status = 0 where userID = 2
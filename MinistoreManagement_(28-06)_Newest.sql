drop database Ministore
go

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
create table ReportType(
	typeID int identity(1,1),
	typeName varchar(50),
	primary key(typeID)
)
create table Report(
	reportID int identity(1,1),
    reportTitle nvarchar(MAX),
	createDate date,
	description nvarchar(MAX),
	plannedDate date,
	requestSoonTime datetime,
	requestLateTime datetime,
	status int,
	note nvarchar(MAX),
	primary key (reportID)
)
go

create table ShiftTime(
	 shiftID int identity(1,1),
	 shiftName nvarchar(50) not null,
	 timeStart datetime,
	 timeEnd datetime,
	 coeShift float,
	 coeOT float,
	 coeDayOff float,
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
	soonTime datetime,
	lateTime datetime,
	duration datetime,
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
	createDate datetime,
	salary float,
	bonus float,
	minus float,
	status int,
	note nvarchar(MAX),
	primary key(paySlipID)
)
go 

create table Record (
	recordID int identity(1,1),
	date datetime,
	userID int,
    shiftID int,
	checkIn datetime,
	checkOut datetime,
	primary key(recordID)
)

/*PHẦN TẠO FOREIGN KEY CHO BẢNG*/
/*Tạo foreign key cho bảng Users => các fk mới tạo sẽ ở cuối bảng*/
alter table Users
add roleID int foreign key references Roles(roleID)

/*Tạo foreign key cho bảng UserShift*/
alter table UserShift
add foreign key(userID) references Users(userID)

alter table UserShift
add foreign key(shiftID) references ShiftTime(shiftID)


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

/*Tạo foreign key cho bảng Report*/
alter table Report 
add userID int foreign key references Users(userID)
alter table Report
add shiftID int foreign key references ShiftTime(shiftID)
alter table Report 
add typeID int foreign key references ReportType(typeID)



/*PHẦN INSERT DỮ LIỆU CHO BẢNG*/

/*Insert cho Roles*/
insert into Roles values('ADMIN',0,'')
insert into Roles values('MANAGER',0,'')
insert into Roles values('SALE',0,'')
insert into Roles values('GUARD',0,'')

/*Insert cho Users*/
insert into Users values('A','6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B','Nguyen Thi A', 'https://toigingiuvedep.vn/wp-content/uploads/2021/01/anh-avatar-cho-con-gai-cuc-dep.jpg','Thanh pho Ho Chi Minh', '0945076586', 'A@gmail.com', 1,'', 1)
insert into Users values('B','D4735E3A265E16EEE03F59718B9B5D03019C07D8B6C51F90DA3A666EEC13AB35','Nguyen Van B', 'https://demoda.vn/wp-content/uploads/2022/04/avatar-dep-anime.jpg','Can Tho', '0945076587', 'B@gmail.com', 1, '', 2)
insert into Users values('C','4E07408562BEDB8B60CE05C1DECFE3AD16B72230967DE01F640B7E4729B49FCE','Nguyen Van C', 'https://cdn.vox-cdn.com/thumbor/WR9hE8wvdM4hfHysXitls9_bCZI=/0x0:1192x795/1400x1400/filters:focal(596x398:597x399)/cdn.vox-cdn.com/uploads/chorus_asset/file/22312759/rickroll_4k.jpg','Vung Tau', '0945076589', 'C@gmail.com', 1, '', 3)
insert into Users values('D','4B227777D4DD1FC61C6F884F48641D02B4D121D3FD328CB08B5531FCACDABF8A','Nguyen Thi D', 'https://cdn.shopify.com/s/files/1/0150/0643/3380/products/SB-Standees-Spong-1_800x.jpg?v=1603744567','Vinh Long', '0945076590', 'D@gmail.com', 1, '', 2)

/*Insert cho ReportType*/
insert into ReportType values('Application')
insert into ReportType values('Report')

/*Insert cho ShiftTime*/
insert into ShiftTime values('Day Shift','06:00:00', '12:00:00', 1, 0.5, 20, 2, 0, '')
insert into ShiftTime values('Day Shift','12:00:00', '18:00:00', 1, 0.5, 20, 2, 0, '')
insert into ShiftTime values('Night Shift','18:00:00', '06:00:00', 1.5, 0.5, 20, 2, 0, '')

/*Insert cho Report*/
insert into Report values('Report1','2023-06-12','I want to change shift..','2023-06-21','00:30:00','00:00:00',1,'',3,1,1)
insert into Report values('Report2','2023-05-11','I want to report something..',null,null,null,1,'',4,null,2)

/*Insert cho UserShift*/
insert into UserShift values ('2','1','2023-05-11', 0, '',0)
insert into UserShift values ('2','1','2023-10-10', 0, '', 0)

--Insert cho DayOff
insert into DayOff values('2023-04-30',1,'National Independent Day',1,'')
insert into DayOff values('2023-05-01',1,'International Labor Day',1,'')

--Insert cho Attendance
insert into Attendance values ('2023-06-01', '06:00:00', '11:30:00', '00:30:00', '00:00:00','05:30:00', 1, '', 2);
insert into Attendance values ('2023-06-02', '06:00:00', '12:00:00', '00:00:00', '00:00:00', '06:00:00', 1, '', 3);
insert into Attendance values ('2023-06-02', '13:00:00', '18:00:00', '00:00:00', '01:00:00', '05:00:00', 1, '', 3);

/*Insert cho Bonus*/
insert into Bonus values(22, '', 0, '', 1)
insert into Bonus values(20, '', 1, '', 2)

/*Insert cho Minus*/
insert into Minus values (5, 10, 0, '', 0, '', 1 )
insert into Minus values (5, 10, 100, '', 0, '', 2)

/*Insert cho PaySlip*/
insert into PaySlip values('2023-07-01', 10000, 22, 50, 0, '', 3 )
insert into PaySlip values('2023-07-01', 5000, 20, 150, 1, '', 4 )

/*Insert cho CheckIn*/
insert into CheckIn values('2023-05-11 06:00:00', 1)
 insert into CheckIn values('2023-10-10 06:02:00', 2)
 insert into CheckIn values('2023-03-27 12:30:00', 1)
 
 /*Insert cho CheckOut*/
 insert into CheckOut values('12:00:00', 2)
 insert into CheckOut values('12:30:00', 1)

select * from Users
select * from Roles
select * from Report
select * from ReportType
select * from ShiftTime
select * from UserShift
select * from Attendance
select * from Bonus
select * from Minus
select * from PaySlip
select * from CheckIn
select * from CheckOut 
select * from Record

--drop table UserShift
--drop table Record
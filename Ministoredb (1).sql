drop database Ministore
go

create database Ministore
go
use Ministore
go
create table Users(
	userID int identity(1,1),
	userName varchar(255) not null unique,
	password varchar(255) not null,
	fullName nvarchar(255) not null,
	avatar varchar(MAX),
	address nvarchar(MAX) not null,
	phone varchar(20) not null,
	email varchar(255) not null unique,
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
	inTime datetime,
	outTime datetime,
	primary key(recordID)
)

/*PHẦN TẠO FOREIGN KEY CHO BẢNG*/
/*Tạo foreign key cho bảng Users => các fk mới tạo sẽ ở cuối bảng*/
alter table Users
add roleID int foreign key references Roles(roleID)

/*Tạo foreign key cho bảng Report*/
alter table Report 
add userID int foreign key references Users(userID)

alter table Report 
add shiftID int foreign key references ShiftTime(shiftID)

/*Tao foreign key cho Report*/
alter table Report 
add typeID int foreign key references ReportType(typeID)

/*Tạo foreign key cho bảng UserShift*/
alter table UserShift
add foreign key(userID) references Users(userID)

alter table UserShift
add foreign key(shiftID) references ShiftTime(shiftID)


/*Tạo foreign key cho bảng Attendance*/
alter table Attendance
add userID int foreign key references Users(userID)

alter table Attendance
add shiftID int foreign key references ShiftTime(shiftID)

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
insert into Roles values('ADMIN',0,'')
insert into Roles values('MANAGER',0,'')
insert into Roles values('SALE',0,'')
insert into Roles values('GUARD',0,'')

/*Insert cho Users*/
insert into Users values('A','6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B',N'Nguyễn Thị Thúy An', 'https://toigingiuvedep.vn/wp-content/uploads/2021/01/anh-avatar-cho-con-gai-cuc-dep.jpg',N'TP.HCM', '0945076586', 'A@gmail.com', 1,'', 1)
insert into Users values('B','D4735E3A265E16EEE03F59718B9B5D03019C07D8B6C51F90DA3A666EEC13AB35',N'Nguyễn Văn Bình', 'https://demoda.vn/wp-content/uploads/2022/04/avatar-dep-anime.jpg',N'Cần Thơ', '0945076587', 'B@gmail.com', 1, '', 2)
insert into Users values('C','4E07408562BEDB8B60CE05C1DECFE3AD16B72230967DE01F640B7E4729B49FCE',N'Tống Văn Can', 'https://cdn.vox-cdn.com/thumbor/WR9hE8wvdM4hfHysXitls9_bCZI=/0x0:1192x795/1400x1400/filters:focal(596x398:597x399)/cdn.vox-cdn.com/uploads/chorus_asset/file/22312759/rickroll_4k.jpg',N'Vũng Tàu', '0945076589', 'C@gmail.com', 1, '', 4)
insert into Users values('D','4B227777D4DD1FC61C6F884F48641D02B4D121D3FD328CB08B5531FCACDABF8A',N'Trương Thanh Tùng Dương', 'https://cdn.shopify.com/s/files/1/0150/0643/3380/products/SB-Standees-Spong-1_800x.jpg?v=1603744567',N'Vĩnh Long', '0945076590', 'D@gmail.com', 1, '', 3)
insert into Users values('E','EF2D127DE37B942BAAD06145E54B0C619A1F22327B2EBBCFBEC78F5564AFE39D',N'Trần Thị Em', 'https://www.comingsoon.net/wp-content/uploads/sites/3/2023/04/sandy-cheeks-movie-header.png',N'Sóc Trăng', '0945076591', 'E@gmail.com', 1, '', 3)
insert into Users values('F','E7F6C011776E8DB7CD330B54174FD76F7D0216B612387A5FFCFB81E6F0919683',N'Lê Văn Phúc', 'https://cdn.shopify.com/s/files/1/0150/0643/3380/products/SB-Standees-Pat-1_800x.jpg?v=1603744570',N'Bến Tre', '0945076592', 'F@gmail.com', 1, '', 4)
insert into Users values('G','7902699BE42C8A8E46FBBB4501726517E86B22C56A189F7625A6DA49081B2451',N'Đỗ Trường Giang', 'https://yt3.googleusercontent.com/YaJHh5SnF1sCzOnWvyXv2oF9aNZCHBBa6yBiqq_2OBF6zF2xM0_n60Y2nBe5tRQU_2qmXpr2=s900-c-k-c0x00ffffff-no-rj',N'Nha Trang', '0945076593', 'G@gmail.com', 1, '', 3)
insert into Users values('H','2C624232CDD221771294DFBB310ACA000A0DF6AC8B66B696D90EF06FDEFB64A3',N'Trương Kim Huệ', 'https://i.pinimg.com/originals/a4/bc/4c/a4bc4c9714b357388fb061520c40b6d4.jpg',N'Mỹ Tho', '0945076594', 'H@gmail.com', 1, '', 3)



/*Insert cho ReportType*/
insert into ReportType values('Application')
insert into ReportType values('Report')

/*Insert cho ShiftTime*/
insert into ShiftTime values('Day Shift','06:00:00', '12:00:00', 1, 0.5, 2, 20, 0, '')
insert into ShiftTime values('Day Shift','12:00:00', '18:00:00', 1, 0.5, 2, 20, 0, '')
insert into ShiftTime values('Night Shift','18:00:00', '06:00:00', 1.5, 0.5, 2, 20, 0, '')

/*Insert cho Report*/
--[reportTitle, createDate, description, plannedDate, requestSoonTime, requestLateTime, status, note, userID, shiftID, typeID]
insert into Report values(N'Đơn xin đi trễ','2023-06-28',N'Do có chuyện đột xuất nên em xin phép đi trễ 15p vào ca 2 ngày mai 29/6 ạ','2023-06-29','00:00:00','00:15:00',0,N'Ok em.',6,2,1)
insert into Report values(N'Báo cáo có hàng bị hỏng hóc','2023-06-29',N'Sáng nay trong lúc kiểm tra hàng trên kệ số 3, em thấy có vẻ như có vài gói hàng có dấu hiệu bị xì hơi ạ.',null,null,null,0,N'Ok, anh sẽ cử người xuống kiểm tra và thay thế.',3,null,2)
insert into Report values(N'Đơn xin chuyển ca','2023-06-15',N'Do em phải đi khám tổng quát định kì vào buổi sáng ngày 16/6 nên em xin phép được dời xuống ca 2 làm ạ.','2023-06-16',null,null,0,N'Ok bạn nha, mình sẽ sắp xép lại lịch của bạn.',4,2,1)
insert into Report values(N'Đơn xin chuyển ca','2023-06-20',N'Do em phải đi thi bằng lái xe vào buổi chiều ngày 22/6 nên em xin phép được dời lên ca 1 làm ạ.','2023-06-22',null,null,2,N'Sorry em nha, hiện tại lịch buổi sáng ngày 22/6 hết chỗ trống r đó, có gì em đăng kí vào ngày khác nha, anh sẽ remove ca cho em',5,1,1)
insert into Report values(N'Đăng kí ca làm','2023-06-18',N'Cho mình xin 1 slot vào ca sáng ngày 20/6 nhe ạ','2023-06-20',null,null,0,N'Ok bạn nha, mình đã sắp lịch cho bạn r đó.',7,1,1)
insert into Report values(N'Đăng kí ca làm ngày 1/8','2023-07-31',N'Cho em xin làm slot 2 ngày 2/8 nhe ạ','2023-08-02',null,null,1,N'',8,1,1)
/*Insert cho UserShift*/
--/*1-6*/
--insert into UserShift values ('4','1','2023-06-01', 0, '',0)
--insert into UserShift values ('5','1','2023-06-01', 0, '',0)
--insert into UserShift values ('6','1','2023-06-01', 0, '',0)
--insert into UserShift values ('8','2','2023-06-01', 0, '',0)
--insert into UserShift values ('6','2','2023-06-01', 0, '',0)
--insert into UserShift values ('7','3','2023-06-01', 0, '',0)
--insert into UserShift values ('3','3','2023-06-01', 0, '',0)
--/*3-6*/
--insert into UserShift values ('4','1','2023-06-03', 0, '',0)
--insert into UserShift values ('5','1','2023-06-03', 0, '',0)
--insert into UserShift values ('6','1','2023-06-03', 0, '',0)
--insert into UserShift values ('7','2','2023-06-03', 0, '',0)
--insert into UserShift values ('6','2','2023-06-03', 0, '',0)
--insert into UserShift values ('8','3','2023-06-03', 0, '',0)
--insert into UserShift values ('3','3','2023-06-03', 0, '',0)
--/*4-6*/
--insert into UserShift values ('8','1','2023-06-04', 0, '',0)
--insert into UserShift values ('6','1','2023-06-04', 0, '',0)
--insert into UserShift values ('4','2','2023-06-04', 0, '',0)
--insert into UserShift values ('7','2','2023-06-04', 0, '',0)
--insert into UserShift values ('6','2','2023-06-04', 0, '',0)
--insert into UserShift values ('5','3','2023-06-04', 0, '',0)
--insert into UserShift values ('3','3','2023-06-04', 0, '',0)
--/*6-6*/
--insert into UserShift values ('4','1','2023-06-06', 0, '',0)
--insert into UserShift values ('5','1','2023-06-06', 0, '',0)
--insert into UserShift values ('6','1','2023-06-06', 0, '',0)
--insert into UserShift values ('8','2','2023-06-06', 0, '',0)
--insert into UserShift values ('6','2','2023-06-06', 0, '',0)
--insert into UserShift values ('7','3','2023-06-06', 0, '',0)
--insert into UserShift values ('3','3','2023-06-06', 0, '',0)
--/*8-6*/
--insert into UserShift values ('4','1','2023-06-08', 0, '',0)
--insert into UserShift values ('5','1','2023-06-08', 0, '',0)
--insert into UserShift values ('6','1','2023-06-08', 0, '',0)
--insert into UserShift values ('7','2','2023-06-08', 0, '',0)
--insert into UserShift values ('6','2','2023-06-08', 0, '',0)
--insert into UserShift values ('8','3','2023-06-08', 0, '',0)
--insert into UserShift values ('3','3','2023-06-08', 0, '',0)
--/*10-6*/
--insert into UserShift values ('5','1','2023-06-10', 0, '',0)
--insert into UserShift values ('6','1','2023-06-10', 0, '',0)
--insert into UserShift values ('4','2','2023-06-10', 0, '',0)
--insert into UserShift values ('6','2','2023-06-10', 0, '',0)
--insert into UserShift values ('7','3','2023-06-10', 0, '',0)
--insert into UserShift values ('3','3','2023-06-10', 0, '',0)
--/*11-6*/
--insert into UserShift values ('4','1','2023-06-11', 0, '',0)
--insert into UserShift values ('5','1','2023-06-11', 0, '',0)
--insert into UserShift values ('6','1','2023-06-11', 0, '',0)
--insert into UserShift values ('8','2','2023-06-11', 0, '',0)
--insert into UserShift values ('6','2','2023-06-11', 0, '',0)
--insert into UserShift values ('7','3','2023-06-11', 0, '',0)
--insert into UserShift values ('3','3','2023-06-11', 0, '',0)
--/*13-6*/
--insert into UserShift values ('4','1','2023-06-13', 0, '',0)
--insert into UserShift values ('5','1','2023-06-13', 0, '',0)
--insert into UserShift values ('6','1','2023-06-13', 0, '',0)
--insert into UserShift values ('7','2','2023-06-13', 0, '',0)
--insert into UserShift values ('6','2','2023-06-13', 0, '',0)
--insert into UserShift values ('8','3','2023-06-13', 0, '',0)
--insert into UserShift values ('3','3','2023-06-13', 0, '',0)
--/*15-6*/
--insert into UserShift values ('5','1','2023-06-15', 0, '',0)
--insert into UserShift values ('6','1','2023-06-15', 0, '',0)
--insert into UserShift values ('4','2','2023-06-15', 0, '',0)
--insert into UserShift values ('6','2','2023-06-15', 0, '',0)
--insert into UserShift values ('7','3','2023-06-15', 0, '',0)
--insert into UserShift values ('3','3','2023-06-15', 0, '',0)
--/*17-6*/
--insert into UserShift values ('4','1','2023-06-17', 0, '',0)
--insert into UserShift values ('5','1','2023-06-17', 0, '',0)
--insert into UserShift values ('6','1','2023-06-17', 0, '',0)
--insert into UserShift values ('7','2','2023-06-17', 0, '',0)
--insert into UserShift values ('6','2','2023-06-17', 0, '',0)
--insert into UserShift values ('8','3','2023-06-17', 0, '',0)
--insert into UserShift values ('3','3','2023-06-17', 0, '',0)
--/*18-6*/
--insert into UserShift values ('8','1','2023-06-18', 0, '',0)
--insert into UserShift values ('6','1','2023-06-18', 0, '',0)
--insert into UserShift values ('4','2','2023-06-18', 0, '',0)
--insert into UserShift values ('7','2','2023-06-18', 0, '',0)
--insert into UserShift values ('6','2','2023-06-18', 0, '',0)
--insert into UserShift values ('5','3','2023-06-18', 0, '',0)
--insert into UserShift values ('3','3','2023-06-18', 0, '',0)
--/*20-6*/
--insert into UserShift values ('4','1','2023-06-20', 0, '',0)
--insert into UserShift values ('5','1','2023-06-20', 0, '',0)
--insert into UserShift values ('6','1','2023-06-20', 0, '',0)
--insert into UserShift values ('8','2','2023-06-20', 0, '',0)
--insert into UserShift values ('6','2','2023-06-20', 0, '',0)
--insert into UserShift values ('7','3','2023-06-20', 0, '',0)
--insert into UserShift values ('3','3','2023-06-20', 0, '',0)
--/*22-6*/
--insert into UserShift values ('4','1','2023-06-22', 0, '',0)
--insert into UserShift values ('5','1','2023-06-22', 0, '',0)
--insert into UserShift values ('6','1','2023-06-22', 0, '',0)
--insert into UserShift values ('7','2','2023-06-22', 0, '',0)
--insert into UserShift values ('6','2','2023-06-22', 0, '',0)
--insert into UserShift values ('8','3','2023-06-22', 0, '',0)
--insert into UserShift values ('3','3','2023-06-22', 0, '',0)
--/*24-6*/
--insert into UserShift values ('5','1','2023-06-24', 0, '',0)
--insert into UserShift values ('6','1','2023-06-24', 0, '',0)
--insert into UserShift values ('4','2','2023-06-24', 0, '',0)
--insert into UserShift values ('6','2','2023-06-24', 0, '',0)
--insert into UserShift values ('7','3','2023-06-24', 0, '',0)
--insert into UserShift values ('3','3','2023-06-24', 0, '',0)
--/*25-6*/
--insert into UserShift values ('4','1','2023-06-25', 0, '',0)
--insert into UserShift values ('5','1','2023-06-25', 0, '',0)
--insert into UserShift values ('6','1','2023-06-25', 0, '',0)
--insert into UserShift values ('8','2','2023-06-25', 0, '',0)
--insert into UserShift values ('6','2','2023-06-25', 0, '',0)
--insert into UserShift values ('7','3','2023-06-25', 0, '',0)
--insert into UserShift values ('3','3','2023-06-25', 0, '',0)
/*27-6*/
insert into UserShift values ('8','1','2023-06-27', 0, '',0)
insert into UserShift values ('6','1','2023-06-27', 0, '',0)
insert into UserShift values ('4','2','2023-06-27', 0, '',0)
insert into UserShift values ('5','2','2023-06-27', 0, '',0)
insert into UserShift values ('6','2','2023-06-27', 0, '',0)
insert into UserShift values ('7','3','2023-06-27', 0, '',0)
insert into UserShift values ('3','3','2023-06-27', 0, '',0)
/*29-6*/
insert into UserShift values ('8','1','2023-06-29', 0, '',0)
insert into UserShift values ('6','1','2023-06-29', 0, '',0)
insert into UserShift values ('4','2','2023-06-29', 0, '',0)
insert into UserShift values ('7','2','2023-06-29', 0, '',0)
insert into UserShift values ('6','2','2023-06-29', 0, '',0)
insert into UserShift values ('5','3','2023-06-29', 0, '',0)
insert into UserShift values ('3','3','2023-06-29', 0, '',0)
/*1-7*/
insert into UserShift values ('7','1','2023-07-01', 0, '',0)
insert into UserShift values ('3','1','2023-07-01', 0, '',0)
insert into UserShift values ('5','2','2023-07-01', 0, '',0)
insert into UserShift values ('8','2','2023-07-01', 0, '',0)
insert into UserShift values ('3','2','2023-07-01', 0, '',0)
insert into UserShift values ('4','3','2023-07-01', 0, '',0)
insert into UserShift values ('6','3','2023-07-01', 0, '',0)
/*2-7*/
insert into UserShift values ('5','1','2023-07-02', 0, '',0)
insert into UserShift values ('3','1','2023-07-02', 0, '',0)
insert into UserShift values ('4','2','2023-07-02', 0, '',0)
insert into UserShift values ('3','2','2023-07-02', 0, '',0)
insert into UserShift values ('7','3','2023-07-02', 0, '',0)
insert into UserShift values ('8','3','2023-07-02', 0, '',0)
insert into UserShift values ('6','3','2023-07-02', 0, '',0)
--/*4-7*/
--insert into UserShift values ('4','1','2023-07-04', 0, '',0)
--insert into UserShift values ('8','1','2023-07-04', 0, '',0)
--insert into UserShift values ('3','1','2023-07-04', 0, '',0)
--insert into UserShift values ('5','2','2023-07-04', 0, '',0)
--insert into UserShift values ('3','2','2023-07-04', 0, '',0)
--insert into UserShift values ('7','3','2023-07-04', 0, '',0)
--insert into UserShift values ('6','3','2023-07-04', 0, '',0)
--/*6-7*/
--insert into UserShift values ('5','1','2023-07-06', 0, '',0)
--insert into UserShift values ('3','1','2023-07-06', 0, '',0)
--insert into UserShift values ('4','2','2023-07-06', 0, '',0)
--insert into UserShift values ('3','2','2023-07-06', 0, '',0)
--insert into UserShift values ('7','3','2023-07-06', 0, '',0)
--insert into UserShift values ('8','3','2023-07-06', 0, '',0)
--insert into UserShift values ('6','3','2023-07-06', 0, '',0)
--/*8-7*/
--insert into UserShift values ('4','1','2023-07-08', 0, '',0)
--insert into UserShift values ('8','1','2023-07-08', 0, '',0)
--insert into UserShift values ('3','1','2023-07-08', 0, '',0)
--insert into UserShift values ('5','2','2023-07-08', 0, '',0)
--insert into UserShift values ('3','2','2023-07-08', 0, '',0)
--insert into UserShift values ('7','3','2023-07-08', 0, '',0)
--insert into UserShift values ('6','3','2023-07-08', 0, '',0)
--/*9-7*/
--insert into UserShift values ('7','1','2023-07-09', 0, '',0)
--insert into UserShift values ('3','1','2023-07-09', 0, '',0)
--insert into UserShift values ('5','2','2023-07-09', 0, '',0)
--insert into UserShift values ('8','2','2023-07-09', 0, '',0)
--insert into UserShift values ('3','2','2023-07-09', 0, '',0)
--insert into UserShift values ('4','3','2023-07-09', 0, '',0)
--insert into UserShift values ('6','3','2023-07-09', 0, '',0)
--/*11-7*/
--insert into UserShift values ('8','1','2023-07-11', 0, '',0)
--insert into UserShift values ('3','1','2023-07-11', 0, '',0)
--insert into UserShift values ('5','2','2023-07-11', 0, '',0)
--insert into UserShift values ('7','2','2023-07-11', 0, '',0)
--insert into UserShift values ('3','2','2023-07-11', 0, '',0)
--insert into UserShift values ('4','3','2023-07-11', 0, '',0)
--insert into UserShift values ('6','3','2023-07-11', 0, '',0)
--/*13-7*/
--insert into UserShift values ('5','1','2023-07-13', 0, '',0)
--insert into UserShift values ('3','1','2023-07-13', 0, '',0)
--insert into UserShift values ('4','2','2023-07-13', 0, '',0)
--insert into UserShift values ('3','2','2023-07-13', 0, '',0)
--insert into UserShift values ('7','3','2023-07-13', 0, '',0)
--insert into UserShift values ('8','3','2023-07-13', 0, '',0)
--insert into UserShift values ('6','3','2023-07-13', 0, '',0)
--/*15-7*/
--insert into UserShift values ('4','1','2023-07-15', 0, '',0)
--insert into UserShift values ('8','1','2023-07-15', 0, '',0)
--insert into UserShift values ('3','1','2023-07-15', 0, '',0)
--insert into UserShift values ('5','2','2023-07-15', 0, '',0)
--insert into UserShift values ('3','2','2023-07-15', 0, '',0)
--insert into UserShift values ('7','3','2023-07-15', 0, '',0)
--insert into UserShift values ('6','3','2023-07-15', 0, '',0)

--Insert cho DayOff
insert into DayOff values('2023-01-01',2,'New Year''s Day',1,'')
insert into DayOff values('2023-01-22',2,'Vietnamese New Year (Tet)',1,'')
insert into DayOff values('2023-04-29',2,'Hung Kings Commemorations',1,'')
insert into DayOff values('2023-04-30',2,'Day of Southern Liberation and National Reunification',1,'')
insert into DayOff values('2023-05-01',2,'International Workers'' Day',1,'')
insert into DayOff values('2023-09-02',2,'National Day',1,'')
insert into DayOff values('2023-12-25',2,'Christmas Day',1,'')

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

/*drop table UserShift
drop table Record*/


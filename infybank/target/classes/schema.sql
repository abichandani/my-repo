drop table if exists Branch;

create table Branch(
	Branch_Code int primary key,
	
	Opening_Time time not null,
	
	Closing_Time time not null,

	Ifsc_Code varchar(20),
	
	Branch_Type varchar(20) not null,
	
	Address varchar(100),
	
	Pincode bigint,
	
	Phone_Number bigint,
	
	Email_Id varchar(50),
	
	Status varchar(1)
	
);
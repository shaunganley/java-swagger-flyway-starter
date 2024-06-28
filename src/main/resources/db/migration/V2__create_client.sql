create table `Client` (
`Client_ID` smallint auto_increment not null primary key,
`Employee_ID` smallint not null,
`Name` varchar(100) not null,
`Address` varchar(100) not null,
`PhoneNumber` varchar(11) not null
);
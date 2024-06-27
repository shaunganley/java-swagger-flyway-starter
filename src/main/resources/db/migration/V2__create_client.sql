create table `Client` (
`Client_ID` int auto_increment not null primary key,
`Employee_ID` int not null,
`Name` varchar(100) not null,
`Address` varchar(100) not null,
`PhoneNumber` varchar(11) not null
);
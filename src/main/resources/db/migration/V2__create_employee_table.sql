create table Employee(
	emp_id smallint auto_increment not null,
    role_id smallInt not null,
    emp_fname VARCHAR(50) not null,
    emp_lname VARCHAR(50) not null,
    bank_acct_no int not null,
    ni_no CHAR(9) not null,
    salary decimal(9,2) not null,
    comm_rate decimal(4,2) default 00.00,
    PRIMARY KEY (emp_id),
    FOREIGN KEY (role_id) REFERENCES Role(role_id)
);
    

CREATE TABLE `User`(
    Email varchar(30) PRIMARY KEY NOT NULL,
    Salt varchar(250) NOT NULL,
    Hash varchar(250) NOT NULL,
    RoleId int NOT NULL
);

INSERT INTO User (Email, Salt, Hash, RoleId)
    VALUES ('adam@random.com', '$2a$10$Oo6.AbrKHHYONZSeBDZpNu',
    '$2a$10$Oo6.AbrKHHYONZSeBDZpNuAmjqFv4Ae3KwIzQC1W4sSKmdGFoh3vu',2),
     ('eoghan@random.com', '$2a$10$X1zBoknoTtzCrmbGVreb.O',
     '$2a$10$X1zBoknoTtzCrmbGVreb.OkQz.t.WwQqc6LyJzXP844kAUozSNU8O',1)
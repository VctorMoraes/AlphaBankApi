CREATE TABLE IF NOT EXISTS `user` (
    ID          VARCHAR(60) NOT NULL PRIMARY KEY,
    `name`      VARCHAR(60) NOT NULL,
    Age         INT         NOT NULL,
    MonthIncome FLOAT       NOT NULL,
    City        VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS loanrequest
(
    ID        VARCHAR(60) NOT NULL PRIMARY KEY,
    status    VARCHAR(10) NOT NULL,
    maxAmount FLOAT NULl,
    UserID    VARCHAR(60) NULL,
    constraint UserID UNIQUE (UserID),
    constraint loanrequest_ibfk_1 foreign key (UserID) references `user` (ID)
);
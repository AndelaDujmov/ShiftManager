CREATE TABLE IF NOT EXISTS `shift` (
    `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `type` varchar(20) NOT NULL,
    `startDate` date NOT NULL CHECK (shift_date <= CURRENT_DATE),
    `endDate` date NOT NULL CHECK (shift_date <= CURRENT_DATE),
    `creationTime` date NOT NULL CHECK (shift_date <= CURRENT_DATE),
    `updateTime` date NOT NULL CHECK (shift_date <= CURRENT_DATE),
    `isDeleted` boolean NOT NULL
);

CREATE TABLE IF NOT EXISTS `shiftAssignment` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `employeeId` BIGINT NOT NULL,
    `shiftId` BIGINT NOT NULL,
    `shiftDate` DATE NOT NULL CHECK (shift_date <= CURRENT_DATE),
    `status` VARCHAR(50) NOT NULL,
    `creationTime` date NOT NULL CHECK (shift_date <= CURRENT_DATE),
    `updateTime` date NOT NULL CHECK (shift_date <= CURRENT_DATE),
    `isDeleted` boolean NOT NULL
);

CREATE TABLE IF NOT EXISTS `user` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(20) NOT NULL CHECK (username ~ '^[A-Za-z0-9]+$'),
    `password` VARCHAR(20) NOT NULL CHECK (username ~ '^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\",./<>?]).+$'),
    `contactNumber` VARCHAR(20) NOT NULL CHECK (username ~ '^\\d+$"'),
    `role` VARCHAR(50) NOT NULL,
    `creationTime` date NOT NULL CHECK (shift_date <= CURRENT_DATE),
    `updateTime` date NOT NULL CHECK (shift_date <= CURRENT_DATE),
    `isDeleted` boolean NOT NULL
);
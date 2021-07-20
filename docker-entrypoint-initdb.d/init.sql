CREATE DATABASE IF NOT EXISTS `car_rental_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE IF NOT EXISTS `cars` (
  `car_id` bigint NOT NULL,
  `car_brand` varchar(255) DEFAULT NULL,
  `car_model` varchar(255) DEFAULT NULL,
  `power` double DEFAULT NULL,
  `price_per_day` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS  `receipts` (
  `receipt_id` bigint NOT NULL,
  `number_of_days` int DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`receipt_id`),
  KEY `FK7t0uo7yxjck29e967rny84ky4` (`user_id`),
  CONSTRAINT `FK7t0uo7yxjck29e967rny84ky4` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `receipts_cars` (
  `receipt_id` bigint NOT NULL,
  `car_id` bigint NOT NULL,
  KEY `FKeuvnlvatlv7qsvfat8vcxoto9` (`car_id`),
  KEY `FKd9hscnr06xp62iwouakdu7to1` (`receipt_id`),
  CONSTRAINT `FKd9hscnr06xp62iwouakdu7to1` FOREIGN KEY (`receipt_id`) REFERENCES `receipts` (`receipt_id`) ON DELETE CASCADE,
  CONSTRAINT `FKeuvnlvatlv7qsvfat8vcxoto9` FOREIGN KEY (`car_id`) REFERENCES `cars` (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `roles` (
  `role_id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` bigint NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO cars(car_id, car_brand, car_model, power, price_per_day, quantity, year) VALUES
(1, 'Skoda', 'Octavia', 110, 50, 10, 2015),
(2, 'Toyota', 'Rav-4', 180, 80, 10, 2017),
(3, 'Toyota', 'Camry', 180, 90, 12, 2018),
(4, 'BMW', 'X5', 240, 120, 10, 2019),
(5, 'Volkswagen', 'Tiguan', 210, 80, 10, 2017),
(6, 'Ford', 'Focus', 120, 40, 10, 2015),
(7, 'Mazda', '6', 180, 70, 10, 2017),
(8, 'Renault', 'Megan', 110, 40, 20, 2016),
(9, 'Audi' , 'Q7', 340, 150, 10, 2017),
(10, 'Audi', 'Q5' , 240, 100, 12, 2017);

INSERT INTO users(user_id, email, first_name, last_name, password) VALUES
(1, 'admin@admin.com', 'Admin', 'Admin', '$2a$10$r1pWBQqyOPJzyP3cWN0rg.vASoPbDJnsQVHvQHvaL6o0TibrTZuXy');

INSERT INTO roles(role_id, name) VALUES
(1, 'ADMIN'),
(2, 'USER');

INSERT INTO users_roles(user_id, role_id) VALUES
(1,1);
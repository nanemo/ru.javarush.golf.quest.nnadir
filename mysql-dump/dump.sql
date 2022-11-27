CREATE TABLE `answers`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `correct_answer` varchar(255) DEFAULT NULL,
    `wrong_answer`   varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `questions`
(
    `id`       int NOT NULL AUTO_INCREMENT,
    `question` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `accounts`
(
    `id`           int NOT NULL AUTO_INCREMENT,
    `account_name` varchar(255) DEFAULT NULL,
    `login`        varchar(255) DEFAULT NULL,
    `password`     varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `description_for_wrong_answer`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `description` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO answers (correct_answer, wrong_answer)
VALUES ("Received a call", "Rejected the call");

INSERT INTO answers (correct_answer, wrong_answer)
VALUES ("Climb up to the bridge", "Refuse to climb the bridge");

INSERT INTO answers (correct_answer, wrong_answer)
VALUES ("Tell the truth about yourself", "Lie about yourself");

INSERT INTO questions (question)
VALUES ("You''ve lost your memory. Take the challenge?");

INSERT INTO questions (question)
VALUES ("You accepted the challenge. Are you going up to the captain''s bridge?");

INSERT INTO questions (question)
VALUES ("You have climbed the bridge. Who are you?");

INSERT INTO description_for_wrong_answer (description)
VALUES ("You rejected the call. Game Over");

INSERT INTO description_for_wrong_answer (description)
VALUES ("You didn''t negotiate. Game Over");

INSERT INTO description_for_wrong_answer (description)
VALUES ("Your lies have been exposed. Game Over");

INSERT INTO accounts (account_name, login, password)
VALUES ("Admin", "admin", "admin");
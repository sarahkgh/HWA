DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `course`;


CREATE TABLE `user`
(
`user_id` INT PRIMARY KEY AUTO_INCREMENT, 
`first_name` VARCHAR(20) NOT NULL, 
`user_name` VARCHAR(50) NOT NULL
);


CREATE TABLE `course`
(
`course_id` INT PRIMARY KEY AUTO_INCREMENT, 
`course_name` VARCHAR(50) NOT NULL, 
`course_description` VARCHAR(255) NOT NULL
);
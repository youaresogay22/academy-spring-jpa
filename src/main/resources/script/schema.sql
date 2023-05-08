CREATE TABLE IF NOT EXISTS `Users` (
    `user_id`   VARCHAR(50) NOT NULL,
    `password`  VARCHAR(50) NOT NULL,

    PRIMARY KEY(`user_id`)
);

MERGE INTO `Users` KEY ( `user_id` ) VALUES ( 'admin', '12345' );
MERGE INTO `Users` KEY ( `user_id` ) VALUES ( 'dongmyo', '67890' );

create table if not exists `Items` (
    `item_id` bigint not null auto_increment,
    `item_name` varchar(40) not null,
    `price` bigint not null,

    primary key(`item_id`)
);

create table if not exists `Orders` (
    `order_id` bigint not null auto_increment,
    `order_date` timestamp not null,

    primary key(`order_id`)
);

create table if not exists `OrderItems` (
    `order_id` bigint not null,
    `line_number` integer not null,
    `item_id` bigint not null,
    `quantity` integer not null,

    primary key(`order_id`, `line_number`)
);

merge into `Items` key (`item_id`) values (  1, 'apple',  300 );
merge into `Items` key (`item_id`) values (  2, 'grape',  200 );
merge into `Items` key (`item_id`) values (  3, 'banana', 150 );
merge into `Items` key (`item_id`) values (  4, 'cherry', 250 );
merge into `Items` key (`item_id`) values (  5, 'kiwi',   400 );
merge into `Items` key (`item_id`) values (  6, 'lemon',  250 );
merge into `Items` key (`item_id`) values (  7, 'lime',   250 );
merge into `Items` key (`item_id`) values (  8, 'mango',  350 );
merge into `Items` key (`item_id`) values (  9, 'orange', 200 );
merge into `Items` key (`item_id`) values ( 10, 'peach',  300 );
merge into `Items` key (`item_id`) values ( 11, 'melon',  100 );

merge into `Orders` key (`order_id`) values ( 1001, '2018-08-23 10:30:00' );
merge into `Orders` key (`order_id`) values ( 1002, '2018-08-24 21:15:30' );

merge into `OrderItems` key (`order_id`, `line_number`) values ( 1001, 1, 1, 3 );
merge into `OrderItems` key (`order_id`, `line_number`) values ( 1001, 2, 2, 1 );
merge into `OrderItems` key (`order_id`, `line_number`) values ( 1001, 3, 3, 2 );

merge into `OrderItems` key (`order_id`, `line_number`) values ( 1002, 1, 4, 1 );
merge into `OrderItems` key (`order_id`, `line_number`) values ( 1002, 2, 5, 1 );
merge into `OrderItems` key (`order_id`, `line_number`) values ( 1002, 3, 6, 2 );
merge into `OrderItems` key (`order_id`, `line_number`) values ( 1002, 4, 7, 1 );
merge into `OrderItems` key (`order_id`, `line_number`) values ( 1002, 5, 8, 5 );
merge into `OrderItems` key (`order_id`, `line_number`) values ( 1002, 6, 9, 1 );

/*
 * TODO #1: `Questions`, `Answers` 테이블 생성
 */
create table if not exists `Questions` (
    `question_id` bigint not null auto_increment,
    `title` varchar(100) not null,
    `content` text,
    `created_at` datetime not null,

    primary key(`question_id`)
);

create table if not exists `Answers` (
    `answer_id` bigint not null auto_increment,
    `question_id` bigint not null,
    `content` text,
    `created_at` datetime not null,

    primary key(`answer_id`)
);

merge into `Questions` key (`question_id`) values ( 1, '질문입니다.', '내용입니다.', '2023-05-08 23:35:00' );
merge into `Answers` key (`answer_id`) values ( 1, 1, '답변입니다.', '2023-05-08 23:36:00' );
merge into `Answers` key (`answer_id`) values ( 2, 1, '또 다른 답변입니다.', '2023-05-08 23:36:30' );


insert into Course (id, title, credits) values
('INT1', 'Introductions', 10),
('MAT1', 'Mathématiques II', 3),
('CAI1', 'Anglais I', 2),
('DEV1', 'Développement I', 10);

insert into Student (id, first_name, gender, last_name, section) values
(1, 'Thuy An','F', 'Nguyen','G'),
(2, 'Thomas','M', 'Guldentops','G'),
(3, 'Test','F', 'Test','I');

insert into COURSE_STUDENTS (COURSES_ID, STUDENTS_ID) values
('INT1',1),
('INT1',2),
('MAT1',2),
('MAT1',3);
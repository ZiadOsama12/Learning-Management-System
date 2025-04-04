INSERT INTO roles (name, description, created_at, updated_at)
VALUES 
    ('student', 'A student role for learners', GETDATE(), GETDATE()),
    ('instructor', 'An instructor role for course creators', GETDATE(), GETDATE()),
    ('admin', 'An admin role for system management', GETDATE(), GETDATE());
	-- NOT Executed
	INSERT INTO user_roles (user_id, role_id)
VALUES 
    (1, 1), -- John Doe (student)
    (2, 2), -- Jane Smith (instructor)
    (3, 1), -- Alice Johnson (student)
    (4, 3); -- Bob Brown (admin)

	INSERT INTO user_roles (user_id, role_id)
VALUES 
    (2, 1), -- John Doe (student)
    (2, 2), -- Jane Smith (instructor)
    (3, 1), -- Alice Johnson (student)
    (4, 3); -- Bob Brown (admin)

	INSERT INTO notifications (user_id, message, is_read, created_at)
VALUES 
    (4, 'Welcome to the LMS, John!', 0, GETDATE()),
    (2, 'Your course has been approved.', 1, GETDATE()),
    (3, 'Reminder: Complete your enrollment.', 0, GETDATE());

	INSERT INTO courses (title, description, category, instructor_id, status, created_at, updated_at)
VALUES 
    ('Introduction to Java', 'Learn the basics of Java programming.', 'Programming', 2, 'published', GETDATE(), GETDATE()),
    ('Web Development Basics', 'Introduction to HTML, CSS, and JavaScript.', 'Web Development', 2, 'draft', GETDATE(), GETDATE());

INSERT INTO modules (course_id, title, description)
VALUES 
    (1, 'Java Fundamentals', 'Learn variables, loops, and conditionals.'),
    (1, 'Object-Oriented Programming', 'Understand classes and objects in Java.'),
    (2, 'HTML Basics', 'Introduction to HTML structure.');

INSERT INTO lessons (module_id, title, content_url, [content_type])
VALUES 
    (1, 'Variables in Java', 'https://example.com/java-variables.mp4', 'video'),
    (1, 'Control Structures', 'https://example.com/java-control.mp4', 'video'),
    (2, 'Classes and Objects', 'https://example.com/java-oop.pdf', 'text'),
    (3, 'HTML Tags', 'https://example.com/html-tags.mp4', 'video');

	select * from lessons
	delete from lessons

	drop table lessons
	select * from content
	DBCC CHECKIDENT ('lessons', RESEED, 0);

	INSERT INTO content (lesson_id, content_url, content_type)
VALUES 
    (1, 'https://example.com/java-variables-slides.pdf', 'video'),
    (2, 'https://example.com/control-structures-quiz.pdf', 'image'),
    (3, 'https://example.com/oop-diagram.png', 'text');


	INSERT INTO assessments (lesson_id, title, created_at)
VALUES 
    (1, 'Java Variables Quiz', GETDATE()),
    (2, 'Control Structures Test', GETDATE()),
    (3, 'OOP Assessment', GETDATE());

	INSERT INTO questions (assessment_id, question_text, question_type)
VALUES 
    (1, 'What is the correct way to declare a variable in Java?', 'multiple_choice'),
    (1, 'Which data type is used for decimal numbers?', 'multiple_choice'),
    (2, 'What does a for loop do?', 'multiple_choice');

	INSERT INTO options (option_text)
VALUES 
    ('int x = 5;'), -- Option for Q1
    ('variable x = 5;'), -- Option for Q1
    ('x = 5;'), -- Option for Q1
    ('float'), -- Option for Q2
    ('int'), -- Option for Q2
    ('string'), -- Option for Q2
    ('Iterates over a range'), -- Option for Q3
    ('Declares a variable'), -- Option for Q3
    ('Creates a class'); -- Option for Q3


	INSERT INTO question_options (question_id, option_id)
VALUES 
    (1, 1), -- Q1: What is the correct way to declare a variable in Java?
    (1, 2),
    (1, 3),
    (2, 4), -- Q2: Which data type is used for decimal numbers?
    (2, 5),
    (2, 6),
    (3, 7), -- Q3: What does a for loop do?
    (3, 8),
    (3, 9);


	--- Not Executed yet
	INSERT INTO enrollments (user_id, course_id, enrolled_at, status)
VALUES 
    (1, 1, GETDATE(), 'active'), -- John enrolls in Introduction to Java
    (3, 1, GETDATE(), 'active'); -- Alice enrolls in Introduction to Java


	INSERT INTO progress (user_id, course_id, completed_modules, completed_lessons, progress_percentage, last_updated)
VALUES 
    (1, 1, 1, 2, 50.0, GETDATE()), -- John: 50% progress in Introduction to Java
    (3, 1, 0, 1, 25.0, GETDATE()); -- Alice: 25% progress in Introduction to Java


	INSERT INTO submissions (user_id, assessment_id, submitted_at, score)
VALUES 
    (1, 1, GETDATE(), 80), -- John submits Java Variables Quiz
    (3, 1, GETDATE(), 90); -- Alice submits Java Variables Quiz
INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');

INSERT INTO surveys (status, created_at, updated_at, description, name) VALUES (TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'This is the first survey', 'Survey 1');

INSERT INTO surveys (status, created_at, updated_at, description, name) VALUES (FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'This is the second survey', 'Survey 2');

INSERT INTO surveys (status, created_at, updated_at, description, name) VALUES (TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'This is the third survey', 'Survey 3');

INSERT INTO chapters (created_at, number, title, updated_at, survey_id) VALUES (CURRENT_TIMESTAMP, 1, 'Chapter 1 for Survey 1', CURRENT_TIMESTAMP, 1);

INSERT INTO chapters (created_at, number, title, updated_at, survey_id) VALUES (CURRENT_TIMESTAMP, 2, 'Chapter 2 for Survey 1', CURRENT_TIMESTAMP, 1);

INSERT INTO chapters (created_at, number, title, updated_at, survey_id) VALUES (CURRENT_TIMESTAMP, 1, 'Chapter 1 for Survey 2', CURRENT_TIMESTAMP, 2 );

INSERT INTO chapters (created_at, number, title, updated_at, survey_id) VALUES (CURRENT_TIMESTAMP, 1,'Chapter 1 for Survey 3', CURRENT_TIMESTAMP, 3);

INSERT INTO questions (comment_question, created_at, question_number, question_text, response_type, updated_at, chapter_id) VALUES ('This question asks for basic information.', CURRENT_TIMESTAMP, '1', 'What is your name?', 'text', CURRENT_TIMESTAMP, 1);
INSERT INTO questions (comment_question, created_at, question_number, question_text, response_type, updated_at, chapter_id) VALUES ('This question is about your age.', CURRENT_TIMESTAMP, '2', 'How old are you?', 'number', CURRENT_TIMESTAMP, 1);

INSERT INTO questions (comment_question, created_at, question_number, question_text, response_type, updated_at, chapter_id) VALUES ('This question is about your favorite color.', CURRENT_TIMESTAMP, '1', 'What is your favorite color?', 'text', CURRENT_TIMESTAMP, 2);
INSERT INTO questions (comment_question, created_at, question_number, question_text, response_type, updated_at, chapter_id) VALUES ('This question asks for your feedback.', CURRENT_TIMESTAMP, '2', 'How satisfied are you with our service?', 'scale', CURRENT_TIMESTAMP, 2);

INSERT INTO questions (comment_question, created_at, question_number, question_text, response_type, updated_at, chapter_id) VALUES ('This question is about your employment status.', CURRENT_TIMESTAMP, '1', 'What is your current employment status?', 'text', CURRENT_TIMESTAMP, 3);
INSERT INTO questions (comment_question, created_at, question_number, question_text, response_type, updated_at, chapter_id) VALUES ('This question asks for your level of education.', CURRENT_TIMESTAMP, '2', 'What is your highest level of education?', 'text', CURRENT_TIMESTAMP, 3);

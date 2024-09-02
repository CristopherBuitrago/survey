INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');

INSERT INTO surveys (status, created_at, updated_at, component_html, component_react, description, name) VALUES (TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '<div>Survey HTML Component 1</div>', '<SurveyComponent1 />', 'This is the first survey', 'Survey 1');

INSERT INTO surveys (status, created_at, updated_at, component_html, component_react, description, name) VALUES (FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '<div>Survey HTML Component 2</div>', '<SurveyComponent2 />', 'This is the second survey', 'Survey 2');

INSERT INTO surveys (status, created_at, updated_at, component_html, component_react, description, name) VALUES (TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '<div>Survey HTML Component 3</div>', '<SurveyComponent3 />', 'This is the third survey', 'Survey 3');

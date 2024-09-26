INSERT INTO
    role(title)
VALUES
    ('admin'),
    ('employee');


INSERT INTO
    user(username, password, role_id)
VALUES
    ('boss_man', 'password1', 1),
    ('top_employee', 'password2', 2);
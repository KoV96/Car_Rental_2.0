DELETE FROM users_roles;
DELETE FROM roles;
DELETE FROM users;

INSERT INTO users(user_id, email, first_name, last_name, password) VALUES
(1, 'okurylyk@luxoft.com', 'Alex', 'Kurylyk', '$2a$10$Bkraz7FpSAjl/AcxrIMTP.WbpnH7oHzCqxlt81WfJ152k1yK49GzK');

INSERT INTO roles(role_id, name) VALUES
(1, 'User');

INSERT INTO users_roles(user_id, role_id) VALUES
(1,1);


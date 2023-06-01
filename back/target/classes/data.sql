INSERT INTO `user` (id, username, password, role)
              VALUES (1,'miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','ADMIN');
INSERT INTO `user` (id, username, password, role)
              VALUES (2,'tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','KORISNIK');
INSERT INTO `user` (id, username, password, role)
              VALUES (3,'petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','KORISNIK');

INSERT INTO state (id, name) values (1, 'NEW');
INSERT INTO state (id, name) values (2, 'IN PROGRESS');
INSERT INTO state (id, name) values (3, 'FINISHED');

INSERT INTO sprint (id, name, total_points) values (1, 'Test Sprint', '10');
INSERT INTO sprint (id, name, total_points) values (2, 'Production Sprint', '17');

INSERT INTO task (id, name, employee, points, sprint_id, state_id) values (1, 'Create login','Milan', 7, 1, 2);
INSERT INTO task (id, name, employee, points, sprint_id, state_id) values (2, 'Backend authorization','Ivan', 7, 1, 3);
INSERT INTO task (id, name, employee, points, sprint_id, state_id) values (3, 'Test login','Tito', 1, 1, 1);
INSERT INTO task (id, name, employee, points, sprint_id, state_id) values (4, 'Create a database','Ilija', 7, 2, 3);
INSERT INTO task (id, name, employee, points, sprint_id, state_id) values (5, 'Write unit tests','David', 4, 2, 1);
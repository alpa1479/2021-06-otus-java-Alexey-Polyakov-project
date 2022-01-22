--insert into projects_users_roles
--select projects.id, projects.owner_id, roles.id from projects, roles
--where roles.id = 1;

--insert into projects_users_roles
--select p.id as project_id, u.id as user_id, (select id from roles where id != 1 and u.id = u.id order by random() limit 1) as role_id
--from projects p, users u
--where u.id not in (select user_id from projects_users_roles) order by user_id

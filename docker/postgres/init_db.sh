echo "=== Schema initialization for 'issues_folder' database ==="
psql issues_folder usr -f /tmp/schema.sql

echo "=== Data initialization for 'issues_folder' database ==="
for script in /tmp/data/*.sql;
do
    psql issues_folder usr -f "$script"
done
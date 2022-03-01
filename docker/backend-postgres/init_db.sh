echo "=== Schema initialization for 'issue_tracker' database ==="
psql issue_tracker usr -f /tmp/schema.sql

echo "=== Data initialization for 'issue_tracker' database ==="
for script in /tmp/data/*.sql;
do
    psql issue_tracker usr -f "$script"
done
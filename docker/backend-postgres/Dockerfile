FROM postgres:latest

COPY schema.sql /tmp/
COPY data/*.sql /tmp/data/
COPY init_db.sh /docker-entrypoint-initdb.d/
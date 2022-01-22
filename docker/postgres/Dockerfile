FROM postgres:10.3

COPY schema.sql /tmp/
COPY data/*.sql /tmp/data/
COPY init_db.sh /docker-entrypoint-initdb.d/

EXPOSE 5432
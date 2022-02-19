FROM quay.io/keycloak/keycloak:latest as builder

ENV KC_DB=postgres
#ENV KC_CACHE=local
ENV KC_FEATURES=token-exchange
ENV KC_METRICS_ENABLED=true

RUN /opt/keycloak/bin/kc.sh build

FROM quay.io/keycloak/keycloak:latest
COPY --from=builder /opt/keycloak/lib/quarkus/ /opt/keycloak/lib/quarkus/
WORKDIR /opt/keycloak

ENV KC_DB_URL=jdbc:postgresql://alpa-keycloak-postgres:5432/keycloak_db
ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin
ENV KC_DB_USERNAME=usr
ENV KC_DB_PASSWORD=pwd

COPY realms/issues_folder-realm.json /tmp/realms/issues_folder-realm.json
COPY realms/master-realm.json /tmp/realms/master-realm.json
COPY scripts/commands.sh /tmp/scripts/commands.sh

ENTRYPOINT ["/tmp/scripts/commands.sh"]
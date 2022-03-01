FROM quay.io/keycloak/keycloak:latest as builder

ENV KC_DB=postgres
ENV KC_CACHE=local
ENV KC_FEATURES=token-exchange
ENV KC_METRICS_ENABLED=true

RUN /opt/keycloak/bin/kc.sh build

FROM quay.io/keycloak/keycloak:latest
COPY --from=builder /opt/keycloak/lib/quarkus/ /opt/keycloak/lib/quarkus/
WORKDIR /opt/keycloak

ENV KC_DB_URL=jdbc:postgresql://keycloak-postgres:5432/keycloak_db
ENV KC_DB_USERNAME=usr
ENV KC_DB_PASSWORD=pwd

COPY realms/issue_tracker-realm.json /tmp/realms/issue_tracker-realm.json
COPY realms/master-realm.json /tmp/realms/master-realm.json
COPY scripts/commands.sh /tmp/scripts/commands.sh

ENTRYPOINT ["sh", "/tmp/scripts/commands.sh"]
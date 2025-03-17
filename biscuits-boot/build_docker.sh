
cd ..
mvn clean install -Pprod

cd biscuits-boot
mvn clean package -DskipTests=true -Pprod && docker compose build && docker compose up -d

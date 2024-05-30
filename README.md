#afin de tester en local veuillez décommenter les 5 lignes suivantes et commenter les 6 dernières lignes (configuration de mongodb pour clevercloud) 
#ensuite lancer le docker compose
#spring.application.name=XMLProject
#spring.data.mongodb.host=localhost
#spring.data.mongodb.port=27017
#spring.data.mongodb.database=cv24
#spring.data.mongodb.uri=mongodb://localhost:27017/cv24
spring.data.mongodb.host=${MONGODB_ADDON_HOST}
spring.data.mongodb.port=${MONGODB_ADDON_PORT}
spring.data.mongodb.database=${MONGODB_ADDON_DB}
spring.data.mongodb.uri=${MONGODB_ADDON_URI}
spring.data.mongodb.username=${MONGODB_ADDON_USER}
spring.data.mongodb.password=${MONGODB_ADDON_PASSWORD}

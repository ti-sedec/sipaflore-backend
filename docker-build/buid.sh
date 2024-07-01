#!/bin/bash

# Variáveis de ambiente
DOCKER_HUB_USERNAME="ti@sedec.mt.gov.br"
DOCKER_IMAGE_NAME="sipaflore-spring-api"

# Solicitar tag da imagem
read -p "Digite a tag da imagem Docker (default: latest): " DOCKER_IMAGE_TAG
DOCKER_IMAGE_TAG=${DOCKER_IMAGE_TAG:-latest}

# Solicitar senha do Docker Hub
echo -n "Digite a senha do Docker Hub: "
# Desabilitar a ecoação da entrada
stty -echo
read DOCKER_HUB_PASSWORD
# Habilitar a ecoação da entrada
stty echo
echo

# Passo 1: Construir o projeto Spring Boot
echo "Passo 1: Construindo o projeto Spring Boot..."
cd ..
mvn clean package
cp ./target/*.jar ./docker-build/app.jar
cd docker-build

# Passo 2: Construir a imagem Docker
echo "Passo 2: Construindo a imagem Docker..."
cat <<EOF > Dockerfile
FROM openjdk:17-alpine
ADD app.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
EOF
docker build -t "tisedec/$DOCKER_IMAGE_NAME:$DOCKER_IMAGE_TAG" .

# Passo 3: Autenticar no Docker Hub
echo "Passo 3: Autenticando no Docker Hub..."
echo "$DOCKER_HUB_PASSWORD" | docker login -u "$DOCKER_HUB_USERNAME" --password-stdin

# Passo 4: Enviar a imagem Docker para o Docker Hub
echo "Passo 4: Enviando a imagem Docker para o Docker Hub..."
docker push "tisedec/$DOCKER_IMAGE_NAME:$DOCKER_IMAGE_TAG"

# Passo 5: Limpar
echo "Passo 5: Limpando..."
rm -f app.jar Dockerfile

echo "Concluído!"
FROM node:alpine

COPY package.json .
COPY package-lock.json .

RUN npm ci --quiet && mkdir /app && mv ./node_modules ./app

WORKDIR /app

COPY . .
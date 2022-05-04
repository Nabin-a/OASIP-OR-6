FROM node:14-alpine3.12
WORKDIR /usr/src/
COPY package*.json ./
RUN npm install
CMD ["npm", "run", "start"]
#!/bin/bash
docker pull mysql:8
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=sic_project -e MYSQL_USER=developer -e MYSQL_PASSWORD=123456 --name mysql-sic mysql:8
docker logs -f mysql-sic

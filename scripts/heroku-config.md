# Heroku database config

### Dump
mysqldump -u user -p dbname > arquivo.sql

### run script on heroku
heroku config | grep CLEARDB_DATABASE_URL
mysql --host=us-hfju-east-11.cleardb.net --user=ba558dg6d991ff --password=58dgt54s --reconnect heroku_58f58f59sa90652 --ssl-mode=DISABLED < ./scripts/teste.sql 

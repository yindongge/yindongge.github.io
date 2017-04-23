#!/bin/sh
# File: /home/mysql_bak/backup.sh
# Database info
DB_NAME="orgstorecms_online"
DB_GIFT_NAME="giftcard"
DB_USER="root"
DB_PASS='8TUG3eoh'

# Others vars
BCK_DIR="/home/mysql_bak"
DATE=`date +%F`


# TODO
/usr/bin/mysqldump --opt -u$DB_USER -p$DB_PASS $DB_NAME | gzip > $BCK_DIR/orgstorecms_online_$DATE.gz
/usr/bin/mysqldump --opt -u$DB_USER -p$DB_PASS $DB_GIFT_NAME | gzip > $BCK_DIR/giftcart_$DATE.gz

# to save 60 days bak
find $BCK_DIR/ -name "*.gz" -mtime +60 |xargs rm -f

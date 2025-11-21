## in localhost://admin for django-admin dashboard 
username/password for super user is :-
user: admin
pass: admin

## random movie quote AH↗️HA↘️HA↗️HA↘️🤣
sound is combination of frequency,
frequency is combination of vibration,
vibration is combination of radiation,
timro sarir ma vako radiation mero sarir ma ayo,
attraction vayo Love paro 

## venv setup
source /home/sujjalbtw/Projects/mycodingbasics/python/venv/bin/activate      
(venv) 

## Database setup
 sudo mariadb                                                                 
[sudo] password for sujjalbtw: 
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 6
Server version: 12.0.2-MariaDB Arch Linux

Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [(none)]> create database django_db;
Query OK, 1 row affected (0.009 sec)

MariaDB [(none)]> use django_db;
Database changed
MariaDB [django_db]> show tables;
Empty set (0.000 sec)

MariaDB [django_db]> CREATE USER 'django_user'@'localhost' IDENTIFIED BY 'password123';
Query OK, 0 rows affected (0.010 sec)

MariaDB [django_db]> GRANT ALL PRIVILEGES ON django_db.* TO 'django_user'@'localhost';
Query OK, 0 rows affected (0.006 sec)

MariaDB [django_db]> FLUSH PRIVILEGES;
Query OK, 0 rows affected (0.001 sec)


CREATE USER 'adminbtw'@'localhost' IDENTIFIED BY 'adminbtw';
GRANT ALL PRIVILEGES ON djangotest_db.* TO 'adminbtw'@'localhost';
FLUSH PRIVILEGES;
SELECT User, Host FROM mysql.user WHERE User='adminbtw';
sudo mariadb -u adminbtw -p
Enter password: adminbtw
USE djangotest_db;
SHOW TABLES;

sudo mariadb
[sudo] password for sujjalbtw: 
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 30
Server version: 12.0.2-MariaDB Arch Linux

Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [(none)]> show databases;
+--------------------+
| Database           |
+--------------------+
| attendance_db      |
| djangotest_db      |
| information_schema |
| mysql              |
| performance_schema |
| rentwheels         |
| sys                |
+--------------------+
7 rows in set (0.001 sec)

MariaDB [(none)]> use djangotest_db;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
MariaDB [djangotest_db]> show tables;
+----------------------------+
| Tables_in_djangotest_db    |
+----------------------------+
| auth_group                 |
| auth_group_permissions     |
| auth_permission            |
| auth_user                  |
| auth_user_groups           |
| auth_user_user_permissions |
| django_admin_log           |
| django_content_type        |
| django_migrations          |
| django_session             |
| myapp_menuitem             |
| myapp_product              |
| myapp_reservation          |
| myapp_student              |
+----------------------------+
14 rows in set (0.000 sec)

MariaDB [djangotest_db]> select * from myapp_reservation
    -> ;
+----+------------+-----------+-------------+------------------+-------------------------------+
| id | first_name | last_name | guest_count | reservation_time | comments                      |
+----+------------+-----------+-------------+------------------+-------------------------------+
|  1 | Sujjal1    | Khadka    |           2 | 2025-11-16       | This is the date for 2 people |
+----+------------+-----------+-------------+------------------+-------------------------------+
1 row in set (0.006 sec)

MariaDB [djangotest_db]> (venv) 
sudo mariadb
sudo mariadb -u root -p

javac -cp .:database/mariadb-java-client-3.5.6.jar database/Database.java

java -cp .:database/mariadb-java-client-3.5.6.jar database.Database      

ALTER USER 'root'@'localhost' IDENTIFIED BY 'sujjalbtw';
FLUSH PRIVILEGES;


CREATE USER 'attendance'@'localhost' IDENTIFIED BY '12345';
GRANT ALL PRIVILEGES ON attendance_db.* TO 'attendance'@'localhost';
FLUSH PRIVILEGES;
String username = "attendance";
String password = "12345";

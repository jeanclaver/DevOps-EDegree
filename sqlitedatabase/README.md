# DevOps-EDegree
Devops Projects

As part of my DevOps training, I was asked to carry out various projects described below:

# Topic :  Install and connect to sqlite database from a virtual machine. Create a Database name "newdatabage" and create 4 tables in it.

To install and connect to an SQLite database from a virtual machine and create a new database with four tables, you can follow these steps:

1- Install SQLite in the virtual machine:
We will use our **devbox** virtual machine
- Access the virtual machine by running `vagrant ssh devbox` in the command line, replacing "devbox" with the appropriate name of the virtual machine in your case.
- Run the command `sudo apt-get update` to update the package lists.
- Run the command `sudo apt-get install sqlite3` to install SQLite.

2- Connect to the SQLite database:
- Run the command `sqlite3 newdatabase.db` to connect to the SQLite database. This will create a new database file named "newdatabase.db" if it doesn't already exist.

3. Create tables in the database according to our model (ER-Model.png):
- Once connected to the SQLite prompt, you can create tables by executing SQL statements. Here's an example to create four tables:

   ```sql
   -- Create the first table
   CREATE TABLE customer (
     customer_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
     title TEXT NOT NULL,
     fname TEXT NOT NULL,
     lname TEXT NOT NULL,
     addressline TEXT NOT NULL,
     town TEXT NOT NULL,
     phone TEXT NOT NULL,
     email TEXT NOT NULL,
     age INTEGER
   );

   -- Create the second table
   CREATE TABLE item (
     item_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
     description TEXT NOT NULL,
     cost_price double,
     sell_price double
   );

   -- Create the third table
   CREATE TABLE orderinfo (
     orderinfo_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
     customer_id INTEGER ,
     date_placed TEXT NOT NULL,
     date_shipped TEXT NOT NULL,
     shipping INTEGER,
     FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE ON UPDATE CASCADE
     
   );

   -- Create the fourth table
   CREATE TABLE orderline (
     orderinfo_id INTEGER,
     item_id INTEGER,
     quantity  INTEGER,
     FOREIGN KEY (orderinfo_id) REFERENCES orderinfo (orderinfo_id) ON DELETE CASCADE ON UPDATE CASCADE,
     FOREIGN KEY (item_id) REFERENCES item (item_id) ON DELETE CASCADE ON UPDATE CASCADE
   );
   ```

   You can modify the table structure and column names according to your specific requirements.

4. Verify the tables:
- You can check if the tables are created successfully by running the command `. tables` in the SQLite prompt. It will display a list of all tables in the database.

That's it! You have now installed SQLite, connected to the database, and created four tables within the virtual machine. You can exit the SQLite prompt by typing `.exit` or pressing Ctrl+D. The database file "newdatabase.db" will be stored in the current directory, which you can access and manipulate as needed.

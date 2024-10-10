
# Hospital Management System

A Simple Java Swing Project With Both CLI And Gui Based On Hospital Management System




## Screenshot

![HMS (1)](https://github.com/user-attachments/assets/be1f3899-be45-4133-87bf-82f8b03df37f)

## Usage

After Cloning the Project 

-Add MySql connector jar File in the External library 
```bash
mysql-connector-java-5.1.47-sources.jar
```
-Configure Your local databases Password in the following files:

```bash
1.Admin.java
2.DoctorClass.java
3.PatientClass.java
```  
Create Hospital Database In Your Mysql Database
```bash
+--------------------+
| Tables_in_hospital |
+--------------------+
| appointments       |
| doctor             |
| patients           |
+--------------------+
```
Appointments Table
```bash
+------------------+------+------+-----+---------+----------------+
| Field            | Type | Null | Key | Default | Extra          |
+------------------+------+------+-----+---------+----------------+
| id               | int  | NO   | PRI | NULL    | auto_increment |
| patient_id       | int  | NO   | MUL | NULL    |                |
| doctor_id        | int  | NO   | MUL | NULL    |                |
| appointment_date | date | NO   |     | NULL    |                |
+------------------+------+------+-----+---------+----------------+
```
Doctor Table
```bash
+----------------+--------------+------+-----+---------+----------------+
| Field          | Type         | Null | Key | Default | Extra          |
+----------------+--------------+------+-----+---------+----------------+
| id             | int          | NO   | PRI | NULL    | auto_increment |
| name           | varchar(255) | NO   |     | NULL    |                |
| specialization | varchar(255) | NO   |     | NULL    |                |
+----------------+--------------+------+-----+---------+----------------+
```
Patients Table
```bash
+--------+--------------+------+-----+---------+----------------+
| Field  | Type         | Null | Key | Default | Extra          |
+--------+--------------+------+-----+---------+----------------+
| id     | int          | NO   | PRI | NULL    | auto_increment |
| name   | varchar(255) | NO   |     | NULL    |                |
| age    | int          | NO   |     | NULL    |                |
| gender | varchar(10)  | NO   |     | NULL    |                |
+--------+--------------+------+-----+---------+----------------+
```


## Run Locally

Clone the project

```bash
  git clone https:(https://github.com/KushalYKale/Hospital_Management_System.git)
```
Install Java JDk(if not installed)

Go To HospitalManagementSystemGui Folder And 
                 
Run the MainFrame.java class 



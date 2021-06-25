# Covid

The website designed for the real-time statistics of Covid-19 and facilitates the diagnosis and treatment process for doctors.

---

## Installation

### Database (PostgreSQL)

1. Create the `covid` database in the DBMS.

```sql
    create database covid
```

2. Run the schema file [ddl.sql](./data/ddl.sql) in the database just created. 

3. Follow the instructions in [data readme](./data/README.md) to get the data in `csv` format and import them to the database. 

### Backend Server (Spring Boot)

1. You must at least have `JDK 11` installed on your computer.

2. Make sure that the environment variable `JAVA_HOME` is configured properly.

3. In the [application.yaml](./backend/src/main/resources/application.yaml) you may configure the `username`, `password` according to your database and the `server-port` however you like.

4. In the [CorsConfig.java](./backend/src/main/java/com/covid/backend/config/CorsConfig.java) you may configure the `registry.allowedOrigins()` according to the frontend server port you chose.

5. In the `backend` directory run Maven command to get the runnable `jar` file.

```shell
    ./mvnw clean compile package
```

6. Enter the `target` directory you will found the `backend-0.0.1-SNAPSHOT.jar` has just been generated. Run it and the backend server is booted up now.

```shell
    java -jar backend-0.0.1-SNAPSHOT.jar
```

### Frontend Server (Node.js)

1. You must have the JavaScript runtime `Node.js` on you computer. If you are on Windows, we recommend you to use [Scoop](https://github.com/lukesampson/scoop) to install it.

```powershell
    scoop install nodejs
```

2. In the `frontend` directory, run the following command to import the dependency for the server.

```shell
    npm install
```

3. Now, run the following command to boot up the frontend server.

```shell
    npm run serve
```

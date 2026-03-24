# Pet Shop Application

This project is a modern Java application split into a `backend` and `frontend` module. The backend securely manages the MySQL database and provides REST API endpoints. The frontend application fetches data from the backend to construct dynamic web pages with Thymeleaf.

## 1. Opening the Project in VS Code

1. Install [Visual Studio Code](https://code.visualstudio.com/) if you haven't already.
2. Open VS Code, click **File > Open Folder...**, and select the root `petshop` directory.
3. Once the folder opens, ensure you have the **Extension Pack for Java** extension installed. This will give you auto-completion, linting, and proper Java build support.
4. VS Code may prompt you to import the Java projects automatically. If so, simply click **Yes** to let the lightweight Language Server build your `.class` files.

## 2. Database Initialization

The Pet Shop backend requires an active MySQL server with the data scripts seeded. 

1. Ensure you have your local **MySQL** server running on port `3306`.
2. The credentials specified in the system are initialized for username `root` and password `pass123`.
3. If you haven't recently, you need to import the data into your DB using the provided SQL files (you can execute these from a fresh VS Code terminal):
   ```bash
   mysql -u root -ppass123 -e "DROP DATABASE IF EXISTS petshop; CREATE DATABASE petshop;"
   mysql -u root -ppass123 petshop < database_1.sql
   mysql -u root -ppass123 petshop < database_2.sql
   mysql -u root -ppass123 petshop < database_3.sql
   ```

## 3. Running the Backend 

The backend application is fundamentally required to supply the data endpoints on port `8082`.

1. Open a new Terminal inside of VS Code (`Terminal > New Terminal` or `Ctrl + Shift + \``).
2. Direct the terminal exclusively into the **backend** directory:
   ```bash
   cd backend
   ```
3. Run the application via Maven:
   ```bash
   mvn spring-boot:run
   ```
4. Allow the process to boot up. The API server maintains health once the terminal says `Started FrontendApplication`.

## 4. Running the Frontend 

The frontend uses Thymeleaf web templates on top of dynamic API mapping. It runs natively on port `8081`.

1. Leave your backend terminal actively running! Open a **second** independent Terminal (`Terminal > New Terminal`).
2. Move into the **frontend** directory:
   ```bash
   cd frontend
   ```
3. Run the frontend application via Maven:
   ```bash
   mvn spring-boot:run
   ```
4. Finally, open a web browser and navigate directly to your application: [http://localhost:8081/](http://localhost:8081/)

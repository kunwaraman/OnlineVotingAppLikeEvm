# Online Voting App (EVM System)

## Overview
The **Online Voting App (EVM System)** is a digital platform that allows users to create polls, vote on available options, and view the results in real-time. The system is built using **Spring Boot** for the backend and **Angular** for the frontend, providing a seamless experience for conducting and managing online polls.

## Features
- **Create Polls**: Users can create polls with multiple voting options.
- **Fetch All Polls**: Retrieve and display all available polls.
- **Fetch Poll by ID**: Get details of a specific poll using its ID.
- **Vote on Polls**: Users can cast votes on available poll options.
- **Real-time Vote Count**: The system updates and stores vote counts automatically.

## Technologies Used
### Backend (Spring Boot)
- **Spring Boot** (REST APIs)
- **Spring Data JPA** (Database Integration)
- **MySQL/PostgreSQL** (Database)
- **Lombok** (For reducing boilerplate code)
- **Jakarta Persistence API (JPA)** (For ORM mapping)

### Frontend (Angular)
- **Angular** (UI Framework)
- **TypeScript** (Logic and Component Handling)
- **Bootstrap** (For Styling)
- **RxJS** (Handling HTTP Requests)

## API Endpoints
### Poll Controller (`PollController.java`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/polls` | Create a new poll |
| `GET` | `/api/polls` | Retrieve all polls |
| `GET` | `/api/polls/{id}` | Fetch poll by ID |
| `POST` | `/api/polls/vote` | Cast a vote |

## Project Structure
```
project-root/
│── src/main/java/com/evm/digitalvotingapp/
│   ├── controller/
│   │   ├── PollController.java
│   ├── dtorequest/
│   │   ├── Vote.java
│   ├── model/
│   │   ├── Poll.java
│   │   ├── OptionVote.java
│   ├── repository/
│   │   ├── PollRepository.java
│   ├── services/
│   │   ├── PollService.java
│── src/main/resources/
│   ├── application.properties
```

## Database Schema
### Poll Table
| Column | Type | Description |
|--------|------|-------------|
| `id` | `Long` | Primary key, auto-generated |
| `question` | `String` | The poll question |
| `options` | `List<OptionVote>` | List of voting options |

### OptionVote Table
| Column | Type | Description |
|--------|------|-------------|
| `voteOption` | `String` | The text for the option |
| `voteCount` | `Long` | Number of votes received |

## How Voting Works
1. The user selects a poll.
2. The user chooses an option and submits their vote.
3. The backend updates the vote count in the database.
4. The frontend updates the vote count in real-time.

## How to Run the Project
### Backend (Spring Boot)
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/online-voting-app.git
   ```
2. Navigate to the project directory:
   ```sh
   cd online-voting-app
   ```
3. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/voting_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Run the Spring Boot application:
   ```sh
   mvn spring-boot:run
   ```

### Frontend (Angular)
1. Navigate to the frontend directory:
   ```sh
   cd frontend
   ```
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start the Angular development server:
   ```sh
   ng serve
   ```
4. Open `http://localhost:4200/` in a browser.

## Future Enhancements
- **User Authentication & Authorization**
- **Admin Panel for Managing Polls**
- **Real-time WebSocket Updates**
- **Mobile Responsive UI**

## Contributing
1. Fork the repository.
2. Create a feature branch: `git checkout -b feature-name`.
3. Commit changes: `git commit -m "Added new feature"`.
4. Push to the branch: `git push origin feature-name`.
5. Open a Pull Request.



1️⃣ Introduction
✅ Briefly introduce the project and its purpose.

👉 "I developed an Online Voting Application (EVM System) using Spring Boot and Angular. It allows users to create polls, vote on them, and view real-time results. The backend handles data storage and voting logic, while the frontend provides an interactive UI for users to participate."

2️⃣ Tech Stack Used
✅ Mention the technologies used and why you chose them.

💻 Backend: Spring Boot, Spring Data JPA, Hibernate, MySQL
🌐 Frontend: Angular, TypeScript
🛠️ Other Tools: Lombok (for reducing boilerplate code), REST APIs (for communication), and CORS (for cross-origin requests).

📌 "I used Spring Boot because it simplifies backend development and integrates well with Hibernate for database management. Angular was chosen for its modular structure and component-based approach."

3️⃣ Features & Functionalities
✅ Explain the key functionalities of your app.

Poll Creation:
Users can create polls with a question and multiple options.
Voting System:
Users can vote on a poll, and the system updates the vote count.
Real-Time Poll Results:
Poll results are updated dynamically when users vote.
Validation & Security:
Prevents invalid votes and handles error cases.
Database Integration:
Uses MySQL to persist poll data.
📌 "For example, when a user votes, the backend updates the vote count and saves it to the database, ensuring accurate results."

4️⃣ Database Design
✅ Explain how data is stored and managed.

Poll Table: Stores poll questions and options.
OptionVote Table: Stores vote count for each option.
📌 "I used @Entity for the Poll model and @ElementCollection to store the list of options in a separate table."

5️⃣ REST API Endpoints
✅ Briefly mention API functionalities.

HTTP Method	Endpoint	Description
POST	/api/polls	Create a new poll
GET	/api/polls	Get all polls
GET	/api/polls/{id}	Get a specific poll
POST	/api/polls/vote	Submit a vote
📌 "For instance, when a user votes, the frontend calls /api/polls/vote, which updates the database and returns the updated poll data."

6️⃣ Challenges Faced & How You Solved Them
✅ Discuss problems you faced and your solutions.

🔹 CORS Issues: Initially, the frontend could not access the backend API due to security restrictions.

✅ Solution: Implemented @CrossOrigin(origins = "http://localhost:4200/") in the Spring Boot controller.
🔹 Handling Concurrent Votes: Multiple users voting at the same time could cause data inconsistencies.

✅ Solution: Used optimistic locking to prevent race conditions.
7️⃣ Possible Enhancements
✅ Mention future improvements to show your vision.

✔️ User authentication (prevent duplicate votes)
✔️ WebSockets for real-time updates
✔️ Role-based access (Admin vs. Voter)

📌 "Currently, anyone can vote multiple times, but I plan to integrate authentication and prevent multiple votes per user."

Interview Questions You Might Face
1️⃣ Can you walk me through your project architecture?
✅ Answer:
"My project follows a 3-tier architecture with the following layers:

Frontend (Angular)

Users interact with a responsive UI built with Angular.
It communicates with the backend via HTTP requests.
Backend (Spring Boot)

Exposes REST APIs for poll creation, voting, and fetching results.
Uses Spring Data JPA for database interaction.
Database (MySQL)

Stores poll questions, options, and votes.
Optimized with indexes for faster queries.
"The frontend calls APIs from the backend, which processes the request and updates the database. The backend then sends the updated poll data back to the frontend to display results dynamically."

2️⃣ How does the voting mechanism work in your app?
✅ Answer:
"When a user votes, the frontend sends a POST request to /api/polls/vote with the poll ID and selected option. The backend then:

Validates the request to ensure the poll exists.
Increments the vote count for the selected option.
Saves the updated poll in the database.
Returns the updated poll data to the frontend for real-time display."*
3️⃣ How do you handle database transactions in Spring Boot?
✅ Answer:
"I use @Transactional to manage transactions in Spring Boot. If an operation involves multiple database updates (like updating vote counts), @Transactional ensures all changes are committed together. If any part of the process fails, the transaction rolls back to maintain data integrity."

4️⃣ How did you manage state in your Angular application?
✅ Answer:
"I used Angular services to manage state efficiently. The service layer stores poll data and shares it across components. When a vote is cast, the state updates dynamically without needing a full-page reload."

5️⃣ What happens if two users vote at the same time?
✅ Answer:
"To handle concurrency, I used optimistic locking in Spring Boot. This prevents race conditions by adding a @Version field in the entity. If two users vote simultaneously, only one update succeeds, and the other user gets an error prompting them to retry."

6️⃣ How does Spring Boot handle dependency injection?
✅ Answer:
"Spring Boot uses the Spring IoC container to handle dependency injection. It automatically injects dependencies using annotations like @Autowired, @Component, and @Service, reducing manual object creation and making the application modular and testable."

7️⃣ What is @Transactional in Spring Boot?
✅ Answer:
"@Transactional is used to manage database transactions in Spring Boot. It ensures that a series of operations either complete successfully or roll back entirely in case of failure. This prevents inconsistent database states and ensures data integrity."

8️⃣ What is the difference between @OneToMany and @ElementCollection in JPA?
✅ Answer:

@OneToMany → Used when there's a separate entity with a foreign key. It requires a relationship mapping.
@ElementCollection → Used for storing a list of simple values (like a list of poll options) inside the same table without needing a separate entity.
📌 "I used @ElementCollection for storing poll options since they are simple values and do not require a separate entity."

9️⃣ How does Angular interact with the backend using HTTP requests?
✅ Answer:
"Angular uses the HttpClient module to send HTTP requests to the backend. I created an ApiService to manage these requests. When a user submits a vote, the service calls the backend API using this.http.post(url, data) and updates the UI with the response."

🔟 How did you configure CORS in your application?
✅ Answer:
"By default, browsers block cross-origin requests for security reasons. Since my frontend (Angular) and backend (Spring Boot) run on different ports, I enabled CORS by adding this in the backend controller:"

java
Copy
Edit
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PollController {
    // Controller methods here
}
"This allows my Angular frontend to communicate with the Spring Boot backend without issues."

1️⃣1️⃣ How would you scale this app to support millions of votes?
✅ Answer:
"To scale the application, I would:

Use Caching: Implement Redis to store frequently accessed polls and reduce database queries.
Optimize Database: Use indexing and partitioning to speed up read/write operations.
Enable Load Balancing: Deploy multiple backend instances behind a load balancer.
Use Asynchronous Processing: Move vote updates to background workers using Kafka or RabbitMQ."*
1️⃣2️⃣ How can you improve database query performance in Hibernate?
✅ Answer:
"I optimized Hibernate performance by:
✔️ Using lazy loading to avoid unnecessary data retrieval.
✔️ Adding indexes on frequently queried columns.
✔️ Writing native SQL queries for complex operations.
✔️ Using batch processing to reduce multiple insert/update queries."*

1️⃣3️⃣ What are some security concerns in an online voting system?
✅ Answer:
"Some major security risks include:
✔️ Duplicate Voting: Prevented by adding user authentication and vote tracking.
✔️ SQL Injection: Prevented by using prepared statements in Hibernate.
✔️ Data Tampering: Ensured data integrity with optimistic locking.
✔️ CSRF Attacks: Protected by implementing CSRF tokens in Angular."*





// interview question answer

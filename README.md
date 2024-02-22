# Job-Application-SpringBoot

This is a simple Java Spring Boot application for managing companies, jobs, and reviews.

## Overview
The application consists of the following components:

- **Company:** Represents a company with attributes such as name, description, and associated jobs and reviews.
- **Job:** Represents a job posting with attributes such as title, description, salary range, and location.
- **Review:** Represents a review of a company, with a title, description, and rating.

**Technologies Used**
- **Java**: Programming language used for backend development.
- **Spring Boot**: Framework for building Java-based enterprise applications.
- **Spring Data JPA**: Provides repository support for JPA.
- **Hibernate**: ORM (Object-Relational Mapping) framework for mapping Java objects to database tables.
- **H2 Database**: Lightweight in-memory database for development and testing.
- **Postman**: API development environment used for testing and interacting with the application endpoints.
- **RESTful API**: Exposes endpoints for performing CRUD operations.

## API Endpoints
### Companies Endpoints:
- GET /companies: Retrieve all companies. ``` http://localhost:8080/companies ```
- POST /companies: Create a new company. ``` http://localhost:8080/companies ``` 
- GET /companies/{id}: Retrieve details of a specific company. ``` http://localhost:8080/companies/{id} ```
- PUT /companies/{id}: Update details of a specific company. ` http://localhost:8080/companies/{id} `
- DELETE /companies/{id}: Delete a company. ` http://localhost:8080/companies/{id} `

### Jobs Endpoints:
- GET /jobs: Retrieve all jobs. ` http://localhost:8080/jobs `
- POST /jobs: Create a new job. ` http://localhost:8080/jobs `
- GET /jobs/{id}: Retrieve details of a specific job. ` http://localhost:8080/jobs/{id} `
- PUT /jobs/{id}: Update details of a specific job. ` http://localhost:8080/jobs/{id} `
- DELETE /jobs/{id}: Delete a job. ` http://localhost:8080/jobs/{id} ` 

### Reviews Endpoints:
- GET /companies/{companyId}/reviews: Retrieve all reviews for a specific company. ` http://localhost:8080/companies/{companyId}/reviews `
- POST /companies/{companyId}/reviews: Add a new review for a specific company. ` http://localhost:8080/companies/{companyId}/reviews `
- GET /companies/{companyId}/reviews/{reviewId}: Retrieve details of a specific review for a specific company. ` http://localhost:8080/companies/{companyId}/reviews/{reviewId} `
- PUT /companies/{companyId}/reviews/{reviewId}: Update details of a specific review for a specific company. ` http://localhost:8080/companies/{companyId}/reviews/{reviewId} `
- DELETE /companies/{companyId}/reviews/{reviewId}: Delete a review for a specific company. ` http://localhost:8080/companies/{companyId}/reviews/{reviewId} `

# ScreenShots

### **Postman**  <br>
<img width="1507" alt="image" src="https://github.com/Yash919/Job-Application-SpringBoot/assets/60219195/89a7d5a0-1175-40a8-93b0-09b68d0df84f">
<br><br><br>
<img width="1512" alt="image" src="https://github.com/Yash919/Job-Application-SpringBoot/assets/60219195/7d9d6a46-01e0-4bde-9c50-2ad36e957576"> <br>


### **H2 Database** <br> 
<img width="1512" alt="image" src="https://github.com/Yash919/Job-Application-SpringBoot/assets/60219195/f7265d64-cfc2-4d00-ae67-212f72bdcdcf">
<br><br><br>
<img width="1512" alt="image" src="https://github.com/Yash919/Job-Application-SpringBoot/assets/60219195/f825d238-257a-4117-8830-d35e9140e1cf">


#### Credits
Created by Yash Mehta 🚀.

# Fullstack project for CSRF implementation with Spring Boot and Angular

The project has the CSRF protection implemented in both parts, the backend and the frontend.

You can find an explanatory video at: https://youtu.be/tgjLsEmxcuY

The CSRF protection allows the backend to know that the frontend which started the communication
is the same that sends the requests.

When loading the frontend, an initial request must be done to obtain the CSRF token. Then, all
the requests made by the frontend must send back this CSRF token (all but GET).

## Backend

The backend is implemented with Spring Boot. As the dependencies add, there is the web dependency
to have some endpoints availables and Spring Security to easily configure the CSRF protection.

First, I need to protect the project with Authentication. I've chosen to use the Cookie session.
Then, the CSRF protection will come as an overlayer over the Authentication. Both the authentication
of a request and the CSRF token should be send from the frontend to the backend in two different
systems. As I choose the session for the authentication, I already have a cookie for the session.
This means that I should send the CSRF in an HTTP header.

To start the backend project:
```
cd backend
./mvnw spring-boot:run
```

## Frontend

The frontend is implemented with Angular. I only added the Material dependency to easily create
the UI components.

The root component must request the CSRF token from the backend and store it at the beginning.
As I use a cookie to identify the session and the authentication of the user, I can't use another
cookie to store the CSRF token. I choose to store the token in a simple variable, and send it
for each request in an HTTP header. For that, I've override the HttpClient and use my own to
be sure to always send the HTTP header with the CSRF token.

To start the frontend project (make sure you have the Angular CLI installed):
```
cd frontend
ng serve
```


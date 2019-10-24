# Basic Todo Management Application
This project is a Basic Todo Management Application that use:
* **Front End**
   * React(Front End View Framework)
   * BootStrap(Styling Pages)
* **Back End** 
   * Spring Boot(REST API Framework)
   * Spring Security(Authentication and Authorization-JWT)
   * Maven(Dependencies Management)
   * Apache Tomcat(Server)
   * H2(Database)
   
## Login Page   
![LoginPage](./Images/LoginPage.png)

## To Do Page
![LoginPage](./Images/ToDoPage.png)

   
# TO DO App Front End
This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).
In the project directory, you can run:

### `npm start`

Runs the app in the development mode.<br>
Open [http://localhost:4200](http://localhost:4200) to view it in the browser.

The page will reload if you make edits.<br>
You will also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.<br>
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.<br>
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.<br>
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can’t go back!**

If you aren’t satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (Webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you’re on your own.

You don’t have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn’t feel obligated to use this feature. However we understand that this tool wouldn’t be useful if you couldn’t customize it when you are ready for it.

# TO DO APP Back End

### Request URLs and Examples

#### Common Headers

```
Origin - http://localhost:4200
Content-Type - application/json
Authorization 
- Bearer *** or
- Basic *****
```


#### Retrieve all todos for a user 

- GET - http://localhost:8087/users/georgeerol/todos

```json
[
    {
        "id": 1,
        "username": "GeorgeErol",
        "description": "Learn to dance",
        "targetDate": "2019-10-23T17:48:38.096+0000",
        "done": false
    },
    {
        "id": 2,
        "username": "GeorgeErol",
        "description": "Learn about Micro Services ",
        "targetDate": "2019-10-23T17:48:38.096+0000",
        "done": false
    },
    {
        "id": 3,
        "username": "GeorgeErol",
        "description": "Learn about Angular",
        "targetDate": "2019-10-23T17:48:38.096+0000",
        "done": false
    }
]
```

#### Retrieve a specific todo

- GET - http://localhost:8087/users/georgeerol/todos/1

```json
{
    "id": 1,
    "username": "GeorgeErol",
    "description": "Learn to dance",
    "targetDate": "2019-10-23T17:48:38.096+0000",
    "done": false
}
```

#### Creating a new todo

- POST to http://localhost:8087/users/georgeerol/todos with BODY of Request given below

```json
{
  "username": "georgeerol",
  "description": "Learn to Drive a Car",
  "targetDate": "2018-11-09T10:49:23.566+0000",
  "done": false
}
```

#### Updating a new todo

- http://localhost:8087/users/georgeerol/todos/1 with BODY of Request given below

```json
{
  "id": 1,
  "username": "georgeerol",
  "description": "Learn to Drive a Car",
  "targetDate": "2018-11-09T10:49:23.566+0000",
  "done": false
}
```

#### Delete todo

- DELETE to http://localhost:8087/users/georgeerol/todos/1

### JWT Authenticate

- POST to http://localhost:8087/authenticate


```json
{
  "username":"george",
  "password":"password@!23@#!"
}
```

Response

```json
{
"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYW5nYSIsImV4cCI6MTU0MjQ3MjA3NCwiaWF0IjoxNTQxODY3Mjc0fQ.kD6UJQyxjSPMzAhoTJRr-Z5UL-FfgsyxbdseWQvk0fLi7eVXAKhBkWfj06SwH43sY_ZWBEeLuxaE09szTboefw"
}
```

Other URLS
- Refresh - http://localhost:8087/authenticate


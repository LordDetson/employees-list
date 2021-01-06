# employees-list
Angular 10 + Spring Boot CRUD Full Stack App

This is the backend of the project. You can see the front-end of the project [here](https://github.com/LordDetson/employee-list-client).

Created according to [this guide](https://youtube.com/playlist?list=PLGRDMO4rOGcNzi3CpBWsCdQSzbjdWWy-f). Great thanks to [Ramesh Fadatare](https://github.com/RameshMF)!

## Commit flags

config: - project setting

feat: - implementation of feature

fix: - bug fixes

## Issue

An error may occur when processing requests from the front-end project related to CORS policy ([see details](https://stackoverflow.com/questions/56328474/origin-http-localhost4200-has-been-blocked-by-cors-policy-in-angular7)). 

**To fix this**, add `@CrossOrigin(origins = "http://localhost:4200")` to `EmployeeController`.

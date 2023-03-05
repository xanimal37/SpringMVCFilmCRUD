# SpringMVCFilmCRUD

## Description
This is a full stack project which consists of a front end where the user can look up, modify, create and delete films and actors from a database. 

## Tools
- SpringToolSuite4
- Gradle
- git
- github
- SQL

## Concepts
- MVC
- DAO

## Lessons Learned
- can't serve jsp with links, if in WEB-INF must use servlet
- JUnit tests very useful for testing DAO as methods are added
- database auto-increment for primary key (id) doesn't fill 'empty' space it remembers what has been added i.e. if we add 1001 and then delete if, if another film is added it will get 1002.
- should use command objects but initially using explicit object creation in the controller

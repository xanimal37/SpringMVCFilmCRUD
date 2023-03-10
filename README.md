# SpringMVCFilmCRUD

## Description
This is a full stack project which consists of a front end where the user can look up, modify, create and delete films and actors from a database. When finding a film by id, the user is able to edit the data in the same page. If using keyword to find a film, the film entry becomes a link which when clicked will populate forms on the linked page for editing or deleting the film.

## Tools
- SpringToolSuite4
- Gradle
- git
- github
- SQL
- Bootstrap

## Concepts
- MVC
- DAO

## Lessons Learned
- can't serve jsp with links, if in WEB-INF must use servlet
- JUnit tests very useful for testing DAO as methods are added
- database auto-increment for primary key (id) doesn't fill 'empty' space it remembers what has been added i.e. if we add 1001 and then delete if, if another film is added it will get 1002.
- should use command objects but initially using explicit object creation in the controller
- learned how to pass radio buttons and check boxes to JSP. This is because the database is limited 
to specific values for RATING and FEATURES. To prevent the user from entering invalid information it is useful to limit input. Maybe did not do it the best way but it works.
- GET method is called when serving a jsp, not just when a form button is clicked. Data can be passed this way by passing variables in the link. This is how the film data populates the form after clicking a link from the keyword search page.


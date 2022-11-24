# academy
**RestApi for academy**
***
**app to manage studends and teachers**

**Student endpoint**

*POST http://localhost:8080/student -> create student*

*GET http://localhost:8080/student/{id} -> get student by id*

*GET http://localhost:8080/student/page/{number of results on page} -> get student list*

*GET http://localhost:8080/student/sort/"param" -> get students sort e.g. age or first name*

*GET http://localhost:8080/student?firstName=Kamil -> get students equal first name*

*PUT http://localhost:8080/student/{id} -> update student*

*DELETE http://localhost:8080/student/{id} -> remove student by id*

**Teacher endpoint**

*POST http://localhost:8080/teacher -> create teacher*

*GET http://localhost:8080/teacher/{id} -> get teacher by id*

*GET http://localhost:8080/teacher/page/{number of results on page} -> get teacher list*

*GET http://localhost:8080/teacher/sort/"param" -> get teachers sort e.g. age or first name*

*GET http://localhost:8080/teacher?firstName=Jerzy -> get teachers equal first name*

*PUT http://localhost:8080/teacher/{id} -> update teacher*

*DELETE http://localhost:8080/teacher/{id} -> remove teacher by id*

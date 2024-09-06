# Campus Surveys

Campus Surveys es una API diseñada por *[CristopherBuitrago](https://github.com/CristopherBuitrago)* y *[SantiLaguado](https://github.com/SanTiLaguado)* para la gestión de encuestas, incluyendo la creación, actualización, eliminación y obtención de encuestas, capítulos, preguntas, y opciones. Este proyecto se ha desarrollado utilizando Spring Boot y sigue buenas prácticas de arquitectura de software.

## Endpoints

La API está configurada para ejecutarse en la ruta por defecto: `http://localhost:6969`

### 1. **ChapterController**
   - **GET `http://localhost:6969/chapters/all`**: Retorna una lista con todos los capítulos.
   - **GET `http://localhost:6969/chapters/{id}`**: Busca un capítulo por su ID.
   - **GET `http://localhost:6969/chapters/survey/{surveyId}`**: Retorna una lista de capítulos pertenecientes a una encuesta específica según el ID de la encuesta.
   - **GET `http://localhost:6969/chapters/{title}`**: Busca un capítulo por su título.
   - **POST `http://localhost:6969/chapters/create`**: Crea un nuevo capítulo.
   - **PUT `http://localhost:6969/chapters/update/{id}`**: Actualiza un capítulo existente por su ID.
   - **DELETE `http://localhost:6969/chapters/delete/{id}`**: Elimina un capítulo por su ID.

### 2. **OptionController**
   - **POST `http://localhost:6969/options/create`**: Crea una nueva opción para una pregunta.
   - **GET `http://localhost:6969/options/{id}`**: Busca una opción por su ID.
   - **GET `http://localhost:6969/options/all`**: Retorna una lista con todas las opciones.
   - **PUT `http://localhost:6969/options/update/{id}`**: Actualiza una opción existente por su ID.
   - **DELETE `http://localhost:6969/options/delete/{id}`**: Elimina una opción por su ID.
   - **GET `http://localhost:6969/options/question/{id}`**: Retorna una lista de opciones para una pregunta específica según el ID de la pregunta.

### 3. **QuestionController**
   - **GET `http://localhost:6969/questions/all`**: Retorna una lista con todas las preguntas.
   - **GET `http://localhost:6969/questions/{id}`**: Busca una pregunta por su ID.
   - **GET `http://localhost:6969/questions/chapter/{chapterId}`**: Retorna una lista de preguntas pertenecientes a un capítulo específico según el ID del capítulo.
   - **POST `http://localhost:6969/questions/create`**: Crea una nueva pregunta.
   - **PUT `http://localhost:6969/questions/update/{id}`**: Actualiza una pregunta existente por su ID.
   - **DELETE `http://localhost:6969/questions/delete/{id}`**: Elimina una pregunta por su ID.

### 4. **SurveyController**
   - **GET `http://localhost:6969/survey/all`**: Retorna una lista con todas las encuestas.
   - **GET `http://localhost:6969/survey/all/public`**: Retorna una lista de encuestas públicas.
   - **GET `http://localhost:6969/survey/{id}`**: Busca una encuesta por su ID.
   - **POST `http://localhost:6969/survey/create`**: Crea una nueva encuesta.
   - **PUT `http://localhost:6969/survey/update/{id}`**: Actualiza una encuesta existente por su ID.
   - **PUT `http://localhost:6969/survey/post/{id}`**: Cambia el estado de una encuesta (activada/desactivada).

### 5. **AuthController**
   - **POST `http://localhost:6969/auth/login`**: Autentica un usuario con sus credenciales.
   - **POST `http://localhost:6969/auth/register`**: Registra un nuevo usuario.

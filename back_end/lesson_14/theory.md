# Lesson 14

Моделирование API на Java - это процесс проектирования и создания интерфейсов приложений (API) с использованием языка программирования Java. Этот процесс включает в себя несколько этапов, начиная с определения требований и заканчивая реализацией и документированием API. Давайте рассмотрим каждый этап более подробно:

1. **Определение требований**:
   Первым шагом в моделировании API является понимание требований к вашему API.
   Это включает в себя определение функциональности, которую должно предоставлять API,
   а также определение типов данных, которые будут передаваться через API и ожидаемых результатов.

2. **Проектирование интерфейса**:
   На этом этапе вы определяете структуру вашего API, включая пути доступа (endpoints),
   методы запросов, параметры и форматы данных. Вам может помочь использование различных инструментов,
   таких как UML-диаграммы или специализированные инструменты для проектирования API.

3. **Выбор архитектурного стиля**:
   Выбор архитектурного стиля API важен для обеспечения эффективности, масштабируемости и безопасности
   вашего приложения. Наиболее популярным в настоящее время является RESTful.

4. **Разработка бизнес-логики**:
   После того как вы определили структуру API, вам нужно реализовать бизнес-логику,
   которая будет выполняться при вызове каждого метода API.
   Здесь важно обеспечить корректную обработку запросов, валидацию данных и выполнение необходимых операций.

5. **Использование библиотек и фреймворков**:
   В Java существует множество библиотек и фреймворков, которые могут упростить создание и поддержку API.
   Эти инструменты предоставляют множество функций, таких как инверсия управления, внедрение зависимостей,
   управление транзакциями и многое другое.

6. **Тестирование API**:
   После реализации API важно протестировать его на соответствие требованиям, а также на безопасность
   и производительность. Это может включать в себя функциональное тестирование, модульное тестирование,
   интеграционное тестирование и нагрузочное тестирование.

7. **Документирование API**:
   Хорошая документация API помогает разработчикам быстро и легко понять, как использовать ваше API.
   Обычно это включает в себя описание каждого метода API, его параметров, возвращаемых значений и возможных ошибок.
   Вы можете использовать инструменты автоматической генерации документации, такие как Swagger или OpenAPI, чтобы упростить этот процесс.

8. **Развертывание и масштабирование**:
   После завершения разработки и тестирования API вы можете развернуть его на сервере и настроить масштабируемость
   для обеспечения отказоустойчивости и эффективности работы при росте нагрузки.

Это основные этапы процесса моделирования API на Java.


### **JSON (JavaScript Object Notation)**
Это легкий формат обмена данными, основанный на подмножестве синтаксиса JavaScript. Он представляет собой текстовый формат, понятный для человека, который легко читается и записывается, а также удобен для машины для разбора и генерации данных.
JSON состоит из пар "ключ: значение", где ключ - это строка, а значение может быть строкой, числом, логическим значением, массивом, объектом или null.

В Spring Boot приложениях JSON широко используется для обмена данными между клиентом и сервером.
Spring Boot обеспечивает удобные средства для работы с JSON, включая автоматическую сериализацию и десериализацию объектов Java в JSON и обратно с использованием Jackson, который является стандартным для многих приложений на Java.

Чтобы использовать JSON в Spring Boot приложении, вы можете использовать аннотации контроллеров, такие как @RestController, которые автоматически сериализуют результаты методов контроллера в JSON.

Пример:

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
    
    @GetMapping("/example")
    public MyObject getExample() {
        MyObject obj = new MyObject();
        obj.setId(1);
        obj.setName("Example");
        return obj;
    }
}
```

```java
public class MyObject {
    
    private int id;
    private String name;
    
    // Геттеры и сеттеры
}
```

В этом примере метод `getExample()` возвращает объект `MyObject`, который автоматически сериализуется в JSON при вызове этого метода.
В результате клиент получит JSON-объект вида `{"id":1,"name":"Example"}`.

Таким образом, JSON является важной частью разработки Spring Boot приложений, поскольку обеспечивает удобный и эффективный способ обмена данными между клиентом и сервером.


### **DTO (Data Transfer Object)**

DTO — это объект, который используется для передачи данных между подсистемами приложения.
Он содержит только поля и getter/setter методы для доступа к ним.
DTO не содержит бизнес-логики и используется только для передачи данных.

## Что такое DTO (Data Transfer Object)?

Зачастую, в клиент-серверных приложениях, данные на клиенте (слой представления) и на сервере (слой предметной области) структурируются по-разному.
На стороне сервера это дает нам возможность комфортно хранить данные в базе данных или оптимизировать использование данных в угоду производительности,
в то же время заниматься “user-friendly” отображением данных на клиенте, и, для серверной части, нужно найти способ как переводить данные из одного формата в другой.
Конечно, существуют и другие архитектуры приложений, но DTO-подобные объекты могут использоваться между любыми двумя слоями представления данных.

DTO — это так называемый value-object на стороне сервера, который хранит данные, используемые в слое представления.
Следует разделять DTO на те, что мы используем при запросе (Request) и на те, что мы возвращаем в качестве ответа сервера (Response).
Они автоматически сериализуются и десериализуются фреймворком Spring.


#### ** Swagger **

Swagger - особый инструмент, автоматически документирующий интерфейс RESTful API вашего приложения.
Он помогает разработчикам создавать, документировать и проверять API.
Его достоинство заключается в том, что он позволяет не только изучить все эндпойнты приложения,
но и сразу же протестировать их в деле, отправить любой запрос и получить ответ.

Часть работы с REST API — это создание описаний работы API: информации о ресурсах, параметрах запросов, возвращаемых данных, конечных точках и других важных вещах. Чтобы автоматизировать это описание, сделать его структурированным и прозрачным, разработчики используют Swagger.

**Для чего нужен Swagger**

Разработчики API

●	Документация. Swagger позволяет автоматически создавать документацию для API на основе спецификации OpenAPI. Это включает в себя информацию о доступных методах, параметрах, типах данных и возвращаемых значениях.
●	Проверка совместимости. Swagger позволяет проверять совместимость API до его реализации, путем создания и валидации спецификации. Это позволяет обнаружить и исправить потенциальные проблемы дизайна и конфигурации API ещё до его запуска.
●	Генерация клиентского кода. Swagger позволяет автоматически генерировать клиентский код для различных языков программирования на основе спецификации OpenAPI. Это позволяет разработчикам быстро интегрировать API в свои приложения без необходимости вручную создавать и настраивать HTTP-запросы.
●	Продвижение API. Swagger предоставляет интерактивную документацию, которая может быть использована для рекламы и продвижения API. Разработчикам будет легко понять, как использовать API, а также его функциональность и возможности.
●	Улучшение командной работы. Swagger предоставляет единый и точный источник информации об API. Спецификация OpenAPI — стандартная форма описания API, которую может использовать вся команда для понимания функциональности и взаимодействия с API.

Важным преимуществом Swagger является его удобный интерфейс, который позволяет пользователям взаимодействовать с API напрямую в браузере. Они могут просмотреть доступные методы, параметры, примеры запросов и ответов, а также выполнить тестовые запросы прямо в интерфейсе Swagger.
Это упрощает процесс разработки и отладки API, а также улучшает понимание его функциональности для конечного пользователя.


Документация, сгенерированная с помощью Swagger, представляет собой интерактивную веб-страницу, которая описывает функциональность вашего API.

Вот пример того, как может выглядеть такая документация:

1. **Общая информация**: Документация начинается с общей информации о вашем API, такой как название, версия, описание и контактная информация.

2. **Маршруты (Endpoints)**: Каждый маршрут вашего API будет отображаться отдельно.

3. Например, если у вас есть маршрут для получения списка пользователей, это будет отображаться как отдельная секция в документации.

    - **Метод запроса**: Например, GET, POST, PUT, DELETE.
    - **Путь (Path)**: URL-адрес, который клиент должен использовать для доступа к этому маршруту.
    - **Параметры запроса**: Параметры, которые могут быть переданы через URL-адрес или тело запроса.
    - **Формат ответа (Response)**: Описание формата данных, который возвращает ваш API при успешном запросе.
    - **Примеры запросов и ответов**: Подробные примеры запросов и соответствующих ответов для каждого маршрута.

3. **Модели данных**: Если ваш API использует какие-либо структуры данных, такие как объекты или массивы, документация может содержать описание этих моделей данных, включая их поля и типы данных.

4. **Тестирование API**: Swagger UI обычно также предоставляет возможность прямого тестирования API прямо из документации. Пользователи могут отправлять запросы и просматривать ответы прямо на странице документации.


### ---------- ПРИМЕР РАЗРАБОТКИ ПРИЛОЖЕНИЯ --------------------

**Пример: Разработка Приложения для Управления Задачами с использованием REST API**

**Введение:**
Мы создаем приложение, которое обеспечивает управление задачами пользователей. Это приложение предоставляет функции создания, редактирования,
удаления и поиска задач по различным параметрам. Кроме того, оно будет взаимодействовать с пользователем через REST API, возвращая ответы в формате JSON.

**Функционал:**
- Создание задачи
- Редактирование задачи
- Удаление задачи
- Поиск задачи по названию
- Поиск задачи по дате

**Описание сущностей:**
1. **Task (Задача):**
    - Integer id
    - String taskName
    - String taskDescription
    - LocalDateTime createDate
    - LocalDateTime deadline
    - User user

2. **User (Пользователь):**
    - Integer id
    - String username
    - String password
    - String eMail

**Репозитории:**
1. TaskRepository
2. UserRepository

**Описание REST API:**

**Создание новой задачи**
- Метод: POST
- URL: createTask
- Запрос: createTaskRequestDto
  ```json
  {
    "taskName": "Название задачи",
    "taskDescription": "Описание задачи",
    "deadline": "Срок выполнения"
  }
  ```
- Ответ: taskResponseDto
  ```json
  {
    "id": "Идентификатор задачи",
    "taskName": "Название задачи",
    "taskDescription": "Описание задачи",
    "createDate": "Дата создания",
    "deadline": "Срок выполнения",
    "userId": "Идентификатор пользователя"
  }
  ```

**Поиск задачи по имени**
- Метод: GET
- URL: /api/tasks?taskName=…
- Параметр: taskName
  ```json
  {
    "taskName": "Название задачи"
  }
  ```
- Ответ:
  ```json
  {
    "id": "Идентификатор задачи",
    "taskName": "Название задачи",
    "taskDescription": "Описание задачи",
    "createDate": "Дата создания",
    "deadline": "Срок выполнения",
    "userId": "Идентификатор пользователя"
  }
  ```
После составления списка запросов, которые будет обрабатывать наше приложение,
а также прописания структуры JSON запросов и ответов, мы фактически получили
полное понимание структуры необходимых DTO и описание сигнатур сервисных методов,
определив их функциональность, входные параметры и ожидаемые результаты.


**Сервисы:**
- Создание новой задачи
  ```java
  ResponseEntity<TaskResponseDto> createNewTask(createTaskRequestDto request) {}
  ```

**CreateTaskRequestDto**
```json
{
  "taskName": "Название задачи",
  "taskDescription": "Описание задачи",
  "deadline": "Срок выполнения"
}
```

**JSON Пример:**
```json
{
  "taskName": "task1",
  "taskDescription": "descry 1"
}
```

**Валидация данных:**
```java
public class User {
  @NotBlank(message = “Name is mandatory”)
  private String name;

  @Size(min = 6, max = 15, message = “Password must be between 6 and 15 characters”)
  private String password;
}
```

**Обработка ошибок:**
```java
@PostMapping("/users")
public ResponseEntity<String> createUser(@Valid @RequestBody User user, BindingResult result) {
  if (result.hasError()) {
    return ResponseEntity.badRequest().body(“There were errors in the user data”);
  }
  // логика записи нового пользователя
  return ResponseEntity.ok(“User is valid”);
}
```

```java
@PostMapping
public ResponseEntity<String> createUser(@RequestBody User user) {
  // логика записи нового пользователя
  return ResponseEntity.ok(“User is valid”);
}
```



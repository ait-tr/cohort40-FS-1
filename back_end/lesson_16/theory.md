# Lesson 16

Аннотации Swagger используются для документирования и описания RESTful API в Spring Boot приложениях. 
В современном Spring Boot Swagger реализован через библиотеку Springdoc OpenAPI. 
Основные аннотации Swagger помогают описывать конечные точки API, их параметры, возможные ответы и прочие аспекты.

### Основные аннотации Swagger

1. **@Operation**
    - **Описание:** Используется для описания отдельной операции API (например, отдельного HTTP-запроса).
    - **Параметры:**
        - `summary`: краткое описание операции.
        - `description`: детальное описание операции.
        - `tags`: список тегов для группировки операций.
        - `responses`: возможные ответы на запрос.
    - **Пример:**
      ```java
      @Operation(summary = "Find manager by name", description = "Returns a manager by their name")
      ```

2. **@ApiResponse**
    - **Описание:** Используется для описания возможного ответа на запрос.
    - **Параметры:**
        - `responseCode`: код ответа HTTP (например, 200, 404).
        - `description`: описание ответа.
    - **Пример:**
      ```java
      @ApiResponse(responseCode = "200", description = "Found the manager")
      ```

3. **@ApiResponses**
    - **Описание:** Группирует несколько аннотаций `@ApiResponse`.
    - **Пример:**
      ```java
      @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Found the manager"),
          @ApiResponse(responseCode = "404", description = "Manager not found")
      })
      ```

4. **@Parameter**
    - **Описание:** Используется для описания параметра операции.
    - **Параметры:**
        - `name`: имя параметра.
        - `description`: описание параметра.
        - `required`: указывает, является ли параметр обязательным.
    - **Пример:**
      ```java
      @Parameter(name = "managerName", description = "Name of the manager", required = true)
      ```

### Примеры использования

#### Описание GET-метода с использованием аннотаций Swagger

```java
@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @Operation(summary = "Find manager by name", description = "Returns a manager by their name")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the manager"),
        @ApiResponse(responseCode = "404", description = "Manager not found")
    })
    @GetMapping("/{managerName}")
    public ResponseEntity<ManagerResponseDTO> findByManagerName(
            @Parameter(name = "managerName", description = "Name of the manager", required = true)
            @PathVariable String managerName) {
        return ResponseEntity.ok(managerService.findByManagerName(managerName));
    }
}
```

#### Описание POST-метода с использованием аннотаций Swagger

```java
@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @Operation(summary = "Create new manager", description = "Creates a new manager in the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Manager created successfully"),
        @ApiResponse(responseCode = "400", description = "Manager already exists")
    })
    @PostMapping
    public ResponseEntity<ManagerCreateResponseDTO> createManager(
            @Parameter(description = "Manager create request data", required = true)
            @RequestBody ManagerCreateRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(managerService.createManager(request));
    }
}
```

### Дополнительные аннотации Swagger

- **@Schema**: используется для описания модели данных.
  ```java
  @Schema(description = "Manager create request data")
  public class ManagerCreateRequestDTO {
      @Schema(description = "Name of the manager", example = "James")
      private String managerName;
      @Schema(description = "Password of the manager", example = "password123")
      private String password;
      @Schema(description = "Email of the manager", example = "james@example.com")
      private String email;
  }
  ```

- **@RequestBody**: аннотация Spring, используемая для обозначения тела запроса в методах контроллеров. Swagger автоматически документирует параметры с этой аннотацией.

### Конфигурация Swagger

Для полной интеграции Swagger необходимо создать конфигурационный класс:

```java
package org.group40fs1workingproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("My API")
                        .version("1.0")
                        .description("API documentation for my Spring Boot project"));
    }
}
```
Для того чтобы Swagger показывал пример значения, которое будет возвращено при ошибке, нужно использовать аннотацию @ExampleObject в @ApiResponse. 
Это позволит вам указать пример значения, который будет отображаться в Swagger.

Вот как это можно сделать:

```java
package org.group40fs1workingproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.group40fs1workingproject.dto.managerDto.ManagerCreateRequestDTO;
import org.group40fs1workingproject.dto.managerDto.ManagerCreateResponseDTO;
import org.group40fs1workingproject.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @Operation(summary = "Create new manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Manager created successfully"),
            @ApiResponse(responseCode = "400", description = "Manager already exists",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "Manager already exists")))
    })
    @PostMapping
    public ResponseEntity<ManagerCreateResponseDTO> createManager(@RequestBody ManagerCreateRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(managerService.createManager(request));
    }
}
```

### Заключение

Аннотации Swagger позволяют детально документировать API, делая его понятным и доступным для разработчиков и пользователей. 
С помощью таких аннотаций можно описывать параметры запросов, возможные ответы и модели данных, что существенно облегчает понимание и использование API.


## Spring Security

## 01. Безопасность в приложении


* `Aутентификация` - идентификация пользователя, кто ты?
* Аутентификация - процесс, при котором приложение запрашивает логин и пароль и проверяет их корректность (проверка подлинности данных пользователя)


* `Авторизация` - проверка прав пользователя, какие действия ты можешь выполнять?
* Авторизация - процесс, при котором приложение проверяет права пользователя на выполнение каких-либо операций
    * например, проверка на возможность получения пользователем всех курсов по адресу `/courses`

* HTTP-сессия - это некоторый объект, который мы храним на сервере, с которым может быть ассоциирован конкретный пользователь

## 02. Процесс аутентификации на основе сессии

* Сначала клиент отправляет POST-запрос на сервер по адресу `api/login`
* В теле запроса клиент передает данные для аутентификации (например, email и пароль)
* Сервер проверяет корректность этих данных (находит пользователя в базе, хеширует введенный пароль, сравнивает с тем, который есть в базе)
* Если данные для входа корректные, то сервер в оперативной памяти создает объект сессии
    * ассоциирует с этим объектом данные пользователя
    * назначает объекту идентификатор
    * отправляет клиенту этот идентификатор, который на клиенте сохраняется в куках

## 03. Процесс авторизации на основе сессии

* Клиент посылает свой запрос вместе с кукой, которая содержит идентификатор сессии
* Сервер по этому идентификатору находит сессию в хранилище и получает ее атрибуты (в нашем случае это пользователь)
* Получив пользователя, сервер проверяет его роль и доступ к определенному endpoint на основе правил (опишем далее)
* Клиенту возвращается либо запрошенный ресурс, либо 403-статус (Запрещено)


## 04. Настройка безопасности Spring Boot с Spring Security

* При подключении Spring Boot Starter Security у вас есть:
    * Страница входа
    * Защита всех endpoints
    * Логин `user`
    * Пароль генерируется в консоли
* Но мы хотим, чтобы люди заходили под своими логинами и паролями


* `Authentication` - объект, который хранит для каждого запроса информацию о пользователе и статусе его аутентификации.

* `SecurityContext` - информация о безопасности, которая ассоциирована с текущим потоком исполнения (Thread). Хранит объект Authentication.

* `SecurityContextHolder` - привязывает SecurityContext к текущему потоку исполнения. По умолчанию ThreadLocal - контекст безопосности доступен всем методам, исполняемым в рамках данного потока.

* Т.е. когда приходит запрос на сервер, сервер выделяет ему один поток из `Tomcat Thread Pool`
* Далее, SecurityContextHolder (на самом деле фильтры, но это не важно) смотрит текущую сессию и привязывает объект `Authentication` к текущему потоку исполнения
* Далее, когда запрос приходит в какой-либо контроллер или хендлер - он уже приходит с объектом аутентификации


### Шаги по настройке Spring Security


1. Создать класс-реализацию интерфейса `UserDetails`
* Данный класс нужен для того, чтобы адаптировать вашего пользователя под безопасность Spring Security
* По сути, это адаптер нашего класса `User` для `Spring Security`
2. Создать класс-реализацию интерфейса `UserDetailsService`
* Данный класс нужен для того, чтобы показать Spring Security откуда брать пользователя для проверки
3. Настройка конфигурации Spring Security
4. Навести порядок с ответами на запросы

  



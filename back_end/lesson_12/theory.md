# Lesson 12

Аннотации @Transactional и @Modifier относятся к аспектам управления транзакциями и изменениям состояния данных в приложениях на языке Java, особенно в контексте использования фреймворка Spring.

### Аннотация @Transactional

Аннотация @Transactional в Spring используется для декларирования методов или классов, которые должны выполняться в рамках транзакции. Эта аннотация предоставляет управление транзакциями, позволяя разработчикам указать, как должны обрабатываться транзакции для определённых методов.

#### Основные свойства @Transactional:

1. **propagation**: Определяет поведение метода в транзакции. Возможные значения:
   - **REQUIRED** (по умолчанию): Использует текущую транзакцию, если она существует, или создает новую.
   - **REQUIRES_NEW**: Всегда создает новую транзакцию, приостанавливая текущую, если она существует.
   - **SUPPORTS**: Метод будет работать в транзакции, если она существует, но не создаст новую.
   - **NOT_SUPPORTED**: Метод будет работать вне транзакции, приостанавливая текущую, если она существует.
   - **MANDATORY**: Метод должен быть выполнен в существующей транзакции, иначе вызовет исключение.
   - **NEVER**: Метод должен быть выполнен вне транзакции, иначе вызовет исключение.
   - **NESTED**: Метод будет выполнен в рамках вложенной транзакции, если существует текущая транзакция.

2. **isolation**: Определяет уровень изоляции транзакции, что помогает управлять параллелизмом и предотвращать такие проблемы, как фантомные чтения и грязное чтение. Возможные значения:
   - **DEFAULT**: Использует уровень изоляции базы данных по умолчанию.
   - **READ_UNCOMMITTED**: Позволяет грязное чтение.
   - **READ_COMMITTED**: Предотвращает грязное чтение.
   - **REPEATABLE_READ**: Предотвращает грязное чтение и неповторяющееся чтение.
   - **SERIALIZABLE**: Самый строгий уровень, предотвращает фантомные чтения.

3. **timeout**: Определяет максимальное время (в секундах), в течение которого транзакция должна быть выполнена. Если время превышено, транзакция откатывается.

4. **readOnly**: Указывает, что транзакция является только для чтения. Это может помочь оптимизировать производительность.

5. **rollbackFor** и **noRollbackFor**: Определяют, какие исключения должны приводить к откату транзакции, а какие нет.

Пример использования:
```java
@Service
public class MyService {

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, timeout = 5, rollbackFor = Exception.class)
    public void myTransactionalMethod() {
        // Логика метода
    }
}
```

### Аннотация @Modifying

Аннотация @Modifying используется в контексте Spring Data JPA для обозначения методов репозитория, которые изменяют состояние базы данных (например, выполняют UPDATE или DELETE запросы). Эта аннотация обычно применяется вместе с @Query, чтобы указать, что метод должен выполнять операцию модификации данных, а не возвращать результат выборки.

#### Основные свойства @Modifying:

1. **clearAutomatically**: Если установлено в true, контекст постоянства будет очищен после выполнения запроса. Это полезно для предотвращения потенциальных проблем с управлением состоянием объектов после выполнения операции модификации.
2. **flushAutomatically**: Если установлено в true, изменения будут автоматически сбрасываться в базу данных перед выполнением запроса.

Пример использования:
```java
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("update User u set u.name = ?1 where u.id = ?2")
    int updateUserName(String name, Long id);

    @Modifying
    @Query("delete from User u where u.id = ?1")
    void deleteUserById(Long id);
}
```

В этом примере, метод `updateUserName` обновляет имя пользователя, а метод `deleteUserById` удаляет пользователя по идентификатору. Оба метода аннотированы @Modifying, чтобы указать, что они изменяют состояние базы данных.

### Основные моменты, которые следует учитывать при использовании @Transactional и @Modifying:

- Методы, аннотированные @Transactional, управляют поведением транзакций, что позволяет контролировать обработку ошибок и управление параллелизмом.
- Методы, аннотированные @Modifying, используются для выполнения операций, которые изменяют данные в базе, и должны использоваться совместно с @Query для явного указания запросов.

Правильное использование этих аннотаций позволяет эффективно управлять транзакциями и изменениями данных в приложениях, обеспечивая целостность и надежность данных.


Аннотация @Transactional в Spring предоставляет мощный и гибкий механизм для управления транзакциями в Java-приложениях. Это позволяет разработчикам сосредоточиться на бизнес-логике, не беспокоясь о явном управлении транзакциями, которое может быть сложным и подверженным ошибкам. Рассмотрим @Transactional более подробно, включая использование, настройки, и нюансы.

### Основные аспекты @Transactional

#### 1. **Propagation (Распространение транзакций)**

Распространение определяет, как метод должен вести себя в отношении существующих транзакций. Вот детальное описание возможных значений:

- **REQUIRED (По умолчанию)**: Если существует текущая транзакция, метод будет выполнен в её рамках. Если транзакции нет, будет создана новая. Это наиболее распространенное поведение, так как оно позволяет методам работать в одном контексте транзакции.
  ```java
  @Transactional(propagation = Propagation.REQUIRED)
  public void someMethod() {
      // логика
  }
  ```

- **REQUIRES_NEW**: Всегда создаёт новую транзакцию. Если текущая транзакция существует, она будет приостановлена.
  ```java
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void someMethod() {
      // логика
  }
  ```

- **SUPPORTS**: Метод будет выполнен в рамках текущей транзакции, если она существует. Если нет, он будет выполнен вне транзакции.
  ```java
  @Transactional(propagation = Propagation.SUPPORTS)
  public void someMethod() {
      // логика
  }
  ```

- **NOT_SUPPORTED**: Метод будет выполнен вне транзакции. Если текущая транзакция существует, она будет приостановлена.
  ```java
  @Transactional(propagation = Propagation.NOT_SUPPORTED)
  public void someMethod() {
      // логика
  }
  ```

- **MANDATORY**: Метод должен быть выполнен в рамках существующей транзакции. Если текущей транзакции нет, будет выброшено исключение.
  ```java
  @Transactional(propagation = Propagation.MANDATORY)
  public void someMethod() {
      // логика
  }
  ```

- **NEVER**: Метод должен быть выполнен вне транзакции. Если текущая транзакция существует, будет выброшено исключение.
  ```java
  @Transactional(propagation = Propagation.NEVER)
  public void someMethod() {
      // логика
  }
  ```

- **NESTED**: Если существует текущая транзакция, метод будет выполнен в рамках вложенной транзакции. Вложенные транзакции поддерживаются на уровне базы данных с помощью сохраненных точек.
  ```java
  @Transactional(propagation = Propagation.NESTED)
  public void someMethod() {
      // логика
  }
  ```

#### 2. **Isolation (Уровень изоляции)**

Изоляция определяет, насколько одна транзакция видна другим. Это помогает управлять проблемами, связанными с параллельным доступом к данным.

- **DEFAULT**: Использует уровень изоляции по умолчанию, заданный в настройках базы данных.
  ```java
  @Transactional(isolation = Isolation.DEFAULT)
  public void someMethod() {
      // логика
  }
  ```

- **READ_UNCOMMITTED**: Минимальный уровень изоляции, позволяющий грязные чтения. Одни транзакции могут видеть незавершенные изменения других транзакций.
  ```java
  @Transactional(isolation = Isolation.READ_UNCOMMITTED)
  public void someMethod() {
      // логика
  }
  ```

- **READ_COMMITTED**: Обеспечивает, что данные, которые читаются транзакцией, были зафиксированы. Предотвращает грязное чтение.
  ```java
  @Transactional(isolation = Isolation.READ_COMMITTED)
  public void someMethod() {
      // логика
  }
  ```

- **REPEATABLE_READ**: Обеспечивает, что данные, которые читаются транзакцией, не изменяются другими транзакциями до её завершения. Предотвращает грязное чтение и неповторяющееся чтение.
  ```java
  @Transactional(isolation = Isolation.REPEATABLE_READ)
  public void someMethod() {
      // логика
  }
  ```

- **SERIALIZABLE**: Самый строгий уровень изоляции, который обеспечивает выполнение транзакций последовательно, предотвращая все типы аномалий чтения.
  ```java
  @Transactional(isolation = Isolation.SERIALIZABLE)
  public void someMethod() {
      // логика
  }
  ```

#### 3. **Timeout (Таймаут транзакции)**

Таймаут определяет максимальное время в секундах, в течение которого транзакция должна завершиться. Если транзакция не завершится в указанный период, она будет откатана.

```java
@Transactional(timeout = 10)
public void someMethod() {
    // логика
}
```

#### 4. **ReadOnly (Только для чтения)**

Указывает, что транзакция предназначена только для чтения данных. Это может помочь оптимизировать производительность, поскольку база данных может применить оптимизации для чтения.

```java
@Transactional(readOnly = true)
public void someMethod() {
    // логика
}
```

#### 5. **RollbackFor и NoRollbackFor (Условия отката транзакции)**

Эти свойства позволяют указать, при каких исключениях транзакция должна быть откатана или не откатана.

- **rollbackFor**: Список исключений, при которых транзакция должна быть откатана.
  ```java
  @Transactional(rollbackFor = {Exception.class})
  public void someMethod() {
      // логика
  }
  ```

- **noRollbackFor**: Список исключений, при которых транзакция не должна быть откатана.
  ```java
  @Transactional(noRollbackFor = {SpecificException.class})
  public void someMethod() {
      // логика
  }
  ```

### Взаимодействие @Transactional с прокси

Spring AOP (Aspect-Oriented Programming) использует прокси для управления транзакциями. Важно учитывать, что методы, аннотированные @Transactional, должны вызываться извне, чтобы прокси смогло их обернуть и управлять транзакцией. Вызов метода из другого метода того же класса не будет обрабатывать транзакцию должным образом.

### Примеры использования @Transactional

#### Пример 1: Управление транзакцией на уровне класса
Если аннотация @Transactional применяется на уровне класса, все методы этого класса будут транзакционными.

```java
@Service
@Transactional
public class MyService {

    public void method1() {
        // логика
    }

    public void method2() {
        // логика
    }
}
```

#### Пример 2: Управление транзакцией на уровне метода
Можно переопределить транзакционные настройки для отдельных методов.

```java
@Service
public class MyService {

    @Transactional(propagation = Propagation.REQUIRED)
    public void method1() {
        // логика
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void method2() {
        // логика
    }
}
```

### Ловушки и рекомендации

1. **Не вызывайте транзакционные методы напрямую из того же класса**: Это обойдет прокси-объект и транзакция не будет управляться.
2. **Не используйте @Transactional для методов, вызываемых при инициализации**: Например, в конструкторах или методах @PostConstruct, так как контекст транзакции еще не создан.
3. **Всегда проверяйте настройки базы данных**: Некоторые настройки изоляции или поведения транзакций могут не поддерживаться вашей СУБД.
4. **Избегайте длительных транзакций**: Длительные транзакции могут блокировать ресурсы и снижать производительность. Разделяйте операции на логические части, если это возможно.

### Заключение

Аннотация @Transactional является мощным инструментом в арсенале разработчиков Spring, позволяя легко управлять транзакциями и обеспечивать целостность данных. Грамотное использование этой аннотации требует понимания основ транзакционного управления и особенностей вашего приложения и базы данных.

### Разберем пример: мы создали метод в сервисе, который вызывает метод из репозитория. Этот метод меняет только одно поле в записи

Если мы например используем просто аннотацию @Transactional и у нас всё работает, это означает, что транзакционный менеджер Spring успешно обрабатывает транзакцию. 
Давайте рассмотрим, почему это происходит и что может пойти не так в определённых сценариях.

### Что происходит в этом случае?

1. **Создание транзакции**: Когда вызывается метод, аннотированный @Transactional, Spring создает транзакцию (если она ещё не существует в текущем контексте).
2. **Вызов метода репозитория**: Внутри транзакции выполняется вызов метода репозитория, который изменяет поле записи в базе данных.
3. **Коммит транзакции**: После завершения работы метода (если не было исключений), транзакция коммитится, то есть изменения фиксируются в базе данных.
4. **Откат транзакции**: Если внутри транзакционного метода возникает исключение, транзакция будет откатана, и изменения не будут сохранены.

### Почему всё работает?

- **Одно поле**: Изменение только одного поля в записи — это простая операция, которая, как правило, не требует сложного управления транзакциями.
- **Метод репозитория**: Репозитории в Spring Data JPA автоматически поддерживают транзакции. Если вы используете стандартные методы репозитория (например, `save`, `delete`), они уже работают в рамках транзакции, инициированной вызовом метода сервиса.
- **Короткая транзакция**: Если метод выполняется быстро и не содержит длительных операций, вероятность возникновения проблем (например, таймаутов или конфликтов блокировок) минимальна.

### Потенциальные проблемы и что может пойти не так?

Хотя наш текущий подход работает, есть несколько потенциальных ловушек, о которых стоит знать:

1. **Вызов метода из того же класса**: Если аннотированный @Transactional метод вызывает другой метод того же класса, который также должен быть транзакционным, транзакция может не обрабатываться правильно. Это связано с тем, что Spring использует прокси для управления транзакциями, и вызовы внутри одного класса не проходят через этот прокси.
   ```java
   @Service
   public class MyService {
       @Transactional
       public void outerMethod() {
           innerMethod(); // Этот вызов не будет обрабатываться прокси
       }

       @Transactional
       public void innerMethod() {
           // логика
       }
   }
   ```

2. **Откат транзакции**: По умолчанию @Transactional откатывает транзакцию только для unchecked exceptions (наследники RuntimeException). Если возникает checked exception, транзакция не будет откатана, если вы явно не укажете это поведение.
   ```java
   @Transactional(rollbackFor = Exception.class)
   public void myMethod() throws Exception {
       // логика
   }
   ```

3. **Параллельное выполнение**: В более сложных сценариях, когда транзакции выполняются параллельно, могут возникнуть проблемы с блокировками или целостностью данных. В таких случаях важно правильно выбирать уровни изоляции транзакций.

4. **Долгие транзакции**: Длительные транзакции могут блокировать ресурсы и негативно влиять на производительность приложения. Избегайте выполнения долгих операций (например, запросов к удалённым сервисам) внутри транзакционных методов.

### Пример правильного использования

```java
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void updateUser(Long userId, String newName) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setName(newName);
        userRepository.save(user);
    }
}
```

В этом примере:

1. Метод `updateUser` аннотирован @Transactional.
2. Метод выполняет операцию поиска пользователя и обновления его имени в рамках одной транзакции.
3. Если возникает исключение (например, пользователь не найден), транзакция будет откатана.

### Заключение

Использование аннотации @Transactional для методов, которые вызывают методы репозиториев, является стандартной практикой и обеспечивает корректное управление транзакциями в большинстве случаев. Однако важно учитывать потенциальные ловушки и гарантировать, что методы вызываются правильным образом для обеспечения надёжного и эффективного управления транзакциями.

### Создание базы данных и её начальное заполнение при запуске приложения

Есть множество способов организовать создание базы данных и её начальное заполнение при запуске приложения.
Выбор метода зависит от используемых технологий и требований к проекту.

Вот некоторые из популярных подходов:

1. **Liquibase или Flyway**:
    - Если вы уже используете Liquibase (или альтернативный инструмент, такой как Flyway), можно создать специфический changeset или миграцию, который создает начальную структуру БД и добавляет начальные данные.
    - При запуске приложения Liquibase или Flyway автоматически применит эти миграции, если они ещё не были применены.

2. **Framework-специфичные инструменты**:
    - Многие современные фреймворки предоставляют механизмы для инициализации и миграции БД.
    - Например, в **Django** есть система миграций, а в **Ruby on Rails** — механизм миграций и seeds.

3. **ORM (Object-Relational Mapping)**:
    - Некоторые ORM позволяют автоматически создавать схему БД на основе определенных моделей. Например, в **Hibernate** есть свойство `hbm2ddl.auto`, которое может быть настроено на автоматическое создание или обновление схемы.
    - Многие ORM также предоставляют средства для заполнения БД начальными данными.

4. **SQL скрипты**:
    - Напишите SQL скрипты для создания таблиц и заполнения их данными, затем выполните их при первом запуске приложения.

5. **Контейнеризация и системы оркестрации**:
    - Если вы используете контейнеры, например Docker, можно настроить запуск определенных SQL скриптов или других инструментов при инициализации контейнера с БД.

6. **Приложение-инициализатор**:
    - Создайте отдельный компонент или модуль в вашем приложении, который будет проверять, инициализирована ли БД, и, если нет, создавать схему и заполнять начальными данными.

При выборе метода следует учитывать потребности проекта, инфраструктурные ограничения и ваш опыт работы с выбранными инструментами. В любом случае, перед автоматическим применением изменений к продакшен-БД рекомендуется тщательно тестировать процесс на тестовом окружении.


**Liquibase** — это инструмент для управления версиями баз данных, который позволяет следить за изменениями схемы базы данных и применять их последовательно. Основная идея заключается в том, чтобы сохранять историю изменений БД в виде последовательности миграций (changesets), которые можно применять и отменять.

**Принципы работы:**
1. **Файлы миграции**: Изменения БД описываются в специальных файлах (обычно XML, но могут быть и в форматах YAML, JSON и SQL).
2. **Changeset**: Основная единица изменения в Liquibase. Каждый changeset имеет уникальный идентификатор, который используется для отслеживания его применения к базе данных.
3. **DATABASECHANGELOG**: Таблица, создаваемая Liquibase в вашей БД, которая отслеживает, какие changesets были применены и когда.
4. **MD5 Checksums**: Liquibase создает контрольные суммы для каждого changeset, чтобы определить, изменился ли он после применения.
5. **Rollbacks**: Liquibase предоставляет возможность определить, как отменить примененный changeset, если это потребуется.

**Основные шаги для реализации миграции базы данных с помощью Liquibase:**
1. **Настройка Liquibase**: Установите Liquibase и настройте его для вашей базы данных.
2. **Создание файла миграции**: Создайте файл миграции (например, в формате XML) и опишите в нем желаемые изменения.
3. **Описание changesets**: В файле миграции определите один или несколько changesets, каждый из которых описывает определенное изменение в базе данных.
4. **Применение миграции**: Запустите Liquibase для применения changesets к вашей базе данных. При успешном применении changesets записываются в таблицу DATABASECHANGELOG.
5. **Откат миграции (если необходимо)**: Если вы допустили ошибку или хотите откатить изменения, вы можете использовать Liquibase для отката определенного changeset или группы changesets.
6. **Повторение**: По мере развития вашей базы данных вы будете добавлять новые changesets в файлы миграции и применять их с помощью Liquibase.


### changeSet

В контексте Liquibase термин "changeSet" используется для обозначения атомарного изменения в базе данных. Каждый changeSet описывает одно или несколько действий, которые нужно выполнить в базе данных, например, создать таблицу, добавить столбец или вставить данные. Liquibase отслеживает, какие changeSets были применены, чтобы гарантировать, что они выполнятся только один раз и в правильном порядке.

**Структура changeSet**

Основные атрибуты changeSet в Liquibase:

- `id`: Уникальный идентификатор в рамках файла миграции.
- `author`: Имя автора, обычно используется для идентификации того, кто создал changeSet.
- `changes`: Действия или изменения, которые нужно применить к базе данных.

**Пример changeSet в формате XML:**

```xml
<changeSet id="1" author="john_doe">
    <createTable tableName="new_table">
        <column name="id" type="int" autoIncrement="true" primaryKey="true"/>
        <column name="name" type="varchar(255)"/>
    </createTable>
</changeSet>
```

В этом примере создаётся новая таблица `new_table` с двумя столбцами: `id` и `name`. Идентификатор `id` служит первичным ключом и настроен на автоинкремент.

**Как это работает:**

1. **Проверка состояния**: Когда Liquibase выполняется, он сначала проверяет таблицу `DATABASECHANGELOG` в вашей базе данных, чтобы определить, какие changeSets уже были применены.

2. **Применение changeSets**: Если changeSet ещё не применён, Liquibase выполнит действия, описанные в нём. В приведённом выше примере Liquibase создаст новую таблицу.

3. **Регистрация изменений**: После успешного применения changeSet записывается в `DATABASECHANGELOG`, включая ID, имя автора и контрольную сумму. Это предотвращает повторное применение того же changeSet и позволяет отслеживать историю изменений.

**Откат изменений:**

Liquibase также поддерживает откат изменений. Вы можете определить, как отменить изменения в каждом changeSet, или позволить Liquibase сделать это автоматически для некоторых типов изменений. Однако не все типы изменений могут быть откачены автоматически, поэтому для некоторых changeSets вам может потребоваться явно указать, как выполнять откат.

**Пример отката:**

Для изменения, внесённого выше, откат может быть автоматическим, если Liquibase поддерживает откат данного типа изменения (создание таблицы). Для сложных изменений может потребоваться определить собственную логику отката.

Использование changeSets в Liquibase — это мощный способ управления миграциями базы данных, позволяющий разработчикам точно контролировать и версионировать изменения, вносимые в схему базы данных.

Liquibase контролирует и следит за изменениями, которые были применены к базе данных. Для этого он использует таблицу `DATABASECHANGELOG`. Каждый раз, когда Liquibase применяет `changeSet`, запись о нем добавляется в эту таблицу. Если `changeSet` уже был применен к базе данных, Liquibase пропустит его при следующем выполнении. Таким образом, дубликаты не будут добавлены.

Для того чтобы быть уверенным в том, что изменения будут применены только один раз, убедитесь, что каждый `changeSet` имеет уникальный идентификатор (`id`) и автора (`author`). Эти два атрибута вместе используются Liquibase для определения уникальности `changeSet`.

Если вы хотите вручную проверить, было ли применено определенное изменение, вы можете посмотреть в таблицу `DATABASECHANGELOG` и найти запись с соответствующим `id` и `author`.

Тем не менее, есть ситуации, когда вы можете захотеть проверить наличие определенных данных в таблице перед их добавлением. В этом случае вы можете использовать условную логику в вашем `changeSet`. Например, вы можете использовать предварительное условие (`preConditions`), чтобы проверить наличие данных перед их вставкой.

Пример:

```xml
<changeSet id="2" author="authorName">
    <!-- Precondition to check if Admin role already exists -->
    <preConditions onFail="MARK_RAN">
        <not>
            <sqlCheck expectedResult="0">SELECT COUNT(*) FROM roles WHERE name='Admin'</sqlCheck>
        </not>
    </preConditions>

    <!-- Insert roles -->
    <insert tableName="roles">
        <column name="id" value="1"/>
        <column name="name" value="Admin"/>
    </insert>
</changeSet>
```

В этом примере, если роль `Admin` уже существует, изменение будет помечено как выполненное (`MARK_RAN`), и действительные изменения в базу данных не будут внесены.

Таким образом, при использовании Liquibase, у вас уже есть встроенный механизм, который гарантирует, что каждый `changeSet` будет применен только один раз. Если вы хотите добавить дополнительные проверки, вы можете использовать `preConditions`.


### РЕГУЛЯРНЫЕ ВЫРАЖЕНИЯ

### Введение в регулярные выражения

Регулярные выражения (RegEx, RegExp) — это мощный инструмент для работы с текстом, позволяющий искать, сравнивать и заменять строки по заданным шаблонам. Они используются в различных языках программирования и текстовых редакторах. Основная идея регулярных выражений заключается в использовании специальных символов и конструкций для описания шаблонов текста.

### Принцип работы

Регулярные выражения состоят из символов и метасимволов. Символы представляют собой обычные символы текста (буквы, цифры и т.д.), а метасимволы имеют специальное значение и определяют шаблоны.

#### Основные метасимволы:

1. **Точка (.)**: обозначает любой одиночный символ, кроме символа новой строки.
   - Пример: шаблон `a.b` совпадет с "aab", "acb", "a1b", но не с "ab" или "a\nb".

2. **Квантификаторы**:
   - `*` — совпадение с предыдущим символом 0 или более раз.
      - Пример: `ab*c` совпадет с "ac", "abc", "abbc" и т.д.
   - `+` — совпадение с предыдущим символом 1 или более раз.
      - Пример: `ab+c` совпадет с "abc", "abbc", но не с "ac".
   - `?` — совпадение с предыдущим символом 0 или 1 раз.
      - Пример: `ab?c` совпадет с "ac" и "abc".
   - `{n}` — совпадение с предыдущим символом ровно n раз.
      - Пример: `a{3}` совпадет с "aaa", но не с "aa".
   - `{n,m}` — совпадение с предыдущим символом от n до m раз.
      - Пример: `a{2,4}` совпадет с "aa", "aaa" и "aaaa", но не с "a" или "aaaaa".

3. **Классы символов**:
   - `[abc]` — любой символ из множества, например, a, b или c.
      - Пример: `b[aeiou]t` совпадет с "bat", "bet", "bit", "bot", "but".
   - `[a-z]` — любой символ из диапазона, например, от a до z.
      - Пример: `[0-9]` совпадет с любой цифрой.
   - `[^abc]` — любой символ, кроме указанных.
      - Пример: `[^0-9]` совпадет с любым символом, кроме цифры.

4. **Якоря**:
   - `^` — начало строки.
      - Пример: `^Hello` совпадет с "Hello" в начале строки.
   - `$` — конец строки.
      - Пример: `world$` совпадет с "world" в конце строки.

5. **Группировка и захват**:
   - `()` — группировка символов и захват совпадения для последующего использования.
      - Пример: `(abc)+` совпадет с "abc", "abcabc" и т.д.

6. **Или (альтернация)**:
   - `|` — оператор "или".
      - Пример: `a|b` совпадет с "a" или "b".

### Примеры регулярных выражений

1. **Поиск email адресов**:
   ```regex
   [a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}
   ```
   - Объяснение: Ищет строки, соответствующие шаблону email адреса.

2. **Поиск всех слов в строке**:
   ```regex
   \b\w+\b
   ```
   - Объяснение: `\b` обозначает границу слова, `\w+` — одно или более буквенно-цифровых символов.

3. **Проверка номера телефона (формат: XXX-XXX-XXXX)**:
   ```regex
   \d{3}-\d{3}-\d{4}
   ```
   - Объяснение: `\d` обозначает цифру, `{3}` — ровно три раза, `-` — дефис.

4. **Поиск HTML тегов**:
   ```regex
   <([a-zA-Z]+)([^<]+)*(?:>(.*)<\/\1>|\s+\/>)
   ```
   - Объяснение: Ищет HTML теги с возможными атрибутами и содержимым.


### Пример на Java

Для работы с регулярными выражениями в Java используется класс `Pattern` и `Matcher` из пакета `java.util.regex`.

#### Пример 1: Поиск всех слов в строке

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        String text = "This is a sample text with several words.";
        String patternString = "\\b\\w+\\b";

        // Компиляция регулярного выражения в объект Pattern
        Pattern pattern = Pattern.compile(patternString);

        // Создание объекта Matcher для поиска совпадений в тексте
        Matcher matcher = pattern.matcher(text);

        // Поиск и вывод всех совпадений
        while (matcher.find()) {
            System.out.println("Found word: " + matcher.group());
        }
    }
}
```

#### Объяснение:
- `\\b` — граница слова.
- `\\w+` — одна или более буквенно-цифровых символов.
- `\\b` — граница слова.

#### Пример 2: Проверка формата email адреса

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static void main(String[] args) {
        String[] emails = {
            "user@example.com",
            "user.name@domain.com",
            "user.name@domain.co.in",
            "user@domaincom",
            "user@.com.my"
        };

        // Регулярное выражение для email
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        // Компиляция регулярного выражения
        Pattern pattern = Pattern.compile(emailPattern);

        // Проверка каждого email на соответствие
        for (String email : emails) {
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                System.out.println(email + " is a valid email.");
            } else {
                System.out.println(email + " is not a valid email.");
            }
        }
    }
}
```

#### Объяснение:
- `^[a-zA-Z0-9._%+-]+` — начало строки, за которым следуют один или более допустимых символов для локальной части email.
- `@[a-zA-Z0-9.-]+` — символ "@" и один или более допустимых символов для домена.
- `\\.[a-zA-Z]{2,}$` — точка и два или более буквенных символов для доменной зоны, конец строки.

#### Пример 3: Замена шаблона в строке

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplace {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog.";
        String patternString = "\\bfox\\b";
        String replacement = "cat";

        // Компиляция регулярного выражения
        Pattern pattern = Pattern.compile(patternString);

        // Создание объекта Matcher
        Matcher matcher = pattern.matcher(text);

        // Замена всех совпадений
        String newText = matcher.replaceAll(replacement);
        
        System.out.println("Original text: " + text);
        System.out.println("Modified text: " + newText);
    }
}
```

#### Объяснение:
- `\\bfox\\b` — шаблон для слова "fox", окруженного границами слова.
- `replaceAll` — метод, заменяющий все совпадения шаблона на указанную строку.

### Заключение

Регулярные выражения в Java являются мощным инструментом для обработки строк. Классы `Pattern` и `Matcher` обеспечивают функциональность для поиска, проверки и замены текста по заданным шаблонам. Эти примеры демонстрируют основные способы использования регулярных выражений в Java.
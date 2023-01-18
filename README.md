# page-counter-cli
### Приложение (CLI-версия) для подсчета количества страниц в документах в структуре директорий.

Требования: Java 17+, Apache Maven 3.x.x+

Сборка приложения:
```
mvn install
```

Запуск:
```
java -jar target/page-counter.jar ПУТЬ-К-КОРНЕВОЙ-ДИРЕКТОРИИ
```

Примеры:

```
java -jar target/page-counter.jar C:/Users/username/Documents
```
```
java -jar target/page-counter.jar /home/username/Documents
```

При корректной отработке сценария вы увидите результат вроде следующего в stdout:
```
Documents: 4
Pages: 201 
```

Если указанная вами директория отсутствует, будет выведен stack trace исключения в stderr.
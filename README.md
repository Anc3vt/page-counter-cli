# page-counter-cli
### Приложение (CLI-версия) для подсчета количества страниц в документах в структуре директорий.

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
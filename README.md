## Задание 7
Выбери базу данных на свой вкус (рекомендую реляционную Postgres).

Решение сделай на уровне Java. Я бы рекомендовал sql-запрос на чистом JDBC. Но, безусловно, есть и другие варианты.

Дана таблица employeesAge
```
id employeeName age
0 Кирилл 18
1 Саша 20
2 Катя 25
```
Выведи всех сотрудников, чей возраст больше 20.


Дана таблица departmentSalary
```
id employeeName departmentName salary
0 Кирилл IT 30000
1 Иван IT 20000
2 Маша HR 40000
```
Выведи среднюю зарплату по каждому отделу
```
departmentName averageSalary
IT 25000
HR 40000
```

Даны таблицы departmentEmployee
```
id employeeName departmentId
0 Кирилл 1
1 Иван 1
2 Маша 2
```

и departmentLocation
```
departmentId departmentName location
1 IT Саратов
2 HR Москва
```

Для каждого сотрудника выведи имя его департамента и локацию работы
```
employeeName departmentName location
Кирилл IT Саратов
Иван IT Калифорния
Маша HR Москва
```


База данных postgresql запускается в докере.
Файл init.sql содержит стуктуру и данные для бд. Можно внести изменения, чтобы бд создавалась с другими данными

Запуск докера 
```
cd postgres-docker/
sudo docker-compose up -d
```

Также в папке postgres-docker нужно создать файл `.env` такого содержания, где указать имя бд, юзера и пароль 
```
POSTGRES_DB=dbname
POSTGRES_USER=dbuser
POSTGRES_PASSWORD=dbpass
```

Сборка - `javac -cp "src/main/java:lib/*" src/main/java/ru/sgu/Main.java`

Запуск - `java -cp "src/main/java:lib/*" ru.sgu.Main`

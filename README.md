## Задание 4
#### Задача 1
На вход подаются даты в формате "год месяц день". Вывести число дней, которое прошло между минимальной и максимальной датой.

Ввод
```
2010 1 1
2022 12 31
```

Вывод
```
4747
```


Сборка - `javac src/main/java/ru/sgu/DateCalculator.java`


Запуск - `java -cp src/main/java/ ru.sgu.DateCalculator`


#### Задача 2
На вход подается имя дня недели и количество дней. Выведи, какой день недели будет через заданное количество дней. Количество дней >= 0.

Ввод
```
sunday 10
```

Вывод
```
wednesday
```

Сборка - `javac src/main/java/ru/sgu/DayOfWeek.java src/main/java/ru/sgu/DayOfWeekCalculator.java`

Запуск - `java -cp src/main/java/ ru.sgu.DayOfWeekCalculator`



#### Задача 3
В конец строки 100 000 раз дописывается строчка, состоящая из 10 рандомных символов. При каждой записи строчка из 10 символов генерируется заново.

Выбери из существующих классов java.lang.* такую реализацию строки, которая будет наиболее оптимальной для использования в таком алгоритме. 

Докажи, что она будет быстрее.


Сборка - `javac src/main/java/ru/sgu/StringAppendBenchmark.java`

Запуск - `java -cp src/main/java/ ru.sgu.StringAppendBenchmark`

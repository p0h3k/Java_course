## Задание 6
#### Задача 1
Два потока инкрементят переменную 100 000 раз. Измени программу, чтобы значение переменной в конце работы всегда было одинаковым (и верным).

Сборка - `javac src/main/java/ru/sgu/SynchronizedCounter.java`

Запуск - `java -cp src/main/java/ ru.sgu.SynchronizedCounter`


#### Задача 2
На вход поступает число N. Посчитай N-е число Фибоначчи через ForkJoinPool.


Сборка - `javac src/main/java/ru/sgu/Fibonacci.java`

Запуск - `java -cp src/main/java ru.sgu.Fibonacci`


#### Задача 3
Есть продюсер, который кладет данные в очередь (название еды + число килокалорий).

Есть несколько потребителей, которые забирают данные из очереди. При заборе потребитель выводит, какой товар он только что съел, и сколько килокалорий суммарно он употребил.

Сборка - `javac src/main/java/ru/sgu/Consumer.java src/main/java/ru/sgu/FoodItem.java src/main/java/ru/sgu/Producer.java src/main/java/ru/sgu/FoodProductionSimulation.java`

Запуск - `java -cp src/main/java ru.sgu.FoodProductionSimulation`

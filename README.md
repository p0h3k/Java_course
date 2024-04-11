## Задание 5
#### Задача 1 
Дано на входе.


ФИОВладельца названиеКомпании рейтингАкции
```
Ионов Кирилл Игоревич Nvidia 10
Петров Петр Apple 9
```

Гарантируется что строчки непустые, данные идут именно в таком порядке, рейтинг акции от 1 (не рекомендована к покупке) до 10 (надо было брать вчера).

Выведи строчки. отсортировав акции по убыванию рейтинга, затем по фамилии во возрастанию, имени по убыванию, отчеству по возрастанию. В выводе не должно присутствовать дубликатов.

Данные берутся из файла input.txt, который лежит в папке data в корне проекта.

Сборка `javac src/main/java/ru/sgu/StockReader.java src/main/java/ru/sgu/StockEntry.java`

Запуск `java -cp src/main/java ru.sgu.StockReader`


#### Задача 2
На вход подается название директории (относительный путь от места запуска программы до директории) и имя целевой строки.


Требуется обойти всю директорию рекурсивно, найти объекты. в имени которых присутствует целевая строка как подстрока и заархивировать их.

Формат архива на ваше усмотрение.
Для тестирования использовалась директория с файлами directory. Готовый архив = directory.zip
	
Пример.

Входные данные
```
directory passport

Структура каталога
directory -> passport -> 1.txt
directory -> passport -> 2
directory -> passport -> 3.md5
directory -> 1passport2.txt
directory -> pass2port.bin
directory -> passp0rt.sh
directory -> 2138123PASSPORT214124124
```

Вывод
```
архив directory

Структура архива
passport -> 1.txt
passport -> 2
passport -> 3.md5
1passport2.txt
2138123PASSPORT214124124
```

Сборка `javac src/main/java/ru/sgu/DirectoryArchiver.java`
Запуск `java -cp src/main/java ru.sgu.DirectoryArchiver directory passport`


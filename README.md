## Задача 2
#### Подзадача 1
Выбери объект из реального мира и реализуй его в в виде класса (ООП). У него будут поля (хранимые состояния) и методы (регулирующие поведение объекта).


Класс реализует интерфейсы (прилагательные, которыми можно описать объект) и от него наследуются классы, расширяющие поведение объекта.

Т.е. сделай свой класс, который расширяет другой твой класс, в котором реализуется один из твоих интерфейсов.

Пример

```
interface 2DFigure {getPerimeter(); getSquare();}

abstract class AbstractFigure {abstract String getNameOfFigure();}

class Line extends AbstractFigure implements 2DFigure
class Circle extends AbstractFigure implements 2DFigure
class Triangle extends AbstractFigure implements 2DFigure
class Rectangle extends AbstractFigure implements 2DFigure
```

#### Подзадача 2
В своем классе реализуй методы equals(), hashCode(), compareTo(), toString(), поверхностной и глубокой копии. Разберись, зачем они нужны.


#### Подзадача 3
Продемонстрируй работу полиморфизма на реализованных классах. В моем примере классы Line, Circle, Rectangle, Triangle должны реализовать методы getPerimeter() и getSquare() для подсчета периметра и площади соответственно.

Соответственно, если я сложу их в контейнер List<2DFigure> list и для каждого элемента figure вызову figure.getPerimeter() и figure.getSquare(), я получу разные результаты


Сборка - `javac src/main/java/ru/sgu/Teapot.java src/main/java/ru/sgu/TeapotInterface.java src/main/java/ru/sgu/ElectricTeapot.java src/main/java/ru/sgu/Main.java`

Запуск - `java -cp src/main/java/ ru.sgu.Main`


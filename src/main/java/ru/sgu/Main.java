package ru.sgu;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ElectricTeapot teapot1 = new ElectricTeapot(1000, "черный", 1500);
        ElectricTeapot teapot2 = new ElectricTeapot(1500, "черный", 1500);
        ElectricTeapot teapot3 = new ElectricTeapot(1000, "белый", 1500);
	ElectricTeapot teapot4 = new ElectricTeapot(1000, "черный", 1500);

        System.out.println(teapot1);
	System.out.println(teapot2);
	System.out.println(teapot3);
	System.out.println(teapot4);

        System.out.println("Чайник 1 равен Чайнику 3? " + teapot1.equals(teapot3));
	System.out.println("Чайник 1 равен Чайнику 2? " + teapot1.equals(teapot2));
	System.out.println("Чайник 1 равен Чайнику 4? " + teapot1.equals(teapot4));

        System.out.println("HashCode чайника 1: " + teapot1.hashCode());
        System.out.println("HashCode чайника 3: " + teapot3.hashCode());
	System.out.println("HashCode чайника 2: " + teapot2.hashCode());
	System.out.println("HashCode чайника 4: " + teapot4.hashCode());

        System.out.println("Сравнение Чайника 1 и Чайника 2: " + teapot1.compareTo(teapot2));
	System.out.println("Сравнение Чайника 1 и Чайника 3: " + teapot1.compareTo(teapot3));

        ElectricTeapot teapotCopy = teapot1.copy();
        System.out.println("Копия Чайника 1: " + teapotCopy);

        teapotCopy.color = "красный";
        System.out.println("Оригинальный Чайник 1 после изменения копии: " + teapot1);
        System.out.println("Измененная копия Чайника 1: " + teapotCopy);

	List<TeapotInterface> teapots = new ArrayList<>();
	teapots.add(teapot1);
	teapots.add(teapot2);
	teapots.add(teapot3);
	teapots.add(teapot4);
	teapots.add(teapotCopy);

	for (TeapotInterface teapot : teapots) {
		teapot.boilWater();
		System.out.println(teapot);
        }
    }
}

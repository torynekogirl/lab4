package com.company.pavel;

import com.company.pavel.equations.MyEquation;

import java.util.Scanner;

/*Відповіді на питання
1. Пакет Java - це механізм організації классів Java подібний просторам імен або модулям.
Пакети можуть зберігатися в стислих файлах, які називають JAR,  що дозволяють класам завантажуватися як група,
а не по черзі. Зазвичай пакети використовують для організації класів, що належать до однієї категорії
або надають схожий функціонал
2. Статичні атрибути классу є спільними для всіх екземплярів классу, отримати до нього доступ можна
без створення екземплярів классу, а через назву классу, якщо змінити в одному екземплярі значення такого атрибуту,
то значення буде змінене у всіх екземплярах. Статичні атрибути ініціалізуються в момент компіляції, в той момент, як
звичайні атрибути під час створення екземпляру класу.
3. Статичні методи є спільними для всіх екземпялрів цього классу, отримати доступ до нього можна без створенння
екземпялрів классу, а через назву класу. Крім того, не можна визвати статичний метод в звичайному методі і навпаки.
Статичний метод не має доступу до нестатичних атрибутів класу.

*/

/**
 * @author PavelGozhii
 * @variant 6
 * @lab 4
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x = ");
        MyEquation.setX(scanner.nextDouble());
        System.out.println(MyEquation.staticCalculate(1, 2, 3));

        MyEquation myEquation = new MyEquation();
        myEquation.startProcess();
    }
}

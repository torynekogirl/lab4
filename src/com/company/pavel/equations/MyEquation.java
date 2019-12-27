package com.company.pavel.equations;

import java.util.Scanner;

import static java.lang.Math.PI;
import static java.lang.Math.atan;
import static java.lang.Math.log;
import static java.lang.Math.sqrt;


public class MyEquation implements Equation {

    private static double x;

    private double b;

    private double a;

    private double y;

    public MyEquation() {

    }

    public MyEquation(double x, double b, double a, double y) {
        this.x = x;
        this.b = b;
        this.a = a;
        this.y = y;
    }

    public static double getX() {
        return x;
    }

    public static void setX(double x) {
        MyEquation.x = x;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double calculate() {
        double numerator = sqrt(x + b - a) + log(y);
        double denominator = atan(b + a);
        return numerator / denominator;
    }

    public static double staticCalculate(double b, double a, double y) {
        double numerator = sqrt(x + b - a) + log(y);
        double denominator = atan(b + a);
        return numerator / denominator;
    }

    @Override
    public void startProcess() {
        Scanner scanner = new Scanner(System.in);
        MyEquation myEquation = new MyEquation();
        boolean sqrtExpression;
        boolean lnExpression;
        boolean arctgExpression;
        boolean denominatorExpression;

        do {
            System.out.println("Enter variables: ");
            System.out.print("a = ");
            myEquation.setA(scanner.nextDouble());
            System.out.print("b = ");
            myEquation.setB(scanner.nextDouble());
            System.out.print("x = ");
            setX(scanner.nextDouble());
            System.out.print("y = ");
            myEquation.setY(scanner.nextDouble());

            sqrtExpression = getX() + myEquation.getB() - myEquation.getA() < 0;
            if (sqrtExpression) {
                System.out.println("x + b - a must be greater than zero or equal zero");
            }
            lnExpression = myEquation.getY() <= 0;
            if (lnExpression) {
                System.out.println("y must be greater than zero");
            }
            arctgExpression = (myEquation.getA() + myEquation.getB()) > PI / 2.0
                    || (myEquation.getA() + myEquation.getB()) < -PI / 2.0;
            if (arctgExpression) {
                System.out.println("Interval for (a+b) is {-p/2;p/2}");
            }
            denominatorExpression = Math.atan(myEquation.getA() + myEquation.getB()) == 0;
            if (denominatorExpression) {
                System.out.println("arctg(a + b) cannot be equal zero");
            }
        } while (sqrtExpression || lnExpression || arctgExpression || denominatorExpression);
        System.out.println("Result = " + myEquation.calculate());
        System.out.println("Calculating by for loop: ");
        myEquation.calculateAndPrintByForLoop(-10.0 - 2.5 * 5.0, 5.0 + 1.2 * 5.0, 0.5 + (5.0 / 20.0));
        System.out.println("Calculating by while loop: ");
        myEquation.calculateAndPrintByWhileLoop(-10.0 - 2.5 * 5.0, 5.0 + 1.2 * 5.0, 0.5 + (5.0 / 20.0));
    }

    private double calculate(double x) {
        double numerator = sqrt(x + b - a) + log(y);
        double denominator = atan(b + a);
        return numerator / denominator;
    }

    private static double staticCalculate(double x, double b, double a, double y) {
        double numerator = sqrt(x + b - a) + log(y);
        double denominator = atan(b + a);
        return numerator / denominator;
    }


    @Override
    public void calculateAndPrintByForLoop(double start, double end, double step) {
        for (; start < end; start += step) {
            System.out.println(calculate(start));
        }
    }

    @Override
    public void calculateAndPrintByWhileLoop(double start, double end, double step) {
        while (start <= end) {
            System.out.println(calculate(start));
            start += step;
        }
    }


    @Override
    public String toString() {
        return "MyEquation{" +
                "x=" + x +
                ", b=" + b +
                ", a=" + a +
                ", y=" + y +
                '}';
    }
}

package com.company.pavel.equations;

public interface Equation {

    double calculate();

    void startProcess();

    void calculateAndPrintByForLoop(double start, double end, double step);

    void calculateAndPrintByWhileLoop(double start, double end, double step);
}

package com.company;

import static java.lang.Math.abs;

public class Metoda_bisekcji {

    double a = -3;
    double b = -1;
    double e = 0.01;
    double xsr = (a+b)/2;
    int iteracja = 1;


    double funkcja(double x)
    {
        return x*x*x+2*x*x+6;
    }
    void warunek_konieczny()
    {
        if(funkcja(a)*funkcja(b)<0)
        {
            System.out.println("Warunek konieczny spełniony");
        }
        else
        {
            System.out.println("Warunek konieczny nie spełniony");
        }
    }

    void przedzial()
    {
        if(funkcja(xsr)*funkcja(a)<0)
        {
            b = xsr;
            xsr = (a+b)/2;

        }
        else if(funkcja(xsr)*funkcja(a)>0){
            a = xsr;
            xsr = (a+b)/2;
        }
        else
        {
            System.out.println("Rozwiązaniem dla e = " + e + " xsr = "+ xsr);
        }
    }

    void oblicz()
    {

        do
        {
            warunek_konieczny();
            przedzial();
            System.out.println(xsr);
            System.out.println("iteracja = "+ iteracja);
            if(abs(funkcja(xsr))>e)
            {
                iteracja++;
                oblicz();
            }
            else{
                System.out.println("Warunek stopu spełniony rozwiązaniem dla e = " + e + " xsr = "+ xsr);
                break;
            }

        }while(abs(funkcja(xsr))>e);

    }

}


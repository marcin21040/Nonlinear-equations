package com.company;

import static java.lang.Math.abs;

public class Metoda_stycznych {

    double a = 1;
    double b = 3;
    double e = 0.01;
    int iteracja = 1;
    double xi[] = new double[1000];
    int i = 0;


    double funkcja(double x)
    {
        return x*x*x+2*x*x-22;
    }

    double funkcja_pochodnej_I(double x)
    {
        return 3*x*x+4*x;
    }

    double funkcja_pochodnej_II(double x)
    {
        return 6*x+4;
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
    void warunek_zbieżnosci()
    {
        if(funkcja_pochodnej_I(a)*funkcja_pochodnej_I(b)>=0 && funkcja_pochodnej_II(a)*funkcja_pochodnej_II(b)>=0)
        {
            System.out.println("warunek zbieznosci spełniony");
        }
        else
        {
            System.out.println("warunek zbieznosci nie spełniony");
        }
    }

    void punkt_startowy()
    {
        if(funkcja(a)>=0 && funkcja_pochodnej_II(a)>=0)
        {
            xi[0] = a;
        }
        else if(funkcja(a)<=0 && funkcja_pochodnej_II(a)<=0)
        {
            xi[0] = a;
        }
        else
        {
            xi[0] = b;
        }
    }

    void oblicz()
    {
        do
        {
            punkt_startowy();
            warunek_konieczny();
            warunek_zbieżnosci();
            xi[i+1] = xi[i] - funkcja(xi[i])/funkcja_pochodnej_I(xi[i]);
            System.out.println(xi[i+1]);
            System.out.println("iteracja = "+ iteracja);
            if(abs(funkcja(xi[i+1])) < e || abs(xi[i+1]-xi[i]) < e)
            {
                System.out.println("Warunek stopu spełniony rozwiązaniem dla e = " + e + " x"+iteracja+" = " + xi[i+1]);
                break;
            }
            else{
                iteracja++;
                i++;
                oblicz();
                if(abs(funkcja(xi[i+1])) < e || abs(xi[i+1]-xi[i]) < e)
                {
                    break;
                }
            }
        }while(abs(funkcja(xi[i+1])) < e || abs(xi[i+1]-xi[i]) < e);

    }
}

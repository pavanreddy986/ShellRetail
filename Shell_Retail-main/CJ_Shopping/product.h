#include<bits/stdc++.h>
using namespace std;
#ifndef PRODUCT_H
#define PRODUCT_H
class product
{
    protected:
        string name;
        int price;
        int number;
        string category;
    public:
        product(string, string, int, int);
        string get_name();
        int get_price();
        int get_number();
        string get_category();
        void Print();
};
#endif
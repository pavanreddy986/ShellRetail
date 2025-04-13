#include <bits/stdc++.h>
using namespace std;
#include "product.h"
product :: product( string cat, string ne, int pr, int num)
{
    category = cat;
    name = ne;
    number = num;
    price = pr;
}

string product :: get_name()    //returns name.
{ 
    return name;
}

int product :: get_price()   //returns price.
{
    return price;
}

int product :: get_number()   //returns number.
{
    return number;
}
string product :: get_category(){
    return category;
}
void product :: Print()    //To print the desired output.
{
    cout << category << " " << name << " " << number << " " << price << endl;
}
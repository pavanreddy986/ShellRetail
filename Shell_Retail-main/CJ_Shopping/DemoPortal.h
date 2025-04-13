#include<bits/stdc++.h>
using namespace std;
#ifndef DEMOPORTAL_H
#define DEMOPORTAL_H
#include "product.h"
class DemoPortal{
    private:
        int portalID=1;
    public:
        vector<string> spl(string);
        void processUserCommand(string);
        void checkResponse(map<string,string>);
};
#endif
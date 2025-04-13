#include<bits/stdc++.h>
#include "product.h"
#include "DemoPortal.h"
using namespace std;    
vector<string> DemoPortal :: spl(string s){
    vector<string>sk;
    stringstream ss(s);
    string sn;
    while(getline(ss,sn,' ')){
        sk.push_back(sn);
    }
    return sk;
}
bool sortPrice(product *p1,product *p2){
    return p1->get_price() < p2->get_price();
}
bool sortName(product *p1,product *p2){
    return p1->get_name() < p2->get_name();
}
void DemoPortal :: processUserCommand(string command){
    ofstream file("PortalToPlatform.txt",ios::app);
    file<<portalID<<" "<<command<<endl;
    file.close();
}
void DemoPortal :: checkResponse(map<string,string>sortorder){
    ifstream file("PlatformToPortal.txt");
    
    string s,str,ki;                                            
    while(getline(file,s)){
        label:
        vector<product *>pro;
        vector<string>v;
        v=spl(s);
        if(sortorder[v[1]]=="Start"){
            for(int i=2;i<v.size();i++){
                cout<<v[i]<<endl;
            }
        }
        else if(sortorder[v[1]]=="Buy"){
            cout<<v[2]<<endl;
        }
        else if(sortorder[v[1]]=="Price"||sortorder[v[1]]=="Name"){
            string x=v[1];
            product * p=new product(v[2],v[3],stoi(v[4]),stoi(v[5]));
            pro.push_back(p);
            string k;
            string vie="";
            while(getline(file,k)){
                vector<string>vi;
                vi=spl(k);
                if(vi[1]==x){
                    product * pr=new product(vi[2],vi[3],stoi(vi[4]),stoi(vi[5]));
                    pro.push_back(pr);
                }
                else{
                    vie=k;
                    break;
                }
            }
            if(sortorder[v[1]]=="Price"){
                sort(pro.begin(),pro.end(),sortPrice);
            }
            else if(sortorder[v[1]]=="Name"){
                sort(pro.begin(),pro.end(),sortName);
            }
            for(product* prod : pro){
                cout<<prod->get_category()<<" "<<prod->get_name()<<" "<<prod->get_price()<<" "<<prod->get_number()<<endl;
            }
            if(vie!=""){
                s=vie;
                goto label;
                // vector<string>vik;
                // vik=spl(vie);
                // if(sortorder[vik[1]]=="Start"){
                //     for(int i=2;i<vik.size();i++){
                //         cout<<vik[i]<<endl;
                //     }
                // }
                // else if(sortorder[vik[1]]=="Buy"){
                //     cout<<vik[2]<<endl;
                // }
                
            }
        }
    } 
    file.close();      
    std::ofstream o;
    o.open("PortalToPlatform.txt",std::ofstream::out | std::ofstream::trunc);
    o.close();                                                                                                                                                     
}

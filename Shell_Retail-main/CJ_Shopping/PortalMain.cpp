#include<bits/stdc++.h>
using namespace std;
#include "DemoPortal.h"
int main(){
    DemoPortal po;
    map<string,string>sortorder;
    int reqID=0;
    string s;
    while(1){
        cin>>s;
        if(s=="Start"){
            reqID++;
            sortorder[to_string(reqID)]=s;
            string k,i=to_string(reqID);

            k=i+' '+s;
            po.processUserCommand(k);
        }
        else if(s=="List"){
            reqID++;
            string cat,so,com,i=to_string(reqID);
            cin>>cat>>so;
            sortorder[to_string(reqID)]=so;
            com=i+' '+s+' '+cat+' '+so;
            po.processUserCommand(com);
        }
        else if(s=="Buy"){
            reqID++;
            string id,n,i=to_string(reqID);
            sortorder[to_string(reqID)]=s;
            cin>>id>>n;
            string com=i+' '+s+' '+id+' '+n;
            po.processUserCommand(com);
        }
        else if(s=="Check"){
            po.checkResponse(sortorder);
        }
    }
}
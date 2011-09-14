#include<iostream>
#include<conio.h>
#include<stdlib.h>
#include<stdio.h>
#include<math.h>
#include<string.h>

using namespace std;

int main ()
{
system("color 1f");
int a,i;
cout<<"ingrese el tama"<<char(-92)<<"o del vector : ";
cin>>a;
int v1[a],v2[a],vs[a];
cout<<"Vector A: ";
cout<<endl;
for(i=1;i<=a;i++)
{            
                cout<<"A["<<i<<"] = ";
                cin>>v1[i-1];
                }
cout<<"Vector B:";cout<<endl;
for(i=1;i<=a;i++)
{               
                cout<<"B["<<i<<"] = ";
                cin>>v2[i-1];
                }
for(i=0;i<a;i++)
{
                 vs[i]=v1[i]+v2[i];
                 }
cout<<"vector A :\t";
for(i=0;i<a;i++)
{
                cout<<"["<<v1[i]<<"]";
     }
cout<<endl;
cout<<"Vector B:\t";
for(i=0;i<a;i++)
{
                cout<<"["<<v2[i]<<"]";
     }
cout<<endl;
cout<<"vector A+B:\t";
for(i=0;i<a;i++)
{
                cout<<"["<<vs[i]<<"]";
     }
getch();
return(0);
}


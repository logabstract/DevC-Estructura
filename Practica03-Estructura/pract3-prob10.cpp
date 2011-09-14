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
float med;
cout<<"ingresa la cantidad de numeros a ingresar : ";
cin>>a;
int v[a];
cout<<"Vector :";
cout<<endl;

for(int i=0;i<a;i++)
        {
        cout<<"V["<<i+1<<"]=";
        cin>>v[i];
        }
cout<<"Vector original :\t";        
for(i=0;i<a;i++)
                {
                cout<<"["<<v[i]<<"]";
                }

for(int j=0;j<=a;j++)
{
        for(i=0;i<=a-2;i++)
        {
        int aux;
            if(v[i]>v[i+1])
            {
            aux = v[i];
            v[i]=v[i+1];
            v[i+1]=aux;
            }
        }
}
cout<<endl;
cout<<"Vector ordenado :\t";
for(i=0;i<a;i++)
{
cout<<"["<<v[i]<<"]";
     }
if(a%2==0)
          {
          med=(v[a/2]+v[(a/2)-1])/2.;
          }else med = v[(a-1)/2];
          cout<<endl;
cout<<"mediana : "<<med;
getch();
return(0);
}


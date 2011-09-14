#include<iostream>
#include<conio.h>
#include<stdlib.h>
#include<stdio.h>
#include<math.h>
#include<string.h>
#include<iomanip>

using namespace std;

int main ()
{
system("color 1f");
int a=10,b=12,i,j;
int v[a][b];

//llenando la primera columna con el numero de sucursal
           for(i=0;i<a;i++)
                 {
                  v[i][0]=i+1;
                 }
// dando valores aleatorios del 0-9 para las ventas
           for(i=0;i<a;i++)
           {
                          for(j=1;j<b-1;j++)
                          {
                          v[i][j]=(rand()%9)+0;
                          // se puede cambiar el valor maximo a 99,999 solo que no saldría ordenado
                          }                              
           }
// estableciendo a 0 el total de venta por sucursal
                for(i=0;i<a;i++)
                {
                v[i][11]=0;
                }
//hallando el total de venta por sucursal
           for(i=0;i<a;i++)
           {
                           for(j=1;j<b-1;j++)
                           {
                           v[i][11]=v[i][11]+v[i][j]; 
                           }      
           }      
//mostrando en pantalla la tabla de ventas 
     
cout<<"   alm.  ";
          for(i=1;i<=a;i++)
          {
          cout<<"t"<<i<<"."<<setw(4);
          }
cout<<"  tot.";
cout<<endl<<endl;
      for(i=0;i<a-1;i++)
      {
      for(j=0;j<b;j++)
                      {
                      cout<<setw(4)<<"["<<v[i][j]<<"]";
                      }
                      cout<<endl<<endl;
                      }
      for(i=0;i<b;i++)
      {
      cout<<setw(3)<<"  ["<<v[9][i]<<"] ";
      }
      
getch();
return(0);
}


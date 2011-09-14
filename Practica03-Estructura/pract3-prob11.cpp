#include <stdio.h>
#include <iostream>
#include <conio.h>
using namespace std;

int main()
{
    system("color 1f");
int V[10], N[10], Rep[10];
int i, j, k, total, indice, elementos, existeModa;

cout<<"ingrese datos del vector :";
cout<<endl<<endl;
// Lectura de numeros

for(i=0; i<10; i++)
{
cout <<"V["<<i+1<<"] = ";
cin >> V[i];
}

// Saca copia del arreglo

for(i=0;i<10;i++)
N[i]=V[i];

// Saca numeros distintos

elementos = 10;
total = elementos;
for(i=0;i<elementos;i++)
{
for(j=i+1;j<elementos;j++)
{
// Si encuentra numero repetido
if(N[i]==N[j])
{
// Recorre una posicion elementos posteriores
for(k=j+1;k<elementos;k++)
N[k-1]=N[k];

elementos--;
j--;
}
}
}

// Halla repeticiones de cada numero distinto
for(i=0; i<elementos; i++)
Rep[i] = 0;
for(i=0; i<elementos; i++)
for(j=0;j<total;j++)
if(N[i]==V[j])
Rep[i]++;

// Halla indice del elemento que mayor numero de veces se repite
indice = 0;
for(i=1; i<elementos; i++)
if(Rep[i]>Rep[indice])
indice = i;

// Verificacion por si 2 numeros se repiten igual numero de veces
existeModa=1;
for(i=0;i<elementos;i++)
if(i!=indice)
{
if(Rep[i]==Rep[indice])
{
existeModa = 0;
break;
}
}

if(existeModa==1)
{
cout<<"La moda es: "<<N[indice];
cout<<"\nNumero de repeticiones:"<<Rep[indice];
}
else
cout<<"No existe moda";

getch();
}

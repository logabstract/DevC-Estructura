 #include <stdio.h>
 #include <stdlib.h>
 #include <iostream>
 #include <conio.h>
 
 #define DIM 50
 
 using namespace std;


 void ingresarVector(int a[],int n);
 void mostrarVector(int a[],int n);
 void ordenarVector(int a[],int n);
 void busquedaSecuencial(int a[],int n);
 

 int main()
 {
      int array[DIM],n;
      
      printf("Ingrese el tamaño del vector: "); cin>>n;
      
      printf("Ingrese los elementos\n");
      
      ingresarVector(array,n);
      
      cout<<"\n\nel vector ingresado es:\n";
      mostrarVector(array,n);
      ordenarVector(array,n);
      cout<<"\nEl vector ordenado es: \n";
      mostrarVector(array,n);
      busquedaSecuencial(array,n);
      
      getch();
                
      return 0;
 }

  void ingresarVector(int a[],int n)
  {
      int i,dato;
      for(i=0;i<n;i++)
      {
         cin>>dato;
         a[i] = dato;
      }
  }
  
  void mostrarVector(int a[],int n)
  {
      for(int i=0;i<n;i++)
         cout<<" "<<a[i];
      
  }
  
   void ordenarVector(int a[],int n)
   {
      int menor,indice = 0,posicion,temp;
      
      while(indice<n)
      {
         menor = a[indice];
         for(int i = indice;i<n;i++)
         {
            if(a[i] <= menor)
            {
               menor = a[i];
               posicion = i;
            }
         }
         temp = a[indice];
         a[indice] = menor;
         a[posicion] = temp;
         indice++;
      }
      cout<<"\nvector ordenado...\n";
   }
   
   void busquedaSecuencial(int a[],int n)
   {
      int pos=0,dato,i=0;
      bool encontro = false;
      
      cout<<"\n\nIngrese el dato a buscar: ";cin>>dato;
      
      while(i<=n && !encontro)
      {
         if(a[i] == dato)
         {
            encontro = true;
            pos = i;
         }
         
         else
            i++;
      }
      if(pos==0)
         cout<<"\nNo se encontro el dato ingresado..";
      else
         cout<<"\nse encontro "<<dato<<" en la posicion :"<<pos<<endl;
   }
  

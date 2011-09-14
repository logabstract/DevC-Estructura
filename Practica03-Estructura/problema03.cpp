 #include <stdio.h>
 #include <stdlib.h>
 #include <conio.h>
 #include <iostream>
 
 #define DIM 50
 
 using namespace std;

 
 void ingresarVector(int a[],int n);
 void mostrarVector(int a[],int n);
 void rotarVector(int a[],int n);
 void invertir(int a[],int i,int j);


 int main()
 {
      int array[DIM],n;
      
      printf("Ingrese el tamaño del vector: "); cin>>n;
      
      printf("Ingrese los elementos\n");
      
      ingresarVector(array,n);
      
      cout<<"\n\nel vector ingresado es:\n";
      mostrarVector(array,n);
      rotarVector(array,n);

      system("pause");
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
  
  void rotarVector(int a[],int n)
  {
      int dato;
      cout<<"\n\nElija un elemento para rotar poniendolo primero\nen el arreglo: ";
      cin>>dato;
      dato--;
      invertir(a,0,dato-1);
      invertir(a,dato,n-1);
      invertir(a,0,n-1);
      
      cout<<"\n\nEl vector rotado es:\n\n";
      mostrarVector(a,n);
      printf("\n\n");
      
   }
   
   void invertir(int a[],int i,int j)
   {
      if(i == j)
         return;
      while(i < j)
      {
         int temp = a[i];
         a[i] = a[j];
         a[j] = temp;
         i++;
         j--;
      }
   } 

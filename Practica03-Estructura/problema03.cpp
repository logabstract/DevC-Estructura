 #include <stdio.h>
 #include <stdlib.h>
 #include <conio.h>
 #include <iostream>
 
 #define DIM 50
 
 using namespace std;

 
 void ingresarVector(int a[],int n);
 void mostrarVector(int a[],int n);
 void rotarVector(int a[],int n);


 int main()
 {
      int array[DIM],n;
      
      printf("Ingrese el tama�o del vector: "); cin>>n;
      
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
      int i,posicion,indice,temp;
      cout<<"\n\ncuantas posiciones desea rotar ?";cin>>posicion;
      
      for(i=0;i < posicion;i++)
      {
         temp = a[0];
         for(indice=0;indice < n-1;indice++)
            a[indice] = a[indice+1];
         a[n-1] = temp;
      }
      
      mostrarVector(a,n);
      cout<<"\n\nvector rotado "<<posicion<<" posiciones"<<endl;
   } 

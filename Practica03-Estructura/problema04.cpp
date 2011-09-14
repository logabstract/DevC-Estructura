 #include <stdio.h>
 #include <stdlib.h>
 #include <iostream>
 #include <conio.h>
 
 #define MAX 50
 
 using namespace std;


 void ingresarVector(float a[],int n);
 void mostrarVector(float a[],int n);
 void ordenarVector(float a[],int n);
 float calcularPromedio(float a[],int n);
 

 int main()
 {
      int n;
      float array[MAX],prom;
      
      printf("Ingrese el tamaño del vector: "); cin>>n;
      
      printf("Ingrese los elementos\n");
      
      ingresarVector(array,n);
      
      cout<<"\n\nel vector ingresado es:\n";
      mostrarVector(array,n);
      
      prom = calcularPromedio(array,n);
      
      printf("\n\nEl promedio de los datos es: %.2f\n",prom);

      system("pause");
      return 0;
 }

   void ingresarVector(float a[],int n)
  {
      float dato;
      for(int i=0;i<n;i++)
      {
         cin>>dato;
         a[i] = dato;
      }
  }
  
  void mostrarVector(float a[],int n)
  {
      for(int i=0;i<n;i++)
         cout<<" "<<a[i];
      
  }
  
  float calcularPromedio(float a[],int n)
  {
      int i=0;
      float suma=0;
      while(i<n)
      {
         suma = suma + a[i];
         i++;
      }
      return suma/n;
   }
      
      
         
  

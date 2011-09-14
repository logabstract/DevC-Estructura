 #include <stdio.h>
 #include <stdlib.h>
 #include <iostream>
 #include <conio.h>
 
 #define DIM 50
 
 using namespace std;


 void ingresarVector(int a[],int n);
 void mostrarVector(int a[],int n);
 bool copiarVector(int a[],int c[],int n);

 int main()
 {
      int array[DIM],copia[DIM],n;
      
      printf("Ingrese el tamaño del vector: "); cin>>n;
      
      printf("Ingrese los elementos\n");
      
      ingresarVector(array,n);
      
      cout<<"\n\nel vector ingresado es:\n";
      mostrarVector(array,n);
      
      copiarVector(array,copia,n);
      
      printf("\nEl vector fue copiado con exito\n");
      cout<<"\nel vector copiado es:\n";
      mostrarVector(copia,n);
      
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
  
  bool copiarVector(int a[],int c[],int n)
  {
      for(int i=0;i<n;i++)
         c[i] = a[i];
  }
   
  

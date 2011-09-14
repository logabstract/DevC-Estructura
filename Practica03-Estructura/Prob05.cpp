#include <iostream>
#include <cstdlib>
#include <conio.h>
#include <String.h>
#include <iomanip>
#define MAX 100

using namespace std;

class Vector{
      int A[MAX];
      int indice;
      int N;
      
      public:
             Vector();
             void Recorrer();
             void CrearVector();
             void EncontrarMayor();
             void EncontrarMenor();
};

Vector::Vector(){
      N=0;
      indice=0;
}

void Vector::CrearVector(){
     int valor;
     int opc;
     
     cout<<"Ingrese el tamanio del vector: ";
     cin>>opc;
     
     for(int i=0;i<opc;i++){
         cout<<"Ingrese valor: ";
         cin>>valor;
         if(N>=MAX)
            cout<<"El vector esta lleno!!!";
         else{
            A[N]=valor;
            N++;
         }
     }
}

void Vector::Recorrer(){
     cout<<endl<<"Vector: "<<endl;
     for(indice=0;indice<N;indice++)
         cout<<"["<<A[indice]<<"]  ";
     cout<<endl;
     getch();
}

void Vector::EncontrarMayor(){
     int mayor=-99;
     int resg=0;
     int cont=0;
     for(indice=0;indice<N;indice++){
         if(A[indice]==mayor)
               cont++;
         if(A[indice]>mayor){            
            mayor=A[indice];
            resg=indice+1;
         }
     }
     if(cont>=1)
        cout<<endl<<"El elemento mayor es: "<<mayor<<" y se repite "<<cont+1<<" veces";  
       else
           cout<<"El elemento mayor en el vector es A["<<resg<<"] y su valor es: "<<mayor;
     getch();
}

void Vector::EncontrarMenor(){
     int menor=9999;
     int resg=0;
     int cont=0;
     
     for(indice=0;indice<N;indice++){
         if(A[indice]==menor)
               cont++;
         if(A[indice]<menor){
            menor=A[indice];
            resg=indice+1;
         }
     }
     if(cont>=1)
        cout<<endl<<"El elemento mmenor es: "<<menor<<" y se repite "<<cont+1<<" veces";  
       else
           cout<<"El elemento menor en el vector es A["<<resg<<"] y su valor es: "<<menor;
     getch();
}

int Salir(){
     cout<<"Gracias por usar el sistema!!!";
     getch();
     exit (1);
}

void Mensaje(){
     cout<<"Ha ingresado una opcion incorrecta!!!";
}

int Menu(){
    int op;
    cout<<'\t'<<"    MENU"<<endl;
    cout<<'\t'<<"============="<<endl;
    cout<<"Llenar vector.................[1]"<<endl;
    cout<<"Recorrer Vector...............[2]"<<endl;
    cout<<"Encontrar Mayor elemento......[3]"<<endl;
    cout<<"Encontrar Menor elemento......[4]"<<endl;
    cout<<"Salir.........................[5]"<<endl;
    cout<<"Ingrese su opcion ==> ";
    cin>>op;
    return op;
}


int main(){
   int opc;
   Vector V;
   
   opc=Menu();

   while(opc!=0){
         switch(opc){
               case 1: V.CrearVector();break;
               case 2: V.Recorrer();break;
               case 3: V.EncontrarMayor();break;
               case 4: V.EncontrarMenor();break;
               case 5: Salir();break;
               default: Mensaje(); break;    
         } 
         system("cls");
         opc=Menu();
         
   }        
              
   getch();
   return 0;
}

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
      int buscado;
      
      public:
             Vector();
             void Recorrer();
             void CrearVector();
             void Burbuja();
             int BusquedaBinaria(int buscado);
             void BusquedaLineal(int buscado);
};

Vector::Vector(){
      N=0;
      indice=0;
      buscado=0;
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

void Vector::Burbuja(){
     int i,j,temp;
     
     for(i=1;i<N;i++)
         for(j=N-1;j>=i;j--) 
            if(A[j-1]>A[j]){
               temp=A[j-1];
               A[j-1]=A[j];
               A[j]=temp;
            }                   
}

int Vector::BusquedaBinaria(int buscado){
    int medio, inicio, fin;
    inicio = 0;
    fin = N-1;
    int resg=0;

    while(inicio <= fin){
      medio = (inicio + fin) / 2;

      if(buscado == A[medio]){
        cout<<"Se encuentra en la posicion "<<medio+1<< endl;
        getch();
        return A[medio];
        
      } else{
          if(A[medio] > buscado){
            fin = medio - 1;
          } else {
            inicio = medio + 1;
          }
      }
    }
    getch();
    return -1;
    
}

void Vector::BusquedaLineal(int buscado){
     int cont=0;
     for(indice=0;indice<N;indice++){
         if(A[indice]==buscado){
            cout <<"El numero "<<buscado<<" se encuentra en la posicion "<<indice+1<< endl;
            cont++;
         }   
     }
     if(cont==0)
        cout<<endl<<"No se encontro el numero!!!";
     
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
    cout<<"Llenar vector........................[1]"<<endl;
    cout<<"Recorrer Vector......................[2]"<<endl;
    cout<<"Busqueda Binaria de un elemento......[3]"<<endl;
    cout<<"Busqueda Lineal de un elemento.......[4]"<<endl;
    cout<<"Salir................................[5]"<<endl;
    cout<<"Ingrese su opcion ==> ";
    cin>>op;
    return op;
}


int main(){
   int opc;
   int buscad;
   int comprob;
   Vector V;

   opc=Menu();

   while(opc!=0){
         switch(opc){
               case 1: V.CrearVector();break;
               case 2: V.Recorrer();break;
               case 3: cout<<"BUCANDO BINARIAMENTE: "<<endl;
                       cout<<"Arreglo inicial==> "; V.Recorrer();
                       cout<<"Ordenando==> "; V.Burbuja(); V.Recorrer();
                       cout<<endl<<"Ingrese numero a buscar: ";
                       cin>>buscad;
                       cout<<endl; 
                       comprob=V.BusquedaBinaria(buscad);
                       if(comprob==-1)
                          cout<<"No se encontro el elemento!!!";break;
               case 4: cout<<"BUCANDO LINEALMENTE: "<<endl;
                       cout<<endl<<"Ingrese numero a buscar: ";
                       cin>>buscad;
                       cout<<endl; 
                       V.BusquedaLineal(buscad);break;
               case 5: Salir();break;
               default: Mensaje(); break;    
         } 
         system("cls");
         opc=Menu();
         
   }        
              
   getch();
   return 0;
}

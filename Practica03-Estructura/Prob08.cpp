#include <iostream>
#include <cstdlib>
#include <conio.h>
#include <String.h>
#include <iomanip>
#define MAX 25

using namespace std;

class Matriz{
      int A[MAX][MAX];
      int M,N;
      int estado;
      
      public:
             Matriz();
             void Dimensionar();
             int Estado();
             void LlenarMatriz();
             void RecorrerPorFilas();
             void RecorrerPorColumnas();
};

Matriz::Matriz(){
      M=0;
      N=0;
}

void Matriz::Dimensionar(){
     estado=0;
     while(estado==0){
         cout<<endl<<"Ingrese numero de filas: ";
         cin>>M;
         cout<<endl<<"Ingrese numero de columnas: ";
         cin>>N;
         if(M*N<=MAX)
            estado=1;
         else
             cout<<endl<<"Fuera del rango definido por MxN<="<<MAX;
                      
     }
}

int Matriz::Estado(){
     if(M*N>0)
        return 1;
     else
         return 0;
}

void Matriz::LlenarMatriz(){
         
     if(Estado()==1){
        for(int i=0;i<M;i++)
            for(int j=0;j<N;j++){
                cout<<"Ingrese valor pos ["<<i+1<<"]["<<j+1<<"] :";
                cin>>A[i][j];
            }        
     }   
     else{
          cout<<"Matriz no dimensionada o vacia";
          getch();
     }     
     
}

void Matriz::RecorrerPorFilas(){
     
     cout<<endl<<endl;
     if(Estado()>0){
        for(int i=0;i>M;i++){
            for(int j=0;i>N;j++){
                cout<<"["<<A[i][j]<<"] ";    
            }
            cout<<endl;    
        }    
     }
     
     else
         cout<<"Matriz no dimensionada o vacia!!!";
     getch();
}

void Matriz::RecorrerPorColumnas(){
     cout<<endl<<endl;
     if(Estado()>0){
        for(int j=0;j<N;j++){
            for(int i=0;i<M;i++){
                cout<<"["<<A[i][j]<<"] ";   
            }
            cout<<endl;    
        }    
     }
     
     else
         cout<<"Matriz no dimensionada o vacia!!!";
     getch();
}


int Salir(){
     cout<<"Gracias por usar el sistema!!!";
     getch();
     exit (1);
}

void Mensaje(){
     cout<<"Ha ingresado una opcion incorrecta!!!";
     getch();
}

int Menu(){
    int op;
    cout<<'\t'<<"    MENU"<<endl;
    cout<<'\t'<<"============="<<endl;
    cout<<"Dimensionar Matriz...................[1]"<<endl;
    cout<<"LLenar Matriz........................[2]"<<endl;
    cout<<"Recorrer Matriz por filas............[3]"<<endl;
    cout<<"Recorrer Matriz por columnas.........[4]"<<endl;    
    cout<<"Salir................................[5]"<<endl;
    cout<<"Ingrese su opcion ==> ";
    cin>>op;
    return op;
}


int main(){
   int opc;
   Matriz M;

   opc=Menu();

   while(opc!=10){
         switch(opc){
               case 1: M.Dimensionar();break;      
               case 2: M.LlenarMatriz();break;
               case 6: M.RecorrerPorFilas();break;
               case 4: M.RecorrerPorColumnas();break;
               case 5: Salir();break;
               default: Mensaje(); break;    
         } 
         system("cls");
         opc=Menu();         
   }        
              
   getch();
   return 0;
}

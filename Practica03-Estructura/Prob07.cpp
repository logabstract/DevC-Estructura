#include <iostream>
#include <cstdlib>
#include <conio.h>
#include <String.h>
#include <fstream>
#include <iomanip>

#define Max 100

using namespace std;

class Vector{
      int A[Max];
      int indice;
      int N;
      int valor;
      int posicion;
      int temp;
      fstream F;
      
      public: 
              Vector();
              int retN(){return N;}
              void CrearVector();
              void Mostrar();
              void Adicionar();
              void Insertar_Val();
              void Eliminar_Pos();
              void Eliminar_Val();
              void Ordenar_Asc();
              void Ordenar_Desc();
              void Rotar_Izq();
              void Rotar_Der();
              void Salvar();
              void Recuperar();
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
         if(N>=Max)
            cout<<"El vector esta lleno!!!";
         else{
            A[N]=valor;
            N++;
         }
     }
}

void Vector::Mostrar(){
     cout<<"Vector: "<<endl;
     cout<<"-------"<<endl;
     for(indice=0;indice<N;indice++){
         cout<<A[indice]<<"\t";
     }
     getch();
}

void Vector::Adicionar(){
     cout<<"Ingrese Valor: ";
     cin>>valor;
     if(N>=Max)
       cout<<"El vector esta lleno!!!";
       else{
            A[N]=valor;
            N++;
       }
}
            
void Vector::Insertar_Val(){
     cout<<"Insertar por valor: "<<endl;
     if(N>0){
        cout<<"Ingrese el Valor: ";
        cin>>valor;
        cout<<"Ingrese la posicion: [0-"<<N-1<<"]: ";
        cin>>posicion;
        if(posicion>=N)
          cout<<"No se puede insertar en esta posicion!!!";
        else{
            N++;
            for(indice=N-1;indice>posicion;indice--)
                A[indice]=A[indice-1];
            A[posicion]=valor;
            Mostrar();
            cout<<"Elemento insertado!!!";
            getch();
            
        }
     }
     else
          cout<<"No hay elementos en el vector!!!";
}

void Vector::Eliminar_Pos(){
     cout<<"Eliminar elemento por posicion: ";
     if(N>=0){
        cout<<"Ingrese la posicion: [0-"<<N-1<<"]: ";
        cin>>posicion;
        if(posicion>=N)
           cout<<"No se puede eliminar una posicion que no existe!!!";
        else{
             N--;
             for(indice=posicion;indice<N;indice++)
                 A[indice]=A[indice+1];
             Mostrar();
             cout<<"Elemento eliminado!!!";
             getch();             
        }        
     }
     else 
          cout<<"No hay elementos en el vector!!!";
}

void Vector::Eliminar_Val(){
     cout<<"Eliminar elemento por valor: ";
     if(N>0){
        cout<<"Ingrese el valor a eliminar: ";
        cin>>valor;
        indice=0;
        int hecho=0;
        while(indice<N){
              if(A[indice]==valor){
                 N--;
                 hecho=1;
                 for(int i=indice;i<N;i++)
                     A[i]=A[i+1];
                 indice=0;
                 cout<<"elemento eliminado!!!"<<endl;
                 getch();                 
              }
              indice++;
        }
         
        if(hecho==0)
           cout<<"No se encontro el elemento!!!";
           else{
               Mostrar();
               cout<<"Elemento eliminados!!!";
          }
     }
     else
         cout<<"No hay elementos en el vector!!!";             
}

void Vector::Ordenar_Asc(){
     cout<<"Ordenar Ascendentemente: "<<endl;
    
     int i,j,temp;
     
     for(i=1;i<N;i++)
         for(j=N-1;j>i;j--) 
            if(A[j-1]>A[j]){
               temp=A[j-1];
               A[j-1]=A[j];
               A[j]=temp;
            }                   

     cout<<"Vector Ordenado..."<<endl;
     Mostrar();
}

void Vector::Ordenar_Desc(){
     cout<<"Ordenar Descendentemente: "<<endl;
     
     int i,j,temp;
     
     for(i=N-1;i>0;i--){
          for(j=0;j<i;j++){
              if(A[j]<A[j+1]){
                 temp=A[j];
                 A[j]=A[j+1];
                 A[j+1]=temp;
              }
          }
     }     
     
     cout<<"Vector ordenado..."<<endl;
     Mostrar();
}

void Vector::Rotar_Izq(){
    cout<<"Rotar hacia la Izquierda: ";
    cout<<endl<<"Cuantas posiciones desea rotar?";
    cin>>posicion;
    for(int i=0;i<posicion;i++){
        temp=A[0];
        for(indice=0;indice<N-1;indice++)
           A[indice]=A[indice+1];
        A[N-1]=temp;
        
    }
    Mostrar();
    cout<<"Vector rotado "<<posicion<<" posiciones";
}

void Vector::Rotar_Der(){
     cout<<"Rotar hacia la derecha: ";
     cout<<endl<<"Cuantas posiciones desea rotar? ";
     cin>>posicion;
     for(int i=0;i<posicion;i++){
        temp=A[N-1];
        for(indice=N-1;indice>0;indice--)
           A[indice]=A[indice-1];
        A[0]=temp;        
     }
     Mostrar();
     cout<<"Vector rotado "<<posicion<<" posiciones";
}

void Vector::Salvar(){
    cout<<"Guardar Vector: ";
    F.open("Vector.txt",ios::out);
    for(indice=0;indice<N;indice++)
       F<<A[indice];
    cout<<"Vector guardado..."<<endl;
    getch();
    F.close();
}

void Vector::Recuperar(){
    posicion=0;
    int buffer;
    F.open("Vector.txt",ios::in);
    F>>buffer;
    while(!F.eof()){
         F>>buffer;
         A[posicion]=buffer;
         posicion++;
    }
    
    N=posicion-1;
    cout<<endl;
    Mostrar();
    cout<<endl<<"Vector Recuperado..."<<endl;
    getch();
    F.close();
}

void Salir(){
    cout<<endl<<"Gracias por usar el sistema!!!";
    getch();
    exit(1);
}

int Menu(){
   int op;
   cout<<"Menu: "<<endl;
   cout<<"-------"<<endl;
   cout<<"Crear Vector...............................[0]"<<endl;
   cout<<"Visualizar Vector..........................[1]"<<endl;
   cout<<"Adicionar elemento.........................[2]"<<endl;
   cout<<"Insertar elemento..........................[3]"<<endl;
   cout<<"Eliminar vector por posicion...............[4]"<<endl;
   cout<<"Eliminar elemento por valor................[5]"<<endl;
   cout<<"Ordenar Ascendentemente....................[6]"<<endl;
   cout<<"Ordenar Descendentemente...................[7]"<<endl;
   cout<<"Rotar hacia la izquierda...................[8]"<<endl;
   cout<<"Rotar hacia la derecha.....................[9]"<<endl;
   cout<<"Guarda vector.............................[10]"<<endl;
   cout<<"Recuperar vector..........................[11]"<<endl;
   cout<<"Salir.....................................[12]"<<endl;
   cout<<"Ingrese una opcion: ";
   cin>>op;
   return op;
}

int main(){
   int opc;
   Vector V;
   opc=Menu();
   while(opc!=123){
       switch(opc){
            case 0:  V.CrearVector();break;
            case 1:  V.Mostrar();break;
            case 2:  V.Adicionar();break;
            case 3:  V.Insertar_Val();break;
            case 4:  V.Eliminar_Pos();break;
            case 5:  V.Eliminar_Val();break;
            case 6:  V.Ordenar_Asc();break; 
            case 7:  V.Ordenar_Desc();break;
            case 8:  V.Rotar_Izq();break;
            case 9:  V.Rotar_Der();break;
            case 10: V.Salvar();break;
            case 11: V.Recuperar();break;
            case 12: Salir();break;
            default: cout<<"No existe la opcion!!!";       
       }
       system("cls");
       opc=Menu();
   }
   
   getch();
   return 0;
}





 #include <stdio.h>
 #include <stdlib.h>
 #include <conio.h>
 #include <iostream>
 
 using namespace std;
 
 typedef struct nodo
 {
      int dato;
      struct nodo* sgte;
 }Nodo;
 
 typedef Nodo* ptrnodo;
 
 ptrnodo nodoDisp();
 void recorrerLista(ptrnodo cab);
 void insertarNodo(ptrnodo q,ptrnodo &cab,ptrnodo &ultimo);    
 void crearLista(ptrnodo &cab,ptrnodo &ultimo);
 void ordenar(ptrnodo &cab);
 void adiciona(ptrnodo &cab,int valor);
 void intercalar(ptrnodo a,ptrnodo b,ptrnodo &cab);


 int main()
 {
      ptrnodo cab1=NULL,ultimo1=NULL;
      ptrnodo cab2=NULL,ultimo2=NULL;
      ptrnodo cab3=NULL,ultimo3=NULL;
      
      cout<<"\nINGRESE LA PRIMERA LISTA"<<endl;
      cout<<"========================"<<endl;
      crearLista(cab1,ultimo1);
      cout<<"\nINGRESE LA SEGUNDA LISTA"<<endl;
      cout<<"========================"<<endl;
      crearLista(cab2,ultimo2);
      cout<<"\nLA PRIMERA LISTA ES: "<<endl;
      cout<<"======================"<<endl;
      recorrerLista(cab1);
      cout<<endl;
      cout<<"\nLA SEGUNDA LISTA ES: "<<endl;
      cout<<"======================"<<endl;
      recorrerLista(cab2);
      cout<<endl;
      cout<<"\nLA LISTA INTERCALADA ES: "<<endl;
      cout<<"========================"<<endl;
      intercalar(cab1,cab2,cab3);
      recorrerLista(cab3);
      cout<<endl;
      

       
      system("pause");
      return 0;
 }
 
  ptrnodo nodoDisp()
 {
      ptrnodo q;
      q = new Nodo;
      
      return q;
   }
   
 void recorrerLista(ptrnodo cab)
 {
      ptrnodo q;
      q = cab;
      while(q !=NULL)
      {
         cout<<q->dato<<" ";
         q = q->sgte;
      }
   }
   
 void insertarNodo(ptrnodo q,ptrnodo &cab,ptrnodo &ultimo)
 {
      if(cab == NULL)  
         cab = q;
      else
         ultimo->sgte = q;
         
      ultimo = q;
   }
   
 void crearLista(ptrnodo &cab,ptrnodo &ultimo)
 {
      
      ptrnodo q;
      int i,n;
      
      cout<<"Ingrese el numero de elementos: ";
      cin>>n;
      cout<<endl;
      
      for(i=0;i<n;i++)
      {
         q = nodoDisp();
         
         cout<<"Ingrese dato: ";
         cin>>q->dato;
         q->sgte = NULL;
         insertarNodo(q,cab,ultimo);
      }
   }

 void ordenar(ptrnodo &cab)
 {
      ptrnodo actual,siguiente,marca;
      int temp;
      marca = NULL;
      while(marca != cab->sgte)
      {
         actual = cab;
         siguiente = actual->sgte;
         while(siguiente != marca)
         {
            if(actual->dato > siguiente->dato)
            {
               temp = siguiente->dato;
               siguiente->dato = actual->dato;
               actual->dato = temp;
            }
            
            actual = actual->sgte;
            siguiente = siguiente->sgte;
         }
         
         marca = actual;
      }
   }
   
   void adiciona(ptrnodo &cab,int valor)
   {
      ptrnodo q;
      q = nodoDisp();
      q->dato = valor;
      q->sgte = cab;
      cab = q;
   }
      
   
   void intercalar(ptrnodo a,ptrnodo b,ptrnodo &cab)
   {
      ptrnodo n1,n2;
      
      ordenar(a);
      ordenar(b);
      
      n1 = a;
      n2 = b;
      cab = NULL;
      while(n1 != NULL && n2 != NULL)
      {
         if(n1->dato == n2->dato)
         {
            adiciona(cab,n1->dato);
            n1 = n1->sgte;
            n2 = n2->sgte;
         }
         else
         {
            if(n1->dato < n2->dato)
            {
               adiciona(cab,n1->dato);
               n1 = n1->sgte;
            }
            else
            {
               adiciona(cab,n2->dato);
               n2 = n2->sgte;
            }
         }
      }
      
      while(n1 != NULL)
      {
         adiciona(cab,n1->dato);
         n1 = n1->sgte;
      }
      
      while(n2 != NULL)
      {
         adiciona(cab,n2->dato);
         n2 = n2->sgte;
      }
   }

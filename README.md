# CursoJava

## Variables en Java

### Tipos de Datos

En java se tienen 2 tipos principales:

1. Tipos primitivos:

  1.1 Tipos enteros: byte(8 bits), short(16 bits), char(16 bits), int(32 bits), long(64 bits)
  1.2 Tipos Flotantes: float(32 bits), double(64 bits)
  
2. Tipos Referenciados(Tipo Object): Clases, interfaces, arreglos

## Sentencias de control

1. IF: 
```
    if( condicion ){
      code...
    }else if( condicion ){
      code...
    }else{
      code...
    }
```    
2. SWITCH
 ```   
    switch( expresion ){
      case valor1: 
        code...
        break;
        
      case valor2: 
        code...
        break;
        
      default:
        code...
    }
 ```   
## Ciclos

1. WHILE
  ```
  while( condicion ){
    code...
  }
```
2. DO WHILE
```
  do {
    code...
  }while( condicion )
  ```
3. FOR
```
  for(inicialización; condicion; iteracion){
    code...
  }
```  
## Clases

Una clase es una plantilla de la cual podemos crear objetos, por lo tanto un objeto es una instancia de una clase. Posee un nombre, atributos y metodos. Por convención los nombres de la clase siempre empiezan en mayúscula.
```
  class NombreClase{
    tipoDato atributo;
    tipoDato atributo;
    
    tipoDato metodo1(argumentos){
      code..
    }
    
    tipoDato metodo1(argumentos){
      code..
    }
  }
 ```
Para crear un objeto o instancia de una clase se usa la sintaxis new y el nombre de la clase. Ejem

Persona persona = new Persona();

### Metodos

Al ser java un lenguaje orientado a objetos para crear un metodo debe estar dentro de una clase. Los metodos pueden retornar tipos primitivos, tipo objetos o simplemente no retornar, cuando no va retornar se le espicifica con la palabra void.Puede llevar o no argumentos.
```
    void metodo1(argumentos){
      code...
    } 
    
    tipo metodo2(argumentos){
      code...
    }
 ```
 ### Constructores

Las clases en Java pueden tener contructores que puedan inicializar sus atributos con valores predeterminados. Si una clase no tiene contructor Java inicializará sus atributos con valores por default. El contructor lleva el nombre de la clase.

    ```
    NombreClase( argumentos ){
      code...
    }
    ```
## Alcance de Variables

Con el operador `this` podemos hacer referencia al objeto con el que se esta trabajando actualmente, un ejemplo de esto es cuando tenemos un constructos con argumentos iguales a los atributos, para diferenciar los atributos de los argumentos se utiliza el operador `this`. Ejemplo


    class Aritmetica{
      int a;
      int b;
      
      Aritmetica (int a, int b){
        this.a = a;
        this.b = b;
      }
    }
    
    
## Memoria stack y heap

La mempria stack se utiliza para almacenar las variables locales y las llamada de funciones, estas variables normalmente tienen un periodo de vida corto, unicamente mientras termina la función o método en el que se estan ejecutando. La memoria Heap se utiliza para almacenar los objetos Java, incluyento sus atributos. Las variables que se crea de un objeto no almacena el objeto en si mismo, si no la referencia de este en memoria (dirección de memoria).


## Encapsulamiento

El estado de un objeto esta generalmente oculto, a esto se le conoce como encapsulamiento. Java utliza modificadores para definir esta caracteristica. Son cuatro: public, private, static y default.

## Contexto Estatico y Dinamico

El contexto estatico es cuando las clases estan cargadas en memoria y una vez que la clase este cargada en memoria se podrá hacer objetos de dicha clase, a esto se le conoce como contexto dinamico. 

### Palabra static

Se puede utilizar la palabra static para trabajar en el contexto estatico. Cuanto se señala un atributo o metodo como static lo que indicamos es que este metodo o atributo pertenece a la clase y no al objeto como tal. Por lo tanto un atributo solo se crea una vez, cuando la clase se carga en memoria. Se puede interactuar con los atributos estaticos de la clase sin haber creado un objeto de la misma. 

### Operador this
Este pertence al contexto dinamico por lo tanto no puede ser utilizado en un metodo statico, marcará error. este operador hace siempre referencia al objeto en el que está.

## Herencia

La herencia nos permite presentar comportamiento en común, evitar duplicación de código, diseñar clases más parecidas al mundo real. Los atributos privados de una clase no se heredan, sin embargo sus metodos publicos si. Solo se puede heredar de una clase a la vez. Todas las clases en Java heredan de la clase Object de manera inderecta o directa. Las clases que no llevan un extends por default heredan de la clase Object

### Sintaxis
  se utiliza la palabra extends
  
 ``` class Persona {...}
  
  class Empleado extends Persona {...}
  
  class Gerente extends Empleado {...}
  ```
 

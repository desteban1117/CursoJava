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

Una clase es una plantilla de la cual podemos crear objetos, por lo tanto un objeto es una instancia de una clase. Posee un nombre, atributos y metodos.
```
  class nombreClase{
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

Las clases en Java pueden tener contructores que puedan inicializar sus atributos con valores predeterminados. Si una clase no tiene contructor Java inicializará sus atributos con valores por default. El contructor lleva el nombre de la clase

  ```
    NombreClase( argumentos ){
      code...
    }
  ```


 

# Fundamentos java

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
  
  class Gerente extends Empleado {...}```
  
## Uso de super y this

Con la palabra super la clase hija puede acceder a los atributos o metodos de la clase padre
  ``` 
public class Persona {
	private String nombre;
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}
}

public class Empleado extends Persona{
	private double sueldo;
	public Empleado(String nombre, double sueldo) {
		super(nombre);
		this.sueldo = sueldo;
	}
}

public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empleado empleado = new Empleado("Juan", 1500000);
}
```
Otro ejemplo es el metodo toString(), que es un metodo de la clase Object, para poder utilizar este método se debe utlizar la anotación @Override, que quiere decir que vamos a sobreescribir un metodo de la clase padre o superior.
```

public class Persona {
	@Override
	public String toString() {
		return "Persona{ " + "nombre: " + nombre + '}';
	}
}


public class Empleado extends Persona{
	@Override
	public String toString() {
		return super.toString() + " Empleado{ " + "Sueldo: " + sueldo + '}';
	}
}
```

## Sobre Carga de constructores
Tienes que ver con distintas opciones para crear un objeto de una clase en particular, se crean diferentes constructores con diferentes argumentos
``` 
public class Persona {
  public Persona(){}
	public Persona(String nombre) {
		this.nombre = nombre;
	}
}
```
Se puede utilizar constructores que llamen a otro constructor para la creación de un objeto, un ejemplo es la siguiente clase:    
```

public class Persona {
	
	private int idPersona;
	private String nombre;
	private static int countPersonas;
	
	private Persona() {
		idPersona = ++countPersonas;
	}
	public Persona(String nombre) {
		this();
		this.nombre = nombre;
	}
}
```
En donde `this()` llama al constructor vacio, estos se hace ya que se puede tener un mejor control de como se están creando los objetos, ya que si se puede notar el constructo `Persona()` es privado y solo se puede llamar desde la misma clase.

### Sobre carga de métodos
Es parecido con la sobre carga de los constructores, pero en este caso se puede sobrecargar cualquier método. Hay que tener en cuenta que para que exista sobrecarga de métodos los argumentos de éste deben ser diferentes. También se debe tener en cuenta que el compilador se fija en el tipo de dato y no el nombre del argumento para hacer la distición de los métodos.
```
int suma(int a, int b){
  return a + b;
}

double suma(double a, double b){
  return a + b;
}
```
## Paquetes en Java
Esto nos permite organizar clases, evitar conflictos entre nombres de clases, limitar el acceso a clases y ademas existe una biblioteca de paquetes ya existentes, clases a las cuales podemos acceder en java.

## Uso de final
En variables:  Evita cambiar el valor que tiene la variable.
En Métodos: Evita que una subclase pueda modificar la definición del método.
En Clases: evita que se crea una subclase a partir de esta, eso quiere decir que no se puede extender de la clase.

## Arreglos
El arreglo es un conjunto de información la cual permite agrupar datos de un tipo en particular, puede ser tanto datos primitivos u objetos.

### Declaración 
`tipo [] nombreArreglo` o `tipo nombreArreglo []`
ejemplo:
`int [] array` o `int array []`

### Instanciar
para instanciar un arreglo se debe de decir cual va ser el tamaño del arreglo, ejemplo
`nombreArreglo = new tipo[5]`

### Inicializar
para inicializar los elementos de una arreglo se puede hacer de las siguientes maneras
```
int array [] = new [5];
array = {1,2,3,4,5};
array[0] = 1;
array[1] = 2;
...
```
cuando no se ha inicializado algún indice el valor que tendrá el arreglo en dicho indice es el default dependiendo del tipo que sea el arreglo.
### Extraer valor de arreglo
se hace de la siguiente manera:
`int i = array[0];`

## Matrices
Es lo mismo que un arreglo, solo que esta es de dos dimenciones
### Declaración 
`tipo [][] nombreArreglo` o `tipo nombreArreglo [][]`
ejemplo:
`int [][] array` o `int array [][]`

### Instanciar
para instanciar un arreglo se debe de decir cual va ser el tamaño del arreglo, ejemplo
`nombreArreglo = new tipo[5][5]`

### Inicializar
para inicializar los elementos de una arreglo se puede hacer de las siguientes maneras
```
int array [][] = new [5][5];
array = {{1,2,3,4,5}, {6,7,8,9,10}};
array[0][0] = 1;
array[0][1] = 2;
...
```
cuando no se ha inicializado algún indice el valor que tendrá el arreglo en dicho indice es el default dependiendo del tipo que sea el arreglo.
### Extraer valor de arreglo
se hace de la siguiente manera:
`int i = array[0][0];`

# Programacion Java

## Sintaxis básica de una clase en Java
```
package <nombre paquete>

import <nombre paquete>

public class NombreClase{
	<atributos>;
	
	<constructores>;
	
	<metodos>;
}
```

## Bloques de código

Todo bloque de código esta definido dentro de dos corchetes `{...}`

Existe el concepto de bloques anónimos que sirven para inicializar variables en una clase, ya que estos se ejecutan antes del constructor de la clase.

## Comentar con javaDoc
Para documentar con javaDoc se debe seguir la siguiente sintaxis `/** ...... */`,tambien con este estilo de documentación se puede utilizar los siguientes caracteres de escape:

@author: Nombre del autor del programa
@deprecated: Indica que el elemento es obsoleto, pertenece a versiones anteriores y no se recomienda su uso
@param: Definición de un parametro de un método
@return: Descripción de lo que devuelve un método
@see: Indica que se asocia con otros métodos o clases
@version: version del método o clase

## Argumentos variables

Se usa de la siguiente manera:

```
public static void main(String[] args) {
		
		imprimirNumeros(1,2,3,4,5);
	}
	
	public static void imprimirNumeros(int... numeros) {
		
		for(int i = 0; i < numeros.length;i++) {
			System.out.println(numeros[i]);
		}
	}
```
En donde a la final los argumentos terminan siendo un arreglo, si se va utilizar varios argumentos con argumentos variables lo recomendable es que los argumentos variables sean escritos a la final de los argumentos.

```
(doube num1, String name, int... numeros)
```

## Foreach

Este tipo de ciclo se puede utilizar para iterar arreglos, se usa de la siguiente manera:
```
public static void main(String[] args) {
		
		imprimirNumerosForeach(1,2,3,4,5);
	}
	
	public static void imprimirNumerosForeach(int... numeros) {
		
		for(int numero : numeros) {
			System.out.println(numero);
		}
	}
```
La unica desventaja es que si se necesita conocer el numero del indice no se va poder utilizar este. La ventaja es que la sintaxis es ms limpia y menos propensa a errores.

## Enumeraciones en Java

Estos enumerados, son un tipo especial de clases que permite guardar valores final, o sea, son constates, se puede utilizar de la siguiente manera:

```
public enum Continentes {
	AFRICA,
	EUROPA,
	ASIA,
	AMERICA,
	OCEANIA;
}

public static void main(String[] args) {
		
	System.out.println(Continentes.AFRICA);
}
```
Estos enum también pueden contener información y se pueden crear métodos.

```
public enum Continentes {
	AFRICA(53),
	EUROPA(46),
	ASIA(44),
	AMERICA(34),
	OCEANIA(14);
	
	private final int paises;
	
	Continentes(int paises){
		this.paises = paises;
	}

	public int getPaises() {
		return paises;
	}
		
}

public static void main(String[] args) {
		
	System.out.println(Continentes.AFRICA.getPaises());
}
```
Para recuperar todos los valores asociados a una enumeración se hace de la siguiente manera:
```
public static void imprimirContinentes() {
		
		for(Continentes c: Continentes.values()) {
			System.out.println(c + ": " + c.getPaises());
		}
	}
```
## Autoboxing y Unboxing 

Autoboxing es el proceso en que el compilador hace la conversión directa entre de un tipo primitivo a uno tipo objeto Object, por ejemplo, `Integer entero = 10`. en donde la clase Integer se convierte en una clase envolvente del tipo primitivo int, existe una clase envolvente por cada tipo primitivo.

Unboxing sería el proceso contrario, en donde se pasa de un tipo envolvente a un tipo primitivo, `int i = entero`.

La ventaja que trae de utilizar estos tipos es que puedo convertir de una clase envolvente a otra de una manera mucho más sencilla. sirve cuando se esta haciendo muchas conversiones entre tipos primitivos.

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

## Sobreescritura de metodos

Esto sucede cuando una clase hija sobre escribe un método de la clase padre. Por ejem:
```
public class Empleado {
	
	protected String nombre;
	protected String puesto;
	protected int nivel;
	
	public String obtenerDetalle() {
		return "nombre: " + nombre + "\n" +
			"puesto: " + puesto + "\n" +
			"nivel: " + nivel;
	}
}

public class Gerente extends Empleado{
	private String departamento;
	
	public String obtenerDetalle() {
		return super.obtenerDetalle() + "\n" +
			"departamento: " + departamento;
	}
}

```
Se puede observar como la clase Gerente extiende de la clase Empleado y ademas sobreescribe el método obtenerDetalle, lo que hace que ya no utilicemos la implementación de la clase padre. La firma del método debe ser la misma, tanto el nombre, el retorno y argumentos, lo unico que puede cambiar es el modificador de acceso, pero un metodo que se sobreescribe no puede ser menos accesible que al metodo que sobreescribe, por ejemplo no puede pasar de public a protected o privado, pero si de privado a public.

## Polimorfismo

Es la avilidad de ejecutar métodos sintacticamente iguales en tipos distintos, por ejemplo.
```
Empleado empleado = new Empleado("Juan", 1000);
		
empleado = new Gerente("David",2000,"Finanzas");
```

Podemos ver como el objeto empleado auque haya sido instanciado de la clase Empleado puede contener un objeto de la clase Gerente, esto es debido a que guardan una relación de Herencia, pero entonces si se utilizara el método sobreescrito `obtenerDetalle()` cual de las dos implementaciones utilizaría?, la respuesta es la que este en tiempo de ejecución, a la cual está haciendo referencia, la que sería el de la clase Gerente para nuestro caso.

La importancia del polimorfismo es que podemos generalizar un método que resiba distintos tipos en la gerarquia de clases definidas, clases padres e hijas, por ejemplo:

```
public static void imprimirDetalle(Empleado empleado) {
	System.out.println(empleado.obtenerDetalle());
}

public static void main(String[] args) {		
	Empleado empleado = new Empleado("Juan", 1000);
	imprimirDetalle(empleado);
	empleado = new Gerente("David",2000,"Finanzas");
	imprimirDetalle(empleado);
}
```
Podemos observar como es posible imprimir el detalle sin necesidad de utilizar varios tipos, solo utilizando el tipo padre, la clase Empleado.

## Instance of 
sirve para responder si una clase tiene alguna relación con otra clase que indiquemos. por ejemplo si tenemos una clase de tipo `Elipse` que extiende de la clase `Circulo` podemos preguntar si un objeto elipse guarda relación con la clase Circulo de la siguiente manera

```
Elipse figura = new Elipse()

if(figura instanceof Circulo)
```
Si guarda relación devolvería true, de lo contrario false. Esto nos sirve a identificar de que tipo es una clase y por lo tanto tomar decisiones apartir de esto. por ejemplo en el polimorfismo identificar de que tipo es la clase para tomar decisiiones dependiendo de lo que tengamos.

## Conversion de Objetos (casting)

Se puede hacer conversión entre tipos de clases, cuando estamos entre clases heredadas. Si hacemos una conversión de una clase hija a una clase padre se conoce como upcasting, pero si lo hacemos desde la clase padre a la clase hija se conoce como downcasting.

### Upcasting 
En este tipo no es necesario decirle al compilador que vamos hacer un casting, por ejem:

```
Empleado empleado;
		
empleado = new Escritor("Roy",1500,TipoEscritura.CLASICO);
```
La clase Escritor extiende de la clase empleado. Hay que tener en cuenta que los métodos que hayan en la clase Escritura pero no en la clase Empleado no se podrán llamar, aunque se haya hecho el casting.

### Downcasting

En este tipo de casting es necesario decirle al compildor que se va hacer un casting de la siguiente manera:
```
Escritor escritor = (Escritor) empleado;
resultado = escritor.getTipoEscrituraEnTexto();
			
resultado = ((Escritor) empleado).getTipoEscritura().getDescripcion();
```

Se puede ver como en la primera forma hay que instanciar un objeto de la clase Escritor para poder acceder a un método, mientras en la segunda forma no, aunque esta es un poco mas confusa de entender.

## Clase Object
Esta es la clase más importate en java y todas las calses heredan de manera indirecta o directamente de esta, algunos de sus métodos mas importantes son los siguientes:

### toString
Este metodo nos sirve para hacer una representación de texto de las clases, si no se sobreescribe este metodo mostrará una referencia de memoria en la que está, el nombre de la clase, etc..	

### equals
Este metodo nos sirve para comparar dos objetos, se debe de recordar que cuando se compara dos objetos con el operador `==` este estará comparando la referencia en memoria, lo cual no sirve mucho que digamos, pero con el metodo equals se compará el contenido de la clase.

### hashcode
Es metodo tambien nos sirve para comparar dos objetos solo que mienstras en equals compara su condinido el hascode compara su representación en entero

## Clases Abstractas
Si una clase contiene un método abstracto la clase tambien se debe declarar como clase abstracta, estas clases pueden contener método abstractos pero tambien no abstractos, además un método abstracto no tiene cuerpo y solo termina con `;` de esta manera unmetodo abstracto solo agrega la firma del método pero ningun comportamiento y son las clases hijas las que se encargan de implementar este método. por lo tanto la clase hija no sebreescribe el método heredado si no que lo implementa.

```
public abstract class FiguraGeometrica {
	
	abstract void dibujar();
}

public class Rectangulo extends FiguraGeometrica{
	@Override
	void dibujar() {
		// TODO Auto-generated method stub	
	}
}
```
Una clase abstracta no se puede instanciar y esto es debido a que algo abstracto no puede materializarce en un objeto, lo que si se puede hacer es crear objetos de la clase hijas en instancias de la clase padre
```
public static void main(String[] args) {
	FiguraGeometrica figura = new FiguraGeometrica() //marca error
				
	FiguraGeometrica figura2 = new Rectangulo(); //Si permite
}
```

## Interfaces

Una interface en la vida real es una forma en común  de comunicarse entre diferentes dispositivos o sistemas. En java una interface define el comportamiento de una clase, ya la clase implementa ese comportamiento. Una interface puede heredar de otra interface pero no de una clase en concreta, muchas clases pueden implementar la misma interface y una clase puede implentar muchas interfaces, al igual que las clases no se puede implentar objetos de una interfaces, pero si instanciar objetos que tengan una referencia de clases que implementan dicha interface, de está manera aplica el método de polimorfismo

## clases abstractas vs interfaces
Una clase abstracta se utiliza para encapsular funcionalidad común entre las clases es decir caracteristicas en común y para hacer uso de esta se debe de extender de la clase abstracta, en cambio una interface define comportamiento relacionado que puede pertenecer a cualquier clase o estructura y para hacer uso de esta se debe implementar de la interface. Las clase abstractas deben utilizarse para objetos estrechamente relacionados, mientras las interfaces son adecuadas para proporcionar funcionalidad común a clases no relacionadas entre si.

## Ejemplo interfaces

```
public interface AccesoDatos {
	
	public static int MAX_REGISTROS = 10;
	
	public abstract void insertar();
	
	public abstract void listar();
}

public class ImplementacionMysql implements AccesoDatos{

	@Override
	public void insertar() {
		System.out.println("Insertar en base de datos mysql");	
	}

	@Override
	public void listar() {
		System.out.println("Listar en base de datos mysql");	
	}
}

public class ImplementacionOracle implements AccesoDatos{

	@Override
	public void insertar() {
		System.out.println("Insertar en base de datos oracle");	
	}

	@Override
	public void listar() {
		System.out.println("Listar en base de datos oracle");	
	}
}
```

## Java Beans

Un java beans es una clase pura de java la cual cumple ciertas reglas para llamarse java beans, la idea es que estas puedan ser utilizadas en otras clases sin necesidad de conocer a detalle el contenido de la clase, por ello debe de cumplir con ciertas reglas:

1. Debe tener un constructor vacio, ya que las tecnologias que hagan uso de nuestro javabeans deben poder instanciar nuestras clases y para elo no se pueden complicar e instanciaran una clase javabeans con el constructor vacio.

2. Los atributos deben ser privados

3. Cada propiedad debde de tener su método get o set

4. Implementara la interface Serializable del paquete java.io

No se debe de confundir los java beans con los enterprise java beans, ya que estos ultimos son tecnologías del lado del servidor en cambio los java beans pueden utilizarce en cualquier version de java

## Excepciones en java

Una excepcion es una situación no esperada en java, existen varias clases en java para excepciones, pero si no existe una que se adecue a nuestra aplicacion podemos crear nuestras propias excepciones 

### Tipos de excepciones

Excepciones que heredan de la clase Exception, si el programa arroja este tipo de excepciones el compilador solicitará alguna actividad con este tipo de excepción, por ejemplo procesarlas dentro de una bloque try y catch o arrojandolas en la declaración del método, por ejemlo SQLException que es relacionada cuando hay un problema con temas de manejo y uso de bases de datos.

Excepciones que heredan de las clases RuntimeException en este tipos de excepciones no estamos obligados a procesarlas por lo que es obcional el uso de bloque try o catch o en la declaración del método, a este tipos de excepciones también se le conocen como excepciones en tiempo de ejecución, por ejemplo el NullPointerException. En los ultimos años existe una tendencia a usar este tipos de excepciones ya que obtine un código más limpio, permitiendo escoger al equipo de desarrollo si procesan o no las excepciones.


## Colecciones en Java

### Api de colecciones en Java
Se divide en listas, sets y mapas, los sets son cojuntos de datos y los mapas son una llave relacionada con un dato, los mapas utilizan funciones hash para el ordenamiento de sus elementos, lo que permite que el ordenamiento de datos sea más ágil. Un set es una colección no ordenada de elementos, no se permite elementos duplicados, una lista es una colección ordenada que si permite elementos repetidos.

```
public class Main {

	public static void main(String[] args) {
		
		List lista = new ArrayList();		
		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");
		//valor repetido
		lista.add("3");
		imprimir(lista);
		
		Set sets = new HashSet();
		sets.add("1");
		sets.add("2");
		sets.add("3");
		sets.add("4");
		//valor repetido
		sets.add("3");
		imprimir(sets);
		
		Map maps = new HashMap();
		maps.put("1", "Juan");
		maps.put("2", "david");
		maps.put("3", "carlos");
		maps.put("4", "andres");
		imprimir(maps.keySet());
		imprimir(maps.values());
	}
	
	public static void imprimir(Collection collection) {
		
		for (Object c : collection) {
			System.out.print(c + ", ");
		}
		System.out.println("");
	}

}
```
## Genericos
Con los genericos no es necesario saber el tipo de dato que se le va pasar a una función. Existe las siguintes conveciones a la hora de utilizar estos tipos Genericos.

E: Element(Utilizado generalmento por el framework de colecciones en java)
K: Key(Utilizado en mapas)
N: Number(utilizado para numeros)
T: Type(Representa un tipo, es decir, una clase)
V: Value(Representa un valor, es usado en mapas)
S,U,V: Usado para representar otros tipos 

Ejemlo:
```
public class ClaseGenerica<T> {
	T objeto;
	
	public ClaseGenerica(T objeto){
		this.objeto = objeto;
	}
	
	public void obtenerTipo() {
		System.out.println("El tipo es "+ objeto.getClass().getName());
	}
}
public static void main(String[] args) {
		
	ClaseGenerica<Integer> objetoInt = new ClaseGenerica<Integer>(150);
	objetoInt.obtenerTipo();
		
	ClaseGenerica<String> objetoString = new ClaseGenerica<String>("Prueba");
	objetoString.obtenerTipo();
}
```
Otro ejemplo con colecciones es:
```
public static void main(String[] args) {
		
		List<String> lista = new ArrayList<>();		
		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");
		//valor repetido
		lista.add("3");
		imprimir(lista);
		
		Set<String> sets = new HashSet<>();
		sets.add("1");
		sets.add("2");
		sets.add("3");
		sets.add("4");
		//valor repetido
		sets.add("3");
		imprimir(sets);
		
		Map<String, String> maps = new HashMap<>();
		maps.put("1", "Juan");
		maps.put("2", "david");
		maps.put("3", "carlos");
		maps.put("4", "andres");
		imprimir(maps.keySet());
		imprimir(maps.values());
	}
	
	public static void imprimir(Collection<String> collection) {
		
		for (Object c : collection) {
			System.out.print(c + ", ");
		}
		System.out.println("");
	}

```

## Entradas y salidas de datos

### Consola entrada y salida de datos
Existen tresvariables con las cuales podemos interactuar con la consola del sistema operativo.
System.in implementa la entrada estándar
System.out implementa la salida estándar
System.err implementa la salida de error

Ejemplo de System.in:
```
public static void main(String[] args) {
	String captura;
	InputStreamReader input = new InputStreamReader(System.in);
	BufferedReader bInput = new BufferedReader(input);
	try {
		System.out.println("Introduce un dato:");
		captura = bInput.readLine();
		while(captura != null) {
			System.out.println("Dato introducido: " + captura);
			captura = bInput.readLine();
		}
	}catch (IOException e) {
		e.printStackTrace();
	}
}
```
Utilizando la clase Scanner:
```
public static void main(String[] args) {
	String captura = null;
	Scanner scan = new Scanner(System.in);
	System.out.println("Introduce un dato:");
	captura = scan.nextLine();
	while(captura != null) {
		System.out.println("Dato introducido: " + captura);
		captura = scan.nextLine();
	}
}
```
## Manejo de archivos en java

### Creación de archivos
```
public static void main(String[] args) {
	File archivo = new File("/home/david/prueba.txt");
	try {
		PrintWriter salida = new PrintWriter(new FileWriter(archivo));
		salida.println("Información dentro del archivo");
		salida.close();
	}catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println("El archivo se ha creado correctamente");
}
```
Se utilizan las clases File, FileWriter y PrintWriter para crear un archivo. Primero se crea un archivo con la clase File, pero esto no crea un archivo físio, para ello utilizamos la clase FileWriter y la clase PrintWriter quien es la encargada de crear el archivo en el disco duro. También podemos notar como con el método `println()` podemos agregar información al archivo. Cada vez que se ejecute este código creará un nuevo archivo y borrará el anterior, si no se desea esto y se quiera guardar el contenido que ya contenía el archivo y solo agregar lineas nuevas, simplemente se debe de agregar true al crear FileWrite, `new FileWriter(archivo, true)`.

### Lectrua de archivos
```
public static void main(String[] args) {
	File archivo = new File("/home/david/prueba.txt");
	try {
		BufferedReader entrada = new BufferedReader(new FileReader(archivo));
		String lectura;
		lectura = entrada.readLine();
		while(lectura != null) {
			System.out.println(lectura);
			lectura = entrada.readLine();
		}
		entrada.close();
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
}
```
Para leer un archivo utilizamos las clases File, FileReader y BufferedReader, en donde esta ultima es la encargada de leer el archivo.

# JDBC en Java

JDBC es un Api que se utiliza en la capa de Datos y nos ayuda a conectarnos con la base de datos entre más funciones. Para utilizar JDBC se deben de seguir los siguientes pasos:

1. Descargar el driver dependiendo de la base de datos a utilizar
2. Agregar el driver al clashpath de la aplicación
3. Creamos una clase java que haga los siguientes pasos:
	-Registrar el driver JDBC
	-Crea una conexion a la bd
	-Crea una sentencia SQL
	-Ejecuta la sentencia
	-cerrar los objetos creados como las conexiones

```
public static void main(String[] args) {
	String url = "jdbc:mysql://localhost:3306/sga?useSSL=false";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
			
		Connection conexion = (Connection) DriverManager.getConnection(url,
				"root","root");
		
		Statement instruccion = conexion.createStatement();
		
		String query = "select * from Personas";
			
		ResultSet resultado = instruccion.executeQuery(query);
			
		while(resultado.next()) {
			System.out.print(resultado.getInt(1) + " ");
			System.out.print(resultado.getString(2) + " ");
			System.out.println(resultado.getString(3));
		}
		resultado.close();
		instruccion.close();
		conexion.close();
	}catch (ClassNotFoundException | SQLException e) {
		e.getStackTrace();
	}
}
```
## Driver JDBC

Existen tres formas para conectarce a una base de datos a traves de los drives del JDBC, la primera forma es utilizando el DriverManager como se muestra en el ejemplo anterior, esta clase se encuentra en el paquete `java.sql`. La segunda forma se utiliza el concepto de DataSource, esta obción es la más recomendada. La ultima forma es por medio del pool de conexiones.

## Tipos de statement (sentencias) en JDBC
La interface statement de JDBC tiene distintos tipos
-Statement: Se utiliza para cualquier tipo de sentencia SQL, pero no hace cache del SQL ejecutado.Cuando sea que una consulta es ejecutada en SQL Server, su plan de ejecución, así como algunos datos útiles de ejecución son ubicados en el caché del plan para usos futuros.

-PreparedStatement: Se utiliza para hacer caché del query, evitando la recopilación de la sentencia SQL. Se recomienda si se va a utilizar una sentencia SQL en repetidas ocaciones

-CallableStatement: Se utiliza para llamar procedimientos de una base de datos.

## Métodos de la interface statements en JDBC
Para una sentencia SELECT:
-executeQuery(String sql): Regresa un objeto ResultSet para procesar los registros.

Para una sentencia DML/DDL:
-executeUpdate(String sql): Regrasa un int, numero de datos que se han modificado.

Para cualquier sentencia:
-execute(String sql): Regresa un boolean, true si se ejecuta un select o false si se ejecuta cualquir tipo de sentencia.

## Excepciones en JDBC

- SQLException
	-SQLWarning
		-DataTruncationException
	-BatchUpdateException
	
## Transacciones con JDBC
Una transaccion es un conjunto de sentencias SQL (select, update ..) las cuales son agrupadas en bloques de ejecución y si algunas de las ejecuciones falla podemos dar marcha atras haciendo un rollback a todo el bloque ejecutado y si los cambios son correctos podemos guardar los cambios haciendo commit al bloque ejecutado. Sus métodos son:
-autocommit: (valores true o false)
-commit: guardas los cambios del bloque de ejecució en la db
rollback: revierte los cambios del bloque de ejecución.

Por default el autocomit tiene valor de true, por la tanto es bueno que se ponga en false por si hay un error y toque hacer un rollback.

Si cerramos la conexión de JDBC se hace un autocomit aunque se tenga deshabilitada esta función.

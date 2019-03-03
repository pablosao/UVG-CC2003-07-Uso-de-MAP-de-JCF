# Uso de MAP de JCF

Utilice el de diseño Factory para seleccionar la implementación de MAP que usará su programa, en tiempo de corrida. El usuario debe seleccionar entre: 
1. HashMap. 
2. TreeMap. 
3. LinkedHashMap. 
 
El programa lee un archivo, el cual esta adjunto en la raíz del directorio con el nombre _**cards_desc.txt**_ que contiene una lista de nombres de cartas y si dicha carta es monstruo, trampa o hechizo. Dichas cartas se agregan a un Mapa que contiene todas las cartas disponibles. 
 
El archivo sigue la siguiente estructura: Cada carta se encuentra en una línea distinta y tiene el nombre luego el carácter | y el tipo de la carta. Un ejemplo del archivo es el siguiente: 
 
> Nombre Carta 1|Tipo  
> Nombre de Carta 2|Tipo


 
Luego de leer el archivo su programa debe permitir al usuario realizar las siguientes operaciones: 
 
1. Agregar una carta a la colección del usuario. Para esto el usuario ingresa el nombre de la carta que desea agregar a la misma. 
   - **NOTA:** _El usuario puede tener más de una carta de cada tipo._ 
   - **NOTA:** _Si el usuario ingresa una carta que no se encuentra entre las cartas disponibles el programa debe mostrar un error._ 
2. Mostrar el tipo de una carta específica. El usuario ingresará el nombre de la carta y se muestra el tipo de esa carta. 
3. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección. 
4. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección, ordenadas por tipo. 
5. Mostrar el nombre y tipo de todas las cartas existentes. 
6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo. 

### Prerequisitos

Para ejecutar el programa es necesario contar con:

* Java >= 8.0.172
* [Netbeans Profiler](https://profiler.netbeans.org/)


##Referencias

* Javin Paul. (2018). _How to Sort Map by values in java 8 using Lambdas and Stream - Example Tutorial_. Extraído de: http://www.java67.com/2017/07/how-to-sort-map-by-values-in-java-8.html
* ORACLE. (s.f.). _Interface Map<K,V>_. Extraído de: https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
* Sridhar, J. (2017). _Java HashMap Search and Sort_. Extraído de: https://dzone.com/articles/java-hashmap-search-and-sort

## Autor

* **Pablo Sao** - [psao](https://github.com/psao)

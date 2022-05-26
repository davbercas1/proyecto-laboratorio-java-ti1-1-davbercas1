# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  21/22)
Autor/a: David Berrocal Castellano   uvus: davbercas1

El dataset tiene información sobre las diferentes películas lanzadas por el estudio Disney, con la intención de recoger esta información y poder trabajar sobre ella.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.pelicula**: Paquete que contiene los tipos del proyecto.
  * **fp.pelicula.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
  
* **/data**: Contiene el dataset o datasets del proyecto
    * **\<diney_movies.csv\>**: Información sobre las diferentes películas lanzadas por el estudio Disney.
    
## Estructura del *dataset*

URL del dataset: https://www.kaggle.com/datasets/prateekmaj21/disney-movies

El dataset está compuesto por 6 columnas, con la siguiente descripción:

* **\<movie_title>**: de tipo String, representa el título de la película.
* **\<release_date>**: de tipo LocalDate, representa la fecha en la que fue lanzada la película.
* **\<genre>**: de tipo Genero, representa de qué género se trata la película.
* **\<mpaa_rating>** de tipo Categoria, la MPAA es un sistema de clasificación, que categoriza por edades las películas en cuanto a la madurez que requiere su visualizacion.
* **\<total_gross>**: de tipo Long, es el beneficio obtenido por el estudio en dólares.
* **\<inflation_adjusted_gross>**: de tipo Long, representa el beneficio teniendo en cuenta la inflación económica, ajustada a 2016.

## Tipos implementados

En el proyecto tratamos con un tipo String, un LocalDate, dos Enum (Genero y Categoria) y dos Long para manejar números enteros grandes.

**Propiedades**:

- _titulo_, de tipo String, consultable y modificable. 
- _fecha_, de tipo LocalDate, consultable y modificable. 
- - _genero_, de tipo Genero, consultable y modificable. 
- - _categoria_, de tipo Categoria, consultable y modificable. 
- - _beneficio_, de tipo Long, consultable y modificable. 
- - _beneficio_inflacion_, de tipo Long, consultable y modificable. 

**Constructores**: 

- C1: Constructor que recibe todos los parámetros.
- C2: Constructor que sólo recibe título y fecha.
- C3: Constructor a partir de cadena String.

**Restricciones**:
 
- R1: Año no puede ser menor de 1923 en fecha.
 
**Criterio de igualdad**: Se concebirá dos objetos iguales si tienen la misma fecha y título.

**Criterio de ordenación**: Se ordenan a partir de fecha y si es la misma, por orden alfabético del título.

**Otras operaciones**:
 
-	_toString()_: Representación en cadena de las propiedas que tiene una pelicula.
- _porcentajeInflacion()_: Devuelve el porcentaje de incrementación de la inflación con respecto la fecha en la que fue lanzada la película. 
- _()_: 

#### Tipos auxiliares
Descripción de los tipos auxiliares que sean necesarios añadir al proyecto.

### Factoría (FactoriaCartelera)
Lee el fichero csv, dividiendo cada fila en String.


### Tipo Contenedor (Cartelera)

Lo usamos para incluir las diferentes peliculas en un conjunto y poder aplicar los métodos.

**Propiedades**:

- _cartelera_, de tipo Set, consultable y modificable. 
 
**Constructores**: 

- C1: Constructor vacío, no hay que pasar ningún argumento.
- C2: Constructor a partir de un conjunto de películas.
- C3: Constructor a partir de un Stream de películas.

**Restricciones**:
 
- No tiene restricciones

**Criterio de igualdad**: Las carteleras serán iguales si sus elementos son los mismos.

**Criterio de ordenación**: No tiene ningún criterio de ordenación.

**Otras operaciones**:
 
-	_numeroPeliculas()_: Obtener el número de películas en la cartelera.
-	_añadirPelicula (Pelicula p)_: Añadir una película p al conjunto a una cartelera.
-	_añadirCartelera (Set<Pelicula> c)_: Añadir un conjunto de películas a la cartelera.
-	_eliminaPelicula (Pelicula p)_: Eliminar una película de la cartelera.
-	_existePeliculaBillonaria()_: Busca si existe alguna película en la cartelera con más de 1.000.000.000 de dólares de beneficio.
-	_existePeliculaBillonariaStream()_: Lo mismo pero uso el método stream para solucionarlo.
-	_numeroPeliculasMusicales()_: Cuenta las películas de género musical que existen en la cartelera.
-	_numeroPeliculasMusicalesStream()_: Lo mismo pero uso el método stream para solucionarlo.
-	_conjuntoPeliculasPG()_: Filtra la cartelera, devolviendo un conjunto de las peliculas con la categoría PG.
-	_conjuntoPeliculasPGStream()_: Lo mismo pero uso el método stream para solucionarlo.
-	_peliculasPorAño()_: Mapa en el que la clave es el año en el que salió cada película y sus valores son las películas de esa año.
-	_peliculasPorAñoStream()_: Lo mismo pero uso el método stream para solucionarlo.
-	_numeroPelisPorMes()_: Mapa en el que la clave es el mes que salió cada película y su valor es el número de peliculas que salieron ese mes.
-	_numeroPelisPorMesStream()_: Lo mismo pero uso el método stream para solucionarlo.
- _peliculaGeneroMasReciente()_: Le pasamos como parámetro un género y devuelve la película más reciente de ese género
- _titulosOrdenadosPorAntiguedadYMes()_: Le pasamos como parámetro un mes (del 1 al 12) y devuelve una lista de películas ordenada de más antiguos a recientes.
- _numeroPeliculas()_: Pasamos como parámetro una categoría y devuelve el número de películas existentes de ese género.
- _peliMasTaquilleraPorGenero()_: Mapa en el que la clave es el género y su clave es la película mas taquillera de este género.
- _peoresPeliculasPorAñoOrdenado()_: Pasamos como parametro un número n y devuelve un mapa en el que las claves son todos los años y los valores son una lista de n películas las cuales han sido las que menos beneficios generaron.
- _generoConMasPeliculas()_: Función que devuelve un Entry con con el género que más peliculas han producido y el valor del número de películas de género.



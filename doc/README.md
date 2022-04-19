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
-	_numeroPeliculasMusicales()_: Cuenta las películas de género musical que existen en la cartelera.
-	_conjuntoPeliculasPG()_: Filtra la cartelera, devolviendo un conjunto de las peliculas con la categoría PG.
-	_peliculasPorAño()_: Mapa en el que la clave es el año en el que salió cada película y sus valores son las películas de esa año.
-	_numeroPelisPorMes()_: Mapa en el que la clave es el mes que salió cada película y su valor es el número de peliculas que salieron ese mes.



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

### Factoría
Descripción breve de la factoría.

- _método 1_: Descripción del método 1.
-	_método 2_: Descripción del método 2.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...

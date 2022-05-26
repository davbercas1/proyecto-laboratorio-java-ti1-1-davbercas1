package fp.pelicula;


import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.pelicula.Pelicula;


public class Cartelera {
	private Set<Pelicula> cartelera;
	

	public Cartelera(Set<Pelicula> c) {
		this.cartelera = new HashSet<>();
		cartelera.addAll(c);
	}
	
	public Cartelera () {
		this.cartelera = new HashSet<>();
	}
	
	public Cartelera(Stream<Pelicula> c) {
		cartelera = c.collect(Collectors.toSet());
	}
	
	public Set<Pelicula> getCartelera() {
		return new HashSet<Pelicula>(this.cartelera);
	}
	
	//a.a) Obtener el número de elementos.
	public Integer numeroPeliculas() {
		return this.getCartelera().size();
	}
	
	//a.b) Añadir un elemento.
	public void añadirPelicula (Pelicula p) {
		this.cartelera.add(p);
	}
	
	//a.c) Añadir una colección de elementos.
	public void añadirCartelera (Set<Pelicula> c) {
		this.cartelera.addAll(c);
	}
	
	//a.d) Eliminar un elemento.
	public void eliminaPelicula (Pelicula p) {
		this.cartelera.remove(p);
	}
	
	//1) Existe
	public Boolean existePeliculaBillonaria () {
		Boolean res = false;
		for (Pelicula p:cartelera) {
			if (p.getBeneficio_inflacion() > 1000000000) {
				res = true;
				break;
			}
		}
		return res;
	}
	public Boolean existePeliculaBillonariaStream () {
		return cartelera.stream() //el tipo qe tenemos aqi es Stream<Pelicula>
				.anyMatch(x->x.getBeneficio_inflacion() > 2000000000);
	}
	
	
	//2) Contador
	public Integer numeroPeliculasMusicales() {
		Integer cont = 0;
		for (Pelicula p:cartelera) {
			if (p.getGenero().equals(Genero.MUSICAL)) {
				cont++;
			}
		}
		return cont;
	}
	public Long numeroPeliculasMusicalesStream() {
		return cartelera.stream()
				.filter(x-> x.getGenero().equals(Genero.MUSICAL))
				.count();
	}
	
	
	//3) Una selección con filtrado.
	public Set<Pelicula> conjuntoPeliculasPG () {
		Set<Pelicula> conjunto = new HashSet<>();
		for (Pelicula p:cartelera) {
			if (p.getCategoria().equals(Categoria.PG)) {
				conjunto.add(p);
			}
		}
		return conjunto;
	}
	public Set<Pelicula> conjuntoPeliculasPGStream () {
		return cartelera.stream()
				.filter(x-> x.getCategoria().equals(Categoria.PG))
				.collect(Collectors.toSet());
	}
	
	
	//4) Map con una coleccion.
	public Map<Integer,Set<Pelicula>> peliculasPorAño () {
		Map<Integer, Set<Pelicula>> res = new HashMap<>();
		for (Pelicula p:cartelera) {
			Integer año = p.getFecha().getYear();
			if(res.containsKey(año)) {
				res.get(año).add(p);
			} else {
				Set<Pelicula> conj = new HashSet<>();
				conj.add(p);
				res.put(año, conj);
			}
		}
		return res;
	}
	
	public Map<Object, List<Pelicula>> peliculasPorAñoStream () {
		return cartelera.stream()
				.collect(Collectors.groupingBy(p -> p.getFecha().getYear()));
	}
	
	//5) Map con contador.
	public Map<Integer, Integer> numeroPelisPorMes () {
		Map<Integer, Integer> res = new HashMap<>();
		for (Pelicula p:cartelera) {
			Integer mes = p.getFecha().getMonthValue();
			if (res.containsKey(mes)) {
				res.put(mes, res.get(mes)+1);
			} else {
				res.put(mes, 1);
			}
		}
		return res;
	}
	
	public Map<Integer, Long> numeroPelisPorMesStream () {
		return getCartelera().stream()
				//.collect(Collectors.groupingBy(p -> p.getFecha().getMonth()),
				.collect(Collectors.groupingBy(x->x.getFecha().getMonthValue(),
						Collectors.counting()));
	}
	
	// 9) Un máximo/mínimo con filtrado.
	public Pelicula peliculaGeneroMasReciente (Genero g) {
		return cartelera.stream()
				.filter(x->x.getGenero().equals(g))
				.max(Comparator.comparing(Pelicula::getFecha))
				.orElse(null);
				//.collect(Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Pelicula::getFecha)),
						//o -> o.get()));
	}
	// 10) Una selección, con filtrado y ordenación.
	public List<String> titulosOrdenadosPorAntiguedadYMes (Integer i) {
		return cartelera.stream()
				.filter(x->Integer.valueOf(x.getFecha().getMonthValue()).equals(i))
				.sorted(Comparator.comparing(x->x.getFecha()))
				.map(Pelicula::getTitulo)
				.collect(Collectors.toList());
	}
	// 12) Un método en cuya implementación se use, o bien el Collector collectingAndThen,
	// o bien el Collector mapping.
	public Integer numeroPeliculas (Categoria c) {
		return cartelera.stream()
				.filter(x->x.getCategoria().equals(c))
				.collect(Collectors.collectingAndThen(Collectors.counting(), x -> x.intValue()));
				
	}
	// 13) Un método que devuelva un Map en el que las claves sean un atributo o una función sobre
	// un atributo, y los valores son máximos/mínimos de los elementos que tienen ese valor.
	public Map<Genero, Pelicula> peliMasTaquilleraPorGenero () {
		return cartelera.stream()
				.collect(Collectors.groupingBy(Pelicula::getGenero,
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Pelicula::getBeneficio_inflacion)),
								o->o.get())));				
	}
	// 14) Un método que devuelva un SortedMap en el que las claves sean un atributo o una función
	// sobre un atributo, y los valores sean listas con los n mejores o peores elementos que
	// comparten el valor de ese atributo (o función sobre el atributo).
	public List<Pelicula> ordenaLista (List<Pelicula> lista, Integer n) {
		return lista.stream()
				.sorted(Comparator.comparing(Pelicula::getBeneficio_inflacion))
				.limit(n)
				.toList();
	}
	public SortedMap<Integer, List<Pelicula>> peoresPeliculasPorAñoOrdenado(Integer n) {
		return cartelera.stream()
				.collect(Collectors.groupingBy(x->x.getFecha().getYear(),
						TreeMap::new,
						Collectors.collectingAndThen(Collectors.toList(), x -> ordenaLista(x,n))));
	}
	
	// 15) Un método que calcule un Map y devuelva la clave con el valor asociado (mayor o menor)
	// de todo el Map. 
	public Entry<Genero, Long> generoConMasPeliculas () {
		return cartelera.stream()
				.collect(Collectors.groupingBy(Pelicula::getGenero,
						Collectors.counting()))
				.entrySet().stream()
				.max(Comparator.comparing(x->x.getValue())).orElse(null);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartelera == null) ? 0 : cartelera.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartelera other = (Cartelera) obj;
		if (cartelera == null) {
			if (other.cartelera != null)
				return false;
		} else if (!cartelera.equals(other.cartelera))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cartelera [getCartelera()=" + getCartelera() + ", numeroPeliculas()=" + numeroPeliculas() + "]";
	}
	
}
//STREAMS: operaciones intermedias devuelven string, operaciones terminales devuelven otros tipos.
// o -> o.get(); SE QUEDA CON EL PRIMER OBJETO SOLO


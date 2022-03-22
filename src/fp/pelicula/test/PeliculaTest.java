package fp.pelicula.test;

import java.time.LocalDate;

import fp.pelicula.Categoria;
import fp.pelicula.Genero;
import fp.pelicula.Pelicula;

public class PeliculaTest {
	public static void main(String[] args) {
		
		Pelicula p1 = new Pelicula("Snow White and the Seven Dwarfs",LocalDate.of(1937, 12, 21), Genero.MUSICAL, Categoria.G, Long.valueOf("184925485").longValue(), Long.valueOf("5228953251").longValue());
		Pelicula p2 = new Pelicula("Aladdin,1992-11-11,Comedy,G,217350219,441969178");
		Pelicula p3 = new Pelicula("Snow White and the Seven Dwarfs",LocalDate.of(1937, 12, 21), Genero.MUSICAL, Categoria.G, Long.valueOf("184925485").longValue(), Long.valueOf("5228953251").longValue());
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println(p1.getFecha());
		System.out.println(p1.equals(p3));
		p1.setFecha(LocalDate.of(2022, 03, 20));
		p1.setGenero(Genero.HORROR);
		System.out.println(p1);
		System.out.println(p2.compareTo(p1));
		
		p1.setFecha(LocalDate.of(1920, 10, 1));
		

		
		
	}
}

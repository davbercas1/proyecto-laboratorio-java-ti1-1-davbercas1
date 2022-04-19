package fp.pelicula.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import fp.pelicula.Pelicula;
import fp.pelicula.Cartelera;
import fp.pelicula.Categoria;
import fp.pelicula.FactoriaCartelera;
import fp.pelicula.Genero;

public class TestCartelera {
	public static void main(String[] args) {	    
		Cartelera c1 = new Cartelera();
		String datos = "data/disney_movies.csv";
		Set<Pelicula> lp = FactoriaCartelera.leerPeliculas(datos);
		c1.añadirCartelera(lp);
		Cartelera c2 = new Cartelera(lp);
		Pelicula p1 = new Pelicula("Snow White and the Seven Dwarfs",LocalDate.of(1937, 12, 21), Genero.MUSICAL, Categoria.G, Long.valueOf("184925485").longValue(), Long.valueOf("5228953251").longValue());
		
		//System.out.println(c1.equals(c2));
		//System.out.println(c1);
		//System.out.println(lp.contains(p1)); //comparo lp, no c1, ya que contains es un metodo para colecciones, no para objetos
		//System.out.println(c1.getCartelera());
		//System.out.println(c1.existePeliculaBillonaria());
		//System.out.println(c1.numeroPeliculas());
		//System.out.println(c1.numeroPeliculasMusicales());
		//System.out.println(c1.numeroPeliculasMusicalesStream());
		//System.out.println(c1.conjuntoPeliculasPG());
		//System.out.println(c1.conjuntoPeliculasPGStream());
		//System.out.println(c1.peliculasPorAño());
		//System.out.println(c1.peliculasPorAñoStream());
		//c1.eliminaPelicula(p1);
		//System.out.println(c1.numeroPelisPorMes());

	}
}





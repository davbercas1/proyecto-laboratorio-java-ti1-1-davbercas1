package fp.pelicula;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class FactoriaCartelera {
	public static Set<Pelicula> leerPeliculas(String archivo){
		Set<Pelicula> res=new HashSet<Pelicula>();
		try {
			List<String> lineas=Files.readAllLines(Paths.get(archivo));
			for (String linea:lineas.subList(1, lineas.size())) {
				Pelicula p = new Pelicula(linea);
				res.add(p);
			}
		}catch(IOException e){
			e.printStackTrace();
			}
		return res;
	}

}

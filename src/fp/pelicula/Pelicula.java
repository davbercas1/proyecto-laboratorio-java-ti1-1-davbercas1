package fp.pelicula;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Pelicula implements Comparable<Pelicula> {
	private String titulo;
	private LocalDate fecha;
	private Genero genero;
	private Categoria categoria;
	private Long beneficio;
	private Long beneficio_inflacion;
	
	//Constructor 1 (completo)
	public Pelicula(String t, LocalDate f, Genero g, Categoria c, Long b, Long b_i) {
		if (f.getYear() < 1923) {  //Disney se fundo en 1923
			throw new IllegalArgumentException("Año invalido en constructor de fecha = "+ f + ", (" + f.getYear()+ ")." );
		}
		titulo = t;
		fecha = f;
		genero = g;
		categoria = c;
		beneficio = b;
		beneficio_inflacion = b_i;
	}
	
	//Constructor 2 (solo titulo y fecha)
	public Pelicula (String t, LocalDate f) {
		titulo = t;
		fecha = f;
		genero = Genero.NOT_CLASSIFIED;
		categoria = Categoria.NOT_RATED;
		beneficio = Long.valueOf(0);
		beneficio_inflacion = Long.valueOf(0);
	}
	
	/*
	//Constructor 3 (usando un String como en el csv) ej: "Aladdin,1992-11-11,Comedy,G,217350219,441969178"
	public Pelicula (String s) {
		String[] trozos = s.split(",");
		if (trozos.length == 7) {
			titulo = trozos[0].trim() + trozos[1].trim().replace("…","...");
			
			fecha = LocalDate.parse(trozos[2], DateTimeFormatter.ofPattern("y-M-d"));
			
			String g = trozos[3].trim().toUpperCase();
			if (g.equals("")) {
				genero = Genero.NOT_CLASSIFIED;
			} else if (g.equals("ROMANTIC COMEDY")) {
				genero = Genero.ROMANTIC_COMEDY;
			} else if (g.equals("BLACK COMEDY")) {
				genero = Genero.BLACK_COMEDY;
			} else if (g.equals("THRILLER/SUSPENSE")) {
				genero = Genero.THRILLER;	
			} else if (g.equals("CONCERT/PERFORMANCE")) {
				genero = Genero.PERFORMANCE;		
			} else {
				genero = Genero.valueOf(g);
			}
			
			String cat = trozos[4].trim();
			if (cat.equals("G")) {
				categoria = Categoria.G;
			}
			else if (cat.equals("PG")) {
				categoria = Categoria.PG;
			}
			else if (cat.equals("R")) {
				categoria = Categoria.R;
			}
			else if (cat.equals("PG_13")) {
				categoria = Categoria.PG_13;
			}
			else {
				categoria = Categoria.NOT_RATED;
			}
			
			beneficio = Long.valueOf(trozos[5].trim()).longValue();
			beneficio_inflacion = Long.valueOf(trozos[6].trim()).longValue();
		} else if (trozos.length == 8) {
			
			titulo = trozos[0].trim() + trozos[1].trim() + trozos[2].trim().replace("…","...");
			
			fecha = LocalDate.parse(trozos[3], DateTimeFormatter.ofPattern("y-M-d"));
			
			String g = trozos[4].trim().toUpperCase();
			if (g.equals("")) {
				genero = Genero.NOT_CLASSIFIED;
			} else if (g.equals("ROMANTIC COMEDY")) {
				genero = Genero.ROMANTIC_COMEDY;
			} else if (g.equals("BLACK COMEDY")) {
				genero = Genero.BLACK_COMEDY;
			} else if (g.equals("THRILLER/SUSPENSE")) {
				genero = Genero.THRILLER;	
			} else if (g.equals("CONCERT/PERFORMANCE")) {
				genero = Genero.PERFORMANCE;		
			} else {
				genero = Genero.valueOf(g);
			}
				
			String cat = trozos[5].trim();
			if (cat.equals("G")) {
				categoria = Categoria.G;
			}
			else if (cat.equals("PG")) {
				categoria = Categoria.PG;
			}
			else if (cat.equals("R")) {
				categoria = Categoria.R;
			}
			else if (cat.equals("PG_13")) {
				categoria = Categoria.PG_13;
			}
			else {
				categoria = Categoria.NOT_RATED;
			}
		
			
			beneficio = Long.valueOf(trozos[6].trim()).longValue();
			beneficio_inflacion = Long.valueOf(trozos[7].trim()).longValue();
			
		} else {

			titulo = trozos[0].trim().replace("…","...");
		
			fecha = LocalDate.parse(trozos[1], DateTimeFormatter.ofPattern("y-M-d"));
			
			String g = trozos[2].trim().toUpperCase();
			if (g.equals("")) {
				genero = Genero.NOT_CLASSIFIED;
			} else if (g.equals("ROMANTIC COMEDY")) {
				genero = Genero.ROMANTIC_COMEDY;
			} else if (g.equals("BLACK COMEDY")) {
				genero = Genero.BLACK_COMEDY;
			} else if (g.equals("THRILLER/SUSPENSE")) {
				genero = Genero.THRILLER;	
			} else if (g.equals("CONCERT/PERFORMANCE")) {
				genero = Genero.PERFORMANCE;		
			} else {
				genero = Genero.valueOf(g);
			}
			
			String cat = trozos[3].trim();
			if (cat.equals("G")) {
				categoria = Categoria.G;
			}
			else if (cat.equals("PG")) {
				categoria = Categoria.PG;
			}
			else if (cat.equals("R")) {
				categoria = Categoria.R;
			}
			else if (cat.equals("PG_13")) {
				categoria = Categoria.PG_13;
			}
			else {
				categoria = Categoria.NOT_RATED;
			}
			
			beneficio = Long.valueOf(trozos[4].trim()).longValue();
			beneficio_inflacion = Long.valueOf(trozos[5].trim()).longValue();
		}
	}
	*/
	public Pelicula (String s) {
		String[] trozos = s.split(",");
		Integer i = 1;
		
		if (trozos.length == 8) {
			titulo = trozos[0].trim() + trozos[1].trim() + trozos[2].trim().replace("…","...");
			i = 3;
		} else if (trozos.length == 7) {
			titulo = trozos[0].trim() + trozos[1].trim().replace("…","...");
			i = 2;
		} else {
			titulo = trozos[0].trim().replace("…","...");
		}
		
		fecha = LocalDate.parse(trozos[i], DateTimeFormatter.ofPattern("y-M-d"));
			
		String g = trozos[i+1].trim().toUpperCase();
		if (g.equals("")) {
			genero = Genero.NOT_CLASSIFIED;
		} else if (g.equals("ROMANTIC COMEDY")) {
			genero = Genero.ROMANTIC_COMEDY;
		} else if (g.equals("BLACK COMEDY")) {
			genero = Genero.BLACK_COMEDY;
		} else if (g.equals("THRILLER/SUSPENSE")) {
			genero = Genero.THRILLER;	
		} else if (g.equals("CONCERT/PERFORMANCE")) {
			genero = Genero.PERFORMANCE;		
		} else {
			genero = Genero.valueOf(g);
		}
			
		String cat = trozos[i+2].trim();
		if (cat.equals("G")) {
			categoria = Categoria.G;
		} else if (cat.equals("PG")) {
			categoria = Categoria.PG;
		} else if (cat.equals("R")) {
			categoria = Categoria.R;
		} else if (cat.equals("PG_13")) {
			categoria = Categoria.PG_13;
		} else {
			categoria = Categoria.NOT_RATED;
		}
		
		beneficio = Long.valueOf(trozos[i+3].trim()).longValue();
		beneficio_inflacion = Long.valueOf(trozos[i+4].trim()).longValue();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		if (fecha.getYear() < 1923) {  //Disney se fundo en 1923
			throw new IllegalArgumentException("Año invalido en setFecha = "+ fecha + ", (" + fecha.getYear()+ ")." );
		}
		this.fecha = fecha;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Long beneficio) {
		this.beneficio = beneficio;
	}

	public Long getBeneficio_inflacion() {
		return beneficio_inflacion;
	}

	public void setBeneficio_inflacion(Long beneficio_inflacion) {
		this.beneficio_inflacion = beneficio_inflacion;
	}
	
	//Propiedad derivada
	public Double porcentajeInflacion () {
		Long ben = this.beneficio;
		Long ben_i = this.beneficio_inflacion;
		if (ben == 0.) {
			return 0.;
		} else {
			return (ben_i/ben)*100.;
		}
	}

	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", fecha=" + fecha + ", genero=" + genero + ", categoria=" + categoria
				+ ", beneficio=" + beneficio + ", beneficio_inflacion=" + beneficio_inflacion
				+ ", porcentajeInflacion()=" + porcentajeInflacion() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Pelicula other = (Pelicula) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	//Ordenacion por fechas y titulo
	public int compareTo(Pelicula p) {
		int res = this.fecha.compareTo(p.getFecha()); // comparamos por fecha
		if (res==0) {
			res = this.titulo.compareTo(p.getTitulo()); // si son iguales vemos por titulo
		}
		return res;
	}
	
}

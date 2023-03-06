/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoUsuario;
/**
 *
 * @author visitante
 */
public class clsPeliculas {
    private int idPeliculas;
    private String Nombre;
    private String Clasificacion;
     private String Genero;
      private String Subtitulado;
       private String Idioma;
        private String Precio;

    public int getIdPeliculas() {
        return idPeliculas;
    }

    public void setIdPeliculas(int idPeliculas) {
        this.idPeliculas = idPeliculas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getClasificación() {
        return Clasificación;
    }

    public void setClasificación(String Clasificación) {
        this.Clasificación = Clasificación;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getSubtitulado() {
        return Subtitulado;
    }

    public void setSubtitulado(String Subtitulado) {
        this.Subtitulado = Subtitulado;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String Idioma) {
        this.Idioma = Idioma;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public clsPeliculas(int idPeliculas, String Nombre, String Clasificación, String Genero, String Subtitulado, String Idioma, String Precio) {
        this.idPeliculas = idPeliculas;
        this.Nombre = Nombre;
        this.Clasificacion = Clasificación;
        this.Genero = Genero;
        this.Subtitulado = Subtitulado;
        this.Idioma = Idioma;
        this.Precio = Precio;
    }

    public clsPeliculas(int idPeliculas, String Nombre, String Clasificación, String Genero, String Subtitulado, String Idioma) {
        this.idPeliculas = idPeliculas;
        this.Nombre = Nombre;
        this.Clasificacion = Clasificación;
        this.Genero = Genero;
        this.Subtitulado = Subtitulado;
        this.Idioma = Idioma;
    }

    public clsPeliculas(int idPeliculas, String Nombre, String Clasificación, String Genero, String Subtitulado) {
        this.idPeliculas = idPeliculas;
        this.Nombre = Nombre;
        this.Clasificacion = Clasificación;
        this.Genero = Genero;
        this.Subtitulado = Subtitulado;
    }

    public clsPeliculas(int idPeliculas, String Nombre, String Clasificación, String Genero) {
        this.idPeliculas = idPeliculas;
        this.Nombre = Nombre;
        this.Clasificacion = Clasificación;
        this.Genero = Genero;
    }

    public clsPeliculas(int idPeliculas, String Nombre, String Clasificación) {
        this.idPeliculas = idPeliculas;
        this.Nombre = Nombre;
        this.Clasificacion = Clasificación;
    }

    public clsPeliculas(int idPeliculas, String Nombre) {
        this.idPeliculas = idPeliculas;
        this.Nombre = Nombre;
    }

    public clsPeliculas(int idPeliculas) {
        this.idPeliculas = idPeliculas;
    }

    public clsPeliculas() {
    }

    
    @Override
    public String toString() {
        return "clsPeliculas{" + "idPeliculas=" + idPeliculas + ", Nombre=" + Nombre + ", Clasificacion=" + Clasificacion + ",Genero=" + Genero + ",Subtitulado=" + Subtitulado + ",Idioma=" + Idioma + ",Precio=" + Precio+ '}';
    }
    //Metodos de acceso a la capa controlador
    public clsPeliculas getBuscarInformacionPeliculaPorNombre(clsPeliculas pelicula)
    {
        daoPeliculas daopeliculas = new daoPeliculas();
        return daopeliculas.consultaPeliculasPorNombre(pelicula);
    }
    public clsPeliculas getBuscarInformacionPeliculasPorId(clsPeliculas pelicula)
    {
        daoPeliculas daopeliculas = new daoPeliculas();
        return daopeliculas.consultaPeliculasPorId(pelicula);
    }    
    public List<clsPeliculas> getListadoPeliculas()
    {
        daoPeliculas daopeliculas = new daoPeliculas();
        List<clsPeliculas> listadoPeliculas = daopeliculas.consultaPeliculas();
        return listadoPeliculas;
    }
    public int setBorrarPeliculas(clsPeliculas peliculas)
    {
        daoPeliculas daopeliculas = new daoPeliculas();
        return daopeliculas.borrarPeliculas(peliculas);
    }          
    public int setIngresarPeliculas(clsPeliculas peliculas)
    {
        daoPeliculas daopeliculas = new daoPeliculas();
        return daopeliculas.ingresaPeliculas(peliculas);
    }              
    public int setModificarPeliculas(clsPeliculas peliculas)
    {
        daoPeliculas daopeliculas = new daoPeliculas();
        return daopeliculas.actualizaPeliculas(peliculas);
    }              
}

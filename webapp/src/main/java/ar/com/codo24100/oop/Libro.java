package ar.com.codo24100.oop;

// Clase Hijo
public class Libro extends Articulo {
    /*atributos */
    private String isbn;

    /*Constructor */
    public Libro(String titulo, String autor, Float precio, String imagen, String isbn /*propio del hijo*/) {
        //Esto es la llamada al constructor Padre!!
        super(titulo, autor, precio, imagen);
        
        // despues datos del hijo
        this.isbn = isbn;
    }
    /*metodos gets/sets */
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    @Override
    public String toString() {
        return super.toString() + ", Libro [isbn=" + isbn + "]";
    }
}

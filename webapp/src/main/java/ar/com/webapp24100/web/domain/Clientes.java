package ar.com.webapp24100.web.domain;

public class Clientes {

    private long id;
    private String nombre;
    private String apellido;
    private String email;
    private String imagen;
    private long tipoClienteId;
    
    //Para Obtener desde la DB
    public Clientes(long id, String nombre, String apellido, String email, String imagen, long tipoClienteId) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.imagen = imagen;
        this.tipoClienteId = tipoClienteId;
    }

    //Para Crear en la DB
    public Clientes(String nombre, String apellido, String email, String imagen, long tipoClienteId) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.imagen = imagen;
        this.tipoClienteId = tipoClienteId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public long getTipoClienteId() {
        return tipoClienteId;
    }

    public void setTipoClienteId(long tipoClienteId) {
        this.tipoClienteId = tipoClienteId;
    }

    
    
}

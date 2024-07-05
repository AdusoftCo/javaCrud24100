package ar.com.webapp24100.web.dto;

//Son objetos INMUTABLES por que NACE y se keda con los atributos
public class ClientesDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String imagen;
    private Long tipoClienteId;

    //Necesitamos un CONSTRUCTOR "VACIO" por defecto para poder usar JACKSON
    public ClientesDto() {
        
    }

    public ClientesDto(Long id, String nombre, String apellido, String email, String imagen, Long tipoClienteId) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.imagen = imagen;
        this.tipoClienteId = tipoClienteId;
    }

    public ClientesDto(String nombre, String apellido, String email, String imagen, Long tipoClienteId) {
        //this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.imagen = imagen;
        this.tipoClienteId = tipoClienteId;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getImagen() {
        return imagen;
    }

    public Long getTipoClienteId() {
        return tipoClienteId;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setTipoClienteId(Long tipoClienteId) {
        this.tipoClienteId = tipoClienteId;
    }
        
}

package ar.com.webapp24100.web.dto;

import java.sql.Date;

//Son objetos INMUTABLES por que NACE y se keda con los atributos
public class ClientesDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Long tipoClienteId;
    private String imagen;
    private String pais;
    private Date fechaNac;
        
    //Necesitamos un CONSTRUCTOR "VACIO" por defecto para poder usar JACKSON
    public ClientesDto() {
        
    }

    public ClientesDto(Long id, String nombre, String apellido, String email, String password, Long tipoClienteId, String imagen, String pais, Date fechaNac) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.tipoClienteId = tipoClienteId;
        this.imagen = imagen;
        this.pais = pais;
        this.fechaNac = fechaNac;
    }

    public ClientesDto(String nombre, String apellido, String email, String password, Long tipoClienteId, String imagen, String pais, Date fechaNac) {
        //this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.tipoClienteId = tipoClienteId;
        this.imagen = imagen;
        this.pais = pais;
        this.fechaNac = fechaNac;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getTipoClienteId() {
        return tipoClienteId;
    }

    public void setTipoClienteId(Long tipoClienteId) {
        this.tipoClienteId = tipoClienteId;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
}

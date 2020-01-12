package mantenimientos;


	public class Usuario {
    
	private int idUsuario;
	private String nombre_usuario;
    private int tipo_usuario;
    private String contrasenya_usuario;
    private String correo;
	
    public Usuario (){
    	super();
    }
    public Usuario(int idUsuario, String nombre_usuario, int tipo_usuario, String contrasenya_usuario, String correo) {
    	super();
    	this.idUsuario = idUsuario;
    	this.nombre_usuario = nombre_usuario;
    	this.tipo_usuario = tipo_usuario;
    	this.contrasenya_usuario = contrasenya_usuario;
    	this.correo = correo;
    }	
    public int getIdUsuario() {
    	return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
    	this.idUsuario = idUsuario;
    }
	
    public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	
	public int getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(int tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public String getContrasenya_usuario() {
		return contrasenya_usuario;
	}
	public void setContrasenya_usuario(String contrasenya_usuario) {
		this.contrasenya_usuario = contrasenya_usuario;
	}
    
	public String getCorreo_usuario() {
		return correo;
	}
	public void setCorreo_usuario(String correo) {
		this.correo = correo;
	}
	
	
	
}
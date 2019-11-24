

	public class Usuario {
    
	private int idUsuario;
	private String nombre_usuario;
    private int tipo_usuario;
    private String contrasenya_usuario;
    private String correo_usuario;
    
    public Usuario (){
    	super();
    }
    public Usuario(int idUsuario, String nombre_usuario, int tipo_usuario, String contrasenya_usuario) {
    	super();
    	this.idUsuario = idUsuario;
    	this.nombre_usuario = nombre_usuario;
    	this.tipo_usuario = tipo_usuario;
    	this.contrasenya_usuario = contrasenya_usuario;
    	this.correo_usuario = correo_usuario;
    	
    }
    public int getIdUsuario() {
    	return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
    	this.idUsuario = idUsuario;
    }
	
    public String getnombre_usuario() {
		return nombre_usuario;
	}
	public void setnombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	
	public int gettipo_usuario() {
		return tipo_usuario;
	}
	public void settipo_usuario(int tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public String getcontrasenya_usuario() {
		return contrasenya_usuario;
	}
	public void setcontrasenya_usuario(String contrasenya_usuario) {
		this.contrasenya_usuario = contrasenya_usuario;
	}
    
	public String getCorreo_usuario() {
		return correo_usuario;
	}
	public void setCorreo_usuario(String correo_usuario) {
		this.correo_usuario = correo_usuario;
	}
	
	
	
}
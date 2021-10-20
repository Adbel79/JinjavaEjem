package mx.uv.datos;

public class Automovil {
    private String id;
    private String modelo;
    private String dueno;

    public Automovil(String id, String modelo, String dueno) {
        this.id = id;
        this.modelo = modelo;
        this.dueno = dueno;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDueno() {
        return this.dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", modelo='" + getModelo() + "'" +
            ", dueno='" + getDueno() + "'" +
            "}";
    }


}

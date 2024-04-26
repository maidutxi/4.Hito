package src;

public class Fotografia {
    private int idFoto;
    private String titulo;
    private String archivo;
    private int visitas;
    private int idFotografo;

    // Constructor
    public Fotografia(int idFoto, String titulo, String archivo, int visitas, int idFotografo) {
        this.idFoto = idFoto;
        this.titulo = titulo;
        this.archivo = archivo;
        this.visitas = visitas;
        this.idFotografo = idFotografo;
    }

    // Getters
    public int getIdFoto() {
        return idFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArchivo() {
        return archivo;
    }

    public int getVisitas() {
        return visitas;
    }

    public int getIdFotografo() {
        return idFotografo;
    }

    public String toString() {
        return titulo;
    }
}



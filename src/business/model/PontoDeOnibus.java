package business.model;

public class PontoDeOnibus{
    private int id;
	private String nome;
	private double latitude, longitude;

    public PontoDeOnibus(int id, double latitude, double longitude){
        this.id = id;
    	this.nome = "P" + (id + 1);
    	this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
    	return this.id;
    }
    
    public String getNome() {
    	return this.nome;
    }
    
    public double getLatitude(){
        return this.latitude;
    }

    public double getLongitude(){
        return this.longitude;
    }
}
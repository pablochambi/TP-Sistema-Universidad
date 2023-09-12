package ar.unlam.pb2.Universidad;

public class Aula {

	private Integer id;
	private Integer cantMax;

	public Aula(Integer id, Integer cantMax) {
		this.id=id;
		this.cantMax=cantMax;
	}

	public Integer getCantMax() {
		return cantMax;
	}

	public void setCantMax(Integer cantMax) {
		this.cantMax = cantMax;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}

package ar.unlam.pb2.Universidad;

public class Nota {
	
	private TipoParcial tipoParcial;
	private Integer valor;
	private Boolean aprobado;
	
	public Nota(TipoParcial tipoParcial, Integer valor) {
		this.tipoParcial = tipoParcial;
		setValor(valor);
		this.aprobado = false;
	}
	
	public Boolean getAprobado() {
		if(this.valor>=7) {
			return true;
		}
		return false;
	}

	public TipoParcial getTipoParcial() {
		return tipoParcial;
	}

	public void setTipoParcial(TipoParcial tipoParcial) {
		this.tipoParcial = tipoParcial;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		if(valor>0 && valor<=10) {
			this.valor = valor;
		}
		else
			this.valor = 0;
	}
	
	
	
	

}

package modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "regra")
public class Regra extends EntidadeBase {

	private static final long serialVersionUID = 3361682229508424377L;

	private String extensao;
	private String diretorioDestino;
	private String diretorioOrigem;
	
	private Arquivo origem;
	
	private Arquivo destino;

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public String getDiretorioDestino() {
		return diretorioDestino;
	}

	public void setDiretorioDestino(String diretorioDestino) {
		this.diretorioDestino = diretorioDestino;
	}

	public String getDiretorioOrigem() {
		return diretorioOrigem;
	}

	public void setDiretorioOrigem(String diretorioOrigem) {
		this.diretorioOrigem = diretorioOrigem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime
				* result
				+ ((diretorioDestino == null) ? 0 : diretorioDestino.hashCode());
		result = prime * result
				+ ((diretorioOrigem == null) ? 0 : diretorioOrigem.hashCode());
		result = prime * result
				+ ((extensao == null) ? 0 : extensao.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Regra other = (Regra) obj;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (diretorioDestino == null) {
			if (other.diretorioDestino != null)
				return false;
		} else if (!diretorioDestino.equals(other.diretorioDestino))
			return false;
		if (diretorioOrigem == null) {
			if (other.diretorioOrigem != null)
				return false;
		} else if (!diretorioOrigem.equals(other.diretorioOrigem))
			return false;
		if (extensao == null) {
			if (other.extensao != null)
				return false;
		} else if (!extensao.equals(other.extensao))
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		return true;
	}

	public Arquivo getOrigem() {
		return origem;
	}

	public void setOrigem(Arquivo origem) {
		this.origem = origem;
	}

	public Arquivo getDestino() {
		return destino;
	}

	public void setDestino(Arquivo destino) {
		this.destino = destino;
	}

}

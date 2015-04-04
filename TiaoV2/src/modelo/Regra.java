package modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "regra")
public class Regra extends EntidadeBase {

	private static final long serialVersionUID = 3361682229508424377L;

	private Extensao extensao;
	private String diretorioDestino;
	private String diretorioOrigem;
	private Arquivo arquivo;

	public Extensao getExtensao() {
		return extensao;
	}

	public void setExtensao(Extensao extensao) {
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

	public Arquivo getArquivo() {
		return arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((arquivo == null) ? 0 : arquivo.hashCode());
		result = prime
				* result
				+ ((diretorioDestino == null) ? 0 : diretorioDestino.hashCode());
		result = prime * result
				+ ((diretorioOrigem == null) ? 0 : diretorioOrigem.hashCode());
		result = prime * result
				+ ((extensao == null) ? 0 : extensao.hashCode());
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
		if (arquivo == null) {
			if (other.arquivo != null)
				return false;
		} else if (!arquivo.equals(other.arquivo))
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
		return true;
	}

}

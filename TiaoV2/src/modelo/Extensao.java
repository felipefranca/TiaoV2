package modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="extensao")
public class Extensao extends EntidadeBase {

	private static final long serialVersionUID = -7476042522972535810L;
	private String extensao;

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		Extensao other = (Extensao) obj;
		if (extensao == null) {
			if (other.extensao != null)
				return false;
		} else if (!extensao.equals(other.extensao))
			return false;
		return true;
	}

}
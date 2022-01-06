package br.com.devinhouse.springbootapiexercicios.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "processos")
public class ProcessoReturnResponseDTO implements Serializable {

	private static final long serialVersionUID = 2250056735041891358L;
	
	private List<ProcessoDTO> processo;

	public List<ProcessoDTO> getProcesso() {
		return processo;
	}

	public void setProcesso(List<ProcessoDTO> processo) {
		this.processo = processo;
	}


}

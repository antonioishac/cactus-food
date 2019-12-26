package br.com.cactus.food.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import br.com.cactus.food.domain.model.Cozinha;
import lombok.Data;
import lombok.NonNull;

@JsonRootName("cozinhas")
@Data
public class CozinhasXmlWrapper {

	@NonNull
	@JsonProperty("cozinha")
	// @JacksonXmlProperty(localName = "cozinha")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Cozinha> cozinhas;

}

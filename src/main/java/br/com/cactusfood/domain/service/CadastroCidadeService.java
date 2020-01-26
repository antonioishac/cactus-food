package br.com.cactusfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.cactusfood.domain.exception.CidadeNaoEncontradaException;
import br.com.cactusfood.domain.exception.EntidadeEmUsoException;
import br.com.cactusfood.domain.model.Cidade;
import br.com.cactusfood.domain.model.Estado;
import br.com.cactusfood.domain.repository.CidadeRepository;

@Service
public class CadastroCidadeService {

	private static final String MSG_CIDADE_EM_USO
		= "Cidade de código %d não pode ser removida, pois está em uso";

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CadastroEstadoService estadoService;

	public Cidade salvar(Cidade cidade) {

		// Atribuir o código do estado em uma variável.
		Long estadoId = cidade.getEstado().getId();

		// Buscar o estado
		Estado estado = estadoService.buscarOuFalhar(estadoId);

		// Atribuindo a busca do objeto estado ao objeto cidade.
		cidade.setEstado(estado);

		// persistindo uma cidade.
		return cidadeRepository.save(cidade);

	}

	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);

		} catch (EmptyResultDataAccessException e) {
			throw new CidadeNaoEncontradaException(cidadeId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_CIDADE_EM_USO, cidadeId));
		}
	}

	public Cidade buscarOuFalhar(Long cidadeId) {
		return cidadeRepository.findById(cidadeId)
			.orElseThrow(() -> new CidadeNaoEncontradaException(cidadeId));
	}

}
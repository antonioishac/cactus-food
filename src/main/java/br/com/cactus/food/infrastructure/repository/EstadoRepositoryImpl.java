package br.com.cactus.food.infrastructure.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import br.com.cactus.food.domain.model.Estado;
import br.com.cactus.food.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Estado> listar() {
		return manager.createQuery("from Estado", Estado.class).getResultList();
	}

	@Override
	public Estado buscar(Long id) {
		return manager.find(Estado.class, id);
	}

	@Override
	@Transactional
	public Estado salvar(Estado estado) {
		return manager.merge(estado);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		Estado estado = buscar(id);

		if (estado == null) {
			throw new EmptyResultDataAccessException(1);
		}

		manager.remove(estado);
	}
}

package br.com.cactusfood.infrastructure;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.cactusfood.domain.model.Restaurante;
import br.com.cactusfood.domain.repository.RestauranteRepositoryQueries;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Restaurante> findRestauranteJpql(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

		StringBuilder jpql = new StringBuilder();
		jpql.append("from Restaurante where 0 = 0 ");

		Map<String, Object> parametros = new HashMap<>();

		if (StringUtils.hasText(nome)) {
			jpql.append("and nome :nome ");
			parametros.put("nome", "%" + nome + "%");
		}

		if (taxaFreteFinal != null) {
			jpql.append("and taxaFrete >= :taxaFreteInicial ");
			parametros.put("taxaFrete", taxaFreteFinal);
		}

		if (taxaFreteFinal != null) {
			jpql.append("and taxaFrete <= taxaFreteFinal");
			parametros.put("taxaFrete", taxaFreteFinal);
		}

		TypedQuery<Restaurante> query = manager.createQuery(jpql.toString(), Restaurante.class);

		parametros.forEach((chave, valor) -> query.setParameter(chave, valor));

		return query.getResultList();
	}

	@Override
	public List<Restaurante> findRestauranteSql(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		StringBuilder sql = new StringBuilder();

		Map<Integer, Object> parametros = new HashMap<>();

		sql.append("SELECT " +
				"	id," +
				"	data_atualizacao," +
				"    data_cadastro," +
				"    endereco_bairro," +
				"    endereco_cep," +
				"    endereco_complemento," +
				"    endereco_logradouro," +
				"    endereco_numero," +
				"    nome," +
				"    taxa_frete," +
				"    cozinha_id," +
				"    endereco_cidade_id" +
				"FROM" +
				"	restaurante " +
				"WHERE 0 = 0 ");

		if (StringUtils.hasLength(nome)) {
			sql.append("and nome = ? ");
			parametros.put(1, "%" + nome + "%");
		}

		if (taxaFreteInicial != null) {
			sql.append("taxaFrete >= ? ");
			parametros.put(2, taxaFreteInicial);
		}

		if (taxaFreteFinal != null) {
			sql.append("taxaFrete <= ? ");
			parametros.put(3, taxaFreteFinal);
		}

		Query query = manager.createNativeQuery(sql.toString(), Restaurante.class);
		parametros.forEach((chave, valor) -> query.setParameter(chave, valor));

		return query.getResultList();
	}

	@Override
	public List<Restaurante> findRestauranteCriteria(String nome, BigDecimal taxaFreteInicial,
			BigDecimal taxaFreteFinal) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();

		CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
		Root<Restaurante> root = criteria.from(Restaurante.class);

		List<Predicate> predicates = new ArrayList<>();

		if (StringUtils.hasText(nome)) {
			predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
		}

		if (taxaFreteInicial != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
		}

		if (taxaFreteFinal != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
		}

		criteria.where(predicates.toArray(new Predicate[0]));

		TypedQuery<Restaurante> query = manager.createQuery(criteria);
		return query.getResultList();
	}

}

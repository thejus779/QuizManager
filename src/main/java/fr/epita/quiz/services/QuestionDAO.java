
package fr.epita.quiz.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.epita.quiz.datamodel.Question;

/**
 * This class is Question DAO class which extends Generic DAO
 *
 * @author  THEJUS
 *
 */
public class QuestionDAO extends GenericORMDao<Question> {

	@Inject
	@Named("questionQuery")
	String query;

	public List<Question> fetchAllQuestions() {

		final Session session = sf.openSession();
		Query query = session.createQuery("from Question");
		List<Question> result = query.list();

		return result;

	}

	public List<Question> searchQuestionByString(String str) {

		final Session session = sf.openSession();
		
		Query query = session.createQuery("from Question where question.question LIKE CONCAT('%',?1,'%')");
		
		query.setParameter("1", str);
		
		List<Question> result = query.list();

		return result;
	}

	// @Override
	// protected WhereClauseBuilder<Question> getWhereClauseBuilder(Question entity)
	// {
	// final WhereClauseBuilder<Question> wcb = new WhereClauseBuilder<>();
	// wcb.setQueryString(query);
	//
	// // TODO as bonus : let the whereclausebuilder generate this map thanks to
	// introspection
	// final Map<String, Object> parameters = new LinkedHashMap<>();
	// parameters.put("type", entity.getType());
	// parameters.put("question", entity.getQuestion());
	// wcb.setParameters(parameters);
	// return wcb;
	//
	// }

	// @Override
	// protected String getSearchQuery(Question question) {
	// return query;
	// }
	//
	// /*
	// * (non-Javadoc)
	// * @see
	// fr.epita.quiz.services.GenericHibernateDao#completeQuery(org.hibernate.query.Query)
	// */
	// @Override
	// protected void completeQuery(Question question, Query toBeCompleted) {
	//
	// toBeCompleted.setParameter("type", question.getType());
	// toBeCompleted.setParameter("question", question.getQuestion());
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.epita.quiz.services.GenericHibernateDao#getWhereClauseBuilder(java.lang.
	 * Object)
	 */

}

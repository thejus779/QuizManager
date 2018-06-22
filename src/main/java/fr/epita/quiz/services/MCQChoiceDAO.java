
package fr.epita.quiz.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;

/**
 * This class is MCQChoice DAO class which extends Generic DAO
 *
 * @author  THEJUS
 *
 */

public class MCQChoiceDAO extends GenericORMDao<MCQChoice> {
	
	@Inject 
	String deleteAllMCQ;

	/*
	 * (non-Javadoc)
	 * @see fr.epita.quiz.services.GenericORMDao#getWhereClauseBuilder(java.lang.Object)
	 */
//	@Override
//	protected WhereClauseBuilder<MCQChoice> getWhereClauseBuilder(MCQChoice entity) {
//		final WhereClauseBuilder<MCQChoice> whereClauseBuilder = new WhereClauseBuilder<>();
//		whereClauseBuilder.setParameters(new LinkedHashMap<>());
//
//		// TODO : load from configuration
//		final String query = "from MCQChoice";
//
//		whereClauseBuilder.setQueryString(query);
//		return whereClauseBuilder;
//
//	}

	/*
	 * (non-Javadoc)
	 * @see fr.epita.quiz.services.GenericORMDao#beforeCreate(java.lang.Object)
	 */
	@Override
	public boolean beforeCreate(MCQChoice entity) {
		return entity.getChoice() != null && entity.getQuestion() != null;

	}
	
	public boolean deleteAllMCQs(Question question){
		
		final Session session = sf.openSession();
		Query query = session.createQuery("delete from MCQChoice where question =:question");
		
		query.setParameter("question", question);
		
		Transaction tr = session.beginTransaction();
		int result = query.executeUpdate();
		tr.commit();
		
		return result>=1;
		
	}
	public List<MCQChoice> fetchAllMCQChoices(Question question){
		
		final Session session = sf.openSession();
		Query query = session.createQuery("from MCQChoice where question =:question");
		query.setParameter("question", question);
		
		List<MCQChoice> result = query.list();
		return result;		
}

}

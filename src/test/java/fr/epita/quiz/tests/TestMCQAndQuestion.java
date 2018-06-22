/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.quiz.tests;

import java.beans.PropertyDescriptor;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.QuestionType;
import fr.epita.quiz.services.MCQChoiceDAO;
import fr.epita.quiz.services.QuestionDAO;

/**
 * <h3>Description</h3>
 * <p>
 * This class allows to ...
 * </p>
 *
 * <h3>Usage</h3>
 * <p>
 * This class should be used as follows:
 * 
 * <pre>
 * <code>${type_name} instance = new ${type_name}();</code>
 * </pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 *         ${tags}
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestMCQAndQuestion {

	@Inject
	QuestionDAO questDAO;

	@Inject
	MCQChoiceDAO mcqDAO;

	@Inject
	SessionFactory factory;

	public void testSave() {
		final Session session = factory.openSession();
		final Transaction tx = session.beginTransaction();
		final Question question = new Question();
		question.setQuestion("How to configure Hibernate?");
		question.setType(QuestionType.MCQ);

		questDAO.create(question);

		final MCQChoice choice = new MCQChoice();
		choice.setValid(true);
		choice.setChoice("thanks to a LocalSessionFactoryBean instance");
		choice.setOrder(0);
		choice.setQuestion(question);

		mcqDAO.create(choice);
		tx.commit();

	}

	// from Question as question where
	// question.type = :type
	// and
	// question.question = :question


	@Test
	public void testgenerateString() {
		Question entity = new Question();
		final BeanWrapper sourceBean = new BeanWrapperImpl(entity.getClass());
		final PropertyDescriptor[] propertyDescriptors = sourceBean.getPropertyDescriptors();
		final Map<String, Object> parameters = new LinkedHashMap<>();
		int i = 0;

		String simpleName = entity.getClass().getSimpleName();
		String baseName = "from " + simpleName + " as " + simpleName.toLowerCase() + " where ";

		for (final PropertyDescriptor propertyDescriptor : propertyDescriptors) {

			if (propertyDescriptor.getName() != null && !propertyDescriptor.getName().contains("class")) {
				baseName += createQueryString(simpleName, propertyDescriptor.getName(), i);
				i++;
			}
		}

		System.out.println("Final Query: " + baseName);
	}

	private String createQueryString(String simpleName, String name, int i) {
		String str = null;
		
		if(i == 0)
		{
			str = simpleName.toLowerCase() + "." + name + " = :" + name;
		}
		
		else{
			str = " and "+simpleName.toLowerCase() + "." + name + " = :" + name;
		}
		
		System.out.println(str);
		return str;

	}

}

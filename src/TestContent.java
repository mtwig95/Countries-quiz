/**
 *	The class represent a test.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestContent{
	public static ArrayList<Question> question_list;
	private int num_of_questions;


	/**
	 * the constructor getting all the data as ArrayList<Question>
	 * @param list
	 */
	public TestContent(ArrayList<Question> question_list) {
		TestContent.question_list = question_list;
		this.num_of_questions=question_list.size();
	}	

	public int getNumOfQuestions() {
		return num_of_questions;
	}
/**
 * Getting specific question from the list.
 * @param num_of_question
 * @return question
 */
	public Question getQuestion(int num_of_question){
		Question question=question_list.get(num_of_question);
		return question;
	}
	
	/**
	 * Shuffle the answers.
	 * @return list of the answers in random order.
	 */
	public List<String> shuffleAnswers() {
		Question question=question_list.get(0);
		List<String> allAnswers = question.getAllAnswers();
		Collections.shuffle(allAnswers);
		return allAnswers;
	}
}

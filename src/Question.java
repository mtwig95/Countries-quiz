/**
 * the class represent a question
 * @param question
 * @param correct answer
 * @param and wrong answers as array
 */
import java.util.ArrayList;
import java.util.List;

public class Question {

	private String question;
	private String correct_answer;
	private String[] wrong_answers;

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setCorrectAnswer(String correct_answer) {
		this.correct_answer = correct_answer;
	}
/**
 * getting 3 strings of wrong answers
 * @param set answers as array
 */
	public void setWrongAnswers(String... answers) {
		int i = 0;
		this.wrong_answers = new String[3];
		for (String ans : answers) {
			this.wrong_answers[i] = ans;
			i++;
		}
	}

	public String getQuestion() {
		return question;
	}

	public String getCorrectAnswer() {
		return correct_answer;
	}
/**
 * get all answers (correct and wrongs)
 * @return all the answers as list
 */
	public List<String> getAllAnswers() {
		List<String> answers = new ArrayList<>();
		answers.add(wrong_answers[0]);
		answers.add(wrong_answers[1]);
		answers.add(wrong_answers[2]);
		answers.add(correct_answer);
		return answers;
	}

	/**
	 * check the user answer
	 * @param user guess
	 * @return true if it is the correct answer
	 */
	public Boolean checkAnswer(String userAns) {
		if (userAns.equals(correct_answer))
			return true;
		return false;
	}

}

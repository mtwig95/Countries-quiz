
/**
 *  Controller class for Game Of Life.
 *
 */
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TestController {
	/* FXML elements */
	@FXML
	private Button button1;
	@FXML
	private Button button2;
	@FXML
	private Button button3;
	@FXML
	private Button button4;
	@FXML
	private Button button_next;
	@FXML
	private Button start;
	@FXML
	private Label title;
	private TestContent test;
	private Question question;
	private int number_of_correct_ans;

	public void initialize() {
		newTest(null);
	}

	/**
	 * Initialize the game
	 * 
	 * @param pressing the start a new game.
	 */
	@FXML
	void newTest(ActionEvent event) {
		number_of_correct_ans = 0;
		button_next.setVisible(false);

		this.test = new TestContent(ParseTest.getData());// new test
		button_next.setText("next");
		nextQuestion(null);
	}

	/**
	 * Display the next question finish the game when the questions ends
	 * 
	 * @param after pressing the next button
	 */
	@FXML
	void nextQuestion(ActionEvent event) {
		if (TestContent.question_list.isEmpty()) {
			finishTest();
		}
		this.question = TestContent.question_list.get(0);
		title.setText(this.question.getQuestion()); // set titl
		List<String> ans = test.shuffleAnswers();// random
		button1.setText(ans.get(0));
		button2.setText(ans.get(1));
		button3.setText(ans.get(2));
		button4.setText(ans.get(3));
		buttonsVisibility(true); // show options
	}

	/**
	 * checking the answer.
	 * 
	 * @param after choosing answer
	 */
	@FXML
	void buttonAction(ActionEvent event) {
		buttonsVisibility(false);
		boolean user_guess = question.checkAnswer(getUserAns(event));
		title.setText(analizeQuestion(user_guess));
		if (TestContent.question_list.isEmpty()) {
			button_next.setText("Apply answers");
		}
	}

	/**
	 * Display to user the result for last answer
	 * 
	 * @param user_guess
	 * @return
	 */
	private String analizeQuestion(boolean user_guess) {
		String output = "you were";
		if (user_guess) {
			number_of_correct_ans++;
			output += " right!";
		} else {
			output += " Wrong!\nthe right answer is: " + question.getCorrectAnswer();
		}
		TestContent.question_list.remove(0);
		return output;
	}

	/**
	 * Getting the answer that the user guess.
	 * 
	 * @param event
	 * @return answer as string
	 */
	String getUserAns(ActionEvent event) {
		String str = event.getSource().toString();
		int cut_str = str.indexOf('\'') + 1;
		str = str.substring(cut_str, str.length() - 1);
		return str;
	}

	/**
	 * Set visibility of buttons.
	 * 
	 * @param show or not
	 */
	private void buttonsVisibility(boolean show) {
		button1.setVisible(show);
		button2.setVisible(show);
		button3.setVisible(show);
		button4.setVisible(show);
		button_next.setVisible(!show);
	}

	/**
	 * Display the user the result.
	 */
	private void finishTest() {
		buttonsVisibility(false);
		button_next.setVisible(false);
		float result = (float) number_of_correct_ans / test.getNumOfQuestions();
		result *= 100;
		title.setText("your result: " + (int) result);
	}
}

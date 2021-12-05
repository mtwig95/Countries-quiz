
/**
 * 
 * @author Maytal Twig
 * @mtwig95@gmail.com
 * @date 05/12/2021 
 * the class parse txt file to list of questions.
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParseTest {
	final private static int NUM_OF_ANSWERS = 4;
	/**
	 * 
	 * @param getting scanner
	 * @return next line if exist
	 */
	public static String getNextLine(Scanner s) {
		if (!s.hasNextLine()) {
			return "";
		}
		return s.nextLine();
	}

	/**
	 * 
	 * @return ArrayList of questions
	 */
	static ArrayList<Question> getData() {
		ArrayList<Question> list = new ArrayList<>();
		try {
			Scanner s = new Scanner(new File("data.txt"));
			while (s.hasNext()) {
				for (int i = 0; i < NUM_OF_ANSWERS; i++) {
					if (s.hasNext()) {
						Question question = new Question();
						question.setQuestion(getNextLine(s));
						question.setCorrectAnswer(getNextLine(s));
						question.setWrongAnswers(getNextLine(s), getNextLine(s), getNextLine(s));
						list.add(question);
					}
				}
			}
			s.close();
		} catch (IOException e) {
			System.out.println("Error, could not read file");
		}
		return list;
	}
}

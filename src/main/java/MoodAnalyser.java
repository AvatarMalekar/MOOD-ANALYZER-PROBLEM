import com.bridgelabz.exception.MoodAnalyserException;

public class MoodAnalyser {
    public String testHappy(String moodMessage) throws MoodAnalyserException {
        try {
            if (moodMessage.isEmpty())
                throw new MoodAnalyserException("This is Empty");
            if (moodMessage.contains("happy"))
                return "Happy";
                return "Sad";
        }
        catch(NullPointerException np) {
            throw new MoodAnalyserException("This is invalid mood");
        }
    }
}

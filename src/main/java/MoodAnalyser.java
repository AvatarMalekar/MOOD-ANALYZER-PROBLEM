import com.bridgelabz.exception.MoodAnalyserException;

public class MoodAnalyser {
    private String moodMessage;
    public MoodAnalyser() {
    }
    public MoodAnalyser(String moodMessage) {
        this.moodMessage=moodMessage;
    }
    public String testHappy() throws MoodAnalyserException {
        try {
            if (moodMessage.isEmpty())
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.IS_EMPTY,"This is Empty");
            if (moodMessage.contains("happy"))
                return "Happy";
                return "Sad";
        }
        catch(NullPointerException np) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.IS_NULL,"This is invalid mood");
        }
    }
}

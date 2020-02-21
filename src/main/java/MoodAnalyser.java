import com.bridgelabz.exception.MoodAnalyserException;

public class MoodAnalyser {
    private String moodMessage;
    public MoodAnalyser() {
        moodMessage="defaultMessage";
    }
    public MoodAnalyser(String moodMessage) {
        this.moodMessage=moodMessage;
    }
    public String testHappy() {
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

    @Override
     public boolean equals(Object another)
    { if(this.moodMessage.equals(((MoodAnalyser) another).moodMessage))
        return true;
        return false;
    }
}

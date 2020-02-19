import com.bridgelabz.exception.MoodAnalyserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoodAnalyserTest {

    MoodAnalyser moodAnalyser;
    @Test
    public void givenHappy_ShouldReturn_Happy() {
        String happyMood = null;
        try {
            moodAnalyser=new MoodAnalyser("This is happy message");
            happyMood = moodAnalyser.testHappy();
            Assert.assertEquals("Happy",happyMood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenSad_ShouldReturn_Sad() {
        String sadMood = null;
        try {
            moodAnalyser=new MoodAnalyser("This is sad message");
            sadMood = moodAnalyser.testHappy();
            Assert.assertEquals("Sad",sadMood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNull_ShouldReturn_Happy() {
        String nullValue = null;
        try {
            moodAnalyser=new MoodAnalyser();
            nullValue = moodAnalyser.testHappy();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.IS_NULL,e.type);
        }
    }

    @Test
    public void givenEmpty_ShouldReturn_Happy() {
        String nullValue = null;
        try {
            moodAnalyser=new MoodAnalyser("");
            nullValue = moodAnalyser.testHappy();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.IS_EMPTY,e.type);
        }
    }
    @Before
    public void setUp() throws Exception {
        moodAnalyser=new MoodAnalyser();
    }
}
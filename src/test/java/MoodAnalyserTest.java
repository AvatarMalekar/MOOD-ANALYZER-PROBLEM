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
            happyMood = moodAnalyser.testHappy("This is happy message");
            moodAnalyser=new MoodAnalyser("This is happy message");
            Assert.assertEquals("Happy",happyMood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenSad_ShouldReturn_Sad() {
        String sadMood = null;
        try {
            sadMood = moodAnalyser.testHappy("This is sad message");
            moodAnalyser=new MoodAnalyser("This is sad message");
            Assert.assertEquals("Sad",sadMood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNull_ShouldReturn_Happy() {
        String nullValue = null;
        try {
            nullValue = moodAnalyser.testHappy(null);
            moodAnalyser=new MoodAnalyser();
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
            Assert.assertEquals("This is invalid mood",e.getMessage());
        }
    }

    @Test
    public void givenEmpty_ShouldReturn_Happy() {
        String nullValue = null;
        try {
            nullValue = moodAnalyser.testHappy("");
            moodAnalyser=new MoodAnalyser("");
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
            Assert.assertEquals("This is Empty",e.getMessage());
        }
    }
    @Before
    public void setUp() throws Exception {
        moodAnalyser=new MoodAnalyser();
    }
}
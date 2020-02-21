import com.bridgelabz.exception.MoodAnalyserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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

    @Test
    public void givenMoodAnalyzer_whenProper_shouldReturnObject() throws ClassNotFoundException {
        Constructor<?> constructor=null;
        Object object;
        try {
            constructor=Class.forName("MoodAnalyser").getConstructor(String.class);
            object=constructor.newInstance("This is happy message");
            MoodAnalyser moodAnalyzer = (MoodAnalyser) object;
            String mood = moodAnalyzer.testHappy();
            Assert.assertEquals("Happy",mood);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzer_When_Proper_ShouldReturnObject() {
        try {
            MoodAnalyser thisMood = MoodAnalyzerFactory.createMoodAnalyzer("this is happy mood");
            String mood = thisMood.testHappy();
            Assert.assertEquals("Happy", mood);
        }catch(MoodAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzer_When_Proper_Should_Return_object() {
        try {
            MoodAnalyzerFactory moodAnalyzerFactory = null;
            MoodAnalyser moodAnalyser = moodAnalyzerFactory.createMoodAnalyzer2();
            Assert.assertEquals(new MoodAnalyser(),moodAnalyser);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenClassName_whenImproper_shouldReturn_Exception() {
        try {
            MoodAnalyzerFactory.getConstructor("Mood",Integer.class);
        }catch(MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenConstructor_whenImproper_shouldReturn_Exception() {
        try {
            MoodAnalyzerFactory.getConstructor("MoodAnalyser",int.class);
        }catch(MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    @Before
    public void setUp() throws Exception {
        moodAnalyser=new MoodAnalyser();
    }
}
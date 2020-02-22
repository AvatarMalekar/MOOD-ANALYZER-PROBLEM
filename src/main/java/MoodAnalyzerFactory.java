import com.bridgelabz.exception.MoodAnalyserException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParameterizedTypeException;

public class MoodAnalyzerFactory {
    public static MoodAnalyser createMoodAnalyzer(String message){
        try {
            Class<?> moodAnalyzerClass=Class.forName("MoodAnalyser");
            Constructor<?> moodConstructor=moodAnalyzerClass.getConstructor(String.class);
            Object myObj=moodConstructor.newInstance(message);
            return (MoodAnalyser)myObj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyser createMoodAnalyzer2() {
        try {
            Class<?> moooAnalyzerClass=Class.forName("MoodAnalyser");
            Constructor<?> moodConstructor=moooAnalyzerClass.getConstructor();
            Object myObj2=moodConstructor.newInstance();
            return (MoodAnalyser)myObj2;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,e.getMessage());
        } catch (IllegalAccessException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ILLEGAL_ACCESS,e);
        } catch (InstantiationException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.INSATANTIATION_EXCEPTION,e.getMessage());
        } catch (InvocationTargetException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.INVOCATION_TARGET_EXCEPTION,e.getMessage());
        }
    }

    public static Constructor<?> getConstructor (String classAsName,Class parm)throws MoodAnalyserException {
        Constructor<?> result = null;
        try {
            Class<?> moodAnalyzerClass = Class.forName(classAsName);
            Constructor<?> constructor = moodAnalyzerClass.getConstructor(parm);
            result = constructor;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,e.getMessage());
        } catch (NoSuchMethodException e){
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,e.getMessage());
        }
        return result;
    }

    public static Object getInvokeMethod(Object constructorObject, String i_am_in_happy_mood) {
        try {
            return constructorObject.getClass().getMethod(i_am_in_happy_mood).invoke(constructorObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,e.getMessage());
        } catch (IllegalAccessException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ILLEGAL_ACCESS,e);
        } catch (InvocationTargetException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.INVOCATION_TARGET_EXCEPTION,e.getMessage());
        }
    }

    public static String setFieldValue(MoodAnalyser moodObject, String message, String fieldName) {
        try {
            Field field = moodObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(moodObject, message);
            return (String) moodObject.getClass().getDeclaredMethod("testHappy").invoke(moodObject);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_FIELD,e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.FIELD_INVOCATION_ISSUE,e.getMessage());
        }
      return null;
    }
}

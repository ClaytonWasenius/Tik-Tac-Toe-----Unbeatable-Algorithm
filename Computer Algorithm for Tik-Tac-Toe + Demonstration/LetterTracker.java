
/**
 * Write a description of class LetterTracker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LetterTracker
{
    // instance variables - replace the example below with your own
    private int letter; 
    public LetterTracker(){ //i don't know if I really need this or not 
        letter = 0; 
    }
    
    public int setValueOfLetterTo(int increment){
    
        letter = letter + increment; //this 
        return(letter); 
    }
    public int returnLetter(){ //this just returns the value 
        return(letter); 
    }
    public int reinitialize(){
        letter = 0; 
        return(letter); 
    }
}

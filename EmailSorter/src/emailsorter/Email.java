
package emailsorter;

/**
 *
 * @author Sam
 */

import java.util.ArrayList;

public class Email {
    
    String[] keywords = {"emergency", "help", "required", "mandatory", "ASAP", "need","deadline","before","by","approaching", "!", "finish","respond"};
    int[] values = {30,5,10,10,15,3,25,3,3,3,3,7,5};
    
    public String sender;
    public String recipient;
    public String subject;
    public ArrayList<String> body = new ArrayList<String>();
    public int value = 0;
    
    public Email() {
        
    }
    
    public int evaluate() {

        if (sender.equals("dan.goldind@mcvts.org")) {
            value += 90;
        } else if (sender.equals("brandon.costa@mcvts.org")) {
            value += 10;
        }

        for (int i = 0; i < body.size(); i++) {
            for(int j = 0; j < keywords.length; j++) {

                if (body.get(i).equalsIgnoreCase(keywords[j]) || body.get(i).contains(keywords[j])) {
                    value += values[i];
                }
            }
        }
        
        for(int i = 0; i < keywords.length; i++) {
            if(subject.contains(keywords[i]))
                value+= values[i]*3;
        } 
        

        if (value >= 90) {
            return 1;
        } else if (value >= 40) {
            return 2;
        } else if (value >= 10) {
            return 3;
        } else {
            return 4;
        }
    }
    
}

/**
 * Left Aligned class
 * @student name: Diyogu Hannadige Yasith Yuvin Gunawardana
 * @Student Index: 12148175
 */

package ta.textalignment;

import java.util.LinkedList;

public class Centered extends AlignmentStrategy  {
    
    @Override
    void align(LinkedList<String> line) {
        int charCount = 0;
         for (String s : line){
             charCount += s.length();
         }
         
         int spaces = 20 - charCount;
      
         if (charCount < 20){
             if(spaces == 1){
                 line.addFirst(" ".repeat(1));
             }else if (spaces > 1 && spaces%2 == 0){
                 line.addFirst(" ".repeat(spaces/2));
                 line.add(" ".repeat(spaces/2));
             }else if (spaces > 1 && spaces%2 != 0){
                 line.addFirst(" ".repeat((spaces/2)));
                 line.add(" ".repeat((spaces/2)+1));
             }
         }
             
    }
    
}

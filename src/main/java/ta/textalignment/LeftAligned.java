/**
 * Left Aligned class
 * @student name: Diyogu Hannadige Yasith Yuvin Gunawardana
 * @Student Index: 12148175
 */

package ta.textalignment;

import java.util.LinkedList;

public class LeftAligned extends AlignmentStrategy {

    
    
    @Override
    void align(LinkedList<String> line) {
         // The lines will already be left aligned so there is no work to be done in the align method.
         int charCount = 0;
         for (String s : line){
             charCount += s.length();
         }
         if (charCount < 20){
             line.add(" ".repeat(20 - charCount));
         }
         
    }
    
}

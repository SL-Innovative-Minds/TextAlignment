/**
 * FXML Controller class
 * @student name: Diyogu Hannadige Yasith Yuvin Gunawardana
 * @Student Index: 12148175
 */

package ta.textalignment;

import java.util.LinkedList;

public class RightAligned extends AlignmentStrategy {

    @Override
    void align(LinkedList<String> line) {
        int charCount = 0;
         for (String s : line){
             charCount += s.length();
         }
         if (charCount < 20){
             line.addFirst(" ".repeat(20 - charCount));
         }
    }
    
}

/**
 * FXML Controller class
 *
 * @student name: Diyogu Hannadige Yasith Yuvin Gunawardana
 * @Student Index: 12148175
 *
 */
package ta.textalignment;

import java.util.LinkedList;

public abstract class AlignmentStrategy {

    public AlignmentStrategy() {
    }
    
    abstract void align(LinkedList<String> line);
}

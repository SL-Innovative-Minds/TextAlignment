/**
 * Left Aligned class
 * @student name: Diyogu Hannadige Yasith Yuvin Gunawardana
 * @Student Index: 12148175
 */
package ta.textalignment;

import java.util.LinkedList;

public class Justified extends AlignmentStrategy {

    @Override
    void align(LinkedList<String> line) {
        int charCount = 0;
        int spaces = 0;
        int v =0;
        int middleSpaces;
        String l;

        LinkedList<String> words = new LinkedList<>();
        LinkedList<String> structured = new LinkedList<>();
        for (String s : line) {
            charCount += s.length();

            if (!" ".equals(s)) {
                words.add(s);
            }
        }

        middleSpaces = words.size() - 1;

        spaces = 20 - charCount;
        
        if (middleSpaces != 0)
            v = (int) spaces / middleSpaces;
        
        
        for (int i = 0; i < line.size();i++){
            if (" ".equals(line.get(i))){
                structured.add(" ".repeat(v+1));
            }else{
                structured.add(line.get(i));
            }
        }
        
        line.clear();
        
            for (String s : structured){
                line.add(s);
            }
        
        StringBuilder sb = new StringBuilder();
        for ( String i : line ) {
                sb.append( i );
        }
        
        if (sb.toString().length() < 20){
            line.add(1, " ".repeat(20-sb.toString().length())); 
        }
    }
}

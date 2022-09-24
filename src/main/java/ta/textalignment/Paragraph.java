/**
 * Paragraph class
 * @student name: Diyogu Hannadige Yasith Yuvin Gunawardana
 * @Student Index: 12148175
 *
 */
package ta.textalignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Paragraph {
    private AlignmentStrategy strategy;
    private int lineLength = 20;
    private String space = " ";
    private String visibleSpace = "^";
    private String text = "";

    public Paragraph(AlignmentStrategy strategy) {
        this.strategy = strategy;
    }
    
    public String alignText(){
        //convert the text to list of lines. Each line is a linked list of words and spacing.
        List<LinkedList<String>> lines = textToLines();

        //align each line according to the alignment strategy
        for ( LinkedList<String> line : lines)
            strategy.align( line );
            
              //convert the list of lines back to a string to be returned (so that it can be displayed)
              return linesToText( lines );

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public void alignAndAugmentText(){
        
    }
    
    private void augment(List<LinkedList<String>> lines){
        
    }
    
    private String linesToText(List<LinkedList<String>> lines){
        StringBuilder sb = new StringBuilder();
        for ( LinkedList<String> line : lines ) {
            for ( String s : line )
                sb.append( s );
            sb.append("\n");
        }
        return sb.toString();

    }
    
    private List<LinkedList<String>> textToLines(){
        String paragraph = getText();
        paragraph = paragraph.replace("\n", "");

        LinkedList<String> lines = new LinkedList<>();
        List<LinkedList<String>> returnList = new ArrayList<>();
        List<String> words = new ArrayList<>();
        LinkedList<String>  line1 = new LinkedList<>();

        String line = "";

        int j = 0;

        String[] wordsArray = paragraph.split(" ");

        words.addAll(Arrays.asList(wordsArray));
        
        while (j < words.size()) {
           
            line = line + words.get(j) + " ";
            
            if (line.chars().count() <= 21) {
               line1.add(line);
            }else{
               lines.add(line1.getLast());
               line1.clear();
               line = "";
               j = j - 1;
            }
            j++; 
        }
        
        for (String l : lines){
            
            String element = l.trim();
            int length = element.length();
            LinkedList<String> elements = new LinkedList<>();
            String[] word = element.split(" ");
            int arraySize = word.length;
            for (int i = 0; i < arraySize; i++){
                elements.add(word[i]);
                if (i != (arraySize -1)){
                    elements.add(space);
                }else {
                    if (length < lineLength){
                        elements.add(space.repeat(lineLength - length));
                    }
                }
            }
            returnList.add(elements);
        }

        //System.out.println(returnList);
        return returnList;
    }
    
    
}

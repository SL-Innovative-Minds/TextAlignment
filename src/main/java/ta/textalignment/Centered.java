/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ta.textalignment;

import java.util.LinkedList;

/**
 *
 * @author nisal
 */
public class Centered extends AlignmentStrategy  {
    
    @Override
    void align(LinkedList<String> line) {
        int charCount = 0;
         for (String s : line){
             charCount += s.length();
         }
         
         int spaces = 20 - charCount;
      
         if (charCount < 20){
             if (spaces%2 == 0){
                 line.addFirst(" ".repeat(spaces/2));
                 line.add(" ".repeat(spaces/2));
             }else{
                 line.addFirst(" ".repeat((spaces/2)));
                 line.add(" ".repeat((spaces/2)+1));
             }
         }
             
    }
    
}

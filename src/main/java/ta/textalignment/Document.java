/**
 * Document class
 * @student name: Diyogu Hannadige Yasith Yuvin Gunawardana
 * @Student Index: 12148175
 */

package ta.textalignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Document {

    private String formattedText;
    private String unformattedText = "The resulting design methodology is called Janus and is described in \n" +
                                     "Section 3. However, its efficacy will be greatly improved if the goal \n" +
                                     "allocation process can occur in such a way that executable agent \n" +
                                     "behaviours are generated, rather than paper-based specifications as in \n" +
                                     "traditional Systems Engineering. In this regard, Janus is intended to \n" +
                                     "be used in conjunction with the GORITE BDI framework [2]. Janus draws \n" +
                                     "from various sources and case studies in the domain of agent-based \n" +
                                     "manufacturing; this background material forms Section 2. In Section 4, \n" +
                                     "the applicability of Janus to a quite different cyber-physical \n" +
                                     "application, namely power substation automation, is examined. A \n" +
                                     "discussion and concluding remarks are provided as Sections 5 and 6.";

    public Document() {
    }
    
    public Document(String fname)throws IOException {
       
        final List<String> lines = Files.readAllLines(Paths.get(fname), StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines){
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }
        unformattedText = stringBuilder.toString();
    }

    public void Save(String fname, String text)throws IOException {
        
        File output = new File(fname + ".txt");
        try (FileWriter writer = new FileWriter(output)) {
            writer.write(text);
            writer.flush();
        }
    }
    
    public String setFormattedText() {
        return formattedText;
    }

    public String getUnformattedText() {
        return unformattedText;
    }
}

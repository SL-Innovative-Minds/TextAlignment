/**
 * Document class
 * @student name: Diyogu Hannadige Yasith Yuvin Gunawardana
 * @Student Index: 12148175
 */

package ta.textalignment;

import java.io.IOException;

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

    public String setFormattedText() {
        return formattedText;
    }

    public String getUnformattedText() {
        return unformattedText;
    }
   
    public Document(String fname)throws IOException {
    }

    
    public void Save(String fname)throws IOException {
    }
}

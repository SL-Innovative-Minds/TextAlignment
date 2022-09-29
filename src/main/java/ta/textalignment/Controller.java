/**
 * FXML Controller class
 * @student name: Diyogu Hannadige Yasith Yuvin Gunawardana
 * @Student Index: 12148175
 **/

package ta.textalignment;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;

public class Controller implements Initializable {


    @FXML
    private Button btnClear;
    @FXML
    private Button btnDefault;
    @FXML
    private Button btnLoad;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnExit;
    @FXML
    private RadioButton left;
    @FXML
    private RadioButton right;
    @FXML
    private RadioButton centered;
    @FXML
    private RadioButton justified;
    @FXML
    private RadioButton augmented;
    @FXML
    private Label alignmentLabel;
    @FXML
    private TextArea originalText;
    @FXML
    private TextArea alignedText;
    
    private Document document;
    
    private boolean augment;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tg = new ToggleGroup();
        left.setToggleGroup(tg);
        right.setToggleGroup(tg);
        centered.setToggleGroup(tg);
        justified.setToggleGroup(tg);
    }
    
    @FXML
    private void onClearClick(ActionEvent event) {
        //System.out.println("clear button invoked");
        originalText.clear();
        alignedText.clear();
        setSelected();
    }

    @FXML
    private void onDefaultClick(ActionEvent event) {
        //System.out.println("default button invoked");
        document = new Document();
        String unFormattedText = document.getUnformattedText();
        originalText.setText(unFormattedText);
    }

    @FXML
    private void onLoadClick(ActionEvent event)
    {
        //System.out.println("load button invoked");
        String res = "Give a File Path";
        String filePath = getResponse(res);
        //System.out.println(filePath);
        try {
        document = new Document(filePath);
        String unFormattedText = document.getUnformattedText();
        originalText.setText(unFormattedText);
        alignedText.clear();
        } catch (Exception e){
                displayError(e.getLocalizedMessage());
        }
    }

    @FXML
    private void onSaveClick(ActionEvent event) {
        if (!alignedText.getText().isEmpty()){
            String res = "Save as..";
            String fileName = getResponse(res);
            document = new Document();
            try{
            document.Save(fileName,alignedText.getText());
            }catch (IOException e){
                displayError(e.toString());
            }
        }else {
            displayError("Empty Text");
        }
    }

    @FXML
    private void onExitClick(ActionEvent event) {
        System.out.println("Exit");
        System.exit(0);
    }

    @FXML
    private void onLeftClick(ActionEvent event) {
        //System.out.println("left invoked");
        LeftAligned leftAligned = new LeftAligned();
        Paragraph paragraph = new Paragraph(leftAligned);
        paragraph.setText(originalText.getText());
        if (augmented.isSelected()){
            alignedText.setText(paragraph.alignAndAugmentedText());
        }else{
            alignedText.setText(paragraph.alignText());
        }
    }

    @FXML
    private void onRightClick(ActionEvent event) {
        //System.out.println("right invoked");
        RightAligned rightAligned = new RightAligned();
        Paragraph paragraph = new Paragraph(rightAligned);
        paragraph.setText(originalText.getText());
        if (augmented.isSelected()){
            alignedText.setText(paragraph.alignAndAugmentedText());
        }else{
            alignedText.setText(paragraph.alignText());
        }
    }

    @FXML
    private void onCenteredClick(ActionEvent event) {
        //System.out.println("centred invoked");
        Centered centerAligned = new Centered();
        Paragraph paragraph = new Paragraph(centerAligned);
        paragraph.setText(originalText.getText());
        if (augmented.isSelected()){
            alignedText.setText(paragraph.alignAndAugmentedText());
        }else{
            alignedText.setText(paragraph.alignText());
        }
    }

    @FXML
    private void onJustifiedClick(ActionEvent event) {
        System.out.println("justified invoked");
    }

    @FXML
    private void onAugmentedClick(ActionEvent event) {
        //System.out.println("augmented invoked");
        
        augment = true;
    }

    private void setSelected() {
        left.setSelected(false);
        right.setSelected(false);
        centered.setSelected(false);
        justified.setSelected(false);
        augmented.setSelected(false);
    }

    private String getResponse( String title ) throws NoSuchElementException{
        // Create a new dialog for each load invocation.
        TextInputDialog lfid = new TextInputDialog();
        lfid.setTitle( title );
        lfid.setHeaderText( null );
        // Block until a response has been provided.
        Optional<String> result = lfid.showAndWait();
        if ( !result.isPresent() ) {
            return "cancelled";
        }
        return result.get();
    }
    
    private void displayError( String message ) {
        Alert a = new Alert(AlertType.ERROR);
        a.setTitle( "Error" );
        a.setHeaderText( message );
        a.showAndWait();
    }
}

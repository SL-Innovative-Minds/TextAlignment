/**
 * FXML Controller class
 * @student name: Diyogu Hannadige Yasith Yuvin Gunawardana
 * @Student Index: 12148175
 **/

module ta.textalignment {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ta.textalignment to javafx.fxml;
    exports ta.textalignment;
}

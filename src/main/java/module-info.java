module com.example.dsapractice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dsapractice to javafx.fxml;
    exports com.example.dsapractice;
}
module com.example.PaycheckCalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.VacationWorker to javafx.fxml;
    exports com.example.VacationWorker;
}
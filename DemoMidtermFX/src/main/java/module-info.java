module cipher.demomidtermfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires DemoMidtermExam;


    opens cipher.demomidtermfx to javafx.fxml;
    exports cipher.demomidtermfx;
}
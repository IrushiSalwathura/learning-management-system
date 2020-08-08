package controller;

import business.BOFactory;
import business.BOType;
import business.custom.StudentBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entity.CustomEntity;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import util.AnnouncementTM;
import util.CourseTM;

import java.io.IOException;
import java.util.List;

public class StudentCoursesFormController {
    public AnchorPane root;
    public JFXComboBox<CourseTM> cmbCourses;
    public JFXTextField txtStudentID;
    public Label lblType;
    public Label lblTitle;
    public VBox vBoxAnnouncements;

    private StudentBO studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);

    public void initialize(){
        txtStudentID.setText("S001");
        loadAllCourses();
        cmbCourses.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CourseTM>() {
            @Override
            public void changed(ObservableValue<? extends CourseTM> observable, CourseTM oldValue, CourseTM newValue) {
                if (newValue == null) {
                    lblTitle.setText("");
                    lblType.setText("");
                    return;
                }
                try {
                    CourseTM courseDetails = studentBO.getCourseDetails(txtStudentID.getText(), newValue.toString());
                    lblTitle.setText(courseDetails.getTitle());
                    lblType.setText(courseDetails.getType());

                    List<AnnouncementTM> announcements = studentBO.getAnnouncements(newValue.toString());
                    for (AnnouncementTM announcement : announcements) {
                        Label label = new Label(announcement.toString());
                        vBoxAnnouncements.getChildren().add(label);
                        label.setPrefWidth(806);
                        label.setPrefHeight(52);
                        label.setFont(new Font(18));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
    public void btnDashboard_OnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource(""));
        Scene mainScene =  new Scene(root);
        Stage mainStage = (Stage)this.root.getScene().getWindow();
        mainStage.setScene(mainScene);
        mainStage.centerOnScreen();
    }

    public void btnCourses_OnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/StudentCoursesForm.fxml"));
        Scene mainScene =  new Scene(root);
        Stage mainStage = (Stage)this.root.getScene().getWindow();
        mainStage.setScene(mainScene);
        mainStage.centerOnScreen();
    }

    public void btnModules_OnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/StudentModuleForm.fxml"));
        Scene mainScene =  new Scene(root);
        Stage mainStage = (Stage)this.root.getScene().getWindow();
        mainStage.setScene(mainScene);
        mainStage.centerOnScreen();
    }

    public void btnAccount_OnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/StudentAccountForm.fxml"));
        Scene mainScene =  new Scene(root);
        Stage mainStage = (Stage)this.root.getScene().getWindow();
        mainStage.setScene(mainScene);
        mainStage.centerOnScreen();
    }
    private void loadAllCourses() {
        try {
            cmbCourses.getItems().clear();
            cmbCourses.setItems(FXCollections.observableArrayList(studentBO.getStudentCourses(txtStudentID.getText())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

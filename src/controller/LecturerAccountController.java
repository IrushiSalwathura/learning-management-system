package controller;

import business.BOFactory;
import business.BOType;
import business.custom.LecturerBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entity.Lecturer;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.LectureTM;

import java.io.IOException;

public class LecturerAccountController {
    public AnchorPane root;
    public JFXButton btnDashboard;
    public JFXButton btnCourses;
    public JFXButton btnModules;
    public JFXButton btnAccount;
    public AnchorPane subAnchorPane;
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtNIC;
    public JFXTextField txtAddress;
    public JFXTextField txtEmail;
    public JFXTextField txtContact;
    public Button btnUpdate;
    public JFXTextField txtUserName;
    public JFXPasswordField txtNewPassword2;
    public JFXPasswordField txtCurrentPassword;
    public JFXPasswordField txtNewPassword;
    public JFXTextField txtCourseId;


    private LecturerBO lecturerBO = BOFactory.getInstance().getBO(BOType.LECTURER);

    public void initialize(){
        txtId.setText("L001");
        try {
            LectureTM lecturerDetails = lecturerBO.getLecturer(txtId.getText());
            txtCourseId.setText(lecturerDetails.getCourseId());
            txtName.setText(lecturerDetails.getName());
            txtAddress.setText(lecturerDetails.getAddress());
            txtAddress.setText(lecturerDetails.getContact());
            txtUserName.setText(lecturerDetails.getUsername());
            txtCurrentPassword.setText(lecturerDetails.getPassword());
            txtNIC.setText(lecturerDetails.getNic());
            txtEmail.setText(lecturerDetails.getEmail());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void btnDashboard_OnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource(""));
        Scene mainScene =  new Scene(root);
        Stage mainStage = (Stage)this.root.getScene().getWindow();
        mainStage.setScene(mainScene);
        mainStage.centerOnScreen();
    }

    public void btnCourses_OnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/LecturerCoursesForm.fxml"));
        Scene mainScene =  new Scene(root);
        Stage mainStage = (Stage)this.root.getScene().getWindow();
        mainStage.setScene(mainScene);
        mainStage.centerOnScreen();
    }

    public void btnModules_OnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/LecturerModulesForm.fxml"));
        Scene mainScene =  new Scene(root);
        Stage mainStage = (Stage)this.root.getScene().getWindow();
        mainStage.setScene(mainScene);
        mainStage.centerOnScreen();
    }

    public void btnAccount_OnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/LecturerAccountForm.fxml"));
        Scene mainScene =  new Scene(root);
        Stage mainStage = (Stage)this.root.getScene().getWindow();
        mainStage.setScene(mainScene);
        mainStage.centerOnScreen();
    }

    public void btnUpdate_OnAction(ActionEvent actionEvent) {
        txtId.setText("L001");
        if(btnUpdate.equals("Update")){
            try {
                lecturerBO.updateLecturer(txtCourseId.getText(),
                        txtName.getText(),txtAddress.getText(),txtContact.getText(),txtUserName.getText(),
                        txtNewPassword2.getText(),txtNIC.getText(),
                        txtEmail.getText(),txtId.getText());
                new Alert(Alert.AlertType.INFORMATION,"Lecturer updated successfully", ButtonType.OK).showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

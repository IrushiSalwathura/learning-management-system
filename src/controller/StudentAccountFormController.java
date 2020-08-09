package controller;

import business.BOFactory;
import business.BOType;
import business.custom.LecturerBO;
import business.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.LectureTM;
import util.StudentTM;

import java.io.IOException;

public class StudentAccountFormController {
    public JFXButton btnDashboard;
    public AnchorPane root;
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
    public JFXTextField txtUserName;
    public JFXPasswordField txtNewPassword;
    public JFXPasswordField txtNewPassword2;
    public Button btnUpdate;
    public JFXTextField txtFacultyId;
    public JFXTextField txtPasswordShow;
    public JFXPasswordField txtPasswordHide;
    public ImageView imgPasswordShow;
    public ImageView imgPasswordHide;

    private StudentBO studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);

    public void initialize(){
        txtPasswordShow.setVisible(false);
        imgPasswordShow.setVisible(false);

        try {
            StudentTM studentDetails = studentBO.getStudent("S001");
            txtId.setEditable(false);
            txtId.setText(studentDetails.getId());
            txtFacultyId.setText(studentDetails.getFacultyId());
            txtName.setText(studentDetails.getName());
            txtAddress.setText(studentDetails.getAddress());
            txtContact.setText(studentDetails.getContact());
            txtUserName.setText(studentDetails.getUsername());
            txtPasswordShow.setText(studentDetails.getPassword());
            txtNIC.setText(studentDetails.getNic());
            txtEmail.setText(studentDetails.getEmail());

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

    public void btnUpdate_OnAction(ActionEvent actionEvent) {
        try {
            studentBO.updateStudent(txtFacultyId.getText(),
                    txtName.getText(),txtAddress.getText(),txtContact.getText(),txtUserName.getText(),
                    txtNewPassword2.getText(),txtNIC.getText(),
                    txtEmail.getText(),txtId.getText());
            new Alert(Alert.AlertType.INFORMATION,"your details have been updated successfully", ButtonType.OK).showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void imgPasswordHide_OnMouseClicked(MouseEvent mouseEvent) {
        txtPasswordHide.setVisible(false);
        imgPasswordHide.setVisible(false);
        imgPasswordShow.setVisible(true);
        txtPasswordShow.setVisible(true);

        txtPasswordShow.requestFocus();
        txtPasswordShow.deselect();
        txtPasswordShow.positionCaret(txtPasswordShow.getLength());
    }

    public void imgPasswordShow_OnMouseClicked(MouseEvent mouseEvent) {
        imgPasswordShow.setVisible(false);
        txtPasswordShow.setVisible(false);
        txtPasswordHide.setVisible(true);
        imgPasswordHide.setVisible(true);

        txtPasswordHide.requestFocus();
        txtPasswordHide.deselect();
        txtPasswordHide.positionCaret(txtPasswordHide.getLength());
    }
}

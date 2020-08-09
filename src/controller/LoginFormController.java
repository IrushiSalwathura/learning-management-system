package controller;

import business.custom.AdminBO;
import business.custom.LecturerBO;
import business.custom.StudentBO;
import business.custom.UserBO;
import business.custom.impl.AdminBOImpl;
import business.custom.impl.LecturerBOImpl;
import business.custom.impl.StudentBOImpl;
import business.custom.impl.UserBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.UserTM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginFormController {
    public JFXPasswordField txtPassword;
    public JFXTextField txtUsername;
    public JFXButton btnLogin;
    public JFXButton btnCancel;
    public AnchorPane root;
    public static String loginId;

    private UserBO userBO = new UserBOImpl();
    private StudentBO studentBO= new StudentBOImpl();
    private LecturerBO lecturerBO = new LecturerBOImpl();
    private AdminBO adminBO= new AdminBOImpl();

    public void btnLogin_OnAction(ActionEvent actionEvent) throws Exception {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        List<UserTM> allUsers = userBO.getAllUsers();


        for (UserTM user : allUsers) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                if (user.getUserRole().equals("Student")) {
                    loadView("/view/StudentCoursesForm.fxml");
                    String studentId = studentBO.getStudentId(user.getId());
                    loginId = studentId;
                    System.out.println(loginId);
                }
                else if(user.getUserRole().equals("Lecturer")){
                    loadView("/view/LecturerCoursesForm.fxml");
                    String lecturerId = lecturerBO.getLecturerId(user.getId());
                    loginId = lecturerId;
                }
                else if(user.getUserRole().equals("Admin")){
                    loadView("/view/AdminDashboard.fxml");
                    String adminId = adminBO.getAdminId(user.getId());
                    loginId = adminId;
                }
                else{
                    if (user.getPassword()!=txtPassword .getText()|| user.getUsername()!=txtUsername.getText()) {
                        //TODO: ADD ALERT
                    }
                }
            }
        }
        System.out.println(loginId);
    }

    public void btnCancel_OnAction(ActionEvent actionEvent) {
        System.exit(0);
        loginId = null;
    }

    public void loadView(String location) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource(location));
        Scene mainScene =  new Scene(root);
        Stage mainStage = (Stage)this.root.getScene().getWindow();
        mainStage.setScene(mainScene);
        mainStage.centerOnScreen();
    }
}

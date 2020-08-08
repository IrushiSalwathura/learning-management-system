package controller;

import business.custom.CourseBO;
import business.custom.ModuleBO;
import business.custom.StudentBO;
import business.custom.impl.CourseBOImpl;
import business.custom.impl.ModuleBOImpl;
import business.custom.impl.StudentBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.CourseTM;
import util.ModuleTM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentModuleFormController {
    public AnchorPane root;
    public JFXButton btnDashboard;
    public JFXButton btnCourses;
    public JFXButton btnModules;
    public JFXButton btnAccount;
    public Label lblCourseName;
    public Label lblDescription;
    public Label lblModuleDescription;
    public Label lblDuration;
    public JFXComboBox cmbModules;
    public Label lblCredits;
    public Label lblModuleTitle;
    public JFXComboBox cmbCourses;

    public void initialize() throws Exception {
        loadAllCoursesOfStudent("S001");
        loadAllCourseModules("C001");
        getModuleDetails("M001");
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

    public void loadAllCoursesOfStudent(String studentId) throws Exception {
        cmbCourses.getItems().clear();
        StudentBO studentBO = new StudentBOImpl();
        List<CourseTM> courses = studentBO.getStudentCourses(studentId);
        ObservableList<CourseTM> courseTM = FXCollections.observableArrayList(courses);
        cmbCourses.setItems(courseTM);
    }
//
    //TODO: call this method when a course is selected from cmbCourses
    public void loadAllCourseModules(String courseId) throws Exception {
        cmbModules.getItems().clear();
        ModuleBO moduleBO = new ModuleBOImpl();
        List<ModuleTM> modules = moduleBO.getCourseModules(courseId);
        ObservableList<ModuleTM> moduleTMS = FXCollections.observableArrayList(modules);
        cmbModules.setItems(moduleTMS);
    }

    public void getModuleDetails(String moduleId) throws Exception {
        ModuleBOImpl moduleBO = new ModuleBOImpl();
        ModuleTM module = moduleBO.getModule(moduleId);
        lblCredits.setText(module.getCredits());
        lblDuration.setText(module.getDuration());
        lblDescription.setText("Add description attribute to the Module table!!!!!!!!!!!!!!!!!!!!!!!");
    }

    //TODO: add a method to get the amount of module content
}

package controller;

import business.custom.ContentBO;
import business.custom.LecturerBO;
import business.custom.ModuleBO;
import business.custom.impl.ContentBOImpl;
import business.custom.impl.LecturerBOImpl;
import business.custom.impl.ModuleBOImpl;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.ContentTM;
import util.CourseTM;
import util.ModuleTM;

import java.io.IOException;
import java.util.List;

public class LecturerModuleContentController {
    public AnchorPane root;
    public JFXComboBox cmbCourses;
    public ListView lstContent;
    public DatePicker txtDate;
    public ComboBox cmbModuleId;

    public void initialize() throws Exception {
        loadAllCoursesOfLecturerInFaculty("L001","F001");
        loadAllCourseModules("C001");
        loadAllModuleContent("M001");
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
    public void loadAllCoursesOfLecturerInFaculty(String lecturerId, String facultyId) throws Exception {
        cmbCourses.getItems().clear();
        LecturerBO lecturerBO = new LecturerBOImpl();
        List<CourseTM> lecturerFacultyCourses = lecturerBO.getLecturerFacultyCourses(lecturerId, facultyId);
        ObservableList<CourseTM> courseTMS = FXCollections.observableArrayList(lecturerFacultyCourses);
        cmbCourses.setItems(courseTMS);
    }

    public void loadAllCourseModules(String courseId) throws Exception {
        cmbModuleId.getItems().clear();
        ModuleBO moduleBO= new ModuleBOImpl();
        List<ModuleTM> courseModules = moduleBO.getCourseModules(courseId);
        ObservableList<ModuleTM> moduleTMS = FXCollections.observableArrayList(courseModules);
        cmbModuleId.setItems(moduleTMS);
    }

    public void loadAllModuleContent(String moduleId) throws Exception {
        lstContent.getItems().clear();
        ContentBO contentBO = new ContentBOImpl();
        List<ContentTM> allContent = contentBO.getModuleContent(moduleId);
        ObservableList<ContentTM> contentTMS = FXCollections.observableArrayList(allContent);
        lstContent.setItems(contentTMS);
    }

    public void btnAddContent_OnAction(ActionEvent actionEvent) {

    }
}

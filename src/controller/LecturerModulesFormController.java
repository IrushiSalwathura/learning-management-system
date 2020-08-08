package controller;

import business.custom.LecturerBO;
import business.custom.ModuleBO;
import business.custom.impl.LecturerBOImpl;
import business.custom.impl.ModuleBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.CourseTM;
import util.FacultyTM;
import util.ModuleTM;

import java.io.IOException;
import java.util.List;

public class LecturerModulesFormController {
    public AnchorPane root;
    public JFXButton btnDashboard;
    public JFXComboBox cmbCourses;
    public JFXComboBox cmbFaculty;
    public ListView<ModuleTM> lstModules;

    public void initialize() throws Exception {
        loadAllFacultiesOfLecturer("L001");
        loadAllCoursesOfLecturerInFaculty("L001","F001");
        loadAllCourseModules("C001");

        lstModules.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ModuleTM>() {
            @Override
            public void changed(ObservableValue<? extends ModuleTM> observable, ModuleTM oldValue, ModuleTM selectedModule) {
                if(selectedModule==null){
                    return;
                }
                try {
                    loadModuleContent();
                } catch (IOException e) {
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

    public void loadAllFacultiesOfLecturer(String lecturerId) throws Exception {
        cmbFaculty.getItems().clear();
        LecturerBO lecturerBO = new LecturerBOImpl();
        List<FacultyTM> faculties = lecturerBO.getLecturerFaculties(lecturerId);
        ObservableList<FacultyTM> facultyTMS = FXCollections.observableArrayList(faculties);
        cmbFaculty.setItems(facultyTMS);
    }

    public void loadAllCoursesOfLecturerInFaculty(String lecturerId, String facultyId) throws Exception {
        cmbCourses.getItems().clear();
        LecturerBO lecturerBO = new LecturerBOImpl();
        List<CourseTM> lecturerFacultyCourses = lecturerBO.getLecturerFacultyCourses(lecturerId, facultyId);
        ObservableList<CourseTM> courseTMS = FXCollections.observableArrayList(lecturerFacultyCourses);
        cmbCourses.setItems(courseTMS);
    }

    public void loadAllCourseModules(String courseId) throws Exception {
        lstModules.getItems().clear();
        ModuleBO moduleBO= new ModuleBOImpl();
        List<ModuleTM> courseModules = moduleBO.getCourseModules(courseId);
        ObservableList<ModuleTM> moduleTMS = FXCollections.observableArrayList(courseModules);
        lstModules.setItems(moduleTMS);
    }

    public void loadModuleContent() throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/LecturerModuleContent.fxml"));
        Scene mainScene = new Scene(root);
        Stage mainStage = (Stage) this.root.getScene().getWindow();
        mainStage.setScene(mainScene);
        mainStage.centerOnScreen();
    }

}

package controller;

import business.custom.ContentBO;
import business.custom.ModuleBO;
import business.custom.StudentBO;
import business.custom.impl.ContentBOImpl;
import business.custom.impl.ModuleBOImpl;
import business.custom.impl.StudentBOImpl;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

public class StudentModuleContentController {

    public AnchorPane root;
    public JFXComboBox<CourseTM> cmbCourses;
    public ListView lstContent;
    public DatePicker txtDate;
    public ComboBox<ModuleTM> cmbModuleId;

    public void initialize() throws Exception {
        loadAllStudentCourses("S001");
//        loadAllCourseModules("C001");
//        loadAllModuleContent("M001");
        cmbModuleId.setVisible(false);

        cmbCourses.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CourseTM>() {
            @Override
            public void changed(ObservableValue<? extends CourseTM> observable, CourseTM oldValue, CourseTM selectedCourse) {
                if(selectedCourse==null){
                    return;
                }
                cmbModuleId.setVisible(true);
                String courseId = selectedCourse.getId();
                try {
                    loadAllCourseModules(courseId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        cmbModuleId.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ModuleTM>() {
            @Override
            public void changed(ObservableValue<? extends ModuleTM> observable, ModuleTM oldValue, ModuleTM selectedModule) {
                if(selectedModule==null){
                    return;
                }
                String moduleId = selectedModule.getId();
                try {
                    loadAllModuleContent(moduleId);
                    System.out.println("Done");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("error");
                }
            }
        });

        //TODO: add lstContent Event Listener to view a file when a row is clicked
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

    public void loadAllStudentCourses(String studentId) throws Exception {
        cmbCourses.getItems().clear();
        StudentBO studentBO = new StudentBOImpl();
        List<CourseTM> studentCourses = studentBO.getStudentCourses(studentId);
        ObservableList<CourseTM> courseTMS = FXCollections.observableArrayList(studentCourses);
        cmbCourses.setItems(courseTMS);
    }

    public void loadAllCourseModules(String courseId) throws Exception {
        ModuleBO moduleBO = new ModuleBOImpl();
        List<ModuleTM> courseModules = moduleBO.getCourseModules(courseId);
        ObservableList<ModuleTM> moduleTMS = FXCollections.observableArrayList(courseModules);
        cmbModuleId.getItems().clear();
        cmbModuleId.setItems(moduleTMS);
    }
    public void loadAllModuleContent(String moduleId) throws Exception {
        lstContent.getItems().clear();
        ContentBO contentBO = new ContentBOImpl();
        List<ContentTM> allContent = contentBO.getModuleContent(moduleId);
        ObservableList<ContentTM> contentTMS = FXCollections.observableArrayList(allContent);
        lstContent.setItems(contentTMS);
    }
}

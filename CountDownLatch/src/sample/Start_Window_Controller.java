package sample;

import Controller.Controller_;
import Model.ADT.*;
import Model.Exceptions.MyException;
import Model.ProgramState;
import Model.Statements.IStatement;
import Repository.IRepository;
import Repository.Repository;
import View.main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

//import javax.swing.text.html.ListView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Start_Window_Controller {
    private ArrayList<IStatement> options = null;
    private Integer index = null;
    private Stage start_window = null;
    private Stage main_window = null;

    @FXML
    private ListView<String> statements_list;

    @FXML
    public void initialize() {
        this.options = main.getAll();
        this.populate();
    }

    public void setStartWindow(Stage startPage) { this.start_window = startPage; }

    public void setMainWindow(Stage _window){ this.main_window = _window; }

    private void populate(){
        ObservableList<String> lst = FXCollections.observableArrayList();
        lst.addAll(options.stream().map(Object::toString).collect(Collectors.toList()));
        statements_list.setItems(lst);
    }

    public void itemClicked(MouseEvent mouseEvent){
        this.index = this.statements_list.getSelectionModel().getSelectedIndex();
    }

    public IStatement getSelectedProgram(int index) { return this.options.get(index); }

    @FXML
    public void executeClicked(MouseEvent mouseEvent) throws Exception {
        if(this.index == null){
            Alert errorAlert = new Alert (Alert.AlertType.ERROR);
            errorAlert.setHeaderText("No item selected! ");
            errorAlert.setContentText("Choose an intem on the list and press 'Execute'! ");
            errorAlert.showAndWait();
            return;
        }
        else
            //System.out.println(this.index);
            try {
                this.setProgramStateController(this.getSelectedProgram(this.index), this.index);
            }
            catch (Exception e){
                Alert errorAlert = new Alert (Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Something went wrong! ");
                errorAlert.setContentText("Kill yourself! ");
                errorAlert.showAndWait();
                //System.out.println(e.getMessage());
            }
//        set_main_window_controller(getSelectedProgram(this.index), index);
    }

    public void setProgramStateController(IStatement selectedPrg, Integer index){
        try{
            //Setting the controller for the Program State
            selectedPrg.typecheck(new MyDictionary<>());
            ProgramState prgState = new ProgramState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), selectedPrg, new MyHeap<>(), new LatchTable());
            IRepository repo = new Repository(prgState, "log " + index + ".txt");
            Controller_ controller_ = new Controller_(repo);


            // Starting the main page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Main_Window.fxml"));
            Scene scene = new Scene(loader.load(),712, 560);
            Main_Window_Controller controller = loader.getController();
            controller.setProgramController(controller_);
            Stage mainStage = new Stage();

            mainStage.setScene(scene);
            controller.setCurrentStage(mainStage);
            mainStage.show();

        }
        catch (MyException | IOException e){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("TypeCheck Error");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }
    }

}

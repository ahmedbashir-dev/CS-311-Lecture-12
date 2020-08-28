package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    private BorderPane root;
    private HBox titleHbox, nameHBox, phoneHbox, addressHbox, orderDetailHbox, bottomHbox;
    private VBox customerVbox, sizeVbox, crustVbox, toppingVbox;
    private FlowPane toppingsFlowpane;

    private Button okBtn, cancelBtn;
    private Label titleLb, nameLb, phoneLb, addressLb, sizeLb, crustLb, toppingsLb;
    private TextField nameTf, phoneTf, addressTf;
    private RadioButton smallRb, mediumRb, largeRb, thinRb, thickRb;
    private ToggleGroup sizeTg, crustTg;
    private CheckBox pepperoniCb, mushroomsCb, sausageCb, tomatoesCb, linguicaCb, anchoviesCb, olivesCb;
    Button btn1, btn2, btn3, btn4;
    @Override
    public void start(Stage primaryStage) throws Exception{
        titleLb = new Label("Order Your Pizza Now!");
        titleLb.setFont(new Font(36));
        titleHbox = new HBox(titleLb);

        //Customer Details
        nameLb = getLabel("Name: ");
        nameTf = getTextField("Enter Customer's Name");
        nameHBox = new HBox(20,nameLb,nameTf);

        phoneLb = getLabel("Phone Number:");
        phoneTf = getTextField("Enter Customer's Phone Number");
        phoneHbox = new HBox(20,phoneLb,phoneTf);

        addressLb = getLabel("Address: ");
        addressTf = getTextField("Enter Customer's Address");
        addressHbox = new HBox(20,addressLb,addressTf);

        customerVbox = new VBox(20,nameHBox,phoneHbox,addressHbox);


        ButtonHandler bh = new ButtonHandler();
        btn1 = new Button("Button 1");

        btn2 = new Button("Button 2");
        btn3 = new Button("Button 3");
        btn4 = new Button("Button 4");
        btn1.setOnAction(bh);
        btn2.setOnAction(bh);
        btn3.setOnAction(bh);
        btn4.setOnAction(bh);
        bottomHbox = new HBox(30,btn1,btn2,btn3,btn4);



        //Main Root
        root = new BorderPane();
        root.setTop(titleHbox);
        root.setCenter(customerVbox);
        root.setBottom(bottomHbox);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private class ButtonHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == btn1){
                System.out.println("Button 1 Clicked");
            }
            else if(event.getSource() == btn2){
                System.out.println("Button 2 Clicked");
            }
            else if(event.getSource() == btn3){
                System.out.println("Button 3 Clicked");
            }
            else if(event.getSource() == btn4){
                System.out.println("Button 4 Clicked");
            }
            System.out.println(event.getTarget());

        }
    }

    private TextField getTextField(String promptText) {
        TextField tf = new TextField();
        tf.setPromptText(promptText);
        tf.setPrefColumnCount(20);
        tf.setFont(Font.font("Arial",16));
        return tf;
    }

    private Label getLabel(String labelText) {
        Label lb = new Label(labelText);
        lb.setPrefWidth(100);
        lb.setFont(Font.font("Arial",16));
        return lb;
    }

    private Label getLabel(String labelText, int colCount){
        Label lb = new Label(labelText);
        lb.setPrefWidth(colCount);
        lb.setFont(Font.font("Arial",16));
        return lb;
    }


    public static void main(String[] args) {
        launch(args);
    }
}

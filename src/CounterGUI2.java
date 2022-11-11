
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


/**
 * A simple GUI that counts continuously
 *
 * @author Karen Laurin
 */
public class CounterGUI2 extends Application {

    private Button btnCount;
    private Button btnReset;
    public static Label lblCount;


    /**
     * the count button handler - using this to simulate a computational task
     * @param e the action that took place
     */
    private void btnCountHandler(ActionEvent e){

        Thread th = new Thread(new BackgroundTask());
        th.start();



    }

    /**
     * the reset button handler - resets the label back to the starting value
     * @param e the action that took place
     */
    private void btnResetHandler (ActionEvent e){
        lblCount.setText("Ready to go!");
    }

    /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(400, 300); // Set canvas Size in Pixels
        stage.setTitle("Counter - Single Thread"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Create buttons and labels
        btnCount = new Button("Start Count");
        btnReset = new Button("Stop Count");
        lblCount = new Label();

        // Add buttons and labels to the canvas
        root.getChildren().addAll(btnCount, btnReset, lblCount);

        // Relocate everything, as by default they are all placed at 0,0
        btnCount.relocate(100, 200);
        btnReset.relocate(200, 200);
        lblCount.relocate(150, 100);

        // Set the action to take when the button is pressed (sets up the listeners)
        btnCount.setOnAction(this::btnCountHandler);
        btnReset.setOnAction(this::btnResetHandler);

        lblCount.setText("Ready to go!");

        // display to the user
        stage.show();
    }



    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) { launch(args);
    }
}

package mygeocal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import static mygeocal.Grid.dY;

public class MyGeoCal extends Application {
    public static String[] args;
    public static double tmp = 400;
    static Parent rename;
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        System.out.println("stated");
        Scene scene = new Scene(root);
        FXMLDocumentController.stage = stage;
        stage.setScene(scene);
        stage.setTitle("GeoCal");
        double tmp = 400;
        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
//                System.out.println("width "+ FXMLDocumentController.tabPane.getWidth() + " "  +  oldVal +" " +newVal );
//                FXMLDocumentController.separator.setPrefWidth((double) newVal);
//                FXMLDocumentController.toolBar.setPrefWidth((double) newVal);
//                FXMLDocumentController.toolBar.setMaxWidth((double) newVal);
                FXMLDocumentController.pane.setMaxWidth((double) newVal);
                
                FXMLDocumentController.canvas.setWidth((double) newVal  );
                FXMLDocumentController.page.clearCanvas(FXMLDocumentController.page.gc);
                FXMLDocumentController.page.redraw(FXMLDocumentController.page.gc);
                
            });

            stage.heightProperty().addListener((obs, oldVal, newVal) -> {
                FXMLDocumentController.pane.setMaxHeight((double) newVal);
                FXMLDocumentController.canvas.setHeight((double) newVal - dY);
                FXMLDocumentController.page.clearCanvas(FXMLDocumentController.page.gc);
                FXMLDocumentController.page.redraw(FXMLDocumentController.page.gc);
                System.out.println(FXMLDocumentController.canvas.getHeight());
            }); 
        stage.getIcons().add(new Image("/image/GeoCal.png"));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}

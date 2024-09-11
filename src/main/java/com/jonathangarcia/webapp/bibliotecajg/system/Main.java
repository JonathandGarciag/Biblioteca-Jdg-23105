package com.jonathangarcia.webapp.bibliotecajg.system;

import com.jonathangarcia.webapp.bibliotecajg.BibliotecajgApplication;
import com.jonathangarcia.webapp.bibliotecajg.controller.FXController.IndexController;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
    //atributos
    private ConfigurableApplicationContext applicationContext;
    private Stage stage;
    private Scene scene;
    
    //Se ejecuta cada vez que yo instancia la clase Main
    @Override
    public void init(){
        this.applicationContext = new SpringApplicationBuilder(BibliotecajgApplication.class).run();
    }

    //Se ejecuta al iniciar la aplicación de javaFX
    @Override
    public void start(Stage prymaryStage) throws Exception{
        this.stage = prymaryStage;
        stage.setTitle("Biblioteca Springboot");
        //carga la escena principal
        indexView();
        stage.show();
    }

    //metodo para cambiar la escena del stage
    public Initializable cambiarEscena(String fxmlName, int width, int height)throws IOException{
        Initializable initializable = null;
        FXMLLoader loader = new FXMLLoader();

        loader.setControllerFactory(applicationContext::getBean);
        InputStream archivo = Main.class.getResourceAsStream("/templates/"+  fxmlName);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource("/templates/"+  fxmlName));

        scene = new Scene((AnchorPane)loader.load(archivo), width, height);
        stage.setScene(scene);
        stage.sizeToScene();

        initializable = loader.getController();

        return initializable;
    }

    public void indexView(){
        try {
            IndexController indexView = (IndexController)cambiarEscena("index.fxml", 600, 400);
            indexView.setStage(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

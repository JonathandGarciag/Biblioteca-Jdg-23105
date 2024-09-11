package com.jonathangarcia.webapp.bibliotecajg.controller.FXController;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jonathangarcia.webapp.bibliotecajg.service.CategoriaService;
import com.jonathangarcia.webapp.bibliotecajg.system.Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.Setter;

@Component
public class IndexController implements Initializable {
    @Setter
    private Main stage;

    private int op;

    @FXML
    TextField tfId, tfNombre;
    @FXML
    TableView tblCategorias;
    @FXML
    TableColumn colId, colNombre;
    @FXML
    Button btnGuardar;

    @Autowired
    CategoriaService categoriaService;

//Se ejecuta cada que yo levanto la vista
    @Override
    public void initialize(URL location, ResourceBundle recources){
        cargarDatos();
    }

    public void handleButtonAction(ActionEvent event){
        if(event.getSource() == btnGuardar){
            if(tfId.getText().isBlank()){
                agregarCategoria();
            }else{
                editarCategoria();
            }
        }
    }

    public void cargarDatos(){

    }

    public ObservableList<Categoria> listaCategorias(){
        return FXCollections.observableArrayList(categoriaService);
    }

    public void agregarCategoria(){

    }

    public void editarCategoria(){
        Categoria categoria = categoriaService.buscarCategoriaPorId(Long.parseLong(tdId.getText())

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djview;

/**
 *
 * @author Nicolás
 */
public class ElectroTraining extends Modelo{
    ElectroTrainingInterface Electro=  ElectroTrainingModel.getInstance();
    public ElectroTraining(){
        
        controller = new ElectroTrainingController(Electro);
        view = new ElectroTrainingView(controller, new ElectroAdapter(Electro));
    }
    
}

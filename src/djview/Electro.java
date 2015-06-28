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
public class Electro extends Modelo{
    ElectroTrainingInterface electroInterface = ElectroTrainingModel.getInstance();
    public Electro(){
        controller = new ElectroTrainingController(electroInterface);
        view = new ElectroTrainingView(controller, new ElectroAdapter(electroInterface));
    }
}

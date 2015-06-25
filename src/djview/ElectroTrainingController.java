/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djview;

/**
 *
 * @author NicolÃ¡s
 */
public class ElectroTrainingController implements ControllerInterface{
    ElectroTrainingInterface model;
    DJView view;
  
    public ElectroTrainingController(ElectroTrainingInterface model) {
    	this.model = model;
	view = new DJView(this, new ElectroAdapter(model));
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
	view.enableStartMenuItem();
    }
  
    public void start() {
        this.model.onn();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }
 
    public void stop() {
        this.model.offf();
	view.disableStopMenuItem();
	view.enableStartMenuItem();}
    
    public void increaseBPM() {
        int nivel =model.getNivel();
        nivel=nivel+1;
        if(0<nivel&&9>=nivel){
            model.setNivel(nivel);
        }
    }
    public void decreaseBPM() {
        int nivel =model.getNivel();
        nivel=nivel-1;
        if(0<nivel&&9>=nivel){
            model.setNivel(nivel);
        }
    }
    public void setBPM(int nivel) {
        if(0<nivel&&9>=nivel){
            model.setNivel(nivel);
        }
    }
    
}

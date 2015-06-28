
package djview;

public class ElectroTrainingController implements ControllerInterface{
    ElectroTrainingInterface model;
    //DJView view;
    //ElectroTrainingView view;
    DJView view;

    public ElectroTrainingController(ElectroTrainingInterface model) {
        this.model = model;
        view = new DJView(this, new ElectroAdapter(model));
        view.createView();        
        view.createControls();
        view.enableSet();
        view.disableStopMenuItem();
	view.enableStartMenuItem();
    }
  
    public ElectroTrainingController(ElectroTrainingInterface model, NewView view) {
    	this.model = model;
	//view = new DJView(this, new ElectroAdapter(model));
        //view = new ElectroTrainingView(this, new ElectroAdapter(model));
        this.view=view;
        //view.createView();
        //view.createControls();
        view.setElectroView();
        view.enableSet();
        view.disableStopMenuItem();
	view.enableStartMenuItem();
    }
  
    public void start() {
        this.model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
        view.disableSet();
    }
    public void stop() {
        this.model.off();
	view.disableStopMenuItem();
	view.enableStartMenuItem();
        view.enableSet();
    }
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
            model.setNivel(nivel);       
    }
    
}

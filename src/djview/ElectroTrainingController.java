
package djview;

public class ElectroTrainingController implements ControllerInterface
{
    ElectroTrainingInterface model;
    //DJView view;
    ElectroTrainingView view;
  
    public ElectroTrainingController(ElectroTrainingInterface model) 
    {
    	this.model = model;
	//view = new DJView(this, new ElectroAdapter(model));
        view = new ElectroTrainingView(this, new ElectroAdapter(model));
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
	view.enableStartMenuItem();
    }
  

    @Override
    public void start() 
    {
        this.model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
        view.disableSet();
    }
    @Override
    public void stop() 
    {
        this.model.off();
	view.disableStopMenuItem();
	view.enableStartMenuItem();
        view.enableSet();
    }
    @Override
    public void increaseBPM() 
    {
        int nivel =model.getNivel();
        nivel=nivel+1;
        if(0<nivel&&9>=nivel){
            model.setNivel(nivel);
        }
    }
    @Override
    public void decreaseBPM() 
    {
        int nivel =model.getNivel();
        nivel=nivel-1;
        if(0<nivel&&9>=nivel){
            model.setNivel(nivel);
        }
    }
    @Override
    public void setBPM(int nivel) 
    {
            model.setNivel(nivel);       
    }
    
}

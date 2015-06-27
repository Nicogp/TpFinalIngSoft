
package djview;


public class Beat extends Modelo{
    BeatModelInterface model2 = new BeatModel();
    public Beat(){
        
        controller = new BeatController(model2);
        view = new DJView(controller, model2);
    }
}

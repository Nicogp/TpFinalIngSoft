
package djview;

public class Heart extends Modelo{
    HeartModelInterface heartModel = HeartModel.getInstance();
    public void Heart(){
        controller = new HeartController(heartModel);
        view = new DJView(controller, new HeartAdapter(heartModel));
    }
    
    
}


package djview;

public class MyTestDriveTriple {
    public static void main (String[] args) {
        ElectroTrainingModel Electro=  ElectroTrainingModel.getInstance();
        ControllerInterface model = new ElectroTrainingController(Electro);
        HeartModel heartModel = HeartModel.getInstance();
	ControllerInterface model1 = new HeartController(heartModel);
        BeatModelInterface model2 = new BeatModel();
	ControllerInterface controller = new BeatController(model2);
    }
    
}

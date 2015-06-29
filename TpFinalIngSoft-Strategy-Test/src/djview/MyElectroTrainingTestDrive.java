
package djview;
  
public class MyElectroTrainingTestDrive {
    
    public static void main (String[] args) {
        ElectroTrainingModel Electro=  ElectroTrainingModel.getInstance();
        ControllerInterface model = new ElectroTrainingController(Electro);
    }
}
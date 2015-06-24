
package djview;

import java.util.ArrayList;
import java.util.Random;

public class ElectroTrainingModel implements ElectroTrainingInteface, Runnable {
    @SuppressWarnings("rawtypes")
    ArrayList beatObservers = new ArrayList();
    @SuppressWarnings("rawtypes")
    ArrayList bpmObservers = new ArrayList();
    int time = 1000;
    int nivel=1;
    int tiempo=15000;
    Random random = new Random(System.currentTimeMillis());
    Thread thread;
    private static ElectroTrainingModel uniqueInstance;
    int muscular []= {3,6,1,7};
    int performance[]={2,4,1,5};
    boolean manual;
    boolean tipoautomatico; //true es muscular, false performance

    private ElectroTrainingModel() {
	thread = new Thread(this);
	thread.start();//
    }
    public static ElectroTrainingModel getInstance() {
		if(uniqueInstance == null){
			uniqueInstance = new ElectroTrainingModel();
			return uniqueInstance;
		}
		else{
			return uniqueInstance;}
	}
    public void run(){
        int ultimonivel=nivel;
        
        for(;;){
            if(manual){
                switch (ultimonivel){
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                }
                
            }
            else{
                if(tipoautomatico){
                    
                }
                else{
                    
                }
            }
        }
        
    }

    public void on() {
        thread = new Thread(this);
	thread.start();
    }

    public void off() {
        
    }

    public void setBPM(int bpm) {
        this.manual=true;
        this.nivel=bpm;
    }

    public int getBPM() {
        return 0;
    }

    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    public void removeObserver(BeatObserver o) {
         int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
    }

    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    public void removeObserver(BPMObserver o) {
        int i = bpmObservers.indexOf(o);
            if (i >= 0) {
		bpmObservers.remove(i);
            }
    }

    public void initialize() {
        
    }
    
}

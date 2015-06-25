
package djview;

import java.util.ArrayList;
import java.util.Random;

public class ElectroTrainingModel implements ElectroTrainingInterface, Runnable {
    @SuppressWarnings("rawtypes")
    ArrayList beatObservers = new ArrayList();
    @SuppressWarnings("rawtypes")
    ArrayList bpmObservers = new ArrayList();
    int time = 1000;
    int nivel=1;
    int ultimonivel=1;
    int tiempo=15000;
    Random random = new Random(System.currentTimeMillis());
    Thread thread;
    private static ElectroTrainingModel uniqueInstance;
    int muscular []= {3,6,1,7};
    int performance[]={2,4,1,5};
    boolean manual;
    boolean tipoautomatico; //true es muscular, false performance
    boolean iniciar;

    private ElectroTrainingModel() {
	thread = new Thread(this);
	thread.start();
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
        
        notifyBPMObservers();
        int ti=this.tiempo;
        int secuencia=0;
        if(this.nivel>7){       
            switch (nivel){
                case 8:
                    ultimonivel=muscular[secuencia];
                    notifyBPMObservers();
                    break;
                case 9:
                    ultimonivel=performance[secuencia];
                    notifyBPMObservers();
                    break;
            }                        
        }
        else{
            ultimonivel=this.nivel;
        }
        while(this.iniciar){
            
            switch (ultimonivel){
                case 1:
                    notifyBeatObservers();
                    ti=ti-500;
                    try {
                        thread.sleep(500);
                    } catch (Exception e) {
                    }                    
                    break;
                case 2:
                    notifyBeatObservers();
                    ti=ti-166;
                    try {
                        thread.sleep(166);
                    } catch (Exception e) {
                    }                    
                    break;
                case 3:
                    notifyBeatObservers();
                    ti=ti-100;
                    try {
                        thread.sleep(100);
                    } catch (Exception e) {
                    }                    
                    break;
                case 4:
                    notifyBeatObservers();
                    ti=ti-40;
                    try {
                        thread.sleep(40);
                    } catch (Exception e) {
                    }                    
                    break;
                case 5:
                    notifyBeatObservers();
                    ti=ti-20;
                    try {
                        thread.sleep(20);
                    } catch (Exception e) {
                    }
                    
                    break;
                case 6:
                    notifyBeatObservers();
                    ti=ti-14;
                    try {
                        thread.sleep(14);
                    } catch (Exception e) {
                    }                    
                    break;
                case 7:
                    notifyBeatObservers();
                    ti=ti-10;
                    try {
                        thread.sleep(10);
                    } catch (Exception e) {
                    }                    
                    break;
            }
            if(ti<=0){
                if(this.nivel>7){                    
                    secuencia=secuencia+1;
                    if(secuencia>3){
                        this.iniciar=false;
                    }
                    else{
                        switch (nivel){
                            case 8:
                                ultimonivel=muscular[secuencia];
                                break;
                            case 9:
                                ultimonivel=performance[secuencia];
                                break;
                        }
                        ti=this.tiempo;
                        notifyBPMObservers();
                    }
                }
                else{
                    this.offf();
                }                
            }
        }
        
    }

    public void onn() {
        thread = new Thread(this);
        this.iniciar=true;
	thread.start();
    }

    public void offf() {
        this.iniciar=false;
    }

    public void setNivel(int bpm) {
        //this.manual=true;
        this.nivel=bpm;
        ultimonivel=nivel;
        notifyBPMObservers();
    }

    public int getNivel() {
        return this.ultimonivel;
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
    public void notifyBeatObservers() {
	for(int i = 0; i < beatObservers.size(); i++) {
            BeatObserver observer = (BeatObserver)beatObservers.get(i);
            observer.updateBeat();
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
    public void notifyBPMObservers() {
	for(int i = 0; i < bpmObservers.size(); i++) {
            BPMObserver observer = (BPMObserver)bpmObservers.get(i);
            observer.updateBPM();
	}
    }

}

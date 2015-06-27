/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djview;

public class ElectroAdapter implements BeatModelInterface{
    ElectroTrainingInterface electro;
 
    public ElectroAdapter(ElectroTrainingInterface electro) {
		this.electro=electro;
    }

    public void initialize() {}
    public void on() {
        electro.on();
    }
    public void off() {
        electro.off();
    }
    public int getBPM() {
	return electro.getNivel();
    }
    public void setBPM(int bpm) {
        electro.setNivel(bpm);
    }
    public void registerObserver(BeatObserver o) {
	electro.registerObserver(o);
    }
    public void removeObserver(BeatObserver o) {
	electro.removeObserver(o);
    }
    public void registerObserver(BPMObserver o) {
	electro.registerObserver(o);
    }
    public void removeObserver(BPMObserver o) {
	electro.removeObserver(o);
    }    
}


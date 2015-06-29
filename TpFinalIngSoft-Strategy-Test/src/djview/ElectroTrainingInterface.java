
package djview;


public interface ElectroTrainingInterface {
    
    void on();
    void off();
    void setNivel(int bpm);
    int  getNivel();
    void registerObserver(BeatObserver o);
    void removeObserver(BeatObserver o);
    void registerObserver(BPMObserver o);
    void removeObserver(BPMObserver o);
}

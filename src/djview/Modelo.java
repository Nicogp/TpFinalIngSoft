/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 *
 * @author Nicolás
 */
public abstract class Modelo {
    ControllerInterface controller;
    InterfaceVistas view;
    //DJView view;
    //JComboBox cbox;
    //String modelos[]={"BeatModel","HeartModel","ElectroTrainingModel"};

    public Modelo() {/*
        final HeartModel heartModel = HeartModel.getInstance();
	final ControllerInterface model1 = new HeartController(heartModel);
        final BeatModelInterface beatModel = new BeatModel();
	final ControllerInterface model2 = new BeatController(beatModel);
        view = new DJView();
        //cbox=new JComboBox(modelos);
        //view.setCbox(cbox);
        view.createView();
        view.createControls();/*
        cbox.addActionListener(new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                    if("BeatModel".equals(cbox.getSelectedItem())){
                        //model.off();
                        //BeatModelInterface model = new BeatModel();                        
                        //controller=new BeatController(model);
                        controller=model2;
                        view.setController(controller);
                        view.setModel(beatModel);
                        setViewBeat();
                        beatModel.initialize();
                    
                    }
                    if("HeartModel".equals(cbox.getSelectedItem())){
                        //HeartModel heartModel = HeartModel.getInstance();
                        //model.off();
                        //controller=new HeartController(heartModel);
                        model1.setView(view);
                        controller=model1;
                        
                        view.setController(controller);
                        view.setModel((BeatModelInterface) heartModel);
                        setViewHeart();
                    
                    }
                    if("ElectroTrainingModel".equals(cbox.getSelectedItem())){
                        ElectroTrainingModel electromodel = ElectroTrainingModel.getInstance();
                        //model.off();
                        controller=new ElectroTrainingController(electromodel, view, cbox);
                        view.setController(controller);
                        view.setModel((BeatModelInterface) electromodel);
                    
                    }
            
        }
        
        
        });
        */
    }
    /*
    public void setViewBeat(){
        //view.createView(cbox);
        //view.createControls();
	view.disableStopMenuItem();
	view.enableStartMenuItem();
	model.initialize();
    }
    public void setViewHeart(){
        view.disableStopMenuItem();
	view.disableStartMenuItem();
    }

    public void setController(ControllerInterface controller) {
        this.controller = controller;
    }

    public void setView(DJView view) {
        this.view = view;
    }
}
*/
}
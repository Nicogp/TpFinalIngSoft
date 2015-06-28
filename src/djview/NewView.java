/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class NewView extends DJView implements ActionListener,  BeatObserver, BPMObserver {
    ControllerInterface controller;
    BeatModelInterface model;
    NewView view = this;
    JFrame viewFrame;
    JPanel viewPanel;
    BeatBar beatBar;
    JLabel bpmOutputLabel;
    JFrame controlFrame;
    JPanel controlPanel;
    JLabel bpmLabel;
    JTextField bpmTextField;
    JButton setBPMButton;
    JButton increaseBPMButton;
    JButton decreaseBPMButton;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem startMenuItem;
    JMenuItem stopMenuItem;
    String Bpmlabel;
    JComboBox cbox;
    String modelos[]={"","BeatModel","HeartModel","ElectroTrainingModel"};
    /*
    public NewView() {
        //final HeartModel heartModel = HeartModel.getInstance();
	//final ControllerInterface model1 = new HeartController(heartModel, );
        //final BeatModelInterface beatModel = new BeatModel();
	//final ControllerInterface model2 = new BeatController(beatModel, this);
        //view = new DJView();
        createView();
    }*/
    public NewView(ControllerInterface controller, BeatModelInterface model) {
                super(controller, model);
        }
        
        public NewView(){
                super();
                createView();
        }
    public void createView() {
		// Create all Swing components here
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("View");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 80));
        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
        cbox=new JComboBox(modelos);
        //view.createView();
        beatBar = new BeatBar();
        view.createControls();
        cbox.addActionListener(new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                    if("BeatModel".equals(cbox.getSelectedItem())){
                        //model.off();
                        //BeatModelInterface model = new BeatModel();                        
                        //controller=new BeatController(model, this);
                        //controller=model2;
                        //view.setController(controller);
                        //view.setModel(beatModel);
                        //setViewBeat();
                        //beatModel.initialize();
                        if(controller!=null) {
                            controller.stop();
                            model.removeObserver((BeatObserver)view);
                            model.removeObserver((BPMObserver)view);
                            
                        }
                            BeatModel beat = new BeatModel();
                            BeatController beatController= new BeatController(beat,view);
                            setController(beatController);
                            setModel(beat);
                            model.registerObserver((BeatObserver)view);
                            model.registerObserver((BPMObserver)view);
                    
                    }
                    if("HeartModel".equals(cbox.getSelectedItem())){
                        //HeartModel heartModel = HeartModel.getInstance();
                        //model.off();
                        //controller=new HeartController(heartModel);
                        if(controller!=null) {
                            controller.stop();
                            model.removeObserver((BeatObserver)view);
                            model.removeObserver((BPMObserver)view);
                            
                        }
                            HeartModel heart = HeartModel.getInstance();
                            HeartController heartController = new HeartController(heart,view);
                            setController(heartController);
                            setModel(new HeartAdapter(heart));
                            model.registerObserver((BeatObserver)view);
                            model.registerObserver((BPMObserver)view);
                    
                    }
                    if("ElectroTrainingModel".equals(cbox.getSelectedItem())){
                        //ElectroTrainingModel electromodel = ElectroTrainingModel.getInstance();
                        //model.off();
                        //controller=new ElectroTrainingController(electromodel, view, cbox);
                        //view.setController(controller);
                        //view.setModel((BeatModelInterface) electromodel);
                        if(controller!=null) {
                            controller.stop();
                            model.removeObserver((BeatObserver)view);
                            model.removeObserver((BPMObserver)view);
                            
                        }
                            ElectroTrainingModel electromodel = ElectroTrainingModel.getInstance();
                            ElectroTrainingController electro= new ElectroTrainingController(electromodel, view);
                            setController(electro);
                            setModel((new ElectroAdapter(electromodel)));
                            model.registerObserver((BeatObserver)view);
                            model.registerObserver((BPMObserver)view);
                    
                    }
            
        }
        
        
        });
        JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
	bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        bpmPanel.add(cbox);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
        
    }

    public void setController(ControllerInterface controller) {
        this.controller = controller;
    }

    public void setModel(BeatModelInterface model) {
        this.model = model;
    }
    
    public void setBeatView(){
        bpmLabel.setText("Enter BPM:");
        menu.setText("DJ Control");
        Bpmlabel = "Current BPM:";
    }
    public void setHeartView(){
        bpmLabel.setText("Enter BPM:");
        menu.setText("Heart Control");
        Bpmlabel = "Instancias:";
    }
    public void setElectroView(){
        bpmLabel.setText("Ingrese Ejercicio:");
        menu.setText("Electro Training");
        Bpmlabel = "Ejercicio:";
    }
    
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

   public void createControls() {
		// Create all Swing components here
        JFrame.setDefaultLookAndFeelDecorated(true);
        controlFrame = new JFrame("Control");
        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(new Dimension(100, 80));

        controlPanel = new JPanel(new GridLayout(1, 2));

        menuBar = new JMenuBar();
        menu = new JMenu("DJ Control");
        startMenuItem = new JMenuItem("Start");
        menu.add(startMenuItem);
        startMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                controller.start();
            }
        });
        stopMenuItem = new JMenuItem("Stop");
        menu.add(stopMenuItem); 
        stopMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                controller.stop();
            }
        });
        JMenuItem exit = new JMenuItem("Quit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        menu.add(exit);
        menuBar.add(menu);
        controlFrame.setJMenuBar(menuBar);

        bpmTextField = new JTextField(2);
        bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
        setBPMButton = new JButton("Set");
        setBPMButton.setSize(new Dimension(10,40));
        increaseBPMButton = new JButton(">>");
        decreaseBPMButton = new JButton("<<");
        setBPMButton.addActionListener(this);
        increaseBPMButton.addActionListener(this);
        decreaseBPMButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

	buttonPanel.add(decreaseBPMButton);
	buttonPanel.add(increaseBPMButton);

        JPanel enterPanel = new JPanel(new GridLayout(1, 2));
        enterPanel.add(bpmLabel);
        enterPanel.add(bpmTextField);
        JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
        insideControlPanel.add(enterPanel);
        insideControlPanel.add(setBPMButton);
        insideControlPanel.add(buttonPanel);
        controlPanel.add(insideControlPanel);
        
        bpmLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        controlFrame.getRootPane().setDefaultButton(setBPMButton);
        controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);

        controlFrame.pack();
        controlFrame.setVisible(true);
        disableSet();
        disableStartMenuItem();
        disableStopMenuItem();
    }

    public void enableStopMenuItem() {
    	stopMenuItem.setEnabled(true);
	}

    public void disableStopMenuItem() {
    	stopMenuItem.setEnabled(false);
	}

    public void enableStartMenuItem() {
    	startMenuItem.setEnabled(true);
	}

    public void disableStartMenuItem() {
    	startMenuItem.setEnabled(false);
	}
    void disableSet() {
        increaseBPMButton.setEnabled(false);
        decreaseBPMButton.setEnabled(false);
        setBPMButton.setEnabled(false);
    }
    public void enableSet(){
        increaseBPMButton.setEnabled(true);
        decreaseBPMButton.setEnabled(true);
        setBPMButton.setEnabled(true);
    }

    public void actionPerformed(ActionEvent event) {
		if (event.getSource() == setBPMButton) {
			int bpm = Integer.parseInt(bpmTextField.getText());
                        controller.setBPM(bpm);
		} else if (event.getSource() == increaseBPMButton) {
			controller.increaseBPM();
		} else if (event.getSource() == decreaseBPMButton) {
			controller.decreaseBPM();
		}
    }

    public void updateBPM() {
		if (model != null) {
			int bpm = model.getBPM();
			if (bpm == 0) {
				if (bpmOutputLabel != null) {
        			bpmOutputLabel.setText("offline");
				}
			} else {
				if (bpmOutputLabel != null) {
                                    //bpmOutputLabel.setText("Current BPM: " + model.getBPM()+ " Instancias: "+ model.getContador());
                                    bpmOutputLabel.setText(Bpmlabel + model.getBPM());
				}
			}
		}
	}
  
    public void updateBeat() {
		if (beatBar != null) {
			 beatBar.setValue(100);
		}
	}

    
}


    

    


package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;

import org.jfree.ui.RectangleInsets;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.util.ArrayList;
import org.jfree.data.general.PieDataset;

public class PieChartDemo extends ApplicationFrame
{
    private static final long serialVersionUID = 1L;


    private PieDataset  dataset = null;
    JFreeChart  chart = null;

    public PieChartDemo(String title) {
        super(title);
        setContentPane(createInputPanel());

    }

    public JPanel createInputPanel()
    {

        String[] SECTIONS = {"None","None","None","None","None","None","None","None","None","None"};
        double[] EXPENSES = {0,0,0,0,0,0,0,0,0,0};
        chart = ChartFactory.createRingChart("Диаграмма", dataset, true, true, true);
        chart.setPadding(new RectangleInsets(4, 8, 2, 2));
        ChartPanel panel2_2 = new ChartPanel(chart);
        panel2_2.setPreferredSize(new Dimension(400, 400));

        JPanel panel = new JPanel();

        JButton Button_Create = new JButton("Создать");
        panel.add(Button_Create);

        JButton Button_Input = new JButton("Ввод");
        panel.add(Button_Input);



        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("Параметры"));
        GridLayout layout2 = new GridLayout(1, 11, 0, 5);
        panel3.setLayout(layout2);
        panel3.setPreferredSize(new Dimension(1200, 50));
        panel.add(panel3);
        ArrayList<JTextField> list_of_names = new ArrayList<JTextField>();
        for(int i=1; i<11; i++) {
            JTextField textField = new JTextField();
            panel3.add(textField);
            list_of_names.add( textField );
        }



        JPanel panel4 = new JPanel();
        panel4.add(new JLabel("Значения"));
        GridLayout layout4 = new GridLayout(1, 11, 0, 5);
        panel4.setLayout(layout4);
        ArrayList<JTextField> list_of_numbers = new ArrayList<JTextField>();
        for(int i=0; i<10; i++) {
            JTextField textField = new JTextField();
            panel4.add(textField);
            list_of_numbers.add( textField );
        }
        panel4.setPreferredSize(new Dimension(1200, 50));
        panel.add(panel4);

        JPanel panel2 = new JPanel();
        panel2.add(panel2_2);
        panel.add(panel2);

        panel.setPreferredSize(new Dimension(1200, 800));

        Button_Input.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for( int i = 0; i< list_of_names.size(); i++) {
                    if (list_of_names.get(i).getText().length() > 0) {
                        SECTIONS[i] = list_of_names.get(i).getText();
                    }
                }
                for( int i = 0; i< list_of_numbers.size(); i++) {
                    if (list_of_numbers.get(i).getText().length() > 0) {
                        EXPENSES[i] = Integer.parseInt(list_of_numbers.get(i).getText());
                    }
                }
            }

        });

        Button_Create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {dataset = Dataset.createPieDataset(EXPENSES, SECTIONS);
                chart = ChartFactory.createRingChart("Диаграмма", dataset, true, true, true);
                chart.setPadding(new RectangleInsets(4, 8, 2, 2));
                ChartPanel panel2_2 = new ChartPanel(chart);
                panel2_2.setPreferredSize(new Dimension(400, 400));
                panel2.removeAll();
                panel2.revalidate();
                panel2.add(panel2_2);

            }
        });

        return panel;
    }

    public static void main(String[] args)
    {
        PieChartDemo demo = new PieChartDemo("My Diagram");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
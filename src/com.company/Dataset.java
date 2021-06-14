package com.company;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class Dataset
{
    public static PieDataset createPieDataset(double[] expenses, String[] sections)
    {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < sections.length; i++)
            if (sections[i] != "None") {
            dataset.setValue(sections[i], new Double(expenses[i]));
            }
        System.out.println(dataset);
        return dataset;
    }
}
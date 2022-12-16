package ru.croc.FinalProject;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Storage {

    private Map<Integer, String> tasks = new HashMap<>();
    private Map<Integer, String> answers = new HashMap<>();
    private Integer tasksCount;

    public Storage(String tasksFilePath){
        try{

            File f = new File(tasksFilePath);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int taskNumber = 0;

            String line = br.readLine();
            while(line!=null){
                String[] task = line.split(";");
                tasks.put(taskNumber, task[0]);
                answers.put(taskNumber, task[1]);
                taskNumber++;
                line = br.readLine();
            }
            br.close();
            fr.close();

            tasksCount = taskNumber;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer getTasksCount(){
        return tasksCount;
    }

    public String getTask(Integer n){
        return tasks.get(n);
    }

    public String getAnswer(Integer n){
        return answers.get(n);
    }
}

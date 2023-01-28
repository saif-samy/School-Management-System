package projectoop;

import java.io.Serializable;
import java.time.LocalDate;

public class Assignment implements Serializable{
    private String description;
    private LocalDate dueDate;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Assignment description= " + description + ",Assignment dueDate= " + dueDate + "\n";
    }
    
    public Assignment(){
        
    }
    public Assignment(String newDes, LocalDate newDate){
        this.description = newDes;
        this.dueDate = newDate;
    }
}

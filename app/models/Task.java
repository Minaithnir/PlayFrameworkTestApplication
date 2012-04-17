package models;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Vincent
 * Date: 17/04/12
 * Time: 12:13
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Task extends Model {

    @Required(message = "Please enter a label for your task")
    @MaxSize(value = 50, message = "The label can't be bigger than 50 characters")
    public String label;

    @Required(message = "Please enter a description")
    @MaxSize(value = 1000, message = "The description can't be bigger than 1000 characters")
    public String description;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return id + ": " + label;
    }
}

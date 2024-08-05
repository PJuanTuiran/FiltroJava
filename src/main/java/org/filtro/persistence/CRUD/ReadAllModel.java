package org.filtro.persistence.CRUD;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;

public interface ReadAllModel<Entity> {
    public ArrayList<Entity> getAll();
}

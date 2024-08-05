package org.filtro.persistence.CRUD;

import javax.swing.text.html.parser.Entity;
import java.security.PublicKey;
import java.util.ArrayList;

public interface ReadModel <Entity, ID>{
    public ArrayList<Entity> read(ID field);
}

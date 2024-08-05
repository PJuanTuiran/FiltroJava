package org.filtro.persistence.CRUD;

public interface UpdateModel<Entity, i>{
    public void update(Entity object, i id);
}

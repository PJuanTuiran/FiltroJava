package org.filtro.persistence.imodels;

import org.filtro.entities.AvionEntity;
import org.filtro.persistence.CRUD.CreateModel;
import org.filtro.persistence.CRUD.DeleteModel;
import org.filtro.persistence.CRUD.ReadModel;
import org.filtro.persistence.CRUD.UpdateModel;

import javax.swing.text.html.parser.Entity;

public interface IAvionModel extends CreateModel<AvionEntity>, DeleteModel<String>, UpdateModel<AvionEntity, Integer >, ReadModel<AvionEntity, String> {
}

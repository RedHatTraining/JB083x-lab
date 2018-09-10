package com.redhat.training.ui;

import java.util.Set;
import java.util.function.Predicate;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.redhat.training.model.UserGroup;

@FacesConverter(value = "SelectItemToEntityConverter")
public class SelectItemConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent comp, String value) {
        Object o = null;
        if (!(value == null || value.isEmpty())) {
            o = this.getSelectedItemAsEntity(comp, value);
        }
        return o;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent comp, Object value) {
        String s = "";
        if (value != null) {
            s = ((UserGroup) value).getId().toString();
        }
        return s;
    }

    private UserGroup getSelectedItemAsEntity(UIComponent comp, String value) {
        UserGroup item = null;

        Set<UserGroup> selectItems = null;
        for (UIComponent uic : comp.getChildren()) {
            if (uic instanceof UISelectItems) {
                Long itemId = Long.valueOf(value);
                selectItems = (Set<UserGroup>) ((UISelectItems) uic).getValue();

                if (itemId != null && selectItems != null && !selectItems.isEmpty()) {
                    Predicate<UserGroup> predicate = i -> i.getId().equals(itemId);
                    item = selectItems.stream().filter(predicate).findFirst().orElse(null);
                }
            }
        }

        return item;
    }
}

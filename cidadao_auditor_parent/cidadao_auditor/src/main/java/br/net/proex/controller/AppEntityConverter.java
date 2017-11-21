package br.net.proex.controller;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.beanutils.PropertyUtils;

@FacesConverter(value = "entityConverter")
public class AppEntityConverter implements Converter {

	protected void addAttribute(UIComponent component, Object o, Long id) {
		String key = id.toString();
		this.getAttributesFrom(component).put(key, o);
	}

	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {

		if (value != null && !value.equals("[Selecione]")) {
			return this.getAttributesFrom(component).get(value);
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		try {
			if (value != null && !"".equals(value)) {

				Long id = (Long) PropertyUtils.getProperty(value, "id");

				// adiciona item como atributo do componente
				this.addAttribute(component, value, id);

				if (id != null) {
					return String.valueOf(id);
				}
			}
			return (String) value;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}

}

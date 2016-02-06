package com.oneapp.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerMailConfiguration {
	{

		try {

			Configuration cfg = new Configuration();
			Template template = cfg.getTemplate("template.ftl");
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", "Sarwesh");
			String output = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

package com.kjj.manage.util;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;

import com.google.common.io.Files;
import com.kjj.commserver.entity.special.OrgSpecial;

/**
 * @Title: GeneraterUtil.java
 * @Package com.kjj.manage.util
 * @Description: 
 * @author ZYLORG
 * @date 2016年7月7日 下午2:56:32
 * @copyright Beijing KJJ Electronic commerce Co., LTD
 * @version V1.0   
 */
public class GeneraterUtil {
	
	 //必须
	 String tableName="org_activity";
	 String controllerVm="src/main/resources/volicity/controller.vm";
	 String controllerDir="src/main/java/com/kjj/manage/web/controller";
	 
	 //不必须
	 String entityPosition="";  //实体类的位置eg：entityPosition="shop"; 默认根据表名新建
	 String servicesPosition=""; //services类的位置eg：servicesPosition="shop"; 默认根据表名新建
	 String folder=""; //是否在controller下新建一级文件夹
	 
	 
	 String prefix=tableName.substring(0,tableName.lastIndexOf("_")); 
	 String suffix=tableName.substring(tableName.lastIndexOf("_")+1);
	 String prefixUC = prefix.substring(0, 1).toUpperCase()+prefix.substring(1);
	 String suffixUC = suffix.substring(0, 1).toUpperCase()+suffix.substring(1);
	 
	
	@Test
	public  void testGene() {
		init();
		createController();
//		createJsp();
//		createjs();
	}
	
	
	private static void createJsp() {
		Field[] declaredFields = OrgSpecial.class.getDeclaredFields();
		List<String> thList=new ArrayList<String>();
		for (Field field : declaredFields) {
			thList.add(field.getName());
		}
	}
	
	private static void createjs() {
		
	}
	
	public void createController() {
		VelocityEngine ve = new VelocityEngine();
		ve.init();
		Template t = ve.getTemplate(controllerVm); 
		VelocityContext context = new VelocityContext();
		context.put("entityPosition", entityPosition); 
		context.put("servicesPosition", servicesPosition); 
		context.put("tb", prefix); 
		context.put("foo",suffix); 
		context.put("Tb", prefixUC); 
		context.put("Foo",suffixUC); 
		//为后面的展示，提前输入List数值 
		List<String> temp = new ArrayList<String>();
		temp.add("1"); 
		temp.add("2"); 
		context.put("list", temp); 
		StringWriter writer = new StringWriter();
		t.merge(context, writer); 
		File file=new File(controllerDir+"/"+suffix+"/"+suffixUC+"Controller.java");
		File parent = file.getParentFile();
	    if (parent != null) {
	       parent.mkdirs();
	    }
		try {
			Files.write(writer.toString().getBytes(), file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void init(){
		 if(entityPosition==""){
			 entityPosition=suffix;
		 }
		 if(servicesPosition==""){
			 servicesPosition=suffix;
		 }
		 if(folder==""){
			 folder=suffix;
		 }
	 }
}


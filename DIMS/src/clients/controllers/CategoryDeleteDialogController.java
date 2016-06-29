package clients.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.orsoncharts.util.json.JSONArray;
import com.orsoncharts.util.json.JSONObject;

import clients.customcontrols.CustomDialog;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.WindowEvent;

public class CategoryDeleteDialogController implements Initializable{

	private CustomDialog window;
	@FXML ComboBox<String> category_selector;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void setWindow(CustomDialog window)
	{
		this.window = window;
	}
	
	@SuppressWarnings("unchecked")
	public void setProperty(JSONArray property)
	{
		property.forEach((str)->{
			category_selector.getItems().add(str.toString());
		});
	}
	
	@SuppressWarnings("unchecked")
	@FXML private void onDeleteCategory()
	{
		if(category_selector.getValue()==null)
		{
			CustomDialog.showMessageDialog("������ ī�װ��� �����ϼ���.", window);
			return;
		}
		JSONObject uData = new JSONObject();
		uData.put("selected", category_selector.getValue());
		System.out.println("���̽� : "+uData.toJSONString());
		System.out.println("������ : "+window);
		window.setUserData(uData);
		window.close();
	}
	
}

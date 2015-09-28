package com.frosty.jfactionsheetmenu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.frosty.jfactionsheetmenu.JFActionSheetMenu.OnActionSheetItemClickListener;

public class MainActivity extends Activity implements OnActionSheetItemClickListener{

	private JFActionSheetMenu  menu = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//ȫ��
		setContentView(R.layout.activity_main);
	}
	
	/*����*/
	
	public void ActionBtn1(View view){
		showMenu(-1,false);//������Ϊios6���
	}

	public void ActionBtn2(View view){
		showMenu(8,false);//����Ϊios7���
	}

	
	//�Զ���
	public void ActionBtn3(View view){
		showMenu(0,true);//0��Ҫ�Զ�����ʽ
	}

	
	
	public void showMenu(int style,boolean isCuston){
		
		menu = new JFActionSheetMenu(this,style);//style<0:ios6��style>0:ios7
		
		menu.setUseCustonStyle(isCuston);
		
		/*�����ʹ���Զ��壨������menu.setUseCustonStyle(isCuston)���������ö�Ӧ�ı�������Ч
		 * �ұ�����ڴ�������ť֮ǰ
		 *ע�⣺�����ڴ����ж����Խ������ã���Ҫ�ڴ���item֮ǰʵ�֣���������setCancelButtonTextAndColor()��addItems��������֮ǰ
		 * */
		menu.setTitleBg(R.drawable.as_other_bt_bg);
		menu.setItemBg(R.drawable.btn_style_one_normal);
		menu.setCancelBg(R.drawable.as_cancel_bt_bg);
		if(isCuston){
			menu.setItemsTextClolor(Color.WHITE);
		}
		//����ȡ����ť
		menu.setCancelButtonTextAndColor("cancel",Color.RED);// ����itemǰ�����
		//���ñ��⣨����������ʾ���⣩
		if( style >= 0){
			menu.setTitleButtonTextAndColor("��ѡ����Ƭ", Color.BLUE);
		}
		
		//������item
		menu.addItems("����","ѡ����Ƭ","�����ȡ");
		
		
		//��item����
		menu.setItemClickListener(this);
		//ȡ����ť����
		menu.setCancelableOnTouchMenuOutside(true);
		//��ʾmenu
		menu.showMenu();

	}
	

	@Override
	public void onItemClick(View v,int itemPosition) {
		// TODO Auto-generated method stub
		Toast.makeText(this,"����˵�"+itemPosition+"����ť,������:"+((Button)v).getText() , Toast.LENGTH_SHORT).show();
	}


	@Override
	public void onCanceClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(this,"�����ȡ����ť,������:"+((Button)v).getText() , Toast.LENGTH_SHORT).show();
	}

}

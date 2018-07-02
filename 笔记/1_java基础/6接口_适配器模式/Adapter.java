class Adapter 
{
	public static void main(String[] args) 
	{
		Button b1=new Button();
		b1.addListener(new MouseAdapter(){
			public void onClick(){
				System.out.println("点击了1下");
			}

			public void onDbClick(){
				System.out.println("点击了2下");
			}

		})；
		b1.click();
		b1.dbclick();
	}
}

//按钮
class Button
{
	private MouseListener listener;

	public void addListener(MouseListener listener){
		this.listener=listener;
	}

	public void click(){
		listener.onClick();
	}

	public void dbClick(){
		listener.onDbClick();
	}
}

//鼠标监听器
interface MouseListener
{
	public void onClick();	// 单击事件
	public void onDbClick();// 双击事件
	public void rightClick();
	public void xxxClick();
}

abstract class MouseAdapter implements MouseListener
{
	public void rightClick(){
	}
	
	public void rightClick(){}
}
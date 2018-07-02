class InterfaceDemo 
{
	public static void main(String[] args) 
	{
		//System.out.println("Hello World!");
		WomenStar ws=new WomenStar();
		ws.white();

		TuHao tuhao =new TuHao();
		tuhao.marry
	}
}

//定义接口
interface White
{
	//白
	public void white();	//	没有函数体
}

interface Rich
{
	public void rich();
}

interface Beauty
{
	public void beauty();
}

//接口可以实现多继承
interface WRB extends White,Rich,Beauty
{
}

class WomenStar implements White,Rich
{
	public void white(){
		System.out.println("很白");
	}
	
	public void rich(){
		System.out.println("有钱");
	}

}
/* 接口可以多继承
class WomenStar implements WRB
{
	public void white(){
		System.out.println("很白");
	}
	
	public void rich(){
		System.out.println("有钱");
	}

	public void beauty(){
		System.out.println("漂亮");
	}
}*/

class TuHao
{
	//white是接口
	public void marry(White w){
		w.white();
	}
}

class KoreaMan implements White
{
	public void white(){
	public void white(){
		System.out.println("白面小生 ");
	}
	}
}